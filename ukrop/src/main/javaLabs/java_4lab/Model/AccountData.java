package java_4lab.Model;

import java_4lab.Helpers.LoginHelper;

public class AccountData {
    private LoginHelper loginHelper;

    public AccountData(LoginHelper loginHelper) {
        this.loginHelper = loginHelper;
    }

    public void login() {
        loginHelper.login();
    }
}