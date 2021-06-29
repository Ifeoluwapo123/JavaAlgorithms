/**
 * convert Numerical values to Numerals
 * */
public class RomanNumeral {

    public static void main(String[] args) {
        System.out.println(roman(1998));
    }
    public static String roman(int n) {
        String result;
        String[] digit = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII",
                "VIII", "IX"};
        String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX",
                "LXXX", "XC"};
        String[] hundred = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC",
                "DCCC", "CM"};
        String[] thousand = {"", "M", "MM", "MMM"};


        result = thousand[n/1000] + hundred[n%1000/100] + ten[n%100/10] +
                digit[n%10];

        return result;
    }

}
