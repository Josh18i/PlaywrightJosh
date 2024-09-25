package Keywords;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.apache.logging.log4j.LogManager;

import static org.junit.Assert.assertTrue;

public class KeywordsWeb {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(KeywordsWeb.class);

    public KeywordsWeb(WebDriver driver) {

        this.driver = driver;

    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public By locator(String varLocator) {
        By byLocator;
        String[] part = varLocator.split(":", 2);
        String valor = part[0];
        int tipo = (valor.equals("id")) ? 1 : (valor.equals("name")) ? 2 : (valor.equals("className")) ? 3 : (valor.equals("tagName")) ? 4 : (valor.equals("linkText")) ? 5 : (valor.equals("partialLinkText")) ? 6 : (valor.equals("cssSelector")) ? 7 : (valor.equals("xpath")) ? 8 : 0;

        switch (tipo) {
            case 1:
                byLocator = By.id(part[1]);
                break;
            case 2:
                byLocator = By.name(part[1]);
                break;
            case 3:
                byLocator = By.className(part[1]);
                break;
            case 4:
                byLocator = By.tagName(part[1]);
                break;
            case 5:
                byLocator = By.linkText(part[1]);
                break;
            case 6:
                byLocator = By.partialLinkText(part[1]);
                break;
            case 7:
                byLocator = By.cssSelector(part[1]);
                break;
            case 8:
                byLocator = By.xpath(part[1]);
                break;
            default:
                byLocator = By.id(part[1]);
                break;
        }

        return byLocator;
    }


    public void type(String nameInput, String stringlocator) {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        String clase = elements[2].getClassName();
        String metodo = elements[2].getMethodName();
        logger.info("Clase -> {} , -> Metodo {} y accion -> type", clase, metodo);

        try {
            driver.findElement(locator(stringlocator)).sendKeys(nameInput);
        } catch (Exception e) {
            logger.error(e.getMessage());
            assertTrue("Error en Locator " + stringlocator, false);
        }

    }

    public void click(String varLocator) {
        waitLoaderClickable(varLocator, 20);
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        String clase = elements[2].getClassName();
        String metodo = elements[2].getMethodName();
        logger.info("Clase -> {} , -> Metodo {} y accion -> click", clase, metodo);

        try {
            driver.findElement(locator(varLocator)).click();
        } catch (Exception e) {
            logger.error(e.getMessage());
            assertTrue("Error en Locator " + varLocator, false);
        }

    }

    public String findElement_getText(String varLocator) {
        String getText = "";
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        String clase = elements[2].getClassName();
        String metodo = elements[2].getMethodName();

        logger.info("Clase -> {} , -> Metodo {} y accion -> findElement_getText", clase, metodo);

        try {
            getText = driver.findElement(locator(varLocator)).getText();
        } catch (Exception e) {
            logger.error(e.getMessage());
            assertTrue("Error en Locator " + varLocator, false);
        }

        return getText;
    }

    public void waitLoaderClickable(String varLocator, int timeOut) {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        String clase = elements[2].getClassName();
        String metodo = elements[2].getMethodName();
        logger.info("Clase -> {} , -> Metodo {} y accion -> waitLoaderClickable", clase, metodo);

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(findElement(locator(varLocator))));
        } catch (Exception e) {
            logger.error(e.getMessage());
            assertTrue("Error en Locator " + varLocator, false);
        }

    }

    public Boolean isDisplayed(String varLocator)
    {
        Boolean isDisplayed = false;
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        String clase = elements[2].getClassName();
        String metodo = elements[2].getMethodName();
        logger.info("Clase -> {} , -> Metodo {} y accion -> isDisplayed",clase,metodo);

        try {
            isDisplayed = driver.findElement(locator(varLocator)).isDisplayed();
        }catch (Exception e)
        {
            logger.error(e.getMessage());
            assertTrue("Error en Locator "+varLocator,false);
        }return isDisplayed;
    }

    public static void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error al esperar", e);
        }
    }

    public void clear(String varLocator)
    {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        String clase = elements[2].getClassName();
        String metodo = elements[2].getMethodName();
        logger.info("Clase -> {} , -> Metodo {} y accion -> clear",clase,metodo);

        try {
            driver.findElement(locator(varLocator)).clear();
        }catch (Exception e)
        {
            logger.error(e.getMessage());
            assertTrue("Error en Locator "+varLocator,false);
        }

    }
}