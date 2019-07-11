package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("GDPgD4vGH5WRRVXx5MvrQaNUJ48tssnfxTbB9lm6")
                // if defined
                .clientKey("1VpdfVMmMjftAr30kKXdgFpF0lX9YBDgZalMwW8K")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
