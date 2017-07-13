package com.example.mszhapa.tourguidecopenhagen;

/**
 * Created by MsZhapa on 24/06/2017.
 * GridAdapter class for the GridActivity
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter{

    private Context mContext;
    private final int[] mCategory;
    private final int[] mImageId;

    public GridAdapter(Context c, int[] mCategory, int[] mImageId) {
        mContext = c;
        this.mImageId = mImageId;
        this.mCategory = mCategory;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mCategory.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = inflater.inflate(R.layout.grid_item, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(mCategory[position]);
            imageView.setImageResource(mImageId[position]);
        } else {
            grid = convertView;
        }
        return grid;
    }
}
