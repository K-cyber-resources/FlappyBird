import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyWorld extends World
{
    int pipeCounter = 0;
    int flappyCounter = 0;
    int PIPE_SPACING = 150;
    int score = 0;
    int FIRST_PIPE = 240;
    int PIPE_HEIGHT;
    Score scoreObj = null;

    /**
     * Constructor for objects of class FlappyWorld.
     * 
     */
    public FlappyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 

        // Set paint order
        setPaintOrder(Pipe.class, Score.class, FlappyBird.class, GameOver.class);
        
        // Create a Flappy Bird Object
        FlappyBird flappy = new FlappyBird();

        //add Flappy to our world
        addObject(flappy, 100, getHeight()/2);

        // Create a Score object
        scoreObj = new Score();
        scoreObj.setScore(0);
        
        // Add it to our world
        addObject(scoreObj, 100, 100);
    }

    public void act()
    {
        pipeCounter++;

        if (pipeCounter % 100 == 0)
        {
            createPipes();
        }

        if (pipeCounter >= FIRST_PIPE)
        {
            if (flappyCounter % 100 == 0)
            {
                score++;
                scoreObj.setScore(score);
            }
            flappyCounter++;
        }
    }

    private void createPipes()
    {
        // Create a new pipe
        Pipe toppipe = new Pipe();
        Pipe botPipe = new Pipe();
        
        int randomGetal = Greenfoot.getRandomNumber(170);
        GreenfootImage image = new GreenfootImage("top_pipe.png");
        PIPE_HEIGHT = image.getHeight();
        
        addObject(toppipe, getWidth(), 500-randomGetal);
        addObject(botPipe, getWidth(), 80-randomGetal);
        
        randomGetal = 0;
    }
}
