import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyBird extends Actor
{
    double dy = 0;
    double g = 1.3;
    double BOOST_SPEED = -12;
    
    /**
     * Act - do whatever the FlappyBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // if we touching a pipe, then game over
        if (getOneIntersectingObject(Pipe.class) != null)
        {
            displayGameOver();
        }

        rotateFlappyBird();
        setLocation( getX(), (int)(getY()  + dy) );

        // If user presses the up key, then the bird will jump
        if(Greenfoot.isKeyDown("up") == true)
        {
            dy = BOOST_SPEED;
        }
        
        // If the bird hits the ground, then the game is over
        if(getY() > getWorld().getHeight())
        {
            displayGameOver();
        }

        dy = dy + g;
    }

    private void displayGameOver()
    {
        GameOver gameOver = new GameOver();
        getWorld().addObject(gameOver, getWorld().getWidth()/2, getWorld().getHeight()/2);
        Greenfoot.stop();
    }
    
    private void rotateFlappyBird()
    {
        if (dy >= -25 && dy <= -5)
        {
            setRotation(-30);
        }
        else if (dy >= -5 && dy <= 15)
        {
            setRotation(30);
        }
        else if (dy >= 15 && dy <= 35)
        {
            setRotation(60);
        }
    }
}
