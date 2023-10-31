import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UnicornPower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnicornPower extends Actor
{
    /**
     * Act - do whatever the UnicornPower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage image1;
    
    public UnicornPower() {
        imageSetup();
    }
    
    public void imageSetup() {
        image1 = getImage();
        image1.scale(image1.getWidth()/15, image1.getHeight()/15);
        setImage(image1);
    }
    
    public void act()
    {
        setLocation(getX() + 5, getY());
        dragonTouch();
        if (getWorld() == null) {
            return;
        }
        AtEdge();
    }
    
    public void dragonTouch() {
        if (isTouching(Dragon.class)) {
            Actor dragon = getOneIntersectingObject(Dragon.class);
        
            int dragon_x = dragon.getX();
            int dragon_y = dragon.getY();
        
            if (Math.abs(getX() - dragon_x) < image1.getWidth()/17 || Math.abs(getY() - dragon_y) < image1.getHeight()/17) {
                removeTouching(Dragon.class);
                ((MyWorld) getWorld()).updateScore(20);
                ((MyWorld) getWorld()).PirateSong.pause();
                Greenfoot.playSound("au.wav");
                ((MyWorld) getWorld()).PirateSong.play();
                getWorld().removeObject(this);
                return;
            }
        }    
    }
    
    public void AtEdge() {
        if (isAtEdge()) {
            ((MyWorld) getWorld()).updateScore(-10);
            getWorld().removeObject(this);
            return;
        }
    }
}
