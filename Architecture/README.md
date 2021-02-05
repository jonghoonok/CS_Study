# Architecture

컴퓨터구조 기초부터 심화까지



참고자료

- SNUON [강의](http://etl.snu.ac.kr/local/ubonline/course_view.php?id=188304&returnurl=L2xvY2FsL3Vib25saW5lL2luZGV4LnBocD9zZWFyY2h0eXBlPTEma2V5d29yZD0lRUElQjUlQUMlRUMlQTElQjAmcGFnZT0z)
  - Computer Systems: A Programmer's Perspective 
  - Computer Organization and Design
- 그래서 컴퓨터는 어떻게 동작하나요?
- CODE



[TOC]



> 컴퓨터 시스템의 기능, 조직, 구현에 대한 법칙 및 방법을 배움: SW와 HW의 인터페이스에 대한 공부
>
> 크게 명령어 집합 구조(ISA, 기계어), 마이크로 아키텍처(파이프라이닝 기반 구현: 속도 향상), 시스템 디자인(메모리 계층구조)으로 나뉨



서울대 컴구 수업 기준 다음과 같은 내용을 다룸

- Integers and Floating Points 
- RISC-V Instruction Set Architecture 
- Sequential Architecture
- Pipelined Architecture
- Cache
- Virtual memory
- I/O
- Parallel Computer Architecture



컴퓨터 아키텍쳐는 "병렬성을 사골까지 우려내는 것"

- ISP (Instruction level parallelism)
  - 파이프라이닝
  - 슈퍼스칼라
  - out-of-order execution, branch prediction, very long instruction word 등
- DLP (Data level parallelism)
  - SIMD / Vector instructions
- TLP (Task level parallelism)
  - Simutaneous multithreading (Hyperthreading)
  - Multicore



## **1. 컴퓨터 개론**

> 컴퓨터란 무엇이고, 어떻게 탄생했으며 어떻게 구성되는가?



컴퓨터의 역사

- 주판 - 파스칼린 - 차분엔진 등을 거치며 계산기로서 점차 발전

- 계산 가능성/불가능성에 대해 연구하다가 **튜링 머신**이 탄생

  - 계산 가능성에 대한 대표적인 문제로 **정지 문제**가 존재

    - Hilbert의 결정문제(*기계적 방식* 으로 모든 수학적 증명이 가능한가)를 해결하기 위해 튜링은 이를 "튜링 머신이 유한한 시간 내에 모든 문제를 풀 방법이 있는지 알아낼 수 있는가"로 바꿈

    - "프로그램과 input이 주어졌을 때 해당 프로그램이 멈출지 판정하라"

    - 정지문제는 귀류법으로 해결

      - ```
        function Problem(string s):
        	if halt(s, s) == false:
        		return true
        	else:
        		loop
        ```

      - halt(a, b) -> 문자열 a와 프로그램 b에 대해 a를 input으로 b를 실행했을 때 정지하면 참, 무한루프를 돌면 거짓

      - Problem(Problem)의 실행이 끝난다고 가정해도, 무한히 실행된다 가정해도 모순: 정지 문제는 증명이 불가함 -> 기계적 방식으로 모든 수학적 증명을 해결하는 것은 불가

  - 튜링 머신: *기계적 방식* 을 실제로 구현한 장치로 테이프를 저장장치로 갖는 **오토마타**

    - 오토마타: 스스로 동작하는 기계
    - 테이프에는 각 cell마다 기호들이 기록되어있고 head가 이를 읽음
    - 행동표에는 기호에 따라 수행되는 행동이 기록되어 있고 CPU에 대응됨

- 1945년 폰 노이만이 stored-program architecture 제안

  - 전선의 재배치가 아닌 소프트웨어 교체를 통해 컴퓨터가 다른 명령 수행

- 60년대 IBM 시스템/360 개발

- 70년대 UNIX, C언어 개발

- 70년대 Intel 8008 프로세서 등장(모든 CPU의 아버지)

- 80년대 IMB PC 등장: Intel 프로세서 + DOS



컴퓨터 구조의 8가지 아이디어

- 무어의 법칙
  - 18~24개월마다 칩에 집적되는 소자의 수가 2배가 된다
- 추상화
  - 하위 수준의 상세한 사항을 안 보이게 함으로써 상위 모델을 단순화
  - 설계 시간을 단축하기 위해 도입
  - 예) 고급 언어(기계어의 추상화)
  - 그러나 추상화에는 한계가 있음
    - 버그의 존재
    - 구현의 근본적인 원리에 대해 알아야 할 필요성
    - **컴퓨터 구조를 알아야 하는 이유**
