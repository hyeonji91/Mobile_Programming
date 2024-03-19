package com.college.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Button btnBack = (Button) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        getApplicationContext(),
                        "돌아가기 버튼이 눌렸어요",
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent();
                intent.putExtra("name", "dd");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}