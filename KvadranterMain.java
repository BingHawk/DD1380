import java.util.Scanner;

public class KvadranterMain {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String startTile = in.nextLine();
        String moveString = in.nextLine();

        int dx = Integer.parseInt(moveString.split(" ")[0]); //Positivt x är höger
        int dy = Integer.parseInt(moveString.split(" ")[1]); //Positivt y är uppåt

        in.close();

        String[] splited = startTile.split("\\.");
        int n = splited.length;

        Grid grid = new Grid(n);
        //System.out.println(grid);

        int[] startCoordinates = grid.getTileCoordinate(startTile); //startCoordinates = [row,col] of the start tile
        if (startCoordinates == null){
            System.out.println("startCoordinates is null");
        }
        int[] endCoordinates = {startCoordinates[0]-dy, startCoordinates[1]+dx};
        String endTile = grid.getTileName(endCoordinates);

        System.out.println(endTile);


    }
}
