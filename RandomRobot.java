import java.util.Random;

/**
 * Le RandomRobot est un robot qui se déplace aléatoirement
 * sur une des cases adjacentes.
 *
 * @author Alexandre DUGUET
 * @version 02/11/2023
 */
public class RandomRobot extends Robot
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int x =getXPosition();
    private int y = getYPosition();
    private int Max = getMaxPosition();
    private Random randomX = new Random();
    private Random randomY = new Random();

    
    /**
     * Constructeur d'objets de classe RandomRobot
     */
    public RandomRobot()
    {
        super(); // Appel du constructeur de la classe parente (Robot)
        setColourBody("WHITE");
    }
    
    /**
     * Allows the robot to move randomly to one of the adjacent 
     * square
     *
     */
    public void move()
    {
        // Manage the random movement
        int xp = randomX.nextInt(3) - 1;
        int yp = randomY.nextInt(3) - 1;
        
        // Reset the position
        if (getWorld().canItMove(xp + x, yp + y)) {
            x = xp + x;
            setXPosition(x);        
            y = yp + y;
            setYPosition(y);  
        }

        redraw();
    }
}
