package com.fitnessapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.fitnessapp.fragments.SplashFragment;
import com.fitnessapp.interfaces.NavigationImpl;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationImpl {

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

        openSplashScreen();
    }

    public void replaceFragment(Fragment mFragment, int id, String tag, boolean addToStack) {
        FragmentTransaction mTransaction = getSupportFragmentManager().beginTransaction();
        mTransaction.replace(id, mFragment);
        hideKeyboard();
        //DebugLog.e("TAG::" + tag);
        if (addToStack) {
            mTransaction.addToBackStack(tag);
        }
        mTransaction.commit();
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void openSplashScreen() {
        replaceFragment(new SplashFragment(), R.id.content_frame, null, false);
    }

    @Override
    public void openLoginScreen() {

    }

    @Override
    public void openSignupScree() {

    }

    @Override
    public void openServiceScreen() {

    }

    @Override
    public void openAboutScreen() {

    }

    @Override
    public void openContactUsScreen() {

    }

    @Override
    public void openReachUsScreen() {

    }

    @Override
    public void openServiceDetails() {

    }
}
