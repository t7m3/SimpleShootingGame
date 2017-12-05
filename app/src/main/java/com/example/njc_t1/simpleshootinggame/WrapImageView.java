package com.example.njc_t1.simpleshootinggame;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;

/**
 * Created by NJC-T1 on 2017/12/05.
 */

public class WrapImageView {

    //このクラスのグローバル変数の宣言
    ImageView imageView;

    //画面の幅、高さを取得する
    DisplayMetrics dm = Resources.getSystem().getDisplayMetrics();
    int screenWidth = dm.widthPixels;
    int screenHeight = dm.heightPixels;


    //このクラスのコンストラクタ
    public WrapImageView(ImageView R_imageView, int x, int y) {
        imageView = R_imageView;
        imageView.setX(x);
        imageView.setY(y);
    }

    //ImageViewクラスのメソッド

    public void setX(int x) {
        imageView.setX(x);
    }

    public void setY(int y) {
        imageView.setY(y);
    }

    public float getX() {
        return imageView.getX();
    }

    public float getY() {
        return imageView.getY();
    }

    public float getWidth() {
        return imageView.getWidth();
    }

    public float getHeight() {
        return imageView.getHeight();
    }

    public void setImageResource(int resid) {
        imageView.setImageResource(resid);
    }

    public void setVisibility(int v){
        imageView.setVisibility(v);
    }
}
