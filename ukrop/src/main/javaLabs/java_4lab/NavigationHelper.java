package java_4lab;

public class NavigationHelper extends HelperBase {
    private String baseURL;

    public NavigationHelper(ApplicationManager app, String baseURL) {
        super(app);
        this.baseURL = baseURL;
    }

    public void openHomePage() {
        driver.get(baseURL);
    }
}
