import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Castle1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Castle1 extends Actor
{
    /**
     * Act - do whatever the Castle1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage image1;
    GreenfootImage image2;
    
    public Castle1() {
        imageSetup();
    }
    
    private void imageSetup() {
        image1 = getImage();
        image1.scale(image1.getWidth()/2, image1.getHeight()/2);
        setImage(image1);
        
        image2 = new GreenfootImage("Castle on Cloud - Copy.png");
        image2.scale(image2.getWidth()/2, image2.getHeight()/2);
    }
    
    public void act()
    {
        
    }
    
    public void End() {
        setImage(image2);
    }
}
