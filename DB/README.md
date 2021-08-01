# DB

데이터베이스 기초부터 심화까지



참고서적

- SNUON 강의 "데이타베이스: 빅데이터 시대의 필수 정보관리 개론" - 이상구
- Database System Concepts [pdf](https://www.db-book.com/db7/index.html)



[TOC]

## **1. Introduction**

> 데이터베이스 기본 개념





### 1.1. Introduction to Database Systems

 



Data란?

- 실세계에 존재하는 개념, 생각, 수치 등을 **컴퓨터에 형식적으로 표현한 것**
  - 기록할 가치가 있는 자료들





Database란?

- An **Integrated collection** of **persistent** data representing the information of interest
  - 프로그램들이 데이터를 사용할 수 있게끔 데이터를 저장함
  - 데이터를 사용하는 프로그램과 데이터 자체를 분리함





DBMS(Database Management System)

- 데이터를 접근/관리하는 업무를 **전담**하는 프로그램
  - 어플리케이션이 여러 목적으로 사용할 데이터들을 관리
  - DBMS 등장 이전에는 어플리케이션이 데이터를 관리/사용하고 파일 시스템은 저장만 함
- 하나의 DBMS를 통해 관리: 데이터를 관리하는 방식이 통합됨
- 중복 및 누락 방지: 하나의 소프트웨어가 데이터를 관리
- 공동으로 실시간 사용 가능: 데이터가 응용프로그램에 독립적이므로 프로그램 업데이트 시에도 사용 가능





File Systems

- DBMS 등장 이전에 데이터들을 관리하기 위해 사용되던 시스템
  - OS의 일부로 프로그램, 데이터, 문서 등을 저장함
  - DB 기능들이 파일시스템 위에 built on 되었었음
- 파일 시스템의 단점
  - 데이터의 중복과 일관성이 깨지는 문제 : 데이터들이 여러 파일에 중복되어 저장됨
  - 데이터 접근이 어려움 : 파일을 조작하는 새로운 작업을 위해서는 새로운 프로그램을 짜야 함
  - 데이터 통합 문제
    - 프로그램을 짤 때마다 매번 데이터의 제약 조건을 확인해야 함
  - 업데이트의 원자성 문제
    - 일련의 트랜잭션 중 일부만이 수행되면 일관성이 깨질 수 있음
  - 여러 유저들의 동시 접근 문제 : 일관성이 깨질 수 있음
  - 보안 문제
- DBMS는 위의 문제들에 대한 솔루션을 제공해 응용 프로그래머의 수고를 줄여줌



#### View of Data



Levels of Abstraction

- Physical level
  - 실제 물리 장치에 데이터가 어떻게 저장되는지 표현함
- Logical level
  - 데이터베이스에 저장된 각 데이터가 어떤 관계로 저장되는지 표현함
  - 각 데이터의 타입을 표현
- View level
  - 보안상 이유로 데이터 타입이나 정보의 디테일은 숨김





Data Independence

- 상위 레벨의 스키마에 영향을 주지 않고 하나의 스키마를 수정할 수 있는 것
  - DB에서 레벨 별로 abstraction을 제공하는 것
- physical data independence
  - 물리적인 레벨의 변경이 논리적인 레벨에 영향을 주지 않는 것
  - 예 : DB 용량 확대로 데이터 저장 장소 변경이 일어나도 액세스에 문제가 없을 것





Instances and Schemas

- 프로그래밍 언어에서 변수와 type의 관계와 비슷함
- 스키마 : 데이터베이스의 논리적 구조
- 인스턴스 : 특정 시점에서 실제 DB에 저장되어 있는 컨텐츠









Data Models



Data Languages



Transaction Management



Storage Management



Data Mining & Analysis



Overall System Structure





데이터베이스란?

- 데이터와 정보
  - 데이터: 어떤 필요에 의해 수집했지만 아직 특정 목적을 위해 평가하거나 **정제하지 않은 자료**
  - 정보: 수집한 데이터를 어떤 목적을 위해 **분석하거나 가공한 것**
- 효율적인 데이터 관리: **데이터베이스의 필요성** 대두
  - 데이터를 통합하여 관리
  - 일관된 방법을 관리
  - 데이터의 누락, 중복 제거
  - 여러 사용자가 공동으로 실시간 사용 가능
- 데이터베이스
  - 특정 목적을 위해 여러 사람이 공유하여 사용할 수 있으며 효율적 관리와 검색을 위해 **구조화한 데이터 집합**
- 파일 시스템
  - DB등장 이전에 데이터를 관리하던 방식
  - 각각의 응용 프로그램에 필요한 데이터를 각각 저장: 중복 및 누락 발생 가능
    - 데이터의 통합 관리 필요성 대두: **DBMS**의 등장



데이터 모델

- 데이터를 저장하는 방식을 정의해 놓은 개념 모형

- 계층형 데이터 모델

  - 트리 구조를 활용
  - 부모 자식 관계 - 1:N

- 네트워크형 데이터 모델

  - 그래프 구조를 기반으로 함
  - 자식 개체가 여러 부모 개체를 가질 수 있음 - M:N

- 객체 지향형 데이터 모델

  - 데이터를 독립된 개체로 구성하여 관리

- **관계형 데이터 모델**

  - 데이터 간 관계에 초점

    - 각 데이터의 **독립 특성**만을 규정하여 데이터 묶음을 나눔
    - 중복이 발생할 수 있는 데이터는 별개의 **relation**으로 정의하여 연결

  - 구성 요소

    - | 이름                   | 설명                                   | 대응(구현)되는 개념  |
      | ---------------------- | -------------------------------------- | -------------------- |
      | 개체(entity)           | 데이터화하려는 사물/개념의 정보 단위   | 테이블(**relation**) |
      | 속성(attribute)        | 데이터의 종류, 특성, 상태              | 열(column)           |
      | **관계(relationship)** | 개체 간 또는 속성 간의 연관성을 나타냄 | 외래키               |

- 릴레이션(relation)과 관계(relationship)의 차이 [링크](https://m.blog.naver.com/PostView.nhn?blogId=ej5811&logNo=80191263951&proxyReferer=https:%2F%2Fwww.google.com%2F)

  - 릴레이션: 집합x와 집합y 사이에 관계 R을 만족하는 **모든 순서쌍**
    - 테이블이 집합 간의 cartesian product를 생성한다는 것을 생각해보자
    - 집합이론에서는 relation, 논리 데이터 모델링에서는 entity, 관계형 데이터베이스에서는 table
  - 관계: 하나 또는 두 개의 entity type으로부터 업무적인 이유에 의해 entity가 연결되어 있는 **페어링의 집합**
    - 예) entity type "주문"의 entity인 "주문번호"가 entity type "주문상품"의 entity인 "상품코드"와 연결되어 페어링을 이루고 있음
    - 페어링은 관계의 멤버이고, 관계는 페어링의 집합체



## **2. Relational Theory**



### 2.1. Relational Model



Structure/Definition of Relational Model, Attributes



Relationa Schema/Instance, Keys, Schema Diagram



Relational Algebra





관계형 데이터베이스

- 관계형 데이터 모델을 바탕으로 만들어진 데이터베이스
  - 테이블(table)로 이루어져 있으며, 이 테이블은 키(key)와 값(value)의 **관계**를 나타냄
- 관계형 데이터베이스를 관리하는 시스템은 **RDBMS**(Relational Database Management System)이라 함
  - MS-SQL, MySQL, MariaDB, PostgreSQL, DB2 등



관계형 데이터베이스의 구성 요소

- 테이블
  - 2차원 표 형태의 데이터 저장 공간
  - 행: 저장하려는 **하나의 개체를 구성하는 여러 값**을 가로로 늘어뜨린 것
  - 열: 저장하려는 데이터를 **대표하는 이름과 공동 특성**
- 키
  - 수많은 데이터를 구별할 수 있는 유일한 값
  - 슈퍼키, 후보키, 기본키, 보조키(대체키), 외래키로 분류할 수 있음 



키의 종류

- 슈퍼키
  - 튜플을 **유일하게 식별**하기 위해서 사용되는 **속성들의 집합**
  - 예) 학생들의 정보를 나열한 테이블에서 학생 식별에 학번과 주민번호가 사용될 수 있음
    - 각각은 학생을 유일하게 식별할 수 있고 또 이 둘의 조합 역시 학생을 유일하게 식별할 수 있음
    - 학번, 주민번호, 학번 + 주민번호 세 가지가 슈퍼키로 사용될 수 있음
