package com.example.demo.senario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 注文シナリオ
 */
public class OrderItem extends SenarioBase {

	/**
	 * 注文する
	 * @param driver webブラウザドライバ
	 * @throws InterruptedException 
	 */
	public static void execute(WebDriver driver) throws InterruptedException {
		// ［注文する］ボタン押下：顧客情報入力画面表示
		driver.findElement(By.cssSelector("form[action='/order'] button")).click();
		// 処理確認用の一時停止
		Thread.sleep(PAUSE_TIME_NORMAL);
		// ［確認画面へ］ボタン押下：顧客情報確認画面表示
		driver.findElement(By.cssSelector("form[action='/order/confirm'] button")).click();
		// 処理確認用の一時停止
		Thread.sleep(PAUSE_TIME_NORMAL);
		// ［この内容で注文］ボタン押下：注文完了画面表示
		driver.findElement(By.cssSelector("form[action='/order'] button")).click();
		// 処理確認用の一時停止
		Thread.sleep(PAUSE_TIME_NORMAL);
	}

}
