## 문제가 무엇인가?
flatMap()과 map()의 차이점은 무엇이고, "스트림 평면화"는 정확히 무엇을 말하는걸까?

## 왜 이런 문제를 선정하였는가?
stream 중간연산자 map, flatMap에 대해 읽었을때, stream 요소들의 반환 자료형을 바꾸기 위해 flatMap을 사용하는 부분이 있었는데 이해가 잘 되지 않아 추가적인공부가 필요했고 해당내용을 공유해보고자 문제로 선정하였습니다.

## 자신이 생각한 답변은 무엇인가?
### 스트림 평면화의 의미
- 스트림 평면화는 스트림 내부 요소에 대해 모든 원소를 단일 원소 스트림으로 반환해 주는 것을 말한다.
- Array나 Object로 감싸져 있는 모든 원소를 가장 작은 단위 스트림으로 반환해준다.

### flatMap()과 map()의 차이점
- map 은 단일 스트림 원소를 매핑시키고, 매핑된 값을 다시 스트림으로 반환한다.
- flatMap은 현재 스트림 요소를 단일 원소 스트림으로 반환해준다. (2차원 배열 -> 1차원 배열)

#### map() 의 반환형
``` java
List<Person> sample = Arrays.asList(
  new Person(00, "kim");
  new Person(01, "lee");
  new Person(02, "park");
);
```
이 있을때, 

``` java
Stream<String> mapStream = sample.stream().map(person -> person.getName());

mapStream.forEach(System.out::println); // kim, lee, park 출력
```
여기서 map 연산의 결과는 List의 Stream<person>을 받아 map 을 수행하고 **Stream<String>형**을 반환한다.

#### flatMap() 의 반환형
``` java
String[][] sample = new String[][]{
  {"a", "b"}, {"c", "d"}, {"e", "a"}, {"a", "h"}, {"i", "j"}
};

Stream<String> stream = sample.stream()
  .flatMap(array -> Arrays.stream(array))
  .filter(x-> "a".equals(x));

stream.forEach(System.out::print); // a a a 출력
```
.flatMap을 사용해서 2차원 배열을 1차원 배열로 반환하고, 이 배열들 중 a를 찾아 결과로 반환한다.

``` {"a", "b"}, {"c", "d"}, {"e", "a"}, {"a", "h"}, {"i", "j"} -> { "a", "b", "c", "d", "e", "a", "a", "h", "i",  "j"} -> (filter 연산) a a a 출력 ```

이렇게 flatMap은 스트림의 각 값을 다른 스트림으로 만든 후 모든 스트림을 **하나의 스트림으로 연결**하는 기능을 수행한다. 