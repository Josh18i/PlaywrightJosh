package StepsDefinitions;

import PAGE.LoginPage;
import PAGE.PimPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepsDefinitions {

    private WebDriver driver;
    private LoginPage loginPage;
    private PimPage pimPage;
    private String nombre;


    public StepsDefinitions() {
        this.driver = Hooks.driver;
        loginPage = new LoginPage(driver);
        pimPage = new PimPage(driver);
    }

    @Given("^El usuario ha ingresado el nombre de usuario \"([^\"]*)\" y la contraseña \"([^\"]*)\" correctos$")
    public void ingresarUsuarioYContrasena(String usuario, String contrasena) {
        loginPage.ingresarDatos(usuario, contrasena);
    }

    @When("el usuario inicie sesión")
    public void iniciarSesion() throws InterruptedException {
        loginPage.iniciarSesion();
    }

    @Then("se debe mostrar el menú principal del sistema")
    public void mostrarMenuPrincipal() {
        loginPage.mostrarMenu();
    }

    @Given("^El usuario \"([^\"]*)\" \"([^\"]*)\" ha iniciado sesión exitosamente$")
    public void iniciarSesion(String usuario, String contrasena) throws InterruptedException {
        loginPage.ingresarDatos(usuario, contrasena);
        loginPage.iniciarSesion();
    }

    @Given("^accede al módulo PIM$")
    public void accederModuloPIM() throws InterruptedException {
        pimPage.ingresarPim();
    }

    @When("^se completan y envían los datos del nuevo empleado \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void completarDatosEmpleado(String name,String middlename,String lastname) throws InterruptedException {
        this.nombre = name;
        pimPage.registrarEmpleado(name,middlename,lastname);
    }

    @Then("^el sistema debe mostrar al empleado registrado correctamente$")
    public void mostrarEmpleadoRegistrado() throws InterruptedException {
        pimPage.ingresarPim();
        pimPage.consultarEmpleado(nombre);
    }

}
