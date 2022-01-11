package com.example.checkinternetsources;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();

        TextView tv = findViewById(R.id.tv);
        try {
            switch (info.getType()){
                case 0:
                    tv.setText("基地台");
                    break;
                case 1:
                    tv.setText("wifi");
                    break;
            }
        }catch (Exception e){
            Toast.makeText(this, "沒網路!!", Toast.LENGTH_SHORT).show();
        }

    }
}