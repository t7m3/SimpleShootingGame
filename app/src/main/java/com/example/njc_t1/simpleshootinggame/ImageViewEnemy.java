package com.example.njc_t1.simpleshootinggame;

import android.widget.ImageView;

/**
 * Created by NJC-T1 on 2017/12/04.
 */

public class ImageViewEnemy extends WrapImageView {

    //このクラスのグローバル変数の宣言
    int dir = +1;
    int bang = 0;

    //このクラスのコンストラクタ
    public ImageViewEnemy(ImageView R_imageViewEnemy, int x, int y){
        //親クラスのコンストラクタを呼び出す
        super(R_imageViewEnemy, x, y);
    }

    //左または右に移動する。valueは移動量。
    public  void  Move(int value){

        float x = getX(); //ｘ座標の取得
        x = x + value*dir;
        setX((int)x); //x座標の更新

        if(x < 0 || x > screenWidth-getWidth()){
            dir = -dir; //移動の左右の向きを反転する
        }
    }

}