- Common case fast
  - 자주 발생하는 일은 조금 더 빨리 최적화하라
  - '자주 발생하는 일'의 예측이 필수적
- 병렬성
  - 큰 문제를 여러 개의 작은 문제로 나누어서 해결
  - 예) 쓰레드
- 파이프라이닝
  - 병렬성의 한 예로, 처음 단계 입력이 다음 단계출력으로 이어지는 구조
    - 화재 진압을 위해 일렬로 줄지어 양동이를 나르는 모습에서 유래함
    - 동시 처리를 통해 처리량을 향상시킴
    - 전체 단계 중 가장 시간이 오래걸리는 것의 처리 시간을 **클럭 사이클**이라 함
- 예측을 통한 성능 개선
  - 복구비용이 낮고 성공확률이 높을 경우에 효과적
  - 계산이 부정확하면 위의 조건을 만족시키지 못해 비용이 커짐
- 메모리 계층구조
  - 메모리 속도가 성능을 좌우함
  - 따라서 좋은 메모리를 사용해야 하지만 비싸기 때문에 계층구조를 통해 해결
    - 레지스터 - 캐시 - 메모리 - 디스크
    - 최근에 접한 데이터를 최상단에 위치 시킴(공간 지역성)
- 여유분을 이용한 신용도 개선
  - 신용도: 시스템을 믿을 수 있는 정도(가용성)
  - 여유분을 통해(백업) 가용성을 높임



컴퓨터의 구성요소 및 역할

- 고전적 구성요소 5가지
  - I/O
    - 입력: 데이터를 메모리에 기록
    - 출력: 메모리로부터 데이터를 읽음
  - 메모리: 데이터를 저장
  - 프로세서: 메모리로부터 명령, 데이터를 가져옴
    - 데이터패스: 산술 연산을 수행
    - 제어유닛: 다른 유닛들의 동작을 제어
- 구성요소의 역할
  - 프로세서
    - CPU
      - 두뇌와 같은 역할을 함: 명령어를 해석하고 연산하여 제어신호를 생성
      - CPU의 발전이 곧 컴퓨터 기술의 발전
    - GPU
      - 영상을 처리하는 용도: 병렬적인 수천 개의 코어를 연결
      - AI 기술발전의 선두주자
    - 프로세서의 동작
      - 제어유닛(CU)이 메모리에서 명령어를 읽어 제어신호를 생성
      - ALU(산술/논리 연산장치)는 제어신호를 받아 연산을 수행해 제어유닛에 전달
        - 연산에 필요한 데이터는 레지스터에서 가져오고 결과도 레지스터에 저장
      - 제어유닛은 전달받은 값을 주변신호에 전달: 명령어 1개의 동작 종료
  - 메모리
    - 정보를 저장했다가 필요할 때 읽어들이는 저장소
    - 레지스터의 용량이 작아서 만들어짐



현대 컴퓨터의 구조

![현대](https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Computer_system_bus.svg/1200px-Computer_system_bus.svg.png)

- Address bus
  - CPU가 메모리로 주소를 보낼 때 사용됨
  - 특정 메모리 주소에 접근하여 데이터를 쓰거나, 읽어올 때 사용
    - 쓰는지 읽는지는 Control bus를 통해서 전달됨



기계어, 어셈블리어, 고급언어

- 프로그램
  - 프로그램은 인간이 이해하는 고급언어와 기계어의 번역을 통해 만들어짐: **컴파일러**
  - 고급언어: 일반적으로 언급되는 프로그래밍 언어
    - C언어, Python, Java
    - 컴파일러가 이를 어셈블리어로 번역
    - 어셈블리어는 프로세서에 따라 달라짐(arm, x86)
  - 어셈블리어: 기계가 이해할 수 있는 **기계사고방식의 언어**
    - 어셈블리어는 다시 어셈블러를 거쳐 기계어로 번역됨
    - 작업 단위인 **instruction을 사람이 이해할 수 있게(mnemonic) 번역**한 것
  - 기계어: 기수가 2인 숫자로 구성
    - 컴퓨터가 이해할 수 있는 bit들의 집합
