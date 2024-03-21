package com.college.demo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    final String tag = "LifeCycle";

    /**
     * requestCode는 처음 startActivityForResult에서 설정한 1이 넘어오고
     * resultCode는 RESULT_OK 넘어옴
     * requestCode, resultCode를 활용해, switch문으로 다른 화면에서 넘어오는 데이터 구분
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String outName = data.getStringExtra("name");
        Toast.makeText(this, "전달 받은 name값: " + outName, Toast.LENGTH_LONG).show();
        /**
         * this: 객체를 대신함 : 객체의 이름은 알 수 없음
         * 여기서 this는 AppCompatActivity의 객체임
         * method: 객체로 부르는 매소드가 있고 클래스로 부르는 메소드(static) 두가지가 있음
         */
    }

    LinearLayout container;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "In the onStart() event");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "In the onRestart() event");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "In the onResume() event");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "In the onPause() event");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "In the onStop() event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(tag, "In the onDestroy() event");

    }

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

        //View.OnClickListener : 익명(Anonymous) 클래스 -> 객체를 한개만 생성
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
                //Toast.makeText(this, "전달 받은 name값: ", Toast.LENGTH_LONG).show();
                //여기 toast의 this는 OnClickListener의 객체임
            }
        });

        Log.d(tag, "In the onCreate() event");

    }
}