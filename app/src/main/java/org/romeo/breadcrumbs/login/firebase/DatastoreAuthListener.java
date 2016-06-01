package org.romeo.breadcrumbs.login.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.romeo.breadcrumbs.BreadCrumbsApplication;
import org.romeo.breadcrumbs.persistence.Datastore;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Inject;

/**
 * User: tylerromeo Date: 5/22/16 Time: 8:27 PM
 */
public class DatastoreAuthListener implements FirebaseAuth.AuthStateListener {

    private Context context;
    @Inject
    Datastore datastore;

    public DatastoreAuthListener(Context context) {
        this.context = context;
        ((BreadCrumbsApplication) context.getApplicationContext()).getAppComponent().inject(this);
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            // User is signed in
            datastore.saveLoginToken(user.getUid());
        } else {
            // User is signed out
            datastore.clearLoginToken();
        }
    }
}
