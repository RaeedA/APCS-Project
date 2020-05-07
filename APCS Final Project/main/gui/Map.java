package gui;

public class Map
{
    int[][] layout;
    
    public Map(int size)
    {
        layout = new int[size][size];
        for (int c = 0; c<size; c++)
        {
            for (int r = 0; r<size; r++)
            {
                layout[c][r] = 0;
            }
        }
    }
    
    public int[][] getLayout()
    {
        return layout;
    }
}
