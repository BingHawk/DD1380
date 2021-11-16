import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class OrdTillTalMain {
    public static void main(String[] args){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("en",1);
        map.put("ett",1);
        map.put("två",2);
        map.put("tre",3);
        map.put("fyra",4);
        map.put("fem",5);
        map.put("sex",6);
        map.put("sju",7);
        map.put("åtta",8);
        map.put("nio",9);
        map.put("tio",10);
        map.put("elva",11);
        map.put("tolv",12);
        map.put("tretton",13);
        map.put("fjorton",14);
        map.put("femton",15);
        map.put("sexton",16);
        map.put("sjutton",17);
        map.put("arton",18);
        map.put("nitton",19);
        map.put("tjugo",20);
        map.put("trettio",30);
        map.put("fyrtio",40);
        map.put("femtio",50);
        map.put("sextio",60);
        map.put("sjuttio",70);
        map.put("åttio",80);
        map.put("nittio",90);
        map.put("hundra",100);
        map.put("tusen",1000);
        map.put("miljon",1000000);
        map.put("miljoner",1000000);
        map.put("miljard",1000000000);
        map.put("miljarder",1000000000);


        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();

        String[] inputSplit = input.split("\\s+");
        int[] intList = new int[inputSplit.length];
        for(int i =0; i< inputSplit.length;i++){
            int num = map.get(inputSplit[i]);
            intList[i] = num;
        }
        Long sum = 0L;
        Long piece = 0L;
        for (int i:intList){
            if(i == 1000 || i == 1000000 || i == 1000000000){
                piece = piece*i;
                sum = sum + piece;
                piece = 0L;
            } else if (i == 100){
                piece = piece*i;
            }else {
                piece = piece + i;
            }
        }
        sum = sum+piece;

        System.out.println(sum);

    }
}
