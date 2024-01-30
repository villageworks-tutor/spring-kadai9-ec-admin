package com.example.demo.senario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * ログインシナリオ
 */
public class Login extends SenarioBase {
	/**
	 * ログインする
	 * @param driver webブラウザドライバ
	 * @throws InterruptedException 
	 */
	public static void execute(WebDriver driver) throws InterruptedException {
		// メールアドレス入力
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("tanaka@aaa.com");
		// パスワード入力
		driver.findElement(By.cssSelector("input[name='password'")).sendKeys("himitu");
		// ［ログイン］ボタン押下：商品一覧画面表示
		driver.findElement(By.cssSelector("button")).click();
		// 目視確認用の一時停止
		Thread.sleep(PAUSE_TIME_MIDLE);
	}
}
