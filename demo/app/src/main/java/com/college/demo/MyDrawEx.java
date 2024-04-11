package com.college.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

public class MyDrawEx extends View { //태그화 시킬수 있다 : 태그 이름은 패키지 이름
    public MyDrawEx(Context c){
        super(c);
    }
    public MyDrawEx(Context c, AttributeSet a){
        //attribute : xml에 속성 하나하나가 -> xml에서 설정한 속성이 view에 적용될 수 있도록 함
        super(c, a);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        canvas.drawColor(Color.WHITE);
        for(int x=0;x<200;x+=5){
            canvas.drawLine(x, 0, 200-x, 100, paint);
        }
    }
}
