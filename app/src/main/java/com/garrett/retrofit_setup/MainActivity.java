/**
 *
 */
package com.garrett.retrofit_setup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText uname_et = findViewById(R.id.main_et_uname);
        EditText pass_et = findViewById(R.id.main_et_pass);

        boolean logged_in;
        do {
            String uname = get_uname(uname_et);
            String pass = get_pass(pass_et);

            logged_in = login(uname, pass);
        } while (!logged_in);
    }

    public static boolean validate_uname(String uname, List<Account> accounts) {
        for (Account account: accounts) {
            if (account.getUname().equals(uname)) {
                return true;
            }
        }

        return false;
    }

    public static boolean validate_pass(String pass, List<Account> accounts) {
        return false;
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