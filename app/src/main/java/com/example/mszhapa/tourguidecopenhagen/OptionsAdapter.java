package com.example.mszhapa.tourguidecopenhagen;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by MsZhapa on 26/06/2017.
 */

public class OptionsAdapter extends FragmentPagerAdapter {

    private Context mContext;

    private String tabTitles[] = new String[4];

    public OptionsAdapter(Context context, FragmentManager fm) {

        super(fm);
        mContext = context;
        tabTitles[0]=mContext.getString(R.string.sights);
        tabTitles[1]=mContext.getString(R.string.castels);
        tabTitles[2]=mContext.getString(R.string.bars);
        tabTitles[3]=mContext.getString(R.string.restaurants);

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
