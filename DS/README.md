# Data Structure

>  데이터 단위와 데이터 자체 사이의 물리적 또는 논리적 관계



참고서적

- 윤성우의 열혈 자료구조
- 자료구조와 함께 배우는 알고리즘 입문 - Bohyoh Shibata
- 파이썬 알고리즘 인터뷰 - 박상길



이 문서는 C언어 기준으로 작성됨

Java에서 사용되는 자료구조는 Java 참조



[TOC]



## **1. 자료구조란?**

> 데이터를 저장하는 것



자료구조의 종류

- 선형 자료구조
  - 배열
  - 리스트
  - 스택
  - 큐
- 비선형 자료구조
  - 트리
  - 그래프



추상 자료형(Abstract Data Type)

- 추상 자료형이란?
  - 자료 자체의 형태와 그 자료에 관계된 연산들을 **수학적으로**만 정의한 것
  - 구체적인 기능의 완성과정을 언급하지 않고, **기능이 무엇인지만 나열**한 것
    - 내부 구현을 알지 못해도 활용할 수 있도록 함
- 자료구조와의 관계
  - 자료구조는 추상적 자료형이 정의한 연산들을 구현한 구현체를 가리키는 말
  - 어떠한 자료구조이건 간에 **자료구조의 구현과 구현된 자료구조의 활용은 구분되도록 정의**되어야 함
  - 자료구조는 ADT의 정의를 알고 → 정의한 ADT를 구현한 후 → 활용하는 방법을 익혀야 함



자료구조와 알고리즘

- 알고리즘은 자료구조에 의존적임
  - 자료구조가 결정되어야 그에 따른 효율적인 알고리즘을 결정할 수 있음
- 알고리즘을 사용하기 위해 개발된 자료구조도 존재
  - 예) 이진 탐색을 하기 위해 이진 탐색 트리가 개발됨



### 1.1. 배열



배열이란?

- **같은 자료형**의 변수로 이루어진 요소가 모여 **직선 모양으로** 줄지어 있는 자료구조

  - ```c
    int arr[number of element];
    ```

  - 이 때 **요소의 갯수는 상수**만 사용 가능

    - 변수를 사용하면 런타임에 크기가 변화될 수 있음 : 컴파일되지 않음
  
- 배열의 개별 요소에는 **인덱스**를 이용하여 접근

  - 인덱스 : 각 원소들에 순서대로 붙인 번호



배열의 특징

- 빠른 검색
  - 인덱스를 이용하여 O(1)에 탐색 가능
  - 임의 접근이(random access) 가능한 자료구조임
- 크기가 변하지 않음
  - 배열은 컴파일 타임에 크기가 결정되며 크기가 변하지 않음
  - 크기를 변화시켜야 할 때는 새 배열을 만들고 기존 내용을 복사하거나, 배열의 일부를 연결 리스트 등으로 다른 곳과 연결함
- 삽입과 삭제가 느림
- 캐시 친화적임
  - 캐시를 적용하는 기준이 일정 크기의 연속된 메모리 영역인 경우가 많기 때문



### 1.2. 구조체



구조체란?

- 임의의 데이터를 다시 조합하여 만드는 자료구조

  - 클래스와 같은 개념
  - 임의의 데이터 타입들을 멤버로 가지는 **데이터의 묶음**
    - 어떤 객체가 갖는 데이터들을 각각 배열로는 관리하기 어렵기 때문에 묶어서 관리하는 것

- 구조체의 선언

  - ```c
    struct person{
        int		height;
        long	personID;
        double	vision;
    };
    ```

  - 중괄호 안의 멤버들을 모아 `struct person` 타입의 구조체를 새롭게 정의한 것 



구조체의 사용

- 멤버 접근

  - `objectName.meberName` : 객체 이름을 이용하여 멤버에 접근
  - `pointerName -> memberName` : 객체를 가리키는 포인터 이름을 이용하여 멤버에 접근

- typedef

  - 구조체의 이름 앞에는 반드시 struct가 따라와야 함: 번거로우니 typedef를 이용하여 동의어 선언

  - ```c
    struct person{
        ...
    }typedef P
    ```

  - 이걸로 `struct person` 을 `P`로 대체 가능



자료형의 정의

- 자료형의 정의는 구조체의 정의에 연산의 종류를(ADT) 결정하는 것을 통해 이루어짐
  - 예) Wallet 구조체에 멤버 변수를 정의하고, 입출금 메소드를 더해 자료형의 정의를 완성함
  - ADT에 구조체의 정의는 포함하지 않아도 됨
    - 기능에 대해서만 정의하는 것으로 충분한 경우



## **2. List**

> 데이터를 순서대로 나열, **중복을 허용**한 자료구조



리스트 자료구조의 ADT

- `void ListInit(List * plist);`
  - 초기화할 리스트의 주소 값을 인자로 전달함
  - 리스트 생성 후 가장 먼저 호출 됨
- `void LInsert(List * plist, LDta data);`
  - 리스트에 데이터를 저장함
  - 매개변수 data에 전달된 값을 저장함
- `bool LFirst(List * plist, LData * pdata);`
  - 첫 번째 데이터가 **pdata가 가리키는 메모리에 저장**됨
  - 데이터의 참조를 위한 초기화가 진행됨
  - 참조 성공/실패를 반환
- `bool LNext(List * plist, LData * pdata);`
  - 참조된 데이터의 **다음 데이터가 pdata가 가리키는 메모리에 저장**됨
  - 순차적인 참조를 위해 반복 호출이 가능함
  - 참조를 새로 시작하려면 먼저 LFirst 함수를 호출해야 함
  - 참조 성공/실패 반환
- `LData LRemove(List * plist);`
  - LFirst 또는 LNext 함수의 **마지막 반환 데이터를 삭제**함
    - LFirst, LNext 함수에서 pdata 포인터가 가리키게 된 값을 삭제함
  - 삭제된 데이터는 반환됨
  - 마지막 반환 데이터를 삭제하므로 반복 호출을 허용하지 않음
- `int LCount(List * plist);`
  - 리스트에 저장되어 있는 데이터의 수를 반환함



### 2.1. Array List



순차 리스트란?

- 배열을 기반으로 구현된 리스트
- 장단점
  - 쌓이는 데이터의 크기(배열의 길이)를 미리 알아야 하고 변경이 불가능 함
  - 데이터를 삭제하는 과정에서 데이터를 옮겨야 하기 때문에 효율이 나쁨
  - 인덱스 값을 기준으로 어디든 한 번에 참조가 가능함



ArrayList 구현

- 구조체 정의

  - ```c
    typedef struct __ArrayList{
        LData arr[LIST_LEN];		// 리스트를 저장할 배열
        int numOfData;				// 저장된 데이터의 수
        int curPosition;			// 데이터 참조 위치를 기록
    }ArrayList;
    ```

- 삽입

  - ```c
    void LInsert(List * plist, LData data){
        if(plist -> numOfData >= LIST_LEN){
            puts("저장이 불가능합니다");
            return
        }
        plist -> arr[plist->numOfData] = data;	// 데이터 저장
        (plist->numOfData)++;					// 저장된 데이터의 수 증가
    }
    ```

  - 데이터 수가 배열의 길이를 초과했는지 검사하고(validation) 초과하지 않았다면 저장함

  - numOfData를 배열의 인덱스로써 활용함

- 조회

  - ```c
    bool LFirst(List * plist, LData * pdata){
        if(plist -> numOfData == 0)		// 저장된 데이터가 없다면 FALSE 반환
            return FALSE;
        
        (plist -> curPosition) = 0;		// 참조 위치 초기화
        *pdata = plist -> arr[0];
        return TRUE;
    }
    ```

  - 참조 위치를 초기화하여 데이터의 참조가 앞에서부터 진행되도록 함

  - ```c
    bool LNext(List * plist, LData * pdata){
        if(plist->curPosition >= (plist->numOfData)-1 ) // 더이상 참조할 데이터가 없으면
            return FALSE;
        
        (plist -> curPosition)++;
        *pdata = plist -> arr[plist->curPosition];
        return TRUE;
    }
    ```

  - curPosition에 저장된 값을 증가시켜서 데이터의 참조가 순서대로 이루어지도록 함

