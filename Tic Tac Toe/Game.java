import java.util.Random;
import java.util.Scanner;
public class Game {
    public static void main(String args[])
    {
       TicTacToe t=new TicTacToe();
       HumanPlayer p1=new HumanPlayer("Shreeya",'X');
       AIPlayer p2=new AIPlayer("TAI",'O');
       Player cp;
       cp=p1;
       while(true)
       {
       System.out.println(cp.name+" turn");
       cp.makeMove();
       TicTacToe.display();
       if(TicTacToe.checkRowWin() || TicTacToe.checkColWin() || TicTacToe.checkDigWin())
       {
           System.out.println(cp.name + " has won");
           break;
       }
       else if(TicTacToe.checkDraw())
       {
           System.out.println("Game is a Draw");
           break;
       }
       else
       {
           if(cp==p1)
           {
               cp=p2;
           }
           else
           {
               cp=p1;
           }
       }
     }
    
    }
}
class TicTacToe
{
    static char[][] board;
    public TicTacToe()
    {
    board=new char[3][3];
    initBoard();
    }
  void initBoard()
  {
    for(int i=0;i<board.length;i++)
    {
        for(int j=0;j<board.length;j++)
        {
            board[i][j]=' ';
        }
     }
  }
static void display()
{
    System.out.println("-------------");
    for(int i=0; i<board.length; i++)
    {
        System.out.print("| ");
        for(int j=0; j<board.length; j++)
        {
        System.out.print(board[i][j] + " | ");    
        }
        System.out.println();
        System.out.println("-------------");
    }
}
static void placeMark(int r,int c,char m)
{
    if (r>=0 && r<=2 && c>=0 && c<=2)
    {
        board[r][c]=m;
    }
    else
    {
        System.out.println("Invalid Position");
    }
}
static boolean checkColWin()
{
    for(int j=0;j<=2;j++)
    {
      if(board[0][j] != ' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j])
      {
        return true;
       }
     
    }
     return false; 
 }
static boolean checkRowWin()
{
    for(int i=0;i<=2;i++)
    {
      if(board[i][0] != ' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2])
      {
        return true;
       }
     
    }
     return false; 
 }
static boolean checkDigWin()
{
    if(board[0][0] != ' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] ||board[0][2] != ' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0])
      {
        return true;
       }
      else
      {
          return false;
      }
 }
 static boolean checkDraw()
 {
     for(int i=0;i<=2;i++)
     {
         for(int j=0;j<=2;j++)
         {
             if(board[i][j]== ' ')
             {
                 return false;
             }
         }
     }
     return true;
 }
}
abstract class Player
{
   String name;
    char m; 
    abstract void makeMove();
    boolean isValidMove(int r,int c)
    {
        if(r>=0 && r<=2 && c>=0 && c<=2)
        {
          if(TicTacToe.board[r][c]==' ')
          {
              return true;
          }
        }
        return false;
    }
    
}
class HumanPlayer extends Player
{
    
    HumanPlayer(String name,char m)
    {
        this.name=name;
        this.m=m;
    }
    void makeMove()
    {
        Scanner scan = new Scanner(System.in);
        int row;
        int col;
        do{
        System.out.println(" \n Enter the row and col");
        row=scan.nextInt();
        col=scan.nextInt();
        }while(!isValidMove(row,col));
        TicTacToe.placeMark(row,col,m);
    }
    
}
class AIPlayer extends Player
{
    AIPlayer(String name,char m)
    {
        this.name=name;
        this.m=m;
    }
    void makeMove()
    {
        Scanner scan= new Scanner(System.in);
        int row;
        int col;
        do{
        Random ra= new Random();
        row=ra.nextInt(3);
        col=ra.nextInt(3);
        }while(!isValidMove(row,col));
        TicTacToe.placeMark(row,col,m);
    }
    
    
}
