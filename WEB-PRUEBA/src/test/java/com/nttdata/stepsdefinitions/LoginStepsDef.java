package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.PrincipalPlatanitosSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepsDef {

    private WebDriver driver;
    private Scenario scenario;
    private PrincipalPlatanitosSteps objPrincipal;
    private LoginSteps objLoginSteps;

    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

    @Dado("que me encuentro en la página principal de platanitos")
    public void queMeEncuentroEnLaPáginaDeLoginDeTestQALAB() {
        driver.get("https://platanitos.com/");
        screenShot();
    }

    @Cuando("hago clic en Cuenta")
    public void hagoClicEnCuentaYEnIniciarSesion() {
        objPrincipal = new PrincipalPlatanitosSteps(driver);

        objPrincipal.seleccionarMenuCuenta();
        screenShot();
    }

    @Y("inicio sesión con las credenciales usuario: {string} y contraseña: {string}")
    public void inicioSesiónConLasCredencialesUsuarioYContraseña(String user, String password) {
        objLoginSteps = new LoginSteps(driver);

        objLoginSteps.typeUser(user);
        objLoginSteps.typePassword(password);
        objLoginSteps.login();
        screenShot();
    }

    @Entonces("valido que deberia aparecer el nombre de usuario {string}")
    public void validoQueDeberiaAparecerElNombreDeUsuario(String expectedUserName) {
        String userName = objPrincipal.getTitle();
        Assertions.assertEquals(expectedUserName, userName);
        screenShot();
    }

    @Y("hago clic en el menu de Ofertas")
    public void hagoClicEnElMenuDeOfertas() {
        objPrincipal.seleccionarOfertas();
        screenShot();
    }

    @Y("doy clic en la ofertas calzado y selecciono la primera opcion")
    public void doyClicEnLaOfertasCalzadoYSeleccionoLaPrimeraOpcion() {
        objPrincipal.seleccionarCalzado();
        screenShot();
        objPrincipal.seleccionarItemCalzado();
        screenShot();
    }

    @Y("doy clic en agregar al carrito")
    public void doyClicEnAgregarAlCarrito() {
        objPrincipal.agregarAlCarrito();
        screenShot();
    }

    @Cuando("doy clic en el menu de carrito de compras")
    public void doyClicEnElMenuDeCarritoDeCompras() {
        objPrincipal.carritoCompras();
        screenShot();
    }

    @Entonces("valido que deberia aparecer el producto con nombre {string} en el carrito")
    public void validoQueDeberiaAparecerElProductoConNombreEnElCarrito(String expectedProductName) {
        String productName = objPrincipal.getProductName();
        Assertions.assertEquals(expectedProductName, productName);
    }

}
