package com.example.kavin.wantedxtickets.UI;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kavin.wantedxtickets.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EDMTab extends Fragment {


    public EDMTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.activity_main, container, false);
       return rootView;
    }

}
