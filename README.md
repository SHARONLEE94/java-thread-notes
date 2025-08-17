#  java-thread-notes
## 📌 개요

이 레포는 **자바 쓰레드 학습 기록**을 정리하기 위한 공간입니다.
특히 자바의 정석 4판에서 다루기 시작한 **가상 쓰레드(Virtual Thread)** 개념을 계기로,
멀티스레드와 동시성 프로그래밍이 앞으로 성능 확장의 핵심이 될 것이라 판단하여
체계적으로 연습하고 기록하기 위해 시작했습니다.

---
## 🎯 학습 목표

- 기본 쓰레드 생성 및 실행 (Thread, Runnable)

- 쓰레드 제어 (우선순위, sleep, join, interrupt 등)

- 동기화 (synchronized, lock, wait/notify)

- 스레드 풀(Executor Framework)

- 가상 쓰레드(Virtual Thread) 개념 및 활용

---
## 📝 기록 방식
- 각 주제별 예제 코드 + 간단한 설명

- 배운 점과 주의할 점은 /notes 폴더에 정리

---
## 🚀 앞으로의 방향
- 기존 쓰레드와 가상 쓰레드 성능 비교 실험

- 실제 프로젝트 코드에 적용할 수 있는 패턴 생각

---
## 🗂️ 레포 구조 (java-thread-notes)

```text
📁 java-thread-notes/
├─ README.md
├─ notes/                      # 문제별 메모 (요약)
│  ├─ 1-thread/
│  ├─ 2-sync/
│  ├─ 3-virtual/
│  └─ 4-executor/
├─ src/
│  └─ main/java/com/example/threadnotes/
│     ├─ common/              # 공통 유틸(타이머, 로거 등)
│     ├─ s1_thread/           # 1. 쓰레드
│     │  ├─ S1_01_ProcessVsThread.java
│     │  ├─ S1_02_ThreadImpl.java
│     │  ├─ S1_03_StartVsRun.java
│     │  ├─ S1_04_SingleVsMulti.java
│     │  ├─ S1_05_Priority.java
│     │  ├─ S1_06_ThreadGroup.java
│     │  ├─ S1_07_Daemon.java
│     │  └─ S1_08_Scheduling.md         # 설명만 필요한 항목은 md
│     ├─ s2_sync/             # 2. 동기화
│     │  ├─ S2_01_Synchronized.java
│     │  ├─ S2_02_WaitNotify.java
│     │  ├─ S2_03_LockCondition.java
│     │  ├─ S2_04_Volatile.java
│     │  └─ S2_05_ForkJoin.java
│     ├─ s3_virtual/          # 3. 가상 쓰레드
│     │  ├─ S3_01_WhatIsVirtual.java
│     │  ├─ S3_02_CreateAndUse.java
│     │  ├─ S3_03_Features.java
│     │  ├─ S3_04_PlatFormVsVirtual.java
│     │  ├─ S3_05_Patterns.java
│     │  └─ S3_06_Cautions.java
│     └─ s4_executor/         # 4. Executor/ExecutorService
│        ├─ S4_01_Executor.java
│        ├─ S4_02_ThreadFactory.java
│        ├─ S4_03_ExecutorService.java
│        ├─ S4_04_ThreadPool.java
│        ├─ S4_05_Future.java
│        └─ S4_06_CompletableFuture.java
└─ pom.xml
```

---
## ✅ 진행 체크리스트
[ ] 1.1 프로세스와 쓰레드?

[ ] 1.2 쓰레드 구현과 실행

[ ] 1.3 start()와 run()

[ ] 1.4 싱글/멀티스레드

[ ] 1.5 우선순위

[ ] 1.6 쓰레드 그룹

[ ] 1.7 데몬 쓰레드

[ ] 1.8 쓰레드의 선점(스케줄링)

[ ] 2.1 synchronized 동기화

[ ] 2.2 wait()/notify()

[ ] 2.3 Lock과 Condition

[ ] 2.4 volatile

[ ] 2.5 fork & join

[ ] 3.1 가상 쓰레드란?

[ ] 3.2 가상 쓰레드 생성과 사용
 
[ ] 3.3 가상 쓰레드의 특징

[ ] 3.4 플랫폼 쓰레드 vs 가상 쓰레드

[ ] 3.5 가상 쓰레드 상태

[ ] 3.6 가상쓰레드 작성시 주의사항

[ ] 3.6 Continuation과 StackChunk

[ ] 4.1 Executor

[ ] 4.2 ThreadFactory

[ ] 4.3 ExecutorService

[ ] 4.4 스레드풀(ThreadPool)

[ ] 4.5 Future

[ ] 4.6 CompletableFuture