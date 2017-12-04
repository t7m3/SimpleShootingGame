package com.example.njc_t1.simpleshootinggame;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

//MainActivityクラスの定義・・・AppCompatActivityクラスを継承している
public class MainActivity extends AppCompatActivity {

    //グローバル変数の宣言(インスタンス変数、メンバ変数)
    ImageViewEnemy imageViewEnemy;
    ImageViewPlayer imageViewPlayer;
    ImageViewBullet imageViewBullet;
    TextView textView;

    //画面の幅、高さを取得する
    DisplayMetrics dm = Resources.getSystem().getDisplayMetrics();
    int screenWidth = dm.widthPixels;
    int screenHeight = dm.heightPixels;

    @Override
    //起動時に自動実行されるメソッドの定義
    protected void onCreate(Bundle savedInstanceState) {
        //親クラスのメソッドを呼び出す
        super.onCreate(savedInstanceState);
        //activity_mainを表示する
        setContentView(R.layout.activity_main);

        //textViewの参照値を取得する。findViewById()メソッドで。
        textView = (TextView)findViewById(R.id.textView);

        //タイマーのインスタンスの生成
        GameTimer gameTimer = new GameTimer(1*60*1000, 50);

        //タイマをスタートする
        gameTimer.start();

        //imageViewEnemyの参照値を取得する。findViewById()メソッドで
        ImageView R_imageViewEnemy = (ImageView)findViewById(R.id.imageViewEnemy);

        //敵のインスタンスの生成
        int x = 0;
        int y = screenHeight * 5/100;
        imageViewEnemy = new ImageViewEnemy(R_imageViewEnemy, x, y);

        //imageViewPlayerの参照値を取得する。findViewById()メソッドで
        ImageView R_imageViewPlayer = (ImageView)findViewById(R.id.imageViewPlayer);

        //プレイヤーのインスタンスの生成
        x = 0;
        y = screenHeight * 60/100;
        imageViewPlayer = new ImageViewPlayer(R_imageViewPlayer, x, y);

        //imageViewBulletの参照値を取得する。findViewById()メソッドで
        ImageView R_imageViewBullet = (ImageView)findViewById(R.id.imageViewBullet);

        //弾のインスタンスの生成
        x = 0;
        y = screenHeight * 75/100;
        imageViewBullet = new ImageViewBullet(R_imageViewBullet, x, y);
    }

    @Override
    //画面タッチのメソッドの定義
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();                //タッチした場所のＸ座標
        int y = (int) event.getY();                //タッチした場所のＹ座標

        textView.setText("X座標："+x+"　Y座標：" + y);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                textView.append("　ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                textView.append("　ACTION_UP");
                imageViewBullet.setXY(x, y);
                imageViewBullet.shoot = true;
                break;
            case MotionEvent.ACTION_MOVE:
                textView.append("　ACTION_MOVE");
                imageViewPlayer.setX(x);
                break;
            case MotionEvent.ACTION_CANCEL:
                textView.append("　ACTION_CANCEL");
                break;
        }

        return true;

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

            //弾が上に移動する。
            if(imageViewBullet.shoot == true){
                imageViewBullet.Move(10);
            }

        }

        //タイマ終了の処理
        public  void onFinish(){

        }
    }

}
