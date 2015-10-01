import java.util.Scanner;

public class UI
{
    private Scanner keyboard = new Scanner(System.in);
    public int inputCombination()
    {
        System.out.print("Enter combination for the treasure chest (5-10): ");
        int number = keyboard.nextInt();
        keyboard.nextLine();
        return number;
    }
    
    public int inputMove()
    {
        System.out.print("Enter Maximum allowed moves: ");
        int number = keyboard.nextInt();
        keyboard.nextLine();
        return number;
    }
    
    public String inputString()
    {
        System.out.print("Enter player name: ");
        return keyboard.nextLine();
    }
    
    public char inputChar()
    {
        System.out.print("Move (l/r/p/d): ");
        return keyboard.nextLine().charAt(0);
    }
    
    public void outputCombination()
    {
        System.out.println("Invalid combination.");
    }
    
    public void outputWin()
    {
        System.out.println("You unlocked the treasure!");
    }
    
    public void outputLose()
    {
        System.out.println("You lose.");
    }
}
