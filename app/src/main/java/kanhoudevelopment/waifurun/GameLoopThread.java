package kanhoudevelopment.waifurun;

/**
 * Created by Kevin on 2017-12-10.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;


public class GameLoopThread extends Thread {

    private GameView view;

    private boolean running = false;



    public GameLoopThread(GameView view) {
        this.view = view;
    }

    public void setRunning(boolean run) {
        running = run;
    }



    @Override
    public void run() {
        while (running) {

            //DO GAME STUFF HERE



            view.clear();
            //Do own draw stuff here
            //example: view.draw(block.getBitmap(), 10, 10)


            //DON'T DRAW AFTER THIS!!!!!
            Canvas c = null;
            try {
                c = view.getHolder().lockCanvas();
                synchronized (view.getHolder()) {
                    view.onDraw(c);
                }
            } finally {
                if (c != null) {
                    view.getHolder().unlockCanvasAndPost(c);
                }
            }
        }
    }
}
