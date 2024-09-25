package Runners;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.microsoft.playwright.Playwright;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/"},
        tags = "@Login",
        glue = "StepsDefinitions",
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RunnersTags {
    private static Playwright playwright;

    @BeforeClass
    public static void setUp() {
        playwright = Playwright.create();
    }

    @AfterClass
    public static void tearDown() {
        if (playwright != null) {
            playwright.close();
        }
    }

    public static Playwright getPlaywright() {
        return playwright;
    }
}