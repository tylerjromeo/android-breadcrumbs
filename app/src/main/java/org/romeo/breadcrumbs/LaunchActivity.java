package org.romeo.breadcrumbs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LaunchActivity extends AppCompatActivity {

    @BindView(R.id.login_email) EditText emailInput;
    @BindView(R.id.login_password) EditText passwordInput;
    @BindView(R.id.login_submit_button) Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.bind(this);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();
                Toast.makeText(LaunchActivity.this, email + " " + password, Toast.LENGTH_LONG).show();
            }
        });
    }
}
