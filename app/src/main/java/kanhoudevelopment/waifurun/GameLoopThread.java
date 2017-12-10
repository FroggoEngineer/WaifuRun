package kanhoudevelopment.waifurun;
import kanhoudevelopment.waifurun.objects.Block;
import kanhoudevelopment.waifurun.objects.BlockManager;

/**
 * Created by Kevin on 2017-12-10.
 */

import android.graphics.Canvas;



public class GameLoopThread extends Thread {

    private GameView view;
    private boolean running = false;
    private BlockManager bManager;


    public GameLoopThread(GameView view) {
        this.view = view;
    }

    public void setRunning(boolean run) {
        running = run;
    }

    @Override
    public void run() {
        bManager = new BlockManager();
        bManager.Initialize(view);
        int a = 0;

        while (running) {

            //DO GAME STUFF HERE

            if (a < 10)
                a++;
            else
            {
                a = 0;
                bManager.spawnBlock(10, 50);
            }


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
