package Kvadranter;

public class Grid {
    public int rowLength; //the number of columns in each row = number of rows in col. 
    public int n; //Number of tiles in the grid. n = rowLength^2. 
    public String[] grid;
    

    //n is the number of digits in the name. 
    public Grid(int levels) {
        rowLength = (int) Math.pow(2,levels);
        n = (int) Math.pow(4,levels);

        //System.out.println("rowLength = "+ rowLength +" n = "+n);
        grid = new String[n];

        grid = setGrid(grid); //Starting the recursion

        //Pseudokod om hur grid skapas. 
        //1. skapa fyra subgrids med n' = n/4
        //2. för varje grid: 
        //3. tilldela siffra
        //4. om n' > 1:
        //5. Dela upp i fyra subgrids med n'' = n'/4
        //6. lägg till sifra efter befintlig siffra
        //7. om n'' > 1: skickar till 5. 
        //8. Klistra ihop de fyra subgridsen.
    }

    //recursively appends the name of each level of subgrid until the subgrids are only
    private String[] setGrid(String[] grid){
        int rows = (int) Math.sqrt(grid.length);
        //Creating the subgrids
        String[] subGrid1 = new String[grid.length/4]; //Bottom left
        String[] subGrid2 = new String[grid.length/4]; //bottom right
        String[] subGrid3 = new String[grid.length/4]; //top left
        String[] subGrid4 = new String[grid.length/4]; //top right

        //Counting how many tiles have been placed in each subgrid
        int placed1 = 0;
        int placed2 = 0;
        int placed3 = 0;
        int placed4 = 0;

        //Deviding grid upto its subgrids by placing the values in grid in correct subgrid list. 
        for(int tileP = 0;tileP < grid.length; tileP++){
            if(tileP % rows < rows/2){ //We are in left quadrants.
                if((int) tileP/rows < rows/2){ //We are in top quadrants
                    //ska skrivas till subgrid 3
                    subGrid3[placed3] = grid[tileP];
                    placed3 = placed3 +1;
                } else{
                    //ska skrivas till subgrid 1
                    subGrid1[placed1] = grid[tileP];
                    placed1 = placed1 +1;
                }
            } else { //We are in right quadrants
                if((int) tileP/rows < rows/2){ //We are in top quadrants
                    //ska hämtas from subgrid 4
                    subGrid4[placed4] = grid[tileP];
                    placed4 = placed4 +1;
                } else{
                    //ska hämtas från subgrid 2
                    subGrid2[placed2] = grid[tileP];
                    placed2 = placed2 +1;
                }
            }
        }

        //Adding the next number in the namestrings
        for(int i = 0; i<subGrid1.length; i++){
            if(grid.length == n){ //we are on the first level, no points added. 
                subGrid1[i]="1";
                subGrid2[i]="2";
                subGrid3[i]="3";
                subGrid4[i]="4";
            } else {
                subGrid1[i]=subGrid1[i]+".1";
                subGrid2[i]=subGrid2[i]+".2";
                subGrid3[i]=subGrid3[i]+".3";
                subGrid4[i]=subGrid4[i]+".4";
            }

        }

        //Calling recursively until each grid only consist of 1 tile. 
        if(subGrid1.length > 1){
            subGrid1 = setGrid(subGrid1);
            subGrid2 = setGrid(subGrid2);
            subGrid3 = setGrid(subGrid3);
            subGrid4 = setGrid(subGrid4);
        }

        //Some test stuf
        //0,0; 0,1; 0,2; 0,3; 1,0; 1,1; 1,2; 1,3; 2,0; 2,1; 2,2; 2,3; 3,0; 3,1; 3,2; 3,3
        //n = 16
        //rowLength = 4

        //Counting how many of each subgrid have been placed in grid
        int retrieved1 = 0;
        int retrieved2 = 0;
        int retrieved3 = 0;
        int retrieved4 = 0;

        //Reconstructing the big grid from the finished subgrids by retrieving data from the correct subgrid. 
        for(int tile = 0;tile < grid.length; tile++){
            if(tile % rows < rows/2){ //We are in left quadrants.
                if((int) tile/rows < rows/2){ //We are in top quadrants
                    //ska hämtas from subgrid 3
                    grid[tile] = subGrid3[retrieved3];
                    retrieved3 = retrieved3 +1;
                } else{
                    //ska hämtas från subgrid 1
                    grid[tile] = subGrid1[retrieved1];
                    retrieved1 = retrieved1 +1;
                }
            } else { //We are in right quadrants
                if((int) tile/rows < rows/2){ //We are in top quadrants
                    //ska hämtas from subgrid 4
                    grid[tile] = subGrid4[retrieved4];
                    retrieved4 = retrieved4 +1;
                } else{
                    //ska hämtas från subgrid 2
                    grid[tile] = subGrid2[retrieved2];
                    retrieved2 = retrieved2 +1;
                }
            }
        }

        return grid;
    }

    public String getTileName(int row, int col){ //0,0 is top left.
        if(row > rowLength || row < 0 || col > rowLength || col < 0){
            return "outside";
        } else {
            return grid[row*rowLength+col];
        }
    }
    public String getTileName(int[] coordinates){ //coordinates = {row,col} 0,0 is top left. 
        int row = coordinates[0];
        int col = coordinates[1];
        if(row > rowLength || row < 0 || col > rowLength || col < 0){
            return "outside";
        } else {
            return grid[row*rowLength+col];
        }
    }

    public int[] getTileCoordinate(String tileName){
        int index = -1;
        for (int i = 0; i<grid.length; i++){
            if (grid[i].equals(tileName)){
                index = i;
            }
        }

        int col = index % rowLength;
        int row = (int) index/rowLength;
        int[] out = {row,col};

        if (index != -1){ //Returns null if tileName is not found. 
            return out;
        } else {
            return null;
        }
    }

    public String toString(){
        String out = "";
        for(int i = 0; i<rowLength; i++){ //i=row, j = column i=j=0 top left corner
            for(int j = 0; j<rowLength; j++){
                out = out + grid[i*rowLength+j] + ", ";
            }
            out = out + "\n";
        }
        return out;
    }
    
}