- 후보키
  - 슈퍼키이면서 **최소성을 만족시키는** 키
    - 모든 레코드를 유일하게 식별하는 데 꼭 필요한 속성만으로 되어있을 것
  - 예) 학번과 주민번호는 굳이 조합하지 않아도 모든 튜플을 유일하게 식별할 수 있음
    - 학번, 주민번호 두 가지가 후보키로 사용될 수 있음
- **기본키**
  - 후보키 중에 **개인 정보 노출이 가장 적은 데이터를 선정**하는 것이 일반적임
  - 예) 학번과 주민번호 중 학번을 기본키로 채택
  - 값이 중복되지 않아야 하고 NULL값을 가질 수 없음
- 보조키
  - 후보키 중에 기본키로 지정되지 않은 값: 속성은 기본키와 같음
- 외래키
  - 특정 테이블에 포함되어 있으면서 **다른 테이블의 기본키**로 지정된 키
  - 예) 학생 정보 테이블에 있는 학과 코드: 학과 정보 테이블과 학생 정보 테이블을 이어줌
- 복합키
  - 여러 열을 조합하여 기본키 역할을 할 수 있게 만든 키
  - 예) 과목 정보 테이블에서 (과목코드+교수+강의시간) 조합으로 수업을 유일하게 식별함



데이터 무결성

- 데이터의 정확성, 일관성, 유효성을 유지하는 것
- 4가지 종류가 있음
  - 개체 **무결성** (Entity integrity) 
    - 모든 테이블이 기본 키 (primary key)로 선택된 필드 (column)를 가져야 함
    - 기본키로 선택된 필드는 빈 값을 허용하지 않음
  - 참조 **무결성** (Referential integrity) 
    - 서로 참조 관계에 있는 두 테이블의 데이터는 항상 일관된 값을 유지함
    - (참조되는 테이블의)기본키와 (참조하는 테이블의)참조키 간의 관계는 항상 유지되어야 함
    - FK의 값은 NULL이거나 참조하는 테이블의 PK 값 중 하나여야 함
  - 도메인 **무결성** (Domain integrity)
    - 테이블에 존재하는 필드의 무결성을 보장하기 위한 것으로 올바른 데이터가 입력됐는지를 체크하는 것
    - 예) 성별 속성의 도메인은 남, 여로 그 외의 값은 입력 불가
  - **사용자 정의 무결성** 규칙 (User-defined Integrity)
    - 사용자가 정의한 무결성 규칙으로 개체, 참조, 도메인 무결성에 포함되지 않는 것



참조 규칙

- 참조되는 테이블에 변경이 있을 때 **참조 무결성을 지키기 위해** SQL에 설정되어 있는 규칙
  - 실수로 관련 데이터가 삭제되거나 수정되는 것을 막아줌
- 참조 무결성 강화 규칙으로 다음과 같이 5가지의 설정이 가능함
  - CASCADE
    - 참조되는 테이블의 레코드를 삭제할 때, 참조하는 테이블의 레코드가 **자동으로 삭제**됨
    - 참조되는 테이블의 기본 키 필드값이 바뀌면 참조하는 테이블의 필드값도 변경됨
  - RESTRICT
    - 참조하는 테이블에 일치하는 레코드가 있다면 참조되는 테이블의 레코드를 갱신/삭제할 수 없음
  - NO ACTION
    - 참조되는 테이블에 대해 갱신 또는 삭제를 했을 때, SQL문장 실행 종료 시에 FK 제약을 만족하는지 체크하고 만족하면 SQL문 실행이 성공, 아니면 실패하도록 함
  - SET NULL
    - 참조되는 테이블의 행이 갱신 또는 삭제되면 참조하는 테이블에서 대응되는 행의 FK 값이 NULL이 됨
  - SET DEFAULT
    - SET NULL과 동일한 경우에 FK 값이 NULL이 아니라 DEFAULT값이 됨



### 2.2. Formal Relational Theory Languages



Select / Project / Union / Set Difference



Cartesian Product / Rename



Formal Definition, Intersection / Natural Join / Assignment





## **3. SQL**



SQL

- Structured Query Language
- RDBMS에서 데이터를 다루고 관리하는 데 사용하는 **질의 언어**
  - 조회, 데이터 조작, 객체 조작 등
  - DQL(Data Query Language)
    - 데이터를 원하는 방식으로 **조회**하는 명령어
  - DML(Data Manipulation Language)
    - **데이터를 저장, 수정, 삭제**하는 명령어
  - DDL(Data Definition Language)
    - 테이블을 포함한 여러 **객체를 생성, 수정, 삭제**하는 명령어
  - TCL(Transaction Control Language)
    - **트랜잭션 데이터의 영구 저장, 취소** 등과 관련된 명령어
  - DCL(Data Control Language)
    - **데이터 사용 권한**과 관련된 명령어





