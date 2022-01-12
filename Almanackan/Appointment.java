package Almanackan;

import java.util.HashMap;


public class Appointment implements Comparable<Appointment>{
    public String description;
    public String month;
    public int date;
    public String time;
    private static HashMap<String,Integer> monthMap = new HashMap<String,Integer>();

    public Appointment(String description, String month, int date, String time){
        this.description = description;
        this.month = month;
        this.date = date;
        this.time = time;

        monthMap.put("jan", 1);
        monthMap.put("feb", 2);
        monthMap.put("mar", 3);
        monthMap.put("apr", 4);
        monthMap.put("maj", 5);
        monthMap.put("jun", 6);
        monthMap.put("jul", 7);
        monthMap.put("aug", 8);
        monthMap.put("sep", 9);
        monthMap.put("oct", 10);
        monthMap.put("nov", 11);
        monthMap.put("dec", 12);
    }

    public String toString(){
        return month+" " + String.valueOf(date) + " " + time + " " + description;
    }

    public int compareTo(Appointment o){
        int thisMonth = monthMap.get(this.month);
        int oMonth = monthMap.get(o.month);
        if (thisMonth < oMonth) {
            return -1;
        }else if (thisMonth > oMonth){
            return 1;
        } else { //If months are the same, check date
            if (this.date < o.date) {
                return -1;
            }else if (this.date > o.date){
                return 1;
            } else { //If dates are the same, check hours
                String[] thisHM = this.time.split(":");
                String[] oHM = this.time.split(":");
                int thisH = Integer.parseInt(thisHM[0]);
                int oH = Integer.parseInt(oHM[0]);
                if (thisH < oH) {
                    return -1;
                }else if (thisH > oH){
                    return 1;
                } else { //If hours are the same, check minutes
                    int thisM = Integer.parseInt(thisHM[1]);
                    int oM = Integer.parseInt(oHM[1]);
                    if (thisM < oM) {
                        return -1;
                    }else if (thisM > oM){
                        return 1;
                    } else { //If minutes are the same, they are equal. 
                        return 0;
                    }
                }

            }
        }
    }
}
