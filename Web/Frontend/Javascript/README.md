# Javascript



참고자료

- Do It! HTML + CSS + 자바스크립트 웹 표준의 정석
- 삼성 청년 SW 아카데미 4기 수업자료
- Softbank 신입사원 OJT
- MDN



[TOC]

## **1. 기본개념**



자바스크립트란?

- 웹 브라우저에서 사용하기 위하여 만들어진 **프로그래밍 언어**
  - 기존에는 브라우저에서만 사용해왔음
  - 최근에는 Node.js 런타임을 통하여 서버 쪽에서도 사용을 할 수 있게 됨
- 스크립트 언어는 **이미 존재하는 소프트웨어를 제어**하기 위한 용도로 사용되는 프로그래밍 언어
  - 새로운 프로그램을 만들기보다는 기존 프로그램을 제어하고 그 위에서 구동이 지원되는 것
  - 다른 프로그래밍언어와 구별하려고 이름 붙임
- 컴파일이 필요 없고 문법이 단순하며 **스크립트 엔진**만 있으면 모든 OS에서 실행가능
  - NW.js, Electron 등의 도구를 사용하여 데스크탑 앱을 만들 수도 있음
  - React-native, NativeScript 등의 도구를 사용하여 모바일 앱도 만들 수 있음
  - Node.js 를 통하여 JavaScript 를 사용 할 수 있기 때문에 IoT 진영에서도 사용 될 수도 있음



자바스크립트의 특징

- 



### 자바스크립트의 역사

- 넷스케이프에서 동적 웹페이지 만들기 위해 최초로 개발
  - Scheme Script를 베이스로 자바 문법과 비슷하게 제작
- ECMA International에서 문법적 사항을 정리한 문서 ECMA Script 발간(1997)
- 그러나 MS에서 이를 무시했고, 파이어폭스도 출시(2004)되면서 **크로스 브라우징 이슈** 심화
  - 이를 해결하기 위해 JQuery, dojo, mootools 등의 라이브러리를 이용
  - 다양한 브라우저에서 동작하는 동적 웹사이트를 만들게 됨
- **AJAX**(Asynchronous JavaScript And XML) 도입
  - CSR을 구현하기 위한 비동기적 웹 어플리케이션 개발 기법
    - 렌더링이 끝난 후에 데이터를 받아오는 것을 비동기로 수행
  - 서버와 통신할 때  **XHR(XMLHttpRequest)**객체를 사용
    - xhr은 데이터를 받아오는 객체로 페이지의 일부를 업데이트 하고 HTML, JSON, Txt를 교환
    - 옛날 방식으로 요즘엔 **서드파티 라이브러리**가 많이 사용됨
    - 서드파티란 제3자(툴 제작자가 아닌 개인, 팀, 업체 등)가 만든 **라이브러리**나 **플러그인**으로 프로그래밍을 돕기 위해 존재함
      - 라이브러리: 재사용이 필요한 기능을 미리 만들어두고 모듈화하여 사용
      - 플러그인: 특정 문제를 해결하기 위한 컴포넌트(라이브러리: 플러그인의 집합)
- 크롬 도입(Just In Time compliation)
  - JS 실행 속도가 굉장히 빠른 크롬의 출시로 자바스크립트 이용률 증가
- 표준화 논의: ES5출시(2009), ES6출시(2015)
  - 현재는 모든 브라우저가 ES를 잘 따르고 있음



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



## **2. 기본 문법**



console

- 콘솔이란?
  - 실시간으로 자바스크립트를 실행하고, 에러 메시지등을 출력해주는 **웹 API**
    - 개발자가 사용할 수 있는 **디버깅 기능**을 제공
    - 코드의 특정 지점에서 값이나 변수를 기록하거나 작업의 소요 시간을 알아낼 수 있음
  - 언어 자체에 포함된 것이 아니라 **브라우저가 이해할 수 있는 API임**
    - 브라우저의 Dev Tool에서 직접 사용하기 가능
    - 사유 API로 시작하여 브라우저가 각자 다른 구현을 했으나 지금은 (거의) 통일됨
- `console.log()`
  - 가장 자주 사용되는 메서드로 콘솔에 내용을 출력하는 것



