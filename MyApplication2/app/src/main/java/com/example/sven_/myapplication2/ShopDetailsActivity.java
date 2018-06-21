package com.example.sven_.myapplication2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class ShopDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_details);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.sven_.SHOP_INDEX", -1);

        if (index > -1) {
            System.out.println("300");
            System.out.println(index);
            int pic = getImage(index);
            ImageView img = (ImageView) findViewById(R.id.shopImageView);
            scaleImage(img, pic);
        }
    }

    private int getImage(int index) {
        System.out.println("100");
        System.out.println(index);
        switch (index) {
            case 0: return R.drawable.dm_logo;
            case 1: return R.drawable.saturn_logo;
            case 2: return R.drawable.jack_and_jones_logo;
            default: return -1;
        }
    }

    private void scaleImage(ImageView img, int pic) {
        System.out.println("200");
        System.out.println(pic);
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth > screenWidth) {
            int ratio = Math.round( (float)imgWidth / (float)screenWidth );
            options.inSampleSize = ratio;

            options.inJustDecodeBounds = false;
            Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
            img.setImageBitmap(scaledImg);

        }
    }


}
