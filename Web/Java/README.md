# Java



참고자료

- 이것이 자바다
- fastcamp 한번에 끝내는 Java/Spring 웹 개발 마스터 패키지
- Softbank 신입사원 OJT



[TOC]

## **1. 자바 기초**

> 자바 관련 개념 및 기초 문법



### 1.1. 자바란?



자바의 특징

- 안정적임
  - 시스템 메모리를 건드려 다운될 수 있는 C와 달리 안정적인 언어의 필요성에 의해 개발됨
- 플랫폼에 영향을 받지 않음
  - OS에 따라 다른 컴파일러와 실행 파일을 갖는 C와 달리 가상머신(**JVM**) 상에서 돌아가기 때문에 플랫폼에 독립적
- **객체 지향 언어**임



객체 지향이란?

- Object Oriented Programming
- **객체**간의 관계와 협력을 기반으로 프로그래밍 하는 것
  - 시간 순으로 프로그래밍 하는 것은 **절차 지향**(procedural prigramming)
- 장점
  - 재사용성, 유지보수, 코드 관리, 고신뢰성



자바가 주로 사용되는 곳

- 웹 서버 구현
- 안드로이드 프로그래밍



실행 환경 관련

- 패키지 이름은 소문자로만
  - 프로젝트랑 클래스는 PascalCase
- 클래스 실행
  - 저장하면 자동으로 빌드가 되어 class 파일이 생성됨 -> 실행되는 것은 class 파일



### 1.2. 변수와 자료형



변수란?

- 변화하는 수: 변화하는 값을 나타낼 때 필요함
- 표현하려는 수에 맞는 데이터 타입을 이용하여 변수를 **선언**



변수의 선언

- **자료형** + 변수명으로 선언
- 변수명은 다음의 규칙을 따라야 함
  - 숫자로 시작하면 안됨
    - 숫자는 애초에 안 넣는 것이 좋음
  - 자바의 reserved word를 사용하면 안 됨(while 등)
  - 가독성 좋게: camelCase를 준수



자료형

- 변수는 선언될 때 해당하는 **자료형의 크기만큼 메모리가 할당됨**
- 종류
  - 정수
    - byte, short, int(기본)
    - long: 선언하고 숫자 뒤에 **L을 붙임**
  - 실수
    - float : 선언하고 숫자 뒤에 **F를 붙임**
    - double: 실수는 기본적으로 double
  - 문자
    - char: 문자열과는 다르다!
    - **문자는 `'A'`로 선언**하고 문자열은 `"A"`로 선언함



상수

- 변하지 않는 수
  - 변하지 않는 값을 반복하여 사용할 때
  - 값을 변경할 수 없기 때문에 **초기화를 해주지 않으면 오류 발생**
- final 예약어를 이용하여 선언
- 대문자와 언더바를 이용하여 이름을 선언함
  - `final MATH_PI;`



리터럴

- 프로그램에서 사용하는 숫자, 문자, 논리 **값**을 뜻함
- 리터럴은 **상수 풀 constant pool**에 존재함
  - **Data 영역**이라고도 함
  - 프로그램이 실행되자마자 메모리에 올라와서 종료될 때까지 존재함
- 정수 리터럴은 int, 실수 리터럴은 double로 저장됨



형변환

- 서로 다른 자료형 간의 연산 등을 하기 위해 하나의 자료형으로 **통일**하는 것
- 묵시적(자동) 형 변환
  - 바이트 크기가 **작은 자료형에서 큰 자료형으로 형 변환은 자동**으로 이루어짐
  - 덜 정밀한 자료형(정수)에서 더 정밀한 자료형(실수)으로 형 변환은 자동으로 이루어짐
  - double에서 int로 형 변환하면 소숫점 아래 부분은 짤림(truncate)
- 명시적(강제) 형 변환
  - 변수 명 앞에 괄호 치고 타입을 써 주면 강제 형 변환



### 1.3. 연산자



항과 연산자

- 항(operand): 연산에 사용되는 값
- 연산자(operator): 항을 이용하여 연산하는 기호



대입 연산자

- 이항 연산자: 변수에 다른 변수나 값을 대입하는 연산자 `=`
- 왼쪽을 l value, 오른쪽을 r value라 하며 오른쪽엔 변수, 식, 값이 들어감
- 이항 연산자 중 **가장 우선순위가 낮음**
  - 오른쪽에서 모든 계산을 다 수행하고 마지막에 대입해야 하기 때문



부호 연산자

- 단항 연산자: 변수의 부호를 유지하거나(+) 바꿈(-)
- 변수의 내용물의 부호가 바뀌는 것은 아님: 그러려면 대입 연산자 사용해야 함 `num = -num;`



산술, 관계 연산자: pass



논리 연산자

- `&&` : and
- `||` : or
- `!` : not
- **short circuit evaluation**(단락 회로 평가)
  - &&에서 앞의 항이 false이면 뒤는 보지 않음(수행되지 않음)
  - ||에서 앞의 항이 true이면 뒤는 보지 않음



비트 연산자

- 마스크: 특정 비트를 가리고 몇 개의 비트 값만 사용할 때
  - 비트 켜기: 특정 비트들만 1로 설정해서 사용
    - 예) `&00001111` : 하위 4비트 중 1인 비트만 꺼내기
  - 비트 끄기: 특정 비트들만 0으로 설정해서 사용
    - 예) `|11110000` : 하위 4비트 중 0인 비트만 0으로 만들기
- 나머지 bit shift나 and, or not은 C와 동일



연산자 우선순위

- 일차식(괄호) → 단항 → 산술 →  비트 이동 → 관계 → 비트 → 논리 → 조건(3항) → 대입



### 1.4. 제어문



#### 조건문

if문 

 ```java
if(conditional statements) {
    statement1;
}
else if(conditional statements 2){
    statement2;
}
else{
    statement3;
}
 ```

위처럼 **한 줄만 쓸 때는 중괄호를 쓰지 않아도 됨** (들여쓰기 해서 나쁠 것 없으니 웬만하면 쓰자)



switch-case 문

- 전통적인 방식

  - ```java
    int day;
    switch(month) {
    	case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
    		day = 31;
    		break;
    	case 2: day = 28;
    		break;
    	case 4: case 6: case 9: case 11: 
    		day = 30;
    		break;
    	default:
    		System.out.println("존재하지 않음");
    		day = -1;
    }
    ```

- yield 키워드를 사용한 새로운 방식

  - ```java
    int day = switch(month){
            case 1, 3, 5, 7, 8, 10, 12 ->
                yield 31;
            case 4, 6, 9, 11 ->
                yield 30;
            case 2 ->
                yield 28;
            default -> {
                System.out.println("존재하지 않음")
                yield -1;
            }
    };
    //마지막 세미콜론에 주의
    ```

  - Java 14부터 사용 가능



#### 반복문

for문

```java
for(초기화; 조건문; 증감식){
    statement;
}
```

