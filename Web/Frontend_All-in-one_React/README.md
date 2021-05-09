# HTML/CSS/JS



참고자료

- Do It! HTML + CSS + 자바스크립트 웹 표준의 정석
- 삼성 청년 SW 아카데미 4기 수업자료
- Softbank 신입사원 OJT



[TOC]

## **1. HTML**

> 싸피에서 공부한 내용 및 프로젝트 관련 질문





### 1.1. HTML 기초

> HTML과 CSS를 합쳐 퍼블리싱 작업이라고 표현하고 이 작업을 하는 사람을 퍼블리셔라 함



#### HTML

> 웹 컨텐츠의 의미와 구조를 정의
>
> HyperText Markup Language



- **시맨틱 태그**란?
  - 콘텐츠의 의미를 명확히 설명하는 태그
  - 마크업 언어는 텍스트에 역할을 부여하는 것
  - 시맨틱 웹: 웹페이지를 의미와 관련성을 가지는 거대한 DB로 구축하고자 하는 발상
    - **웹 접근성**: 장애인 및 고령자도 웹사이트를 이용할 수 있도록 웹 컨텐츠를 제작하는 방법
    - 키보드를 통해서만 웹을 이용할 수 있게 하거나, 영상에 자막을 넣는 등의 방법이 있음
- Document Object Model
  - 웹 페이지에 대한 인터페이스: HTML 요소들의 구조화된 객체 지향 표현
    - 텍스트로 구성된 HTML을 객체 모델로 변환, 브라우저에 내장되어있음
    - 노드 트리로 표현됨: 태그는 줄기, 컨텐츠는 잎
    - JS에 의해 수정될 수 있는 동적 모델
    - **가상 요소**를 포함하지 않음
      - CSS에 사용되는.... 뭐지?
    - **보이지 않는 요소**를 포함
      - `display: none` 스타일 속성을 갖는 요소
  - 브라우저는 문서를 **파싱**하여 **View Port**에 뭘 렌더링할지 결정(Render Tree)하고, 해당 렌더링을 수행하는데 렌더 트리를 생성할 때 DOM과 CSSOM이 필요
    - 파싱이란 일련의 문자열을 의미 있는 토큰으로 분해하고 그것들로 이루어진 트리를 만드는 과정임
    - 뷰포트란 화면 디스플레이 상에 표시되는 영역
      - 데스크탑 뷰포트는 브라우저 창(visible area)의 뷰포트와 같음: 창의 크기가 조절되면 뷰포트의 크기도 조절됨
      - 모바일 뷰포트는 창보다 크거나 작을 수 있고 **배율의 변경이 가능**
- 요소
  - **태그 + 태그 사이의 내용(content)**
  - 중첩(nested)될 수 있음
    - 교차해서는 안 됨
    - **인라인 태그**는 블록 태그를 포함할 수 없음
  - 블록 요소와 인라인 요소
    - 블록 요소: div, h, p
      - **사용 가능한 최대의 가로 너비**를 사용함
      - 세로는 기본적으로 0이고 내부 컨텐트의 크기에 따라 달라짐(auto)
      - 크기를 지정할 수 있음
      - 수직으로 쌓임
      - margin, padding의 **4방향 모두 사용 가능**
    - 인라인 요소: span, strong, em, i
      - **필요한 만큼의 너비**만 사용함: 기본적으로 가로 세로 0이고 auto임
      - 크기를 지정할 수 없음
      - 수평으로 쌓임: 줄바꿈을 하지 않으면 띄어쓰기 없이 딱 붙음
      - margin, padding의 **가로 방향만 사용 가능**
- 속성
  - 태그의 부가적인 정보: 파일의 경로, 크기 등
  - 요소의 시작 태그에 위치하며 이름과 값의 쌍을 이룸



#### 반응형 웹

> **반응**하여 구성 요소가 변하는 기술
>
> 기기별로 웹사이트의 구조가 최적화되어 보여지는 기능: 최근엔 모바일 퍼스트도 등장

- 브라우저의 가로 넓이에 따른 크기 변경: 반응형 웹 디자인
  - 넓이에 따라 CSS를 추가로 코딩해야 하기 때문에 비용이 증가하는 문제가 있음
  - .container > .row > col-*
- Vue에서 data가 바뀌면 DOM이 알아서 다시 렌더링 되게 하는 기술
  - 웹 어플리케이션이 반응형이라고 말할 수 있으려면 다음 조건들을 만족해야 함
    - 어플리케이션 상태 변화를 관찰
    - 어플리케이션 전체에 변경 알림을 전달
    - 상태 변화에 따라 뷰를 자동 렌더링



### 1.2. HTML 태그들



#### 1.2.1. 주요 범위, 메타 데이터

기본 구조

- DTD(DOCTYPE)
  - 문서타입: HTML5, HTML4, XHTML중 무엇인지 나타내 줌
  - 싸피에서는 html5만 다루었음
- html태그
  - 이 페이지는 html로 작성되었음을 알려줌
  - 속성
    - 언어 설정 lang: 기본 en으로 설정되어 있음
- head태그
  - 문서의 정보를 입력하는 용도: 각종 메타 데이터가 들어감
- body태그
  - 문서의 구조를 입력하는 용도
  - 일반적으로 header - main - footer 구조를 가짐



head 내의 메타 데이터

- 문서 제목: `<title>`
- 기타 정보: `<meta>`
  - charset 속성으로 인코딩 설정
  - http-equiv/content 속성으로 브라우저 별 렌더링 설정
  - name/content 속성으로 각종 메타 데이터 설정(viewport, og:title 등등)
- 스타일: 직접 입력 `<style>`
  - type속성의 언어와(기본값은 CSS) 일치하는 스타일 정보
- 외부 문서 연결 `<link>` : 주로 스타일 시트에 사용하고 아이콘 연결에도 사용됨
  - ref 속성에 현재 html 문서와 외부 문서의 관계를 명시
