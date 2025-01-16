import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppTest {

    static AppiumDriver driver;

    public static void main(String[] args) throws MalformedURLException {
        openMobileApp();
    }

    public static void openMobileApp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "redmi");
        cap.setCapability("udid", "1ae4bff7");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11");
        cap.setCapability("appPackage", "com.cuidadelivery");
        cap.setCapability("appActivity", "com.cuidadelivery.MainActivity");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("noReset", false);
        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url, cap);

        System.out.println("Inicia conexión");

        // Primer clic
        driver.findElement(By.xpath("//android.widget.TextView[@text='Dar acceso a ubicación']")).click();
        System.out.println("Click de Acceso a ubicación");

        // Esperar a que el próximo botón esté visible o interactuable después del clic
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera de 10 segundos
        WebElement enabledButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))
        );

        System.out.println("Click de Acceso a ubicación Flotante Android");

        // Accionar el botón
        enabledButton.click();
            System.out.println("Permiso concedido");





            WebDriverWait SegundaEspera = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement enabledButton2 = SegundaEspera.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"Correo, Contraseña\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.EditText"))
            );

        //Click para pontero en campo correo
        enabledButton2.click();

        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Correo, Contraseña\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.EditText")).sendKeys("danny.escalante@cuida.pe");
        System.out.println("Correo ingresado");

        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Correo, Contraseña\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.EditText")).sendKeys("danny.escalante");
        System.out.println("Contraseña ingresada");

        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Iniciar sesión\"]")).click();
        System.out.println("Click en login");



    }
}