package com.example.javathreadnotes.virtual_thread.s1_thread;

/*
* 멀티 스레드를 이용한 I/O 블로킹(Blocking) 해결
* - 별도의 스레드에서 카운트다운을 실행시켜
* - 사용자 입력을 기다리는 동안에도 프로그램이 멈추지 않고
* - 동시에 작업이 처리
* */
public class ThreadEx7 {
    public static void main(String[] args) {
        ThreadEx7_1 th1 = new ThreadEx7_1();
        th1.start();

        String input = javax.swing.JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력한 값은 " + input + "입니다.");
    }
}

class ThreadEx7_1 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
