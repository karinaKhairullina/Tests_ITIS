package java_5lab.Model;
import java_5lab.Helpers.LoginHelper;

public class AccountData {
    private LoginHelper loginHelper;

    public AccountData(LoginHelper loginHelper) {
        this.loginHelper = loginHelper;
    }

    public void login() {
        loginHelper.login();
    }
}