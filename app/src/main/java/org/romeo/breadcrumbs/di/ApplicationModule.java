package org.romeo.breadcrumbs.di;

import com.google.firebase.auth.FirebaseAuth;

import org.romeo.breadcrumbs.persistence.Datastore;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * User: tylerromeo Date: 5/29/16 Time: 7:27 PM
 */

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    Datastore provideDatastore(Application application) {
        return new Datastore(application);
    }

    @Provides
    @Singleton
    FirebaseAuth provideFirebaseAuth() {
        return FirebaseAuth.getInstance();
    }
}