### 2.1. 변수와 연산자



변수와 상수

- let : 유일한 **변수**(mutable)
  - ES6에 추가됨
- var : 예전에 사용되던 변수
  - 이제 쓰면 안 됨: **블럭을 무시**하기 때문
  - Hoisting: 선언 위치에 상관 없이 (제일 위로) 선언을 끌어올림
  - 간단한 프로그램에서는 유연하고 좋지만 규모가 커지면 에러의 원인이 됨
- const : **상수** (read only)

  - 포인터가 잠겨있기 때문에 값을 재할당할 수 없음(immutable)
  - 보안성
    - thread safety : 여러 쓰레드가 동시에 값을 변경하려고 하여 충돌할 일이 없음
    - reduce human mistakes



`null` vs `undefined`

- null : 값이 "없는" 것
  - 아무것도 참조하고 있지 않음
  - 주로 객체를 담을 변수를 초기화할 때 많이 사용됨
  - 변수를 **선언한 후 null 값을 할당**해야 함 : typeof null 은 object 임
- undefined : 아직 값이 설정되지 않은 것
  - undefined는 데이터 타입이자, 값을 나타냄
  - 기본적으로 **초기화되지 않은 변수**는 undefined 타입
  - 변수를 선언만 하더라도 할당됨



연산자

- 산술 연산자 : 생략

- 대입 연산자 : 생략

- 논리 연산자

  - `!`: NOT

  - `&&`: AND

  - `||`: OR

  - 위의 3개 순서대로 우선순위가 높음

    - ```javascript
      const value = !((true && false) || (true && false) || !false)
      ```

    - value의 값은 false다

- 비교 연산자

  - 동등 연산자 : `==`
    - 피 연산자들의 **값만 비교**
    - `1 == '1'` , `null == undefined`의 값은 true임
  - 일치 연산자 : `===`
    - 피 연산자들의 값과 **타입까지 비교**하여 일치하면 true를 리턴



### 2.2. 제어문



#### 조건문



If문

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

- 삼항 연산자 Ternary operator

  - ```javascript
    console.log(name === 'ellie' ? 'yes' : 'no')
    ```

  - 길어지면 줄을 분리할 수 있음

  - ```javascript
    let text = array.length === 0 
      ? '배열이 비어있습니다' 
      : '배열이 비어있지 않습니다.';
    ```

  - Nesting도 가능하지만 비추 : 그럴거면 그냥 if -else 문을 쓰자

- Switch

  - else if를 여러 개 반복하게 되면 스위치 쓰는 것이 좋음

  - ```javascript
    const device = 'iphone';
    
    switch (device) {
      case 'iphone':
        console.log('아이폰!');
        break;
      case 'ipad':
        console.log('아이패드!');
        break;
      default:
        console.log('모르겠네요..');
    }
    ```

  - break를 쓰지 않으면 다음 case도 실행되므로 써야 함



Truthy and Falsy

- Boolean은 아니지만 조건식 내부에서 **true 또는 false와 같이 처리되는 것**
- Falsy는 아래의 5가지가 있음
  - undefined, 0, null, '', NaN
  - NaN(Not A Number) : 문자열을 숫자로 변환하는 parseInt 라는 함수를 사용하게 될 때 볼 수 있음
- 나머지는 전부 Truthy로 처리됨
  - **빈 객체나 빈 배열도 Truthy**임에 주의



Short circuit evaluation

- AND(&&) 연산

  - `A && B` 에서 A 가 Truthy 한 값이라면 **B 가 결과값**이 됨

    - B가 False여도 상관 없이 B를 리턴함
    - 반대로 **A가 Falsy하다면 A가 결과값**이 됨

  - 특정 값이 유효할때에만 어떤 값을 조회하는 작업을 해야 할 때 매우 유용함

  - ```javascript
    function getName(animal) {
      return animal && animal.name;
    }
    ```

