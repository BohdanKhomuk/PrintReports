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
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class  AutoTest   {

    private static EventFiringWebDriver eventDriver;
    private static Print print;
    private static VerificationStatus verStatus;
    private static Delete delete;
    private static FormationAndVerification formAndVer;
    private static final Logger LOG = LogManager.getLogger(EventHandler.class);

    @BeforeMethod
    public static void firstClass() {
        System.setProperty("java.net.preferIPv4Stack", "true");
        String browser = new File( AutoTest.class.getResource( "/IEDriverServer.exe" ).getFile()).getPath();
        System.setProperty("webdriver.ie.driver", browser);
        EventFiringWebDriver eventDriver = new EventFiringWebDriver( new InternetExplorerDriver() );

         /* String browser = new File(RegistrationCard_FO.class.getResource("/chromedriver.exe").getFile()).getPath();
        System.setProperty("webdriver.chrome.driver", browser);
        eventDriver = new EventFiringWebDriver(new ChromeDriver(  ));*/
        EventHandler handler = new EventHandler();
        eventDriver.manage().window().maximize();
        eventDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        eventDriver.register( handler );
        String polygonAddress = String.format( "http://10.10.17.%s:8080/barsroot/account/login/", LoginPage.getPolygon() );
        eventDriver.get( polygonAddress );
        //eventDriver.get( "http://10.10.10.198:11111/barsroot/" );

        LoginPage loginPage = new LoginPage( eventDriver );
        MainPage mainPage = new MainPage( eventDriver );
        print = new Print( eventDriver );
        verStatus = new VerificationStatus( eventDriver );
        delete = new Delete( eventDriver );
        formAndVer = new FormationAndVerification( eventDriver );


        System.out.println((char) 27 + "[33mБлок авторизації" + (char)27 + "[0m");
        loginPage.enterInMainPage( "absadm01", "qwerty" );
        System.out.println((char) 27 + "[33mДрук звітів" + (char)27 + "[0m");
        mainPage.enterFunction();

    }

    @Test
    public void testingPrintReports(){
        print.print();

        Assert.assertEquals( "Створено файл", verStatus.getStatusR1() );
        Assert.assertEquals( "Створено файл", verStatus.getStatusR2() );
        Assert.assertEquals( "Створено файл", verStatus.getStatusR4() );
        Assert.assertEquals( "Створено файл", verStatus.getStatusR3030() );
        Assert.assertEquals( "Створено файл", verStatus.getStatusR5502() );

        formAndVer.pressReports1();
        Assert.assertEquals( "Друк звіту - № 1 (1.Бранч: Зведення док.дня - ТИТУЛ)", formAndVer.getTextTitle() );
        formAndVer.pressBtBack();

        formAndVer.pressReports2();
        Assert.assertEquals( "Друк звіту - № 2 (2.Бранч: Зведення документiв дня - РЕЄСТР проводок по папкам)", formAndVer.getTextTitle() );
        formAndVer.pressBtBack();

        formAndVer.pressReports4();
        Assert.assertEquals( "Друк звіту - № 4 (4.МФО: Зведення документiв дня - ТИТУЛИ ( Бранчi+ , Папки))", formAndVer.getTextTitle() );
        formAndVer.pressBtBack();

        formAndVer.pressReports3030();
        Assert.assertEquals( "Друк звіту - № 3030 (Виконання автоматичних операцій)", formAndVer.getTextTitle() );
        formAndVer.pressBtBack();

        formAndVer.pressReports5502();
        Assert.assertEquals( "Друк звіту - № 5502 (Звіт для контролю файлів стат звітності по валютних операціях)", formAndVer.getTextTitle() );
        formAndVer.pressBtBack();

        delete.deleteReports();
    }

    @AfterMethod
    public static void tearDown() {
        eventDriver.quit();
    }

}
