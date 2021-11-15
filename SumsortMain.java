import java.util.Scanner;
import java.util.Arrays;   

public class SumsortMain {
    public static void main(String[] args){
        int[] arr = parseInput();
        Arrays.sort(arr);
        int half;
        if(arr.length % 2 == 0){
            half = arr.length/2;
        } else {
            half = (arr.length-1)/2;
        }
        int sum = 0;
        for(int i = half;i < arr.length; i++){
            sum = sum + arr[i];
        }
        System.out.println(sum);
    }

    public static int[] parseInput(){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] arr = new int[len];
        for(int i = 0;i<len;i++){
            arr[i] = in.nextInt();
        }
        in.close();
        return arr;
    }
}
