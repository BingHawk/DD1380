package Kvadranter;


public class Tile {
    //Klass som definierar en ruta i systemet. 
    public int x;
    public int y;
    public String name;

    //matematiska samband anteckningar
    /*
        //Första siffran:
        // 1 <=> 0 =< x < 2^(n-1) och 0 =< y < 2^(n-1), lägsta: x=0, y=0
        // 2 <=> 2^(n-1) =< x < 2^(n-0) och 0 =< y < 2^(n-1), lägsta: x=2^(n-1), y=0
        // 3 <=> 0 =< x < 2^(n-1) och 2^(n-1) =< y < 2^(n-0), lägsta: x=0, y=2^(n-1)
        // 4 <=> 2^(n-1) =< x < 2^(n-0) och 2^(n-1) =< y < 2^(n-0), lägsta: x=2^(n-1), y=2^(n-1)

        //första kvadrantedn, Andra siffran
        // 1 <=> 0 =< x < 2^(n-2) och 0 =< y < 2^(n-2)
        // 2 <=> 2^(n-2) =< x < 2^(n-1) och 0 =< y < 2^(n-2)
        // 3 <=> 0 =< x < 2^(n-2) och 2^(n-2) =< y < 2^(n-1)
        // 4 <=> 2^(n-2) =< x < 2^(n-1) och 2^(n-2) =< y < 2^(n-1)

        // Första, första, första:
        // 1 <=> 0 =< x < 2^(n-1) och 0 =< y < 2^(n-1)
        // 1 <=> 0 =< x < 2^(n-2) och 0 =< y < 2^(n-2)
        // 1 <=> 0 =< x < 2^(n-3) och 0 =< y < 2^(n-3)
    */
    
    public Tile(String name, int x, int y){ //Constructor om allt är kännt. 
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Tile(int newX, int newY, int n){ //Constructor om koordinat och träddjup är kända
        //Loopa igenom levels
        //För varje nivå, kolla vilken kvadrant vi är i 
        //Lägg till kvadrantens siffra i strängen
        //Ta bort lägsta möjliga koordinatvärde för den kvadranten från koordinaten
        //  Detta justerar koordinaten till den tile i kvadrant 1 som har samma nästkommande kvadranter
        //  och tillåter att samma koll som ovan körs igen. 

        this.x = newX;
        this.y = newY;

        int level = n; //Initiera nivån till n
        name ="";
        
        while(level > 0){ //Kör tills alla nivåer är genomgådda. 
            if(newX < Math.pow(2,level-1)){ //Kvadrant 1 eller 3 eftersom x<2^(n-1)
                if(newY < Math.pow(2,level-1)){ //Kvadrant 1 eftersom y<2^(n-1)
                    name = name +"1";
                    newX = newX - 0;
                    newY = newY - 0;
                    //System.out.println("Quadrant 1. name = "+name+":\nlevel: "+level+"\tx,y: "+newX+","+newY);
                } else {//kvadrant 3 eftersom y>=2^(n-1)
                    name = name +"3";
                    newX = newX - 0;
                    newY = newY - (int) Math.pow(2, level-1);
                    //System.out.println("Quadrant 3. name = "+name+":\nlevel: "+level+"\tx,y: "+newX+","+newY);
                }
            } else { //Kvadrant 2 eller 4 eftersom x>=2^(n-1)
                if(newY < Math.pow(2,level-1)){ //Kvadrant 2 eftersom y<2^(n-1)
                    name = name +"2";
                    newX = newX - (int) Math.pow(2, level-1);
                    newY = newY - 0;
                    //System.out.println("Quadrant 2. name = "+name+":\nlevel: "+level+"\tx,y: "+newX+","+newY);
                } else {//kvadrant 4 eftersom y>=2^(n-1)
                    name = name +"4";
                    newX = newX - (int) Math.pow(2, level-1);
                    newY = newY - (int) Math.pow(2, level-1);
                    //System.out.println("Quadrant 4. name = "+name+":\nlevel: "+level+"\tx,y: "+newX+","+newY);
                }
            }
            level = level -1;
            if (level != 0){ //Lägg till punkt mellan siffror om vi inte är på sista nivån. 
                name = name+".";
            }
        }
    }

    public Tile (String name){ //Konatruktor om namn är känt
        //Iterera genom varje nivå
        //För varje nivå, kolla vilken kvadrant vi är i
        //Lägg till lägsta möjliga koordinatvärde för den kvadranten.

        //Exempel: 4.1.4 borde ge:
        //startX = 2^(2)+0+2^(0) = 4+1 = 5
        //y = 2^(2)+0+2^(0) = 4+1 = 5

        this.name = name;
        String[] splited = name.split("\\.");
        int n = splited.length; //n is the number of levels
        int level = n; //Initialisera nivån till n: yttersta nivån
        int startX = 0; //Initialisera coordinaterna till nedre vänstra hörnet. 
        int startY = 0;
        while(level > 0){ //när level är 0 är vi på en ruta. 
            int index = n-level; //index i splited för den siffran som motsvarar level. 
            switch(Integer.parseInt(splited[index])){
                case 1: //är vi i kvadrant 1 är nedre vänstra hörnet minsta möjliga koodinat
                    startX = startX + 0;
                    startY = startY + 0;
                    //System.out.println("Case 2. name = "+name+":\nlevel: "+level+"\tx,y: "+startX+","+startY);
                    break;
                case 2: //är vi i kvadrant 2 är nedre raden mitten minsta möjliga koodinat
                    startX = startX + (int) Math.pow(2, level-1);
                    startY = startY + 0;
                    //System.out.println("Case 2. name = "+name+":\nlevel: "+level+"\tx,y: "+startX+","+startY);
                    break;
                case 3: //är vi i kvadrant 3 är vänstra kolumnen mitten minsta möjliga koodinat
                    startX = startX + 0;
                    startY = startY + (int) Math.pow(2, level-1);
                    //System.out.println("Case 3. name = "+name+":\nlevel: "+level+"\tx,y: "+startX+","+startY);
                    break;
                case 4: //är vi i kvadrant 4 är mitten minsta möjliga koodinat
                    startX = startX + (int) Math.pow(2, level-1);
                    startY = startY + (int) Math.pow(2, level-1);
                    //System.out.println("Case 4. name = "+name+":\nlevel: "+level+"\tx,y: "+startX+","+startY);
                    break;
            }
            level = level-1;
        }
        x = startX;
        y = startY;
    }

    public String toString(){
        return "Name: "+this.name+"\n(x,y): ("+this.x+","+this.y+")";
    }
}
