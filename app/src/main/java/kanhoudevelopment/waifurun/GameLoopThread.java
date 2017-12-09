package kanhoudevelopment.waifurun;

/**
 * Created by Kevin on 2017-12-10.
 */

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




            //DRAW FUCKING PIECE OF SHIT
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
