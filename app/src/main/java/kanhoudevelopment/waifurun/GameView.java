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
    private SurfaceHolder holder;
    private GameLoopThread gameLoopThread;
    private int x = 0;

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
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.reisensprite);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //ADD DRAW FUCKING STUFF HERE !!!!!!!!!!!!!!!!!!!!!
        canvas.drawColor(Color.BLACK);
        if (x < getWidth() - bmp.getWidth()) {
            x++;
        }
        canvas.drawBitmap(bmp, x, 10, null);
    }
}
