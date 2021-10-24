package com.uts_pbp_c_9229;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.uts_pbp_c_9229.listdata.UserList;
import com.uts_pbp_c_9229.view.HomeActivity;

public class LoginActivity extends AppCompatActivity {
    private String splash;
    private TextInputEditText txtEmail, txtPass;
    private Button btnLogin;
    private SharedPreferences preference;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        preference = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preference.edit();
        splash  = preference.getString("splash", null);

        setAttribut();
    }

    public void setAttribut(){
        txtEmail    = findViewById(R.id.txtEmail);
        txtPass     = findViewById(R.id.txtPassword);
        btnLogin    = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString();
                String pass = txtPass.getText().toString();

                if(email.equals("") || pass.equals("")){
                    Toast.makeText(getApplicationContext(),
                            "Field must be filled.", Toast.LENGTH_SHORT).show();
                }else{
                    String message = new UserList().login(email, pass);
                    if(message.equalsIgnoreCase("User Not Found") ||
                            message.equalsIgnoreCase("Password invalid")){
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    }else{
                        editor.putString("isLogin", "ya");
                        editor.putString("userId", message);
                        editor.apply();
                        if(splash.equals("ya")) {
                            startActivity(new Intent(LoginActivity.this, SplashScreen.class));
                        }else{
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}