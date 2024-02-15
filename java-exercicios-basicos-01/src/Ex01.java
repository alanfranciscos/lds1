
public class Ex01 {
    public static void main(String[] args) {
        int idade = 15;
        // exiba a idade
        System.out.println("A idade é de " + idade + " anos");
        // somar 5 nessa idade e multiplicar por 2 - exibir na tela
        idade = (idade+5)*2;
        System.out.println("Resultado 1: " + idade);
        // subtrair 5 - exibir na tela
        idade = idade-5;
        System.out.println("Resultado 2: " + idade);
        // Verificar SE a idade é maior do que 20 - exibir na tela
        String result = (idade > 20) ? "A idade é maior que 20" :"A idade é menor que 20";
        System.out.println(result);
    }
}
