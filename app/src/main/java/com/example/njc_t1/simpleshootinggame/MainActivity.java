package com.example.njc_t1.simpleshootinggame;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  class  GameTimer extends CountDownTimer{

        //GameTimerクラスのコンストラクタ
        public GameTimer(long millisInFuture, long countDownInterval){
            super(millisInFuture, countDownInterval );
        }

        //タイマイベントの処理
        public void onTick(long millisUntilFinished){

        }

        //タイマ終了の処理
        public  void onFinish(){

        }
    }
}