### 3.1. Basic SQL



Create/Drop/Alter Table





Basic Structure - Select / From / Where





Rename, Strings, Null





Aggregate Functions, Nested Query





Insert, Delete, Update



데이터를 조회하는 3가지 방법

- SELECTION
  - **행 단위**로 원하는 데이터를 조회
- PROJECTION
  - **열 단위**로 원하는 데이터를 조회
  - SELECTION, PROJECTION을 함께 사용하여 상세하게 조회할 수도 있음
- JOIN
  - **두 개 이상의 테이블을 연결하여 하나의 테이블처럼 조회**
  - SELECT문을 사용할 때 자주 사용됨



`SELECT [조회할 열1 이름], [열2], ..., [열N] FROM [조회할 테이블 이름];`

- 조회할 열 이름에 `*`를 넣으면 전체 열 조회 가능: `SELECT * FROM EMP;`
- 띄어쓰기와 줄 바꿈 활용
  - 명령 수행에 영향을 주지 않기 때문에 가독성을 위해 **SELECT와 FROM을 다른 줄에 적는 것 권장**



중복 제거

- DISTINCT를 이용하여 중복을 제거하고 특정 데이터 종류만 확인 가능

- ```SQL
  SELECT DISTINCT DEPTNO
  	FROM EMP;
  ```

- ALL을 이용하면 반대로 중복을 제거하지 않고 그대로 출력함

- ```SQL
  SELECT ALL DEPTNO
  	FROM EMP;
  ```



정렬

- ORDER BY를 사용하여 출력 데이터를 정렬함

- SELECT문의 제일 마지막에 `ORDER BY [정렬하려는 열(여러 개 가능)] [정렬 옵션]` 을 붙여 사용

  - 정렬 옵션은 ASC(기본 값), DESC 존재

  - ```SQL
    SELECT *
    	FROM EMP
    ORDER BY SAL;
    ```

  - 여러 개 조건을 붙이면 먼저 오는 열을 우선 정렬하고 값이 같으면 그 다음 열 기준으로 정렬

    - `ORDER BY DEPTNO DESC, ENAME;`

- 정렬은 느리기 때문에 **가능하면 사용하지 않을 것**을 권장



별칭 설정

- SELECT 절에 명시한 열 이름이 아니라 별칭이(alias) 출력되도록 할 수 있음

  - 편의를 위해 + 해당 열이 어떻게 도출되었는지 노출되지 않기 위해 사용함

- **별칭을 하나씩 지정**하는 방법과 **연산식을 사용**하는 방법 존재

  - 연산식을 사용하여 연수입 출력하기(월급*12 + 상여)

  - ```SQL
    SELECT ENAME, SAL, SAL*12+COMM, COMM
    	FROM EMP;
    ```

  - 별칭을 지정하는 방법

    - 4가지가 있는데 보통 3번째를 많이 사용(한 칸 띄우기, 한 칸 띄우고 큰 따옴표, **한 칸 띄우고 AS**, 한 칸 띄우고 AS 다음에 큰 따옴표 )
    - `SELECT ENAME, SAL, SAL*12+COMM AS ANNSAL, COMM FROM EMP;`
    - SQL문에 따옴표 사용이 좋지 않기 때문: 프로그래밍 언어에서 문자열로 ("SQL") 사용 시 에러 발생



WHERE

- **특정 조건을 기준으로** 원하는 행을 출력

  - WHERE절에는 조건식이 들어감: 조건식이 참인 경우에만 출력

- FROM 다음에 WHERE 절을 이용함

  - ```SQL
    SELECT *
    	FROM EMP
    WHERE DEPTNO = 30;
    ```

  - SQL문에서는 동등 연산자가 ==가 아니라 =임

- WHERE문과 함께 사용하는 연산자

  - **논리 연산자 AND, OR**을 이용하여 **여러 개의 조건식 적용도 가능**: 조건식 갯수는 무제한

    - 여러 개 조건식이 묶여 있을 때 NOT을 이용하여 한번에 뒤집는 경우 많음

  - **IN**을 이용하여 조건식 갯수를 줄일 수 있음

    - OR을 여러 개 사용한 경우

    - ```SQL
      SELECT *
      	FROM EMP
      WHERE JOB = 'MANAGER'
         OR JOB = 'SALESMAN'
         OR JOB = 'CLERK';
      ```

    - IN을 사용한 경우

    - ```SQL
      SELECT *
      	FROM EMP
      WHERE JOB IN ('MANAGER', 'SALESMAN', 'CLERK');
      ```

  - **BETWEEN A AND B**를 이용하여 조회하기

    - ```SQL
      SELECT *
      	FROM EMP
      WHERE SAL BETWEEN 2000 AND 3000;
      ```

  - 일부 문자열이 포함된 데이터를 조회할 때 사용하는 **LIKE**

    - ENAME 열 값이 대문자 S로 시작하는 데이터를 조회하라는 SQL문

    - ```SQL
      SELECT *
      	FROM EMP
      WHERE ENAME LIKE 'S%';
      ```

    - 와일드 카드: ( `%, _` ) 특정 문자 또는 문자열을 대체함

  - **IS NULL**을 이용해 데이터가 NULL인 행을 조회하기

    - ```SQL
      SELECT *
      	FROM EMP
      WHERE COMM IS NULL;
      ```

    - NULL은 비교 연산자로 비교하면 결과 값도 NULL이 되기 때문에 IS NULL을 이용해야 함

  - **집합 연산자**

    - 두 개 이상의 SELECT문의 결과 값을 연결함
    - 열 갯수와 각각의 열의 자료형이 일치해야(열 이름은 달라도 ok)연결 가능
    - UNION: 합집합으로 묶음, 중복 제거
    - UNION ALL: 합집합으로 묶고 중복 제거하지 않음
    - MINUS: 차집합 - 먼저 작성한 SELECT문의 결과에서 다음 결과를 빼 줌
    - INTERSECT: 교집합





### 3.2. Intermediate SQL



Joins - Natural, Inner/Outer





Integrity Constraints, Authorization



### 2.2. JOIN



