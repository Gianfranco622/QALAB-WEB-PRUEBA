package com.nttdata.page;

import org.openqa.selenium.By;

public class HomePage {

    //Localizadores de elementos
    public static By userName = By.xpath("//body/div[@id='body-cuenta']/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/p[1]");
    public static By menuOfertas = By.xpath("//header/div[2]/nav[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[7]/h2[1]/a[1]");
    public static By itemOfertasCalzado = By.xpath("//body/div[@id='body-Ofertas']/div[4]/div[1]/div[2]");
    public static By itemCalzado = By.xpath("//body/div[@id='body-productos']/div[4]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]");
    public static By agregarCarrito = By.xpath("//button[@id='btn_add_cart_full']");
    public static By carrito = By.xpath("//a[@id='IconCar']");
    public static By productName = By.xpath("//p[contains(text(),'Sandalias Dama Sb 0724')]");


}