- HW/SW 계층
  - 시스템 소프트웨어: 프로그램과 하드웨어 사이에서 인터페이스 역할을 하는 소프트웨어
    - 어셈블러, 컴파일러, 운영체제, 로더 등
    - 자세한 내용은 운영체제 공부



CPU 성능

- 성능: 시간/리소스 대비 컴퓨터 시스템이 수행하는 작업의 양
  - 성능은 응답시간이나 처리량 등 다양한 관점에서 측정이 가능
  - 응답시간: 작업개시-종료까지의 시간
    - 디스크 접근, 메모리 접근, 입출력, 오버헤드, cpu연산 시간 등을 포함
    - 프로그램이 필요로 하는 모든 시간
  - 처리량: 단위 시간 당 처리할 수 있는 task의 양
  - 응답시간을 단축시키면 처리량 또한 증가함
- 클럭(clock)
  - 하드웨어 이벤트가 발생하는 시점을 결정
  - 클럭 주기(사이클): 연산 한 번에 걸리는 시간
    - 클럭 속도: 클럭 주기의 역수
  - 프로그램의 CPU 실행시간 = cpu클럭 사이클 수 * 클럭 주기
    - 클럭 사이클 수 = 명령어 수 * 명령어당 평균 클럭 사이클 수(CPI)
    - Clock cycle Per Instruction
      - 프로그램의 CPU실행시간 = 명령어 수 * CPI / 클럭 속도



전력

- 사용 원인
  - 트랜지스터의 스위칭: 스위칭시 소모되는 에너지 * 시간당 논리값의 변경 빈도
  - 따라서 연산이(클럭 속도) 많을 수록 전력 사용량 증가
- 문제점
  - 전압이 낮으면 트랜지스터 누설 전류 증가
    - 서버 칩의 경우 전체 전력의 40%가 **누설 전류**로 소모
  - 전력이 높으면 온도 상승으로 인한 냉각 비용 발생
    - 전력 소모량과 CPU온도는 상관관계가 있음



CPU의 발전

- 단일 프로세서에서 **멀티코어 프로세서**로 진화
- 파이프라인 구조를 채택해 병렬성을 높여 처리량 최대화
- Intel 8086
  - 최초의 16bit 프로세서: CPU의 아버지
- 80386 CPU
  - 최초의 32bit 아키텍쳐: PC의 보급화로 널리 사용됨
  - 32bit란 1클럭 당 처리할 수 있는 최대 크기가 32bit라는 뜻: 최대 메모리 4GB
- 펜티엄
  - 최초로 숫자가 아닌 이름이 붙은 CPU
  - super-scalar architecture: 파이프라인 2개를 이용해 병렬성 극대화
- 코어2
  - 펜티엄4가 발열 문제로 생산이 중단되고 최초로 멀티코어 프로세서를 도입
  - **암달의 법칙**
    - 코어 갯수에 비례하여 성능이 향상되지는 않음: 병렬화 문제 때문
    - 멀티 프로세싱에 최적화된 프로그램을 작성하지 않으면 한 코어에 쏠림
- i-시리즈
  - 오버클럭
    - 설계된 클럭속도보다 높은 클럭속도를 강제로 갖도록 하는 기술
    - FSB(중앙처리장치 외부접속 버스), CPU배수를 높여 최대 운영 주파수에 다다르게 함
  - 하이퍼스레딩
    - 하나의 코어에 또 다른 가상코어를 만들어 2개로 인식하게 만드는 병렬화 방법



CPU의 구조

![cpu](data:image/png;base64,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)

- 제어 장치
- 산술 논리 장치
- 레지스터: 명부(register) - 데이터를 등록해놓고 사용하는 용도
  - 프로그램 카운터
  - 명령어 레지스터
  - 메모리 주소 레지스터
  - 메모리 데이터 레지스터
  - 어큐뮬레이터



CPU가 일하는 방법