![join](https://miro.medium.com/max/1932/0*Mu_d-mJMmaVX-j0P)



JOIN이란?

- 중복을 없애기 위해서 **정규화**한 테이블들에서 원하는 결과를 도출하기 위해 **다시 조합**하는 것
- 적어도 하나의 칼럼을 서로 공유하고 있는 테이블들을 연결하여 **데이터 검색에 활용**함
  - 보통 공통된 값인 PK 및 FK 값을 사용하여 JOIN
  - JOIN 연산자에 따라, From 절의 JOIN 형태에 따라서 구별함



JOIN의 종류

- 연산자에 따른 분류
  - EQUI JOIN : 두 테이블 간의 칼럼 값들이 서로 일치하는 경우(`=`연산자 사용)
  - NON EQUI JOIN : 두 테이블 간의 칼럽 값들이 일치하니 않는 경우(비교 연산자 사용)
- FROM 절의 JOIN 형태에 따른 분류
  - INNER JOIN : JOIN 조건에서 **값이 일치하는 행만** 반환
  - OUTER JOIN : JOIN 조건에서 **한쪽 값이 없더라도** 행을 반환



JOIN의 동작 방식

- JOIN이 어떤 방식으로 동작하고 있는지는 **실행계획**에서 확인 가능
  - 적절하지 않은 경우 오라클 힌트를 이용하여 변경 가능
- NESTED LOOP JOIN : 중첩 for문과 같은 방식으로 **JOIN 조건을 반복적으로 체크**하면서 수행
  - INNER TABLE의 INDEX를 이용하지 않으면 굉장한 비효율이 발생함
  - 1:N관계를 가지는 경우 1인 쪽이 OUTER TABLE로 설정되는 것이 좋음 
  - 예)걸그룹 테이블과 멤버 이름 테이블을 그룹명 기준으로 JOIN할 때 그룹을 기준으로 멤버 이름 테이블을 scan하면서 멤버 이름을 가져와야 함
- SORT MERGE JOIN : 두 테이블을 각각 JOIN 컬럼 기준으로 sort한 후 JOIN을 수행
  - INNER TABLE에 적절한 INDEX가 없어서 NESTED LOOP JOIN을 사용하기 비효율적인 경우에 이용
  - 범위로 JOIN을 하는 경우에도 (NON EQUI JOIN) 적절함
  - sorting은 PGA영역에서 수행됨 : 경합이 발생하지 않아 성능 상 이점이 있음
- HASH JOIN
  - OUTER TABLE을 **Build Input**으로 삼아서 Hash 영역에 저장하고, INNER TABLE의 JOIN 컬럼을 기준으로 해시 함수를 적용하여 해시 테이블을 탐색하면서 JOIN을 수행
  - EQUI JOIN만 가능함
  - INNER TABLE이 대용량이고 OUTER TABLE이 작을 때(Hash영역 크기 제한) 좋음
  - 해시 키 값으로 사용되는 컬럼에 중복이 적어야 함
  - 배치에서 쓰면 좋음



#### INNER JOIN

![INNER JOIN](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile9.uf.tistory.com%2Fimage%2F99799F3E5A8148D7036659)

EQUI JOIN

- 기준 테이블과 JOIN할 테이블의 **칼럼 값들이 서로 정확하게 일치하는 경우** 겹치는 값들을 가져오는 것

- WHERE 절에 `=`  동등 연산자를 사용하여 JOIN 조건을 명시

- 일반적으로 PK, FK로 지정된 칼럼을 JOIN으로 많이 사용함

- EQUI JOIN의 성능을 높이려면 **INDEX 기능을 사용하는 것이 좋음**

  - 조건이 일치하는지 확인하기 위해 매번 FULL SCAN을 하면 굉장히 비효율적이기 때문

- 예) 테이블 A와 B에서 각각 이름과 나이를 가져옴 

  - ```sql
    SELECT A.NAME, B.AGE
    FROM EX_TABLE A				--FROM EX_TABLE A, JOIN_TABLE B로 쓰면 JOIN구문 생략 가능
    EQUI JOIN JOIN_TABLE B		--EQUI JOIN을 INNER JOIN으로 변경 가능
    ON A.NO_EMP = B.NO_EMP
    ```

  - 사원 번호가 같은 사람에 대해 조회 : 사원 별 나이-이름 테이블이 된다



NATURAL JOIN

- 두 테이블의 **동일한 이름을 가지는 칼럼을 모두 JOIN하는 것**

- EQUI JOIN에서 동일한 속성이 두 번 나타나게 되는데, **중복을 제거하여 같은 속성을 한번만 표기**함

  - ```sql
    SELECT A.NAME, B.AGE
    FROM EX_TABLE A NATURAL JOIN JOIN_TABLE B
    ```

  - USING문을 사용하면 칼럼을 선택해서 JOIN할 수 있음

  - ```sql
    SELECT A.NAME, B.AGE
    FROM EX_TABLE A JOIN JOIN_TABLE B
    USING No_EMP;
    ```

- 테이블 별칭(alias)을 사용하면 오류가 발생함



NON EQUI JOIN

- 조인 대상 테이블의 **어떤 칼럼 값도 일치하지 않을 때** 사용하며 '=' 이외의 연산자를 사용

- 사용 빈도가 매우 낮다고 함

- 연산자 : BETWEEN AND, IS NULL, IS NOT NULL, IN, NOT IN, < , >, >=, <=

- ```sql
  SELECT [테이블명1.]속성명, [테이블명2.]속성명 ....
  FROM 테이블명1, 테이블명2..
  WHERE (NON EQUI JOIN 조건)	--JOIN 키워드는 안 쓰고 그냥 조인함
  ```



SELF JOIN

- **같은 테이블 내에서** 2개의 속성을 연결하여 EQUI JOIN을 하는 것

  - 주의할 점 : JOIN할 때 **별칭을 반드시 입력**해주어야 함

- 한 테이블 내에 이미 종속 관계가 있을 때 사용(학번 - 학생 이름 - 선배의 학번)

- ```sql
  SELECT a.S_NO AS 학번, a.S_NAME AS 이름, b.S_NAME AS 선배
  FROM STUDENT a, STUDENT b
  WHERE a.S_SENIOR = b.S_NO;
  ```



#### OUTER JOIN

![LEFT OUTER JOIN](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile6.uf.tistory.com%2Fimage%2F997E7F415A81490507F027)

LEFT OUTER JOIN

- JOIN의 왼쪽에 표기된 데이터를 기준으로 OUTER JOIN을 수행함

