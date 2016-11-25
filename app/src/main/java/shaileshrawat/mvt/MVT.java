package shaileshrawat.mvt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MVT extends Activity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4;
    int j=0;

    //private int backView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvt);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        btn1.setOnClickListener(this);
        btn1.setTag("a");
        btn2.setOnClickListener(this);
        btn2.setTag("b");
        btn3.setOnClickListener(this);
        btn3.setTag("c");
        btn4.setOnClickListener(this);
        btn4.setTag("d");
        btn5.setOnClickListener(this);
        btn5.setTag("e");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
         }

    @Override
    public void onClick(View v) {
        switch (v.getTag().toString()) {
           // backView = v.get

            case "a":
                Intent mpersonal = new Intent(this, modipersonal.class);
                startActivity(mpersonal);

                break;
            case "b":
                Intent tpersonal = new Intent(this, trumppersonal.class);
                startActivity(tpersonal);

                break;
            case "c":
                Intent mvtdiff = new Intent(this, mvtPersonalDiff.class);
                startActivity(mvtdiff);
                break;
            case "d":
                Intent mvtpoldiff = new Intent(this, mvtPoliticalDiff.class);
                startActivity(mvtpoldiff);
                break;
            case "e":
                CustomDialogClass cdd=new CustomDialogClass(this);
                cdd.show();
                cdd.setCancelable(false);
                cdd.setCanceledOnTouchOutside(false);
                break;
            default: finish();
        }
    }
}