- 삭제

  - 중간에 데이터가 삭제되면 뒤에 저장된 데이터들을 한 칸씩 이동시켜서 빈 공간을 메워야 함

    - 앞에서부터 데이터를 채워야 하기 때문

  - ```c
    LData LNext(List * plist){
        int rpos = plist -> curPosition;
        int num = plist -> numOfData;
        int i;
        LData = rdata = plist -> arr[rpos];
            
        for(i=rpos; i<num-1; i++)
            plist -> arr[i] = arr[i+1];
        
        (plist -> numOfData)--;
        (plist -> curPosition)--;
        return rdata;
    }
    ```



### 2.2. Linked List



연결 리스트란?

- 메모리의 동적 할당을 기반으로 구현된 리스트
  - 필요할 때마다 노드 역할을 하는 구조체 변수를 하나씩 동적 할당하여 이들을 **연결**하는 것
- 노드들의 연결
  - 각 노드는 데이터와 **다음 노드를 가리키는 포인터**를 갖고 있음
  - 각 노드의 앞 노드를 predecessor node, 뒷 노드를 successor node라고 함
  - 맨 앞 노드는 head node, 맨 뒷 노드는 tail node라고 함
    - 새 노드를 추가할 때 머리에 추가할 경우엔 tail 변수가 필요 없음



장단점

- 삽입과 삭제가 빠름
  - 삽입하는 곳 전후로 새로운 노드와의 연결만 추가하면 됨
  - 삭제도 마찬가지로 연결만 끊어내면 됨 : O(1)
- 조회가 느림
  - 인덱스를 이용할 수 없고 원하는 데이터를 찾을 때까지 링크를 계속 따라가야 함 : O(n)
- 추가적인 포인터 변수 사용으로 배열 대비 메모리 공간이 낭비됨



#### 2.2.1. Singly Linked List



ADT

- 기본적으로 리스트의 ADT와 동일함
  - 여기서는 정렬 기능을 추가해 봄
- `void SetSortRule(List * plist, bool (*comp)(LData d1, LData d2));`
  - 리스트에 정렬의 기준이 되는 함수를 등록함
  - 두 번째 parameter로 데이터를 비교하여 무엇이 앞에 위치할 지 결정하는 함수 포인터 comp를 받음



Node 구현

- 하나의 구조체 안에 두 개의 변수 **data**와 **next**가 존재: 포인터를 이용해 다음 노드를 가리킴

- ```c
  typedef struct __node{
      Data data;
      struct __node *next;	// 다음 노드를 가리키는 포인터 next
  } Node;
  ```



Singly Linked List 구현

- 맨 앞에 시작 노드인 헤드, 맨 뒤 노드에는 next에 NULL을 담음

- 삽입

  - 새로운 노드를 head, tail 중 어디에 삽입할지 결정해야 함

    - head에 추가할 경우 : tail 변수가 필요하지 않으나 저장된 순서가 유지되지 않음
    - tail에 추가할 경우 : tail 변수가 필요하지만 저장된 순서가 유지됨
    - 여기서는 dummy node를 활용해 head에 추가함

  - 정렬의 기준 유무에 따라 다른 삽입 함수를 호출함

  - ```c
    void LInsert(List * plist, LData data){
        if(plist -> comp == NULL)
            FInsert(plist, data);
        else
            SInsert(plist, data);
    }
    ```

  - 기준이 없는 경우

    - ```c
      void FInsert(List * plist, LData data){
          Node * newNode = (Node*)malloc(sizeof(Node));
          newNode -> data = data;
          
          newNode -> next = plist -> head -> next;	//새 노드가 선두의 노드를 가리킴
          plist -> head -> next = newNode;			//더미 노드가 새 노드를 가리킴
          
          (plist -> numOfData)++;
      }
      ```

    - 삽입할 위치 이전 노드가 삽입하는 노드를 가리키고, 삽입하는 노드가 다음 노드를 가리키도록 함

    - dummy node가 있기 때문에 모든 **노드의 추가과정이 일관되게 정의**됨

    - 더미가 없으면 예외 처리가 필요함

  - 기준이 있는 경우

    - ```c
      void SInsert(List * plist, LData data){
          Node * newNode = (Node*)malloc(sizeof(Node));
          Node * pred = plist -> head;				//더미 노드
          newNode -> data = data;
          
          // 새 노드가 들어갈 위치 찾기
          while(pred->next != NULL && plist->comp(data, pred->next->data)!=0){
              pred = pred -> next;	// 다음 노드로 이동
          }
          
          newNode -> next = pred -> next;		// 새 노드의 오른쪽 연결
          pred -> next = newNode;				// 새 노드의 왼쪽 가리킴
          
          (plist -> numOfData)++;
      }
      ```

    - comp에 등록된 함수의 호출결과에 기반해서 새 노드가 추가될 위치를 찾음

    - 새 노드의 data와 현재 노드 pred의 다음 노드를 비교 : FALSE가 나오면 pred의 다음에 새 노드 삽입

    - **정렬의 기준이 되는 함수는 연결 리스트가 호출되는 파일에 작성**돼야 함 : 유연성 확보

- 조회

  - 현재 노드를 가리키는 cur 포인터를 이용

  - ```c
    int LFirst(List * plist, LData * pdata){
        if(plist->head->next == NULL)
            return FALSE;
        
        plist -> before = plist -> head;		// before은 더미 노드를 가리킴
        plist -> cur = plist -> head -> next;	// cur은 첫 번째 노드를 가리킴
        
        *pdata = plist -> cur -> data;
        return TRUE;
    }
    
    int LNext(List * plist, LData * pdata){
        if(plist->cur->next == NULL)
            return FALSE;
        
        plist -> before = plist -> cur;			// cur이 가리키던 것을 before가 가리킴
        plist -> cur = plist -> cur -> next;	// cur은 그 다음 노드를 가리킴
        
        *pdata = plist -> cur -> data;
        return TRUE;
    }
    ```

  - before은 삭제에 이용하기 위해 cur보다 하나 앞선 노드를 가리키게 함

- 삭제

  - 삭제할 위치 이전 노드가 다음 노드를 가리키고, 삭제할 노드 **메모리 할당 해제함**

  - 바로 이전에 호출된 LFirst 혹은 LNext가 반환한 데이터를 삭제함

  - ```c
    LData LRemove(List * plist){
        Node * rpos = plist -> cur;
        LData rdata = rpos -> data;
        
        plist->before->next = plist->cur->next;	// cur가 가리키는 노드를 리스트에서 제거
        plist->cur = plist->before;				// cur가 가리키는 위치를 앞으로 당김
        
        free(rpos);								// 리스트에서 제거한 노드 소멸
        (plist->numOfData)--;
        return rData;
    }
    ```



연결 리스트 구조체

- 노드를 가리키는 포인터는(head, cur 등) 따로 **구조체로 묶어야 함**

  - 프로그램에서 여러 연결 리스트를 사용할 수 있기 때문
  - 따라서 전역변수로 선언하는 것은 더더욱 안 됨

- 예시

  - ```c
    typedef struct __linkedList{
        Node * head;
        Node * cur;
        int numOfData;
        int (*comp)(LData d1, Ldata d2);
    } LinkedList;
    ```



#### 2.2.2. Circular Linked List



원형 연결 리스트란?

- 마지막 노드가 첫 번째 노드를 가리키는 연결 리스트
  - LNext 함수의 무한 반복 호출이 가능함
- 머리와 꼬리의 구분이 없음
  - **head, tail중 하나만 있어도 노드를 간단히 추가**할 수 있음
  - 일반적으로 tail만 두고 새로운 노드를 리스트의 끝에 추가하도록 구현함



원형 연결 리스트 구현

- 삽입

  - 새로운 노드를 리스트의 앞에 추가하는 경우와 뒤에 추가하는 경우가 있음

  - ```c
    void LInsert(List * plist, Data data){
        Node * newNode = (Node*)malloc(sizeOf(Node));
        newNode->data = data;
        
        if(plist->tail == NULL){
            plist->tail = newNode;
            newNode->next = newNode;
        }
        else{
            newNode->next = plist->tail->next;
            plist->tail->next = newNode;
            plist->tail = newNode;		// 앞에 추가하는 경우에는 이 코드가 빠짐
        }
    }
    ```

  - 머리에 추가하는 것과 꼬리에 추가하는 경우는 코드 한 줄만 다름 : 머리-꼬리 구분이 없음!

- 조회

  - 현재 노드를 가리키는 cur 포인터를 이용
  - Singly Linked List와 거의 동일하고 tail이 NULL인지만 체크하므로 구현은 생략
    - 리스트의 끝을 검사하지 않기 때문에 무한으로 반복해서 호출 가능

