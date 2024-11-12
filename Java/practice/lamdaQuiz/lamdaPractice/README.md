### 람다와 함수형 인터페이스
1. 람다식에서 함수형 인터페이스를 사용해야하는 이유
- 람다식은 익명함수(이름이 없는 함수)를 표현한 간결한 문법이다.
- 람다식은 함수를 일급객체로 취급하여 다른 함수의 인자로 전달하거나, 함수에서 반환값으로 사용할 수 있다.
- 즉 람다식을 사용하므로써 함수를 일급 객체로 다룰 수 있게되는것이다.(인자로 함수를 넘기거나, 반환값으로 함수를 사용하는 것)
- 
2. 함수형 인터페이스를 만들고 호출하여 사용하기
   - 함수형 인터페이스는 추상메서드를 단 하나만 가지고 있는 인터페이스를 말한다.
   - 람다식은 익명객체인데, 이 객체에 접근하여 메소드를 실행시키기위해 함수형 인터페이스를 사용하게되었다.
```java
@FunctionalInterface
interface Greeting{
    void sayHi(String name);
}

public class FunctionalIterfaceExample{
    public static void main(String[] args){
        Greeting greeting = name -> System.out.println("Hi"+name+"!");
        greeting.sayHi("kim");
    }
}
```

3. 기본 함수형 인터페이스
- Runnable
- Callable
- Comparator
- Predicate
- Function
- Consumer
- Supplier