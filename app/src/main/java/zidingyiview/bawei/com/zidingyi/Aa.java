package zidingyiview.bawei.com.zidingyi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by 1 on 2017/3/9.
 */
public class Aa extends View
{
private float r=0;
    private newthreah tt;
    private Paint pp=new Paint();
    private float sweep=0;

    public Aa(Context context)
    {
        super(context);
    }


    public Aa(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        RectF re=new RectF(0,60,100,160);

        pp.setTextSize(30);
        canvas.drawText("赵正亨",r,30, pp);
        canvas.drawArc(re,0,sweep,true,pp);
        if(tt==null){
            tt = new newthreah();
            tt.start();
        }

    }
    class  newthreah extends Thread{

        Random ran=new Random();
        public void run()
        {
            super.run();
            while(true){
                r+=3;
                if(r>getWidth())
                {
                    r=0-pp.measureText("赵正亨");
                }
                sweep++;
                if(sweep>360)
                {
                    sweep=0;
                }
                int rn=ran.nextInt(256);
                int g=ran.nextInt(256);
                int b=ran.nextInt(256);
                pp.setARGB(255,rn,g,b);
                postInvalidate();
                try {
                    sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }





        }
    }
}
