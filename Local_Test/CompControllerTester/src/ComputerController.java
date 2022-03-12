import java.awt.*;
import java.awt.event.InputEvent;

public class ComputerController {

    //this is a change

    private Robot robot;
    //private static Point p;
    private int initialX;
    private int initialY;
    private final int AUTO_DELAY = 1000;

    public ComputerController(){

        try {
            this.robot = new Robot();

            robot.setAutoWaitForIdle(true);
            robot.setAutoDelay(100);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void init(float x, float y){
        this.initialX = (int)x;
        this.initialY = (int)y;
    }

    public void leftClickPress(){
        this.robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void leftClickRelease(){
        this.robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void singleClick(){
        leftClickPress();
        leftClickRelease();
    }

    public void doubleClick(){
        singleClick();
        singleClick();
    }

    public void rightClick(){
        this.robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        this.robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
    }

    public void scrollDown(){
        this.robot.mouseWheel(1);
    }

    public void scrollUp(){
        this.robot.mouseWheel(-1);
    }

    public void keyPress(int key) throws AWTException {
        try {
            Thread.sleep(AUTO_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Key Code: " + key);

        Robot robot = new Robot();
        robot.keyPress(key);
        robot.keyRelease(key);
    }

    public void mouseMovement(float differenceX, float differenceY){

        //p = MouseInfo.getPointerInfo().getLocation();
        //robot.mouseMove(p.x+differenceX, p.y+differenceY);
        int myAdditionX=0;
        int myAdditionY=0;

        if(Math.abs(differenceX)>3){
            myAdditionX=(int)differenceX;
        }
        if(Math.abs(differenceY)>3){
            myAdditionY=(int)differenceY;
        }

        //this.robot.mouseMove((int)(initialX+differenceX), (int)(initialY+differenceY));

        this.robot.mouseMove(initialX+myAdditionX, initialY+myAdditionY);
    }


}
