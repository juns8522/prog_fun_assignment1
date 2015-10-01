public class Player
{
    private String name;
    private int position;
    private char holdingStone = ' ';
  
    public Player(String name)
    {
        this.name = name;
        this.position = 0;
    }
   
    public void setPosition(char direction)
    {
        if(direction == 'r')
            position++;
        else
            position--;
    }
    
    public int getPosition()
    {
        return position;
    }
    
    public void setHoldingStone(char holdingStone)
    {
        this.holdingStone = holdingStone;
    }
    
    public char getHoldingStone()
    {
        return holdingStone;
    }
    
    public String toString()
    {
        if(holdingStone == ' ')
            return name + "(" + position + ") ";
        else
            return name + holdingStone + "(" + position + ") ";
    }
}
