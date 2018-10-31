package com.example.priyanka.islapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerInitListener;

public class Alphabets extends AppCompatActivity {
    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     setContentView(R.layout.youtube_player_view);
        youTubePlayerView = findViewById(R.id.youtube_player_view);

        youTubePlayerView.initialize(
                new YouTubePlayerInitListener() {

                    @Override
                    public void onInitSuccess(
                            final YouTubePlayer initializedYouTubePlayer) {

                        initializedYouTubePlayer.addListener(
                                new AbstractYouTubePlayerListener() {
                                    @Override
                                    public void onReady() {
                                        initializedYouTubePlayer.loadVideo("TMJn6Zjf5jY", 0);
                                    }
                                });
                    }
                }, true);
    }
}
