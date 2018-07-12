package com.example.ragna.treuepunkte2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserActivity extends Activity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(UserActivity.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
