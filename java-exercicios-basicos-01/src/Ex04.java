public class Ex04 {
    public static void main(String[] args) {
        //exiba 20 vezes o numero da iteração utilizando while
        int i = 0;
        while (i < 20) {
            System.out.println(i);
            i = i + 1;
        }

        //exiba 20 vezes o numero da iteração utilizando do/while
        int j = 0;
        do {
            System.out.println(j);
            j = j + 1;
        } while (j < 20);


        // exiba 20 vezes o numero da iteração utilizando for
        for(int m = 0; m < 20; m ++) {
            System.out.println(m);
        }

    }
}
