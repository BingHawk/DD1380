import java.util.Scanner;

class kommentarer5 {
    public static void main(String[] args) {

        Scanner scan = new Scanner( System.in );
        StringBuffer buf = new StringBuffer();
        while ( scan.hasNextLine() ) {
            buf.append( scan.nextLine() );
            buf.append( "\n" );
        }
        String text = buf.toString(); 

        scan.close();

        // TESTSTRÄNG
        //String text = "Charles knocked on the door and a woman opened it. % Hmm, is this good... /* Not sure to 100% */ Perhaps this should happen in chapter 10 instead? % She looked at him.- Yes?, she said.";
        String storage = "0";

        while (text.contains("%") || text.contains("/*")) {

            String[] parts;

            int plats1 = text.indexOf("%");
            int plats2 = text.indexOf("/*");
            //System.out.println(plats1 + " and " + plats2);

            if (plats1 == -1) plats1=plats2+1;          // "placerar" /* en plats bakom % (för att gå in i rätt if-sats)
            else if (plats2 == -1) plats2=plats1+1;     // Tvärtom

            //System.out.print("% finns pa plats: " + plats1 + ". ");
            //System.out.print("/* finns pa plats: " + plats2 + ". ");

            // 1--------------> Om % före /* <---------------
            if (plats1 < plats2) {
                parts = text.split("%", 2);
                storage = storage + parts[0];
                if (parts[1].contains("%")) {   // Om det finns kommentarsavslut
                    text=parts[1];
                    parts = text.split("%", 2);
                    text=parts[1];
                }
                else text = "";
            }

            else if (plats1 > plats2) {
                String text2;
                storage = storage + text.substring(0,plats2);    // Substring för att lösa fallet /*/*/*/
                text2 = text.substring(plats2+2);
                if (text2.contains("*/")) {  // Om det finns kommentarsavslut
                    //parts1 = storage + text.substring(0,plats2);    // Substring för att lösa fallet /*/*/*/
                    int plats3 = text2.indexOf("*/");
                    text = text2.substring(plats3+2);
                    //System.out.println(plats3 + " and " + text);
                }
                else text="";
            }
        //System.out.println(storage + " and " + text);
        }
        storage=storage+text;
        storage=storage.substring(1);
        System.out.println(storage);
    }
}