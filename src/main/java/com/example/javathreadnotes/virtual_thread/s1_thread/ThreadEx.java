package com.example.javathreadnotes.virtual_thread.s1_thread;

/*
* ThreadEx를 구현하는 방법 2가지
* 1. Thread 클래스를 상속받는 방법
* 2. Runnable 인터페이스를 구현하는 방법
* */
public class ThreadEx {
    public static void main(String[] args) {
        ThreadEx_1 t1 = new ThreadEx_1();

        Runnable r = new ThreadEx_2();
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}

/*
* ThreadEx_1.java
* Thread 클래스를 상속받은 경우
* */
class ThreadEx_1 extends Thread {
    public void run() {
        for(int i=0; i < 5; i++) {
            System.out.println(getName());
        }
    }
}

/*
 * ThreadEx_2.java
 * Runnable 인터페이스를 구현한 경우
 * Thread.currentThread() - 현재 실행 중인 스레드의 정보를 반환
 * Thread.currentThread().getName() - 현재 실행 중인 스레드의 이름을 반환
 * */
class ThreadEx_2 implements Runnable {
    public void run() {
        for(int i=0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}