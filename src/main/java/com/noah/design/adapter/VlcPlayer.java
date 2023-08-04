package com.noah.design.adapter;

/**
 * VlcPlayer.java
 *
 * @author yinzongchang
 * 创建时间 2023/8/1
 * @since 1.0
 * 
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
