public class Stone
{
    private char symbol;
    
    public Stone(char symbol)
    {
        this.symbol = symbol;
    }
    
    public void setSymbol(char symbol)
    {
        this.symbol = symbol;
    }
    
    public char getSymbol()
    {
        return symbol;
    }
    
    public String toString()
    {
        String  str = "";
        if(symbol != ' ')
            str = "" + symbol;
        return str;
    }
}
