package sz6636.view_2_textview.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import sz6636.view_2_textview.R;
import sz6636.view_2_textview.util.DensityUtil;


/**
 * Created by lincoln on 17/3/22.
 */

public class LincolnTextView extends View {
    private CharSequence text;
    private TextPaint mPaint;
    private int textSize = 30;


    public LincolnTextView(Context context) {
        this(context, null);
    }

    public LincolnTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, R.attr.textViewStyle);
    }

    public LincolnTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public LincolnTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        CharSequence text = "AAAA";
        final Resources.Theme theme = context.getTheme();

        /*
         * Look the appearance up without checking first if it exists because
         * almost every TextView has one and it greatly simplifies the logic
         * to be able to parse the appearance first and then let specific tags
         * for this View override it.
         */
        TypedArray a = theme.obtainStyledAttributes(attrs,
                R.styleable.TextViewAppearance, defStyleAttr, defStyleRes);
        TypedArray appearance = null;
        int ap = a.getResourceId(
                R.styleable.TextViewAppearance_textAppearance, -1);
        a.recycle();
        if (ap != -1) {
            appearance = theme.obtainStyledAttributes(
                    ap, R.styleable.TextAppearance);
        }
        if (appearance != null) {
            int n = appearance.getIndexCount();
            for (int i = 0; i < n; i++) {
                int attr = appearance.getIndex(i);
                switch (attr) {
                    case R.styleable.TextView_text:
                        text = a.getText(attr);
                        break;
                }
            }
        }
        mPaint = new TextPaint();
        mPaint.setColor(getResources().getColor(R.color.red));
        mPaint.setTextSize(DensityUtil.dip2px(getContext(), textSize));
        setText(text);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText(text.toString(), getWidth() / 2, getHeight() / 2, mPaint);

    }

    public CharSequence getText() {
        return text;
    }

    public void setText(CharSequence text) {
        this.text = text;
        invalidate();
    }

    public int getTextSize() {
        return textSize;

    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
        mPaint.setTextSize(DensityUtil.dip2px(getContext(),textSize));
        invalidate();
    }
}
