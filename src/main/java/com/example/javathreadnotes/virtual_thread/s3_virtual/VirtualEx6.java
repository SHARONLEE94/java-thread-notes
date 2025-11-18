package com.example.javathreadnotes.virtual_thread.s3_virtual;

import java.util.concurrent.locks.ReentrantLock;

public class VirtualEx6 {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception{
        Runnable r = () -> {
            syncMethod();
            lockMethod();
        };
        Thread.ofVirtual().start(r).join();
    }


    private static synchronized void syncMethod() {
        System.out.println("[synchronized] - start");
        try{
            Thread.sleep(1_000);;
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[synchronized] - end");
    }

    private static void lockMethod() {
        System.out.println("[lock] - start");
        lock.lock();
        try{
            Thread.sleep(1_000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        System.out.println("[lock] - end");
    }
}
