import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Counter here.
 * 
 * @author (Sandesh Bindukar) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    int score=0; /** Initial score variable */
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void Act() 
    {
        setImage(new GreenfootImage("Score :" + score, 20, Color.GREEN, Color.BLACK)); 
        /** Display Score Counter in the world. */
    }
    public Counter()
    {
        Act(); /** Call act method. */
    }
    public void addScore() /** Score Counter */
    {
        score++; /** Increase score with 1. */
        Act(); /** Call act method. */
    }
}
