
import java.util.Scanner; 
import java.util.ArrayList; 
import java.util.Random; 


public class minesweepers
{
    
    public static void main (String []args){        
        
        drawField ( 10, 10); 
        
        
      
        

    }
    
    public static void drawField(int n, int m){
        int [] [] grid = new int [n] [m]; 
         int min = 0; 
        int max =n;
        
        Random random = new Random(); 
        
        int randomNum = random.nextInt((max - min) + 1) + min;
        
        
        for ( int r = 0; r < grid.length; r++){
            
            for ( int c = 0; c< grid[0].length; c++){
                System.out.print( " " + "?" ); 
                
                
            }
            
            
            if ( grid[r][r] == grid [randomNum] [randomNum]){
                    
                    System.out.print( " " + "B" ); 
                }
            System.out.println(); 
        }
        
        
        
    }
    
    
    public static void drawMines(int n, int m ){
        
       
        
        
        
        
    }
    
    
}
