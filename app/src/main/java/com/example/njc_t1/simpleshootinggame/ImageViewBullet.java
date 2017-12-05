package com.example.njc_t1.simpleshootinggame;

import android.view.View;
import android.widget.ImageView;

/**
 * Created by NJC-T1 on 2017/12/04.
 */

public class ImageViewBullet extends WrapImageView {

    //このクラスのグローバル変数の宣言
    boolean shoot = false;

    //このクラスのコンストラクタ
    public ImageViewBullet(ImageView R_imageViewBullet, int x, int y){
        super(R_imageViewBullet, x, y);
    }

    //左または右に移動する。valueは移動量。
    public  void  Move(int value){

        float y = getY(); //y座標の取得
        y = y - value;
        setY((int)y); //x座標の更新

        if(y < 0 ){
            shoot = false;
            reset();
        }

    }

    //弾をリセットする
    public  void  reset(){
        setVisibility(View.INVISIBLE);
        int x = 0;
        int y = screenHeight * 75/100;
        setX(x);
        setY(y);
    }

}

