/**
 *  Three 1's => 1000 points
 *  Three 6's =>  600 points
 *  Three 5's =>  500 points
 *  Three 4's =>  400 points
 *  Three 3's =>  300 points
 *  Three 2's =>  200 points
 *  One   1   =>  100 points
 *  One   5   =>   50 point
 *  */
public class Greed{

    public static void main(String[] args) {
        System.out.println(greedy(new int[]{5,1,3,4,1}));
        System.out.println(greedy(new int[]{1,1,1,3,1}));
        System.out.println(greedy(new int[]{2,4,4,5,4}));
    }

    public static int greedy(int[] dice){
        //code here
        int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0;
        int sum = 0;

        for(int i = 0; i < dice.length; i++){
            if(dice[i] == 1){
                one++;

                if(one == 3){
                    sum += 1000;
                    one = 0;
                }
            }
            if(dice[i] == 2){
                two++;

                if(two == 3){
                    sum += 200;
                    two = 0;
                }
            }
            if(dice[i] == 3){
                three++;

                if(three == 3){
                    sum += 300;
                    three = 0;
                }
            }
            if(dice[i] == 4){
                four++;

                if(four == 3){
                    sum += 400;
                    four = 0;
                }
            }
            if(dice[i] == 5){
                five++;

                if(five == 3){
                    sum += 500;
                    five = 0;
                }
            }
            if(dice[i] == 6){
                six++;

                if(six == 3){
                    sum += 600;
                    six = 0;
                }
            }
        }

        if(one  > 0){
            for(int i = 0; i < one; i++){
                sum += 100;
            }
        }

        if(five  > 0){
            for(int i = 0; i < five; i++){
                sum += 50;
            }
        }
        return sum;
    }
}
