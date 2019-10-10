package jp.ac.shohoku.s18b709.graphicssample;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;

public class CustomView extends View {
    //コンストラクタ1
    public CustomView(Context context) {
        super(context);
    }

    //コンストラクタ2
    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //コンストラクタ3
    public CustomView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 30* このメソッドで描画をします．
     * param canvas 画像表示用のキャンバス
     **/
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        int w = this.getWidth();
        int h = this.getHeight();
        Paint p = new Paint();
        p.setStyle(Style.STROKE);//Styleを設定: 線で描く
        p.setColor(Color.DKGRAY);//色を設定
        canvas.drawRect(new Rect(5, 5, w - 10, h - 10), p);//長方形を描画
        Resources rs = this.getResources();
        Bitmap bmp = BitmapFactory.decodeResource(rs, R.drawable.illumination);
        canvas.drawBitmap(bmp, 0, 0, p);  //画像の左上をCanvasの(0,0)に合わ
        for (int i = 0; i < 10; i++) {
            Paint p2 = new Paint();
            p2.setStyle(Style.FILL);//Styleを設定：塗りつぶす
            p2.setColor(Color.rgb(25 * i, 0, 0));//色を設定
            canvas.drawCircle(25 * i + 125, 25 * i + 125, 100, p2);
        }
    }

}

