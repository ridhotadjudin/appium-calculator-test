package com.nexsoft.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CalculatorFunctionTest {

	public AndroidDriver driver;
	public Hashtable<String, WebElement> keys;
	
	public CalculatorFunctionTest(AndroidDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		mapping();
		
	}
	
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_1" )
	public WebElement btn1;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_2" )
	public WebElement btn2;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_3" )
	public WebElement btn3;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_4" )
	public WebElement btn4;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_5" )
	public WebElement btn5;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_6" )
	public WebElement btn6;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_7" )
	public WebElement btn7;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_8" )
	public WebElement btn8;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_9" )
	public WebElement btn9;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_0" )
	public WebElement btn0;
	
	@AndroidFindBy(id = "com.google.android.calculator:id/op_add" )
	public WebElement btnAdd;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_sub" )
	public WebElement btnSub;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_mul" )
	public WebElement btnMul;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_div" )
	public WebElement btnDiv;
	@AndroidFindBy(id = "com.google.android.calculator:id/eq")
	public WebElement btnEq;
	
	@AndroidFindBy(id="com.google.android.calculator:id/result_final")
	public WebElement result;
	
	public void mapping() {
		keys = new Hashtable<String, WebElement>();
		keys.put("0", btn0);
		keys.put("1", btn1);
		keys.put("2", btn2);
		keys.put("3", btn3);
		keys.put("4", btn4);
		keys.put("5", btn5);
		keys.put("6", btn6);
		keys.put("7", btn7);
		keys.put("8", btn8);
		keys.put("9", btn9);
		keys.put("+", btnAdd);
		keys.put("/", btnDiv);
		keys.put("-", btnSub);
		keys.put("*", btnMul);
		keys.put("=", btnEq);
		keys.put("result", result);
	}
	
	public void tambah(int a, int b) {
		String expectedResult = String.valueOf(a + b);
		keys.get(String.valueOf(a)).click();
		keys.get("+").click();
		keys.get(String.valueOf(b)).click();
		keys.get("=").click();
		String hasil = keys.get("result").getText();

		assertEquals(hasil, expectedResult);
	}

	public void kurang(int a, int b) {
		String expectedResult = String.valueOf(a - b);
		keys.get(String.valueOf(a)).click();
		keys.get("-").click();
		keys.get(String.valueOf(b)).click();
		keys.get("=").click();
		String hasil = keys.get("result").getText();

		assertEquals(hasil, expectedResult);
	}

	public void kali(int a, int b) {
		String expectedResult = String.valueOf(a * b);
		keys.get(String.valueOf(a)).click();
		keys.get("*").click();
		keys.get(String.valueOf(b)).click();
		keys.get("=").click();
		String hasil = keys.get("result").getText();

		assertEquals(hasil, expectedResult);
	}

	public void bagi(int a, int b) {
		String expectedResult = String.valueOf(a / b);
		keys.get(String.valueOf(a)).click();
		keys.get("/").click();
		keys.get(String.valueOf(b)).click();
		keys.get("=").click();
		String hasil = keys.get("result").getText();

		assertEquals(hasil, expectedResult);
	}
	
}