- 삭제

  - **더미 노드가 존재하지 않기 때문에 예외 상황을 고려**해야 함

    - 예외1 : 삭제할 노드를 tail이 가리키는 경우
    - 예외2 : 삭제할 노드가 리스트에 혼자 남은 경우

  - ```c
    LData LRemove(List * plist){
        Node * rpos = plist -> cur;
        LData rdata = rpos -> data;
        
        if(plist->tail == rpos){					// 예외1
            if(plist->tail == plist->tail->next)	// 예외2
                plist->tail = NULL;
            else
                plist->tail = plist->before
        }
        
        plist->before->next = plist->cur->next;	
        plist->cur = plist->before;				
        
        free(rpos);								
        (plist->numOfData)--;
        return rData;
    }
    ```

  - 더미 노드를 추가하면 삭제 코드는 간결해지지만 대신 삽입 시 예외 상황을 고려해야 함



#### 2.2.3. Doubly Linked List



Doubly Linked List란?

- 각 노드가 양쪽 방향으로 연결됨

  - 왼쪽 노드가 오른쪽 노드를 가리키는 동시에 오른쪽 노드도 왼쪽 노드를 가리킴
  - before 변수가 불필요하며 

- 각 노드는 data, **next, prev**를 가짐 : 앞 뒤 노드를 가리킴

  - Node 구현

  - ```c
    typedef struct __node{
        Data data;
        struct __node *prev;	// 이전 노드를 가리키는 포인터 prev
        struct __node *next;	// 다음 노드를 가리키는 포인터 next
    } Node;
    ```



Doubly Linked List 구현

- 삽입

  - 앞 노드의 next가 삽입할 노드를, 삽입할 노드의 prev가 앞 노드를 가리키게 함

  - 뒷 노드의 prev가 삽입할 노드를, 삽입할 노드의 next가 뒷 노드를 가리키게 함

  - ```c
    void LInsert(List * plist, Data data){
        Node * newNode = (Node*)malloc(sizeOf(Node));
        newNode->data = data;
        
        newNode->next = plist->head;
        if(plist->head != NULL)
            plist->head->prev = newNode;		// 두 번째 이후의 노드를 추가할 때 실행
        
        newNode->prev = NULL;
        plist->head = newNode;
        
        (plist->numOfData)++;
    }
    ```

- 조회

  - LFirst, LNext는 Singly Linked List와 차이가 없음

  - 역방향으로 조회하는 LPrevious만 구현

  - ```c
    int LPrevious(List * plist, Data * pdata){
        if(plist->cur->prev == NULL)
            return FALSE;
        
        plist->cur = plist->cur->prev;
        *pdata = plist->cur->data;
        return TRUE;
    }
    ```

- 삭제

  - **더미 노드를 도입하는 경우가 간단**하므로 해당 경우에 대해 구현

    - 더미 노드가 없으면 삭제할 노드가 맨 앞인 경우, 맨 뒤인 경우에 대해 예외처리 필요

  - 삭제할 노드의 앞 노드의 next를 뒷 노드로 하고, 뒷 노드의 prev가 앞 노드를 가리키게 함

  - ```c
    Data LRemove(List * plist){
        Node * rpos = plist->cur;
        Data * rdata = plist->cur->data;
        
        plist->cur->prev->next = plist->cur->next;
        plist->cur->next->prev = plist->cur->prev;
        
        plist->cur = plist->cur->prev;
        
        free(rpos);
        (plist->numOfData)--;
        return rdata;
    } 
    ```

  - 



## **3. 스택**

> 후입선출 방식의 자료구조



스택이란?

- 데이터를 일시적으로 저장하기 위한 자료구조로, **후입선출**이라는 특징을 가짐
  - 한 쪽이 막혀있는 통에 비유할 수 있음
  - **단일한 입구**를 통해 데이터가 출입함(push, pop)
- 스택을 사용하는 곳
  - 프로그램에서 함수를 호출하고 실행할 때(Call Stack)
  - 문자열 역순 출력
  - **연산자 후위 표기법**
- 배열 또는 링크드리스트로 구현될 수 있음



스택의 ADT

- `void StackInit(Stack * pstack);`
  - 스택의 초기화를 진행
  - 스택 생성 후 제일 먼저 호출되어야 하는 함수
- `bool SIsEmpty(Stack * pstack);`
  - 스택이 빈 경우 TRUE, 아닌 경우 FALSE를 반환
- `void SPush(Stack * pstack, Data data);`
  - 스택에 데이터를 저장함
  - 매개변수 data로 전달된 값을 저장
- `Data SPop(Stack * pstack);`
  - 마지막에 저장된 요소를 삭제함
  - 삭제된 데이터는 반환함
  - 삭제하기 전 데이터가 있는지 validation을 거쳐야 함
- `Data SPeek(Stack * pstack);`
  - 마지막에 저장된 요소를 반환하되 삭제하지는 않음
  - 실행하기 전에 데이터가 있는지 validation을 거쳐야 함



### 3.1. 배열로 구현



구현의 논리

- 스택의 가장 밑바닥을 bottom이라 하고, `stackArr[0]`을 bottom으로 설정함
  - 인덱스 0을 바닥으로 지정하면 **배열의 길이에 상관 없이** 언제나 인덱스 0의 요소가 바닥이 됨
- **스택 포인터** ptr을 움직이며 pop과 push를 수행
  - ptr은 포인터 변수가 아니라 스택의 인덱스로, top의 위치를 나타냄
    - top은 `stackArr[ptr]`임
  - push : top을 한 칸 올리고, top이 가리키는 위치에 데이터를 저장함
  - pop : top이 가리키는 데이터를 반환하고, top을 아래로 한 칸 내림



스택 구현하기

- 스택 구조체와 초기화
  
  - ```c
    typedef struct __arrayStack{
        Data stackArr[STACK_LEN];
        int ptr;
    } ArrayStack;
    ```
    
  - 스택 포인터만 초기화해 주면 됨(스택 길이는 헤더 파일에서 초기화한다 가정)
    
  - ```c
    void StackInit(Stack * pstack){
        pstack->ptr = -1;		// -1은 빈 상태를 의미함
    }
    ```
  
  - ptr이 0이면 0번 인덱스에 데이터가 있어야 하므로 -1이 빈 상태를 의미함
  
- IsEmpty

  - 비어있는지 확인하기 위해서는 ptr의 값만 체크하면 됨

  - ```c
    bool SIsEmpty(Stack * pstack){
        return pstack->ptr == -1;
    }
    ```

- Push

  - 배열은 **길이 제한이 있기 때문에 스택이 가득 찼는지 확인**해야 함

  - 가득 차지 않았다면 top을 한 칸 올리고, `stackArr[ptr]`에 데이터를 저장함

  - ```c
    void SPush(Stack * pstack, Data data){
        if(plist->ptr == STACK_LEN - 1){...}	// 에러 메세지 출력
        
        (pstack->ptr)++;
        pstack->stackArr[ptr] = data;
    }
    ```

- Pop

  - 스택이 비었는지 확인

  - 비지 않았다면 `stackArr[ptr]`의 데이터를 리턴하고 ptr을 감소시킴

  - ```c
    Data SPop(Stack * pstack){
        int rIdx;
        
        if(SIsEmpty(pstack)){...}	// 에러 메세지 출력
        
        rIdx = pstack->ptr;		
        (pstack->ptr)--;
        
        return pstack->stackArr[rIdx];
    }
    ```

  - 리턴할 데이터를 받기 위한 변수를 선언하면 메모리를 많이 차지하므로 인덱스를 가리키는 변수를 선언함

- Peek

  - ```c
    Data SPeek(Stack * pstack){
        if(SIsEmpty(pstack)){...}	// 에러 메세지 출력
        
        return pstack->stackArr[plist->ptr];
    }
    ```

  - 반환한 데이터를 소멸시키지 않으므로 간단함



### 3.2. 연결리스트로 구현



구현의 논리

- 연결리스트를 저장된 순서의 역순으로 조회(삭제) 가능하도록 만들면 스택이 됨
  - head에서 노드를 추가하고 삭제하면 됨



스택 구현하기

- 초기화

  - ```c
    void StackInit(Stack * pstack){
        pstack->head = NULL;
    }
    ```

  - 포인터 변수 head를 NULL로 초기화

- IsEmpty

  - ```c
    bool SIsEmpty(Stack * pstack){
        return pstack->head == NULL;
    }
    ```

  - head가 NULL인지 체크하여 비어있는지 판단

