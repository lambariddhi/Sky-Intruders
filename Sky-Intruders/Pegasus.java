import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pegasus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pegasus extends Actor
{
    /**
     * Act - do whatever the Pegasus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage image1;
    
    private int reload_time = 50;
    
    private boolean checkShot;
    
    public Pegasus() {
        checkShot = false;
        
        imageSetup();
    }
    
    private void imageSetup() {
        image1 = getImage();
        image1.scale(image1.getWidth()/6,image1.getHeight()/6);
        setImage(image1);
    }
    
    public void act()
    {
        move();
        shoot();
        ((MyWorld) getWorld()).checkEnd();
    }
    
    private void move() {
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY()+3);
        }
        
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY()-3);
        }
    }
    
    private void shoot() {
        if (Greenfoot.isKeyDown("space")) {
            checkShot = true;
            
            if (reload_time == 50) {
                getWorld().addObject(new UnicornPower(), getX(), getY());
                Greenfoot.playSound("Twinkle-sound-effect.mp3");
                getWorld().showText("Recharging...", 300, 200);
            }
            
            else {
                getWorld().showText("Recharging...", 300, 200);
            }
        }
        
        if (checkShot) {
            reload_time --;
        }
        
        if (reload_time == 0) {
                reload_time = 50;
                checkShot = false;
                getWorld().showText(null, 300,200);
            }
    }
}
