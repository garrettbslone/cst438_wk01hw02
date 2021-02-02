/**
 *
 */
package com.garrett.retrofit_setup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText uname_et;
    private EditText pass_et;
    private Button login_btn;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname_et = findViewById(R.id.main_et_uname);
        pass_et = findViewById(R.id.main_et_pass);
        login_btn = findViewById(R.id.main_btn_login);

        login_btn.setOnClickListener(v -> {
            String uname = get_uname();
            String pass = get_pass();

            int uid;
            if((uid = login(uname, pass)) >= 0) {
                Intent intent = LandingPageActivity.get_intent(getApplicationContext(), uid);
                startActivity(intent);
            }
        });
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

    private int login (String uname, String pass) {
        List<Account> accounts = Account.get_accounts();

        if (!validate_uname(uname, accounts)) {
            uname_et.setBackgroundColor(Color.RED);
            return -1;
        } else {
            uname_et.setBackgroundColor(Color.WHITE);
        }

        Account account = Account.get_by_uname(accounts, uname);

        if (account == null || !validate_pass(pass, account)) {
            pass_et.setBackgroundColor(Color.RED);
            return -1;
        }

        return account.getId();
    }
}