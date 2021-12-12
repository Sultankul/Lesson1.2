package com.example.lesson1;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private Button btnGo;
    private final int CAMERA_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btnGo.setOnClickListener(new View.OnClickListener() {


            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(checkCallingOrSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED
                ) {


                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


                    startActivityForResult(intent, CAMERA_REQUEST);
                }else{
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA},CAMERA_REQUEST);

                }


           // Intent actionIntent = new Intent(Intent.ACTION_SEND);
            //String text = "Hello world";
            //actionIntent.setType("text/plain");
          //  actionIntent.putExtra(Intent.EXTRA_SUBJECT,"Subject")
            //actionIntent.putExtra(Intent.EXTRA_TEXT,text);
           // startActivity(actionIntent);


           // Uri uri = Uri.parse("https://web.telegram.org/z/#588059080");
               // Intent intent = new Intent(Intent.ACTION_VIEW,uri);
             //   startActivity(intent);


            }


        });
        // Glide.with(this).load("https://i.pinimg.com/474x/23/ab/a6/23aba60b66ef08174bb7455c4a8a2d2f.jpg").into(image);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CAMERA_REQUEST  && resultCode == RESULT_OK && data!= null){
            Bitmap picture = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(picture);



        }
    }

    public void initView() {
        btnGo = findViewById(R.id.buttn);
        image = findViewById(R.id.image);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }
}