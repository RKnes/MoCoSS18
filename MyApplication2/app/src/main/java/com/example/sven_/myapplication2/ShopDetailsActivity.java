package com.example.sven_.myapplication2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/**
 *****************************TO DO'S**************************************
 * - Name
 * - Beschreibung
 * - Bewertung und Kommentare
 */

/**
 * Diese Klasse generiert die Anzeige der Shop-Details.
 * Aufgerufen wird sie, sobald in der Shopüberischt jemand auf einen
 * speziellen Shop klickt, um Infos über diesen zu erhalten.
 * Hierin enthalten sind:
 * - Logo
 * - Name
 * - Beschreibung
 * - Bewertungen und Kommentare
 */
public class ShopDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_details);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.sven_.SHOP_INDEX", -1);



        /**
         * Wenn index kleine 0 ist, ist kein Shop gewählt
         * ansonsten wird über die getImage Methode das richtige Bild gewählt
         * und geschrieben
         */
        if (index > -1) {
            int pic = getImage(index);
            ImageView img = (ImageView) findViewById(R.id.shopImageView);
            Bitmap picture = BitmapFactory.decodeResource(getResources(),pic);
            img.setImageBitmap(picture);
        }
    }

    /**
     * getImage ist eine case Struktur in der jedes Bild seinen Case hat und je nach Shop
     * wird eine Bildnummer zugewießen, aktuelle abhängig von der Shop-Reihenfolge
     * @param index Der Shop, für welchen das Bild aufgerufen werden soll
     * @return das jeweilige Shopbild
     */
    private int getImage(int index) {
        switch (index) {
            case 0: return R.drawable.dm_logo;
            case 1: return R.drawable.saturn_logo;
            case 2: return R.drawable.jack_and_jones_logo;
            default: return -1;
        }
    }

    /**
     * Ob die Methode wirklich nötig ist, wird sich zeigen, bisher ist die Skalierung so
     * auch sehr gut, ansonsten, Methode ist fehlerhaft, da nicht die richtige weite der ImageView
     * genommen wird     *
     * @param img
     * @param pic
     */
    /*
    private void scaleImage(ImageView img, int pic) {
        ImageView iv = findViewById(R.id.shopImageView);
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int imgContainerWidth = iv.getMaxWidth();
        System.out.println(imgContainerWidth);
        System.out.println(imgWidth);


        if (imgContainerWidth > imgWidth) {
            int ratio = Math.round( (float)imgWidth / (float)imgContainerWidth );
            options.inSampleSize = ratio;

            options.inJustDecodeBounds = false;
            Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
            img.setImageBitmap(scaledImg);
        }
    }*/

}