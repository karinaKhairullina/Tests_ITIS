package java_3lab;

import org.junit.BeforeClass;

public class TestBase {
    protected static ApplicationManager app;

    @BeforeClass
    public static void setUp() {
        if (app == null) {
            // Используем getInstance() для инициализации менеджера и проверки, была ли уже произведена инициализация
            app = ApplicationManager.getInstance("https://diary.anek.ws/", "Karina", "nchi4792");
        }
    }
}