- 초기화, 조건문, 증감식 안에 여러 식이 들어갈 수 있음
  - 세미콜론으로 구분하여 넣으면 됨
  - `for(int i = 0, int count = 0; i < 10; i++, count++)` 이런 식으로
- 초기화식, 조건식, 증감식은 각각 생략 가능함
  - 모두 생략 시 무한 루프 	



while, do-while, for문 의 비교

- while은 조건의 결과나 변수가 true, false인 경우에 주로 사용
  - 수행문을 먼저 할지 나중에 할지에 따라 while, do-while 중 무엇을 할지 결정할 것
- for는 특정 수의 범위나 횟수와 관련하여 반복되는 경우(배열 관련)에 주로 사용



## **2. OOP 개론**



### 2.1. 객체와 클래스



객체란?

- 사전적 의미 : 의사나 행위가 미치는 대상
- 구체적, 추상적 **데이터의 단위**



객체 지향 프로그래밍 vs 절차 지향 프로그래밍

- 객체 지향 프로그래밍
  - **객체 사이의 interaction에 따라 프로그래밍**
    - 학생 객체 - 세면대 객체 - 밥 객체 - 버스 객체들 간에 상호작용
    - 객체의 정의 -> 각 객체가 제공하는 기능 구현 -> 메세지 전달을 통해 상호작용 구현
- 절차 지향 프로그래밍
  - **시간이나 사건 흐름에 따라 프로그래밍**
  - 일어난다 - 씻는다 - 밥먹는다 - 버스 탄다
- 절차 지향의 구현이 쉬워보이나 프로그램이 복잡해지면 객체 지향이 훨씬 간단



객체와 클래스

- **클래스는 객체의 blueprint**다
  - 각 객체가 가지는 속성을 클래스의 **멤버 변수**로 선언함
  - 프로그램을 짜기 전에 필요한 객체들을 정의하고, 각각을 클래스로 설계함
    - 클래스를 만든다는 것은 **추상화 작업**
    - 학생 클래스, 주문 클래스, 회원 클래스...
- 클래스 코딩
  - 클래스 이름은 PascalCase
    - 멤버 변수와 메서드는 camelCase
  - **하나의 java 파일에는 하나의 public 클래스가 있어야** 하며 파일명과 클래스명이 동일해야 함
    - 하나의 자바 파일 안에 클래스가 여러 개 들어갈 수 있지만 `public class` 는 하나 뿐



함수와 메서드

- 함수란?

  - **하나의 기능을 수행**하는 일련의 코드

  - 정의된 함수는 **호출하여 사용하고, 기능이 끝나면 제어가 반환됨**

    - 함수는 여러 곳에서 동일한 방식으로 호출되어 사용될 수 있음
    - 함수가 호출되면 **스택**에 함수가 사용할 메모리 공간이 생성되고, 지역 변수가 저장됨
    - 함수가 끝나면 메모리 공간이 해제되면서 반환

  - 함수의 정의: 반환 값 + 이름 + 매개 변수 + 함수 몸체

    - ```java
      int add(int num1, int num2){
          int result;
          result = num1 + num2;
          return result;
      }
      ```

- 메서드란?

  - 객체의 기능을 구현하기 위해 **클래스 내부에 구현되는 함수**
    - 멤버 변수를 매개 변수로 사용하여 멤버 함수라고 하기도 함
  - 메서드 이름은 객체에 맞춰서 지음
    - 예) `getStudentName()` 



인스턴스

- **특정 클래스 기반으로 생성된 객체**를 클래스의 인스턴스라고 함
  - 인스턴스는 해당 클래스의 멤버 변수, 메서드를 사용할 수 있음
  - 생성은 `new 생성자()`로 함
- 생성된 인스턴스는 **heap에 할당됨**
  - 하나의 클래스는 여러 인스턴스를 생성할 수 있는데, 각각 다른 메모리 주소를 가리키기 위해 힙 사용
  - 사용되지 않는 인스턴스는 GC가 자동으로 메모리에서 해제함
  - 메모리에 생성된 인스턴스를 가리키는 변수를 **참조 변수**, 해당 메모리 주소 값을 **참조 값**이라 함



생성자

- 어떤 클래스에서 **인스턴스를 생성하는 함수**를 생성자라고 함

  - 클래스에는 반드시 하나 이상의 생성자가 있고, 구현하지 않으면 컴파일러가 **기본 생성자**를 넣음
    - 생성자가 있는데 기본 생성자를 호출하면 에러: 만들어줘야 함
  - 기본 생성자는 매개 변수가 없고 그냥 인스턴스를 선언만 함: 나중에 값을 넣어줘야 함
    - 초기화는 되어 있는데 기본 값으로 되어 있음(int면 0): 지역 변수와 달리 **멤버변수는 생성되면 초기화는 됨**
  
- 생성자 만들기

  - **this**의 이해

    - this는 **인스턴스 자신의 메모리를 가리킴**

      1. 생성자는 파라미터로 들어온 값을 이용해 인스턴스를 만든다
      2. 그런데 일반적으로 파라미터는 멤버 변수와 이름을 동일하게 지음
      3. `studentNumber = studentNumber`와 같은 상황이 발생
      4. this를 붙여서 **"이"** 인스턴스의 멤버변수에 파라미터 studentNumber를 대입한다는 의미를 부여
      5. `this.studentNumber = studentNumber`

    - 생성자 내에서 또 다른 생성자를 호출할 때 사용

    - 자신의 주소를 반환할 때 사용

      - ```java
        public Person getPerson(){
            return this;
        }
        ```

  - 생성자 **오버로딩**

    - **메서드는 같고 매개변수가 다른 것**을 오버로딩이라 함
    - 클라이언트 코드(생성자를 호출하는 코드)에서 여러 생성자 중 필요에 따라 호출할 수 있음



참조 자료형 변수

- 변수의 자료형은 다음과 같이 분류됨
  - 기본 자료형(int, long, float, double) 등: 메모리 크기가 정해져 있는 타입
  - 참조 자료형(String, Date, UserClass): 클래스에 따라 메모리 크기가 다름
    - 참조 자료형을 사용할 때는 해당 변수에 대해 객체를 생성해야 함(String 제외)
- 참조 자료형 변수의 사용
  - **하나의 클래스에 정보가 너무 많이 들어가지 않도록** 클래스를 분리하여 해당 클래스의 객체를 사용
  - 예) 학생의 과목별 성적: 학생 클래스 + 성적 클래스로 분리하고 학생이 성적 객체(의 배열)을 가짐



객체 협력 collaboration

- 객체 간에 필요한 메세지를 전송하고 처리하는 것
  - 예) 학생 객체가 버스 객체에 탑승하여 버슷 객체의 승객 수가 변화
- **매개 변수로 객체가 전달**될 수 있음



### 2.2. OOP의 요소



#### 캡슐화



캡슐화란?

- 변수와 함수를 하나의 단위로 묶는 것
  - 데이터의 번들링(Bundling)
  - 자바에서 번들링은 클래스를 통해 구현되고, 클래스의 인스턴스 생성을 통해 클래스 안에 포함된 멤버 변수와 메소드에 접근



