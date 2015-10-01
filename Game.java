public class Game
{
    private Player player;
    private Stone s1 = new Stone('#');
    private Stone s2 = new Stone('@');
    private Stone s3 = new Stone('%');
    private Stone s4 = new Stone('$');
    private TreasureChest treasureChest;
    private UI ui = new UI();
    private int allowedMove;
    private boolean holding = false;
    
    public Game()
    {
        int combination = 0;
        do{
            combination = ui.inputCombination();
            if(combination <5 || combination >10)
                ui.outputCombination();
        }while(combination < 5 || combination > 10);
        treasureChest = new TreasureChest(combination);
        allowedMove = ui.inputMove();
        player = new Player(ui.inputString());
    }

    public String toString()
    {
        return player.toString() + s1.toString() + "(1) " + s2.toString() + "(2) " + s3.toString() + "(3) " + s4.toString() + "(4) " + treasureChest.toString();
    }
    
    public void turn()
    {
        char move = ui.inputChar();
        int position = player.getPosition();
        char symbolP = player.getHoldingStone();
        if(move == 'r' || move == 'l')
        {
            player.setPosition(move);
            allowedMove--;
        }
        else if((move == 'p' && holding == false) || ((move == 'd' && holding == true)))
        {
            switch(position)
            {
                case 1:
                    pickNDrop(s1, move, symbolP);
                    break;
                case 2:
                    pickNDrop(s2, move, symbolP);
                    break;
                case 3:
                    pickNDrop(s3, move, symbolP);
                    break;
                case 4:
                    pickNDrop(s4, move, symbolP);
                    break;
                case 5:
                    if(move == 'p')
                    {
                        char symbolTC = treasureChest.getTreasureChest();
                        if(symbolTC != ' ')
                            change(symbolTC);
                    }
                    else
                    {
                        treasureChest.setTreasureChest(symbolP);
                        change(' ');
                    }
                    break;
                default:
                    break;
            }
        }
    }
    
    public void pickNDrop(Stone s, char move, char symbolP)
    {
        char symbolS = s.getSymbol();
        if(symbolS != ' ' && move == 'p')
        {
            s.setSymbol(' ');
            change(symbolS);
        }
        else if(symbolS == ' ' && move == 'd' && symbolP != ' ')
        {
            s.setSymbol(symbolP);
            change(' ');
        }
    }
    
    public void change(char symbol)
    {
        player.setHoldingStone(symbol);
        holding = !holding;
        allowedMove--;
    }
    
    public boolean isOver()
    {
        return (treasureChest.isCorrect() || allowedMove == 0);
    }
    
    public void play()
    {
        while(!isOver())
        {
            System.out.println(toString());
            turn();
        }
        System.out.println(toString());
        if(treasureChest.isCorrect())
            ui.outputWin();
        else
            ui.outputLose();
    }
}
