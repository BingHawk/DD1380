import java.io.IOException;

public class KommentarerMain {
    public static Boolean inComment = false;
    public static String commentType = null;

    public static void main(String[] args){
        int i;

        try {
            char prev = '0';
            while ((i = System.in.read()) != -1) {
                char c = (char)i;

                if(c == '%'){
                    System.out.print("[% detected]");
                    parsePercent();
                } else if (c == '*'){
                    System.out.print("[* detected, prev = "+prev+"]");
                    parseStar(prev);
                } else if (c == '/'){
                    System.out.print("[/ detected, prev = "+prev+"]");
                    parseSlash(prev);
                } else {
                    if(!inComment){
                        System.out.print(c);
                    }
                }
                prev = c;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Slår på eller av kommentarsläge om % kommer
    private static void parsePercent(){
        if(!inComment){
            inComment = true;
            commentType = "%";
        } else {
            inComment = false;
            commentType = null;
            //TODO: lägg till hantering av annan kommentar
        }
    }

    //Slår på kommentarsläge om /kommer före *
    private static void parseStar(char prev){
        if(!inComment){
            if(prev == '/'){
                inComment = true;
                commentType = "*/";
            }
        }
    }

    //stännger av komentarsläge om stjärna kommer innan /
    private static void parseSlash(char prev){
        if(inComment){
            if(prev == '*'){
                inComment = false;
                commentType = null;
                //TODO: hantera annan kommentarstyp
            }
        }
    }
}

