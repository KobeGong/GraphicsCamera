package com.example.aaa;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyView extends View{

	private int angleX, translateZ, translateX, tranlateY;
	private Camera camera;
	private Matrix matrix;
	private int width;
	private int height;
	private Paint mPaint;
	
	public MyView(Context context) {
		this(context, null);
		
	}

	public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		camera = new Camera();
		matrix = new Matrix();
		mPaint = new Paint();
		mPaint.setColor(Color.BLUE);
	}



	public MyView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}



	public void setAngleX(int angle){
		this.angleX = angle;
		invalidate();
	}

	public void setTranslateZ(int translateZ){
		this.translateZ = translateZ;
		invalidate();
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		this.width = w;
		this.height = h;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		matrix.reset();
		camera.save();
		camera.rotateX(angleX);
		camera.translate(translateX, tranlateY, translateZ);
		camera.getMatrix(matrix);
		camera.restore();
		matrix.preTranslate(-width/2, -height/2);
		matrix.postTranslate(width/2, height/2);
		canvas.save();
		canvas.concat(matrix);
		canvas.drawRect(10, 10, 290, 290, mPaint);
		canvas.restore();
		
		
	}
}
