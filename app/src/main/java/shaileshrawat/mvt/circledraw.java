package shaileshrawat.mvt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;

public class circledraw extends SurfaceView
{
    public circledraw(Context context, int w, int h)
    {
        super(context);
        Canvas grid = new Canvas(Bitmap.createBitmap(200,100, Bitmap.Config.ARGB_8888));
        grid. drawColor(Color.BLUE);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        grid.drawCircle(w/2, h/2 , w/2, paint);
    }
}