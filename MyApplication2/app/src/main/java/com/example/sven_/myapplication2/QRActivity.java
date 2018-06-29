package com.example.sven_.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QRActivity extends Activity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(QRActivity.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
