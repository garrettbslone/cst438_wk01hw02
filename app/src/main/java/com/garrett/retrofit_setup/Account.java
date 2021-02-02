/*
 * author: Garrett
 * date: 2/1/2021
 * project: retrofit_setup
 * description:
 */
package com.garrett.retrofit_setup;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String uname;
    private String pass;
    private int id;

    private static int cur_id = 0;

    private static final List<Account> accounts = new ArrayList<>();

    private static void create_accounts() {
        accounts.add(new Account("din_djarin", "baby_yoda_ftw"));
        accounts.add(new Account("foo", "bar"));
        accounts.add(new Account("baz", "foobarbaz"));
        accounts.add(new Account("test_user", "test_pass"));
        accounts.add(new Account("test_usertest_user", "test_pass"));
        accounts.add(new Account("foo", "baz"));
    }

    public static List<Account> get_accounts() {
        if (accounts.isEmpty()) {
            create_accounts();
        }

        return accounts;
    }

    public Account (String uname, String pass) {
        this.uname = uname;
        this.pass = pass;
        this.id = cur_id++;
    }

    public String getUname () {
        return uname;
    }

    public void setUname (String uname) {
        this.uname = uname;
    }

    public String getPass () {
        return pass;
    }

    public void setPass (String pass) {
        this.pass = pass;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }
}
