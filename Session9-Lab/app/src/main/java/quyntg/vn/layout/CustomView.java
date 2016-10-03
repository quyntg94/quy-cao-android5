package quyntg.vn.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import butterknife.BindColor;
import butterknife.ButterKnife;

/**
 * Created by giaqu on 10/3/2016.
 */
public class CustomView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @BindColor(R.color.red)
    public int red;

    @BindColor(R.color.blue)
    public int blue;

    public CustomView(Context context) {
        super(context);
        ButterKnife.bind(this, this);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ButterKnife.bind(this, this);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ButterKnife.bind(this, this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(red);
        canvas.drawCircle(300, 100, 100, paint);
        paint.setColor(blue);
        canvas.drawCircle(200, 100, 100, paint);
    }
}
