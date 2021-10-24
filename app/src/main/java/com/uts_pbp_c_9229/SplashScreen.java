package com.uts_pbp_c_9229;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.uts_pbp_c_9229.dao.User;
import com.uts_pbp_c_9229.listdata.UserList;
import com.uts_pbp_c_9229.view.HomeActivity;

public class SplashScreen extends AppCompatActivity {
    private String splash;
    private CheckBox checkBox;
    private ImageView ivNext;
    private SharedPreferences preference;
    private TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();
        txtName = findViewById(R.id.txtName);
        preference = PreferenceManager.getDefaultSharedPreferences(this);
        User user = new UserList().getUserById(preference.getString("userId", null));
        txtName.setText("Welcome, "+ user.getName().substring(0,5));

        checkBox = findViewById(R.id.checkBox);
        ivNext = findViewById(R.id.ivNext);
        SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preference.edit();

        ivNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked())
                    editor.putString("splash", "tidak");
                else
                    editor.putString("splash", "ya");
                editor.apply();

                startActivity(new Intent(SplashScreen.this, HomeActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}