package com.dante.customview.hencoder.practice5.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class Sample04DispatchDrawLayout extends LinearLayout {
    Pattern pattern = new Pattern();

    public Sample04DispatchDrawLayout(Context context) {
        super(context);
    }

    public Sample04DispatchDrawLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample04DispatchDrawLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /*
        ViewGroup执行onDraw之后，通过dispatchDraw绘制子View
     */
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

        pattern.draw(canvas);
    }

    private class Pattern {
        private static final float PATTERN_RATIO = 5f / 6;

        Paint patternPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Spot[] spots;

        {
            patternPaint.setColor(Color.parseColor("#A0E91E63"));
        }

        private Pattern() {
            spots = new Spot[4];
            spots[0] = new Spot(0.14f, 0.3f, 0.026f);
            spots[1] = new Spot(0.59f, 0.25f, 0.067f);
            spots[2] = new Spot(0.22f, 0.6f, 0.067f);
            spots[3] = new Spot(0.52f, 0.78f, 0.083f);
        }

        private Pattern(Spot[] spots) {
            this.spots = spots;
        }

        private void draw(Canvas canvas) {
            int repitition = (int) Math.ceil((float) getWidth() / getHeight());
            for (int i = 0; i < spots.length * repitition; i++) {
                Spot spot = spots[i % spots.length];
                canvas.drawCircle(i / spots.length * getHeight() * PATTERN_RATIO + spot.relativeX * getHeight(), spot.relativeY * getHeight(), spot.relativeSize * getHeight(), patternPaint);
            }
        }

        private class Spot {
            private float relativeX;
            private float relativeY;
            private float relativeSize;

            private Spot(float relativeX, float relativeY, float relativeSize) {
                this.relativeX = relativeX;
                this.relativeY = relativeY;
                this.relativeSize = relativeSize;
            }
        }
    }
}
