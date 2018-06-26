package com.example.ragna.treuepunkte2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    CardView btnUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUser = findViewById(R.id.btnImageUser);
        btnUser.setOnClickListener(this);
    }

    public void onClick(View v){
        Intent intent = new Intent(MainActivity.this, UserActivity.class);
        startActivity(intent);
        this.finish();
    }

}
