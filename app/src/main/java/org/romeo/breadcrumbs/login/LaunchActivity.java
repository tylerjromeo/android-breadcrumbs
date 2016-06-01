package org.romeo.breadcrumbs.login;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.romeo.breadcrumbs.BreadCrumbsApplication;
import org.romeo.breadcrumbs.R;
import org.romeo.breadcrumbs.login.firebase.DatastoreAuthListener;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LaunchActivity extends AppCompatActivity {

    private static final String TAG = "LaunchActivity";

    @BindView(R.id.login_email) EditText emailInput;
    @BindView(R.id.login_password) EditText passwordInput;
    @BindView(R.id.login_submit_button) Button submitButton;

    @Inject
    FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.bind(this);
        ((BreadCrumbsApplication) getApplicationContext()).getAppComponent().inject(this);

        authListener = new DatastoreAuthListener(this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(
                        LaunchActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Log.d(TAG, "signInWithEmail", task.getException());
                                    Toast.makeText(LaunchActivity.this, R.string.auth_failed,
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    //TODO navigate to main activity
                                   Toast.makeText(LaunchActivity.this, "navigate to main activity", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }
}
