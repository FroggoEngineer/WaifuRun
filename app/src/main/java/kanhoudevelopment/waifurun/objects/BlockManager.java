package kanhoudevelopment.waifurun.objects;

import android.graphics.BitmapFactory;
import android.view.SurfaceView;
import kanhoudevelopment.waifurun.R;

public class BlockManager
{

    private static final int MAX_BLOCKS = 20;

    private Block blocks[];

    public void Initialize(SurfaceView view)
    {
        blocks = new Block[MAX_BLOCKS];
        for (int i = 0; i < MAX_BLOCKS; i++)
        {
            blocks[i].LoadContent(BitmapFactory.decodeResource(view.getResources(),
                    R.drawable.stone));
        }
    }

    public Block[] getBlocks()
    {
        return blocks;
    }

    public void spawnBlock(int speed, int y)
    {
        for (int i = 0; !blocks[i].isActive() || i < 20; i++)
            if (blocks[i].isActive())
                blocks[i].spawn(speed, y);
    }
}