- `<base>` 상대경로를 작성하는 기준점을 명시: 마지막에 슬래시 빼먹지 말기
  - html문서에 **단 한번만 작성 가능**
  - 경로를 작성하는 곳(link 태그 등) 위에 작성하는 것을 권장



#### 1.2.2. body 내의 태그들

영역을 설정하는 태그(전부 블럭 요소임)

- header
  - 문서 맨 위에 표시되는 것: 일반적으로 navigation bar
  - header, footer를 자손으로 가질 수 없음 
- footer
  - 문서 맨 밑에 작성자, 저작권 관련 사이트 등을 표시할 때 사용됨
  - header, footer를 자손으로 가질 수 없음
- main
  - 주요 콘텐츠: 문서의 핵심 주제나 어플리케이션의 핵심 기능 설명 등
  - header, footer, main은 html문서에 하나씩만 존재해야 함 
- h
  - 6단계의 문서 제목을 구현하는 태그
    - 제목 단계를 건너뛰지 말 것: h1아래에 h2를 생략하고 h3을 쓰는 것은 권장하지 않음
  - 기본적으로 글씨의 크기가 다르게 설정되어 있음
    - 크기를 조절하기 위해 h1을 h4으로 표현하는 등 낮은 단계 사용은 자제: font-size 사용 권장
    - 크기 지정하라고 있는 태그가 아니기 때문
- article
  - **독립적으로 구분**되거나 재사용 가능한 영역: 기사 같은 것의 묶음을 지정
    - 따로 떼어놔도 괜찮은 부분
  - 제목을 붙여(h1 ~ h6) 식별하고, 작성일자/시간을 `<time>`의 datetime 속성으로 작성
    - 제목은 article 태그 내부에 작성
- section
  - 문서의 일반적인 **영역**을 설정함
  - 제목을 붙여 식별함(h1 ~ h6)
    - article, section은 **div와는 달리 의미를 가지는 영역**이기 때문에 제목을 붙여 식별함
    - 의미를 얼마나 가지는지는 article > section > div 의 느낌
- aside
  - 문서의 별도 콘텐츠를 설정: 광고, 링크, 사이드바
- nav
  - 다른 페이지의 링크를 제공하는 영역: 메뉴, Home, About, Contact 등
  - 대부분 ol 혹은 ul 태그가 이용됨
- address
  - 연락처 정보를 제공하기 위해 사용
  - body, article, footer 내부에 포함됨
- div
  - 의미를 부여하지 않고 사용되는 콘텐츠 영역
  - 꾸미는 목적으로 많이 사용됨



문자 콘텐츠를 나타내는 태그

- 리스트
  - 각 항목 li
    - ol이나 ul에 자식으로 포함되어야 함
    - ol, ul은 자식으로 li만 포함 가능
    - value 속성: 해당 li 요소에 번호를 매겨 다음 li부터 순차적으로 값을 따라갈 수 있게 함
  - 정렬된 목록 ol
    - 항목의 순서는 중요도를 의미할 수도 있음
    - reversed 속성: 번호 순서를 거꾸로 할 수 있음
    - start 속성: 시작하는 번호 설정 가능
    - type 속성: 매겨지는 번호의 유형 설정 가능(a, A, i, I 등)
  - 정렬되지 않은 목록 ul
- dl, dt, dd
  - 용어(dt), 정의(dd) 쌍들의 영역(dl)을 설정함
  - dl 태그는 dt, dd만을 포함해야 함
    - 스타일링하기 까다롭기 때문에 잘 안 쓰임
    - dl로 감싼 dt - dd를 li로 감싼 dfn - p 태그로 대체하여 사용할 수 있음
  - key - value 형태를 표시할 때 유용함
- 문단
  - p태그
    - 문단 혹은 문장을 나타냄
    - 필요성: 보통 정보통신 보조기기에서 다음 문단으로 넘어가는 단축키가 있음
  - hr태그
    - 문단의 분리: 보통 수평선으로 표시됨
- pre
  - 서식이 미리 지정된 텍스트: preformatted text
  - 텍스트의 공백과 줄바꿈을 유지하여 표시할 수 있음
    - 태그 뒤에 엔터가 들어가면 그것도 줄 바꿈 들어가니까 콘텐츠와 태그를 붙여야 함
  - 기본적으로 **Monospace** 글꼴 계열로 표시돔
    - 모든 글씨와 공백의 폭이 동일함: 코딩에 사용되는 글꼴은 기본적으로 monospace
- blockquote
  - 인용문을 나타냄
  - cite 속성: 인용한 출처의 URL을 입력



인라인텍스트 태그

- a
- 



### 1.3. Input





## **2. CSS**

> **Cascadding** Style Sheets
>
> HTML이 내용을 담당한다면 스타일은 문서의 내용과 상관없이 디자인만을 담당함



### 2.1. CSS 기본



CSS의 형식

`input {color: red; font-family: 'Noto Sans';}`

- 선택자 input
  - 스타일을 어디에 적용할 것인가?
  - 사람이 읽을 수 있는 **선택자**(selectors)에 적용함
    -  문서 전체가 될 수도 있고, 태그가 될 수도, 클래스나 id가 될 수도 있음
- 속성 color
  - 어떤 속성을 적용할 것인가?
  - 색상, 폰트, 크기 등
- 속성값 red
  - 속성의 구체적인 값
- CSS를 공부한다는 것은 **다양한 속성을 알아보고 각 속성마다 어떤 값을 사용하는지 배우는 것**
  - 참고) CSS의 속성은 property, HTML의 속성은 attribute라고 함



스타일 시트의 종류

- 웹 문서에 적용할 스타일 규칙을 묶어둔 것
- 브라우저 기본 스타일
  - 브라우저에서 미리 정해둔 스타일을 따라감
