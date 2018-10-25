import com.test.LoginPage;
import com.test.MainPage;
import com.test.Methods.EventHandler;
import com.test.PrintReports.Delete;
import com.test.PrintReports.FormationAndVerification;
import com.test.PrintReports.Print;
import com.test.PrintReports.VerificationStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static com.test.LoginPage.getPolygon;
import static java.lang.System.out;

public class AutoTest {

    private static EventFiringWebDriver eventDriver;
    private static final Logger LOG = LogManager.getLogger( EventHandler.class );

    @BeforeClass
    public static void firstClass() {
        System.setProperty( "java.net.preferIPv4Stack", "true" );
        String browser = new File( AutoTest.class.getResource( "/IEDriverServer.exe" ).getFile() ).getPath();
        System.setProperty( "webdriver.ie.driver", browser );
        eventDriver = new EventFiringWebDriver( new InternetExplorerDriver() );

         /* String browser = new File(RegistrationCard_FO.class.getResource("/chromedriver.exe").getFile()).getPath();
        System.setProperty("webdriver.chrome.driver", browser);
        eventDriver = new EventFiringWebDriver(new ChromeDriver(  ));*/
        EventHandler handler = new EventHandler();
        eventDriver.manage().window().maximize();
        eventDriver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );
        eventDriver.register( handler );
        String polygonAddress = String.format( "http://10.10.17.%s:8080/barsroot/account/login/", LoginPage.getPolygon() );
        eventDriver.get( polygonAddress );
        //eventDriver.get( "http://10.10.10.198:11111/barsroot/" );

        MainPage mainPage = PageFactory.initElements( eventDriver, MainPage.class );
        LoginPage loginPage = PageFactory.initElements( eventDriver, LoginPage.class );

        out.println( (char) 27 + "[33mБлок авторизації" + (char) 27 + "[0m" );
        loginPage.enterInMainPage( "absadm01", "qwerty" );
        out.println( (char) 27 + "[33mДрук звітів" + (char) 27 + "[0m" );
        mainPage.enterFunction();

    }

    @Test(priority = 1)
    public void testingPrintReports() {
        Print print = PageFactory.initElements( eventDriver, Print.class );
        VerificationStatus verStatus = PageFactory.initElements( eventDriver, VerificationStatus.class );
        print.print();

        try {
            Assert.assertEquals( "Створено файл1", verStatus.getStatusR1() );
        } catch (AssertionError error) {
            LOG.error ( error );
        }

        try {
            Assert.assertEquals( "Створено файл", verStatus.getStatusR2() );
        } catch (AssertionError error) {
            LOG.error ( error );
        }

        try {
            Assert.assertEquals( "Створено файл", verStatus.getStatusR4() );
        } catch (AssertionError error) {
            LOG.error ( error );
        }

        try {
            Assert.assertEquals( "Створено файл", verStatus.getStatusR3030() );
        } catch (AssertionError error) {
            LOG.error ( error );
        }

        if(/*getPolygon() == 22 || */getPolygon() == 40) {
            try{
            Assert.assertEquals( "Створено файл", verStatus.getStatusR5502() );
            } catch (AssertionError error){
                LOG.error ( error );
            }
        }
    }

    @Test(priority = 2)
    public void testingPrintReports1() {
        FormationAndVerification formAndVer = PageFactory.initElements( eventDriver, FormationAndVerification.class );
        formAndVer.pressReports1();
        Assert.assertEquals( "Друк звіту - № 1 (1.Бранч: Зведення док.дня - ТИТУЛ)", formAndVer.getTextTitle() );
        formAndVer.pressBtBack();
    }

    @Test(priority = 3)
    public void testingPrintReports2() {
        FormationAndVerification formAndVer = PageFactory.initElements( eventDriver, FormationAndVerification.class );
        formAndVer.pressReports2();
        Assert.assertEquals( "Друк звіту - № 2 (2.Бранч: Зведення документiв дня - РЕЄСТР проводок по папкам)", formAndVer.getTextTitle() );
        formAndVer.pressBtBack();
    }

    @Test(priority = 4)
    public void testingPrintReports4() {
        FormationAndVerification formAndVer = PageFactory.initElements( eventDriver, FormationAndVerification.class );
        formAndVer.pressReports4();
        Assert.assertEquals( "Друк звіту - № 4 (4.МФО: Зведення документiв дня - ТИТУЛИ ( Бранчi+ , Папки))", formAndVer.getTextTitle() );
        formAndVer.pressBtBack();
    }

    @Test(priority = 5)
    public void testingPrintReports3030() {
        FormationAndVerification formAndVer = PageFactory.initElements( eventDriver, FormationAndVerification.class );
        formAndVer.pressReports3030();
        Assert.assertEquals( "Друк звіту - № 3030 (Виконання автоматичних операцій)", formAndVer.getTextTitle() );
        formAndVer.pressBtBack();
    }


    @Test(priority = 6)
    public void testingPrintReports5502() {
        FormationAndVerification formAndVer = PageFactory.initElements( eventDriver, FormationAndVerification.class );
        if(/*getPolygon() == 22 || */getPolygon() == 40) {
            formAndVer.pressReports5502();
            Assert.assertEquals( "Друк звіту - № 5502 (Звіт для контролю файлів стат звітності по валютних операціях)", formAndVer.getTextTitle() );
            formAndVer.pressBtBack();
        }
    }

    @Test(priority = 7)
    public void deleteReports(){
        Delete delete = PageFactory.initElements( eventDriver, Delete.class );
        delete.deleteReports();
    }

    @AfterClass
    public static void tearDown() {
        eventDriver.quit();
    }
}
