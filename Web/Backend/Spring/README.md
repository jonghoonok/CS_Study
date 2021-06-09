# Spring





[TOC]

## **1. Spring**



스프링이란?

- 자바 엔터프라이즈 어플리케이션을 개발하기 위한 프레임워크
- 20여 개의 모듈로 구성됨
  - 주요 모듈 : 스프링 부트, 스프링 클라우드, 스프링 데이터, 스프링 배치, 스프링 시큐리티
- Monolithic에서 마이크로서비스 아키텍처로 변환되는 중



스프링 등장 배경

- **테스트 용이성**, **느슨한 결합**에 중점을 두고 개발됨
  - 기존 Java EE에서는 테스트가 어려웠음
  - 배포가 필요하거나 DB연결이 필요한 등, 외부 의존도가 있는 코드의 테스트가 어려웠음
  - **IoC의 등장**



### 1.1. 스프링 삼각형



![triangle](https://i1.wp.com/docs.jboss.org/snowdrop/presentations/images/spring-triangle.png?w=750)

#### Plain Old Java Object

POJO란?

- **순수한** 자바 오브젝트
  - 외부에 종속성이 없다는 뜻
- 등장 배경
  - 과거 Java EE의 스펙을 구현한 **EJB**(Enterprise Java Beans) 기술의 복잡도가 증가해서 성능이 느려짐
  - EJB에 종속적인 부분으로 개발이 진행되면서 모듈 교체, 시스템 업그레이드 시 불편한 부분이 발생함
  - 종속성을 갖지 않는 가벼운 객체의 필요성 대두 : POJO의 등장
- 특징
  - 특정한 **규약**에 종속되지 않음
    - 특정 라이브러리나 모듈에서 정의된 클래스를 상속받아 구현하지 않아도 됨
    - 외부 의존성 없이 순수하게 Java로 구현할 수 있어야 함
  - 특정한 **환경**에 종속되지 않음
    - 어노테이션 기반으로 설정하는 부분도 엄밀하게는 POJO라고 볼 수 없음
- POJO Framework
  - Spring
  - Hibernate



Enterprise Java Beans란? [참고자료](https://woongsin94.tistory.com/357)

- 기업환경의 시스템을 구현하기 위한 서버 측 컴포넌트 모델
  - 일반적으로 업무 로직을 가지고 있는 서버 어플리케이션을 EJB라고 함
  - 비즈니스 로직을 탑재한 부품을 **Enterprise Bean**이라 하고. DB처리, Transaction처리 등 시스템 서비스를 이용한 로직을 감추고 있는 부품을 **컨테이너**라고 함
- 서버 어플리케이션 생산성의 향상과 이동성을 실현하기 위해서 개발됨
  - 시스템 서비스 개발에 소요되는 시간을 단축시켜줌



#### Dependency Injection

객체의 생명주기를 사람이 관리하는 게 아니라 기계에 관리를 시키는 것



IoC(Inversion Of Control)

- 제어의 역전 : 개발자에서 **프레임워크로 객체 제어의 권한이 넘어감**
  - 프로그램이 외부 라이브러리의 코드를 호출하는 것이 아니라 프레임워크가 개발자의 코드를 호출함
  - 제어권이 프레임워크에게 있어 필요에 따라 스프링 프레임워크가 사용자의 코드를 호출하는 것
- Spring Container가 Java 객체를 생성하고 관리하는 것을 수행함
  - Spring은 ApplicationContext라는 IOC 컨테이너를 통해 **Bean**의 생명 주기를 관리
  - `@Component` 어노테이션을 이용해 Bean을 등록, Spring이 객체를 Singleton 형태로 만들어서 관리함



DI(Dependency Injection)

- **외부로부터 내가 사용할 객체를 주입**받는 것
  - **구성요소** 간의 의존 관계가 소스코드 내부가 아닌 외부에서 설정을 통해 정의되는 방식
  - Spring Bean 사이의 참조 관계를 설정할 때 DI를 이용함
- DI의 메리트
  - 코드 확장-변경 시 영향을 최소화 하고(추상화) 순환참조를 막을 수 있음
  - 코드 테스트에 용이함
    - 의존성을 격리시킴
    - Mocking을 이용한 안정적인 테스트가 가능 : mock객체의 주입



DI의 구현 방식

- 필드 주입
  - `@Autowired`, `@Resource` 등의 어노테이션을 **필드(속성)**에 설정
    - 객체의 멤버 변수를 필드라고도 함
  - 스프링에서 검색 규칙에 따라 알맞은 클래스를 기반으로 만든 Bean을 주입시켜 줌
  - 코드의 양은 줄어들지만 **외부에서 변경이 불가능**해서 테스트 하기 힘들어 짐
    - DI컨테이너와 결합이 강하게 되고, 의존 관계가 보이지 않게 됨
- 세터(수정자) 주입
  - 어노테이션을 Setter 형태로 만든 메소드에 붙여주면 해당 필드에 Bean을 주입시켜 줌
  - setter는 의존관계를 변경시킬 위험이 있고, public으로 설정해야 한다는 단점이 있음
- **생성자 주입**
  - 스프링에서 추천하는 방법
    - 생성자 주입을 사용하게 되면 **전략패턴**을 사용함 : Open Closed Principle에 부합
    - 런타임에 의존관계가 결정되기 때문에 느슨한 결합을 갖게 됨
  - 클래스 생성자에 주입시킬 Bean들을 파라미터로 넣어주고 설정하는 방법
  - 필드 주입과 세터 주입에서 사용하지 못하는 final 키워드를 필드에 붙일 수 있음
    - 중간에 필드 인스턴스를 바꾸는 게 불가능하며, 의존성을 추가할 수록 생성자 파라미터가 늘어나게 됨



#### Aspect Oriented Programming

관점 지향 프로그래밍이란?

- **횡단 관심**에 따라 프로그래밍 하는 것
  - 여러 모듈에서 **공통적으로 사용하는 기능을 분리하여 관리**하기 위함
- OOP를 보완하는 것으로 각 언어마다 AOP의 구현체가 있음
  - Java에는 AspectJ가 있음 : 완벽한 AOP기능을 제공함
  - Spring AOP는 **프록시 패턴**을 통해 간단한 AOP 기능만 제공함



횡단 관심(Cross-Cutting Concern)

- 공통적인 기능들이나 **인프라 로직**을 한 곳에 모아서 코딩할 수 있게 해 줌
  - method parameter log : 메소드들의 파라미터와 리턴값을 확인
  - 실행 시간 log : 특정 메소드의 실행 시간
  - parameter encode : 메소드가
- 반복되는 로직을 어떻게 한 곳에 모아서 관리하는가?
  - **모듈을 관리해주는 모듈**을 상하/인터페이스 관계없이 따로 마련함
- 인프라 로직이란?
  - 비즈니스 로직을 수행하는 데 있어 **부가적인 기능**(성능 검사, 로깅 등)
  - 부가적이기 때문에 어플리케이션의 전 영역에서 나타날 수 있음 : **횡단 관심**
    - 중복코드를 만들어 낼 가능성 때문에 유지보수가 어려워 짐
    - 비즈니스 로직과 함께 있으면 비즈니스 로직을 이해하기 어려워 짐
  - 예) 모든 서비스에 로깅을 추가하기 위해 반복적으로 로깅 객체를 추가하는 경우
    - SRP를 위반하게 됨 : AOP를 이용하면 해결 가능



AOP 관련 용어

- Target
  - 부가 기능을 부여할 대상
  - Spring AOP에서는 Spring Container가 관리하는 bean에 대해서만 가능
- Join Point
  - 어디에 적용할 것인지?
  - 메서드, 필드, 생성자
    - **Spring AOP에서는 메서드에 한정**함
- Advice
  - 어떤 부가 기능인지
  - Join Point가 메서드 : 실행되는 시점에 따라 5가지로 분류 가능
    - `@Before` : 메서드 실행 전
    - `@AfterReturning` : 메서드가 실행되어 결과값을 리턴한 이후
    - `@AfterThrowing` : 메서드가 실행되었으나 exception이 발생한 이후
    - `@After `: return/throw 관계 없이 실행 이후
    - `@Around` : 실행 전후
- Point cut
  - 실제 advice가 적용되는 지점
    - 어떤 패키지에서 어떤 클래스의 어떤 메서드에 적용할 지?
  - Spring AOP에서는 advice가 적용될 메서드를 선정하는 부분
    - 예) `@Pointcut("execution(*con.example.aop.controller..*.*(..))")`
    - controller 패키지 내 모든 메서드에 적용
    - 예) `@Around("@annotation(PerformanceCheck)")`
    - PerformanceCheck이라는 custom annotation을 붙인 메서드의 실행 전후로 해당 advice를 적용



