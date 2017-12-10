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
    private final int BUTTON_HEIGHT = 256;

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
        player = new Player(150, 1080-BUTTON_HEIGHT, view);
        int a,b = 0;


        while (running) {
            bManager.Update();

            if (b == 7)
            {
                a = 0;
                bManager.spawnBlock(8, 1080-BUTTON_HEIGHT-64);

            }
            else
                b++;

            /*
            if (a == 7 || a == 15 || a == 23)
                bManager.spawnBlock(8, 1080-64*2);
            if (a == 15 || a == 23)
                bManager.spawnBlock(8, 1080-64*3);
            if (a == 23)
                bManager.spawnBlock(8, 1080-64*4);
            if (a == 31)
                a = 0;
            else
                a++;
            */

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