- 사용자 스타일
  - 인라인 스타일
    - 스타일을 적용할 대상에 **직접 표시**함 `<p style='color: blue;'> 안녕 </p>`
    - 간단한 스타일 정보를 적용할 때 사용
    - 반복 작성에 의한 낭비 및 수정의 어려움 때문에 **가능한 피해야 함**
  - 내부 스타일 시트
    - 웹 문서에 사용할 스타일을 같은 (html)문서 안에 정리한 것
    - head 태그 안의 **style 태그 사이에 작성**
  - 외부 스타일 시트
    - 같은 스타일을 여러 웹 문서에 적용하기 위해 별도로 스타일만을 작성한 파일
    - link 태그를 이용하여 웹 문서와 연결
    - `<link rel='stylesheet' href='style.css'>`



기본 선택자

- 전체 선택자
  - asterisk 사용
  - `* {속성: 값; ...}`
- 타입 선택자
  - 특정 태그를 사용한 모든 요소에 스타일을 적용
  - 실무에서는 잘 사용하지 않음
- 클래스 선택자
  - 태그에 **별명**을 부여: 같은 태그라도 일부에 다른 스타일을 적용하고 싶을 때 사용
- id 선택자
  - 웹 문서의 특정 부분을 선택해서 스타일을 적용: 클래스와 동일
  - 단, **문서 전체에서 1번만 적용할 수 있음**
    - 웬만하면 쓰지 않는 것이 좋음
- 그룹 선택자
  - 쉼표로 구분하여 여러 선택자를 나열할 후 스타일 규칙을 한 번만 정의함
  - `selector1, selector2{ style }`



캐스케이딩

- 우선순위가 폭포수처럼(cascading) 위에서 아래로 적용된다는 뜻
  - CSS: **우선순위가 있는** 스타일 시트
- **스타일이 충돌하지 않도록** 하는 것이 중요
  - 스타일 우선순위: 우선순위에 따라 위에서 아래로 스타일을 적용
  - 스타일 상속: 태그의 포함 관계에 따라 부모 요소의 스타일을 자식이 상속 받음

- 스타일 우선순위는 3가지 개념에 따라 지정됨
  - 얼마나 중요한가?
    1. 사용자 스타일
    2. 제작자 스타일
    3. 브라우저 기본 스타일
  - 적용 범위는 어디인가?
    1. `!important`
    2. 인라인 스타일
    3. id 스타일
    4. 클래스 스타일
    5. 타입 스타일
  - 소스 코드의 작성 순서는?
    - **나중에 작성한 스타일이** 먼저 작성한 스타일을 덮어씀



우선순위를 좀 더 정확하게는 점수 매겨서 결정됨

**CSS 선택자 명시도**

 https://developer.mozilla.org/en-US/docs/Web/CSS/Specificity





### 2.2. CSS 속성

> CSS 공부는 결국 어떤 속성을 적용하여 원하는 화면을 만드는 것인가? 라고 할 수 있음



#### 2.2.1. 폰트, 텍스트

폰트 관련

- font-family
  - 폰트를 지정함
  - 여러 개의 폰트를 지정할 수 있음: 사용자 시스템에 설치되어 있지 않으면 그 다음 폰트를 이용
  - `body {font-family: "맑은 고딕", 돋움, 굴림}`
    - body에 폰트를 적용하면 문서 전체에 적용됨
- font-size
  - 글자 크기를 지정함
  - 절대 크기, 상대 크기(권장), 크기, 백분율 사용 가능
    - 크기는 small, medium, large, x-large 등
    - 상대 크기는 em(부모 요소의 글자 크기 기준), rem(문서 시작 부분 기준)이 있음
    - 백분율도 부모 요소의 글자크기를 기준으로 결정
- font-weight
  - 글자 굵기
  - 예약어(normal, bold, bolder), 숫자(400, 700, 900) 사용 가능



웹 폰트 사용

- 구글 폰트 사용(직접 웹 폰트 파일 이용하는 경우도 있지만 굳이...)
  1. 구글 폰트에서 원하는 폰트 찾기
  2. @import 속성을 확인하고 복사
  3. style태그 내부 혹은 css 파일 내에 붙여넣기
  4. 폰트 이름은 복사해서 바로 font-family에 적용 가능



텍스트 스타일

- color
  - 색상은 영문명, 16진수, hsl(a), rgb(a)로 표기 가능
- text-align
  - **문단의** 텍스트를 정렬함
    - start, end: 현재 텍스트 줄의 시작/끝 위치에 맞춤
    - left, right, center
    - justify: 양쪽에 맞춤
    - match-parent: 부모 요소에 따라 정렬
- line-height
  - **문단 내의 줄 간격**을 조절함
  - 텍스트를 세로 정렬할 때도 유용하게 사용할 수 있음
    - 영역의 높이를 나타내는 height와 line-height를 동일하게 지정하면 세로로 가운데 정렬됨
- text-decoration
  - 밑줄을 긋거나 취소선 표시
- text-shadow
  - 그림자 효과 추가
  - `text-shadow: none | <가로 거리> <세로 거리> <번짐> <색상>`
- text-transform
  - 대소 문자 변환: 영문자에만 적용됨
- letter-spacing
  - 자간 조절
- word-spacing
  - 띄어쓰기 조절



#### 2.2.2. 목록

불릿 스타일

- list-style-type
  - 불릿 모양(ul) 또는 번호 스타일(ol) 지정 가능
  - disc, circle, square, decimal, lower-roman 등
- list-style-image
  - 불릿을 원하는 이미지로 변경 가능
- list-style-position
  - 불릿 들여쓰기 조정
  - inside(안으로 들여쓰기), outside(기본값)
- list-style
  - 위 3개를 한 번에 표현 가능
  - `list-style: lower-alpha inside;`



#### 2.2.3. 테이블

> 개 같은....



테이블 제목

- caption-side
  - `<caption> `태그를 이용해 표시되는 표 제목의 위치 조정
  - top(기본값), bottom



테두리

- border
  - 크기, 모양, 색 3가지로 구성됨
  - `border: 1px solid black;`
