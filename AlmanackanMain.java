import Almanackan.Appointment;

import java.util.ArrayList;
import java.util.Scanner;

public class AlmanackanMain {

    public static void main(){
        parseInput();
    }

    private static void parseInput() {
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();

        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()){
            String line = in.nextLine();
            String[] parts = line.split(" ");




        }


    }

    
}
