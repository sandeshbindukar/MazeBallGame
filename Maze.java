import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Maze here.
 * 
 * @author (Sandesh Bindukar) 
 * @version (a version number or a date)
 */
public class Maze extends World
{
    Counter counter = new Counter(); /** Get information from Counter Actor Class */
    
    /**
     * Constructor for objects of class Maze.
     * 
     */

    public Maze() /** Whole maze scenario */
    {    
        /** Create a new world with 600x400 cells with a cell size of 1x1 pixels. */
        super(1000, 850, 1); 
        for (int loop=40;loop<960;loop=loop+60)
        {
            addObject(new sandroad(), loop,50);
            addObject(new sandroad(), loop,230);
            addObject(new sandroad(), loop,410);
            addObject(new sandroad(), loop,590);
            addObject(new sandroad(), loop,770);
            for (int loop_2=0;loop_2<=1;loop_2=loop_2+1)
            {
                addObject(new sandroad(), 100,110+(loop_2*60));
                addObject(new sandroad(), 340,110+(loop_2*60));
                addObject(new sandroad(), 580,110+(loop_2*60));
                addObject(new sandroad(), 160,290+(loop_2*60));
                addObject(new sandroad(), 400,290+(loop_2*60));
                addObject(new sandroad(), 700,290+(loop_2*60));
                addObject(new sandroad(), 100,470+(loop_2*60));
                addObject(new sandroad(), 340,470+(loop_2*60));
                addObject(new sandroad(), 760,470+(loop_2*60));
                addObject(new sandroad(), 160,650+(loop_2*60));
                addObject(new sandroad(), 400,650+(loop_2*60));
            }
        }
        addObject(new Goal(), 40,770);
        addObject(new GoldenBall(),940 ,50);

        prepare(); //call private method
    }
    
    public Counter getCounter()
    {
        return counter; //return counter variable
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(counter,165,95); //add counter actor in the maze 
        Skull skull = new Skull();
        addObject(skull,760,228); //add skull actor in the maze
        Skull skull2 = new Skull();
        addObject(skull2,280,49);
        Skull skull3 = new Skull();
        addObject(skull3,220,411);
        Pear pear = new Pear();
        addObject(pear,648,56); //add pear actor in the maze
        pear.setLocation(639,50);
        Pear pear3 = new Pear();
        addObject(pear3,460,230);
        Pear pear4 = new Pear();
        addObject(pear4,520,412);
        Pear pear5 = new Pear();
        addObject(pear5,339,592);
        Pear pear6 = new Pear();
        addObject(pear6,520,771);
        Pear pear7 = new Pear();
        addObject(pear7,221,771);
        
    }
}
