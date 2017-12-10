package kanhoudevelopment.waifurun;
import kanhoudevelopment.waifurun.objects.*;

/**
 * Created by Kevin on 2017-12-10.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;


public class GameLoopThread extends Thread {

    private GameView view;
    private boolean running = false;
    private BlockManager bManager;
    private Player player;

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
        player = new Player(50, 400, view);
        int a = 0;

        while (running) {

            //GAME LOOP HERE
            //------------------------------------------
            if (a < 60)
                a++;
            else
            {
                a = 0;
                bManager.spawnBlock(20, 1080-128);
            }

            bManager.Update();

            player.update();

            //------------------------------------------


            //DRAWING HAPPENS HERE
            //------------------------------------------
            //Clear the background and ready it for new batch
            view.clear();

            //Do own draw stuff here
            //example: view.draw(block.getBitmap(), 10, 10
            bManager.draw(view);
            player.draw(view);

            //------------------------------------------


            //DON'T DRAW AFTER THIS!!!!!
            //This only displays the background per Double buffering system
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
