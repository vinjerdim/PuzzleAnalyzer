/**
 * 
 */

package playercontroller;

import java.awt.BorderLayout;
import java.util.Timer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Puzzle;
import view.Board;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class PlayerController extends JPanel implements Runnable {
  public static int playerCount = 0;
  protected Board board;
  protected Timer showTimer;
  protected JLabel movementLabel;
  protected int playerId;
  private volatile boolean runningState;
  
  public PlayerController(Puzzle p) {
    playerCount++;
    playerId = playerCount;
    board = new Board(p);
    movementLabel = new JLabel();
    setRunningState(true);
    
    setLayout(new BorderLayout());
    add(movementLabel, BorderLayout.PAGE_START);
    add(board, BorderLayout.CENTER);
    
    setVisible(true);
  }
  
  public Board getBoard() {
    return board;
  }
  
  public Timer getShowTimer() {
    return showTimer;
  }
  
  public JLabel getMovementLabel() {
    return movementLabel;
  }
  
  public int getPlayerID() {
    return playerId;
  }
  
  public boolean isRunning() {
    return runningState;
  }
  
  public void setRunningState(boolean state) {
    runningState = state;
  }
  
  public void enablePlayer(boolean enabled) {
    board.setTilesEnabled(enabled);
  }
  
  @Override
  public void run() {
    // TODO Auto-generated method stub
    while (isRunning()) {
      if (board.isFinished()) {
        setRunningState(false);
      }
    }
    showTimer.cancel();
  }
}