- 예) 학생 테이블과 학과 테이블에서 학과 코드 값이 같은 튜플을 JOIN하여 출력

  - ```sql
    SELECT s.S_NO, s.S_NAME, s.D_CODE, d.D_NAME
    FROM STUDENT s LEFT OUTER JOIN DEPARTMENT d
    ON s.D_CODE = d.D_CODE;
    ```

  - INNER JOIN과 달리 **학과 정보가 NULL인 학생도 출력됨**



RIGHT OUTER JOIN

- JOIN의 왼쪽에 표기된 데이터를 기준으로 OUTER JOIN을 수행함

- LEFT OUTER JOIN이랑 다른 것은 위치 뿐이니 위 예제를 다른 문법으로 해보자

  - ```sql
    SELECT s.S_NO, s.S_NAME, s.D_CODE, d.D_NAME
    FROM STUDENT s, DEPARTMENT d
    WHERE s.D_CODE(+) = d.D_CODE;	--LEFT OUTER JOIN의 경우 오른쪽에 (+)를 붙이면 됨
    ```

  - 이번엔 학생이 없는(학생 정보가 NULL인 학과)도 출력됨



FULL OUTER JOIN

- LEFT OUTER JOIN과 RIGHT OUTER JOIN의 결과를 합집합으로 처리한 결과와 동일함

- LEFT, RIGHT OUTER JOIN과 다르게 JOIN을 명시하는 경우만 가능

  - ```sql
    SELECT s.S_NO, s.S_NAME, s.D_CODE, d.D_NAME
    FROM STUDENT s FULL OUTER JOIN DEPARTMENT d
    ON s.D_CODE = d.D_CODE;
    ```

  - 학과코드가 입력 안 된 학생이나 학과명이 없는 학과코드도 모두 출력됨



CROSS JOIN

- Cartesian Product라고도 하며 곱집합을 반환함

- 두 테이블 간에 연결될 수 있는 모든 경우의 수를 산출하여 나타내는 JOIN

- ```sql
  SELECT A.COLOR, B.SIZE
  FROM EX_TABLE A
  CROSS JOIN JOIN_TABLE B
  ```

![cross join](https://www.essentialsql.com/wp-content/uploads/2016/08/Cross-Join-Two-Tables-to-Get-Combinations.png?ezimgfmt=ng%3Awebp%2Fngcb11%2Frs%3Adevice%2Frscb11-1)







## **4. Database Design & The E-R model**



Design Process





Entity, Relationship, E-R Diagram





Mapping Cardinality





Extended E-R Features, Weak Entity Sets





Logical Design, Design Issues





## **5. Relational DB Design**





1NF, Functional Dependency





Decomposition, BCNF, Dependency Preservation





3NF, Closure of Attribute Sets, Testing for BCNF





BCNF Decomposition Algorithms, Overall Database Design Process





데이터베이스 이상(**anomaly**)이란?

- 잘못된 테이블 설계로 인해 **데이터의 중복이 발생하여 생길 수 있는 부작용**을 이상이라 함
  - 이상은 **정규화가 되어있지 않기 때문**에 발생함
  - 이상을 해결하기 위해서 속성들 간의 관련성을 파악해서 정규화를 해주어야 함
- 삽입 이상
  - 신규 데이터를 삽입하기 위해 불필요한 데이터를 함께 삽입해야 하는 경우
  - 예) 학번+과목명을 PK로 갖는 수강 과목 테이블에서 한 과목도 안 듣는 학생을 삽입할 때
    - PK는 null값을 가질 수 없기 때문에 "미수강" 항목을 추가로 만들어서 넣어줘야 함
- 갱신 이상
  - 중복되는 데이터 중 일부만 변경하여 데이터의 불일치가 발생하는 문제
  - 예) 3과목을 수강하는 학생의 과를 변경할 때 1개만 변경하면 해당 학생의 과가 무엇인지 모르게 됨
- 삭제 이상
  - 어떤 튜플을 삭제할 때 삭제가 되지 않아야 할 데이터도 같이 지워지는 문제
  - 예) 한 과목만 수강하는 어떤 학생이 수강 취소했을 때 해당 학생의 모든 정보가 지워짐

![예제](https://blog.kakaocdn.net/dn/bcDYpO/btqZreZlrwW/PJBOL8oLXU9zKktsxZKJp1/img.png)



함수적 종속성(Functional Dependency)이란?

- 어떤 릴레이션 R의 속성 X, Y가 있을 때, 다음 상황에서 **Y는 X에 함수적 종속**이라고 함
  - X의 값을 알면 Y의 값을 식별할 수 있고
  - X의 값이 변화함에 따라 Y의 값이 달라짐
- 완전 함수적 종속성(Full Functional Dependency)
  - Y가 **속성 집합 X 전체에 대해서만 함수적 종속**이 되는 경우
  - 예) 위 예시에서 학점은 학번+과목명 전체에 대해서만 종속이고 둘 중 하나에 종속되진 않음
- 부분 함수적 종속성(Partial Functional Dependency)
  - Y가 **속성 집합 X의 일부에 대해서도 함수적 종속**이 되는 경우
  - 예) 위 예시에서 이름, 학과는 학번+과목명 전체에 대해서도, 학번에도 종속임



정규화와 반정규화

- 정규화 데이터베이스
  - 중복을 최소화하도록 설계된 테이블
  - 트랜잭션이나 CRUD가 많이 일어나는 경우에 사용(**OLTP**)
    - On-Line Transaction Processing : 비즈니스 거래 데이터로 실시간으로 CRUD가 일어남
  - 저장 공간 최소화, 안정성/무결성 유지, 이상 현상 제거라는 장점 있음
- 반정규화 데이터베이스
  - 개발이나 운영 상의 이슈로 인해 정규화된 **테이블을 역으로 합치는 경우**
    - 정규화된 테이블을 과다하게 JOIN하면 비용이 크기 때문에 의도적으로 정규화 원칙을 어김
  - 대량의 데이터를 읽고 처리하는 것이 중요한 경우에 사용(**OLAP**)
    - On-Line Analytical Processing : 분석과 집계를 위한 데이터로 변경이 적음
  - 빠른 조회가 가능하고 쿼리가 간단하여 버그 발생 가능성 낮다는 장점 있음



1NF

