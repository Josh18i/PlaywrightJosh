package PAGE;

import Keywords.KeywordsWeb;
import org.openqa.selenium.WebDriver;

public class LoginPage extends KeywordsWeb {
    String inputUsername = "xpath://input[@placeholder='Username']";
    String inputPassword = "xpath://input[@placeholder='Password']";
    String btnLogin = "xpath://button[@type='submit']";
    String lblDashboard = "xpath://h6[text()='Dashboard']";
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void ingresarDatos(String username, String password) {
        click(inputUsername);
        type(username, inputUsername);
        click(inputPassword);
        type(password, inputPassword);
    }
    public void iniciarSesion() throws InterruptedException {
        click(btnLogin);
        esperar(5);
    }

    public boolean mostrarMenu(){
        return isDisplayed(lblDashboard);
    }

}
