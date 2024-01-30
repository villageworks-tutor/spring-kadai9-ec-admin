package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.demo.senario.CartIn;
import com.example.demo.senario.CustomersEntry;
import com.example.demo.senario.Login;
import com.example.demo.senario.OrderItem;

public class SenarioTest {

	/**
	 * クラス定数
	 * TARGET_SYSTEM_LOGIN_URL：対象システムのログインURL
	 */
	private static final String TARGET_SYSTEM_LOGIN_URL = "http://localhost:8080/";
	private static final WebDriver CHROME_DRIVER = new ChromeDriver();
	
	/**
	 * クラスフィールド：Selenium用Webブラウザドライバ
	 */
	private static WebDriver driver = CHROME_DRIVER;
	
	/**
	 * シナリオを実行する
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) {
		
		try {
			
			// 初期化処理
			init();
			
			// 顧客の新規登録
			CustomersEntry.execute(driver);
			
			// ログイン
			Login.execute(driver);
			// 商品をカートに入れる
			CartIn.execute(driver);
			// 注文する
			OrderItem.execute(driver);
			
			// 処理の終了
			quit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 処理の初期化：webブラウザドライバの読み込んでインスタンス化する
	 */
	private static void init() {
		// chromedriverの設定
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		// WebDriverをインスタンス化
		driver.get(TARGET_SYSTEM_LOGIN_URL);
	}
	
	/**
	 * 処理を終了する
	 */
	private static void quit() {
		driver.quit();
	}

}
