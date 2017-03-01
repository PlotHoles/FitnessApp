package com.fitnessapp;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.content_frame)
    FrameLayout contentFrame;
    @Bind(R.id.left_drawer)
    ListView leftDrawer;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private float lastTranslate = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, null, R.string.acc_drawer_open, R.string.acc_drawer_close) {
            @SuppressLint("NewApi")
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float moveFactor = (leftDrawer.getWidth() * slideOffset);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    contentFrame.setTranslationX(moveFactor);
                } else {
                    TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
                    anim.setDuration(0);
                    anim.setFillAfter(true);
                    contentFrame.startAnimation(anim);

                    lastTranslate = moveFactor;
                }
            }
        };

        drawerLayout.addDrawerListener(mDrawerToggle);
    }
}
