package com.example.autismicare;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;


public class HomeFragment extends Fragment{
    Button dyk,event;
    final static String TAG_1 = "Did_You_Know";
    FrameLayout containers;
    private YouTubePlayer YPlayer;
    private static final String YoutubeDeveloperKey = "AIzaSyB0I6IDVHEWUQAVi6WtNyPt1ZvrZ2CmgL0";

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        getActivity().setTitle("AutismICare");
        containers = (FrameLayout) view.findViewById(R.id.fragment_container1);
        dyk = (Button) view.findViewById(R.id.button1);
        event = (Button) view.findViewById(R.id.button2);

        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_frag,youTubePlayerFragment);
        transaction.commit();

        youTubePlayerFragment.initialize(YoutubeDeveloperKey, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                YPlayer = youTubePlayer;
                YPlayer.loadVideo("RbwRrVw-CRo" , 240000);
                YPlayer.getFullscreenControlFlags();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });


        dyk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DidYouKnowFragment didYouKnow=new DidYouKnowFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, didYouKnow);
                fragmentTransaction.commit();
            }
        });

        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventFragment ee=new EventFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, ee);
                fragmentTransaction.commit();
            }
        });
        return view;

    }

}



