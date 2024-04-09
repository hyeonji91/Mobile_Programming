package com.college.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CustomView extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView vw = new MyView(this);
        setContentView(vw);
    }

    protected class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(@NonNull Canvas canvas) {
            super.onDraw(canvas);
            Paint pnt = new Paint(Paint.ANTI_ALIAS_FLAG);
//            pnt.setColor(Color.BLUE);
//            canvas.drawColor(Color.RED);
//            canvas.drawCircle(200, 200, 50, pnt);
//            canvas.drawRect(400, 400, 500, 500, pnt);


            pnt.setStrokeWidth(8);
            pnt.setColor(Color.RED);

            //채우기
            pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(50, 50, 40, pnt);

            //외곽선 그리기
            pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150, 50, 40, pnt);

            //외곽선 및 채우기
            pnt.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(250, 50, 40, pnt);

            //파란색으로 채우고 빨간색으로 외곽선
            pnt.setColor(Color.BLUE);
            pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(50, 150, 40, pnt);

            pnt.setColor(Color.RED);
            pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(50, 150, 40, pnt);

            // 빨간색으로 외곽선 그리고 파란색으로 채우기 ->
            // 순서만 바뀌었는데 외곽선이 얇아지고 안에 원이 더 커짐
            pnt.setColor(Color.RED);
            pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150, 150, 40, pnt);

            pnt.setColor(Color.BLUE);
            pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(150, 150, 40, pnt);



            // 캡모양테스트
            pnt.setColor(Color.BLUE);
            pnt.setStrokeWidth(16);
            canvas.drawLine(50, 30, 240, 30, pnt);
            pnt.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawLine(50, 60, 240, 60, pnt);
            pnt.setStrokeCap(Paint.Cap.SQUARE);
            canvas.drawLine(50, 90, 240, 90, pnt);

            // 조인모양테스트
            pnt.setColor(Color.BLACK);
            pnt.setStrokeWidth(20);
            pnt.setStyle(Paint.Style.STROKE);
            pnt.setStrokeJoin(Paint.Join.MITER);
            canvas.drawRect(50, 150, 90, 200, pnt);
            pnt.setStrokeJoin(Paint.Join.BEVEL);
            canvas.drawRect(120, 150, 160, 200, pnt);
            pnt.setStrokeJoin(Paint.Join.ROUND);
            canvas.drawRect(190, 150, 230, 200, pnt);
        }
    }
}
