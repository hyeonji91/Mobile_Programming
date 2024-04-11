package com.college.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Gainmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomImageView extends AppCompatActivity {
    LinearLayout mLinearLayout;
    ImageView img;
    Button changeImgBtn;
    int idx =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLinearLayout = new LinearLayout(this);
        changeImgBtn = new Button(this);
        changeImgBtn.setText("change image");

        img = new ImageView(this);
        Drawable myImage1 = getResources().getDrawable(R.drawable.img1);
        Drawable myImage2 = getResources().getDrawable(R.drawable.img3);
        Drawable myImage3 = getResources().getDrawable(R.drawable.img4);

        img.setImageDrawable(myImage1);

        img.setLayoutParams(new Gallery.LayoutParams(Gallery.LayoutParams.WRAP_CONTENT,
                Gallery.LayoutParams.WRAP_CONTENT));

        mLinearLayout.addView(img);
        mLinearLayout.addView(changeImgBtn);

        setContentView(mLinearLayout);

        changeImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idx %3 ==0){
                    img.setImageDrawable(myImage1);
                    idx++;
                } else if (idx %3 == 1) {
                    img.setImageDrawable(myImage2);
                    idx++;
                } else{
                    img.setImageDrawable(myImage3);
                    idx++;
                }

            }
        });
    }
}