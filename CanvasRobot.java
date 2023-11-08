import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
import java.util.ArrayList;

/**
 * Draws robots on a canvas.
 * 
 * @author Patrick Girard 
 * @version 2021.08
 */
public class CanvasRobot
{
    static private Canvas canvas = Canvas.getCanvas(); 
    static private Random randomGenerator; 
    
    static private ArrayList<CanvasRobot> canvasRobotList = new ArrayList<CanvasRobot>();
    static private boolean gameOver = false;
    
    // Coordinates for redraw
    private boolean redrawable;
    private int x;
    private int y;
    
    private int n = 0;
    private int lo = 30;
    private int la = 31;
    private int plo = 8;
    private int pla = 10;
    private int tlo = 26;
    private int tla = 13;
    private int qla = 4;
    private int milieu = 240;
    static private Colour colourHead = Colour.RED;
    private Colour colourBody = Colour.RED;
    static private Colour colourLeg = Colour.BLACK;
    static private Colour colourEye = Colour.GREEN;
    private Integer corps;
    private Integer brasG;
    private Integer brasD;
    private Integer jambeG;
    private Integer jambeD;
    private Integer tete;
    private Integer oeilD;
    private Integer oeilG;

    /**
     * CanvasRobot Constructor - Creates a new graphical robot, which can be drawn. 
     * if the colour is not correct, the colour body is set to BLUE
     * The robot is not drawn at this time (no coordinates)
     *
     * @param colour body colourBody
     */
    public CanvasRobot ( String colourBody )
    {
        // The random generator is instanciated if necessary
        if (randomGenerator == null) randomGenerator = new Random();
        // The different objects of the robot are instanciated, to allow the process of identification 
        // of graphical objects in the canvas. 
        corps = new Integer(randomGenerator.nextInt());
        brasG = new Integer(randomGenerator.nextInt());
        brasD = new Integer(randomGenerator.nextInt());
        jambeG = new Integer(randomGenerator.nextInt());
        jambeD = new Integer(randomGenerator.nextInt());
        tete = new Integer(randomGenerator.nextInt());
        oeilD = new Integer(randomGenerator.nextInt());
        oeilG = new Integer(randomGenerator.nextInt());

        this.colourBody = valueOf(colourBody);
        redrawable = false;
        
        canvasRobotList.add(this);
    }
    /**
     * Draws a robot onto the canvas, on ly if not game over
     * If try do draw out of canvas or on an existing CanvasRobot => Game Over !
     * If the robot was already drawn, it is erased (thanks to Canvas)
     * stores the coordinates to allow redraw if the color changes
     *
     * @param  x,y  robot position
     */
    public void drawRobot(int x, int y)
    {
        if (!gameOver) {
            int xp = x*50 ;
            int yp = y*50 ;
            canvas.draw(brasG, colourLeg, new Rectangle(xp, yp+15, 
                                         plo, pla));
            canvas.draw(brasD, colourLeg, new Rectangle(xp+la+2, yp+15, 
                                         plo, pla));
            canvas.draw(jambeG, colourLeg, new Rectangle(xp+10, yp+40, 
                                         plo, pla));
            canvas.draw(jambeD, colourLeg, new Rectangle(xp+la-8, yp+40, 
                                         plo, pla));
            canvas.draw(tete, colourHead, new Rectangle(xp+14, yp, 
                                         tla, tlo));
            canvas.draw(oeilG, colourEye, new Ellipse2D.Double(xp+16, yp+2, 
                                         qla, qla));
            canvas.draw(oeilD, colourEye, new Ellipse2D.Double(xp+21, yp+2, 
                                         qla, qla));
            canvas.draw(corps, colourBody, new Rectangle(xp+5, yp+10, 
                                         la, lo));
            this.x = x;
            this.y = y;
            redrawable = true;
            
            if (outOfCanvas()) gameOver();                
            if (collision()) gameOver();
            
        }
    }
    
    /**
     * Method setColourBody
     * Sets the colour of the body and draw it again
     * 
     * @param colourBody the new colour
     */
    public void setColourBody(String colourBody){
        this.colourBody = valueOf(colourBody);
        if (redrawable) drawRobot(this.x, this.y);
    }
    
    /**
     * Method getColourBody
     *
     * @return The actual color of the body
     */
    public String getColourBody(){
        return colourBody.toString();
    }
    
    
    /**
     * Utilitary method valueOf
     * returns the value of the String param il enum Colour, with no sensitive letters
     * if the String is not a colour, returns "BLUE"
     *
     * @param colour the String that represents the colour
     * @return value in Colour enum
     */
    private static Colour valueOf(String colour){
       try {
            return Colour.valueOf(colour.toUpperCase());
        } catch (Exception e) {
        }
        return Colour.BLUE;
    }
    
    private boolean collision(){
        for (CanvasRobot c:canvasRobotList) 
            if ((c!=this)&&(x==c.x)&&(y==c.y)&&(c.redrawable))  
                return true;
        return false;
    }
    
    private boolean outOfCanvas() {
        if (x<0) return true;
        if (y<0) return true;
        if (x>11) return true;
        if (y>11) return true;
        return false;
    }
    
    private static void gameOver(){
        gameOver = true;
        canvas.gameOver();
    }
}