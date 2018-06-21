
package robot_world;

public class Tester {
    
    public static void main(String[] args) throws Exception {
        
        RobotWorld rw = new RobotWorld("src/robot_world/map1.txt");
        rw.printCurrentWorldMap();
        
        rw.moveForward();
        rw.printCurrentWorldMap();
        
        rw.rotateClockwise();
        rw.printCurrentWorldMap();
        
        for (int i = 0; i < 5; i++) {
        	rw.moveForward();
        	rw.printCurrentWorldMap();
        }
    }
}
