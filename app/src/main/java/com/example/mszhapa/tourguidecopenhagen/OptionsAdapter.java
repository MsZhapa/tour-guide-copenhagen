package com.example.mszhapa.tourguidecopenhagen;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by MsZhapa on 26/06/2017.
 */

public class OptionsAdapter extends FragmentPagerAdapter {

    Context mContext;

    private String tabTitles[] = new String[] { "Sights", "Castels", "Bars", "Restaurants" };

    public OptionsAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SightsFragment();
        } else if (position == 1) {
            return new CastelsFragment();
        } else if (position == 2) {
            return new BarsFragment();
        } else {
            return new RestaurantsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
