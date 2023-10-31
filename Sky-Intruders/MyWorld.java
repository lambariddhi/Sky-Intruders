import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    GreenfootImage image1;
    
    private int time_left = 10000;
    private int score = 0;
    
    private int dragon_x = (new Dragon()).getImage().getWidth()/6;
    private int dragon_y = (new Dragon()).getImage().getHeight()/6;
    
    Sky sky = new Sky();
    
    GreenfootSound PirateSong = new GreenfootSound("Pirates.mp3");
    GreenfootSound Skyfall = new GreenfootSound("James Bond - Skyfall.mp3");
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        prepare();
        
        ReadyText();
        ReadyBackground();
    }
    
    public void prepare() {
        Castle1 castle1 = new Castle1();
        addObject(castle1,90,225);
        Pegasus pegasus = new Pegasus();
        addObject(pegasus,226, 180);
        Dragon dragon1 = new Dragon();
        addObject(dragon1, 560-dragon_x, (Greenfoot.getRandomNumber(390-2*dragon_y)+dragon_y));
    }

    private void ReadyText() {
        addObject(sky, 300, 200);
        showText("Welcome!\n\nYour mission is to defend the Sky Castle of the noble Alicorns\nfrom the dread invaders the Dracos.\n\nPress the space bar to fire spells at the Dracos...\n...but beware that it takes time for your powers to recharge\nand that each misfired shot costs you points,\nso you MUST hit a dragon on the first shot to play!\n\n", 300, 200);
    }
    
    private void ReadyBackground() {
        setBackground("Sky.png");
        image1 = getBackground();
        image1.scale(getBackground().getWidth(), getBackground().getHeight());
        setBackground(image1);
    }
    
    public void act() {
        ridOpening();
        playGameMusic();
        showText("Time Left: " + time_left, 90, 375);
        showText("Score: " + score, 545, 375);
        spawnDragons();
        checkEnd();
        time_left --;
    }
    
    private void ridOpening() {
        if (time_left == 10000) {
            removeObject(sky);
            showText(null, 300, 200);
        }   
    }    
    
    private void playGameMusic() {
        if (Skyfall.isPlaying()) {
            Skyfall.stop();
        }
        PirateSong.playLoop();
        PirateSong.setVolume(100);
    }
    
    private void spawnDragons() {
        Dragon dragon = new Dragon();
        
        if (Greenfoot.getRandomNumber(95)<1) {
            addObject(dragon, 560-dragon_x, (Greenfoot.getRandomNumber(390-2*dragon_y)+dragon_y));
        }
    }
    
    public void checkEnd() {
        if (time_left == 0) {
            Victory victory = new Victory();
            addObject(victory, 300, 200);
            showText("Time Left: " + time_left, 90, 375);
            showText("The Dracos have no choice but to flee!\nYou've saved the Sky Castle!\n\nScore: "+score, 300, 200);
            Greenfoot.playSound("fanfare.wav");
            Greenfoot.stop();
        }
        
        if (score < 0) {
            showText("Game Over!", 300, 200);
            PirateSong.stop();
            Greenfoot.playSound("tf_nemesis.mp3");
            Greenfoot.stop();
        }
    }
    
    public void updateScore(int scoreChange) {
        score += scoreChange;
    }
    
    public int timeLeft() {
        return time_left;
    }
}