![1nf](https://blog.kakaocdn.net/dn/c38D78/btqZpVMHIk8/0YFf9MHNgT4EGad1kGoz2K/img.png)

- 테이블은 **관계**여야 하며, 속성의 **원자성을 확보**하는 것을 제1정규형이라고 함
  - 각각 관계된 데이터 모임이 되도록 하기 위하여 분리된 테이블을 만들고 PK를 설정함
  - 도메인이 원자값이어야 함 : **중복되는 항목이 없어야 한다**
    - 여기에 NULL을 허용하지 않는 등 조건이 좀 추가될 수 있는데 이 정도만 알아두자
  - 예시에서 한 도메인에 여러 값이 들어가 있는데, 이를 다 나눠줘야 함 



2NF

![2nf](https://blog.kakaocdn.net/dn/dKQhio/btqZpfLsjIO/CBSqtuNzEW3oPPC4mVMoH0/img.png)

- 후보 키 K와, K에 속하지 않는 속성 A가 있을 때, A를 결정하기 위해 K 전체를 참조해야만 하는 경우
  - 한 마디로 **1NF 테이블에서 부분 함수적 종속성을 제거**하면 2NF가 됨
    - **갱신이상을 해결**해 줌(모든 갱신이상을 해결하는 것은 아님)
  - 예) 기본키 학번+과목명에 대해 학과, 학비는 부분 함수적 종속성을 가짐(학번→학과, 학번→학비)
    - 학번, 과목명, 학점 테이블과 학번(PK), 학과, 학비 테이블 이렇게 2개로 분할하여 해결



3NF

- 2NF인 테이블에서 **모든 속성이 기본키에만 의존**하며, 다른 후보키에 의존하지 않는 경우
  - **이행적 함수 종속**(Transitive Functional Dependency)을 없애야 함
    - X→Y이고 Y→Z이면 X→Z이고, Z가 X에 이행적 함수 종속이라고 함
  - 예) 학번→학비는 사실 학번→학과, 학과→학비 이기 때문에 이행적 함수 종속임
    - 학번, 학과 테이블과 학과, 학비 테이블로 분할해주어야 함
- **3NF가 되면 정규화되었다**고 표현할 수 있음 : 삽입, 갱신 삭제 이상이 (거의)일어나지 않음



BCNF(Boyce-Codd Normal Form)

![bcnf](./img/bcnf.png)

- 3NF인 테이블에서 **모든 종속성**에 대해서 다음을 만족하면 BCNF이다

  - X→Y는 trivial functional dependency이다 (Y는 X에 포함되는 속성이다)
    - 예) {Employee_ID, Employee_Name} –> Employee_ID
  - X는 슈퍼키이다
  - 다른 말로 하면 **모든 결정자가 슈퍼키**이면 됨

- 예) 테니스 코트 예약을 받는 상황에서 예약 타입→코트 종속성이 있음

  - 예약 타입 SAVER는 회원이 코트1을 예약, STANDARD는 비회원이 1을 예약, PREMIUM-A,B도 회원/비회원이 코트 2를 예약하는 경우
  - 타입에 의해 코트 번호를 결정할 수 있는 종속성이 있으나 코트 번호는 타입의 부분집합이 아니고, 예약 타입은 슈퍼키가 아님
    - 예약타입 + 시작 시각 or 종료 시각을 해 줘야 유일성 확보 가능
  - Rate type을 PK로 가지고 Court, Member flag 속성을 갖는 Rate types table과 {Court, Start time}을 PK로 가지고 Member flag, End Time 속성을 갖는 Today's bookings table으로 분할하여 BCNF 정규화

  ![bcnf2](./img/bcnf2.png)



4NF

- BCNF에서 **다치 종속**(multivalued dependency)을 제거하면 4NF이다

  - 의미적으로 상관없는 속성을 한 테이블에 표현하면, 같은 값을 여러번 입력해야하는 다치 종속이 발생함
  - 한 테이블에 X→Y와 X→Z 종속성이 있지만 Y, Z는 아무런 연관이 없는 경우
  - 예) 피자집, 피자 메뉴, 배달 가능 지역 : 메뉴와 지역은 피자집에 종속되나 이 둘은 관계가 없음

  ![4nf](./img/4nf.png)



5NF

- 4NF에서 **조인 종속**을 제거하면 5NF이다

  - 조인 종속 : 어떤 릴레이션의 속성의 부분집합끼리 JOIN했을 때 항상 자기 자신이 되는 경우

  - 조인 종속일 때는 **어떤 릴레이션의 모든 속성이 슈퍼키**임

  - 예) 개발자, 프로그래밍 언어, 자격증

    - 한 명의 개발자는 여러 언어를 가질 수 있고, 한 언어는 여러 개발자에 속할 수 있음
    - 한 자격증은 여러 개발자에 속할 수 있고, 한 개발자는 여러 자격증을 가질 수 있음
    - 한 언어는 여러 자격증에 속할 수 있고, 한 자격증은 여러 언어를 가질 수 있음

    ![5nf](https://media.vlpt.us/images/moning02004/post/43a5c09a-d9ce-4b73-9cb7-b6887016de6a/image.png)



## **6. Storage & File Structure**



OverView of Physical Storage Media, Magnetic Disc and Flash Storage



RAID





File Organization, Data-Dictionary Storage, Data Buffer



## **7. Indexing & Hashing**



Basic Concepts, Ordered Indices





B+-Tree Index Files - Overview





B+-Tree Index Files - Insertion





B+-Tree Index Files - Deletion





Static Hasing





Dynamic Hashing





Comparision of Ordered Indexing and Hashing, Index Definition in SQL





인덱스란?

- 추가적인 쓰기 작업과 저장공간을 활용하여 DB테이블의 **검색 속도를 향상시키기 위한 자료구조**
  - 특정 column에 대해 데이터와(search key) 레코드의 주소를(pointer) 매핑해 따로 저장함
  - 내부적으로는 B-Tree, B+Tree 또는 해시테이블을 활용하여 만들어짐
    - 각각의 방식은 **Ordered Index, Hash Index**라고 함
  - 해시 테이블은 등호 연산에만 특화되어있기 때문에 B-Tree나 B+Tree가 사용되는 것이 일반적
    - DB는 부등호 연산이 보통 : range queries로 찾는 경우가 많기 때문에
- 인덱스의 필요성
  -  **Full Table Scan** : DB에서는 조회 요청이 들어올 때 테이블의 **모든 데이터를 검색**함
  -  데이터의 수가 늘어날 수록 검색이 느려지기 때문에 공간을 다소 희생해서 속도를 높이는 것
     - 인덱스는 데이터 외의 공간에 저장되고, 통상 10%정도를 추가로 필요로 함



Ordered Index의 종류

- Clustered(Primary Index)
  - 인덱스가 참조하는 레코드가 **순서대로 정렬**된 경우 : 범위 검색에 강점이 있음
    - 새로 저장하면 뒤에 있는 데이터를 하나씩 다 밀어줘야 함
  - 보통 PK를 Primary Index의 search key로 사용함
    - 테이블마다 단 하나만 존재할 수 있음
- Non-Clustered(Secondary Index)
  - 인덱스가 참조하는 레코드가 **순서와 상관없이 저장**됨 : 조회가 그렇게 효율적이진 않음
    - 레코드가 순서 상관 없이 있는거지 인덱스는 정렬되어 있음
    - cardinality가 낮은 경우에 사용하면 좋음!
  - Primary Index를 제외한 나머지를 다 Secondary라고 함 : 한 테이블에 여러개가 존재 가능
- Dense Index
  - 모든 레코드에 대해 인덱스 레코드를 가지는 인덱스
  - Secondary Index는 dense여야 함 : 레코드가 정렬되어있지 않기 때문
- Sparse Index
  - 테이블의 레코드 중 일부만 인덱스 파일에 반영된 경우 : Primary Index는 sparse여도 됨
  - dense index 대비 조회 속도를 약간 포기하고 삽입/갱신 오버헤드를 줄인 것
    - 삽입의 경우 **새로운 블록이 생성되었을 때만 삽입**해주면 됨
    - 삭제의 경우 해당 블록의 entry가 삭제되었을 때만 다음 search key로 바꿔주면 됨



인덱스의 구조와 원리

- 인덱스는 항상 정렬된 상태로 유지되어야 함
- 인덱스는 **Range scan**을 함
  - key column 순으로 정렬시켜두고 특정값을 찾다가 해당 범위를 넘는 값을 만나면 **멈춤**
  - 예) 5번 멤버를 찾기 위해 5번 이하의 멤버를 타고 리프까지 내려간 후 탐색하다 5번을 만나면 stop
  - ![range scan](./img/index.png)
  - Full table scan의 경우 원하는 값을 찾아도 뒤에 또 있을 수 있으니(정렬되지 않아서) 계속 찾음
