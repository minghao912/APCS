//Program to do noughts & crosses (very badly!).
//by www.neiljohan.com

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Nought
{
    public static boolean GAME_OVER=false;
    public static boolean NoughtGo = true;
    public static String tTeam = "Nought";
    public static int[][] aGrid = new int[3][3];
    public static boolean COMPUTER_GO = false;
    
    
    public static void main(String[] pArgs) throws IOException
        {
            int TURN_NUMBER=0;
            for (int rows=0; rows<3; rows++){
                for (int columns=0; columns<3; columns++){
                    aGrid[rows][columns] = 0;
                }
            }

            printgrid(aGrid);
       
       while (!GAME_OVER){
           boolean VALID=false;
           int X=0;
           int Y=0;
           if (!COMPUTER_GO){
               while (!VALID){
                   try{
                       String tInput = NeilClass.GetInputString("Where do you want to put your " + tTeam + " eg(2,1)");
                       final BufferedReader tKeyboard = new BufferedReader(new InputStreamReader(System.in));
                       StringTokenizer tTokensOnLine = new StringTokenizer(tInput, ",");

                       String tThisToken = tTokensOnLine.nextToken();
                       X = new Integer(tThisToken).intValue();

                       tThisToken = tTokensOnLine.nextToken();
                       Y = new Integer(tThisToken).intValue();
                       VALID=true;
                   }
                   catch(NumberFormatException e){
                       System.out.println("Invalid Co-ordinate");

                   }
                   catch(NoSuchElementException e){
                       System.out.println("Invalid Co-ordinate");
                   }
               }
           }
           
           if (X==9 && Y==9){
               GAME_OVER=true;
               System.exit(1);
           }

           if (!OverlapError(aGrid,X,Y)) {
               
               if (NoughtGo){
                   aGrid[X-1][Y-1]=-1;
                   NoughtGo=false;
                   tTeam = "Cross";
               }
               else{
                   aGrid[X-1][Y-1]=1;
                   NoughtGo=true;
                   tTeam="Nought";
                   
               }
               printgrid(aGrid);
               checkmove(aGrid);

               TURN_NUMBER++;
               if (TURN_NUMBER == 9){
                   System.out.println("Game Over - It's a Draw");
                   System.exit(1);
               }
           }else{
               System.out.println("Illegal move - try again");
           }
        }

    if(GAME_OVER){
        GameOverProc();
    }
}

    public static void printgrid(int[][] aGrid)
        {
            for (int rows=2; rows>=0; rows--){
                System.out.print("* ");
                for (int columns=0; columns<3; columns++){
                    if ((aGrid[columns][rows]) == -1)
                        {
                            System.out.print(" 0");
                        }
                    else if((aGrid[columns][rows]) == 1)
                        {
                            System.out.print(" X");
                        }
                    else{
                        System.out.print(" -");
                    }
                }
                System.out.println();
            }
            System.out.println("   1 2 3");
        }


    public static void checkmove(int[][] aGrid)
        {
                //checks for vertical lines - honest!
            for (int rows=2; rows>=0; rows--){
                int tCheck = (aGrid[rows][0]) + (aGrid[rows][1]) + (aGrid[rows][2]);
                if (tCheck == -3 || tCheck == 3){
                    System.out.println("Orrrh Yes! Game Over");
                    GAME_OVER=true;
                }
            }
            
                //checks horizontal lines
            for (int columns=2; columns>=0; columns--){
                int tCheck = (aGrid[0][columns]) + (aGrid[1][columns]) + (aGrid[2][columns]);
                 if (tCheck == -3 || tCheck == 3){
                    System.out.println("Game Over");
                    GAME_OVER=true;
                 }
            }

            if (aGrid[0][0] == 1 && aGrid[1][1] == 1 && aGrid[2][2] == 1){
                    System.out.println("Game Over");
                    GAME_OVER=true;
                }

            if (aGrid[2][0] == 1 && aGrid[1][1] == 1 && aGrid[0][2] == 1){
                    System.out.println("Game Over");
                    GAME_OVER=true;
                }

            if (aGrid[0][0] == -1 && aGrid[1][1] == -1 && aGrid[2][2] == -1){
                    System.out.println("Game Over");
                    GAME_OVER=true;
                }

            if (aGrid[2][0] == -1 && aGrid[1][1] == -1 && aGrid[0][2] == -1){
                    System.out.println("Game Over");
                    GAME_OVER=true;
                }            
        }


    public static boolean OverlapError(int[][] aGrid, int X,int Y)
        {
            if ((aGrid[X-1][Y-1])==0){
                return false;
            }
            else{
                return true;
            }
        }

    public static void GameOverProc()
        {
            System.out.println("Game Over " + tTeam + " Won!");
        }
 }