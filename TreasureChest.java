public class TreasureChest
{
    private int combination;
    private StringBuffer treasureChest = new StringBuffer();
    
    public TreasureChest(int combination)
    {
        this.combination = combination;
    }

    public void setTreasureChest(char symbol)
    {
        treasureChest.append(symbol);
    }
    
    public char getTreasureChest()
    {
        int length = treasureChest.length();
        if(length != 0)
        {
            char symbol = treasureChest.charAt(length - 1);
            treasureChest.delete(length - 1, length);
            return symbol;
        }
        else
            return ' ';
    }
    
    public boolean isCorrect()
    {
        if(treasureChest.length() == 4)
            return (combination == ((getNumber(treasureChest.charAt(0)) + getNumber(treasureChest.charAt(1)))*getNumber(treasureChest.charAt(2))));
        return false;
    }
    
    public int getNumber(char symbol)
    {
        int num = 0;
        switch(symbol)
        {
            case '#':
                num = 1;
                break;
            case '@':
                num = 2;
                break;
            case '%':
                num = 3;
                break;
            case '$':
                num = 4;
                break;
            default:
                break;
        }
        return num;
    }
    
    public String toString()
    {
        return "Treasure/" + combination + "\\" + "(5)";
    }
}
