package com.Nasta.Trello.Tests;

        import com.Nasta.Trello.Manager.AppManager;
        import org.testng.annotations.AfterSuite;
        import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static AppManager app = new AppManager();


    @BeforeSuite

    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }
}
