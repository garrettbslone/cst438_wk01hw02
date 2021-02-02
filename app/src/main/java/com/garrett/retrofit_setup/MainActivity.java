/**
 *
 */
package com.garrett.retrofit_setup;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;

import java.util.List;

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
            String uname = get_uname();
            String pass = get_pass();

            logged_in = login(uname, pass);
        } while (!logged_in);
    }

    public static boolean validate_uname(String uname, List<Account> accounts) {
        return Account.get_by_uname(accounts, uname) != null;
    }

    public static boolean validate_pass(String pass, Account account) {
        return account.getPass().equals(pass);
    }

    private String get_uname () {
        return uname_et.getText().toString().trim();
    }

    private String get_pass () {
        return pass_et.getText().toString().trim();
    }

    private boolean login (String uname, String pass) {
        return false;
    }
}