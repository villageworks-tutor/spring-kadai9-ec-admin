package com.example.demo.senario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.demo.entity.Item;

/**
 * 商品をカートに入れるシナリオ
 */
public class CartIn extends SenarioBase {
	
	// サンプル用商品IDリスト
	private static List<Item> items = new ArrayList<>();
	
	/**
	 * クラスの初期化：サンプル用商品リストを初期化する
	 */
	private static void init() {
		// 商品リストの設定
		items.add(new Item(1, 1, "Javaの基本", 2500));
		items.add(new Item(1, 1, "Javaの基本", 2500));
		items.add(new Item(5, 2, "The Racer", 1000));
		items.add(new Item(4, 2, "なつかしのアニメシリーズ", 2000));
	}
	
	/**
	 * 商品をカートに入れる
	 * @param driver webブラウザドライバ
	 * @throws InterruptedException 
	 */
	public static void execute(WebDriver driver) throws InterruptedException {
		// サンプル用顧客インスタンスの生成
		init();
		
		// 商品リストの各要素を走査して処理
		Iterator<Item> iterator = items.iterator();
		while (iterator.hasNext()) {
			// 商品を取得
			Item item = iterator.next();
			// カートに入れる
			addCart(driver, item.getId(), iterator.hasNext());
		}
	}
	
	/**
	 * 商品をカートに入れる
	 * @param driver webブラウザドライバ
	 * @param itemId カートに入れる商品の商品ID
	 * @param toBeContinued 買い物を続ける場合はtrue、それ以外はfalse
	 * @throws InterruptedException
	 */
	private static void addCart(WebDriver driver, Integer itemId, boolean toBeContinued) throws InterruptedException {
		// ［カートに入れる］ボタン押下
		driver.findElement(By.cssSelector("input[value='" + itemId + "']+button")).click();
		Thread.sleep(PAUSE_TIME_NORMAL);
		if (toBeContinued) {
			// 一覧に戻る
			driver.findElement(By.cssSelector("h1>a")).click();
		}
	}

}
