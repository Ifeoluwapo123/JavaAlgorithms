import java.util.ArrayList;
import java.util.List;

/**
 The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge .
 Each of them has a single 100, 50 or 25 dollar bill. An "Avengers" ticket costs 25 dollars.
 Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.
 Can Vasya sell a ticket to every person and give change if he initially has no money and sells the tickets
 strictly in the order people queue?
 Return YES, if Vasya can sell a ticket to every person and give change with the bills he has at hand at that moment.
 Otherwise return NO.
 Examples:
 getChange(new int[] {25, 25, 50}) // => YES
 getChange(new int[] {25, 50}) // => YES
 getChange(new int[] {25, 100}) // => NO. Vasya will not have enough money to give change to 100 dollars
 getChange(new int[] {25, 25, 50, 50, 100}) // => NO. Vasya will not have the right bills to give 75 dollars of change
 (you can't make two bills of 25 from one of 50)

 /============== EXTRA CASES ===================/
 getChange(new int[] {25, 25, 50, 25, 100}); // => YES
 getChange(new int[] {25, 25, 50, 50, 25}); // => YES
 getChange(new int[] {25, 100, 50, 50 });  // => NO
 getChange(new int[] {50, 100, 50, 50 }); // => NO
 getChange(new int[] {25, 50, 25, 100 }); // => YES
 getChange(new int[] {25, 50, 25, 25, 100 }); // => YES
 getChange(new int[] {25, 25, 50, 25, 25, 25, 50, 50, 100 }); //= > YES
 getChange(new int[] {25, 50, 25, 50, 50 }); // => NO
 */
public class Avengers {

    public static void main(String[] args) {
        System.out.println(getChange(new int[] {25, 25, 25, 25, 25, 50, 100, 100, 25}));  // YES
        System.out.println(Tickets(new int[] {25, 25, 25, 25, 25, 25, 50, 100, 100, 25}));  // YES
        System.out.println(getChange(new int[] {25, 50}));  // YES
        System.out.println(getChange(new int[] {25, 100}));  // NO
        System.out.println(getChange(new int[] {25, 25, 50, 50, 100})); // NO
        System.out.println(getChange(new int[] {25, 25, 50, 25, 100})); // YES
        System.out.println(getChange(new int[] {25, 25, 50, 50, 25})); // YES
        System.out.println(getChange(new int[] {25, 100, 50, 50 }));  // NO
        System.out.println(getChange(new int[] {50, 100, 50, 50 })); // NO
        System.out.println(getChange(new int[] {25, 50, 25, 100 })); // YES
        System.out.println(getChange(new int[] {25, 50, 25, 25, 100 })); // YES
        System.out.println(getChange(new int[] {25, 25, 50, 25, 25, 25, 50, 50, 100 })); //YES
        System.out.println(getChange(new int[] {25, 50, 25, 50, 50 })); // NO
    }

    /**
     *  if currentBill equals 25, you are not collecting change, move to the next index
     *  if not 25, check if you can give exact change from the money of previous ticket sold (change - previous = 0)
     *  if yes, give the change, then take away the money from the list
     *  Because the Array list decreases in size by 1, take a step backward
     *  once change is 0, meaning no change to collect, move to the next person
     * */
    public static String getChange(int[] arr){
        List<Integer> ls = new ArrayList();

        if (arr[0] != 25) {
            return "NO";
        }

        for(int num: arr){
            ls.add(num);
        }

        //25, 25, 50, 25, 100

        for(int i = 1; i < ls.size(); i++){
            int currentBill = ls.get(i);
            int change = currentBill - 25;

            if(currentBill != 25){

                for(int j = 0; j <= i; j++) {
                    int previousBill = ls.get(j);
                    if (change - previousBill == 0) { //if it enters this loop change will become 0 and the loop will break
                        if (change != 0) change = change - previousBill;
                        ls.remove(j);
                        i--;
                        j--;
                    }else{
                        if(change > 0 && previousBill <= change){ //to remove negative change
                            change = change - previousBill;
                            ls.remove(j);
                            i--;
                            j--;
                        }
                    }

                    if(change == 0) break;
                }

                if(change != 0) return "NO";
            }
        }

        System.out.println(ls);
        return "YES";
    }

    public static String Tickets(int[] peopleInLine) {
        int current25 = 0, current50 = 0;
        for(int cash : peopleInLine){
            if(cash < 26) current25++;
            else if(cash < 51 && current25 > 0){
                current50++;
                current25--;
            } else if (current25 > 0 && current50 > 0){
                current25--;
                current50--;
            }else if(current25 > 2) current25 -= 3;
            else return "NO";
        }
        return "YES";
    }

}
