package com.example.njc_t1.simpleshootinggame;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;

/**
 * Created by NJC-T1 on 2017/12/04.
 */

public class ImageViewBullet {

    //このクラスのグローバル変数の宣言
    ImageView imageViewBullet;
    boolean shoot = false;

    //画面の幅、高さを取得する
    DisplayMetrics dm = Resources.getSystem().getDisplayMetrics();
    int screenWidth = dm.widthPixels;
    int screenHeight = dm.heightPixels;

    //このクラスのコンストラクタ
    public ImageViewBullet(ImageView R_imageViewBullet, int x, int y){
        imageViewBullet = R_imageViewBullet;
        imageViewBullet.setX(x);
        imageViewBullet.setY(y);
    }
    //左または右に移動する。valueは移動量。
    public  void  Move(int value){

        float y = imageViewBullet.getY(); //y座標の取得
        y = y - value;
        imageViewBullet.setY(y); //x座標の更新

        if(y < 0 ){
            shoot = false;
            reset();
        }
    }

    //ｘ座標、ｙ座標を設定する
    public void setXY(int x, int y){
        imageViewBullet.setX(x);
        imageViewBullet.setY(y);
    }

    //弾をリセットする
    public  void  reset(){

        int x = 0;
        int y = screenHeight * 75/100;
        setXY(x, y);
    }
}

