package shaileshrawat.mvt;

import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.format.DateUtils;
import android.util.Property;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;


public class splashscreen extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splashscreen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(splashscreen.this,MVT.class);
                splashscreen.this.startActivity(mainIntent);
                splashscreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
        ImageView im= (ImageView)findViewById(R.id.splash);
        //im.setImageResource(R.mipmap.logo);
        im.animate();

        /*Typeface myTypeface = Typeface.createFromAsset(getAssets(), "Fonts/colors.ttf");
        textView.setTypeface(myTypeface);*/


         }

    private static final Property<RainbowText, Float> ANIMATED_COLOR_SPAN_FLOAT_PROPERTY
            = new Property<RainbowText, Float>(Float.class, "ANIMATED_COLOR_SPAN_FLOAT_PROPERTY") {
        @Override
        public void set(RainbowText span, Float value) {
            span.setTranslateXPercentage(value);
        }
        @Override
        public Float get(RainbowText span) {
            return span.getTranslateXPercentage();
        }
    };
    @Override
    public void onBackPressed() {
    }

    }

