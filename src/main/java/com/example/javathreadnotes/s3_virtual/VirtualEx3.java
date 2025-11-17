package com.example.javathreadnotes.s3_virtual;

// 최대로 생성할 수 있는 "플랫폼 쓰레드"의 수를 알아내기 위한 것
/** 내 pc 결과
    count = 203000
    #
    # There is insufficient memory for the Java Runtime Environment to continue.
    # Native memory allocation (malloc) failed to allocate 1625208 bytes for AllocateHeap
    # An error report file with more information is saved as:
    # C:\Users\sharo\Desktop\java-thread-notes\hs_err_pid17032.log
    [938.412s][warning][os] Loading hsdis library failed
     Process finished with exit code 1
*/

public class VirtualEx3 {
    public static void main(String[] args) {
        int count = 0;

        Runnable r = () -> {
            try{
                Thread.sleep(Integer.MAX_VALUE); // 종료되지 않고 오래 잠자게 한다.
            } catch(InterruptedException e) {}
        };

        try{
            while(true) {
                Thread.ofPlatform().start(r);
                if(++count%1000 == 0) {
                    System.out.println("count = " + count);
                }
            }
        }catch(OutOfMemoryError e) {
            e.printStackTrace();
        }
        System.out.println("max count = " + count);
    }
}
