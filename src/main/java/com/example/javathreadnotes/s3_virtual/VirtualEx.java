package com.example.javathreadnotes.s3_virtual;

public class VirtualEx {
    public static void main(String[] args) throws InterruptedException{
        Runnable r = () -> {
            try{
                Thread.sleep(1000);
            } catch(Exception e) {
                System.out.println("Hello");
            }
        };

//        Thread vt = Thread.ofVirtual().start(r);
        Thread vt = Thread.ofVirtual().unstarted(r); // 가상쓰레드를 생성만 한다.
        vt.setPriority(10);
//        vt.setDaemon(false); // 데몬을 false로 하면 실행오류 발생
        vt.start();

        System.out.println("vt.isVirtual() = "+ vt.isVirtual());
        System.out.println("vt.isDaemon() = "+ vt.isDaemon());
        System.out.println("vt.getPriority() = "+ vt.getPriority());
        System.out.println("vt.getName() = "+ vt.getName());
        System.out.println("vt.threadId() = "+ vt.threadId());
        System.out.println("vt.getThreadGroup() = "+ vt.getThreadGroup());
        vt.join(); // vt가 종료될 때까지 main쓰레드를 기다리게 한다
        // 가상쓰레드는 데몬 쓰레드이므로 데몬 쓰레드가 안니 쓰레드가 모두 종료되면 자동 종료된다.
    }
}
