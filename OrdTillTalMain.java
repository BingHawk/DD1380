import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;

public class OrdTillTalMain {
    public static void Main(String[] args){
        Map<String, String[]> map = new HashMap<String, String[]>();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        String pattern = "(.*?miljoner)"
        String[] inputSplit = input.split("\\s+");

        for(String i: inputSplit){

        }

        in.close();
    }
    
    public static int parseHundred(String input){
        int number = 0;

        return number;
    }


}
