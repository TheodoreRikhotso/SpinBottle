package com.example.admin.spinbottle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView iv_Bottle;
    Boolean restart= false;
    Button btn_Spin;
    Random r;
    int angle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        iv_Bottle =(ImageView)findViewById(R.id.iv_bottle);
        btn_Spin =(Button) findViewById(R.id.btnSpin);

        btn_Spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(restart){
                     angle = angle%360;
                    RotateAnimation ra = new RotateAnimation(angle,360,RotateAnimation.RELATIVE_TO_SELF,0.5f, RotateAnimation.RELATIVE_TO_SELF,0.5f);
                    ra.setFillAfter(true);
                    ra.setDuration(1000);
                    ra.setInterpolator(new AccelerateDecelerateInterpolator());
                    iv_Bottle.startAnimation(ra);
                        btn_Spin.setText("Spin");
                    restart = false;
                }else {

                    angle = r.nextInt(3600)+360;
                    RotateAnimation ra = new RotateAnimation(0,angle,RotateAnimation.RELATIVE_TO_SELF,0.5f, RotateAnimation.RELATIVE_TO_SELF,0.5f);
                    ra.setFillAfter(true);
                    ra.setDuration(3600);
                    ra.setInterpolator(new AccelerateDecelerateInterpolator());
                    iv_Bottle.startAnimation(ra);
                    restart = true;
                    btn_Spin.setText("Reset");
                }

            }
        });

    }
}
