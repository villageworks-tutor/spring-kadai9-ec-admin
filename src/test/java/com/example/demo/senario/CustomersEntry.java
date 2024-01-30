package com.example.demo.senario;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.demo.entry.CustomerEx;

/**
 * 顧客登録シナリオ
 */
public class CustomersEntry extends SenarioBase {
	
	// サンプル用顧客リスト
	private static List<CustomerEx> customers = new ArrayList<>();
	
	/**
	 * 顧客を登録する
	 * @param driver webブラウザドライバ
	 * @throws InterruptedException 
	 */
	public static void execute(WebDriver driver) throws InterruptedException {
			
		// サンプル用顧客インスタンスの生成
		init();
		
		// 顧客リストの各要素を走査して処理
		for (CustomerEx customer : customers) {
			// 新規登録のリンクをクリック
			driver.findElement(By.cssSelector("a[href='/account']")).click();
			// 登録の実行
			input(driver, customer);
			// 処理確認用の一時停止
			Thread.sleep(PAUSE_TIME_NORMAL);
			// ［登録］ボタン押下：ログイン画面に遷移
			driver.findElement(By.cssSelector("button")).click();
			// 処理確認用の一時停止
			Thread.sleep(PAUSE_TIME_NORMAL);
		}
			
	}
	
	/**
	 * クラスの初期化：サンプル用顧客リストを初期化する
	 */
	private static void init() {
		// 顧客サンプルの設定
		customers.add(new CustomerEx("田中太郎", "東京都新宿区", "090-1111-1111", "tanaka@aaa.com", "himitu"));
		customers.add(new CustomerEx("鈴木一郎", "大阪府大阪市", "090-2222-2222", "suzuki@aaa.com", "himitu"));
	}

	/**
	 * 登録画面の入力部品に登録内容を入力する
	 * @param driver   webブラウザドライバ
	 * @param customer 登録対象の顧客インスタンス
	 */
	private static void input(WebDriver driver, CustomerEx customer) {
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys(customer.getName());
		driver.findElement(By.cssSelector("input[name='address']")).sendKeys(customer.getAddress());
		driver.findElement(By.cssSelector("input[name='tel']")).sendKeys(customer.getTel());
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys(customer.getEmail());
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(customer.getPassword());
	}
	
}
