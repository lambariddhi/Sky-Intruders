import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends Actor
{
    /**
     * Act - do whatever the Dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage image1;
    
    private int y_speed = Greenfoot.getRandomNumber(5)+5;
    private int x_speed = Greenfoot.getRandomNumber(20)+30;
    
    public Dragon() {
        imageSetup();
    }
    
    private void imageSetup() {
        image1 = getImage();
        image1.scale(getImage().getWidth()/6, getImage().getHeight()/6);
        setImage(image1);
    }
    
    public void act()
    {
        setLocation(getX(), getY() + y_speed);
        
        AtEdge();
        
        checkDragonEnd();
    }
    
    private void AtEdge() {
        if (isAtEdge()) {
            y_speed *= -1;
            
            setLocation(getX() - x_speed, getY());
        }
    }
    
    private void checkDragonEnd() {
        if (isTouching(Castle1.class)) {
            Actor castle = getOneIntersectingObject(Castle1.class);
            int castle_x = castle.getX();
            int castle_y = castle.getY();
            
            if (Math.abs(getX()-castle_x) < image1.getWidth()/7 || Math.abs(getY()-castle_y) < image1.getHeight()/7) {
                ((Castle1) castle).End();
                ((MyWorld) getWorld()).PirateSong.stop();
                Greenfoot.playSound("Dragon_Roar.wav");
                Greenfoot.playSound("James Bond - Skyfall.mp3");
                getWorld().showText("Game Over!", 300, 200);
                EvilDragon();
                Greenfoot.stop();
            }
        }
    }
    
    public void EvilDragon() {
        Burning burning_sky = new Burning();
        getWorld().addObject(burning_sky, 300, 200);
        
        Dragon dragon = new Dragon();
        getWorld().addObject(dragon, 300, 210);
        GreenfootImage dragon_image = dragon.getImage();
        dragon_image.scale(dragon_image.getWidth()*6, dragon_image.getHeight()*6);
        dragon.setImage(dragon_image);
    }
}