- border-spacing
  - 테두리를 표 전체에 적용하고 각 요소에 다시 적용하면 셀 사이의 여백이 생김: spacing 조절
  - 수평거리, 수직거리
  - `border-spacing: 1px 1px;`
- border-collapse
  - seperate(기본값, 여백 유지), collapse(테이블과 셀의 테두리를 합침)
  - 이 속성은 **table 태그에 적용**하면 됨
  - *collapse가 안 되는 경우에는 어떻게 함ㄴ 되지?*



##### 테이블 CSS 문제 해결

테이블의 헤더를 고정하는 방법



table-layout:fixed



nowrap





#### 2.2.4. 배경







### 2.3. 박스 모델

> 박스 형태인 요소를 이용하여 배치
>
> 컨텐츠를 담을 박스를 지정하고 스타일, 위치, 정렬을 지정함



블록 vs 인라인

- 블록 레벨 요소
  - 혼자 한 줄을 차지하는 요소
  - div, h1, p 등
  - 블록 레벨 요소는 모두 **박스 모델 요소** 임
- 인라인 레벨 요소
  - 콘텐츠 만큼만 영역을 차지함: 나머지 공간에 다른 "인라인 레벨"요소가 올 수 있음
  - span, img, strong 등



박스 모델의 구성

![box model](https://s3.amazonaws.com/viking_education/web_development/web_app_eng/css_box_model_chrome.png)

- contents
  - 글, 이미지, 비디오 등 **요소의 내용**
  - width, height 속성으로 크기를 지정할 수 있음
  - 크기(px, em단위), 백분율(**부모 요소를 기준으로**), auto 사용 가능
- padding: 내부 여백, 배경색 및 이미지 지정 가능
- border: 테두리
- margin: 바깥쪽 여백, 배경색 지정 불가. 마진은 큰 쪽으로 결합되어 상쇄될 수 있음



박스 모델의 크기: box-sizing

- border-box
  - 테두리까지 포함해서 크기를 지정
  - 보통 CSS 최상단에(body) `box-sizing: border-box;`를 명시해두고 스타일 시트를 작성함
- content-box
  - 콘텐츠 영역만 크기를 지정
  - 기본값임...



박스 모델의 스타일 지정

- 상하좌우 4가지 방향에 대해 각각 지정할 수 있음
  - top, right, bottom, left 순서대로 지정함
- border
  - border-style
    - 테두리 스타일을 지정
    - solid, dashed, dotted, double, groove 등
  - border-width
    - 테두리의 두께
    - double 같은 경우엔 두 선 사이의 간격이 border-width가 됨
  - border-color
    - 테두리 색상 지정
  - border
    - 위 세개를 한 번에 지정: `border: 1px solid black;`
  - border-radius
    - 꼭짓점을 둥글게 처리해줌
- margin
  - `margin: <크기> | <백분율> | auto;`
  - 마진을 이용하여 요소를 가운데 정렬하는 방법
    - `margin: 20px auto;`
    - 마진을 이용해 가운데 정렬하려면 적용하는 요소의 너비가 지정되어 있어야 함
  - margin collapse
    - 요소를 **세로로 배치할 때** 마진이 겹치면 값이 큰 쪽의 마진만 반영되고 작은 쪽은 무시
    - 여러 요소가 나열될 때 간격이 동일하게 하도록 위함
    - 가로로 배치할 때는 중첩되지 않음
- padding
  - 마진과 같은 식으로 지정할 수 있음



Display

- display는 속성을 **바꿔줄 요소**에 적용: 부모 요소에 적용하는 것이 아님!
  - 리스트 내 요소들을 나란히 배치하고 싶으면 ul이 아니라 li 태그에 `display: inline;` 적용
- block
  - 인라인 요소를 블록 요소로 만들어줌
- inline
  - 블록 요소를 인라인 레벨 요소로 만들어줌
  - **width, height, mt, mb 지정 불가**, **상하 여백은 line-height로** 지정
- inline-block
  - 텍스트 흐름대로 나열하면서(인라인 레벨 속성) 마진, 패딩 지정 가능(block속성)
- none
  - 화면에서 요소가 사라지며 요소가 차지하는 **공간도 사라짐**
  - `visibility: hidden`은 공간은 사라지지 않음



Float

- 이미지와 텍스트를 나란히 배치하기 위해 등장: 이미지를 텍스트가 둘러쌀 수 있음
  - margin도 같이 사용해주면 좋음
  - 웹문서 레이아웃 만드는 데 사용되기도 함
    - 기본적으로 **비추**: 요즘엔 flexbox를 사용함
    - **사이드 바 만드는 데 쓰기 좋음**
- left(왼쪽으로 띄움), right(오른쪽으로 띄움), none(기본값)
  - clear를 통해서 해제해주면 그 다음에 등장하는 요소부터는 float와 상관없이 아래쪽으로 표시됨





#### 2.3.1. 웹 요소 위치 지정



position

- 문서 상에 **요소를 배치할 방법**을 지정함
- static: 기본
  - top, left, right, bottom 등 오프셋이 **아무런 영향도 주지 않음**
- relative
  - 자기 자신을 기준으로 위치 이동(top, left, right, bottom)
  - 오프셋이 적용되어도 다른 요소에는 영향 없음: static 조건 하에서 차지하던 **"공간"은 그대로 남음**
- absolute
  - **가장 가까운 위치 지정 조상 요소** 기준으로 이동, 없으면 body에 붙음
    - 위치 지정 요소: position 속성이 static이 아닌 값을 가지는 요소
  - static 조건 하에서 차지하던 **공간은 사라짐**: 다른 것에 상관 없이 독자적인 곳에 놓이게 됨
  - 팝업 정보 상자 등 다른 요소와 위치에 간섭하지 않는 UI 기능 만들 때 사용
- fixed
  - viewport 기준으로 이동 - 항상 같은 곳에 위치
  - static 조건 하에서 차지하던 공간은 사라짐
- sticky
  - 요소 자체는 일반적인 문서 흐름에 따라서 배치
  - **가장 가까운, 스크롤 되는 조상** 기준으로 오프셋 적용
    - AND 조건임: 스크롤 동작이 존재하고 가장 가까운 조상이 실제 스크롤되지 않는다면 동작하지 않음
    - 스크롤 동작: `overflow`속성이 hidden, scroll, auto, overlay인 경우



위치 이동(오프셋)

- top, bottom, left, right
- z-index
  - z축 방향의 "쌓임 맥락"을 결정함



FlexBox

- - 
- 



#### 2.3.2. 박스 모델 문제 해결



부모 박스와 자식 박스의 크기

- 문제) div 내에 100px * 100px의 div가 들어 있고 padding 10px, margin 10px이라면 부모 div의 크기는?
  - 해답) 110px * 110px
  - 해설) 자식의 마진이 부모의 크기에 영향을 미치지 않음: 마진은 같은 레벨 요소 간의 위치를 조정할 때 사용되는 개념이기 때문
