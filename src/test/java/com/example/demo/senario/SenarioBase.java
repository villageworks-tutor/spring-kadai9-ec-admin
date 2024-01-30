package com.example.demo.senario;

import org.openqa.selenium.WebDriver;

/**
 * すべてのシナリオクラスが継承する抽象クラス
 */
public class SenarioBase {

	/**
	 * 一時停止時間定数
	 */
	public static int PAUSE_TIME_SHORT = 500;
	public static int PAUSE_TIME_MIDLE = 1000;
	public static int PAUSE_TIME_NORMAL = 1500;
	public static int PAUSE_TIME_LONG = 2000;
	
	/**
	 * 実行する
	 * @param driver webブラウザドライバ
	 * @throws InterruptedException
	 */
	public static void execute(WebDriver driver) throws InterruptedException {
		
	}
	
}
