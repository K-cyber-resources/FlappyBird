import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @version (a version number or a date)
 */
public class Score extends Actor
{

    public Score()
    {
        GreenfootImage newImage = new GreenfootImage(100, 50);
        setImage(newImage);
    }

    public void setScore(int score)
    {
        GreenfootImage newImage = getImage();
        newImage.clear();

        greenfoot.Color c = new greenfoot.Color(127, 127, 127, 127);
        newImage.setColor(c);
        newImage.fillRect(0, 0, newImage.getWidth(), newImage.getHeight());
        newImage.setColor(greenfoot.Color.BLACK);
        newImage.drawString("" + score, 30, 30);
        setImage(newImage);
    }
}