정보은닉

- **꼭 필요한 정보와 기능만 외부에 오픈하는 것**
  - 프로그램(클래스)의 세부 구현을 외부로 드러나지 않도록 감춤
  - 대부분의 멤버 변수와 메서드를 감추고 외부에 통합된 인터페이스만 공개하여 일관된 기능을 제공함
- 정보 은닉의 필요성
  - 메서드와 멤버 변수에 접근할 때 발생하는 오류를 최소화
  - 유연함과 유지보수성을 높임
    - 모듈 내에서의 응집도는 높이고
    - 모듈 간의 결합도는 떨어뜨림
- 정보 은닉을 위해 **접근 제어 지시자**가 사용됨



접근 제어 지시자

- **클래스 외부에서 클래스의 멤버 변수, 메서드, 생성자를 사용할 수 있는지** 지정하는 키워드
  - default: 지정하지 않으면 디폴트로 같은 패키지에서만 접근 가능
  - public: 어디에서나 접근 가능
  - private: **같은 클래스 내부에서만** 접근 가능
  - protected: **같은 패키지나 상속관계의 클래스에서** 접근 가능
- private으로 제어한 멤버 변수 어떻게 접근하는가? **get, set**
  - private으로 제어된 멤버 변수에 대해 접근/수정할 수 있는 public method
  - 예) month의 값이 1부터 12 사이일 때만 set 가능하게 함



#### 상속

상속이란?

- 자식 클래스가 **부모 클래스의 특성과 기능을 그대로 물려받는 것**
  - 기능의 일부분을 변경해야 할 경우 '**오버라이딩(Overriding)**'을 함
  - 자식 클래스에서 상속받은 그 기능만을 수정해서 다시 정의하는 것
- 상속은 캡슐화를 유지하면서도 클래스의 재사용이 용이하도록 해 줌



#### 다형성

하나의 변수, 또는 함수가 상황에 따라 다른 의미로 해석될 수 있는 것

자세한 내용은 OOP 심화 참조



### 2.3. 클래스와 변수



static 변수란?

![static](https://gitlab.com/easyspubjava/javacoursework/-/raw/master/Chapter2/2-16/img/mem.png)

- 여러 인스턴스에서 **공통으로 사용하는 변수**
  - 여러 인스턴스가 공유하는 기준 값이 필요한 경우 사용
  - 예) 학번, 카드 번호, 사원 번호 등
  - 프로그램이 메모리에 로딩될 때 Data(Static)영역에 할당됨
- 선언과 사용
  - `static int serialNum;`
  - 클래스 변수, 정적 변수라고도 함
    - **클래스 이름으로 직접 참조** `Student.serialNum = 100;`
    - 인스턴스 이름으로도 참조할 수 있긴 한데 권장하진 않음



static 메서드

- 인스턴스 생성과 무관하게 클래스 이름으로 호출 가능함
  - **static 메서드 내부에서는 멤버 변수 사용이 불가능**하게 되어 있음
  - 인스턴스 생성 전에 static 메서드가 호출될 수 있기 때문



변수의 Scope와 메모리

![scope](https://gitlab.com/easyspubjava/javacoursework/-/raw/master/Chapter2/2-17/img/variable.png)

- 멤버 변수는 적게 하는 것이 좋음
  - 너무 많으면 인스턴스 생성 시 메모리를 많이 차지
  - 너무 적어도 문제인데, 필요할 때마다 인자로 전달해야해서 복잡해짐
- static 변수에 큰 자료형은 피하는 것이 좋음
  - 배열 등 메모리를 많이 먹는 자료형이 계속 메모리를 점유하고 있으면 안 됨



static의 활용: Singleton Pattern

- 디자인 패턴이란?
  - 어떤 방식으로 OOP에 적합하고 효율적이고 재사용이 용이하게 코딩할 것인지 정리한 것
  - 23가지 종류가 있음
- 싱글톤 패턴이란?
  - 프로그램 내에서 **인스턴스가 단 한 개만 생성되어야 하는 경우** 사용하는 디자인 패턴
  - static 변수와 메서드를 활용하여 구현
  - 회사-사원 등 1:N 관계를 갖는 객체를 구현할 때 좋음
- 싱글톤 패턴의 구현
  - 인스턴스를 1개만 만들 수 있도록 **생성자를 private으로 만들어야 함**
  - 생성자 구현 안 하면 default constructor가 생기는데 이건 public이라 까먹지 말고 구현해야됨



클래스 다이어그램

*cf) UML notation?*