- ```c
  A = 3;
  B = 4;
  C = A + B
  ```

  라는 프로그램을 실행시킬 때 CPU는 다음과 같이 움직임

  - CPU가 **Program Counter**로부터 프로그램의 시작 지점을 읽음
  - 해당 주소를 **메모리 주소 레지스터**에 복사함
  - 메모리 주소 레지스터에 저장된 주소를 참조하면 `LOAD 10`이 있음(10은 A가 저장된 주소)
  - 해당 instruction을 **메모리 데이터 레지스터**에 저장
  - 메모리 데이터 레지스터에 저장된 것은 명령어(LOAD)이므로 **명령어 레지스터**로 옮김
  - PC 값이 하나 올라감
  - 명령어 레지스터에 있는 명령을 **제어 장치**에 올림
  - 제어장치는 명령어를 **decode**하여 해야할 작업을 이해함
    - 10번지에 있는 데이터를 가져와야 함
    - 메모리 주소 레지스터에 10을 넣어줌
    - 10에 있는 데이터: "3"을 메모리 데이터 레지스터에 저장
    - 메모리 데이터 레지스터에 저장된 것은 데이터(3)이므로 **어큐뮬레이터**로 옮김
  - 100번에 해당하는 작업이 끝났으니 PC를 읽어 101번 작업을 시작
    - (생략)
  - 제어장치에 `ADD 11`이 올라감
    - ALU에 어큐뮬레이터의 데이터를 옮김
    - 메모리 주소 레지스터에 11을 넣음
    - 11에서 4를 읽어와 메모리 데이터 레지스터에 넣음
    - 어큐뮬레이터에 4를 넣음
    - ALU에 4를 넣어 3+4를 수행
    - 7을 어큐뮬레이터로 옮김
  - 102번 작업 수행: `STORE 12`
    - 제어장치가 어큐뮬레이터에 있는 7을 12번지에 저장하고 종료 



## **2. 명령어**

> 컴퓨터가 하드웨어에게 일을 시키기 위한 수단

 

명령어의 실행

- 기본적으로 하향식 접근구조: 위에서 아래로 순차 실행
- 다음 명령어를 가리키는 레지스터(Instruction Pointer)를 따라 명령어가 실행됨
  - **Instruction Pointer** : 현재 실행되고 있는 프로그램의 코드가 저장된 메모리의 주소를 가리킴
    - 프로그램의 실행에 따라 자동으로 증가, 실행순서가 변경되는 제어문을 만나면 자동으로 변경
    - 직접 접근이 불가함: 임의로 변경시 프로그램이 설계 의도대로 움직이지 않을 수 있음



**명령어 집합구조(Instruction Set Architecture)**

- 프로세서가 인식해서 기능을 이해하고 실행할 수 있는 '기계어'
  - ISA는 1대1 대응되는 어셈블리어로 표현 가능함
  - MIPS, ARM, x86, RISC-V 등이 있음
- ISA의 설계
  - 프로그램과 하드웨어 사이의 인터페이스에 대한 완전한 정의/명세 필요
  - 설계시 고려 사항
    - 연산의 종류: 처리, 제어, 입출력
    - 데이터 타입: 의미, 저장방식 등
    - 명령어 형식: 명령어 구성부분을 나타내는 양식(연산 부호 유무 등)
    - 피연산자를 위한 주소지정방식(Addressing mode)
      - 피연산자의 위치를 명시하는 방법
      - 데이터를 메모리(스택, 힙)에 위치시킬지 레지스터에 위치시킬 지 고려해야 함
- Instruction Set이란?
  - CPU가 수행하는 명령들의 집합
  - ADD, JUMP, COMPARE 등



명령어의 구조(MIPS 기준)

- 실행코드(opcode)
  - 앞의 8bit: ADD 등
- 피연산자(operand)
  - 뒤의 24bit: R1, R2, R3(레지스터의 이름)



연산

- 산술연산

  - 사칙연산의 계산
  - **산술 명령어**를 기반으로 레지스터와 ALU로 산술연산을 수행
    - MIPS 산술명령어는 한 종류의 연산만 지시하고 피연산자 3개를 가짐
    - 간단히 설계하기 위해 피연산자는 반드시 3개
    - 예) `add a, b, c` : b, c를 더하여 a에 저장

- MIPS 레지스터: 연산을 위해 MIPS ISA에서 제공하는 레지스터

  - `$s`에는 변수를,`$t`에는 temp 값이나 메모리에서 불러온 값, `$v`에는 리턴값을 저장
  - sp는 stack pointer의 값을, fp는 base pointer를 저장

  - **스택 프레임**
    - 함수가 실행될 때마다 가지는 자신만의 스택 영역
    - 스택프레임의 시작점은 fp가 가리키고, 함수 종료시 리턴 주소로 복귀
    - 함수가 호출되면 스택프레임 생성하고 인자의 크기만큼 sp가 이동함



피연산자(operand)

