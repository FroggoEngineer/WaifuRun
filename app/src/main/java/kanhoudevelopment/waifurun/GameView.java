package kanhoudevelopment.waifurun;

/**
 * Created by Kevin on 2017-12-10.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



public class GameView extends SurfaceView {
    private Bitmap bmp;
    private Bitmap bmpReisen;
    private SurfaceHolder holder;
    private GameLoopThread gameLoopThread;
    private int x = 0;
    private Canvas back;

    public GameView(Context context) {
        super(context);
        gameLoopThread = new GameLoopThread(this);
        holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                boolean retry = true;
                gameLoopThread.setRunning(false);

                while (retry) {
                    try {
                        gameLoopThread.join();
                        retry = false;
                    } catch (InterruptedException e) {
                    }
                }
            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                gameLoopThread.setRunning(true);
                gameLoopThread.start();
            }


            @Override
            public void surfaceChanged(SurfaceHolder holder, int format,
                                       int width, int height) {
            }
        });
        bmpReisen = BitmapFactory.decodeResource(getResources(), R.drawable.reisensprite);
    }

    public void clear() {
        bmp = Bitmap.createBitmap(1920, 1080, Bitmap.Config.ARGB_8888);
        back = new Canvas(bmp);
    }

    public void draw(Bitmap tempBit, int x, int y) {
        //c.drawBitmap(bmpReisen, 50, 50, null);
        back.drawBitmap(tempBit,x,y,null);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //ADD DRAW FUCKING STUFF HERE !!!!!!!!!!!!!!!!!!!!

        canvas.drawColor(Color.BLACK);
        /*if (x < getWidth() - bmpReisen.getWidth()) {
            x++;
        }*/
        //Draw background thingy
        canvas.drawBitmap(bmp, 0, 0, null);

        //Draw reisen
        //canvas.drawBitmap(bmpReisen, x, 10, null);
    }
}
