package com.example.javathreadnotes.s1_thread;

/*
* 메인 스레드(main)와 새로 만든 작업 스레드(ThreadEx5_1)가
* 각자의 for문을 동시에 실행하는 멀티 스레딩 예제
* */
public class ThreadEx5 {
    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx5_1 th1 = new ThreadEx5_1();
        th1.start();
        startTime = System.currentTimeMillis();

        for(int i = 0; i < 300_000; i++) {
            System.out.printf("%s", "-");
        }

        System.out.println("소요시간1: " + (System.currentTimeMillis() - ThreadEx5.startTime));
    }
}

class ThreadEx5_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300_000; i++) {
            System.out.printf("%s", "|");
        }
        System.out.println("소요시간2: " + (System.currentTimeMillis() - ThreadEx5.startTime));
    }
}
