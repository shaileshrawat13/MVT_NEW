package shaileshrawat.mvt;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.logging.Handler;

import static shaileshrawat.mvt.R.drawable.dialog;

/**
 * Created by shailesh.rawat on 11/10/2016.
 */

public class CustomDialogClass extends Dialog {

    public Activity c;
    public ProgressBar mprogressBar;
    public TextView percentage, calculations;
    CountDownTimer ctimer;
    int percen[] = {1, 10, 15, 27,  30, 35, 45, 51, 60, 70, 79,  88, 93, 98, 99, 100};

    public CustomDialogClass(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        mprogressBar = (ProgressBar) findViewById(R.id.circular_progress_bar);
        percentage = (TextView) findViewById(R.id.perc);
        calculations = (TextView) findViewById(R.id.txtonDialog);
        ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 0, 100);
        anim.setDuration(15000);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();
        Typeface font = Typeface.createFromAsset(c.getAssets(),"Fonts/freefont.ttf");
        calculations.setTypeface(font);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ctimer.start();
            }
        }, 1000);
        ctimer = new CountDownTimer(16000, 1000) {

            public void onTick(long m) {
                int i=(int) m/1000;
                percentage.setText(percen[16-i] + "%");
                if(percen[16-i]==1){
                    calculations.setText("Analysing Modi Demographics...");
                }
                if(percen[16-i]==27){
                    calculations.setText("Analysing Trump Demographics..");
                }
                if(percen[16-i]==45){
                    calculations.setText("Analysing Modi Policies........");
                }
                if(percen[16-i]==70){
                    calculations.setText("Analysing Trump Policies........");
                }
                if(percen[16-i]==88){
                    calculations.setText("Deciding world Leader...........");
                }
                if(percen[16-i]==98){
                    calculations.setText("And Winner is...................");
                }

            }
            public void onFinish() {
                dismiss();
                Intent winner = new Intent(getContext(), winner.class);
                getContext().startActivity(winner);
            }
        };

    }

    private void stopTimer(){
        if(ctimer != null){
            ctimer.cancel();
        }
    }

}