- 정의

  - 연산을 하기위해 사용되는 상수, 레이블, 메모리 주소 등
  - 레지스터 중 일부에 할당하여 사용: `$ra`등에는 할당 불가

- 데이터 단위

  - 32bit 기준 operand의 최대 크기는 4byte: 'word'라고 표현
    - 레지스터의 단위가 word이므로 과거에는 8bit가 워드였음
    - 16bit는 half word, 8bit는 byte라고 함
    - 배열 등 복잡한 자료의 연산이 불가 - 메모리에서 불러올 필요

- 데이터 전송 명령어: 메모리에서 원하는 데이터의 주소를 참조해 값을 레지스터에 저장

  - 적재 명령어 (load word)

    - 메모리에서 데이터를 레지스터로 복사하는 데이터 전송 명령어

    - 연산자(lw) + 저장할 레지스터 + 접근에 사용할 상수 및 레지스터로 구성됨

    - 예제) `g = h+A[1];` 을 MIPS 명령어로 치환하기 (g, h, A는 $s1,s2,s3에 할당)

      - ```assembly
        lw $t0, 4($s3) # $t0 = Memory[$s3 + 4]
        add $s1, $s2, $t0
        ```

      - 전송명령어 상수 부분(4)를 offset이라 함

      - 자료구조의 시작주소를 가리키는 레지스터($s3)를 base register라 함

      - MIPS에서 시작주소는 항상 4의 배수여야 함(정렬 제약)

  - 저장 명령어 (store word)

    - 레지스터에서 메모리로 데이터를 보내는 명령

    - 연산자(sw) + 저장할 레지스터 + 메모리 주소 레지스터 및 상수(offset)의 조합

    - 예제) 다음 MIPS 명령어를 C언어로 치환해라(h는 $s1에, 배열 A는 $s3에 할당)

      - ```assembly
        lw $t0, 8($s3)
        add $t0, $s1, $t0
        sw $t0, 32($s3)
        ```

      - ```c
        A[8] = h + A[2];
        ```

- 수치연산

  - 레지스터가 아니라 상수를 사용하는 경우

  - 사용 빈도가 높은 상수를 명령어에 포함시키는 것이 좋음(common case fast)

  - 연산자: `addi`

  - 예제) `A[8] = h + 10;`을 MIPS로 치환하기 (h는 $s1, A의 베이스 레지스터는 $s3)

    - ```assembly
      addi $t0, $s1, 10
      sw $t0, 32($s3)
      ```



부호

- 이진수의 10진수 변환
  - 가장 오른쪽 비트: LSB(Least Significant Bit)
  - 가장 왼쪽 비트: MSB(Most Significant Bit)
- 음수의 표현
  - 컴퓨터는 덧셈만 가능: 뺄셈을 표현하기 위해 음수를 도입
  - 2의 보수: NOT연산(1의 보수) + 1
    - 1의 보수는 0이 2개 존재하기 때문에(진짜 0, -2^32-1) 2의 보수가 사용됨
    - 2의 보수를 취하면 MSB가 부호를 나타냄: 0이면 양, 1이면 음
  - 오버 플로우
    - 덧/뺄셈 연산결과가 처리 가능한 최대 비트수를 초과하면 발생
    - **캐리**: 가장 높은 자리에서 자리올림이 발생한 경우
      - 2의 보수연산에서는 이를 무시함



명령어의 내부표현

- 명령어의 해석: 숫자로 표현

  - 레지스터 이름도 숫자로 매핑하는 규칙 존재

    - 예) $t0 ~ $t7 == 08 ~ 15,  $s0 ~ $s7 == 16 ~ 23

  - `add $t0, $s1, $s2` 명령어를 숫자로 표현하면 0 17 18 8 0 32가 됨

    - 명령어의 각 부분을 **필드**라고 함
    - 위 형식을 **명령어 형식**이라 하고 16진수로 표현
    - op(6bit) : 명령어가 실행할 연산의 종류(연산자)
    - rs(5bit) : 첫번째 피연산자
    - rt(5bit) : 두번째 피연산자
    - rd(5bit) : 목적지 레지스터, 연산결과 저장
    - shamt(5bit) : 몇 번의 shift가 수행되었는지 
    - funct(6bit) : op코드에 표시된 연산의 구체적 종류 지정

  - 변환 예제

    - `A[300] = h + A[300]`

    - ```assembly
      lw $t0, 1200($s3)
      add $t0, $s2, $t0
      sw $t0, 1200($s3)
      ```

    - ```
      35 19 8 1200
      0 18 8 8 0 32
      43 19 8 1200
      ```

    - 연산자에 대한 기계어 변환표를 보면서 하면 쉬움



