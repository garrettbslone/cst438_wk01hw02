/**
 *
 */
package com.garrett.retrofit_setup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText uname_et;
    private EditText pass_et;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname_et = findViewById(R.id.main_et_uname);
        pass_et = findViewById(R.id.main_et_pass);

        boolean logged_in;
        do {
            String uname = get_uname(uname_et);
            String pass = get_pass(pass_et);

            logged_in = login(uname, pass);
        } while (!logged_in);
    }

    private String get_uname (EditText uname_et) {
        return uname_et.getText().toString().trim();
    }

    private String get_pass (EditText pass_et) {
        return pass_et.getText().toString().trim();
    }

    private boolean login (String uname, String pass) {
        return false;
    }
}