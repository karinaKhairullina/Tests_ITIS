package java_4lab;

public class AccountData {
    private LoginHelper loginHelper;

    public AccountData(LoginHelper loginHelper) {
        this.loginHelper = loginHelper;
    }

    public void login() {

        loginHelper.login();
    }
}