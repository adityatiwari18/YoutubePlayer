package com.example.aditya.youtubeplayer;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity
            implements YouTubePlayer.OnInitializedListener {

    static final String GOOGLE_API_KEY = "AIzaSyCLAH7x_6S7C1B_28QTP-kAVtAFYpDtNYM";
    static final String YOUTUBE_VIDEO_ID = "nyVBF02EusU";
    static final String YOUTUBE_PLAYLIST = "PL976432F7B68FA276";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_youtube);
        ConstraintLayout layout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_youtube,null);
        setContentView(layout);

        YouTubePlayerView playerView = new YouTubePlayerView(this);
        playerView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(playerView);
        playerView.initialize(GOOGLE_API_KEY,this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        Toast.makeText(this,"Initialized youtube player successfully",Toast.LENGTH_LONG);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if(!b){
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        }


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
     private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
         @Override
         public void onPlaying() {
            Toast.makeText(YoutubeActivity.this,"Video Started", Toast.LENGTH_SHORT).show();
         }

         @Override
         public void onPaused() {
            Toast.makeText(YoutubeActivity.this,"Video Paused", Toast.LENGTH_SHORT).show();
         }

         @Override
         public void onStopped() {

         }

         @Override
         public void onBuffering(boolean b) {

         }

         @Override
         public void onSeekTo(int i) {

         }
     };
}
