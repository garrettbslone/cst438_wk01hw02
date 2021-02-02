package com.garrett.retrofit_setup;

import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTests {
    @Test
    public void verify_username() {
        Random rand = new Random();
        List<Account> accounts = Account.get_accounts();

        int ind = rand.nextInt(accounts.size());
        String username1 = accounts.get(ind).getUname();

        assertTrue(MainActivity.validate_uname(username1, accounts));
        assertFalse(MainActivity.validate_uname("", accounts));
    }
}