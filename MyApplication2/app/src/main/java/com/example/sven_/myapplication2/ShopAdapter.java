package com.example.sven_.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Der Shopadapter
 */
public class ShopAdapter extends BaseAdapter {

    LayoutInflater mInflator;

    String[] shop_names;
    String[] shop_description;
    String[] shop_distance;

    public ShopAdapter(Context c, String[] s_n, String[] s_des, String[] s_dis) {
        shop_names = s_n;
        shop_description = s_des;
        shop_distance = s_dis;
        mInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return shop_names.length;
    }

    @Override
    public Object getItem(int position) {
        return shop_names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = mInflator.inflate(R.layout.shop_listview_detail, null);
        TextView shopNameView = (TextView) v.findViewById(R.id.shopNameView);
        TextView shopDescriptionView = (TextView) v.findViewById(R.id.shopDescriptionView);
        TextView shopDistanceView = (TextView) v.findViewById(R.id.shopDistanceView);

        String name = shop_names[position];
        String description = shop_description[position];
        String distance = shop_distance[position];

        shopNameView.setText(name);
        shopDescriptionView.setText(description);
        shopDistanceView.setText(distance);

        return v;
    }
}