논리 명령어

- 논리연산을(AND, OR, NOR 등) 하기 위한 명령어
  - 초기 컴퓨터는 워드의 처리만 하였으나 비트 일부나 각 비트에 대한 연산의 필요성 대두
  - 논리 연산을 통해 패킹(bit -> word)과 언패킹 작업 수행 가능
- 종류
  - bit shift: `sll`, `srl`
    - 지정된 비트를 넘길 경우 최하위 비트는 버려짐
    - `sll $t2, $s0, 4`의 경우 기계어로는 `0 0 16 10 4 0`이 됨 (srl의 funct는 2)
    - shamt에 몇 비트 이동시키는지 정보가 포함됨
  - and, or, nor
    - 논리연산자는 funct만 다름: and(24) or(25), xor(26), nor(27)
    - `AND $t0, $t1, $t2` 의 경우 기계어로는 `0 9 10 8 0 24`가 됨



제어문의 명령어 구성

- 판단 기능: 컴퓨터와 단순 계산기의 차이

  - 입력 데이터나 연산 결과에 따라 다른 명령어를 실행하게 함: **조건부 분기**

  - 조건부 분기는 if-then-else로 나타남

  - MIPS에서는 branch 명령어로 조건부 분기를 표현

    - `beq register1, register2, L1` : 비교 레지스터 값이 같으면 L1으로 분기

    - `bne register1, register2, L1` : 비교 레지스터 값이 다르면 L1으로 분기

    - 예제) `if(a==b) c=d+e; else c=d-e;`

      - ```assembly
        bne $s0, $s1, Else	# bne를 쓰는 이유: 일반적으로 beq가 instruction이 많음
        add $s2, $s3, $s4
        j Exit				# jump의 약자로 무조건 분기문: 무조건 Exit으로 가라
        Else:
        sub $s2, $s3, $s4
        Exit:
        ```

- 반복문: instruction의 순환

  - 반복문도 branch를 이용하여 나타냄

  - 예제) `while(A[C]==B) C=C+1;`

    - ```assembly
      Loop:
      	sll $t0, $s2, 2		# $t0 = C<<2 : C에 4를 곱함
      	add $t0, $t0, $s0	# A[C]에 접근하기 위해 A의 시작주소에 C*4를 더함
      	lw $t1, 0($t0)		# $t0 주소에 있는 값(A[C])를 $t1에 저장
      	bne $t1, $s1, Exit
      	addi $s2, $s2, 1
      	j Loop
      Exit:
      ```

- 대소비교

  - `slt` : rs(첫번째 operand)와 rt(두번째 operand)를 비교하여 첫번째가 작으면 rd를 1로 아니면 0으로

    - ```c
      if (rs < rt) rd = 1;
      else if(rs > rt) rd = 0;
      ```

  - 부호가 없는 수끼리의 비교는 `sltu`, `sltiu`를 사용함 (unsigned 라는 뜻)



프로시저

- 정의

  - 고급언어에서의 함수와 비슷한 개념: 제공되는 인수에 따라 특정 작업을 수행하는 서브루틴
  - C언어에서는 리턴이 존재하지 않는 함수를 프로시저라고 함
  - 재사용 가능하도록 프로그램을 구조화 함

- 프로시저에 사용되는 레지스터

  - 인수 레지스터: $a0~$a3, 전달할 인수를 가지고 있음
  - 값 레지스터: $v0~$v1, 반환할 값을 가지고 있음
  - 리턴 레지스터: 복귀주소를 가지고 있음, 프로시저가 실행되기 전에 주소가 저장됨

- 프로시저 명령어

  - jal(jump-and-link instruction)
    - 프로시저 콜을 만났을 때 복귀주소를 $ra에 저장하고 프로시저가 할당된 주소로 점프
    - $ra에 저장되는 값은 PC+4 (**Program Counter**, 현재 수행중인 명령어의 주소)
  - jr(jump register)
    - $ra의 값을 가지고 복귀 주소로 돌아감
  - `jal procedure address, jr $ra`

