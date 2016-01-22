package picoledelimao.github.io.instadog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * This activity describes the actions taken on login screen
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.17.2016
 */
public class LoginActivity extends AppCompatActivity {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private OkHttpClient mClient;
    private View mLoading;

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
    private void login(final String login, final String password) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "http://instadog-armq.rhcloud.com/login";
                JSONObject json = new JSONObject();
                try {
                    json.put("Login", login);
                    json.put("senha", password);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RequestBody body = RequestBody.create(JSON, json.toString());
                Request request = new Request.Builder().url(url).post(body).build();
                Response response = null;
                try {
                    response = mClient.newCall(request).execute();
                    final String result = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (!result.equals("SUCESSO")) {
                                new AlertDialog.Builder(LoginActivity.this)
                                        .setTitle("Erro")
                                        .setMessage(result)
                                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                mLoading.setVisibility(View.GONE);
                                            }
                                        })
                                        .create()
                                        .show();
                            } else {
                                new AlertDialog.Builder(LoginActivity.this)
                                        .setTitle("Sucesso")
                                        .setMessage("Login realizado com sucesso")
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                                startActivity(intent);
                                                finish();
                                                finish();
                                            }
                                        })
                                        .create()
                                        .show();
                            }
                        }
                    });
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }

            }
        }).start();

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