- Push

  - ```c
    void SPush(Stack * pstack, Data data){
        Node * newNode = (Node*)malloc(sizeOf(Node));
        
        newNode->data = data;
        newNode->next = pstack->head;
    
        pstack->head = newNode;
    }
    ```

  - 리스트의 머리 쪽에 노드를 추가함

- Pop

  - ```c
    Data SPop(Stack * pstack){
    	Data rdata;
        Node * rnode;
        
        if(SIsEmpty(pstack)){...}	// 에러 메세지 출력
    
        rdata = pstack->head->data;
        rnode = pstack->head
        
        pstack->head = pstack->head->next;
        free(rnode);
            
        return rdata;
    }
    ```

  - 삭제할 노드의 다음 노드를 head가 가리키도록 함

- Peek

  - ```c
    Data SPeek(Stack * pstack){
        if(SIsEmpty(pstack)){...}	// 에러 메세지 출력
        
        return pstack->head->data;
    }
    ```

  - 반환한 데이터를 소멸시키지 않으므로 간단함





### 3.3. Postfix

> 연산자 후위 표기법



중위 표기법과 후위 표기법



## **4. Queue**

> 선입선출 방식의 자료구조



큐란?

- 데이터를 일시적으로 저장하기 위한 자료구조로, **선입선출**이라는 특징을 가짐
  - 데이터를 넣는 작업(enqueue)과 꺼내는 작업이(dequeue) 다른 곳에서 일어남
  - 데이터를 꺼내는 쪽을 front, 넣는 쪽을 rear라고 함
- 큐가 사용되는 곳
  - Process Ready Queue, Task Queue 등 이름 그대로 대기열에 사용됨
  - Buffer
- 배열이나 링크드리스트로 구현될 수 있음



큐의 ADT

- `void QueueInit(Queue * pq);`
  - 큐의 초기화를 진행
  - 큐 생성 후 제일 먼저 호출되어야 함
- `int QIsEmpty(Queue * pq);`
  - 큐가 빈 경우 TRUE를, 아닌 경우 FALSE를 반환함
- `void Enqueue(Queue * pq, Data data);`
  - 큐에 데이터를 저장함
  - 매개변수 data로 전달된 값을 저장함
- `Data Dequeue(Queue * pq);`
  - 가장 먼저 저장된 데이터를 삭제함
  - 삭제한 데이터는 반환됨
  - 실행에 앞서 큐 안에 데이터가 있는지 validation을 거쳐야 함
- `Data QPeek(Queue * pq);`
  - 가장 먼저 저장된 데이터를 반환하되 삭제하지 않음
  - 실행에 앞서 큐 안에 데이터가 있는지 validation을 거쳐야 함



### 4.1. 배열로 구현



구현의 논리

- 스택과 마찬가지로 인덱스를 이동시키면서 데이터를 삽입-삭제함
- 삭제할 경우 **데이터를 한 칸씩 밀어줘야 함** : 비효율 발생
  - 큐의 입구와(rear) 출구에(front) 각각 포인터를 두어 데이터를 밀지 않고도 삭제 가능하도록 함
  - 단, 삭제가 계속 일어나면 **데이터가 뒤에만 쌓임**
    - 입구를 배열의 앞으로 이동시켜서 해결 : **원형 큐**의 도입



원형 큐란?

- **front, rear**를 도입하여 논리적으로 첫 번째, 마지막 요소를 식별하고 이 변수들만 변경해주는 방식
  - 이 때 큐가 꽉 찬 상태와 비어있는 상태를 식별할 수 없다는 문제가 발생함
    - 삽입 후 r을, 삭제 후 f를 오른쪽으로 이동시키면 full과 empty인 경우 r-f위치 관계가 동일함
  - 해결방안1) 큐의 원소 갯수를 나타내는 변수를 도입
  - 해결방안2) 큐를 꽉 채우지 않고 한 칸을 남김
    - 삽입 시 데이터를 넣은 후 r을 이동시키는 것이 아니라 이동시킨 후에 삽입함
    - empty일 때는 r,f가 동일한 위치, full일 때는 r의 바로 오른쪽에 f가 오게 됨
- 링 버퍼는 **오래된 데이터를 버리는 데 사용**될 수 있음: 가장 최근에 들어온 데이터 n개만 저장함



원형 큐 구현하기

- 큐 구조체

  - 실제로 데이터가 저장되는 배열과 입/출구를 나타내는 인덱스 rear/front를 선언

  - ```c
    typedef struct __cQueue{
        int front;
        int rear;
        Data queArr[QUE_LEN];
    } cQueue;
    ```

- 초기화

  - 텅 빈 경우 front와 rear는 동일한 위치를 가리킴

  - ```c
    void QueueInit(Queue * pq){
        pq->front = 0;
        pq->rear = 0;
    }
    ```

- IsEmpty

  - 여기에서는 해결방안2를 선택하여 front와 rear가 동일한 위치일 때 비었다고 함

  - ```c
    int QIsEmpty(Queue * pq){
        return pq->front == pq->rear;
    }
    ```

- NextPosIdx

  - 큐의 다음 위치에 해당하는 배열의 인덱스 값을 반환함

  - F와 R이 회전할 수 있도록 하는 함수

  - ```c
    int NextPosIdx(int pos){
        if(pos == QUE_LEN-1)	// 인덱스가 배열의 마지막에 도달하면
            return 0;			// 처음으로 돌림
        else
            return pos+1;
    }
    ```

  - 나머지 연산을 활용할 수도 있으나 여기서는 그냥 맨 앞으로 돌리는 것으로 함

- Enqueue

  - 배열은 **길이 제한이 있기 때문에 큐가 가득 찼는지 확인**해야 함

  - rear를 오른쪽으로 한 칸 이동시킨 후 데이터를 삽입

  - ```c
    void Enqueue(Queue * pq, Data data){
        if(NextPosIdx(pq->rear) == pq->front){		// r의 바로 오른쪽에 f가 온다면
            ...										// 에러 메세지 반환
        }
        
        pq->rear = NextPosIdx(pq->rear);
        pq->queArr[pq->rear] = data;
    }
    ```

- Dequeue

  - 큐가 비었는지 확인

  - 비어있지 않다면 front를 오른쪽으로 이동시킨 후 front에서 데이터를 꺼냄

  - ```c
    Data Dequeue(Queue * pq){
        if(QIsEmpty(pq)){...}		// 에러 메세지 반환
        
        pq->front = NextPosIdx(pq->front);
        return pq->queArr[pq->front];
    }
    ```

- Peek

  - ```c
    Data QPeek(Queue * pq){
        if(QIsEmpty(pq)){...}		// 에러 메세지 반환
        
        return pq->queArr[NextPosIdx(pq->front)];
    }
    ```



### 4.2. 연결리스트로 구현



구현의 논리

- 연결리스트에서도 마찬가지로 데이터가 나오는 곳(front)과 들어가는 곳(rear)을 분리해야 함
  - 단 연결리스트이므로 각각은 노드를 가리키게 됨



큐 구현하기

- 큐 구조체와 노드 구조체
  - 실제로 데이터가 저장되는 노드(생략)와 입/출구를 나타내는 노드 rear/front를 선언

  - ```c
    typedef struct __lQueue{
        Node * front;
        Node * rear;
    } LQueue;
    ```

- 초기화

  - 텅 빈 경우 front와 rear는 아무 것도 가리키지 않음

  - ```c
    void QueueInit(Queue * pq){
        pq->front = NULL;
        pq->rear = NULL;
    }
    ```

- IsEmpty

  - **front에 NULL이 저장된 경우 비었다**고 판단함

    - 빼낼 수 있는 node가 없다는 뜻이기 때문 : rear는 신경쓰지 않아도 됨

  - ```c
    int QIsEmpty(Queue * pq){
        return pq->front == NULL;
    }
    ```

- Enqueue

  - 노드를 추가한 이후 rear가 새로 추가한 노드를 가리키도록 함

  - ```c
    void Enqueue(Queue * pq, Data data){
    	Node * newNode = (Node*)malloc(sizeOf(Node));
        newNode->data = data;
        
        if(QIsEmpty(pq)){				// 첫 번째로 추가하는 노드라면
            pq->front = newNode;		// head도 새로 추가하는 노드를 가리켜야 함
            pq->rear = newNode;
        }
        else{							// 두 번째 이후라면
            pq->rear->next = newNode;	// 마지막 노드가 새로 추가하는 노드를 가리킴
            pq->rear = newNode;
        }
    }
    ```

