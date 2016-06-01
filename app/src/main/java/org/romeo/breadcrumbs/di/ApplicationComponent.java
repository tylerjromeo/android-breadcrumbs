package org.romeo.breadcrumbs.di;

import com.google.firebase.auth.FirebaseAuth;

import org.romeo.breadcrumbs.login.LaunchActivity;
import org.romeo.breadcrumbs.login.firebase.DatastoreAuthListener;
import org.romeo.breadcrumbs.persistence.Datastore;

import javax.inject.Singleton;

import dagger.Component;

/**
 * User: tylerromeo Date: 5/29/16 Time: 7:47 PM
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Datastore getDatastore();
    FirebaseAuth getFirebaseAuth();

    void inject(DatastoreAuthListener datastoreAuthListener);

    void inject(LaunchActivity launchActivity);
}
