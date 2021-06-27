/***
 * adds together the numbers in each string in the array,
 * and sort the array in ascending order based on the result from the addition
 */
public class WeightSort {

    public static String orderWeight(String strng) {
        // your code
        String[] str = strng.split(" ");
        String value = "";

        for(int i = 0; i < str.length-1; i++){
            if(addAllNo(str[i]) > addAllNo(str[i+1])){
                String temp = str[i];
                str[i] = str[i+1];
                str[i+1] = temp;
            }
        }

        for(String item: str){
            value += item+" ";
        }

        return value.trim();
    }

    public static void main(String[] args) {
        System.out.println(orderWeight("2003 103 123 4444 99"));
    }

    public static int addAllNo(String num){
        int sum = 0;
        for(int i = 0; i < num.length(); i++){
            sum += Integer.parseInt(num.charAt(i)+"");
        }

        return sum;
    }
}