AOP의 구현 방법

- 컴파일 시
  - `.java` 파일을 `.class` 파일로 컴파일하는 시점에 해당하는 aspect를 끼워 넣어 줌
- 클래스 로드시
  - 클래스를 로드할 때 AOP를 적용시킴
- 프록시 패턴
  - target class를 부가 기능을 제공하는 **프록시**로 감싸서 AOP를 적용시킴
    - DI, IoC 덕분에 가능 : 런타임에 프록시를 만들어서 의존성을 주입받을 bean을 감싸는 것
    - private method는 프록시로 감싸더라도 advice가 불리지 않음(예 : `@transactional`)
  - Spring AOP에서 사용하는 방법



주요 어노테이션

- `@Aspect` : AOP를 적용할 때 사용



스프링 어플리케이션은 대부분 다음 세 개의 계층으로 정의 됨

- Web Layer : REST API를 제공하며 client 중심의 로직을 적용
- Buisiness Layer : 내부 정책에 따른 logic을 처리
- Data Layer : DB및 다른 서버와의 연동을 처리



#### Portable Service Abstractions

이식 가능한 추상화란?

- 기술에 대해 공통으로 사용할 수 있게 추상화된 레이어를 제공하고 있다는 의미
- 세부 구현 사항에 대한 변경이 손쉬워짐
  - 공통 로직을 스프링이 제공하는 인터페이스로 작성하였다면 세부 구현이 무엇이든 상관이 없어짐
  - 예) JPA를 사용하든 JDBC를 사용하든 `@Transactional` 은 변경할 필요 없음



## **2. Spring Boot**



빌드 툴?

maven, gradle



HTTP 메서드 



Tomcat port 변경하기

`resources > application.properties` 에서 `server.port=9090`하는 식으로 변경 가능



어노테이션

`@RestController` : REST API를 처리하는 컨트롤러로 기능하게 해줌

`@RequestMapping` : RequestMapping URI를 지정해줌(해달 어플리케이션의 주소)

`@GetMapping` : 해당 어플리케이션에서 GET을 보낼 때 필요한 주소



path variable

메소드에 선언한 변수 이름과 일치해야 함

일치하지 않는다면 @PathVariable(name = )속성에 pathvariable로 받는 것과 동일한 이름을 넣어줘야 함 

### 2.1. GET API



### 2.2. POST API



### 2.3. PUT APU



### 2.4. DELETE API