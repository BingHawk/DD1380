import Almanackan.Appointment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AlmanackanMain {

    public static void main(String[] args){
        ArrayList<Appointment> appointments = parseInput();
        Collections.sort(appointments);
        print(appointments);
    }

    private static ArrayList<Appointment> parseInput() {
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();

        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()){
            String line = in.nextLine();

            while(line.indexOf("  ") != -1){ //rensar dubbel-space. 
                line = line.replaceAll("\\s\\s", " ");
            }
            String[] parts = line.split(" ");

            if(parts.length == 1){
                continue;
            }

            String month = parts[0];
            int date = Integer.parseInt(parts[1]);
            String time = parts[2];
            String description = parts[3];
            if(parts.length > 4) {
                for (int i = 4; i< parts.length;i++){
                    description = description + " " +parts[i];
                }
            }


            Appointment apmt = new Appointment(description, month, date, time);

            appointments.add(apmt);
        }
        in.close();
        return appointments;
    }

    private static void print(ArrayList<Appointment> appointments){
        for(Appointment i : appointments){
            System.out.println(i.toString());
        }
    }
}
