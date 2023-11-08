import java.lang.*;
import java.util.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Décrivez votre classe RobotCamouflage ici.
 * ce robot va longe le canvas 
 * @author Abigaël FUENTES 
 * @version 31/10/23
 */
public class RobotCamouflage extends Robot
{
    // variables d'instance 
    private int x = getXPosition();
    private int y = getYPosition(); 

    /**
     * Constructeur d'objets de classe RobotCamouflage
     */
    public RobotCamouflage()
    {
        setColourBody("GREEN");
    }
    
    public void move() {
        // si est sur un côté du canvas il va juste longer le canvas toujours dans le même sens 
    if (x == 0 && y < 11) {
        System.out.println(getYPosition() + 1);
        System.out.println(getWorld().canItMove(getXPosition(), (getYPosition() + 1)));
        if(getWorld().canItMove(getXPosition(), (getYPosition() + 1))){
            y++;
            setYPosition(y);
        }
    } else if (y == 11 && x < 11) {
        if(getWorld().canItMove((getXPosition() + 1), (getYPosition()))){
            x++;
            setXPosition(x);
        }
    } else if (x == 11 && y > 0) {
        if(getWorld().canItMove(getXPosition(), (getYPosition() - 1))){
            y--;
            setYPosition(y);
        }
    } else if (y == 0 && x > 0) {
        if(getWorld().canItMove((getXPosition() -1), (getYPosition()))){
            x--;
            setXPosition(x);
        }
        //si le robot apparer au milieu du canvas il va chercher à rejoindre un côté de celui ci
    } else if ( (y != 11) || (y!= 0) || (x!= 11) || (x!= 0)){         
        if (x<y){
            if(getWorld().canItMove(getXPosition()-1, (getYPosition()))){
                x--;
                setXPosition(x);
            }
        }else{
            if(getWorld().canItMove(getXPosition(), (getYPosition() - 1))){
                y--;
                setYPosition(y);
            }
        }
    }
    redraw();
    }

}

