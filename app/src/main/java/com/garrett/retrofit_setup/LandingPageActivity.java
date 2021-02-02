package com.garrett.retrofit_setup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LandingPageActivity extends AppCompatActivity {
    private static final String BASE_MSG = "Welcome User ";

    private TextView welcome_tv;
    private TextView posts_tv;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        welcome_tv = findViewById(R.id.lp_tv_welcome);
        posts_tv = findViewById(R.id.lp_tv_posts);
        int logged_in_uid = getIntent().getIntExtra("uid", -1);

        if (logged_in_uid >= 1) {
            welcome_tv.setText(BASE_MSG + logged_in_uid);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JsonPlaceHolderApi api = retrofit.create(JsonPlaceHolderApi.class);

            Call<List<Post>> call = api.getPosts(logged_in_uid);
            call.enqueue(new Callback<List<Post>>() {
                @Override
                public void onResponse (Call<List<Post>> call, Response<List<Post>> response) {
                    if (!response.isSuccessful()) {
                        posts_tv.setText("Code: " + response.code());
                        return;
                    }

                    List<Post> posts = response.body();
                    for (Post post : posts) {
                        StringBuilder str = new StringBuilder();

                        str.append("ID: ").append(post.getId()).append("\n");
                        str.append("Title: ").append(post.getTitle()).append("\n");
                        str.append("Text: ").append(post.getText()).append("\n\n");

                        posts_tv.append(str.toString());
                    }
                }

                @Override
                public void onFailure (Call<List<Post>> call, Throwable t) {
                    posts_tv.setText(t.getMessage());
                }
            });
        } else {
            welcome_tv.setText("Error getting user id from intent: uid: " + logged_in_uid);
        }
    }

    public static Intent intent_factory (Context ctx, int uid) {
        Intent intent = new Intent(ctx, LandingPageActivity.class);
        intent.putExtra("uid", uid);

        return intent;
    }
}