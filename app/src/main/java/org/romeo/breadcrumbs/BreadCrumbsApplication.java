package org.romeo.breadcrumbs;

import org.romeo.breadcrumbs.di.ApplicationComponent;
import org.romeo.breadcrumbs.di.ApplicationModule;
import org.romeo.breadcrumbs.di.DaggerApplicationComponent;

import android.app.Application;

/**
 * User: tylerromeo Date: 5/29/16 Time: 8:34 PM
 */
public class BreadCrumbsApplication extends Application {

    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }

}