- Dequeue

  - 큐가 비었는지 확인

  - 비어있지 않다면 front는 선두 노드의 다음 노드를 가리키도록 함

    - 노드가 하나만 남은 상황에서 삭제하면 rear는 쓰레기 값을 가리키게 됨
    - 그러나 비었는지 확인할 때 front만을 체크하기 때문에 rear는 신경 쓰지 않아도 됨

  - ```c
    Data Dequeue(Queue * pq){
        Node * delNode;
        Data retData;
        
        if(QIsEmpty(pq)){...}		// 에러 메세지 반환
        
        delNode = pq->front;
        retData = delNode->data;
        pq->front = pq->front->next;
    	
        free(delNode);
        return retData;
    }
    ```

- Peek

  - ```c
    Data QPeek(Queue * pq){
        if(QIsEmpty(pq)){...}		// 에러 메세지 반환
        
        return pq->front->data;
    }
    ```



### 4.3. Dequeue

> 앞뒤로 모두 삽입과 삭제가 가능한 큐



덱의 ADT

- `void DequeInit(Queue * pq);`
  - 덱의 초기화를 진행
  - 큐 생성 후 제일 먼저 호출되어야 함
- `int DQIsEmpty(Queue * pq);`
  - 덱이 빈 경우 TRUE를, 아닌 경우 FALSE를 반환함
  - 큐와 마찬가지로 head가 NULL이면 비었다고 판단함
- `void DQAddFirst(Queue * pq, Data data);`
  - 덱의 머리에 데이터를 저장함
  - 매개변수 data로 전달된 값을 저장함
- `void DQAddLast(Queue * pq, Data data);`
  - 덱의 꼬리에 데이터를 저장함
  - 매개변수 data로 전달된 값을 저장함
- `Data DQRemoveFirst(Queue * pq);`
  - 덱의 머리에 위치한 데이터를 반환하고 소멸시킴
  - 실행에 앞서 덱 안에 데이터가 있는지 validation을 거쳐야 함
- `Data DQRemoveLast(Queue * pq);`
  - 덱의 꼬리에 위치한 데이터를 반환하고 소멸시킴
  - 실행에 앞서 덱 안에 데이터가 있는지 validation을 거쳐야 함
- `Data DQGetFirst(Queue * pq);`
  - 덱의 머리에 위치한 데이터를 반환하되 삭제하지 않음
  - 실행에 앞서 큐 안에 데이터가 있는지 validation을 거쳐야 함
- `Data DQGetLast(Queue * pq);`
  - 덱의 꼬리에 위치한 데이터를 반환하되 삭제하지 않음
  - 실행에 앞서 큐 안에 데이터가 있는지 validation을 거쳐야 함



덱의 구현

- Doubly Linked List를 이용하여 구현할 수 있음
- 실제 구현은 생략
- 주의할 점
  - Queue와는 다르게 노드를 **삭제할 때 rear에도 NULL처리를 해줘야 함** : 뒤로 출입이 가능하기 때문



## **5. Set**



집합이란?

- 어떤 조건을 만족하는 자료의 모임
- 이 자료를 원소(element)라 하고 원소의 **중복은 허용되지 않음**
- 두 집합 X, Y가 같은 원소로 구성될 때 X와 Y는 서로 같다고 함



배열로 집합 구현하기

- 모든 원소가 같은 자료형인 경우 배열로 표현 가능
- 초기화
  - 집합의 크기 max, 원소의 갯수 num, 집합을 가리키는 포인터 *set를 초기화
- IsMember
  - 배열에 원소가 들어있는지 확인하는 함수 : 선형 검색을 이용
  - 들어 있으면 인덱스를, 아니면 -1을 반환
- Add
  - 원소를 추가하는 함수 : `s->set[s->num++] = n;` 
  - IsMember로 해당 원소가 집합에 있는지 확인한 후 없는 경우에만 추가
- Remove
  - 삭제하려는 원소의 인덱스를 IsMember로 검색한 뒤 num을 1 감소시키고 마지막 원소를 대입함
- Assign
  - 한 집합을 다른 집합으로 복사
- Equal
  - 두 집합이 같은지 조사
  - 정렬되어 있지 않은 경우 O(n^2)로 완전 탐색해야 함
- Union
  - 합집합을 만드는 함수
  - 집합 s1을 s3에 Assign한 후 s2의 모든 원소를 s3에 Add함
- Intersection
  - 교집합을 만드는 함수
  - 집합 s1의 원소가 s2에 있다면(IsMember) s3에 추가
- Difference
  - 차집합을 만드는 함수
  - 집합 s1의 원소가 s2에 없다면 s3에 추가



비트 벡터로 집합 만들기

- 집합을 하나의 정수로 표현 : 정수의 n번째 bit가 1이면 n을 원소로 갖는 집합
- 비트 벡터 집합의 함수
  - Equal : `s1 == s2`
  - Intersection : `s1 & s2`
  - Union : `s1 | s2`
  - Difference : `s1 &~s2`



## **6. Tree**

> 사이클을 갖지 않는 그래프
>



트리란?

- **계층적 관계**(Hierarchical Relationship)을 **표현**하는 자료구조
  - 데이터의 저장-삭제보다 표현에 초점이 맞춰져 있음



트리의 성질

- 사이클이 없음
  - 트리는 부모가 자식을 가리키는 단방향 그래프로 사이클이 생길 수 없음
- 루트는 유일함
  - 부모 노드를 하나만 갖기 때문에 루트도 하나일 수밖에 없음
- 재귀적임
  - 트리의 자식은 트리임(**subtree**)
  - 큰 트리에 속하는 작은 트리를 서브 트리라 함



트리 용어

- Node: 트리의 구성 요소
  - 부모 노드: 어떤 노드 바로 위(root 방향)에 연결된 노드
  - 자식 노드: 어떤 노드 바로 아래에 연결된 노드
  - 형제 노드: 같은 부모노드를 갖는 자식 노드들
- Degree: 자식 노드의 갯수
  - Size: 자신을 포함한 **모든 자손 노드**의 갯수
- Height: 루트에서 가장 먼 리프 노드까지의 거리
  - Leaf: 자식 노드를 갖지 않는 노드(terminal node라고도 함)
  - internal node : 리프 노드가 아닌 노드(root 포함)
  - root: 부모 노드를 갖지 않는 노드
- Depth: 루트에서부터 현재 노드까지의 거리(height라고도 함)
  - Level: 루트에서부터 깊이 n만큼 떨어진 노드들을 level n 노드들이라고 함
  - root의 레벨은 0임



### 6.1. Binary Tree

> 모든 노드가 **최대 2개의 자식 노드**를 갖는 트리



이진트리의 조건

- 루트 노드를 중심으로 두 개의 서브 트리로 나뉘어짐
  - 노드가 없는 경우 공집합(empty set) 노드가 존재하는 것으로 간주할 수 있음
  - 그러니까 **2개 이하의 서브트리**를 가지면 되는 것
- 나뉘어진 두 트리도 모두 이진트리임



이진 트리의 유형

- Full Binary Tree
  - 모든 노드가 0개 또는 2개의 자식 노드를 갖는다
- Complete Binary Tree
  - 마지막 레벨을 제외하고 모든 레벨이 완전히 채워져 있음
  - 마지막 레벨의 노드들은 왼쪽부터 채워짐
  - **배열로 구현할 수 있음**
    - BFS를 하면서 각 노드에 순서대로 인덱스를 부여하면 됨
    - 인덱스 0는 빼고 `왼쪽 자식=부모*2`, `오른쪽 자식=부모*2+1` 인덱스 부여하면 됨
  - n개의 노드를 저장할 수 있는 완전이진트리의 높이는 logn임
- Perfect Binary Tree(Fully Complete Binary Tree)
  - 모든 노드는 2개의 자식 노드를 가짐
  - 모든 리프 노드가 동일한 높이를 가짐



이진 트리의 구현

