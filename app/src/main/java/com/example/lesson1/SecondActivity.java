package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.textView);


        int fromMainActivity;
        fromMainActivity = getIntent().getIntExtra("key1",0);
        textView.setText(String.valueOf(fromMainActivity));

        String text = getIntent().getStringExtra("key");
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

    }
}