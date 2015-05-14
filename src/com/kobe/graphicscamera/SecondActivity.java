package com.kobe.graphicscamera;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
	}
	
	class MyView extends View{

		private Paint mPaint;
		private RectF rectF;
		
		public MyView(Context context) {
			super(context);
			mPaint = new Paint();
			rectF = new RectF();
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			mPaint.setColor(Color.BLUE);
			canvas.drawRect(rectF, mPaint);
		}
		
	}
}