- OR(||)연산

  - `A || B` 에서 A 가 Falsy 하다면 결과는 **B 가 결과값**이 됨

    - B가 False여도 상관 없이 B를 리턴함
    - 반대로 **A가 Truthy하다면 A가 결과값**이 됨

  - 어떤 값이 Falsy 하다면 그 대신 사용 할 값을 지정해줄 때 매우 유용함

  - ```javascript
    function getName(animal) {
      const name = animal && animal.name;
      return name || '이름이 없는 동물입니다.';
    }
    ```

- 함수같이 무거운 것은 최대한 뒤로 빼서 short circuit evaluation을 활용하는 것이 좋음



조건문 응용 : 값에 따라 다른 결과물을 반환 해야 할 때

- 예) 동물 이름을 받아오면, 동물의 소리를 반환하는 함수를 어떻게 구현할 것인가?

  - 방법 1 : 조건문 떡칠 - 동물 이름마다 조건 부여

  - 방법 2 : **객체를 활용**

  - ```javascript
    function getSound(animal) {
      const sounds = {
        개: '멍멍!',
        고양이: '야옹~',
      };
      return sounds[animal] || '...?';
    }
    ```

- 값에 따라 실행하는 코드 구문 자체가 다른 경우에는 객체 내에 함수를 넣어서 해결 가능





#### 반복문

