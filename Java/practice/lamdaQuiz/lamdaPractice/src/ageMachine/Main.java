package ageMachine;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args){
        System.out.println("나이를 입력하세요");
        Scanner sc = new Scanner(System.in);
        int ageInput = sc.nextInt();
        Function<Integer, String> ageMachine = i -> "나이는 "+ i +"입니다. ";
        System.out.println(ageMachine.apply(ageInput));

        Predicate<Integer> isAdult = i -> i>18;
        System.out.println(isAdult.test(ageInput));

        System.out.println("이름을 입력하세요");
        sc = new Scanner(System.in);
        String nameInput = sc.nextLine();
        Consumer<String> namePrinter = i -> System.out.println("이름 : "+nameInput);
        namePrinter.accept(nameInput);

        Supplier<Integer> defaultAge = () -> 20;
        System.out.println("기본 나이: " + defaultAge.get());


    }
}
