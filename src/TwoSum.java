import java.util.Arrays;

/**
 * returns the indexes of addition of two numbers in the array that first equal the target value
 * [2, 7, 11, 15] , target = 9, returns [0, 1] because 2 + 7 = 9;
 * [2, 11, 7, 15] , target = 9  returns [0, 2] because 2 + 11 = 13 wrong 2 + 7 = 9;
 * */
public class TwoSum {
    public static int[] twoSum(int[] number, int target){
        int[] newArr = new int[2];
        for(int i = 0; i < number.length; i++){
            int check = number[i];
            for(int j = 0; j < number.length; j++){
                if(i != j){
                    if(check + number[j] == target){
                        newArr[0] = i;
                        newArr[1] = j;
                    }
                }
            }
        }

        Arrays.sort(newArr);

        for (int i = 0; i < newArr.length; i++){
            System.out.println(newArr[i]);
        }

        return newArr;
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2, 11, 7, 15}, 9));
    }
}
