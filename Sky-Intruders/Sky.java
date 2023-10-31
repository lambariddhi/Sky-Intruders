import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sky extends Actor
{
    /**
     * Act - do whatever the Sky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage image;
    
    public Sky() {
        imageSetup();
    }
    
    private void imageSetup() {
        image = getImage();
        image.scale(image.getWidth()*2, image.getHeight()*2);
        setImage(image);
    }
    
    public void act()
    {
        
    }
}
