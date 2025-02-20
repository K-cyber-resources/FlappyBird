import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyBird extends Actor
{
    int dy = 0;
    int g = 1;

    public void act()
    {
        setLocation(getX(), (int) getY() + dy);
        dy = dy + g;
        if (Greenfoot.isKeyDown("up"))
        {
            dy = -15;
        }
    }
}
