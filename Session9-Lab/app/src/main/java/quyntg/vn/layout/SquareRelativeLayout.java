package quyntg.vn.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by giaqu on 10/2/2016.
 */
public class SquareRelativeLayout extends RelativeLayout {
    private static final String TAG = SquareRelativeLayout.class.toString() ;

    public SquareRelativeLayout(Context context) {
        super(context);
    }

    public SquareRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightSize = MeasureSpec.getSize(widthMeasureSpec);

        int widthSize = heightSize / 2;
        int widthMode = MeasureSpec.EXACTLY;

        int newWidthMeasureSpec = MeasureSpec.makeMeasureSpec(widthSize, widthMode);
        super.onMeasure(newWidthMeasureSpec, heightMeasureSpec);
    }
}