- 문제) padding을 제외하고 자식 div로 contents를 꽉 채우려면 자식 div의 크기를 어떻게 설정해야 하는가?
  - 해답) `width = calc(100% - padding);`
  - 해설) %는 부모 요소 기준으로 설정되기 때문에 padding을 뺀 값으로 크기를 설정해줘야 함



### 2.4. 선택자



- - 



CSS Selector

- 우선순위: `!important`, inline style, id, class, 요소(태그), 순서(cascade)
- id 선택자
  - `#` 문자로 시작, 아이디는 문서당 하나만 사용 가능
  - 링크 이동이나 for를 사용하는 경우에만 사용
- class 선택자
  - 특정 부분만 선택해서
  - 마침표 문자로 시작, 해당 클래스가 적용된 문서의 모든 항목 선택
- 복합 선택자
  - 자손: `selector a selector b`
  - 자식: `selector a > selector b`





### 2.6. 트랜지션과 애니메이션



### 2.7. 반응형 웹, 미디어 쿼리



반응형 웹 디자인

- 기존 웹 사이트의 내용은 그대로 유지하면서 **다양한 화면 크기에 맞게 웹 요소를 배치하는 것**
  - 모바일 기기 보급에 따라 등장
  - 사이트를 기기별로 작성할 필요가 없음



뷰포트 viewport

- 화면에서 실제 내용이 표시되는 영역
- 모바일 기기별 사이즈에 적합한 사이트를 제작하기 위해 알아둬야 함
  - **웹키트를 기반으로 한 모바일 브라우저**의 기본 뷰포트 너비는 980px
  - webkit엔진 기반으로 작동하는 모바일 브라우저: 크롬, 엣지, 사파리 등
- 뷰포트 작성
  - head 내에 `<meta>`태그를 이용하여 작성
  - `<meta name="viewport" content="width=device-width", initial-scale=1.0">`
    - html에서`!` 입력하면 위와 같이 설정됨: 너비는 스마트폰 화면 너비에 맞추고 초기 화면 배율 1로
    - content 내부에 뷰포트 너비, 높이, 확대/축소 가능 여부, 초기 확대/축소 값 설정 가능
- 뷰포트 단위
  - vw: 뷰포트 너비의 1%
  - vh: 뷰포트 높이의 1%
  - vmin: 뷰포트 너비와 높이 중 작은 값의 1%
  - vmax: 뷰포트 너비와 높이 중 큰 값의 1%
- 디바이스 모드
  - 크롬 개발자 도구 좌측 상단의 디바이스 모드 아이콘을 눌러 이용 가능
  - 화면의 가로, 세로 값을 바꾸면서 기기 별로 화면이 어떻게 표시되는지 확인 가능



미디어 쿼리

