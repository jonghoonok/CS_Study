# Java



참고자료

- 이것이 자바다
- fastcamp 한번에 끝내는 Java/Spring 웹 개발 마스터 패키지
- Softbank 신입사원 OJT



[TOC]

## **1. 자바란?**

> 웹 개발



특징

- 안정적임
  - 시스템 메모리를 건드려 다운될 수 있는 C와 달리 안정적인 언어의 필요성에 의해 개발됨
- 플랫폼에 영향을 받지 않음
  - OS에 따라 다른 컴파일러와 실행 파일을 갖는 C와 달리 가상머신 상에서 돌아가기 때문에 플랫폼에 독립적
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



자바 실행 관련

- 패키지 이름은 소문자로만
- 클래스 이름은 PascalCase
  - 저장하면 자동으로 빌드가 되어 class 파일이 생성됨 -> 실행되는 것은 class 파일
  - 하나의 자바 파일 안에 클래스가 여러 개 들어갈 수 있지만 `public class` 는 하나 뿐



## **2. 변수와 자료형**



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
    - byte
    - short
    - int
    - long : 선언하고 숫자 뒤에 **L을 붙임**
  - 실수
    - float : 선언하고 숫자 뒤에 **F를 붙임**
    - double
  - 문자
    - char
    - 문자열과는 다르다!
    - 문자는 `'A'`로 선언하고 문자열은 `"A"`로 선언함



상수

- 변하지 않는 수
  - 변하지 않는 값을 반복하여 사용할 때
  - 값을 변경할 수 없기 때문에 초기화를 해주지 않으면 오류 발생
- final 예약어를 이용하여 선언
- 대문자와 언더바를 이용하여 이름을 선언함



리터럴

- 프로그램에서 사용하는 숫자, 문자, 논리 **값**을 뜻함
- 리터럴은 **상수 풀 constant pool**에 존재함
  - Data 영역이라고도 함
  - 프로그램이 실행되자마자 메모리에 올라와서 종료될 때까지 존재함
- 정수 리터럴은 int, 실수 리터럴은 double로 저장됨



형변환

- 서로 다른 자료형 간의 연산 등을 하기 위해 하나의 자료형으로 **통일**하는 것
- 종류
  - 묵시적(자동) 형 변환
    - 바이트 크기가 작은 자료형에서 큰 자료형으로 형 변환은 자동으로 이루어짐
    - 덜 정밀한 자료형(정수)에서 더 정밀한 자료형(실수)으로 형 변환은 자동으로 이루어짐
    - double에서 int로 형 변환하면 소숫점 아래 부분은 짤림(truncate)
  - 명시적(강제) 형 변환
    - 변수 명 앞에 괄호 치고 타입을 써 주면 강제 형 변환



### 2.1. 연산자



항과 연산자

- 항(operand): 연산에 사용되는 값
- 연산자(operator): 항을 이용하여 연산하는 기호



대입 연산자

- 이항 연산자: 변수에 다른 변수나 값을 대입하는 연산자 `=`
- 왼쪽을 l value, 오른쪽을 r value라 하며 오른쪽엔 변수, 식, 값이 들어감
- 이항 연산자 중 가장 우선순위가 낮음
  - 오른쪽에서 모든 계산을 다 수행하고 마지막에 대입해야 하기 때문



부호 연산자

- 단항 연산자: 변수의 부호를 유지하거나(+) 바꿈(-)
- 변수의 내용물의 부호가 바뀌는 것은 아님: 그러려면 대입 연산자 사용해야 함 `num = -num;`



산술, 관계 연산자: pass



논리 연산자

- `&&` : and
- `||` : or
- `!` : not
- short circuit evaluation(단락 회로 평가)
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



## **3. 제어문**



### 3.1. 조건문

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

위처럼 한 줄만 쓸 때는 중괄호를 쓰지 않아도 됨

물론 들여쓰기 해서 나쁠 것 없으니 웬만하면 쓰자



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



### 3.2. 반복문

for문

```java
for(초기화; 조건문; 증감식){
    statement;
}
```

- 초기화, 조건문, 증감식 안에 여러 식이 들어갈 수 있음
  - 콤마로 구분하여 넣으면 됨
  - `for(int i = 0, int count = 0; i < 10; i++, count++)` 이런 식으로
- 초기화식, 조건식, 증감식은 각각 생략 가능함
  - 모두 생략 시 무한 루프 	



while, do-while, for문의 비교

- while은 조건의 결과나 변수가 true, false인 경우에 주로 사용
  - 수행문을 먼저 할지 나중에 할지에 따라 while, do-while 중 무엇을 할지 결정할 것
- for는 특정 수의 범위나 횟수와 관련하여 반복되는 경우(배열 관련)에 주로 사용



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



#### List 인터페이스

> 멤버십 관리하기



ArrayList 활용

- 멤버를 순차적으로 관리



Vector 활용



LinkedList 활용