package java_3lab;

import org.openqa.selenium.WebDriver;

public class AccountData {
    private LoginHelper loginHelper;

    public AccountData(LoginHelper loginHelper) {
        this.loginHelper = loginHelper;
    }

    public void login() {
        loginHelper.login();
    }
}