package com.example.javathreadnotes.virtual_thread.s1_thread;

/*
* 새로운 스레드가 생성되지 않고 main 스레드에서 일반 메서드처럼 실행
* */
public class ThreadEx3 {
    public static void main(String[] args) throws Exception{
        ThreadEx3_1 t1 = new ThreadEx3_1();
        t1.run(); // run() 메서드를 직접 호출
    }
}

class ThreadEx3_1 extends Thread {
    public void run() {
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}