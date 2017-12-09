package kanhoudevelopment.waifurun;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import kanhoudevelopment.waifurun.objects.BlockManager;

public class GameActivity extends AppCompatActivity implements Runnable {

    Thread gameThread = null;
    CanvasView canvas;
    volatile boolean running = false;
    private int r=0,g=0,b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new GameView(this));
        View decorView = this.getWindow().getDecorView();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        //main();

    }





    private void main() {

        setContentView(canvas);


        //Start game loop after starting everything up
        running = true;
        run();

    }

    private void update() {
        r = g = b = b+1;
    }

    private void draw() {

    }

    @SuppressLint("WrongCall")
    @Override
    public void run() {
        while(r < 255) {
            Canvas c = null;
            try {
                c = canvas.getHolder().lockCanvas();
                synchronized (canvas.getHolder()) {
                    canvas.onDraw(c);
                }
            } finally {
                if (c != null) {
                    canvas.getHolder().unlockCanvasAndPost(c);
                }
            }
        }
        //update();


    }



}
