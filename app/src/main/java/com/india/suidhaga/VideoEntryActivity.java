package com.india.suidhaga;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
public class VideoEntryActivity extends AppCompatActivity {


    Button btn3;
    Animation bganim ;
    Animation bganimcard ;
    CardView card;
    Button btnG;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpage);

        btn3 = (Button)findViewById(R.id.btn3);
        btnG = (Button)findViewById(R.id.btnG);
        card = (CardView) findViewById(R.id.cardView);
        bganim = AnimationUtils.loadAnimation(this,R.anim.bganim);
        bganimcard = AnimationUtils.loadAnimation(this,R.anim.bganimcard);


        btnG.setOnClickListener(arg0 -> {

            btnG.startAnimation(bganim);
            btn3.startAnimation(bganim);
            card.startAnimation(bganimcard);
        });
        btn3.setOnClickListener(view -> startActivity(new Intent(VideoEntryActivity.this,Sign_In_Page.class)));


Toolbar toolbar = (Toolbar) findViewById(R.id.linlay);
setSupportActionBar(toolbar);






        videoView = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bckvid);
                videoView.setVideoURI(uri);
                videoView.start();


        Button b = (Button)findViewById(R.id.btnskip);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(VideoEntryActivity.this,
                       LauchHomeScreenMain.class);
                startActivity(myIntent);
            }
        });

    }




    }

