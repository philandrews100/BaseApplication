package phil.baseproject.activities.controllers;

import android.content.Context;

import phil.baseproject.activities.controllers.interfaces.ActivityMainInterface;

/**
 * Created by phil-apposing on 03/02/2017.
 */

public class ActivityMainController {

    private ActivityMainInterface mainInterface;

    public ActivityMainController(Context context) {
        mainInterface = (ActivityMainInterface) context;
    }

    public void goBack() {
        mainInterface.goBack();
    }

    public Context getParentInstance() {
        return mainInterface.getParentInstance();
    }
}
