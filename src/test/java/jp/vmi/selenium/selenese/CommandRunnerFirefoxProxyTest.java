package jp.vmi.selenium.selenese;

import org.junit.Assume;
import org.junit.Before;

import jp.vmi.selenium.webdriver.DriverOptions;
import jp.vmi.selenium.webdriver.DriverOptions.DriverOption;
import jp.vmi.selenium.webdriver.BrowserNotFoundException;
import jp.vmi.selenium.webdriver.FirefoxDriverFactory;
import jp.vmi.selenium.webdriver.WebDriverFactory;

public class CommandRunnerFirefoxProxyTest extends CommandRunnerFirefoxTest {
    @Before
    public void checkProxy() {
        TestUtils.checkProxy();
    }

    @Before
    public void assumeInstalledFirefox() throws InvalidConfigurationException {
        try {
            FirefoxDriverFactory f = new FirefoxDriverFactory(new DriverOptions());
            f.initDriver();
        } catch (BrowserNotFoundException e) {
            Assume.assumeNoException(e);
        }
    }

    @Override
    protected WebDriverFactory getWebDriverFactory() throws InvalidConfigurationException {
        DriverOptions options = new DriverOptions();
        options.set(DriverOption.PROXY, "localhost:18080");
        return WebDriverFactory.getFactory(FirefoxDriverFactory.class, options);
    }
}