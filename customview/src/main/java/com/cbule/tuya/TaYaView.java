package com.cbule.tuya;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/6/30.
 */
public class TaYaView extends View {

    private Canvas canvas;
    private Bitmap bitmap;
    private Paint paint;
    private float mx,my;
    private Path path;

    public TaYaView(Context context,int screenWidth,int screenHeight) {
        super(context);
        bitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
    }
    public TaYaView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TaYaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action =event.getAction();
        float x = event.getX();
        float y =event.getY();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                path = new Path();
                path.moveTo(x,y);
                mx=x;
                my=y;
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(x-mx);
                float dy = Math.abs(y-my);
                if(dx>4||dy>4){
                path.moveTo(x,y);
                    canvas.drawPath(path,paint);
                }
                mx=x;
                my=y;
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,0,0,paint);
    }
}
