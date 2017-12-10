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
        player = new Player(50, 400, view);

        cuBtnLeft = new cuButton(view,200,400,0,null);
        cuBtnRight = new cuButton(view,500,400,0,null);

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
