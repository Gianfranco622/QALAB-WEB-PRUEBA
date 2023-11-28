package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {

    //Localizadores de elementos
    public static By menuCuenta = By.xpath("//a[@id='IconAccount']");
    public static By userInput = By.xpath("//input[@id='email']");
    public static By passInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//button[@id='btn_submit']");

}
