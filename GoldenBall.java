import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class GoldenBall here.
 * 
 * @author (Sandesh Bindukar) 
 * @version (a version number or a date)
 */
public class GoldenBall extends Actor
{
    /**
     * Act - do whatever the GoldenBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        key(); /**Check which keys are pressed and move appropriately.*/ 
        checkFall(); /** Check for fall. */
        eatPears(); /** Eat Pears */
        die(); /** Game Over */
        win();  /** Win if GoldenBall reaches Goal. */
    }    

    public boolean canMove(int x, int y) /** Checks if there is a block you can move to. */
    {
        Actor sand; /** Create Actor sand. */
        sand=getOneObjectAtOffset(x,y,sandroad.class); /** Detect if Actor sand is intersecting with GoldenBall */
        //the section below checks if there is a block you can move to
        // if there is it sets sand to a vlaue otherwise it says null
        boolean flag=false; /** Default setting for flag.(Value is null) */
        if (sand !=null) /** If sandroad is detected. */
        {
            flag=true; /** Move */
        }
        return flag;  /** Returns the value. */
    }

    public void key() /** Moves GoldenBall in the direction of arrow pressed. */
    {
        /** Note 1: Down the page increase the y value and going to the right increases the x value */
        /** Note 2: Each block is 60 pixels wide and high */
        int leftChange=-60; /** leftChange Variable */
        int rightChange=60; /** rightChange Variable */
        int upChange=-60;  /** upChange Variable */
        int downChange=60; /** downChange Variable */
        if (Greenfoot.isKeyDown("left")) /** Check if left arrow is pressed. */
        {
            if (canMove(leftChange, 0)==true){
                setLocation(getX()+leftChange, getY()) ;} /** Decrease position on X-axis to move left. */
        }
        if (Greenfoot.isKeyDown("right")) /** Check if right arrow is pressed. */
        {
            if (canMove(rightChange, 0)==true){
                setLocation(getX()+rightChange, getY()) ;} /** Increase position on X-axis to move right. */
        }
        if (Greenfoot.isKeyDown("up")) /** Check if up arrow is pressed */
        {
            if (canMove(0, upChange)==true){
                setLocation(getX(), getY()+upChange) ;} /** Decrease position on Y-axis to move upwards. */
        }
        if (Greenfoot.isKeyDown("down")) /** Check if down arrow is pressed. */
        {
            if (canMove(0, downChange)==true){
                setLocation(getX(), getY()+downChange) ;} /** Increase position on Y-axis to move downwards. */
        }
    }

    public void checkFall() /** Fall if there is a block GoldenBall can move to.*/
    {
        int downChange=60; /** downChange Variable */
        if (canMove(0,downChange)==true)
        {
            Greenfoot.playSound("drop.wav"); /** Play Sound */
            Greenfoot.delay(1); /** Delay One second. */
            setLocation(getX(), getY()+downChange); /** Increase position on Y-axis to move downwards. */
        }
    }

    public void  eatPears() /** Eat pears if GoldenBall touches it. */ 
    {
        Actor pear = getOneObjectAtOffset(0,0,Pear.class); /** If Pear is intersecting with GoldenBall. */
        if (pear != null) /** If pear is detected */
        {
            Greenfoot.playSound("eatpear.wav"); /** Play Sound */
            getWorld().removeObject(pear); /** Remove pear from the world */
            Maze maze  = (Maze)getWorld();  /** Get information from Maze World class. */
            Counter counter= maze.getCounter();  /** Get information from Counter Actor class. */
            counter.addScore(); /** Add Score in the Counter. */
        }
    } 

    public void die() /** Game Over if GoldenBall touches Skull. */
    {  
        Actor skull; /** Create Actor Skull. */
        skull = getOneIntersectingObject( Skull.class); /** If Skull is intersecting with GoldenBall. */
        if (skull != null) /** If skull is detected */
        {
            GameOver gameover= new GameOver(); /** Get information from GameOver Actor class. */
            Greenfoot.playSound("gameover.wav");  /**Play Sound. */
            getWorld().addObject(gameover,545, 505);  /** Add object in the world. */
            Greenfoot.stop(); /** Stop. */

        }  
    }

    public void win()  /** Detect if touching Goal. */
    {
        Actor win; /** Create Actor Win.*/
        win=getOneObjectAtOffset(0,0,Goal.class);  /** If Goal is intersecting with GoldenBall. */
        if (win !=null) /** If goal is detected. */
        {
            Greenfoot.stop();  /** Stop. */
             Greenfoot.playSound("congratulations.wav");  /**Play Sound. */
            Congratulation congratulations= new Congratulation(); /** Get information from Congratulation Actor class. */
            getWorld().addObject(congratulations,545, 505); /** Add object in the world. */

        }

    }

}
