### 스트림이란?

나는 기존에 for문을 자주 써왔다. for 문은 작성자외에 다른 사람이 보기에 한눈에 어떤 동작을 하는지 알아보기가 어렵다는 단점과 재사용성이 떨어진다는 단점이 있는데,

책에서 말하는 가장 큰 단점은 데이터 소스마다 다른 방식으로 다뤄야 한다는것이다. (자료형이 바뀔때마다 또다른 방식을 써야한다는 것이다. → ex) Collections.sort() , Array.sort()

이러한 문제를 해결하기 위해 만들어진것이 스트림 Stream 이다.

스트림은 데이터 소스가 무엇이던 간에 같은 방식으로 다룰 수 있게한다.

```java
Stream<String> strStream1 = strList.stream();
Stream<String> strStream2 = Arrays.stream(strArr);
```

### 스트림의 특징

1. 스트림은 데이터 소스를 변경하지 않는다.
    - 스트림은 소스로부터 데이터를 읽기만할 뿐, 데이터 소스를 변경하지 않는다.
2. 스트림은 일회용이다.
    - 스트림은 한번 사용하면 닫혀서 다시 사용할 수 없다. 필요하다면 재생성해야한다.
3. 스트림은 작업을 내부 반복으로 처리한다.
    - 내부 반복 : 반복문을 메서드의 내부에 숨긴것의 의미한다.
    - 스트림을 이용한 작업이 간결할 수 있는 비결중 하나가 내부 반복이다.
    - ex) for 문을 내부로 숨기고 있는 forEach()
4. 지연된 연산
    - 최종 연산이 수행되기 전까지는 중간 연산이 수행되지 않는다.
    - 최종연산이 수행되어야 비로소 스트림의 요소들이 중간연산을 거쳐 최종 연산에서 소모된다.
5. 데이터 소스의 요소를 기본형으로 다루는 스트림
    - 스트림은 기본적으로 Stream<T>  : 기본 타입이 T로, 딱히 정해져있지 않은 타입이지만,
    - 오토박싱&언박싱으로 인한 비효율을 줄이기 위해 기본형이 있다.
    - IntStream, LongStream, DoubleStream
6. 병렬 스트림
    - 스트림은 병렬처리가 쉽다.
    - Parallel() 메소드 호출, 끝!
    - 기본연산은 Sequential()이며, 병렬해제시 이를 호출하면 된다.

### 스트림을 만드는 5가지 방법, (스트림의 소스가 될 수 있는 대상)

1. 컬렉션
2. 배열
3. 임의의 수
4. 특정범위의 정수
5. 람다식 Iterate(), generate()
6. 파일과 빈 스트림

### 스트림의 연산

- 스트림이 제공하는 연산은 중간연산과 최종 연산으로 분류할 수 있다.
- 중간연산은 연산결과를 스트림으로 반환하기 때문에 중간연산을 연속해서 연결할 수 있다.
- 반면 최종연산은 스트림의 요소를 소모하면서 연산을 수행하므로 단 한번만 연산이 가능하다.

### 스트림의 중간 연산자

- concat() 두 스트림을 연결 (단, 각 스트림의 요소는 같은 타입이어야 한다.)

    ```java
    Stream.concat(strs1, strs2);
    ```

- 스트림 자르기 - skip(), limit()

    ```java
    IntStream intStream = IntStream.rangeClosed(1,10);
    intStream.skip(3).limit(5).forEach(System.out.print);
    ```

- 요소 걸러내기 - filter(), distinct()
   - distinct : 중복 제거
   - filter : 조건에 맞지 않는 요소 걸러냄

    ```java
    IntStream intStream = IntStream.rangeClosed(1,10);
    intStream.filter(i -> i%2 ==0 ).forEach(System.out.print);
    ```

- 정렬하기 - sorted()
- 변환 - map()
   - Stream<R> map(Function<? super T,? extends R> mapper)
- 조회 - peek()
   - 스트림의 요소를 소모하지 않는 연산이다.
   - 연산과 연산 사이에 올바르게 처리되었는지 확인하는 용도.
   - peek(s → System.out.printf(”filename = %s%n”,s))
   - filter()나 map()의 결과를 확인할 때 유용하게 사용될 수 있다.
- 기본형 스트림
   - 숫자를 다루는 편리한 메소드 제공 : sum(), max(), min()
   - → 최종 연산에 해당하기 때문에 연속해서 사용할 수는 없음.
- CharSequence 에 정의된 char()
   - IntStream charStream = “12345”.chars();
   - int charSum = charStream.map(ch → ch-’0’).sum(); // charSum = 15