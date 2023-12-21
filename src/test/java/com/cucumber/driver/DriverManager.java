package com.cucumber.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class DriverManager {


    /**
     * Этот Java-класс представляет собой реализацию паттерна "Thread-Local Singleton"
     * для управления экземпляром веб-драйвера (WebDriver) в многопоточной среде, как, например,
     * при автоматизации тестирования веб-приложений.
     */


    /**
     * Здесь создается ThreadLocal переменная, которая обеспечивает каждому потоку свой экземпляр WebDriver.
     * Это важно, когда тесты запускаются параллельно в нескольких потоках.
     */
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();



    public DriverManager() {
    }
    /**
     *  setupDriver - метод устанавливает и настраивает веб-драйвер (ChromeDriver в данном случае).
     *  Он использует WebDriverManager для управления версиями драйвера и создает новый экземпляр ChromeDriver.
     *  После этого устанавливаются неявные ожидания (implicit wait) для драйвера на 15 секунд, что означает,
     *  что драйвер будет ждать до 15 секунд, прежде чем выбросить исключение, если элемент не будет найден.
     */
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        webDriverThreadLocal.set(driver);
    }

    /**
     * getWebDriver - метод возвращает экземпляр веб-драйвера, связанный с текущим потоком.
     * При вызове этого метода из разных потоков, каждый поток получит свой уникальный экземпляр веб-драйвера.
     */
    public static WebDriver getWebDriver() {
        return webDriverThreadLocal.get();
    }


    /**
     * Этот метод закрывает браузер, если он был инициализирован.
     * Используется Optional для безопасного вызова метода quit() у объекта WebDriver,
     * чтобы избежать возможного NullPointerException.
     */
    public static void quitDriver() {
        Optional.ofNullable(getWebDriver()).ifPresent(WebDriver::quit);
    }
}
