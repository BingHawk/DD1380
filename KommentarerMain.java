import java.io.IOException;
import java.util.Scanner;

public class KommentarerMain {
    public static Boolean inComment = false;
    public static Boolean slashDebt = false; //true om vi har ett överhoppat / som bör skrivas ut.
    public static Boolean resetPrev = false; //True if prev in the loop needs to be reset
    public static String commentType = null;

    public static void main(String[] args){
        streaming();
    }

    public static void streaming(){
        int i;

        try {
            char prev = '0';
            while ((i = System.in.read()) != -1) {
                char c = (char)i;

                if(c == '%'){
                    paySlashDept(slashDebt);
                    parsePercent();
                } else if (c == '*'){
                    parseStar(prev);
                } else if (c == '/'){
                    paySlashDept(slashDebt);
                    parseSlash(prev);
                } else {
                    if(!inComment){
                        paySlashDept(slashDebt);
                        System.out.print(c);
                    }
                }
                prev = c;
                if (resetPrev){
                    prev = '0';
                    resetPrev = false;
                }
            }
            inComment = false;
            commentType = null;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buffering(){
        Scanner scan = new Scanner( System.in );
        StringBuffer buf = new StringBuffer();
        while ( scan.hasNextLine() ) {
            buf.append( scan.nextLine() );
            buf.append( "\n" );
        }
        scan.close();
        String s = buf.toString();
        //System.out.println("testar skriva s: "+s);

        char prev = '0';
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '%'){
                parsePercent();
            } else if (c == '*'){
                parseStar(prev);
            } else if (c == '/'){
                parseSlash(prev);
            } else {
                if(!inComment){
                    System.out.print(c);
                }
            }
            prev = c;
        }
    }
    //Slår på eller av kommentarsläge om % kommer
    private static void parsePercent(){
        //System.out.print("[%: inC: "+inComment+" , cType: "+commentType+"]");
        if(!inComment){
            inComment = true;
            commentType = "%";
        } else {
            if(commentType == "%"){
                inComment = false;
                commentType = null;
            }
        }
    }

    //Slår på kommentarsläge om /kommer före *
    private static void parseStar(char prev){
        //System.out.print("[*: prev: "+prev+" , inC: "+inComment+" , cType: "+commentType+"]");
        if(!inComment){
            if(prev == '/'){
                if(commentType != "%"){
                    inComment = true;
                    commentType = "*/";
                    slashDebt = false; //Nollställer slash dept eftersom en * kom efter. 
                    resetPrev = true;
                }
            } else {
                System.out.print('*');
            }
        }
    }

    //stännger av komentarsläge om stjärna kommer innan /
    private static void parseSlash(char prev){
        //System.out.print("[/: prev: "+prev+" , inC: "+inComment+" , cType: "+commentType+"]");
        if(inComment){
            if(prev == '*'){
                if(commentType == "*/"){
                    inComment = false;
                    commentType = null;
                    resetPrev = true;
                }
            }
        } else {
            slashDebt = true; //Vi har ett / att skriva ut om nästa inte är en *
        }
    }

    //skriver ut / om vi har hoppat över ett som skulle skrivas ut
    public static void paySlashDept(boolean dept){
        if (dept){
            System.out.print('/');
            slashDebt = false;
        }
    }
}

/*

Charles knocked on the door and a woman 
opened it. % Don't forget that Charles 
has already met this woman in chapter 5! % 
She looked at him.
- Yes?, she said.

*/