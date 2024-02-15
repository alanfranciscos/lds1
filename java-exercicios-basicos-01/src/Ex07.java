public class Ex07 {
    public static void metodo(int[] input) {
        int sum = 0;
        for(int n: input) {
            sum+=n;
        }
        System.out.println("Resultado da operação: " + sum);
    };

    public static void metodo(double[] input) {
        double sub = 0;
        for(double n: input) {
            sub-=n;
        }
        System.out.println("Resultado da operação: " + sub);
    };

    public static void metodo(String[] input) {
        String str = "";
        for(String s: input) {
            str+=s;
        }
        System.out.println("Resultado da operação: " + str);
    };

    public static void main(String[] args) {
        int[] input1 = {5,5};
        double[] input2 = {10.27, 10.42};
        String[] input3 = {"44", "um texto qualquer"};

        Ex07.metodo(input1);
        Ex07.metodo(input2);
        Ex07.metodo(input3);

    }
}