- 배열 또는 연결리스트로 구현 가능
  - 배열 : **탐색이 빈번하게 이루어지는 경우**에 유리함
    - 완전 이진 트리의 일종인 heap이 일반적으로 배열로 구현됨
    - heap은 중요하기 때문에 [6.3.절](#6.3.-Heap)에서 따로 다룸
  - 연결리스트 : 구현이 간편함
    - 연결리스트의 구성 형태가 트리와 일치하기 때문
- ADT
  - `BTreeNode * MakeBTreeNode(void);`
    - 이진 트리 노드를 생성하여 주소값을 반환함
  - `BTData GetData(BTreeNode * bt);`
    - 노드에 저장된 데이터를 반환함
  - `void SetData(BTreeNode * bt, BTData data);`
    - 노드에 데이터를 저장함
    - data로 전달된 값을 저장함
  - `BTreeNode * GetLeftSubTree(BTreeNode * bt);`
    - 왼쪽 서브트리의 주소값을 반환함
  - `BTreeNode * GetRightSubTree(BTreeNode * bt);`
    - 오른쪽 서브트리의 주소값을 반환함
  - `void MakeLeftSubTree(BTree * main, BTreeNode * sub);`
    - 왼쪽 서브트리를 연결함
    - 이미 서브트리가 존재한다면 해당 트리를 삭제하고 새로운 서브트리를 연결함
  - `void MakeRightSubTree(BTree * main, BTreeNode * sub);`
    - 오른쪽 서브트리를 연결함
    - 이미 서브트리가 존재한다면 해당 트리를 삭제하고 새로운 서브트리를 연결함



트리 순회

- 트리 자료구조에서 **모든 노드를 한 번씩 방문**하는 것
- 순회 방식 
  - 이진 트리에서는 다음 3가지 방식으로 순회 가능
    - Pre-Order : **루트 방문** - 왼쪽 서브트리 - 오른쪽 서브트리
    - In-Order : 왼쪽 서브트리 - **루트 방문** - 오른쪽 서브트리
    - Post-Order : 왼쪽 서브트리 - 오른쪽 서브트리 - **루트 방문**
  - 순회 함수의 유일한 차이점은 루트 노드를 방문하는 코드가 삽입된 위치



#### 6.1.1. Expression Tree

> 이진 트리를 이용해서 수식을 표현해 놓은 것



수식 트리란?

- **컴파일러가 수식을 인식**할 수 있도록 **이진트리로 표현**한 것
  - 연산자를 담는 루트 노드와 피연산자를 담는 두 피연산자로 구성됨
  - 서브트리의 계산결과를 다시 하나의 피연산자로 치환하여 계산을 수행함
- 순회를 통해 전위/중위/후위 표기법의 수식으로 표현 가능
  - 각각의 순회 방법을 이용해 출력하면 해당 표기법의 수식이 반환됨
  - 수식트리를 중위순회하면 중위 표기법으로 출력 가능



수식 트리의 작성

- 후위 표기법으로 작성된 수식을 이용하여 만들 수 있음
- 피연산자와 연산자를 이용해 트리의 하단을 만들고, 이를 바탕으로 점진적으로 구성해 나감
  1. 피연산자를 스택으로 옮김
  2. 연산자가 등장하면 **스택에 있는 두 피연산자를 꺼내 연산자의 자식노드로 연결**
  3. 완성된 **서브트리를 다시 스택으로 옮김**
  4. 위 과정을 반복



수식 트리의 계산

- **재귀적으로 자식 노드의 피연산자를 연산**해 나감

- 피연산자는 각각의 서브트리의 연산 결과를 저장함

  - 탈출 조건 : 자식 노드가 리프 노드인 경우 해당 노드에 저장된 피연산자를 반환

  - ```c
    if(GetLeftSubTree(bt)==NULL && GetRightSubTree(bt)==NULL)
        return GetData(bt)
    ```



### 6.2. Binary Search Tree

> 정렬된 이진 트리



BST에 저장되는 데이터의 규칙

- 중복을 허용하지 않음 : 이진 탐색 트리에 저장된 key는 유일함
- 루트 노드의 키가 왼쪽 서브트리의 **어떠한 노드의 키보다 큼**
- 루트 노드의 키가 오른쪽 서브트리의 **어떠한 노드의 키보다 작음**
- 왼쪽과 오른쪽 서브트리도 이진 탐색 트리임



BST의 필요성

- 이름부터가 그렇지만 이진 탐색을 위해 고안됨
  - 균형이 완벽히 잡힌 perfect binary tree의 경우 시간 복잡도 O(log n)
  - 단 트리의 균형이 깨지면 최악의 경우 O(n)까지도 증가할 수 있음
  - **자가 균형 이진 탐색 트리**(Self-Balancing BST)가 필요!
    - AVL 트리, 레드-블랙 트리 등
- inorder traversal을 통해 자료를 정렬하여 출력 가능



노드의 삽입

- 삽입할 노드의 key와 기존 노드의 key를 비교하며 **비교 대상이 없을 때까지 내려감**
- 비교 대상이 없는 위치에(리프) 새로운 노드를 연결함
  - 해당 위치의 부모 노드의 key와 비교하여 크면 오른쪽에, 작으면 왼쪽에 삽입



노드의 삭제

- 삭제 후에도 BST가 유지되도록 **빈 자리를 채워야 함**
- 자식 노드가 0개인 경우
  - 자신을 가리키는 부모 노드의 포인터를 NULL로 변경
- 자식 노드가 1개인 경우
  - 자신을 가리키는 부모 노드의 포인터가 자신의 자식을 가리키도록 변경
- 자식 노드가 2개인 경우
  - 왼쪽 서브트리에서 가장 큰 값을 가진 노드 or 오른쪽 서브트리에서 가장 작은 값을 가진 노드를 찾음
  - 그 값을 복사하여 자신의 값을 변경한 후 **해당 노드를 삭제**
    - 다시 해당 노드의 자식 갯수를 따져서 삭제를 진행
- 루트 노드를 삭제하는 경우
  - 일관성을 확보하기 위해 가상의 부모노드를 두고 위 루틴을 처리하도록 하면 됨
    - "자신을 가리키는 부모 노드"가 있어야 하기 때문
  - 루트 노드가 삭제된 이후(free)에도 루트를 가리키는 포인터가 루트 노드를 가리켜야 함
    - **가상의 부모노드의 자식을 가리키게**끔 하면 됨



#### 6.2.1. AVL 트리

> 삽입/삭제를 할 때마다 균형이 안맞는 것을 맞추기 위해 트리의 일부를 왼쪽 혹은 오른쪽으로 회전시키는 BST



특징

- 모든 노드의 **Balance Factor**가 1이하가 되도록 유지함
  - Balance Factor = 왼쪽 서브 트리의 높이 - 오른쪽 서브 트리의 높이
  - 이를 유지하기 위해서 **회전**을 이용함
- RBT 대비 삽입과 삭제는 느리지만 탐색이 빠름



회전

- 삽입 or 삭제 동작 후 트리가 **AVL의 조건**(balance factor)을 만족하는지 확인
- 만족하지 않는다면 W로부터 root로 가는 경로상에 가장 처음으로 위치한 불균형한 노드 Z를 찾음
  - W는 삽입 or 삭제를 실시한 노드의 부모
- W-Z 경로 상에서 회전을 실시
  - 이 때 Z의 자식을 Y, 손자를 X라 할 때 X와 Y의 위치 관계에 따라 4가지 회전이 가능함
  - LL, LR, RL, RR



LL회전

![ll](https://www.codingeek.com/wp-content/uploads/2017/04/LL.png)

- W-Z경로 상에서 X, Y 둘 다 왼쪽에 위치한 경우
- 균형인수가 +2인 노드를(Z) 균형인수가 +1인 노드의(Y) 오른쪽 자식 노드가 되도록 함
  - 이 때 **Y노드에 오른쪽 서브트리가 존재한다면** 해당 서브트리는 **Z의 왼쪽 서브트리가 되도록 함**
  - 위 그림엔 안 나왔는데 루트가 25인 서브트리가 있다고 생각해보자
- 실행순서는 다음과 같음
  1. Y노드의 오른쪽 서브트리 R을 구함
  2. Z의 왼쪽 서브트리를 가리키는 포인터에 R의 루트를 할당
  3. Y의 오른쪽 서브트리를 가리키는 포인터에 Z를 할당



RR회전

![rr](https://www.codingeek.com/wp-content/uploads/2017/04/RR.png)

- W-Z경로 상에서 X, Y 둘 다 오른쪽에 위치한 경우
- LL과 정확히 반대로 해주면 됨 : Z를 Y의 왼쪽 자식 노드가 되도록 함
  1. Y의 왼쪽 서브트리 L을 구함
  2. Z의 오른쪽 서브트리를 가리키는 포인터에 L을 할당
  3. Y의 왼쪽 서브트리를 가리키는 포인터에 Z를 할당



LR회전(그림은 반대로 표기되어 있는데 신경쓰지 말자)

![lr](https://www.codingeek.com/wp-content/uploads/2017/05/RL.png)

- W-Z경로 상에서 Y가 왼쪽, X가 오른쪽에 위치한 경우
- Y에 대해 RR회전을 해준 다음 Z에 대해 LL회전을 해줌



RL회전

![rl](https://www.codingeek.com/wp-content/uploads/2017/05/LR.png)

- W-Z경로 상에서 Y가 오른쪽, X가 왼쪽에 위치한 경우
- Y에 대해 LL회전을 해준 다음 Z에 대해 RR회전을 해줌



#### 6.2.2. Red-Black Tree

> Java에서 내부적으로 BST를 구현하기 위해 사용되는 자료구조
>
> Depth를 최소화하여 탐색, 삽입, 삭제를 O(logn)에 끝내는 것을 목적으로 설계됨



![red-black](https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Red-black_tree_example.svg/500px-Red-black_tree_example.svg.png)

특징

- 각 노드는 레드 또는 블랙의 색상을 가지고 있고, 다음의 규칙을 따름
  - 루트 노드, 모든 리프 노드는 블랙
  - 루트에서 리프까지의 경로에 **레드 노드가 연속으로 올 수 없음**
    - 레드 노드의 자식은 모두 블랙
  - 루트에서 리프까지의 모든 경로에는 같은 수의 블랙 노드가 있음
  - 모든 노드는 자식이 없는 부분에 NIL이라는 가상적인 노드를 자식으로 갖는다고 가정함
    - NIL은 블랙
- 루트로부터 **가장 긴 경로가 가장 짧은 경로의 길이의 두 배를 넘지 않음**
  - 이를 roughly balanced하다고 함
  - 따라서 AVL이 더 탐색이 효율적이나 삽입 삭제 오버헤드는 RBT가 더 적음
    - 회전이 적음 : 밑에서 설명하는 경우4에 대해서만 회전 실시
- 삽입, 탐색, 삭제 모두 최악의 경우 O(log n)의 시간 복잡도를 가짐



노드 삽입

- BST에 새 노드를 삽입하는 것과 동일하게 하고 **새 노드 N을 레드로 함**
- 경우1) N이 루트인 경우
  
  - N을 블랙으로 바꿔줌
  
- 경우2) N의 부모 노드 P가 블랙인 경우

  - 모든 조건을 만족하므로 pass

- 경우3) N의 부모 노드 P가 레드고, 삼촌 노드 U가 레드

  - **색상을 변경**함
  - P와 U를 블랙으로 변경하고, 조부모 노드 G는 레드로 변경
  - G에서부터 다시 root방향으로 거슬러 올라가며 규칙이 맞는지 살펴보고 1-3번 경우에 따라서 변경함

- 경우4)  N의 부모 노드 P가 레드고, P의 형제 노드 U가(삼촌 노드) 블랙

  - **회전을 수행**함

  - 경우 4-1) N이 오른쪽 자식임

    - P를 기준으로 왼쪽으로 회전 1회 실시하고 3-2를 수행함

    ![RBT4-1](https://upload.wikimedia.org/wikipedia/commons/5/56/Red-black_tree_insert_case_4.png)

  - 경우 4-2) N이 왼쪽 자식임

    - P를 블랙, G를 레드로 변경하고 (P가 G의 왼쪽 자식이라면) G에 대해 오른쪽으로 회전 1회 실시
    - P가 G의 오른쪽 자식이라면 왼쪽으로 회전 1회 실시
    - P는 블랙으로 G는 레드로 바꿔줌

    ![RBT4-2](https://upload.wikimedia.org/wikipedia/commons/6/66/Red-black_tree_insert_case_5.png)



노드 삭제

- 삭제는 최대 한 개의 non-leaf 자식을 갖고 있는 노드를 삭제하는 문제로 치환할 수 있음
  - 이진 탐색 트리에서 삭제를 수행할 때에는 왼쪽 서브트리에서의 최댓값이나, 오른쪽 서브트리에서의 최솟값을 삭제한 노드의 위치에 삽입하기 때문
- 삭제할 노드 M에 대해 non-leaf 자식 혹은 NIL 중 하나를 C라고 하면 다음과 같이 경우를 나눌 수 있음
- 경우1) M이 레드
  - M을 C로 치환하면 종료
