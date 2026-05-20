package gr.athenstech.course;

import android.app.Application;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize any libraries or resources here
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
