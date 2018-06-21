
package robot_world;

import java.io.IOException;


import java.util.Stack;

public class SuperRobotWorld extends RobotWorld {

	// TODO: Add some fields to keep track of commands
	Stack<Character> undos = new Stack<Character>();
    Stack<Character> redos = new Stack<Character>();
    
    public SuperRobotWorld(String mapFile) throws IOException {
        super(mapFile);
    }
    
    @Override
    public void rotateClockwise() {
      super.rotateClockwise();
      undos.push('c');
    }
    
    @Override
    public void rotateCounterClockwise() {
      super.rotateCounterClockwise();
      undos.push('a');
    }

    @Override
    public void moveForward() throws Exception {
      super.moveForward();
      undos.push('m');
    }
    
    /**
     * Undo the last move or rotation command that put the robot
     * in its current state.  If no commands have been issued yet,
     * do nothing.
     */
    public void undoCommand() {
        if (undos.size() != 0) {
          char command = undos.pop();
          redos.push(command);
          if (command == 'c')
          super.rotateCounterClockwise();
          else if (command == 'a')
          super.rotateClockwise();
          else if (command == 'm'){
        	try {
          super.rotateClockwise();
          super.rotateClockwise();
          super.moveForward();
          super.rotateClockwise();
          super.rotateClockwise();
          }catch(Exception ex) {}
    }}
    }
      
    
    public void undoCommands(int n) {
    	if (n != 0) {
    	  for (int i = 0; i < n; i++) {
    		undoCommand();
    	  }
    	}
    }
    
    /**
     * For previously undone commands, redo the last command that was
     * undone
     */
    public void redoUndoneCommand() {
        if (redos.size() != 0) {
          char command = redos.pop();
          undos.push(command);
            if (command == 'c')
            super.rotateCounterClockwise();
            else if (command == 'a')
            super.rotateClockwise();
            else
          	try {
            super.moveForward();}catch(Exception ex) {}
        }
    }
    
    public void redoUndoneCommands(int n) {
      if (n != 0) {
  	  for (int i = 0; i < n; i++) {
  		redoUndoneCommand();
  	  }
  	}
  }
}
