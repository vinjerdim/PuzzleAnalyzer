/**
 * 
 */

package playercontroller;

import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import model.Puzzle;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class HumanPlayer extends PlayerController {
  /**
   * 
   * @param p Puzzle yang akan diselesaikan.
   */
  public HumanPlayer(Puzzle p) {
    super(p);
    movementLabel.setText("Movement(s): " + board.getMovementCount());
  }
 
  @Override
  public void run() {
    TimerTask showMovement = new ShowMovement();
    showTimer = new Timer("Timer" + playerId, true);
    showTimer.scheduleAtFixedRate(showMovement, 0, 10);
    super.run();
  }
  
  private class ShowMovement extends TimerTask {
    @Override
    public void run() {
      // TODO Auto-generated method stub
      movementLabel.setText("Movement(s): " + board.getMovementCount());
    }
  }
}