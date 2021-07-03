/**
 * Replace all the digits to # leaving the last four digits the way they are
 * */
public class Maskify {
    public static void main(String[] args) {
        System.out.println(maskify("4556364607935616"));

    }

    public static String maskify( String cc ) {

        if(cc.length() <= 4) return cc;

        int strLen = cc.length();

        int len = strLen - 4;

        return "#".repeat(len)+cc.substring(len);

    }

    public static String maskifyOne( String cc ) {

        if(cc.length() <= 4) return cc;
        return "#".repeat(cc.length()-4)+cc.substring(cc.length()-4);

    }
}
