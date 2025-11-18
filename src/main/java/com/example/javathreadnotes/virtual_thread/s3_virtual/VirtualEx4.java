package com.example.javathreadnotes.virtual_thread.s3_virtual;

// 최대로 생성할 수 있는 "가상 쓰레드"의 수를 알아내기 위한 것
// cf 플랫폼 쓰레드 => 203000
// 38배 이상 차이남

/** 내 pc 결과
 count = 7801000
 Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "RMI TCP Connection(idle)"
 Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "main"
*/
public class VirtualEx4 {
    public static void main(String[] args) {
        int count =0;
        Runnable r = () -> {
            try{
                Thread.sleep(Integer.MAX_VALUE);
            } catch(InterruptedException e) {}
        };

        try{
            while(true) {
                Thread.ofVirtual().start(r);
                if(++count%1000==0) {
                    System.out.println("count = " + count);
                }
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        System.out.println("max count = " + count);
    }
}
