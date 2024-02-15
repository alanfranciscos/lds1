import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        // obter o valor de um produto, sendo que o mesmo deve ter até 02 casas decimais. (Digite o valor do produto: xx.xx)
        Scanner scanner = new Scanner(System.in);
        double value = scanner.nextDouble();

        // converter este valor para o tipo int e exibir o resultado
        int valueInt = (int) value;
        System.out.println("Valor com casas decimais: " + value + " | Valor inteiro: " + valueInt);

        // converter o valor 10 (int) para double de forma implícita. E exibir
        valueInt = 10;
        double valueDouble = valueInt;
        System.out.println("Novo: "+ valueInt +" | Convertido: " + valueDouble);

        //converter o valor 10 (double) para int de forma implícita
        valueInt = (int) valueDouble;
    }
}
