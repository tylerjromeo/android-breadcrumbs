package org.romeo.breadcrumbs.login;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.romeo.breadcrumbs.persistence.Datastore;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * User: tylerromeo Date: 5/22/16 Time: 8:27 PM
 */
public class DatastoreAuthListener implements FirebaseAuth.AuthStateListener {

    private Context context;
    private Datastore datastore;

    public DatastoreAuthListener(Context context) {
        this.context = context;
        this.datastore = new Datastore(context);
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
