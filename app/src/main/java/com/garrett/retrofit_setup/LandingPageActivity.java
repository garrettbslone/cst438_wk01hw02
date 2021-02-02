package com.garrett.retrofit_setup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class LandingPageActivity extends AppCompatActivity {
    private static final String BASE_MSG = "Welcome User ";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
    }

    public static Intent get_intent (Context ctx, int uid) {
        Intent intent = new Intent(ctx, LandingPageActivity.class);
        intent.putExtra("uid", uid);

        return intent;
    }
}