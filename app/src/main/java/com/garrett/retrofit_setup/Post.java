/*
 * author: Garrett
 * date: 2/2/2021
 * project: retrofit_setup
 * description:
 */
package com.garrett.retrofit_setup;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int userId;
    private int id;
    private String title;
    @SerializedName("body")
    private String text;

    public int getUserId () {
        return userId;
    }

    public int getId () {
        return id;
    }

    public String getTitle () {
        return title;
    }

    public String getText () {
        return text;
    }
}
