package com.nttdata.steps;

import com.nttdata.page.HomePage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PrincipalPlatanitosSteps {
    private WebDriver driver;
    public PrincipalPlatanitosSteps(WebDriver driver){
        this.driver = driver;
    }

    public void esperaElemento(By by){
        //Esperar hasta que el elemento exista
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void seleccionarMenuCuenta() {
        esperaElemento(LoginPage.menuCuenta);

        WebElement menuCuenta = driver.findElement(LoginPage.menuCuenta);
        menuCuenta.click();

    }

    public String getTitle() {
        return this.driver.findElement(HomePage.userName).getText();
    }

    public void seleccionarOfertas() {
        WebElement menuOfertas = driver.findElement(HomePage.menuOfertas);
        menuOfertas.click();
    }

    public void seleccionarCalzado() {
        WebElement ofertasCalzado = driver.findElement(HomePage.itemOfertasCalzado);
        ofertasCalzado.click();
    }

    public void seleccionarItemCalzado() {
        WebElement itemCalzado = driver.findElement(HomePage.itemCalzado);
        itemCalzado.click();
    }

    public void agregarAlCarrito() {
        WebElement agregarCarrito = driver.findElement(HomePage.agregarCarrito);
        agregarCarrito.click();
    }

    public void carritoCompras() {
        WebElement carritoCompras = driver.findElement(HomePage.carrito);
        carritoCompras.click();
        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }
    }

    public String getProductName() {
        return this.driver.findElement(HomePage.productName).getText();
    }
}