- 위와 같은 Multilevel Index의 경우 **상위 레벨(Outer Index)은 메인 메모리에 저장**할 수 있음
  - 모든 인덱스가 메모리에 올라가면 좋지만 공간이 부족하면 하위 레벨은 디스크로 내려감
  - 내려가더라도 해당 범위만 scan하면 되기 때문에 조회 속도는 빠름



인덱스를 사용해야 하는 경우

- **Cardinality**가 높은 column에 인덱스를 적용한다
  - cardinality is the number of elements in the set
    - 여러 튜플들이 다 다른 값을 가질 때 cardinality가 높음
    - 성별이나 수강 과목 같은 경우 여러 튜플들이 동일한 값을 갖고 있으므로 cardinality 낮음
  - 같은 인덱스가 적용된 데이터가 많으면 그거 대상으로 다시 scan해야 해서 속도 향상이 적음
- SELECT문의 WHERE, JOIN이 자주 사용되는 경우
- INSERT, UPDATE, DELETE 등 데이터 수정이 적게 일어나는 경우
  - **원본 데이터의 수정이 있을 때마다 모든 인덱스의 수정이 필요**함
    - 블록 내의 주소에 변동이 있을 수 있기 때문
  - INSERT
    - 인덱스는 정렬된 상태로 존재하기 때문에 중간에 새 데이터가 들어온다면 하나씩 밀어줘야 함
    - 최악의 경우 Leaf Block이 꽉 차서 데이터를 다른 블록으로 옮겨야 하기도 함
  - DELETE 
    - 인덱스 테이블에서는 데이터를 삭제하지 않고 **사용하지 않음 표시**만 함
    - DELETE가 빈번하게 일어나면 금방 자리를 다 차지하고, 최악의 경우 원본보다 인덱스가 길어짐
  - UPDATE
    - 인덱스는 데이터를 변경하지 않음
    - DELETE로 사용 안 함 처리를 한 후 INSERT하기 때문에 부하가 큼



## **8. Query Processing**



Overview, Measures of Query Cost





Select Operation





Sorting





Join Operation - Nested Loop





Join Operation - Hash





Evaluation of Expressions, Cost Estimation of Expressions





## **9. Transactions**





Transaction Concept, Transaction Model





Transaction States, Transaction Isolation & Schedules





Serializability, Recoverability





트랜잭션이란?

- 하나의 그룹으로 처리되어야 하는 여러 **쿼리들을 묶은 작업의 논리적 단위**
  - 트랜잭션은 DML 쿼리들의 조합으로 구성됨
  - 예) 송금 트랜잭션 : 돈 보내는 사람의 잔고 UPDATE + 받는 사람의 잔고 UPDATE
  - 쿼리들을 논리적으로 그룹화하기 위해 **커밋**과 **롤백**이 이루어 짐
- 트랜잭션은 한 **작업의 완전성**을 보장함
  - 트랜잭션 내의 모든 처리대상 명령문들이 반드시 완전히 수행되어야 함
  - 어느 한 문장이라도 에러가 발생한다면 트랜잭션으로 묶인 전체 명령문은 모두 취소



트랜잭션의 성질 ACID

- Atomicity
  - 트랜잭션 중간에 어떠한 문제가 발생한다면 트랜잭션에 해당하는 어떠한 작업 내용도 수행되어서는 안되며 아무런 문제가 발생되지 않았을 경우에만 모든 작업이 수행되어야 함
- Consistency
  - 트랜잭션은 발생 전후에 **데이터의 일관성**을 보장해야 함
  - 데이터의 일관성 : 한 데이터를 서로 다른 장소에서 참조했을 때 조회 결과가 일치하는 것
- Isolation
  - 각 트랜잭션은 서로 간섭 없이 실행되어야 함
  - isolation이 보장되지 않으면 트랜잭션이 원래 상태로 되돌아갈 수 없음
- Durability
  - 트랜잭션이 종료되면 영구적으로 DB에 작업의 결과가 저장되어야 함
  - 이를 위해 트랜잭션 종료시 커밋 또는 롤백을 수행함



커밋과 롤백

- 트랜잭션을 논리적인 작업의 단위로 구분하기 위해  커밋과 롤백을 이용함
  - 이를 통해 **데이터 무결성**을 보장할 수 있음
- 커밋
  - 트랜잭션으로 묶인 모든 쿼리가 실행되어 성공하면 트랜잭션의 결과를 DB에 **영구적으로 저장**하는 작업
  - 영구적으로 변경하기 전에 데이터의 변경사항을 확인할 수 있음
  - DDL과 DCL 명령문이 수행되면 자동으로 커밋됨
