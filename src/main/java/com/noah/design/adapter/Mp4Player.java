package com.noah.design.adapter;

/**
 * Mp4Player.java
 *
 * @author yinzongchang
 * 创建时间 2023/8/1
 * @since 1.0
 * 
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
