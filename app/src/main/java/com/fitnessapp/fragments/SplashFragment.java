package com.fitnessapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import com.fitnessapp.R;
import com.fitnessapp.views.HorizontalPanning;
import com.fitnessapp.views.PanningView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hitesh on 4/3/17.
 */

public class SplashFragment extends BaseFragment {


    @Bind(R.id.panningView)
    PanningView panningView;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_splash, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        panningView.setPanningListener(new PanningView.PanningListener() {
            @Override
            public void onPanningEnd(PanningView panningView) {
                Toast.makeText(getActivity(), "Finish", Toast.LENGTH_SHORT).show();
            }
        });

        HorizontalPanning subwayPanning = new HorizontalPanning(HorizontalPanning.RIGHT_TO_LEFT);
        subwayPanning.setStartXOffset(1);
        subwayPanning.setEndXOffset(1f);
        subwayPanning.setInterpolator(new DecelerateInterpolator());
        panningView.setPanning(subwayPanning);
        
    }

    @Override
    void setToolBarForFragment() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