- 롤백
  - 트랜잭션의 쿼리가 하나라도 실패하면 **실행 결과를 모두 취소하고 DB를 트랜잭션 실행 전의 상태로 되돌리는 것**
  - 컴퓨터가 다운되거나 SQL 프로그램이 비정상 종료되면 자동으로 롤백됨



트랜잭션의 복구

- UNDO
  - 사용자가 했던 작업을 반대로 진행하여 원상태로 되돌림
  - 롤백 작업 시에는 UNDO를 이용함
- REDO
  - 사용자가 했던 작업을 그대로 반복하여 진행
  - DB서버에는 기본적으로 모든 작업이 REDO에 기록됨 : 장애가 발생해도 안 날아감
- 장애 복구의 흐름
  1. REDO 데이터를 이용해서 마지막 Check point부터 장애까지의 버퍼 캐시를 복구
  2. UNDO를 이용해서 커밋되지 않은 데이터를 모두 롤백하여 복구 완료



#### isolation level

여러 트랜잭션이 동시에 DB에 접근할 때 어떻게 제어할지에 대한 설정

- isolation level에 따라 **성능을 얻기 위해서 정합성을 얼마나 포기할 것인지** 정함
- 데이터 정합성과 성능(동시성)은 trade-off 관계를 가지고 있음
  - ACID를 엄격히 지키면 성능 저하
  - ACID를 완벽히 지키는 4레벨부터(Serializable) 지키지 않는 1레벨까지 4단계 존재함



Read-Uncommitted

- 트랜잭션이 커밋 되기 전에 데이터가 변경된 내용을 다른 트랜잭션이 조회 가능
- **Dirty Read**, Non-Repeatable Read, Phantom Read 발생 가능
  - 한 트랜잭션이 수정한 데이터를 다른 트랜잭션이 조회한 후 롤백이 일어난 경우
  - 무효가 된 데이터를 읽고 처리했기 때문에 문제가 생김



Read-Committed

- 커밋이 완료된 트랜잭션의 변경 사항만 다른 트랜잭션에서 조회 가능
- 아직 커밋되지 않았다면 변경 전 데이터를, 커밋됐다면 변경 후의 데이터를 읽음
- **Non-Repeatable Read**, Phantom Read 발생 가능
  - 한 트랜잭션에서 수정하고 커밋한 데이터를 다른 트랜잭션에서 커밋 이전과 이후에 각각 조회한 경우
  - 두 번의 조회에 대해 값이 다르다는 문제가 생김



Repeatable-Read

- 한 트랜잭션이 조회한 데이터는 항상 동일함을 보장
- 조회를 한 번 했으면 트랜잭션 종료시까지 다른 트랜잭션이 변경하거나 삭제 불가
- **Phantom Read** 발생 가능
  - 어떤 범위의 레코드를 읽었을 때 첫 번째 쿼리에선 없던 데이터가 새로 생긴 경우



Serializable

- 한 트랜잭션에서 사용하는 데이터를 다른 트랜잭션에서 접근 불가



## **10. Concurrency Control, Recovery System**





Concurrency Control





Failure Classification, Storage Structure, Recovery and Atomicity





Recovery Alogorithm - Log-based Recovery, Buffer Management





NoSQL의 종류

- Aggregate-oriented Model
  - 집합 지향 모델은 분산 시스템에서 사용하기 적합하며 **JOIN 연산이 불가능**
    - 이를 지원하기 위해 MongoDB 등에서는 **Map Reduce**를 제공함
  - Key-value
    - 데이터를 key-value pair로 저장함
    - 수평적 확장이 용이하고 API가 간단함
    - **value의 내용을 사용한 쿼리가 불가능**함
    - Redis, Amazon Dynamo DB, LevelDB 등이 있음
  - Document
    - 계층적 구조를 갖는 document를 이용, 데이터를 key-document pair로 저장함
    - **document 내의 item을 활용한 쿼리가 가능**함
    - ORM이 필요하지 않음 : document가 객체의 형식을 갖고 있기 때문(xml, JSON)
    - Mongo DB, Couch DB 등
  - Column-family
    - key가 row(키 값), column-family, column-name으로 구성됨
    - key에서 필드를 결정 : 질의는 row, column-family, column-name을 통해 수행
    - **클러스터링**이 쉽게 이루어짐
    - HBase, Cassandra 등
- Graph Model
  - 개체와 관계를 그래프 형태로 표시 : 데이터는 연속적인 노드, 관계, 특성의 형태로 저장됨
  - 데이터 간의 관계가 탐색의 키인 경우에 적합함
    - SNS에서 친구의 친구를 찾는 기능에 최적화됨
    - 연관된 데이터를 추천해주는 추천 엔진이나 패턴 인식 등에도 적합함
  - ACID 트랜잭션을 지원함
  - 클러스터링에는 적합하지 않음



클러스터링 vs 리플리케이션

- 클러스터링이란?
  - 여러 개의 DB를 **수평적인 구조로 구축**하는 방식
    - **Fail Over**한 시스템임 : 1개의 노드가 죽어도 다른 노드가 살아있어 장애없이 운영할 수 있음
  - 동기 방식으로 노드들 간의 데이터를 동기화
    - 동기화하는 시간이 필요하므로 Replication에 비해 쓰기 성능이 떨어짐
- 리플리케이션(Replication)
  - 여러 개의 DB를 **권한에 따라 수직적인 구조로 구축**하는 방식
  - 비동기 방식으로 노드들 간의 데이터를 동기화
    - 지연 시간이 거의 없다는 장점 있으나 일관성있는 데이터를 얻지 못할 수 있음



DB 회복 기법

- Log 기반 회복 기법
- 지연 갱신 회복 기법
  - Write 연산을 하지 않고 로그에 DB변경 내역만 저장 : **write 연산은 트랜잭션 완료시 로그를 보고 수행**
  - 트랜잭션 완료시 장애 발생 : write을 아직 하지 않았기 때문에 REDO만 수행
  - 트랜잭션 미완료시 장애 발생 : 로그 무시
- 즉시 갱신 회복 기법
  - 즉시 DB 변경(write 연산 수행) + 로그에 기록
  - 장애 발생 시 로그에 기반하여 **UNDO 실행**
- 체크포인트 회복기법
  - 체크 포인트를 지정하여 장애발생시 체크포인트까지 UNDO 실행 후 다시 REDO 실행
- 그림자 페이징 회복 기법 
  - 하드디스크에 그림자 페이지를 만들고 저장
  - 장애 발생시 하드디스크에 있는 페이지로 주메모리 페이지 변경
  - 장애 미발생시 그림자 페이지 테이블은 삭제

