package kanhoudevelopment.waifurun;
import kanhoudevelopment.waifurun.objects.*;

/**
 * Created by Kevin on 2017-12-10.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;


public class GameLoopThread extends Thread {

    private GameView view;
    private boolean running = false;
    private BlockManager bManager;
    private Player player;
    private cuButton cuBtnLeft;
    private cuButton cuBtnRight;
    private final int BUTTON_HEIGHT = 256;
    private final int SCREEN_HEIGHT = 1080;
    private final int SCREEN_WIDTH = 1920;
    private Bitmap background;

    public GameLoopThread(GameView view) {
        this.view = view;
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // ... Respond to touch events
                return hasPressed(v,event);

            }
        });
    }

    private boolean hasPressed(View v, MotionEvent ev) {
        if(cuBtnRight.isPressed(ev)){
            System.out.println("HAS PRESSED BUTTON");
            return true;
        }
        return false;
    }

    public void setRunning(boolean run) {
        running = run;
    }

    @Override
    public void run() {

        //initialize things first
        bManager = new BlockManager();
        bManager.Initialize(view);

        cuBtnLeft = new cuButton(view,50,SCREEN_HEIGHT-256,0,null);
        cuBtnRight = new cuButton(view,SCREEN_WIDTH-256-50,SCREEN_HEIGHT-256,0,null);

        player = new Player(150, 1080-BUTTON_HEIGHT, view);

        background = BitmapFactory.decodeResource(view.getResources(),R.drawable.background);

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

            //Background
            view.draw(background,0,0);

            //DRAW GAME STUFF
            //example: view.draw(block.getBitmap(), 10, 10
            bManager.draw(view);
            player.draw(view);


            //------------------------------------------

            //UI RENDERING HAPPENS HERE
            //------------------------------------------
            cuBtnRight.draw(view);
            cuBtnLeft.draw(view);

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
