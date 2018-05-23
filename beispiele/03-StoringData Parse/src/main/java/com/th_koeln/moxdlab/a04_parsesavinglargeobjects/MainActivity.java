package com.th_koeln.moxdlab.a04_parsesavinglargeobjects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.interceptors.ParseLogInterceptor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        //False = only master key access
        ParseACL.setDefaultACL(defaultACL, true);

        // Add your initialization code here
        // Parse API is initilized here.
        Parse.addParseNetworkInterceptor(new ParseLogInterceptor());
        final String YOUR_APPLICATION_ID = "Parse_DB_Team_1";
        final String YOUR_CLIENT_KEY = "team1";
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId(YOUR_APPLICATION_ID)
                .clientKey(YOUR_CLIENT_KEY)
                .server("https://team1.parse.dock.moxd.io/api/")   // '/' important after 'api'
                .build());
    }


    public void addData(View v) throws ParseException {

        byte[] data = "Working at Parse is great!".getBytes();
        ParseFile file = new ParseFile("resume.txt", data);
        file.saveInBackground();


        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.moxd);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);

        byte[] dataImg = stream.toByteArray();
        ParseFile file2 = new ParseFile("Bild.png", dataImg);

        ParseObject jobApplication = new ParseObject("JobApplication");
        jobApplication.put("applicantName", "Joe Smith");
        jobApplication.put("applicantResumeFile", file);
        jobApplication.put("applicantResumeImg", file2);


        jobApplication.saveInBackground();

        Toast.makeText(this,"Object Saved", Toast.LENGTH_SHORT).show();
    }

    public void getData(View v) throws ParseException {

        //save context to handle it into the inner class for making Toast on UI
        final Context con = this;

        ParseQuery<ParseObject> query = ParseQuery.getQuery("JobApplication");
        query.getFirstInBackground( new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    Toast.makeText(con, "Name: " + object.getString("applicantName") , Toast.LENGTH_LONG).show();
                    ParseFile file = object.getParseFile("applicantResumeImg");
                    file.getDataInBackground(new GetDataCallback() {
                        public void done(byte[] data, ParseException e) {
                            if (e == null) {
                                ImageView iV = (ImageView) findViewById(R.id.imageView);
                                Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                                iV.setImageBitmap(bmp);
                            } else {
                                // something went wrong
                                Log.d("Getting", "Something wrong getting File " + e);
                            }
                        }
                    });
                } else {
                    Log.d("Getting","Something wrong getting the Object " + e);
                    // something went wrong
                }
            }
        });
    }
}
