import java.io.IOException;

public class KommentarerMain {
    public static Boolean inComment = false;
    public static String commentType = null;

    public static void main(String[] args){
        int i;
        char bufferedChar = '0';

        try {
            while ((i = System.in.read()) != -1) {
                char c = (char)i;

                //on toggles
                if(c == '%' && !inComment){
                    toggleInComment("%");
                }
                if (bufferedChar == '0' && (c == '*' || c == '/')){
                    bufferedChar = c;
                } else if (bufferedChar == '/' && c == '*' && !inComment){ //Comments are off
                    toggleInComment("*/"); //Toggel on. 
                } else {
                    bufferedChar = '0';
                }

                //print
                if(!inComment){
                    System.out.print(c);
                }

                //off toggles
                if(c == '%' && inComment){
                    toggleInComment("%");
                }
                if (bufferedChar == '*' && c == '/' && inComment){
                    toggleInComment("*/");
                } 
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void toggleInComment(String comType){
        if (inComment){
            if (comType.equals(commentType)){
                inComment = false;
                commentType = null;
            }
        } else {
            inComment = true;
            commentType = comType;
        }
        System.out.println("toggleInComment run. inComment: "+inComment);
    }
}

