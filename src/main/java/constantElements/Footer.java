package constantElements;

import org.openqa.selenium.WebDriver;
import technical.BasePage;

/**
 * Created by alex on 31.03.2017.
 */
public class Footer extends BasePage {

    public Footer (WebDriver driver) {
        super(driver);
    }

    //FOOTER
    //Headers
    private String INFO = ".col-sm-2:nth-child(1):first-child h4";
    private String EXTRAS = ".col-sm-2:nth-child(2) h4";
    private String MY_ACCOUNT = ".col-sm-2:nth-child(3) h4";
    // TODO: 21.02.2017 Разобраться с локаторами / попросить команду изменить ихменить их
    //private String COMPANY_INFO = "";
    // private String CONTACT_US = "";
}