- 사용자가 **어떤 미디어를 사용하는가에 따라 사이트의 형태가 바뀌도록** CSS를 작성하는 것
  - 기기의 해상도에 따라 달라지게 함
  - [미디어 쿼리 사이트](http://mediaqueri.es)에서 미디어 쿼리를 이용한 다양한 사이트 확인 가능
- 



그리드 레이아웃



#### 2.7.1 Flexbox

> 2차원 상의 레이아웃을 간단하게(??) 구현하기 위해 등장 [W3C](http://w3.org/TR/css-flexbox-1)

flexbox

- 아이템 간 공간 배분과 정렬
- 컨테이너를 선언: `display="flex"`
- flex-direction, flex-wrap, flex-flow, jistify-content, align-items, align-self, order, flex-grow







## **3. Javascript**



### 3.1. 기본개념

자바스크립트는 스크립트언어다
- 스크립트 언어는 이미 존재하는 소프트웨어를 제어하기 위한 용도로 사용됨
  - **프로그래밍언어**긴 하지만 OS위에서 새로운 프로그램을 만들기보다는 기존 프로그램을 제어하고 그 위에서 구동이 지원되는 것이라 구별하려고 이름 붙임
- 컴파일이 필요 없고 문법이 단순하며 스크립트 엔진만 있으면 모든 OS에서 실행가능



자바스크립트의 역사

- 처음엔 넷스케이프에서 동적 웹페이지 만들려고 개발
  - Scheme Script를 베이스로 자바 문법과 비슷하게
- ECMA International에서 문법적 사항을 정리한 문서 ECMA Script 발간(1997)
- 그러나 MS에서 이를 생까고, 파이어폭스 출시(2004)되면서 크로스 브라우징 이슈 심화
  - JQuery, dojo, mootools 등의 라이브러리를 이용해 다양한 브라우저에서 동작하는 동적 웹사이트를 만들게 됨
- **AJAX**(Asynchronous JavaScript And XML) 도입
  - CSR을 구현하기 위한 비동기적 웹 어플리케이션 개발 기법
    - 렌더링이 끝난 후에 데이터를 받아오는 것을 비동기로 수행
  - 서버와 통신할 때  **XHR(XMLHttpRequest)**객체를 사용하는 것
    - xhr은 데이터를 받아오는 객체로 페이지의 일부를 업데이트 하고 HTML, JSON, Txt를 교환
    - 옛날 방식: 요즘엔 **서드파티 라이브러리** 많이 쓴다
    - 서드파티란 제3자(툴 제작자가 아닌 개인, 팀, 업체 등)가 만든 **라이브러리**나 **플러그인**으로 프로그래밍을 돕기 위해 존재함
      - 라이브러리: 재사용이 필요한 기능을 미리 만들어두고 모듈화하여 사용
      - 플러그인: 특정 문제를 해결하기 위한 컴포넌트(라이브러리: 플러그인의 집합)
- 크롬 도입(Just In Time compliation): JS 실행 속도가 굉장히 빠름
- 표준화 논의: ES5출시(2009), ES6출시(2015)
  - 현재는 모든 브라우저가 ES를 잘 따르고 있음



자바스크립트의 구성

- JS 엔진
  - 메모리 힙: 메모리 할당을 실시
  - 콜 스택: 스택 프레임 코드를 실행, 함수 호출을 일시적으로 저장-관리
- 이벤트 루프
  - 현재 실행중인 태스크가 없는지(콜스택이 비었는지), 태스크 큐가 비었는지 반복적으로(tick) 확인
  - 콜스택이 비었으면 태스크큐의 첫번째 태스크를 가져옴
- web api
  - 스택에서 비동기 함수를(ajax, setTimeout) 만나면 여기로 이동
  - 여기서 실행된 함수의 리턴값은 태스크 큐로 이동함
- task queue(callback queue)
  - FIFO
  - 스택이 비어있을 경우 태스크 큐에서 콜스택으로 전달
  - **마이크로 태스크 큐**
    - Promise의 `then()` 메서드는 여기에 추가됨
    - 이벤트 루프는 태스크 큐보다 여기 있는 함수를 우선적으로 처리
  - Animation Frame이라는 것도 있는데 일단 생략

- 실행 컨텍스트
  - 실행 가능한 코드를 형상화하고 구분
- 특징
  - 비동기성: 싱글 스레드이기 때문
    - 특정 시점에 어떤 일(콜백 함수)을 이어나감
  - Callback 함수: 어떤 일이 "일어나면" 자동적으로 호출되는 함수, 1급 객체임
    - **1급 객체**: 리턴값으로 사용가능, 함수 인자로 사용가능, 변수 할당가능
    - 연쇄적인 콜백함수의 사용은 콜백 지옥으로 이어짐
  - Promise
    - 주로 서버에서 받아온 데이터를 화면에 표시할 때 사용하는 것으로, 콜백 지옥을 해결
    - 콜백 지옥이란?
      - 비동기 처리 로직을 위해 콜백 함수를 연속해서 사용할 때 발생하는 문제
      - Promise나 async/await를 사용해서 해결
    - 성공/실패의 상황을 가정하고 새로운 promise를 리턴함으로써 콜백지옥 해결



### 3.2. 기본 문법



- `console`
  - 웹 API로, 언어 자체에 포함된 것이 아니라 브라우저가 이해할 수 있는 함수:  브라우저의 Dev Tool에서 직접 사용하기 가능
  - Node.js같은 애들도 포함하고 있음
- `async` vs `defer`
  - 공통점: JS코드를 만나면 parsing과 병렬적으로 JS코드를 다운로드(fetching)
  - async
    - 해당 JS코드 다운로드가 끝나면 실행(executing)
    - 순서에 의존적인 JS코드라면 문제가 생길 수 있음
    - 파싱이 끝나기 전에 실행되기 때문에 필요한 DOM요소가 아직 없다면 문제가 생길 수 있음
    - 파싱을 중단하기 때문에 페이지를 보기까지 시간이 걸림
  - defer
    - 파싱이 완료되면 JS코드를 작성 순서에 따라 실행
    - 관련 컴포넌트들이 준비되지 않은 상태에서 화면을 보게 됨: **사용불가 처리**를 해줘야 함
- `'use strict'`를 맨 위에 침으로써(ES5에 도입됨) 호이스팅 방지



#### 데이터 타입

- let: 유일한 **변수**(mutable)

  - ES6에 추가됨
  - var는 이제 쓰면 안 됨: 블럭을 무시하기 때문
    - Hoisting: 선언 위치에 상관 없이 제일 위로 선언을 끌어올림
    - 간단한 프로그램에서는 유연하고 좋지만 규모가 커지면 에러의 원인이 됨
  - Increment
    - postIncrement: `value++`
    - preIncrement: `++value`

- **Block Scope**

  - 블럭 {} 밖에서 접근할 수 없게 함
  - 블럭 밖의 변수는 Global Scope
    - 어플이 종료될 때까지 메모리를 차지하므로 사용 최소화 권장
    - 클래스, 함수, 반복문 등 필요한 부분에서만 쓰자

- const(read only)

  - 포인터가 잠겨있기 때문에 값을 재할당할 수 없음(immutable)
  - 보안성
  - thread safety
    - 여러 쓰레드가 동시에 값을 변경하려고 하여 충돌할 일이 없음
  - reduce human mistakes

- **Dynamic typing**

  - 어떤 타입인지 선언하지 않고 런타임 때 타입을 변경할 수 있음

  - 빠르게 프로토타이핑할 때 유용하지만 규모가 커지면 머리 아플 수 있음!

  - ```javascript
    let text = 'hello';
    console.log(`value: ${text}, type: ${typeof text}`)
    text = 1;
    console.log(`value: ${text}, type: ${typeof text}`)
    text = '7' + 5;
    console.log(`value: ${text}, type: ${typeof text}`)
    text = '8' / '2';
    console.log(`value: ${text}, type: ${typeof text}`)
    // value: hello, type: string
    // value: 1, type: number
    // value: 75, type: string
    // value: 4, type: number
    ```

  - 중간에 타입이 바껴서 (스트링 -> 넘버) 인덱싱을 못하는 바람에 런타임 에러가 생기는 등의 문제가 있을 수 있음: TypeScript로 해결

- Operation

  - Short circuit evaluation
    - 파이썬과 마찬가지로 or(||)연산은 true가 나오면 끝
    - 따라서 함수같이 무거운 것은 최대한 뒤로



#### 함수

- Early return, Early exit
  - 조건이 만족될 때 특정 로직이 도는 함수가 있다면
  - 조건이 안 맞는 경우 먼저 리턴, 그 후에 조건이 맞는 경우에 대한 로직을 작성하는 것이 효율적
- function expression: 1급 객체로 기능하게 해 줌
  - function declaration은 호이스팅 가능하나 이것은 불가
    - 변수에 할당된 이후에만 실행
  - anonymous function: 이름 없이 기능만 작성해서 변수에 할당
  - named function: 디버깅하기 편하려고 씀
- Callback
  - 조건에 맞으면 다른 함수(callback func)를 호출
- Arrow function
  - 간단하게 쓰려고 사용
  - `const simplePrint = () => console.log('simplePrint!');`
  - 좀 길어지면 블럭을 써야하지만 블럭 사용시 return 명시해야
- IIFE(Immediately Invoked Function Expression)
  - 함수를 선언하는 즉시 실행하는 것: 함수를 괄호로() 둘러싸면 됨



#### 조건, 반복

- If

  - ```javascript
    const name = 'df';
    if (name === 'ellie') {
        console.log('Welcome, Ellie!')
    } else if (name === 'coder') {
        console.log('You are amazing coder')
    } else {
        cosole.log('unknown')
    }
    ```

  - Ternary operator: 간단할 때만 쓰자

  - ```javascript
    console.log(name === 'ellie' ? 'yes' : 'no')
    ```

- Switch

  - else if를 여러 개 반복하게 되면 스위치 쓰는 것이 좋음

- loop

  - ```javascript
    let i = 3;
    while (i > 0) {
        console.log(`while: ${i}`)
        i--;
    }
    ```

  - do-while: 먼저 do 블럭을 실행해 조건이 맞는지 검사

  - for-loop

  - ```javascript
    for (i = 3; i > 0; i--) {
        console.log(`for: ${i}`);
    }
    ```

  - Nesting(중복 포문) 작성 가능



#### 클래스

> ES6에 도입됨, 이전에는 바로 객체를 만들어서 사용: function을 이용

- 선언

  - `constructor(parameters) {}`: 클래스 필드 정의
    - consructor 없이 publicField, #privateField를 정의할 수 있음
    - 파이썬과 마찬가지로 static, static method 정의 가능
  - 그 밑에 메소드 선언
  - 객체를 만들 때는 `new Class()`

- Getter, Setter

  - 사용자 실수로 class property를 잘못 설정했을 때 수정하게 해줌

  - ```javascript
    class User {
        constructor(name, age) {
            this.name = name;
            this.age = age;
            // getter 정의하는 순간 this.age는 메모리에 올라간 데이터가 아니라 getter를 호출
            // setter를 정의하는 순간 값을 할당할 때 setter를 호출
    
        }
        get age() {
     	   return this._age;
    	}
    	set age(value) {
            if (value < 0) {
                throw Error('age cannot be negative');
            }
        	this._age = value;
            // 할당할 때 setter가 호출되는데 age변수 이름이 같으면 계속 돌기 때문에 '_'를 앞에 붙이는 게 convention
    	}
    }
    ```

- 상속, 다형성

  - extends를 통해 상속함
    -  `class Rectangle extends Shape {}`
    - Overriding 가능: `super.method()`하면 부모 메소드도 사용

- **Object**

  - 클래스를 이용해서 만들거나(new), 중괄호를 이용해서 생성(object literal)
  - object는 key, value의 집합체
    - in operator: 키가 있는지 체크하는 bool 함수
    - for .. in vs for .. of
      - `for (key in ellie) {}`: object 내의 키를 순회
      - `for (value of iterable) {}`: 배열 내의 원소를 순회
  - object의 copy
    - object는 call by reference이기 때문에  
    - for문을 돌면서 일일이 복사를 해주거나(old way)
    - `Object.assign()`을 활용: assign<Target, source1, source2>
      - `const user2 = Object.assign({}, user);`
      - source가 여러 개이고 같은 필드가 있으면 뒤에 있는 것이 덮어씌우게 됨



#### 배열

- 배열 순회
  - `fruits.forEach((fruit, index) => console.log(fruit))`
- 배열 조작
  - 뒤에 추가: `.push()`  뒤에서 빼기: `.pop()`
  - 앞에 추가: `.unshift()`  앞에서 빼기: `.shift()`
  - 앞에서 빼거나 추가하는 것은 굉장히 느리기 때문에 안 쓰는 것이 좋음
- 검색
  - 인덱스 반환: `.indexOf()` 여러개 있으면 제일 먼저 나오는 인덱스 반환, 반대는 `.lastIndexOf()`
  - 존재여부 찾기: `.includes()`  indexOf()도 쓸 수 있는데 포함 안 되어 있으면 -1이 반환됨



#### JSON

- XML

  - HTML과 같은 마크업 언어로, 태그를 이용하여 데이터를 표현함
  - 아웃룩이 XML을 이용하여 데이터를 주고받았기 때문에 AJAX(Asynchronous Javascript And XML), XHR(XML Http Request)에 XML 이름이 들어가 있음

- JSON: JavaScript Object Notation

  - JS의 object가 키-밸류로 이루어져 있듯 JSON도 그러함
  - 프로그래밍 언어나 플랫폼에 상관 없이 사용 가능

- Serialization

  - (언어별로) object를 JSON으로 변환하는 것

  - Object to JSON

    - `JSON.stringify(object)`: object 뒤에 callback함수를 넣어서 변환을 통제할 수 있음
    - 오브젝트 함수는 JSON으로 변환되지 않음: JSON이 될 때 전부 String으로 바꾸기 때문

  - JSON to Object(deserialization)

    - `JSON.parse(json)`

    - json뒤에 reviver이라는 콜백함수를 이용하여 스트링으로 변환된 원본의 객체를 살릴 수 있음

    - ```javascript
      const obj = JSON.parse(json, (key, value) => {
          console.log(`key: ${key}, value: ${value}`);
          return key === 'birthDate' ? new Date(value) : value;
      })
      ```



#### Event

> HTML 문서 내에서 일어나는 일
>
> `click`, `submit`, `keydown`, `mouseover`, `submit`, `change` ...

- addEventListener

  - `EventTarget.addEventListener(type, listener)`
  - 이벤트가 발생하면 listener가 실행된다

- event.preventDefault()

  - 각 태그의 기본 이벤트가 동작하지 않도록 막음




#### 비동기 처리

> 자바스크립트 자체는 동기적: 호이스팅이 된 이후로는 하나씩 순서대로 실행
>
> 비동기 함수를 만나면 webAPI, 태스크큐 등을 거쳐 비동기적 실행

- **Callback**
  - synchronous callback
  - asynchronous callback
  - callback hell
    - 코드 가독성이 심각함
- **Promise**
  - 비동기를 간편하게 처리할 수 있도록 도와주는 Object
    - 정해진 *장시간의 기능* 을 수행하고 성공한다면 결과를, 실패한다면 에러를 전달
    - 시간이 오래걸리는 코드를 동기적으로 처리하면 다음 라인의 코드가 실행되지 않기 때문에 Promise를 만들어 비동기적으로 처리하는 것이 좋다
      - ex) network, read files
    - Promise 객체를 만들면 executor가 자동적으로 실행됨
    
  - State
    - pending: operation이 실행중일 때(resolve, reject 둘 다 호출하지 않으면 이렇게 됨)
    - fulfilled: operation을 성공적으로 마쳤을 때(resolve)
    - rejected: 파일을 찾을 수 없거나 네트워크에 문제가 생김
    
  - Producer vs Consumer
    - Producer: 원하는 기능을 수행하여 해당 데이터를 만들어 냄
      - 특정 기능이 성공하면 resolve를 통해 데이터를 전달
      - reject는 Error Object를 통해 값을 전달
    - Consumer: 원하는 데이터를 소비함
      - then: promise가 정상적으로 수행되어 resolve를 통해 전달한 값이 value라는 parameter로 들어옴
      - catch: 에러가 발생했을 때 처리하는 방식을 정의하는 callback함수
      - finally: 성공/실패 관계없이 마지막에 호출됨
    - Promise Chaining
      - then을 호출하면 promise가 리턴되고, 여기에 다시 catch를 등록함
      - 이게 콜백지옥을 깔끔하게 만들어주는 핵심
        - 프로미스 객체를 받아오기 때문에 변수명 줄줄이 쓸 필요 없음 [참고](https://youtu.be/JB_yU6Oe2eE?t=1123)
        - 심지어 변수가 1개면 생략도 가능함ㄷㄷㄷ
    
  - **Async** (ES8에 등장)
  
    - promise를 동기적으로 실행하는 것처럼 보이게 해 줌
    - promise위에 API를 제공해줌(`syntatic sugar`)
    - 함수 앞에 async를 써주면 자동으로 (함수 안의 내용물을 실행하는) Promise가 됨
  
  - **Await**
  
    - async가 붙은 함수 안에서만 쓸 수 있음
    - 비동기적인 수행 앞에 붙여주면 해당 수행을 마친 이후에 다음으로 넘어가게 됨
  
  - async & await의 사용
  
    - Promise도 중첩하게되면 결국 콜백지옥과 다를 것이 없음
  
    - ```javascript
      function pickFruits() {
          return getApple().then(apple => {
              return getBanana().then(banana => `${apple} + ${banana}`);
          });
      }
      ```
  
    - ```javascript
      async function pickFruits() {
          const apple = await getApple();
          const banana = await getBanana();
          return `${apple} + ${banana}`;
      }
      ```
  
    - 다만 독립적인 두 과정을 직렬로 수행하면 낭비: 병렬처리 가능
  
    - ```javascript
      async function pickFruits() {
          const applePromise = getApple();
          const bananaPromise = getBanana();
          const apple = await applePromise;
          const banana = await bananaPromise;
          return `${apple} + ${banana}`;
      }
      // 또는 API 사용
      function pickAllFruits() {
          return Promise.all([getApple(), getBanana()]).then(fruits =>
           fruits.join(' + ')                                )
      }
      ```
  
    - 



#### Axios

> Promise 기반의 비동기 요청을 할 수 있는 JavaScript 라이브러리
>
> xhr을 직관적으로 사용할 수 있도록 만들었음

- async, await
  - 비동기로 처리하는 로직을 동기적으로 보이게 만드는 것
  - 함수 앞에 async를 작성, 비동기로 처리되는 로직 앞에 await 작성
  - await는 async function 내부에서만 사용



#### TypeScript

- 사용하는 이유
  - JS의 보완: 컴파일 시 타입을 체크해 에러를 잡아줌
- 장점
  - 안정성 업, IDE 지원, ES6지원
- 단점
  - 하나의 매개변수가 필요할 때도 적용해줘야 함
  - 동적언어로써의 매력 감소: **왜??**
- 동작
  - 브라우저에서 동작하지 않음: 컴파일러를 이용해 js파일로 변환해야 



### 1.6. Vue



#### 기본개념



- MVVM
  - Model : Javascript의 object
  - View : actual DOM
  - View Model : model과 view를 연결해주는 것
    - View Model은 모든 vue instance이다
    - Directives
    - DOM Listener
- 작성 순서
  - data가 작성되면 DOM이 바뀌는 것이 vue의 기본 로직: 작성도 이 순서를 따름

- 





