package PAGE;

import Keywords.KeywordsWeb;
import org.openqa.selenium.WebDriver;

public class PimPage extends KeywordsWeb {

    String btnPim = "xpath://span[text()='PIM']";
    String btnAdd = "xpath://button[text()=' Add ']";
    String inputFirstName = "xpath://input[@name='firstName']";
    String inputMiddleName = "xpath://input[@name='middleName']";
    String inputLastName = "xpath://input[@name='lastName']";
    String btnSubmit = "xpath://button[@type='submit']";
    String inputID= "xpath://label[text()='Employee Id']/../../div[2]/input";
    String inputNameSearch="xpath://input[@placeholder='Type for hints...']";
    String btnSearch = "xpath://button[text()=' Search ']";


    public PimPage(WebDriver driver) {
        super(driver);
    }

    public void ingresarPim() throws InterruptedException {
        click(btnPim);
        esperar(5);
    }
    public void registrarEmpleado(String firstname,String middlename,String lastname) throws InterruptedException {
        click(btnAdd);
        esperar(5);
        type(firstname,inputFirstName);
        type(middlename,inputMiddleName);
        type(lastname,inputLastName);
        clear(inputID);
        click(btnSubmit);
        esperar(10);
    }

    public void consultarEmpleado(String nombreEmpleado){
        String txtName= "xpath://div[contains(text(), '"+nombreEmpleado+"')]";
        type(nombreEmpleado,inputNameSearch);
        click(btnSearch);
        esperar(5);
        isDisplayed(txtName);
    }
}
