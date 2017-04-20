/**
 * 
 */

package puzzle;

import java.util.Comparator;

/**
 * @author Marvin Jerremy Budiman (13515076).
 *
 */
public class PuzzleNodeComparator implements Comparator<PuzzleNode> {
  @Override
  public int compare(PuzzleNode pn1, PuzzleNode pn2) {
    if (pn1.getCost() < pn2.getCost()) {
      return -1;
    } else if (pn1.getCost() > pn2.getCost()) {
      return 1;
    }
    return 0;
  }
}