![클래스 다이어그램](https://gitlab.com/easyspubjava/javacoursework/-/raw/master/Chapter2/2-18/img/singleton.png)

- 맨 위는 클래스 이름
  - 아래는 순서대로 변수, 생성자, 메서드
- `-`는 private이라는 뜻, `+`는 public이라는 뜻



## **3. OOP 핵심**

> 클래스 간의 관계, 인터페이스를 어떻게 설계할 것인가?
>
> 객체 지향이 왜 유지보수에 좋은지?



### 3.1. 상속



상속이란?

- 상위 클래스의 기능(메서드), 속성을 받아서 확장하는 것을 상속이라 함
- A클래스를 B클래스가 상속받는다면
  - `class B extends A { ... }`
  - A를 상위 클래스(super class), B를 하위 클래스(subclass)라고 함
  - **상위 클래스는 단 하나만 존재**할 수 있음
    - **모호성을 방지**하기 위함: Java는 초기부터 안정성, 심플함을 추구함
    - Diamond Problem 참조
  - 상위 클래스가 하위 클래스보다 일반적인 개념과 기능을 가짐 



상속은 언제 사용하는가?

- **Is-A 관계**
  - 일반적 개념 - 구체적 개념 (예: 고객 - 골드 고객)의 관계가 존재할 때 **상속함**
  - 하위 클래스에서 상위클래스에 구체적인 개념들을 더해 나감
  - 계층 구조가 복잡하거나 depth가 크면 좋지 않음
- Has-A 관계
  - 클래스가 다른 클래스를 포함 (예 : 학생이 과목을 포함)
  - 코드 재사용의 일반적인 방법임: 여기서는 **상속하지 않음**
  - 라이브러리를 구현할 때 ArrayList 생성하여 사용함



상속 클래스 생성

- private과 protected
  - 외부에서는 참조 못하지만 상속받은 하위 클래스에서는 참조할 수 있도록 protected를 이용함
- `super()`
  - 하위 클래스에서 **상위 클래스의 기본 생성자를 호출**함
    - 생성자를 작성하지 않으면 컴파일러가 기본 생성자를 만들듯이 하위 클래스의 생성자에는 자동으로 super()가 들어감
    - 이 때 상위 클래스에는 반드시 기본 생성자가 존재해야 하고, 기본 생성자 없이 다른 생성자만 있다면 하위 클래스에서 super()를 이용해 명시적으로 상위 클래스의 생성자를 호출해야 함
    - super()를 이용해 상위 클래스의 메서드 및 멤버 변수에 접근 가능
- 상속이 일어날 때 메모리의 상태
  - 힙 메모리에 상위 클래스의 인스턴스가 생기고 그 밑에 하위 클래스의 속성이 추가됨
  - ![상속 메모리](https://gitlab.com/easyspubjava/javacoursework/-/raw/master/Chapter3/3-03/img/memory.png)
- 상속과 **형 변환**
  - 상위 클래스로 변수를 선언하고 하위 클래스 생성자로 인스턴스 생성이 가능함
    - `Customer vc = new VIPCustomer();`
    - 이걸 업캐스팅이라고 하며, 역은 성립하지 않음(모든 Customer가 VIPCustomer는 아니므로)
    - **업캐스팅**한 다음 다시 자기 클래스로 형 변환 가능한데, 이는 **다운 캐스팅**이라 함
    - 물론 업캐스팅한 인스턴스는 **하위 클래스의 속성과 메서드 사용 불가**함



다운캐스팅

- 업캐스팅된 인스턴스를 다시 **원래의 타입으로** 형 변환 하는 것

  - 업캐스팅은 Implicit하게 변환되지만 다운캐스팅은 명시적으로(explicit) 해야 함

  - ```java
    Customer vc = new VIPCustomer();              //묵시적
    VIPCustomer vCustomer = (VIPCustomer)vc;      //명시적
    ```

  - 당연한 얘기지만 VIPCustomer를 Customer로 업캐스팅한 뒤 GoldCustomer로 다운 캐스팅은 불가

- `instanceof` 키워드

  - 원래 인스턴스 타입이 맞는지 체크하는 키워드
  - 체크하지 않은 채로 Customer로 업캐스팅된 VIPCustomer를 GoldCustomer로 다운 캐스팅하려고 하면 에러 발생
  - **다운 캐스팅을 하기 전에는 반드시 instanceof로 체크**를 할 것



#### Overriding

- **재정의** 라는 뜻 : 상위 클래스에서 구현된 코드를 하위 클래스에서 재정의 하는 것
  - 메서드나 생성자에 대해서 가능
  - 상위 클래스에 정의된 메서드의 구현 내용이 하위 클래스에서 구현할 내용과 맞지 않는 경우
  - 이클립스에서 우클릭 > Source > Override로 구현 가능
- Annotation
  - 오버라이딩한 메서드 위에는`@Override`가 붙음
  - 컴파일러에게 정보를 주는 위 표기법을 annotation이라 함

**가상 메서드**

- 인스턴스를 업캐스팅하고 오버라이딩된 메서드를 호출하면 **하위 클래스의 메서드가 호출됨**
  - 왜? **자바의 모든 메서드는 가상 메서드**로, **항상 인스턴스의 메서드가 호출**되기 때문
  - 업캐스팅하는 경우 변수 vc의 타입은 Customer이지만 인스턴스의 타입은 VIPCustomer임

- 가상 메서드 원리
  - ![가상 메서드](https://gitlab.com/easyspubjava/javacoursework/-/raw/master/Chapter3/3-05/img/virtual.png)
  - 메서드는 Code영역에 저장되고, 메서드의 이름은 그 주소값을 나타냄
  - 각 클래스는 **가상 메서드 테이블**(자신이 갖는 메서드의 주소 테이블)을 가짐
  - 하위 클래스로 생성된 인스턴스는 오버라이딩된 메서드의 주소를 갖기 때문에, 업캐스팅을 하더라도 하위 클래스의 메서드를 호출함



### 3.2. 다형성



다형성이란?

- 하나의 변수, 또는 함수가 상황에 따라 다른 의미로 해석될 수 있는 것
  - 하나의 코드가 여러 자료형으로 구현되어 실행
  - animal.move() 예제: 다른 클래스가 동일한 타입인 것처럼 쓰이지만 실제 동작은 각각 다르게 일어남
- 다형성을 잘 활용하면 유연하고 확장성있고, 유지보수가 편리한 프로그램을 만들수 있음
  - 다형성을 쓰지 않으면 코드 확장을 할 때 if-else문을 계속 추가해야 함
  - 이를 피하기 위해 **상위 클래스에서 공통적인 부분을 제공하고 하위 클래스에서 각 클래스의 기능을 구현**
  - 한 클래스에 조건분기가 너무 많으면 리팩토링을 통해 클래스를 나누는 것을 권장



다형성의 종류

- 서브타입 다형성(Subtype Polymorphism / Inclusion Polymorphism / Subtyping)
  우리가 일반적으로 접하는 OOP의 그것. 기초 클래스 또는 어떠한 인터페이스를 구현하는 상위 클래스를 생성하고, 해당 클래스를 상속받는 다수의 하위 클래스들을 만들어 상위 클래스의 포인터나 참조변수 등이 하위 클래스의 객체를 참조하게 하는 것이다. 이 때 각각의 하위 클래스는 상위 클래스의 메소드 위에 자신의 메소드를 덮어쓰는 메소드 오버라이딩(Method overriding)을 수행하며, 상위 클래스의 참조변수가 어떤 하위 클래스의 객체를 참조하느냐에 따라 호출되는 메소드가 달라진다.[[3\]](https://namu.wiki/w/객체 지향 프로그래밍#fn-3) [Java](https://namu.wiki/w/Java), [C++](https://namu.wiki/w/C%2B%2B), [C#](https://namu.wiki/w/C%23), [Python](https://namu.wiki/w/Python), [Ruby](https://namu.wiki/w/Ruby) 등의 객체 지향 언어들은 기본적으로 지원하는 개념.
- 매개변수 다형성(Parametric Polymorphism)
  타입을 매개변수로 받아 새로운 타입을 되돌려주는 기능이다. 타입 매개변수를 정의한 클래스 혹은 메소드는 사용할 때 매개변수에 타입을 지정하게 되며, 컴파일 시 지정한 타입에 따라 해석된다.
  - 템플릿(Template)
    C++에서 사용하는 개념으로, 타입 매개변수를 입력한 타입으로 치환한 코드를 생성하는 방식이다. 타입 뿐 아니라 변수도 입력할 수 있으며, 객체 내부에서 연산이나 함수 호출을 할 수 있지만, 해당 연산이나 함수가 정의되지 않은 타입을 매개변수로 넣으면 컴파일 에러가 발생하며 컴파일이 느려지고 파일이 커진다.
  - 제네릭(Generic)
    Java와 C# 등에 도입된 개념으로, 지정한 타입 매개변수에 해당하는 타입만을 사용하겠다고 약속하는 방식이다. 타입 매개변수가 특정 객체를 상속할 경우 상속하는 객체의 함수는 호출할 수 있지만 그렇지 않을 경우 타입 매개변수로 지정된 객체의 멤버에는 접근할 수 없다.
- 임시 다형성(Ad hoc Polymorphism)
  - 함수 오버로딩(Function overloading)
    C++과 C#, Java에서는 함수 오버로딩을 통해 동일한 이름의 함수를 매개변수에 따라 다른 기능으로 동작하도록 할 수 있다. 함수 오버로딩을 너무 많이 사용하면 전체적인 코드의 유지보수가 어려워지므로, 템플릿 또는 제네릭으로 대체하는 것이 일반적이다.
  - 연산자 오버로딩(Operator overloading)
    C++, C# 등에서는 연산자를 오버로딩해서 기본 연산자가 해당 클래스에 맞는 역할을 수행하게 하는 것이 가능하다. Java에서는 연산자의 오버로딩이 불가능하다. Perl 6나 Smalltalk, F#, Kotlin 등 연산자의 신규 정의가 가능한 언어도 있다.
- 강제 다형성(Coercion Polymorphism)
  - 묵시적 형 변환(Implicit type coercion)
    'double a = 30;'이라는 식이 실행되면 int형 값 30은 double로 묵시적 형 변환이 이루어진다. double은 int보다 크기가 큰 자료형이므로, 이러한 형 변환을 자료형 승급(Type promotion)이라고 한다. C++의 변환 생성자에 의한 형 변환도 묵시적 변환에 속하며, 이를 막으려면 생성자 앞에 explicit 키워드를 추가해야 한다.
  - 명시적 형 변환(Explicit type coercion)
    'double a = (double)30;'이라는 식은 위와 동일한 결과를 내지만, (double)을 통해 int형 값 30이 double형으로 변환됨을 명시적으로 표현하였다.



### 3.3. 추상클래스, 인터페이스



#### 추상 클래스

추상 클래스란?

- **추상 메서드를 포함한 **클래스

  - 추상 메서드란 구현부(body) 없이 선언만 된 메서드: 앞에 abstract를 붙여서 구분함

    - 반대로 추상 메서드가 없는 클래스는 Concrete Class라 함

  - ```java
    int add(int x, int y); // 선언 
    int add(int x, int y){ } // 구현부가 있음, 추상 메서드 아님
    ```

  - 추상 메서드를 선언하면 eclipse가 body를 추가하거나 abstract를 추가하라고 함

    - abstract를 추가하면 추상 메서드가 되기 때문에, 클래스에도 abstract를 추가하라고 함

  - 추상 클래스는 **new로 인스턴스를 생성할 수 없음**

    - 왜?
    - 추상 메서드를 다 구현했어도 클래스 앞에 abstract가 붙으면 new로 생성 불가

- 추상 클래스, 추상 메서드는 클래스 다이어그램에서 이탤릭체로 표현함

  - ![추상](https://gitlab.com/easyspubjava/javacoursework/-/raw/master/Chapter3/3-09/img/notebook.png)

- 추상 클래스의 필요성

  - **상속만을 하기 위해** 만들어진 클래스임



템플릿 메서드 패턴

- 전체 일을 수행하는 구조는 바꾸지 않으면서 특정 단계에서 수행하는 내역을 바꾸는 패턴
  - "특정 단계"에 해당하는 작업을 처리하는 부분을 **서브 클래스로 캡슐화**해서 구현
  - 추상 클래스를 활용하여 캡슐화
  - 프레임워크에서 굉장히 많이 사용되는 설계 패턴임
- 템플릿 메서드
  - abstract 메서드 + concrete 메서드를 이용하여 코드의 흐름을 정의하는 메서드
  - final로 선언하여 **하위클래스에서 재정의할 수 없게 함** : 변하면 안 되는 시나리오(템플릿)기 때문
  - 템플릿 메서드에 포함되는 추상 메서드들은 하위 클래스에서 구현
    - 꼭 추상 메서드가 아니더라도 하위 클래스에서 재정의해서 쓰기도 함



#### 인터페이스

인터페이스란?

![interface](https://gitlab.com/easyspubjava/javacoursework/-/raw/master/Chapter3/3-15/img/book.png)

- **추상 메서드만으로 구성된** 클래스
  - 자바 8 이후에 default method와 static method가 제공되면서 일부 구현 코드도 들어가게 되었음
  - 하지만 인터페이스 메서드를 선언하면 기본적으로 public abstract가 됨
- 인터페이스는 **클래스에 의해 구현됨**
  - 상속이랑은 다름: 상속은 `extends`, 구현은 `implements`
    - `public abstract class Calculator implements Calc{ ... }`
  - 모든 추상 메서드를 다 구현하면 (fully implemented) 추상 클래스가 아니지만, 일부분만 구현하면 추상 클래스가 됨
- 인터페이스는 **다중 상속**이 가능
  - 한 클래스가 여러 인터페이스를 구현할 수 있음
  - 정확히는 상속이 아니기 때문에 "여러 타입을 내포할 수 있다"라고 함
    - 타입 상속이라고도 함: `Calculator`는 `Calc` 타입이다
- 클래스는 왜 다중 상속이 안 될까?
  - **Diamond Problem**
  - 추상 클래스 a에 추상 메서드 aa가 있고, 클래스 b와 c가 이를 각각 구현했다고 할 때 클래스 d가 b, c를 상속한다면 d에서 aa를 어떻게 호출해야 되는가?
  - 이런 모호성 때문에 자바에서는 클래스의 다중 상속을 막았음
  - **인터페이스는 구현이 안 되어있기 때문에 다중 상속(정확히는 구현)이 가능**한 것
- 인터페이스의 상속은 클래스 다이어그램에서 점선으로 표현함



인터페이스의 필요성

- 인터페이스가 하는 일
  - 클래스나 프로그램의 기능을 명시적으로 선언: 명세(specification)라고 할 수 있음
  - 클라이언트 코드가 서비스의 구현을 알 필요 없이 **메서드의 명세만 보고 사용**할 수 있도록 함
    - 예) 리모콘을 쓸 때 기능만 알고 쓰지 작동 원리는 모르는 것처럼
- 인터페이스의 사용
  - 어떤 객체가 하나의 인터페이스 타입이라는 것은 해당 인터페이스가 제공하는 모든 메서드를 구현했다는 뜻임
  - 하나의 인터페이스를 여러 객체가 구현하여 사용할 수 있음: 다형성
    - 예) JDBC 인터페이스



인터페이스의 요소

- 상수
  - 모든 변수는 상수로 변환됨: public static final
- 추상 메서드
  - 모든 메서드는 추상 메서드가 됨: public abstract
- 디폴트 메서드
  - 구현을 가지는 메서드, 인터페이스를 구현하는 클래스들에서 공통으로 사용할 수 있는 기본 메서드
  - 구현하는 클래스에서 재정의할 수 있음
  - 인스턴스 생성 후에 사용 가능
- 정적 메서드
  - 인스턴스가 없어도 인터페이스 타입으로 사용 가능한 메서드
- private 메서드
  - default method나 static method에서만 사용함
  - 인터페이스를 구현한 클래스에서 사용하거나 재정의할 수 없음



인터페이스의 상속

- 다중 구현
  - 하나의 클래스가 여러 인터페이스는 구현 할 수 있음
  - 디폴트 메서드가 중복되는 경우는 구현하는 클래스에서 재정의 필요
  - 여러 인터페이스를 구현한 클래스는 특정 인터페이스로 형 변환 되는 경우 **해당 인터페이스에 선언된 메서드만 사용 가능** 함
- 인터페이스 간 상속
  - 이 때는 extends를 이용해서 상속



## **4. 자바의 유용한 클래스들**



Object 클래스

- 모든 자바 클래스의 root 클래스
  - 모든 클래스는 Object 클래스를 (자동으로) 상속받음
  - Object 클래스 내에 final로 선언되지 않은 메서드들은 재정의하여 사용 가능: `toString()` 등
- Object 클래스는 java.lang 패키지 안에 들어있음
  - java.lang 패키지는 자동으로 import 됨



Object 클래스의 메서드들

- `toString()`
  - 객체의 정보를 String으로 표현할 때
  - 객체를 println해보면 메모리 주소가 나오는데 String 객체에 대해서는 문자열의 내용물이 나옴
  - String, Integer 클래스에 대해서는 이미 재정의가 되어 있다
- `equals()`
  - 두 인스턴스의 **주소값을 비교하여** true/false를 반환함
    - 물리적으로 동일한지 판단
    - `==` 연산자는 주소값만 비교
  - 재정의하여 두 인스턴스가 논리적으로 동일한지 구현**할 수 있음**
    - 메모리 내부에 저장된 "값"이 동일한지 판단
    - equals() 메서드의 원형은 물리적 판단만 하지만 보통 재정의해서 논리적으로도 판정함
- `hashCode()`
  - **인스턴스의 저장 주소를 반환**함
  - JVM이 힙 메모리를 관리할 때 해시 함수를 이용함
- `Clone()`
  - 객체의 원본을 복제하는 데 사용
  - 사용이 권장되지는 않음
    - 정보 은닉, 객체 보호 관점에서 안 좋음
    - cloneable 인터페이스를 명시해 준 경우에 사용
    - `public class Student implements Cloneable{ ... }`
- 재정의 불가한 메서드들
  - 스레드 관련
    - `wait()`
    - `notify()`
  - `finalize()`: GC가 인스턴스를 메모리에서 해제할 때 사용. 이제는 사용되지 않지만..
  - `getClass()`



String 클래스

- 선언하기

  - 인스턴스로 생성: `String str1 = new String("abc");`
    - char Array를 만들어 그 안에 문자를 집어넣음
    - 내부적으로 final로 선언되기 때문에 변경 불가
  - 리터럴로 생성: `String str2 = "abc";`
    - constant pool 안에 생성, 마찬가지로 변경 불가

- 한 번 선언된 **String은 불변**(immutable)

- String의 연결

  - `+`로 연결
  - `concat()`로 연결: 기존의 String에 연결되는 것이 아닌 새로운 문자열이 생성됨 (메모리 낭비)
  - StringBuilder, StringBuffer 사용을 권장

- **StringBuilder vs StringBuffer**

  - 둘 다 내부적으로 가변적인 char[]를 멤버 변수로 가짐: **문자열 변경에 유리**함
  - StringBuffer는 멀티쓰레드 프로그래밍에서 유리: 동기화를 보장함
  - StringBuilder는 싱글쓰레드에서 사용하는 것을 권장
  - buffer에 문자열을 넣고, 출력할 때는 `toString()`을 이용함

- text block

  - Java 13부터 지원하는 기능으로 문자열을 """ """ 사이에 이어서 만들 수 있음

  - html, json 문자열을 만드는데 유용함

    - ```java
      String strBlock = """
      				This 
      				is 
      				text
      				block
      				test.""";
      ```



Class 클래스

- 컴파일 된 **class 파일**을 로드하여 객체를 **동적으로 로드**(바인딩)하고 정보를 가져오는 메서드를 제공함
  - 자바의 모든 클래스, 인터페이스는 컴파일 후 class 파일을 생성함
  - `Class.forName(String className)` 메서드를 이용해 클래스를 로드
    - `Class c = Class.forName("java.lang.String");`
  - 동적으로 로드: 컴파일 시가 아니라 실행 중에(runtime) 데이터 타입을 바인딩 함
    - 프로그래밍 시에는 문자열 변수로 처리, 런타임시에 원하는 클래스를 로딩
    - 오류가 발생하면(Class Not Found) 심각한 장애가 될 수도 있음
- Class 클래스의 메서드
  - 클래스의 정보 알아보기(**reflection 프로그래밍**)
    - 로컬 메모리에 객체 없는 경우, 원격 프로그래밍, 객체의 타입을 알 수 없는 경우에 사용
    - `.getConstructors()`
    - `.getMethods()`
  - 인스턴스 생성
    - `.newInstance()`
    - 이것도 로컬에 해당 객체가 없을 때 사용





## **5. 자바와 자료구조**



### 5.1. Array



배열이란?

- **동일한 자료형**의 **순차적** 자료구조
  - 인덱스를 이용하여 O(1)에 빠르게 탐색 가능
  - 단 삽입-삭제는 O(n)으로 느림
- 물리적 위치와 논리적 위치가 같음
  - 실제 메모리 상에도 순차적으로 저장됨: `arr[i]` 옆에 `arr[i+1]`가 있음
  - 선언할 때 자료형과 크기에 따라 메모리를 차지하는 공간 결정
- jdk 클래스로 **ArrayList**, Vector가 있음



배열 선언 및 초기화

- 선언하기

  - **자료형과 길이를 명시**해줘야 함

  - ```java
    int[] arr1 = new int[10];
    int arr2[] = new int[10];
    ```

- 초기화 하기

  - 선언과 동시에 초기화 하는 경우엔 new를 쓸 수도 안 쓸 수도 있음

  - ```java
    int[] numbers = new int[] {10, 20, 30};
    int[] numbers = {10, 20, 30};
    ```

  - 선언 후 초기화 하는 경우에는 new 생략 불가

  - ```java
    int[] ids;
    ids = new int[] {10, 20, 30};
    ```

- 2차원 배열의 선언 및 초기화

  - `int[][] arr = {{1,2,3}, {4,5,6}};`



배열의 사용

- `arr.length`와 배열 안에 있는 데이터의 갯수는 다름
  - 배열의 길이는 초기화 때 정해짐
- 향상된 for문
  - `for(int num : arr) { ... }`
  - 이거 파이썬의 `for num in nums`랑 같은 방식으로 사용 가능



객체 배열

- 객체를 요소로 갖는 배열

  - int, double 등의 primitive type의 원소를 갖는 것은 기본 자료형 배열이라고 함
  - 객체 배열은 선언될 때 객체의 **주소가 들어갈 메모리만 할당**됨
    - 각 요소 객체는 생성해서 저장해야 함

- 객체 배열 복사

  - 얕은 복사

    - 복사 메서드`System.arrayCopy(src, srcPos, dest, destPos, length)` 이용
    - 주소가 복사되기 때문에 한쪽 배열의 요소를 수정하면 복사한쪽에도 반영됨

  - 깊은 복사

    - 각각의 객체를에 대해 생성한 후 똑같은 값으로 복사하고 배열에 넣어줌

    - 이건 뭐 일일이 반복문으로 해주는 수밖에 없다

    - ```java
      for(int i = 0; i< library.length; i++) {
      			copiedLibaray[i].setTitle(library[i].getTitle());
      			copiedLibaray[i].setAuthor(library[i].getAuthor());
      		}
      ```



ArrayList

- `java.util` 패키지 내에 **객체 배열**을 구현해 둔 클래스

- 많은 메서드들이 최적의 알고리즘으로 구현되어 있어 사용 방법만 익히면 유용하게 사용할 수 있음

  - 주요 메서드

    ![메서드](https://gitlab.com/easyspubjava/javacoursework/-/raw/master/Chapter2/2-23/img/method.png)

  - E는 뭐냐?

    - 객체 배열의 element(인스턴스)에 해당하는 클래스를 E로 표기함

- 선언 및 초기화

  - `ArrayList<Book> library = new ArrayList<Book>(); `
  - 객체 타입에 해당하는 Class를 import해야 함(위에서는 Class Book)



### 5.2. LinkedList



연결 리스트란?

- **동일한 데이터 타입**을 순서에 따라 관리하는 자료 구조
- 데이터를 저장하는 노드에는 **자료와 다음 요소를 가리키는 링크**(포인터)가 있음
  - 데이터가 추가 될때 노드 만큼의 메모리를 할당 받고 이전 노드의 링크로 연결함 (정해진 크기가 없음)
  - 연결 리스트의 i 번째 요소를 찾는데 걸리는 시간은 요소의 개수에 비례 : O(n)
  - 삭제/추가는 O(1)이지만 삭제할 곳을 찾는 데 O(n)이 걸리기 때문에 전체적으로 느리다
- jdk 클래스 : LinkedList





### 5.3. Stack, Queue



스택의 특징

- 맨 마지막 위치(top)에서만 자료를 추가,삭제, 꺼내올 수 있음 ( 중간의 자료를 꺼낼 수 없음)
  - Last In First Out ( 후입선출 ) 구조: 택배 상자가 쌓여있는 모양
  - 응용: 가장 최근의 데이터를 찾아오거나 게임에서 히스토리를 유지하고 이를 무를때
- 함수의 메모리는 호출 순서에 따른 stack 구조로 되어 있음
- jdk 클래스 : Stack



Queue의 특징

- 맨 앞(front) 에서 자료를 꺼내거나 삭제하고, 맨 뒤(rear)에서 자료를 추가 함
  - Fist In First Out (선입선출) 구조: 일렬로 줄 서 있는 모양
  - 순차적으로 입력된 자료를 순서대로 처리하는데 많이 사용됨
  - 응용: 콜센터에 들어온 문의 전화, 메세지 큐 등
- jdk 클래스 : ArrayList



### 5.4. Generic



제네릭이란?

- 자료형을 지정하지 않고 프로그래밍하는 것
  - 클래스에서 사용하는 변수의 자료형이 여러개 일수 있고, 그 **기능(메서드)은 동일한 경우**
  - 자료형을 특정하지 않고 **추후 해당 클래스를 사용할 때 지정** 할 수 있도록 선언

- 실제 사용되는 자료형의 변환은 컴파일러에 의해 검증되므로 안정적임
- 컬렉션 프레임워크에서 많이 사용되고 있음



자료형 매개변수

- T(type parameter)를 사용하여 클래스를 사용하는 시점에 실제 타입을 지정함
  - E : element, K: key, V : value 등 여러 알파벳을 의미에 따라 사용 가능
- 선언: `public class GenericPrinter<T> { ... }`
- 사용: `GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();`
  - 다이아몬드 연산자를 생략해도 되지만 인스턴스를 사용할 때 형변환 `(Powder)` 필요
- static 변수는 사용 불가



`<T extends Class>` 

- **T 자료형의 범위를 제한** 할 수 있음
  - 상위 클래스에서 선언하거나 정의하는 메서드를 활용할 수 있음
  - 상속을 받지 않는 경우 T는 Object로 변환되어 Object 클래스가 기본으로 제공하는 메서드만 사용가능
- 구현하기
  - `public class GenericPrinter<T extends Material>`
  - GenericPrinter 에 material 변수의 자료형을 상속받아 구현
  - T에 들어가는 것을 Material 클래스를 상속받은 클래스로 한정



제네릭 메서드

- 말 그대로 제네릭을 이용한 메서드
  - `public <자료형 매개 변수> 반환형 메서드 이름(자료형 매개변수.....) { }`
  - 자료형 매개 변수가 하나 이상인 경우도 있음
- 제네릭 클래스가 아니어도 내부에 제네릭 메서드는 구현하여 사용 할 수 있음  



### 5.5. Collection Framework



컬렉션 프레임워크란?

- 자바에서 사용되는 자료구조를 구현해 놓은 JDK 라이브러리
  - `java.util` 패키지에 구현되어 있음
- Collection과 Map으로 나뉨
  - ![collection framework](https://gitlab.com/easyspubjava/javacoursework/-/raw/master/Chapter5/5-09/img/collection.png)
- Collection
  - 하나의 객체를 관리함
    - 이름, 주민번호, 아이디 등 
  - List와 Set으로 나뉨: **중복을 허용하는지** 아닌지
- Map
  - 쌍(key-value)로 이루어진 객체를 관리함
  - key는 중복을 허용하지 않음



List 인터페이스

- 멤버를 순차적으로 관리
- 기본적으로 object 10개가 들어가고, 길이 지정 가능
  -  `add()`하게 되면 `ensureCapacity`로 체크한 후 10개를 **다 썼다면 새로운 ArrayList를 파서 복사**함



Iterator의 활용

- Set에는 Get(i)가 없기 때문에 Iterator를 이용하여 **순회**함
  - 순회: 컬렉션 프레임워크에 저장된 요소들을 하나씩 차례로 참조하는것



Set 인터페이스

- 중복을 허용하지 않도록 관리: **인스턴스의 동일성을 확인**하고 add해야 함
  - 동일성 구현을 위해 필요에 따라 equals()와 hashCode()메서드를 재정의



Tree 인터페이스

- 이름에 Tree가 붙은 인터페이스는 BST로 구현되어 있음
  - 정확히는 균형을 유지하기 위해 레드-블랙 트리로 되어 있음
  - BST에 객체를 저장하기 위해 **객체의 비교가 필요**함: Comparable, Comparator 인터페이스 필요
  - String, Integer에 대해서는 Comparable 인터페이스가 이미 구현되어 있음



Map 인터페이스

- 검색을 위한 자료구조로 key - value를 쌍으로 관리하는 메서드를 구현함
- HashMap
  - 가장 많이 사용되는 Map 인터페이스 기반 클래스
  - **hash 알고리즘으로 key를 이용**하여 값을 저장하고 꺼내오는 방식
    - key가 되는 객체는 중복될 수 없음:  `equals()`와 `hashCode()` 메서드를 구현
- TreeMap
  - key-value 쌍의 자료를 **key값 기준으로 정렬**하여 관리
    - key가 되는 클래스에 Comparable이나 Comparator인터페이스를 구현





## **6. 자바 고급**



### 6.1. 내부 클래스



내부 클래스란?

- 클래스 내부에 선언한 클래스
  - 외부 클래스와 밀접한 연관이 있으면서
  - 다른 외부 클래스에서 사용할 일이 거의 없는 경우에 내부 클래스로 선언해서 사용함

- 중첩 클래스라고도 함



내부 클래스의 종류

- 인스턴스 내부 클래스
  - 외부 클래스가 생성된 후 생성됨
    - 인스턴스 내부 클래스에서는 **정적 변수 선언 불가**
    - 클래스가 생성이 되어야 정적 변수도 할당할 수 있기 때문...
  - private으로 선언하는 것을 권장
    - private이 아닌 경우 다른 외부 클래스에서도 생성 가능
- 정적 내부 클래스
  - 외부 클래스 생성과 무관하게 생성될 수 있음
    - **정적 변수, 정적 메서드 사용 가능**
  - 정적 내부 클래스에서는 **외부 클래스의 인스턴스 변수 사용 불가**
    - 정적 메서드에서는 내-외부 클래스의 정적 변수만 호출 가능
    - 일반 메서드에서는 추가로 내부 클래스(본인)의 인스턴스 변수 호출 가능
- 지역 내부 클래스
  - 지역 변수와 같이 **메서드 내부에서 정의**하는 클래스
  - 지역 내부 클래스에서 사용하는 **지역변수 및 매개변수는 final로 선언**됨
    - 메서드가 끝나면 메서드 내 지역 변수는 Stack에서 해제됨
    - 메서드 내부의 지역 내부 클래스가 나중에 또 호출될 수 있기 때문에 내부 변수를 final로 선언해야 함
    - 컴파일러가 자동으로 final로 선언해줌
- 익명 내부 클래스
  - 지역 내부 클래스의 이름은 호출될 일이 없기 때문에 **이름을 없애고 바로 리턴**을 때림
    - `return new Runnable() { ... }`
    - 클래스의 이름을 생략하고 주로 하나의 인터페이스나 하나의 추상 클래스를 구현하여 반환
    - 인터페이스나 추상 클래스 자료형의 변수에 직접 대입하여 클래스를 생성하거나
    - 지역 내부 클래스의 메서드 내부에서 생성하여 반환
  - 내부 클래스 중에 가장 많이 활용됨
    - Android 프로그래밍에서 widget 이벤트 핸들러에 많이 활용됨



### 6.2. Lambda expression



함수형 프로그래밍이란?

- 함수형 프로그래밍에서는 함수가 외부의 변수를 사용하지 않고 **인자로 전달된 변수만을 사용**함
  - 글로벌 변수를 사용하면 side effect가 있을 수 있음(동기화 이슈 등)
  - 병렬 처리가 가능함
  - 함수의 기능이 자료에 독립적임을 보장함



람다식이란?

- 자바에서 **함수형 프로그래밍**을 지원하기 위해 사용하는 표현
  - 자바 8부터 지원
- 소스가 간결해지나 가독성이 떨어진다는 단점이 있음



람다식 문법

- 함수의 이름이 없음
- (매개 변수) -> {실행문;} 으로 구성됨
  - `(int x, int y) -> {return x+y;}`
  - 매개 변수가 하나인 경우 자료형과 괄호 생략 가능
    - `str->{System.out.println(str);}`
  - 실행문이 한 문장인 경우 중괄호 생략 가능
    - `str-> System.out.println(str); `
  - 실행문이 한 문장이더라도 return문은 중괄호 생략 불가
    - `str-> return str.length();  //오류 `
  - 실행문이 한 문장의 반환문인 경우엔 return, 중괄호 모두 생략 가능
    - `str -> str.length;`



람다식의 구현

- 함수형 인터페이스

  - 람다식을 선언하기 위한 인터페이스: 람다식은 함수가 사용되는 곳에서 구현
  - `@FunctionalInterface` 어노테이션을 붙여서 선언
  - 인터페이스는 **단 하나의 메서드만을 선언**해야함
    - 익명 함수를 구현해야 하는데 메서드가 여러 개면 뭘 구현할지 모르기 때문

- 변수처럼 사용되는 람다식

  - 변수의 선언과 대입

    - ```java
      interface PrintString{
      	void showString(String str);
      }
      public class PrintStringTest{
      	PrintString lambdaStr = s -> System.out.println(s);  //람다식을 변수에 대입
      	lambdaStr.showString("hello lambda_1");    
      }
      ```

  - 매개변수 전달과 사용

    - ```java
      public static void showMyString(PrintString p){
          p.showString("hello lambda_2");
      }
      showMyString(lambdaStr);
      ```

  - return값으로 돌아오는 변수

    - ```java
      public static PrintString returnString(){
          return s -> System.out.println(s + "world");
      }
      PrintString reStr = returnString();
      reStr.showString("hello ");
      ```

- OOP와의 비교

  - OOP: 인터페이스 선언 → 인터페이스를 구현한 클래스 작성 → 클래스 생성 후 메서드 호출
  - 람다식: 함수형 인터페이스 선언 → 람다식 구현하고 메서드 호출
  - 람다식도 내부적으로는 anonymous class가 생성되어 OOP와 동일하게 작동함



### 6.3. Stream



1. [스트림(Stream)](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-05/README.md)
2. [연산 수행에 대한 구현을 할 수 있는 reduce()연산](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-06/README.md)
3. [스트림을 활용하여 패키지 여행 비용 계산하기](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-07/README.md)
4. [예외 처리는 왜 해야 하나? 자바에서 제공되는 클래스들](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-08/README.md)
5. [예외 처리하기와 미루기](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-09/README.md)
6. [사용자 정의 예외 클래스와 그 활용](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-10/README.md)
7. [오류의 로그를 남기기 - java.util.logging.Logger 활용](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-11/README.md)
8. [자바의 입출력을 위한 I/O 스트림](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-12/README.md)
9. [표준 입출력 스트림](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-13/README.md)
10. [바이트 단위 입출력 스트림](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-14/README.md)
11. [문자 단위 입출력 스트림](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-15/README.md)
12. [여러가지 보조 스트림 클래스들](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-16/README.md)
13. [직렬화 (serialization)](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-17/README.md)
14. [그외 여러가지 입출력 클래스들](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-18/README.md)
15. [데코레이터 패턴을 활용한 커피 머신 프로그램](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-19/README.md)
16. [자바에서 Thread 만들기](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-20/README.md)
17. [Thread 클래스의 여러 메서드들](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-21/README.md)
18. [멀티 Thread 프로그래밍에서의 동기화](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-22/README.md)
19. [wait()/notify() 에서드를 활용한 동기화 프로그래밍](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter6/6-23/README.md)