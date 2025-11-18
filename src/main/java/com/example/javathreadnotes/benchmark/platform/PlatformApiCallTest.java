package com.example.javathreadnotes.benchmark.platform;

import com.example.javathreadnotes.utils.ApiClient;
import com.example.javathreadnotes.utils.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class PlatformApiCallTest {

    static final int CALL_COUNT = 1000;
    static final String URL = "http://localhost:8080/mock";

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(200);

        // StopWatch 시작
        StopWatch sw = StopWatch.startNew();

        // 부하테스트 메서드 호출
        runPlatformLoadTest(executor);

        executor.shutdown();

        // StopWatch 종료
        sw.stop();
        System.out.println("Platform Threads: " + sw.getElapsedMillis() + " ms");
    }

    /**
     * 플랫폼 스레드 부하 테스트 수행
     */
    private static void runPlatformLoadTest(ExecutorService executor) throws Exception {

        List<Future<String>> futures = new ArrayList<>(CALL_COUNT);

        // 요청 생성
        for (int i = 0; i < CALL_COUNT; i++) {
            futures.add(executor.submit(() -> ApiClient.get(URL)));
        }

        // 요청 완료 대기
        for (Future<String> f : futures) {
            f.get();
        }
    }
}