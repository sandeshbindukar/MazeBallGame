import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Skull here.
 * 
 * @author (Sandesh Bindukar) ) 
 * @version (a version number or a date)
 */
public class Skull extends Actor
{
    /**
     * Act - do whatever the Skull wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(5); /** Move forward. */
        Return(); /** Call return method. */ 
    }
    public void Return()
    {
        if(getX() <=0 || getX() >= getWorld().getWidth()-1 )
        {
            turn(90); /** turn 90 degree. */
            move(-5); /**  move backward. */
        }
    }
}

