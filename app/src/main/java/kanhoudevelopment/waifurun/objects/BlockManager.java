package kanhoudevelopment.waifurun.objects;

import android.graphics.BitmapFactory;
import android.view.SurfaceView;
import kanhoudevelopment.waifurun.R;
import kanhoudevelopment.waifurun.GameView;

public class BlockManager
{
    public void BlockManager(){}
    private static final int MAX_BLOCKS = 128;

    private Block blocks[];

    public void Initialize(GameView v)
    {
        blocks = new Block[MAX_BLOCKS];
        for (int i = 0; i < MAX_BLOCKS; i++)
        {
            blocks[i] = new Block();
            blocks[i].LoadContent(BitmapFactory.decodeResource(v.getResources(),
                    R.drawable.stone));
        }
        for (int i = 0; i < 32; i++)
            //256 = button height, 64 = block height
            blocks[i].spawn(8, 720-170-48, i*64+1);
    }

    public void spawnBlock(int speed, int y)
    {
        int q = 0;
        for (int i = 0; i < MAX_BLOCKS; i++)
        {
            //System.out.println(blocks[i].getPosX());
            if (blocks[i].isActive() && blocks[i].getPosX() > 1280 && blocks[i].getPosY() == y) {
                if (blocks[i].getPosX() > q+1)
                    q = blocks[i].getPosX();
            }
        }
        for (int i = 0; i < MAX_BLOCKS; i++)
            if (!blocks[i].isActive())
            {
                blocks[i].spawn(speed, y, q);
                return;
            }
    }

    public void Update()
    {
        for( int i = 0; i < MAX_BLOCKS; i++) {
            if (blocks[i].isActive()) {
                blocks[i].Update();
            }
        }
    }

    public void draw(GameView v)
    {
        for( int i = 0; i < MAX_BLOCKS; i++) {
            if (blocks[i].isActive()) {
                blocks[i].draw(v);
            }
        }
    }
}