- for

  - ```javascript
    for (let i = 0; i < 10; i++) {
      console.log(`for: ${i}`);
    }
    ```

  - 배열을 다룰 때는 주로 `for of` 또는 `for in`을 사용 : [객체](# 2.4.-객체와-클래스) 부분 참조

- while

  - while문에서는 단순히 숫자를 1씩 올리는 것보다는 좀 까다로운 조건식을 이용하는 것이 일반적

  - ```javascript
    let i = 3;
    let isFun = false;
    
    while (!isFun) {
      console.log(`while: ${i}`)
      i++;
      if (i === 10){
        isFun = true;
      }
    }
    ```

- do-while

  - 먼저 do 블럭을 실행해 조건이 맞는지 검사

- Nesting(중복 포문) 작성 가능





### 2.3. 함수



함수란?

- 특정 코드를 하나의 명령으로 실행 할 수 있게 해주는 기능

- 기본 형태

  - ```javascript
    function add(a, b) {
      return a + b;
    }
    ```

- Arrow function

  - 함수를 간단하게 쓰려고 사용

  - 기본 형태

    - ```javascript
      const add = (a, b) => {
        return a + b;
      };
      ```

    - 블럭 사용시 return 명시해야 함

  - 코드 블록 내부에서 바로 return 을 하는 경우는 블럭을 없애고 단축 가능

    - ```javascript
      const add = (a, b) => a + b;
      ```



Template Literal

- 파이썬의 f String과 똑같은 기능을 한다고 볼 수 있음

- ```javascript
  function hello(name) {
    console.log(`Hello, ${name}!`);
  }
  ```

- 백틱을 이용하여 문자열을 감싸고 변수는 `${ }`로 감쌈



기본 파라미터

- 다음과 같이 파라미터에 기본 값을 지정할 수 있음(ES6 이후)

- ```javascript
  function calculateCircleArea(r = 1) {
    return Math.PI * r * r;
  }
  ```



자바스크립트 함수의 특징

**추후 보강**

- Early return, Early exit
  - 조건이 만족될 때 특정 로직이 도는 함수가 있다면
  - 조건이 안 맞는 경우 먼저 리턴, 그 후에 조건이 맞는 경우에 대한 로직을 작성하는 것이 효율적

- function expression: **1급 객체**로 기능하게 해 줌
  - function declaration은 호이스팅 가능하나 이것은 불가
    - 변수에 할당된 이후에만 실행
  - anonymous function: 이름 없이 기능만 작성해서 변수에 할당
  - named function: 디버깅하기 편하려고 씀
- IIFE(Immediately Invoked Function Expression)
  - 함수를 선언하는 즉시 실행하는 것: 함수를 괄호로() 둘러싸면 됨



Callback Function

- 함수 타입의 값을 파라미터로 넘겨줘서, **파라미터로 받은 함수를 특정 작업이 끝나고 호출**을 해주는 것



#### Scope



Scope의 종류

- **Global Scope**: 코드의 모든 범위에서 사용이 가능
- **Function Scope**: 함수 안에서만 사용이 가능
- **Block Scope**: if, for, switch 등 특정 블록 내부에서만 사용이 가능



Global Scope

- 어플이 종료될 때까지 메모리를 차지하므로 사용 최소화 권장
- 클래스, 함수, 반복문 등 필요한 부분에서만 쓰자



Block Scope

- 블럭 {} 밖에서 접근할 수 없게 함
- `let`, `const` 로 선언한 값은 Block Scope 로 선언
  - 블록 내부에서만 사용 가능하며, 블록 밖에서 똑같은 이름을 가진 값이 있어도 영향을 주지 않음
- **`var` 는 Function Scope 로 선언**이 됨
  - if 문 블록 내부에서 선언한 value 값이 블록 밖의 value 에도 영향을 미침
  - 함수 밖에서 선언한 var 변수가 함수 내에 영향을 주지는 않음



Hoisting

- 아직 선언되지 않은 함수/변수를 "끌어올려서" 사용 할 수 있는 자바스크립트의 작동 방식

- 단, `const` 와 `let` 은 hoisting 이 발생하지 않고, 에러가 발생함

  - `var`는 가능

  - ```javascript
    console.log(number);	// undefined가 출력됨
    var number = 2;			
    ```

  - `const`, `let`은 불가능

  - ```javascript
    function fn() {
        console.log(a); // Reference Error : Cannot access 'a' before initialization
        let a = 2;
    }
    fn();
    ```

  - Codesandbox 에서는 **Babel**이 `const`, `let` 을 `var` 로 변환하기 때문에 오류가 발생하지 않음

- Hoisting은 방지하는 것이 좋음

  - 이해하기 어렵기 때문에 유지보수도 힘들어지고 의도치 않는 결과물이 나타나기 쉬움



**Dynamic typing**

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



### 2.4. 객체와 클래스

> 클래스는 ES6에 도입됨 : 이전에는 객체 생성자 function을 이용해서 바로 객체를 만들어서 사용함



객체란?

- 관련된 데이터와 함수의 집합

  - 자바스크립트에서 객체는 key, value의 집합체

- 클래스를 이용해서 만들거나(new), 중괄호를 이용해서 생성(object literal)

  - ```javascript
    const ironMan = {
      name: '토니 스타크',
      actor: '로버트 다우니 주니어',
    };
    ```

  - 키에는 공백이 없어야 하며, 일반적으로 문자열임



객체의 이용

- 객체 내 데이터 이용

  - `objectName.key` 로 객체 내 데이터를 이용함

  - ```javascript
    function print(hero) {
      const text = `${hero.name} 역할을 맡은 배우는 ${hero.actor} 입니다.`;
      console.log(text);
    }
    
    print(ironMan);
    ```

- 객체 관련 함수

  - `in` : 키가 있는지 체크하는 bool 함수
  - `for .. in` 
    - `for (key in ellie) {...}`
    - object 내의 **키를 순회**
    - `Object.keys()`와 함께 알아두자 : 객체 내의 키들을 배열 형태로 리턴함
  - `for .. of`
    - `for (value of iterable) {...}`
    - 배열 내의 **원소를 순회**
    - 보통 배열은 내장함수를 이용하여 순회하기 때문에 딱히 쓰지는 않음

- object의 copy

  - for문을 돌면서 일일이 복사를 해주거나(old way)
  - `Object.assign()`을 활용: assign<Target, source1, source2>
    - `const user2 = Object.assign({}, user);`
    - source가 여러 개이고 같은 필드가 있으면 뒤에 있는 것이 덮어씌우게 됨
  - **object는 call by reference**이기 때문에 deep copy하려면 위와 같이 해야 함



객체 비구조화 할당

- 객체에서 값들을 추출해서 새로운 상수로 선언해 주는 것 : 코드를 **짧고 가독성 좋게** 작성할 수 있음

- ```javascript
  function print(hero) {
    const { name, actor } = hero;		// 비구조화 할당
    const text = `${name} 역할을 맡은 배우는 ${actor} 입니다.`;
    console.log(text);
  }
  ```

- 파라미터 단계에서 객체 비구조화 할당을 할 수도 있음

- ```javascript
  function print({ name, actor }) {
    const text = `${name} 역할을 맡은 배우는 ${actor} 입니다.`;
    console.log(text);
  }
  ```

- 비구조화 할당에도 기본 값 설정 가능함

- 비구조화 할당시 **이름 변경 가능**함

- ```javascript
  const animal = {
    name: '멍멍이',
    type: '개'
  };
  
  const { name: nickname } = animal
  console.log(nickname);			// animal 객체 안에 있는 name 을 nickname 이라고 선언
  ```

- 배열에서도 비구조화 할당 가능함

- ```javascript
  const array = [1, 2];
  const [one, two] = array;
  
  console.log(one);
  ```

- 비구조화 할당은 가독성이 목적이므로 이를 해치지 않는 선에서 적당히 잘 이용하자



객체 내 함수

- 객체 내에 함수를 선언할 수 있음

  - ```javascript
    const dog = {
      sound: '멍멍!',
      say: function() {
        console.log(this.sound);
      }
    };
    dog.say();
    ```

  - 함수를 선언할 때 함수 이름은 없어도 됨 (anonymous function)

- this

  - 함수가 객체안에 들어가게 되면, `this` 는 자신이 속해있는 객체를 가리킴
  - 화살표 함수 this는 자신이 속한 객체를 가리키지 않음
    - 객체 내에는 function 으로 선언한 함수를 사용해야 함
    - 그럼 뭘 가리킴? 화살표 함수는 자신의 `this`가 없습니다. 대신 화살표 함수를 둘러싸는 **렉시컬 범위**(lexical scope)의 `this`가 사용됩니다; 
    - [MDN](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Functions/Arrow_functions) 추후 보강

- Getter와 Setter

  - Getter : 특정 값을 **조회할 때** 프로그래머가 설정한 함수로 연산된 값을 반환

    - 함수 앞부분에 `get` 키워드 붙임

    - ```javascript
      const numbers = {
        a: 1,
        b: 2,
        get sum() {
          console.log('sum 함수가 실행됩니다!');
          return this.a + this.b;
        }
      };
      console.log(numbers.sum);
      ```

  - Setter : 특정 값을 **설정할 때** value를 인자로 받아와서 값을 설정하고 추가적인 연산 가능

    - 함수 앞부분에 `set` 키워드 붙임

    - ```javascript
      const numbers = {
        _a: 1,
        _b: 2,
        sum: 3,
        calculate() {
          this.sum = this._a + this._b;
        },
        get a() {
          return this._a;
        },
        get b() {
          return this._b;
        },
        set a(value) {
          this._a = value;
          this.calculate();
        },
        set b(value) {
          this._b = value;
          this.calculate();
        }
      };
      
      console.log(numbers.sum);
      numbers.a = 5;
      numbers.b = 7;
      numbers.a = 9;
      console.log(numbers.sum);
      console.log(numbers.sum);
      console.log(numbers.sum);
      ```
      
    - a 혹은 b 값이 "바뀔 때마다" sum 값을 연산 : sum을 "조회할 때마다" 연산하는 get보다 효율적



객체 생성자

- 함수를 통해서 새로운 객체를 만들고 그 안에 넣고 싶은 값 혹은 함수들을 구현할 수 있게 해 줌

- 함수의 이름은 대문자로 시작하고, 새로운 객체를 만들 때에는 `new` 키워드를 앞에 붙여주어야 

  - ```javascript
    function Animal(type, name, sound) {
      this.type = type;
      this.name = name;
      this.sound = sound;
      this.say = function() {
        console.log(this.sound);
      };
    }
    ```

- 객체 내 함수를 재사용하기 위해 **프로토타입** 등장

  - 위 코드에서는 객체를 생성할 때마다 함수를 새롭게 선언해야 함

  - 프로토타입은 객체 생성자 함수 아래에 `.prototype.[key] =` 코드를 입력하여 설정 

  - ```javascript
    Animal.prototype.say = function() {
      console.log(this.sound);
    };
    Animal.prototype.sharedValue = 1;
    ```

- 객체 생성자에도 상속이 있으나 pass..



클래스

- 선언

  - `constructor(parameters) {}`: 클래스 필드 정의
    - consructor 없이 publicField, #privateField를 정의할 수 있음
    - 파이썬과 마찬가지로 static, static method 정의 가능
  - 그 밑에 메소드 선언
  - 객체를 만들 때는 `new Class()`로 선언

- Getter, Setter

  - 사용자 실수로 class property를 잘못 설정했을 때 수정하게 해줌
- 자바와 마찬가지로 캡슐화를 위해 사용됨
  
- 클래스 예시

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

- 상속

  - extends를 통해 상속함
  
  - ```javascript
    class Animal {
      constructor(type, name, sound) {
        this.type = type;
        this.name = name;
        this.sound = sound;
      }
    }
    
    class Dog extends Animal {
      constructor(name, sound) {
        super('개', name, sound);
      }
    }
    ```
  
  -  Overriding 가능: `super.method()`하면 부모 메소드도 사용



### 2.5. 배열



배열이란?

- 여러개의 항목들이 들어있는 리스트

  - 자바스크립트 배열 안에는 어떤 값, 어떤 타입도 들어갈 수 있음

- 배열 선언

  - ```javascript
    const array = [1, true, { name: '멍멍이' }, [1, 2, 3]];
    ```

  - 배열 안에는 객체도 배열도 뭐 다 들어감

  - 조회는 `array[1]`과 같이 함



#### 배열 내장함수



forEach

- for 문을 대체하여 배열 순회 가능

- `.forEach()`의 **파라미터로 함수**를 받음 : 배열을 순회하면서 각 원소들을 함수의 인자로 전달

  - ```javascript
    const superheroes = ['아이언맨', '캡틴 아메리카', '토르', '닥터 스트레인지'];
    
    function print(hero){
        console.log(hero);
    }
    
    // 세 개 다 같은 기능을 함
    superheroes.forEach(print)
    superheores.forEach(function(hero) {
        console.log(hero)
    })
    superheroes.forEach(hero => {
      console.log(hero);
    });
    ```



map

- 배열 안의 각 원소를 변환 할 때 사용 되며, 이 과정에서 **새로운 배열이 만들어짐**

- `.map()`의 파라미터로 함수를 받음 : 배열의 원소를 변환해 줄 함수가 들어감

  - ```javascript
    const array = [1, 2, 3, 4, 5, 6, 7, 8];
    const square = n => n * n;
    
    // 같은 결과
    const squared = array.map(square);
    const squared = array.map(n => n * n);
    ```



filter

- 배열에서 **특정 조건을 만족하는 값들만 추출하여 새로운 배열**을 만들어 냄

- `filter()`의 파라미터로는 **조건을 검사하는 함수**가 들어감

  - ```javascript
    function countBiggerThanTen(numbers) {
      return numbers.filter(n => n > 10).length;
    }
    
    const count = countBiggerThanTen([1, 2, 3, 5, 10, 20, 30, 40, 50, 60]);
    console.log(count);
    ```



splice vs slice

- splice : 배열에서 특정 항목을 제거
  - `splice(index, num)` 으로 사용함 : 어떤 인덱스부터 몇개를 지울지 결정
  - 리턴값이 없는 함수로 배열의 내용물을 변경함
- slice : 파이썬 리스트 슬라이싱과 완벽히 똑같음
  - `slice(start, end)` : start index는 포함하고 end index 전까지 포함
  - 배열의 내용물을 건드리지 않고 슬라이싱한 배열을 리턴함



원소 추가 및 제거

- 뒤에 추가: `push()`  뒤에서 빼기: `pop()`
  
  - 빈 배열에서 pop() 하면 아무 일도 일어나지 않음
  
- 앞에 추가: `unshift()`  앞에서 빼기: `shift()`
  - 앞에서 빼거나 추가하지 말자
  - O(n)으로 굉장히 느리기 때문에 안 쓰는 것이 좋음
  
- 두 배열을 합치기 : `concat()`

  - 배열에는 영향을 주지 않고 새로운 배열을 리턴함

  - ```javascript
    const concated = arr1.concat(arr2);
    ```

- 배열 안의 값들을 문자열 형태로 합쳐주기 : `join()`

  - 파이썬과 동일



검색

- `indexOf()` 

  - 인덱스 반환 : 여러개 있으면 제일 먼저 나오는 인덱스 반환, 반대는 `.lastIndexOf()`

- `includes()`

  - 존재여부 찾기 : bool 값을 반환

    - 특정 값이 여러 값 중 하나인지 확인할 때 이용하면 좋음

    - ```javascript
      function isAnimal(name) {
        const animals = ['고양이', '개', '거북이', '너구리'];
        return animals.includes(name);
      }
      ```

  - indexOf()도 사용 가능한데, 포함 안 되어 있으면 -1이 반환되고 포함 되어 있으면 인덱스를 반환

- `findIndex()` 

  - 배열 안에 있는 값이 객체나 배열이라면 찾을 대상과 비교할 수 있는 함수를 넣어줌

  - ```javascript
    const index = todos.findIndex(todo => todo.id === 3);
    ```

- `find()` 

  - 찾아낸 값이 몇번째인지 알아내는 것이 아니라, 찾아낸 값 자체를 반환
  - 사용법은 findIndex()와 동일



**reduce**

- **콜백 함수**와 초깃값을 이용하여 다양한 계산을 수행함

- ```javascript
  const numbers = [1, 2, 3, 4, 5];
  let sum = numbers.reduce((accumulator, current) => {
    console.log({ accumulator, current });
    return accumulator + current;
  }, 0);
  ```

- 콜백함수는 첫번째 파라미터로 초깃값을, 두번째 파라미터로 배열의 각 원소를 받아와서 반복적으로 계산함



### 2.6. 기타



spread

- 스프레드 연산자 `...`를 이용하여 기존의 것을 건드리지 않고, 새로운 객체나 배열을 만들 수 있음

  - ```javascript
    // 객체
    const slime = {
      name: '슬라임'
    };
    
    const cuteSlime = {
      ...slime,
      attribute: 'cute'
    };
    
    //배열
    const numbers = [1, 2, 3, 4, 5];
    
    const spreadNumbers = [...numbers, 1000, ...numbers];
    console.log(spreadNumbers); // [1, 2, 3, 4, 5, 1000, 1, 2, 3, 4, 5]
    ```



rest

- 객체, 배열, 함수의 파라미터에서 이용 가능

- 비구조화 할당 문법과 함께 사용하여 객체나 배열을 분리할 수 있음

  - ```javascript
    const purpleCuteSlime = {
      name: '슬라임',
      attribute: 'cute',
      color: 'purple'
    };
    
    const { color, ...rest } = purpleCuteSlime;
    console.log(rest);		// Object {name : '슬라임', attribute : 'cute'}
    ```

  - 추출한 값의 이름이 꼭 rest 일 필요는 없음

  - 배열에서 rest를 사용할 경우 rest는 반드시 맨 뒤로 가야 함

- 함수의 파라미터가 몇개가 될 지 모르는 상황에서 rest 파라미터를 사용하면 매우 유용함

  - ```javascript
    function sum(...rest) {
      return rest.reduce((acc, current) => acc + current, 0);
    }
    
    const result = sum(1, 2, 3, 4, 5, 6);
    ```





## **3. 비동기 처리**

> 자바스크립트 자체는 동기적: 호이스팅이 된 이후로는 하나씩 순서대로 실행
>
> 비동기 함수를 만나면 webAPI, 태스크큐 등을 거쳐 비동기적 실행



![synchronous](https://i.imgur.com/hh3Mawr.png)



비동기 처리란?

- 한 작업이 끝나야 다른 작업을 처리하는 동기적 처리와 달리 **동시에 여러 가지 작업을 처리**하는 것
  - 주로 많은 시간이 걸리는 작업에 대해 비동기 처리를 함
  - JS 엔진이 싱글 쓰레드기 때문에 **자바스크립트 자체는 기본적으로 동기적**임
- 자바스크립트에서 비동기적으로 처리하는 작업 예시
  - Ajax Web API 요청
  - 파일 읽기
  - 암호화-복호화
  - 작업 예약



### 3.1. 비동기 처리 방법



`setTimeout()`

- ```javascript
  function work() {
    setTimeout(() => {
      const start = Date.now();
      for (let i = 0; i < 1000000000; i++) {}
      const end = Date.now();
      console.log(end - start + 'ms');
    }, 0);
  }
  
  console.log('작업 시작!');
  work();
  console.log('다음 작업');
  ```

  - 작업 시작! → 다음 작업 → 600ms 순으로 log가 찍힘

- 첫번째 파라미터에 넣는 함수를, 두번째 파라미터에 넣은 **시간(ms 단위)이 흐른 후 호출**해 줌

  - 최소 단위로 4ms가 지정되어 있음
  - 지정한 시간이 흘렀어도 **다른 작업이 진행중이라면 호출되지 않음** : 그거 끝나고 호출함

- 함수가 끝난 뒤 다른 작업을 처리해야 하는 경우에는 콜백 함수를 이용해서 처리



#### Promise

Promise란?

- 비동기 작업을 조금 더 편하게 처리 할 수 있도록 ES6 에 도입된 Object
  - 과거에는 비동기 처리를 위해 콜백 함수를 이용했었는데, 복잡한 작업의 경우 **콜백 지옥**에 빠짐
  - 이를 해결하기 위해 Promise를 도입
- 기능이 수행됐다면(`resolve`) 성공 메시지를, 실패했다면(`reject`) 실패 메시지를 보냄
  - Promise 객체는 성공하는 경우, 실패하는 경우에 대해 각각 콜백 함수를 받아서 비동기 처리를 수행



Producer

- 원하는 기능을 수행하여 데이터(리턴 값)를 만들어 내는 쪽 : Promise 객체

  - ```javascript
    const promise = new Promise((resolve, reject) => {
        console.log('doing something...');
        setTimeout(() => {
            //resolve('ellie')
            //reject(new Error('no network'));
        }, 1000);
    });
    ```

- Promise 객체는 executor 콜백 함수를 인자로 받아서 생성됨

  - 객체가 만들어지는 순간 executor 콜백 함수를 실행함
  - 성공/실패 각각에 대해 executor를 받음 (위 예제에서는 둘 다 주석 처리 했지만)



Consumer

- 제공되는 데이터를 사용하는 쪽
  - 여기서 `then`, `catch`를 묶어서(chaining) 연속적인 비동기 처리를 수행함
- `promise.then()` 
  - promise 객체가 수행한 결과를 받아와 then 내부의 콜백 함수를 실행
  - 이 때 **promise 객체를 리턴**함
- `promise.catch()` 
  - error가 발생했을 때 어떻게 처리할 것인지 나타내는 콜백 함수를 등록
- `promise.finally()`
  - 성공, 실패 여부와 관계 없이 무조건 실행됨



**Promise Chaining**

- `then` 내부에 넣은 함수에서 리턴하는 Promise 를 받아 연달아서 사용하는 것

  - 예제 : 숫자를 입력받아 1씩 증가시키며 5가 될 때까지 console에 찍음

  - ```javascript
    function increaseAndPrint(n) {
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          const value = n + 1;
          if (value === 5) {
            const error = new Error();
            error.name = 'ValueIsFiveError';
            reject(error);
            return;
          }
          console.log(value);
          resolve(value);
        }, 1000);
      });
    }
    
    increaseAndPrint(0)
      .then(increaseAndPrint)	// 리턴 값을 그대로 콜백함수에 사용하는 경우 parameter 생략
      .then(increaseAndPrint)
      .then(increaseAndPrint)
      .then(increaseAndPrint)
      .then(increaseAndPrint)
      .catch(e => {
        console.error(e);
      });
    ```

  - 콜백 지옥이 일어나는 부분이 깔끔히 정리된 것을 확인할 수 있음

- 단점

  - 에러를 잡을 때 몇번째에서 발생했는지 알아내기도 어려움
  - 특정 조건에 따라 분기를 나누는 작업이 어려움
  - 특정 값을 공유해가면서 작업을 처리하기 까다로움



#### async, await





### 자바스크립트의 구성

- **JS 엔진**
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



