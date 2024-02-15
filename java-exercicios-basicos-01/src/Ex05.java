public class Ex05 {
    public static void main(String[] args) {
        for(int i = 0; i<= 5; i ++) {
            switch (i) {
                case 1:
                    System.out.println("Primeira condição");
                    break;
                case 4:
                    System.out.println("Segunda condição");
                    break;
                default:
                    System.out.println("Não encontrou uma condição");
            }
        }
    }
}
