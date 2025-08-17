package com.example.javathreadnotes.s1_thread;

import javax.swing.*;

/*
* 단일 스레드의 I/O 블로킹(Blocking) 예제
* - 사용자 입력이 끝날 때까지
* - 카운트다운이 시작되지 않음
 * */
public class ThreadEx6 {
    public static void main(String[] args) throws Exception {
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력한 값은 " + input + "입니다.");

        for(int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
