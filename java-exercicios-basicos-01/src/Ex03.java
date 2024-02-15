import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int idade = scanner.nextInt();
        String response = "Outras combinações";
        if (idade > 20) {
            response = "Idade maior que 20";
        } else if (idade > 12 && idade < 17) {
            response = "Idade maior que 12 e menor que 17";
        } else if (idade == 7 || idade < 5) {
            response = "Idade igual a 7 OU menor que 5";
        }
        System.out.println(response);
    }
}
