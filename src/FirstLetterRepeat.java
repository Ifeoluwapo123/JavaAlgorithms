import java.util.*;

/**
 * Return the first latter that doesn't repeats itself
 * Case sensitive. e.g, A is not the same as a
 * */
public class FirstLetterRepeat {
    public static String getFirstLetter(String str){
        Map<Character, Integer> ls = new LinkedHashMap<>();

        for(int i = 0; i < str.length(); i ++){
            char key = str.charAt(i);
            int count = 0;
            if(ls.size() == 0){
                ls.put(key, 1);
            }else{
                for(Map.Entry<Character, Integer> item: ls.entrySet()){
                    if(item.getKey().equals(key)){
                        count++;
                    }
                }

                if(count != 0) {
                    int value = ls.get(key);
                    value++;
                    ls.put(key, value);
                }else{
                    ls.put(key, 1);
                }
            }
        }

        String value = "";
        for(Map.Entry<Character, Integer> item: ls.entrySet()){
           if(item.getValue() == 1){
               value += item.getKey();
               break;
           }
        }
        return value;
    }

    public static void main(String args[]){
        System.out.println(getFirstLetter("stress"));
        System.out.println(getFirstLetter("STreSS"));
        System.out.println(getFirstLetter("cocacola"));
        System.out.println( indexOfMethod("ChoColate"));
        System.out.println( indexOfMethod("MetarmoPHOSis"));
        System.out.println("===========================");
        System.out.println(getFirstCharacter("stress"));
        System.out.println(getFirstCharacter("STreSS"));
        System.out.println(getFirstCharacter("cocacola"));
        System.out.println( indexOfMethod("ChoColate"));
        System.out.println( indexOfMethod("MetarmoPHOSis"));
        System.out.println("===========================");
        System.out.println( sofiaSolution("stress"));
        System.out.println( sofiaSolution("STreSS"));
        System.out.println( sofiaSolution("cocacola"));
        System.out.println( indexOfMethod("ChoColate"));
        System.out.println( indexOfMethod("MetarmoPHOSis"));
        System.out.println("===========================");
        System.out.println( indexOfMethod("stress"));
        System.out.println( indexOfMethod("STreSS"));
        System.out.println( indexOfMethod("cocacola"));
        System.out.println( indexOfMethod("ChoColate"));
        System.out.println( indexOfMethod("MetarmoPHOSis"));
    }

   public static String getFirstCharacter(String str){
        String[] arr = str.split("");
        LinkedList<String> ls = new LinkedList();
        String ans = "";

       for (String s : arr) {
           ls.add(s);
       }

        for(int i = 0; i < arr.length; i++){
            int tally = Collections.frequency(ls, ls.get(i));
            if (tally ==1 ){
               ans = ls.get(i);
               break;
            }
        }

        return ans;

   }

   public static String sofiaSolution(String str){
        String substring;
        String value = "";
        int length = str.length();
        for(int i = 0; i < str.length(); i++){
            substring = String.valueOf(str.charAt(i));
            int check = length  - str.replaceAll(substring, "").length();
            if(check == 1){
               value = String.valueOf(str.charAt(i));
               break;
            }
        }

        return value;
   }

   public static String indexOfMethod(String str){
        String value = "";
        for(int i = 0; i < str.length(); i++){
            String newStr = String.valueOf(str.charAt(i)).toLowerCase();
            String strToLowerCase = str.toLowerCase();

            if(strToLowerCase.indexOf(newStr) == strToLowerCase.lastIndexOf(newStr)){
                value = String.valueOf(str.charAt(i));
                break;
            }
        }

        return value;
   }

}
