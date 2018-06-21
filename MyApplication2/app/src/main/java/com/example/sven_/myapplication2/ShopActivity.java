package com.example.sven_.myapplication2;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ShopActivity extends AppCompatActivity {

    ListView shopListView;
    String[] shop_names;
    String[] shop_description;
    String[] shop_distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);


        Resources res = getResources();
        shopListView = (ListView) findViewById(R.id.shopListView);
        //bind the string-arrays from resources/string.xml
        shop_names = res.getStringArray(R.array.shop_names);
        shop_description = res.getStringArray(R.array.shop_description);
        shop_distance = res.getStringArray(R.array.shop_distance);

        ShopAdapter shopAdapter = new ShopAdapter(this, shop_names, shop_description, shop_distance);
        shopListView.setAdapter(shopAdapter);

        shopListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showShopDetails = new Intent(getApplicationContext(), ShopDetailsActivity.class);
                showShopDetails.putExtra("com.example.sven_.SHOP_INDEX", position);
                startActivity(showShopDetails);
            }
        });
    }
}
