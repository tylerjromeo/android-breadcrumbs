package org.romeo.breadcrumbs.di;

import org.romeo.breadcrumbs.login.DatastoreAuthListener;
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

    void inject(DatastoreAuthListener datastoreAuthListener);
}
