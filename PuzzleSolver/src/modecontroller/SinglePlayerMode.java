/**
 * 
 */

package modecontroller;

import java.awt.BorderLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class SinglePlayerMode extends FrameMode {
  /**
   * Konstruktor kelas SingleModeFrame.
   */
  public SinglePlayerMode() {
    super();
    add(player1, BorderLayout.CENTER);
  }
  
  @Override
  public void startGame() {
    player1.enablePlayer(true);
    player1Thread.start();
    TimerTask gameMonitor = new GameMonitor();
    monitorTimer = new Timer(true);
    monitorTimer.scheduleAtFixedRate(gameMonitor, 0, 100);
  }
  
  private class GameMonitor extends TimerTask {
    @Override
    public void run() {
      // TODO Auto-generated method stub
      statusLabel.setText("Player 1 is active");
      if (!player1.isRunning()) {
        monitorTimer.cancel();
        statusLabel.setText("Player 1 finished the puzzle");
      }
    }
  }

  @Override
  public void endGame() {
    // TODO Auto-generated method stub
    player1.setRunningState(false);
  }
}
