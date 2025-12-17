import java.util.Random;
import java.util.Scanner;

public class minesweepers {

    public static void main(String[] args) {

        int rows = 10;
        int cols = 10;
        int mines = 10;

        int[][] grid = createGrid(rows, cols, mines);

        boolean[][] revealed = new boolean[rows][cols];
        Scanner sc = new Scanner(System.in);
        boolean gameOver = true;

        while (gameOver==false) {

            drawField(grid, revealed);

            System.out.print("Enter the row and col that you want to reveal (row,col):");

            String coor = sc.next();

            int r = Integer.parseInt(coor.substring(0,1));

            int c =Integer.parseInt(coor.substring(2,3));

            if (r < 0 || r >= rows || c < 0 || c >= cols) {
                System.out.println("Invalid");
                continue;
            }

            revealed[r][c] = true;

            if (grid[r][c] == -1) {
                gameOver = true;
            }
        }

        drawField(grid, revealAll(rows, cols));
        System.out.println("Game Over");
        sc.close();
    }

    public static int[][] createGrid(int n, int m, int mines) {
        int[][] grid = new int[n][m];
        Random rand = new Random();

        int placed = 0;
        while (placed < mines) {
            int r = rand.nextInt(n);
            int c = rand.nextInt(m);
            

            if (grid[r][c] != -1) {
                grid[r][c] = -1;
                placed++;
            }
        }
        return grid;
    }


    public static void drawField(int[][] grid, boolean[][] revealed) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (revealed[r][c]) {
                    if (grid[r][c] == -1) {
                        System.out.print(" B");
                    } else {
                        System.out.print(" " + grid[r][c]);
                        
                    }
                } else {
                    System.out.print(" ?");
                }
            }
            System.out.println();
        }
    }
    /*
    
    
    public static void calcDist( int r, int c){
        
        if (grid [r][c-1] == "B" ){
            
            grid [r][c-1] = 1; 
            
            
              
        }else if ( grid [r] [c+ 1] == "B"){
            
            grid [r] [c+ 1] = 1;
            
        }else if ( grid [r-1] [c] == "B" ) {
            
            grid [r-1] [c] = 1; 
        }else {
            grid [r+1] [c] = 1; 
        }
        
        
        
    }
    
    /*

    public static void reveal ( int r, int c){

       // reveal [r][c] = true; 

        if ( drawField [r][c] == 0 ){
            reveal (r , c-1); 
            reveal (r , c+1); 
            reveal (r-1, c); 
            reveal (r+1 , c); 

            
        }
        
    }
    
    */
    
    
    public static boolean[][] revealAll(int r, int c) {
        boolean[][] all = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                all[i][j] = true;
            }
        }
        return all;
    }
}