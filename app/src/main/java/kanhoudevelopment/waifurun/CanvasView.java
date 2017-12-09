package kanhoudevelopment.waifurun;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.*;

/**
 * Created by Kevin on 2017-12-09.
 */

public class CanvasView extends SurfaceView implements SurfaceHolder.Callback {

    SurfaceHolder ourHolder;

    Canvas canvas;
    Paint paint;

    Bitmap bmpReisen;

    public CanvasView(Context cont) {
        super(cont);

        ourHolder = getHolder();
        ourHolder.addCallback(this);
        paint = new Paint();

        bmpReisen = BitmapFactory.decodeResource(this.getResources(), R.drawable.reisensprite);

    }

    @Override
    protected void onDraw(Canvas c) {


            //canvas = ourHolder.lockCanvas();
            //canvas.drawRGB(r,g,b);
            c.drawBitmap(bmpReisen, 50, 200, null);
            //ourHolder.unlockCanvasAndPost(canvas);



    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
