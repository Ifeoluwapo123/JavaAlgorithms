import java.util.ArrayList;

/**
 * checks for valid combination of Braces
 * */
public class ValidBraces {

    public static boolean validBraces(String braces){
        ArrayList arrayList = new ArrayList();

        for(int i = 0; i < braces.length(); i++){
            if(braces.charAt(i) == '(' || braces.charAt(i) == '{' || braces.charAt(i) == '['){
                arrayList.add(braces.charAt(i));
            }else{
                if(arrayList.size() == 0) return false;
                String lastSym = arrayList.get(arrayList.size()-1).toString();
                if(braces.charAt(i) == ')'&& lastSym.equals("(") || braces.charAt(i) == ']'&& lastSym.equals("[")
                || braces.charAt(i) == '}'&& lastSym.equals("{")){
                    arrayList.remove(arrayList.size()-1);
                }else{
                    break;
                }
            }
        }

        return arrayList.size() == 0;
    }


    public static void main(String[] args) {
        //test cases
        System.out.println(validBraces("()"));
        System.out.println(validBraces("[]"));
        System.out.println(validBraces("{}"));
        System.out.println(validBraces("(){}[]"));
        System.out.println(validBraces("(}"));
        System.out.println(validBraces("([{}])"));
        System.out.println(validBraces("[(])"));
        System.out.println(validBraces("({})[({})]"));
        System.out.println(validBraces("(})"));
        System.out.println(validBraces("(({{[[]]}}))"));
        System.out.println(validBraces("{}({})[]"));
        System.out.println(validBraces(")(}{]["));
        System.out.println(validBraces("())({}}{()][]["));
        System.out.println("false "+validBraces("[}"));
        System.out.println("true "+ validBraces("(){}[]"));
        System.out.println("false "+validBraces("(}"));
        System.out.println("false "+ validBraces("[(])"));
        System.out.println("true "+validBraces("([{}])"));

    }

}
