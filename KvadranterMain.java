import java.util.Scanner;

import Kvadranter.Tile;

public class KvadranterMain {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String startTileName = in.nextLine();
        String moveString = in.nextLine();

        int dx = Integer.parseInt(moveString.split(" ")[0]); //Positivt x är höger
        int dy = Integer.parseInt(moveString.split(" ")[1]); //Positivt y är uppåt

        String[] splited = startTileName.split("\\.");
        int n = splited.length; //n is the number of levels

        in.close();

        Tile startTile = new Tile(startTileName);
        int newX = startTile.x + dx;
        int newY = startTile.y + dy;

        //System.out.println(startTile);
        
        if(newX < 0 || newY < 0 || newX > Math.pow(2,n)-1 || newY > Math.pow(2,n)-1 ){
            System.out.println("outside");
        } else { //Nya koordinaten finns. 
            //System.out.println("new (x,y) = "+newX+","+newY);
            Tile endTile = new Tile(newX, newY, n);
            System.out.println(endTile.name);
        }
        //Old recursive solution kept for testing 
        /*
        Grid grid = new Grid(n);
        //System.out.println(grid);

        int[] startCoordinates = grid.getTileCoordinate(startTileName); //startCoordinates = [row,col] of the start tile
        if (startCoordinates == null){
            System.out.println("startCoordinates is null");
        }
        int[] endCoordinates = {startCoordinates[0]-dy, startCoordinates[1]+dx};
        String endTile = grid.getTileName(endCoordinates);

        System.out.println(endTile);
        */
    }
}
