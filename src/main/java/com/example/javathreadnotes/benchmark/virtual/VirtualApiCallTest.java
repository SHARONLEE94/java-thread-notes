package com.example.javathreadnotes.benchmark.virtual;

import com.example.javathreadnotes.utils.ApiClient;
import com.example.javathreadnotes.utils.StopWatch;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
* Virtual Thread로 N개 동시 호출
*
* 역할
*  1. Virtual Thread로 3000/10000/50000개 API 호출
*  2. 성능 측정
*  3. StopWatch util 사용
*
* */
public class VirtualApiCallTest {

    static final int BATCH_SIZE = 6000;   // 한 번에 보낼 요청 개수
    static final int BATCH_COUNT = 10;    // 1000개씩 10번 → 총 10000개
    static final String URL = "http://localhost:8080/mock";

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        // StopWatch 시작
        StopWatch sw = StopWatch.startNew();

        // 배치 반복 실행
        for (int batch = 0; batch < BATCH_COUNT; batch++) {
            executeBatch(batch, executor);
        }

        executor.shutdown();

        // StopWatch 종료
        sw.stop();
        System.out.println("Total Time : " + sw.getElapsedMillis() + " ms");
    }

    /**
     * 하나의 배치를 실행하는 메서드
     */
    private static void executeBatch(int batchNumber, ExecutorService executor) throws Exception {

        List<Future<String>> futures = new ArrayList<>();

        // 요청 보내기
        for (int i = 0; i < BATCH_SIZE; i++) {
            futures.add(executor.submit(() -> ApiClient.get(URL)));
        }

        // 요청 모두 완료될 때까지 대기
        for (Future<String> f : futures) {
            f.get();
        }

        System.out.println("Batch " + (batchNumber + 1) + " 완료");
    }
}