- 경우2) M이 블랙, C가 레드
  - M을 C로 치환하고 C를 블랙으로 변경
- 경우3) M,C 모두 블랙
  - M을 그냥 삭제하면 "모든 경로에는 같은 수의 블랙 노드가 있음"을 위반하게 됨
  - 경우의 수를 나누어서 삭제를 실시 : [참고](https://itstory.tk/entry/%EB%A0%88%EB%93%9C%EB%B8%94%EB%9E%99-%ED%8A%B8%EB%A6%ACRed-black-tree)



### 6.3. Heap

> **힙의 특성**을 만족하는 완전 이진트리(Complete Binary Tree)



힙이란?

- 부모가 항상 자식보다 같거나 작음(최소힙) or 부모가 항상 자식보다 크거나 같음(최대힙)
  - 이것을 힙의 특성이라고 함
  - 이 특성을 이용하여 **우선순위 큐**를 구현하는 데 활용할 수 있음
- 우선순위 큐
  - 들어간 순서에 상관없이 우선순위가 높은 데이터가 먼저 나오는 큐
  - **힙의 루트를 출구**로 하면 항상 우선순위가 높은 데이터가 먼저 나올 수 있음
    - 일반적으로 힙으로 구현됨
    - 배열이나 링크드리스트로 구현도 가능하나 삽입의 오버헤드가 커서 잘 사용되지 않음
    - 힙의 Insert, Delete 함수의 호출결과는 우선순위 큐의 enqueue, dequeue와 일치함



힙의 구현

- **배열에 기반**한 Complete Binary Tree로 구현할 수 있음
  - 연결 리스트 기반으로 구현하면 새로운 노드를 힙의 **마지막 위치**에 추가하는 것이 어려움
    - 마지막 원소 : 완전 이진 트리에서 마지막 레벨의 가장 오른쪽에 위치한 노드
    - 배열이라면 **인덱스의 계산**을 통해 알 수 있으나 연결 리스트는 탐색을 거쳐야 함
- 데이터 삽입과 추출 시 힙의 구조를 유지해야 함 : **heapify**
  - 삽입 : 배열 마지막에 원소를 추가하고 부모와 값을 비교하면서 위치를 바꿈
  - 추출 : 루트 노드를 삭제하고 **마지막 원소**를 루트에 추가한 뒤 자식 노드와 값을 비교하며 위치를 바꿈
  - 데이터 삽입과 추출에 O(logn)이 소요됨을 알 수 있음
- 배열로 힙 구현하기
  - 노드에 번호를 부여하여 해당 번호를 인덱스 값으로 이용함
  - 0번은 비우고, 왼쪽 자식은 부모 인덱스x2, 오른쪽 자식은 부모 인덱스x2+1을 인덱스로 가짐
    - 저장된 노드의 갯수와 마지막 노드의 고유번호가 일치함



이진 힙 vs 이진 탐색 트리

- 힙은 상하관계를 보장함
  - 부모는 자식보다 작고 **왼쪽 오른쪽은 상관 없음**
- BST는 좌우 관계를 보장함
  - 부모는 왼쪽 자식보다는 크고 오른쪽 자식보다는 작다



문제풀이에서의 힙

- 정렬되지 않은 배열에서 k번째로 큰 값을 추출하는 경우 [LeetCode 215](https://leetcode.com/problems/kth-largest-element-in-an-array/)
  - 추가, 삭제가 빈번할 때는 힙을 사용하는 것이 좋음
  - 값이 고정된 경우에는 그냥 정렬해서 k번째를 추출



### 6.4. Trie

> 문자열 탐색을 위한 자료구조로 m-ary Tree의 형태를 띔

![Trie](https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Trie_example.svg/1200px-Trie_example.svg.png)

특징

- 공간을 많이 사용하는 대신, 그 문자열의 길이의 속도만큼 초고속 탐색이 가능
  - 문자열 길이 m에 대해 O(m)의 탐색 속도를 보임
  - 가장 효율적인 문자열 검색법임 : 정렬해두고 이진탐색을 하면 정렬에 O(nmlogn)이 걸림..
- K진 트리임
  - K는 문자 종류의 수 : 알파벳의 경우 K=26



### 6.5. B-Tree

> 자식 노드의 개수가 **2개 이상**인 트리
>
> leaf node의 깊이가 모두 동일하도록 균형이 잡혀 있음



노드 내의 데이터가 복수일 수 있으며 최대 데이터 수 m에 대해 m차 B-Tree라고 말함

- 노드 내의 **데이터는 정렬되어 있어야 함**
  - inorder traversal로 출력할 때 순차적으로 나옴
- 노드의 데이터 수가 n개라면 자식 노드의 개수는 n+1개여야 함
- 모든 노드는 적어도 m//2개의 데이터를 갖고 있어야 함
- **leaf노드는 모두 같은 레벨**에 있어야 함



#### 6.5.1. B+Tree

데이터의 빠른 접근을 위한 인덱스 역할만 하는 비단말 노드(not Leaf)가 추가로 있음





![b+tree](./img/b+tree.png)



B+Tree의 특징

- 데이터는 리프 노드에만 담김
  - 브랜치에는 키만 담기기 때문에 메모리를 확보하여 더 많은 키를 담을 수 있음
    - 키는 양쪽 포인터가 가리키는 자식 노드의 키 사이의 값을 가짐
  - **트리의 높이가 낮아지는 효과** 있음 : Cache hit를 높일 수 있음
- 모든 리프의 높이가 동일하고, B-Tree와 마찬가지로 At least half full임
  - 루트 노드를 제외한 각 노드는 적어도 n//2개의 데이터를 갖고 있어야 함
  - n은 노드 내 포인터의 갯수
- Leaf Block 간에 양방향 링크가 있어 내림차순, 오름차순 검색이 용이함
  - full scan 시 리프 노드만 선형탐색하면 되므로 B-Tree보다 빠르게 탐색 가능
  - **노드에 있는 데이터들은 정렬되어있음**(물론 포인터 말고 key가)



장단점

- B+ Tree는 장점이 단점을 상쇄하고도 남기 때문에 DB 인덱스로써 아주 잘 사용되고 있음
- 장점
  - 데이터의 삽입-삭제가 일어날 때 자동적으로 reorganize함
  - 어떤 값을 탐색하더라도 시간이 보장됨
- 단점
  - 데이터 삽입-삭제시 약간의 오버헤드가 있음
  - 트리 구조이고, at least half full이기 때문에 공간 낭비가 약간 있음



## **7. 해시**

> 해싱을 이용하여 데이터를 저장하는 자료구조



해싱이란?

- 데이터를 저장할 위치(인덱스)를 **간단한 연산**으로 구하는 것
  - 이 때 사용되는 함수를 해시 함수라고 함
  - 해시 함수는 Key를 고정된 크기 값으로 변환해 줌
- 이렇게 구한 인덱스로 해시 테이블 or 해시 맵에 자료를 저장



해시 함수의 성능 기준

- 함수 값의 **충돌이 최소화**되는지?
- 연산이 빠른지?
  - 충돌의 최소화와 빠른 연산은 trade-off 관계를 가짐
- 해시 값이 균일하게 분포되는지?
- 사용할 키의 *모든 정보*를 이용하여 해싱하는지?



해싱 알고리즘

- Modulo-Division Method

  - `h(x) = x mod m`

  - x는 입력값을 연산하여 랜덤하게 만든 키 값, m은 해시 테이블의 크기

  - 입력값은 다음과 같은 방식으로 랜덤하게 만들어 줌

  - ```C
    unsigned hash(char* s){
        unsigned hashval;
        
        for (hashval = 0; *s != '\0'; s++)
            hashval = *s + 31 * hashval;
        return hashval % HASHSIZE;
    }
    ```

    - 문자열의 각 자릿수를 계수로 갖는 31의 power series로 x를 표현하여 랜덤하게 만들었음



### 6.1. 해시 함수의 충돌



충돌이란?

- 서로 다른 객체 X와 Y에 대해 해시함수 연산 결과가 동일한 것
  - cf) perfect hash function : X.hashCode() = Y.hashCode() 이면  X.equals(Y)는 참
- 컨테이너의 수보다 아이템이 많은 경우, 비둘기집의 원리에 의해 충돌은 반드시 발생함
  - 확률적으로 컨테이너의 수보다 아이템이 훨씬 적어도 충돌은 발생함
  - **Birthday Problem**: 23명만 모여도 생일이 같은 사람이 존재할 확률 50%, 57명인 경우엔 99% 이상
- 충돌을 막기 위해서 **로드 팩터**를 모니터링 함
  - load factor = n/k (테이블에 저장된 갯수 / 버킷의 갯수)
  - 로드 팩터 값에 따라 함수를 재작성하거나 테이블의 크기를 조정함
  - 자바10의 경우 로드 팩터가 0.75를 넘어가면 테이블의 공간을 **리사이징** 함
- 충돌이 발생하는 경우 다음 방법을 이용하여 해결
  - **개별 체이닝**
  - **오픈 어드레싱**
  - 리사이징



개별 체이닝

- 충돌 발생 시 같은 해시 값의 데이터들을 **연결 리스트로 연결**하는 방법
  - open hashing이라고도 함
  - 트리로 연결할 수도 있는데 이건 하나의 버킷에 데이터가 많이 들어오는 경우에 그렇게 함
    - Java 8 HashMap에서는 하나의 해시 버킷에 8개의 키-값 쌍이 모이면 트리로 변경함
- 시간 복잡도
  - 잘 구현되면 O(1), 최악의 경우 O(n): 모든 해시 충돌이 발생할 경우
- **해시 테이블** 구조의 원형임



오픈 어드레싱

- 충돌 발생 시 빈 공간을 탐색(**rehashing**)하여 다른 버킷에 저장함
  - closed hashing이라고도 함
  - 재해시할 때 해시 함수는 자유롭게 선택 가능
    - linear probing : 한 칸씩 옮기는 방법, 대표적인 rehashing
    - Quadratic probing : 2차 함수를 이용
    - Double hashing probing : 다른 해시 함수를 이용해 새로운 주소를 할당. 많은 연산량을 요구함
- 장점
  - 구현이 간단하고 성능이 괜찮음
- 단점
  - **클러스터링** 발생: 선형 탐색의 경우 충돌한 곳 바로 다음에 저장되기 때문
    - 그렇기 때문에 캐시 효율이 좋기도 함
  - 버킷 사이즈보다 데이터가 많이 들어오면 삽입 불가
    - 로드 팩터를 넘으면 **Growth Factor** 비율에 따라 더 큰 크기의 버킷을 생성하여 리해싱 실시
- 체이닝과 비교
  - 낮은 로드팩터에서는 성능이 좋으나 높은 로드팩터에서 급격한 성능저하 발생
  - Ruby, Python의 해시 테이블은 오픈 어드레싱 방식을 택하되 로드 팩터를 적게 잡아 이를 해결함



### 6.2. Hash Table

> 해시 값이 인덱스가 되도록 원래의 키 값을 저장한 **배열**



기본 원리: 개별 체이닝과 같음

1. 키의 해시 값을 계산함
2. 해시 값을 이용해 배열의 인덱스를 구함
3. 같은 인덱스가 있다면 연결 리스트로 연결



해시 테이블의 구현

- 테이블의 각 요소를 버킷이라고 함
  - 각 버킷에 저장하는 값은 해당 인덱스를 해시 값으로 하는 연결 리스트의 head를 가리키는 포인터
  - 데이터가 없는 버킷에는 NULL 포인터가 저장됨



사용 예

- 파이썬의 딕셔너리는 오픈 어드레싱 방식의 해시 테이블로 구현됨



### 6.3. Hash Set



중복을 제거하기 위한 Set 인터페이스를 상속받는 것 외에는 특별히 없음



### 6.4. Hash Map



해시맵이란?

- 해시 함수를 이용하여 key, value pair를 저장하는 자료구조
  - 해시맵은 key로 인덱스를 얻고, 해당 버킷에는 value를 저장함 
  - 해시 테이블은 value를 해시 함수에 넣어 인덱스를 얻어 저장
    - 자바에서는 해시 테이블도 key, value pair를 저장함 : **동기화 지원 여부**만 다름
    - 해시맵은 동기화 지원하지 않음



보조 해시 함수(Additional Hash Function)를 사용함

- HashTable에 비하여 해시 충돌(hash collision)이 덜 발생할 수 있어 상대으로 성능상 이점이 있음
- 사용하는 이유
  - 해시 값을 2의 승수로 나누면 해시 충돌이 쉽게 발생할 수 있기 때문
  - `index = X.hashCode() % M`을 계산할 때 X.hashCode()의 하위 a개의 비트만 사용하게 됨
    - 해시 버킷의 개수 M이 `2**a` 형태가 되기 때문