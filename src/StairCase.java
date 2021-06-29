
/**
 * Builds a stair case of height n and base n(base size(n) decreases up the stair to n = 1)
 * */
public class StairCase {

    public static void main(String[] args) {
        staircase(4);
        System.out.println("_________________");
        staircase(5);
    }

    static void staircase(int n) {
        String ash = "#";
        String space = " ";

        for(int i = 1; i <= n; i++){
            int j = n - i;
            //String result = ash.repeat(i); //not supported in
            String result = new String(new char[i]).replace("\0", "#");
            String spaceResult = space.repeat(j);
            System.out.println(spaceResult+result);
        }
    }
}
