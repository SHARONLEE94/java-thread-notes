package com.example.javathreadnotes.mockserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* 외부 API 역할을 하는 Mock 서버
*
* 외부 API는 보통 네트워크 지연이 있기 때문에 sleep으로 I/O 블로킹을 흉내기 위한 코드
* */
@RestController
public class ExternalApiController {
    @GetMapping("/mock")
    public String mock() throws InterruptedException {
        Thread.sleep(50);
        return "ok";
    }
}
