package quyntg.vn.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by giaqu on 10/2/2016.
 */
public class LabelTextView extends TextView {
    public LabelTextView(Context context) {
        super(context);
        initFromContext(context, null);
    }



    public LabelTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromContext(context, attrs);

    }

    public LabelTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFromContext(context, attrs);

    }

    private void initFromContext(Context context, AttributeSet attrs) {

    }
}
