package kanhoudevelopment.waifurun;

/**
 * Created by Kevin on 2017-12-10.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import kanhoudevelopment.waifurun.objects.cuButton;


public class GameView extends SurfaceView {
    private Bitmap bmp;
    private Bitmap bmpReisen;
    Bitmap background;
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

        bmp = Bitmap.createBitmap(1280, 720, Bitmap.Config.RGB_565);
        back = new Canvas(bmp);
    }

    public void clear() {
        back.drawColor(Color.BLACK);

    }

    public void draw(Bitmap tempBit, int x, int y) {
        back.drawBitmap(tempBit,x,y,null);

    }


    @Override
    protected void onDraw(Canvas canvas) {

        //Clear the screen with black color
        canvas.drawColor(Color.BLACK);
        background = Bitmap.createScaledBitmap(bmp, canvas.getWidth(), canvas.getHeight(),false);
        //Draw background bitmap (Double buffer system)
        canvas.drawBitmap(background, 0, 0, null);
        background.recycle();
    }

}
