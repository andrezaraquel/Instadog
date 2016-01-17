package picoledelimao.github.io.instadog;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * This activity describes the actions taken on login screen
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.17.2016
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        Button btSignup = (Button) findViewById(R.id.btSignup);
        btSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
        Button btLogin = (Button) findViewById(R.id.btLogin);
        final EditText etLogin = (EditText) findViewById(R.id.etLogin);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = etLogin.getText().toString();
                String password = etPassword.getText().toString();
                login(login, password);
            }
        });
    }

    /**
     * This method is called when the login button is pressed
     * @param login
     *      Login filled in the login field
     * @param password
     *      Password filled in the password field
     */
    private void login(String login, String password) {
        // TODO Replace the body of this method with the correct implementation
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
