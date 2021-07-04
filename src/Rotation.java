/**
 * e.g fatigue....number of rotations that will be tiguefa
 * efatigu 1
 * uefatig 2
 * guefati 3
 * iguefat 4
 * tiguefa 5
 *
 * 5 rotations, if not found return -1;
 * */
public class Rotation {
    public static void main(String[] args) {
        System.out.println(shiftedDiff("fatigue", "tiguefa"));
        System.out.println(shiftedDiff("coffee", "eecoff"));
    }

    public static int shiftedDiff(String first, String second) {
        int rotation = 0;
        String newStr = "";

        if(first.equals(second)) return  0;

        while(!first.equals(second)){
            char last = first.charAt(first.length()-1);
            newStr = last + first.substring(0, first.length()-1);
            rotation++;

            if(rotation > first.length()) return -1;

            if(!newStr.equals(second)) first = newStr;
            else return rotation;
        }

        return  -1;
    }
}
