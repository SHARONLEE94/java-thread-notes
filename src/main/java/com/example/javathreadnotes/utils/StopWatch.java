package com.example.javathreadnotes.utils;

/*
* StopWatch
*
* 코드 실행 중 원하는 위치에서 시간을 재는 기능
*
* */
public class StopWatch {
    private long startTime = 0;
    private long endTime = 0;
    private boolean running = false;

    public static StopWatch startNew() {
        StopWatch sw = new StopWatch();
        sw.start();
        return sw;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
        this.running = false;
    }

    public long getElapsedMillis() {
        return running ? System.currentTimeMillis() - startTime
                       : endTime - startTime;
    }

    @Override
    public String toString() {
        return getElapsedMillis() + " ms";
    }
}
