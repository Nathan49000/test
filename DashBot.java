import java.util.Random;
/**
 * Décrivez votre classe RobotCombat ici.
 *The DashBot is just a basical robot that can move 1 square by 1. 
 * He also has a little probability to move of 3 square 
 * @Nicolas Bonneau
 * @Group 5 01/11/2023
 */
public class DashBot extends Robot
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int xPos = getXPosition();
    private int yPos = getYPosition();
    private int Max = getMaxPosition();
    private Random random = new Random();
    private double proba;
    /**
     * Constructeur d'objets de classe DashBot
     */
    public DashBot()
    {
        // initialisation des variables d'instance
        setColourBody("RED");
        
    }
    
    /**
     * Method that give that choose randomly the type of movement of the bot in function of a probability
     */
    public void move(){
        
        proba = random.nextDouble();
        //System.out.println(proba);
        if (proba > 0.3 ) {
            yPos ++;
            xPos ++;
            if (xPos > Max || yPos > Max){
                yPos --;
                xPos --;
            }else {
                redrawR();
            }  
        }else if(proba > 0.25 && proba <= 0.3){
            dashDiagBas();
        }else if(proba > 0.20 && proba <= 0.25){
            dashDiagHaut();
        }else if(proba > 0.15 && proba <= 0.20){
            dashBas();
        }else if(proba > 0.10 && proba <= 0.15){
            dashHaut();
        }else if(proba > 0.05 && proba <= 0.10){
            dashGauche();
        }else if(proba > 0 && proba <= 0.05){
            dashDroite();
        }
        
    }
    
    /**
     * Robot can dash up
     */
    public void dashHaut()
    {
        if (xPos < Max && yPos < Max) {
        
            yPos -= 3;
            if (yPos > 0){
            setYPosition(yPos);
            redrawR();
            }else{ yPos += 3;
            }
        }
    }
    
    /**
     * Robot can dash down
     */
    public void dashBas()
    {
        if (xPos < Max && yPos < Max) {
        
            yPos += 3;
            if (yPos < Max){
            setYPosition(yPos);
            redrawR();
            }else{ yPos -= 3;
            }
        }
    }
    
    /**
     * Robot can dash right
     */
    public void dashDroite()
    {
        if (xPos < Max && yPos < Max) {
        
            xPos += 3;
            if (xPos < Max){
               setXPosition(xPos);
               redrawR(); 
            }else{
                xPos -= 3;
            }
        }
    }
    
    /**
     * Robot can dash left
     */
    public void dashGauche()
    {
        if (xPos < Max && yPos < Max) {
        
            xPos -= 3;
            if (xPos > 0){
               setXPosition(xPos);
               redrawR(); 
            }else{
                xPos += 3;
            }
        }
    }
    
    /**
     * Robot can dash in diagonal down
     */
    public void dashDiagBas()
    {
        if (xPos < Max && yPos < Max) {
        
            xPos += 3;
            yPos += 3;
            if (xPos > Max || yPos > Max){
            xPos -= 3;
            yPos -= 3;
            }else {
                setXPosition(xPos);
                setYPosition(yPos);
                redrawR();
            }
        }
    }
    
    /**
     * Robot can dash in diagonal up
     */
    public void dashDiagHaut()
    {
        if (xPos < Max && yPos < Max) {
        
            xPos -= 3;
            yPos -= 3;
            if (xPos < 0 || yPos < 0){
            xPos += 3;
            yPos += 3;
            }else {
                setXPosition(xPos);
                setYPosition(yPos);
                redrawR();
            }
        }
    }
    
    /**
     * Draw the robot at X and Y position
     */
    public void redrawR()
    {
        getCanvasRobot().drawRobot(xPos,yPos);
    }
}