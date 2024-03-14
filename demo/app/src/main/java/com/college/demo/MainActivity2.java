package com.college.demo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        * xml파일에 컴포넌트들을 객체로 생성해줌 ex.new Button
        * 따라서 setContentView 다음에 작성해줘야함
         */
        setContentView(R.layout.activity_main2);

        Button myButton = (Button) findViewById(R.id.myButton);
        TextView text = (TextView) findViewById(R.id.textView);

        text.setText("202135760");
        myButton.setText("Hyeonji Kim");


        Button button = (Button)findViewById(R.id.button);
        button.setText("Start ");

    }
}