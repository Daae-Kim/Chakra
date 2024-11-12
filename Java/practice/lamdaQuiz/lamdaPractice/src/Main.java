import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int first_input = Input();
        int second_input = Input();

        calculator add = (a,b) -> a+b;
        System.out.println("덧셈결과 : "+add.calc(first_input,second_input));

        calculator sub = (a,b) -> a-b;
        System.out.println("뺄셈결과 : " + sub.calc(first_input,second_input));

    }

    static int Input(){
        System.out.println("정수를 입력하세요");
        Scanner sc = new Scanner(System.in);
        int inputNum = Integer.parseInt(sc.nextLine());
        return inputNum;
    }






}