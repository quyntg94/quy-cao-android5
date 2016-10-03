package quyntg.vn.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by giaqu on 10/2/2016.
 */
public class ViewCompund extends LinearLayout {

    @BindView(R.id.tv_number) ValueTextView valueTextView;
    @BindView(R.id.tv_label) LabelTextView labelTextView;
    @BindView(R.id.iv_remove)
    ImageView ivRemove;
    @BindView(R.id.iv_add)
    ImageView ivAdd;

    private String label;
    private int value;

    public void setLabel(String label) {
        this.label = label;
        updateUI();
    }

    public void setValue(int value) {
        this.value = value;
        updateUI();
    }

    public ViewCompund(Context context) {
        super(context);
        initFromContext(context, null);
    }

    public ViewCompund(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromContext(context, attrs);
    }

    public ViewCompund(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFromContext(context, attrs);
    }

    public LabelTextView getLabelTextView() {
        return labelTextView;
    }

    public void setLabelTextView(LabelTextView labelTextView) {
        this.labelTextView = labelTextView;
        updateUI();
    }

    private void initFromContext(Context context, AttributeSet attrs){
        View rootView = inflate(context, R.layout.turn1, this);
        ButterKnife.bind(this, rootView);
        if(attrs != null){
            //1
            TypedArray labelArray = context.obtainStyledAttributes(attrs, R.styleable.LabelTextView);
            //2
            this.label = labelArray.getString(R.styleable.LabelTextView_label);
            //3
            labelArray.recycle();
            //4
//            this.setLabelTextView(String.format("%s", attrs));

            //1
            TypedArray valueArray = context.obtainStyledAttributes(attrs, R.styleable.ValueTextView);
            //2
            this.value = valueArray.getInt(R.styleable.ValueTextView_value, -1);
            //3
            valueArray.recycle();
            //4
            Log.d("ad", value+"" + label);
        }
        updateUI();
        addListeners();
    }

    private void updateUI() {
        labelTextView.setText(label);
        valueTextView.setText(value+"");
    }

    private void addListeners() {
        ivAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                value++;
                valueTextView.setText(String.format("%s", value));
            }
        });
        ivRemove.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                value--;
                valueTextView.setText(String.format("%s", value));
            }
        });
    }
}
