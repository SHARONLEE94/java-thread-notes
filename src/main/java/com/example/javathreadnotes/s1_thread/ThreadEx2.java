package com.example.javathreadnotes.s1_thread;

/*
* "새로운 스레드" 내에서 예외가 발생하고 처리되는 방식
* */
public class ThreadEx2 {
    public static void main(String[] args) throws Exception {
        ThreadEx2_1 t1 = new ThreadEx2_1();
        t1.start();
    }
}

class ThreadEx2_1 extends Thread {
    public void run() {
        throwException();
    }

    public void throwException() {
        try{
            throw new Exception();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}