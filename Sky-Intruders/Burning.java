import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Burning here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Burning extends Actor
{
    /**
     * Act - do whatever the Burning wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage image;
    
    public Burning() {
        imageSetup();
    }
    
    private void imageSetup() {
        image = getImage();
        image.scale(image.getWidth()*3, image.getHeight()*3);
        setImage(image);
    }
}
