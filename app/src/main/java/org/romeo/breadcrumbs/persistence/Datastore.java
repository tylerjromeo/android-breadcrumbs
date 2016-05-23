package org.romeo.breadcrumbs.persistence;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * User: tylerromeo Date: 5/22/16 Time: 8:12 PM
 */
public class Datastore {

    private static final String PREFS_KEY = "org.romeo.breadcrumbs.presistence.Datastore";

    private static final String LOGIN_TOKEN_KEY = "LOGIN_TOKEN_KEY";

    private SharedPreferences prefs;

    public Datastore(Context context) {
        this.prefs = context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE);
    }

    public void saveLoginToken(String loginToken) {
        prefs.edit().putString(LOGIN_TOKEN_KEY, loginToken).apply();
    }

    public String getLoginToken() {
        return prefs.getString(LOGIN_TOKEN_KEY, "");
    }

    public boolean isLoggedIn() {
        return prefs.contains(LOGIN_TOKEN_KEY);
    }

    public void clearLoginToken() {
        prefs.edit().remove(LOGIN_TOKEN_KEY);
    }

}
