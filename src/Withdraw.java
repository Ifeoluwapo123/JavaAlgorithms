
/**
 * An ATM contains [100, 50, 20] notes
 * look for the better combination of these that will pay
 * a certain amount without any money left to pay(no remainder)
 * e.g 100 returns [1, 0, 0] because 1=>(100), 0=>(50), 0=>(20)
 * 110 returns [0, 1, 3] because 0=>(100), 1=>(50), 3=>(20)
 * */
public class Withdraw {
    public static int[] withdraw(int n) {
        int n50 = 0;
        int n20 = n / 20;
        int rem = n % 20;

        if (rem == 10) {
            n20 -= 2;
            n50 += 1;
        }

        int n100 = n20 / 5;
        n20 %= 5;
        System.out.println(n100);
        System.out.println(n50);
        System.out.println(n20);
        return new int[]{n100, n50, n20};
    }

    public static void main(String[] args){
        System.out.println(withdraw(110));
    }
}
