package com.example.kavin.wantedxtickets.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.kavin.wantedxtickets.R;
import com.example.kavin.wantedxtickets.UI.CountryTab;
import com.example.kavin.wantedxtickets.UI.EDMTab;
import com.example.kavin.wantedxtickets.UI.HipHopTab;
import com.example.kavin.wantedxtickets.UI.MusicFestivalTab;
import com.example.kavin.wantedxtickets.UI.MusicalTab;

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    private Context mContext;

    public FragmentPagerAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new EDMTab();
        } else if (position == 1) {
            return new HipHopTab();
        } else if (position == 2) {
            return new CountryTab();
        } else if (position == 3) {
            return new MusicalTab();
        } else return new MusicFestivalTab();
    }


    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.edm_title);
            case 1:
                return mContext.getString(R.string.hip_hop_title);
            case 2:
                return mContext.getString(R.string.country_title);
            case 3:
                return mContext.getString(R.string.musical_title);
            case 4:
                return mContext.getString(R.string.festival_title);
            default:
                return null;
        }
    }
}
