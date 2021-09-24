import java.util.Objects;
import java.util.Scanner;

public class Calc {
    static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args) {
        System.out.println("Введите выражение через пробел: ");
        double x = Double.parseDouble(scanner.next());
        char operation = scanner.next().charAt(0);
        double y = Double.parseDouble(scanner.next());
        double result = calc(x, y, operation);
        String str = scanner.nextLine();
        if (Objects.equals(str, "")) {
            System.out.println("Результат операции: " + result);
        } else {
            System.out.println("Введено неверное выражение! ");
        }
    }

    public static double calc (double x, double y, char operation){
    double result = 0;
    switch (operation){
        case '+':
            result = x + y;
            break;
        case '-':
            result = x - y;
            break;
        case '*':
            result = x * y;
            break;
        case '/':
            if (y == 0)
                System.out.println("NaN");
            else
            result = x / y;
            break;
        default:
            System.out.println("Введены не верные данные!");
        }
        return result;
    }
}