- 실행 단계

  1. main에서 procedure call을 만남
  2. 프로시저 실행에 필요한 인수 값들을 $a 레지스터에 저장하고 복귀주소를 $ra에 저장
  3. 프로시저 시작 주소로 프로그램의 흐름이 넘어감
  4. 프로시저에서 필요한 메모리를 명시: 각각의 프로시저는 고유한 메모리 공간을 가짐(스택 프레임)
  5. 작업 수행
  6. 작업 결과인 리턴값들을 $v 레지스터에 저장
  7. $ra에 저장된 복귀주소를 이용하여 main루틴을 다시 실행

- 스택

  - 컴파일 시간에 결정되는 메모리, 주로 정적 변수 선언을 했을 때 사용됨
  - SP(Stack Pointer): 스택에 데이터가 들어가고 나올 때마다 변경됨
  - 높은주소에서 낮은주소로 생성되며 스택을 할당할 때는 sp에서 사용할 만큼의 값을 감소시킴

- 스택 프레임

  - 프로시저가 호출되면 fp는 프로시저의 첫 번째 word를 가리킴: base register의 역할
  - sp는 스택의 최하단을 가리킴
  - 재귀호출에 대비하여 스택 프레임 내부에 ra를 저장하고 다른 프로시저를 call 함

- 예제

  - ```c
    int test_procedure(int a, int b, int c, int d){
        int e;
        e = (a + b) + (c + d);
        return e;
    }
    ```

  - ```assembly
    test_procedure:
    	addi $sp, $sp, -4	# int e를 하나 선언하기 때문에 4바이트 사용
    	sw $s0, 0($sp)		# e
    	add $t0, $a0, $a1	# $t0에 (a + b)를 저장
    	add $t1, $a2, $a3	# $t1에 (c + d)를 저장
    	add $s0, $t0, $t1
        add $v0, $s0, $zero	# $v0에 계산결과($s0) 저장
        lw $s0, 0($sp)		# sp를 정리하기 위해? 저장된 값을 $s0으로 불러옴
        addi $sp, $sp, 4	# 줄어든 sp의 값을 원상복구
        jr $ra
    ```



주소지정방식

- MIPS의 5가지 주소지정 방식
  - 수치 주소지정
    - immediate 연산자, operand가 16bit 상수로 구성됨
    - 명령어의 주소 필드에 상수와 같은 데이터가 들어있어 기억장치 접근이 필요없으므로 명령어 사이클 한 개가 적음 -> 빠름
      - 16bit의 작은 상수만 표현할 수 있다는 단점 존재
  - 레지스터 주소지정
    - 명령어의 operand가 전부 레지스터
    - 주소 필드가 레지스터 번호를 나타내므로 적은 bit 수로 표현 가능
      - 데이터 저장 공간이 아주 적다는 단점 존재
  - 베이스 레지스터 주소지정
    - 주소 지정의 기준이 되는 베이스 레지스터를 기반으로 주소 필드의 offset을 더해 주소 지정
    - 메모리 자원을 사용하기 때문에 저장형식이 유연하나 느리다는 단점 존재
    - lw, sw 명령어가 해당됨
  - PC 상대 주소지정
    - PC값과 16bit주소를 더해 분기할 주소를 구함
    - 명령어에서 주소를 표현할 때는 16it만 사용 가능하므로 PC를 이용
      - PC는 레지스터이기 때문에 32bit의 길이를 가짐
    - 조건부 분기명령(bne, beq)이 해당됨
  - 의사직접 주소지정
    - 명령어 내의 26bit를 PC의 상위 비트들과 연접해 점프주소를 구함
    - j 등 무조건 분기문의 경우 6bit의 op code와 26bit의 주소를 operand로 가짐
- 32bit 상수 operand
  - MIPS에서 16bit로 표현되는 상수를 32bit로 표현하는 방법이 있는가?
  - 레지스터를 16bit씩 나누어 저장하면 됨
    - `lui` : load upper immediate 상위 16bit를 저장
    - `ori $s0, $s0, 2222` 
      - 상위 16bit만 사용해서 저장된 변수 $s0에 2222를 OR연산하여 저장
      - 하위 16bit에 상수가 들어가고, 상위 16bit엔 원래 정보가 남는 효과



## **3. 사칙연산**



곱셈

- 피승수, 승수, 곱이라는 요소가 필요
  - 피승수(multiplicand): 곱함을 당하는 수
  - 승수(multiplier): 곱하는 수
  - 곱(product): 곱셈의 결과 값



## **4. 프로페서**



## **5. 메모리 계층구조**



