package com.college.demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //requestCode는 처음 startActivityForResult에서 설정한 1이 넘어오고
        //resultCode는 RESULT_OK 넘어옴
        //위 코드를 활용해, switch문으로 다른 화면에서 넘어오는 데이터 구분
        String outName = data.getStringExtra("name");
        Toast.makeText(this, "전달 받은 name값: "+outName, Toast.LENGTH_LONG).show();
    }

    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2024.03.12
        container = (LinearLayout) findViewById(R.id.container);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.sub1, container, true); //container에 sub1을 붙여주기

                CheckBox checkBox = (CheckBox) container.findViewById(R.id.checkBox); //container로 찾는 범위를 한정
                checkBox.setText("로딩되었어요.");
            }
        });


        //2024.03.19
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01010001000"));
                startActivity(intent);
            }
        });

        Button btnNew = (Button) findViewById(R.id.btn_new);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }
}