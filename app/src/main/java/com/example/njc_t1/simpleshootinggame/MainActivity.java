package com.example.njc_t1.simpleshootinggame;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.ImageView;

//MainActivityクラスの定義・・・AppCompatActivityクラスを継承している
public class MainActivity extends AppCompatActivity {

    //グローバル変数の宣言(インスタンス変数、メンバ変数)
    ImageViewEnemy imageViewEnemy;

    //画面の幅、高さを取得する
    DisplayMetrics dm = Resources.getSystem().getDisplayMetrics();
    int screenWidth = dm.widthPixels;
    int screenHeight = dm.heightPixels;

    @Override
    //起動時に自動実行されるメソッド
    protected void onCreate(Bundle savedInstanceState) {
        //親クラスのメソッドを呼び出す
        super.onCreate(savedInstanceState);
        //activity_mainを表示する
        setContentView(R.layout.activity_main);

        //タイマーのインスタンスの生成
        GameTimer gameTimer = new GameTimer(1*60*1000, 50);

        //タイマをスタートする
        gameTimer.start();

        //imageViewEnemyの参照値を取得する。findViewById()メソッドで。
        ImageView R_imageViewEnemy = (ImageView)findViewById(R.id.imageViewEnemy);

        //敵のインスタンスの生成
        int x = 0;
        int y = screenHeight * 5/100;
        imageViewEnemy = new ImageViewEnemy(R_imageViewEnemy, x, y);
    }

    //Timerクラスの定義　CountDownTimerクラスを継承している
    public  class  GameTimer extends CountDownTimer{

        //GameTimerクラスのコンストラクタの定義
        public GameTimer(long millisInFuture, long countDownInterval){
            super(millisInFuture, countDownInterval );
        }

        //タイマイベントの処理
        public void onTick(long millisUntilFinished){
            //敵が左右に移動する。
            imageViewEnemy.Move(5);

        }

        //タイマ終了の処理
        public  void onFinish(){

        }
    }

}
