package quyntg.vn.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by giaqu on 10/2/2016.
 */
public class ValueTextView extends TextView {

    public ValueTextView(Context context) {
        super(context);
        initFromContext(context, null);
    }

    public ValueTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromContext(context, attrs);

    }

    public ValueTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFromContext(context, attrs);

    }

    private void initFromContext(Context context, AttributeSet attrs){

    }
}
