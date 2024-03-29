# 🚀 4단계 - 사다리(리팩토링)
## 기능 요구사항
* 기능 요구사항 3단계와 같다.
* 추가로 제공되는 객체 설계 힌트를 참고해 철저하게 TDD로 재구현해 본다.
## 실행 결과
* 위 요구사항에 따라 4명의 사람을 위한 5개 높이 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.
```java
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
꽝,5000,꽝,3000

최대 사다리 높이는 몇 개인가요?
5

사다리 결과

pobi  honux crong   jk
|-----|     |-----|
|     |-----|     |
|-----|     |     |
|     |-----|     |
|-----|     |-----|
꽝    5000  꽝    3000

결과를 보고 싶은 사람은?
pobi

실행 결과
꽝

결과를 보고 싶은 사람은?
all

실행 결과
pobi : 꽝
honux : 3000
crong : 꽝
jk : 5000
```
   
## 기능 구현 목록   
* [O] `,`를 기준으로 참가자가 생성된다.
* [O] 참가자는 이름을 가진다.
    * 이 과정에서 이름 5글자 이상이면 안 된다.
    * 이부분은 참가자 안에 Name 클래스 만들지 생각
* [O] 사다리 타기의 라인이 겹치면 안 된다.
* [O] 사다리는 랜덤하게 생성되므로 이부분을 추상화시킨다.
* [O] 실행 결과 입력 받기
* [O] 결과를 보고 싶은 사람 이름 입력
    * []`all`을 사람 이름으로 받으면 안 된다. -> 예외처리 추가해야한다.
    * [] 입력한 사람의 이름이 없을 경우 예외처리 -> 재귀호출로 다시 받기
* [O] 입력한 사람의 이름이나 명령어로 실행 결과를 출력한다.
* [O] all 입력 할 때 까지 위 동작들 반복
* [O] all 입력시 전체 출력 및 종료    
