package sw.builder.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import sw.builder.gui.layout.BuilderLayoutManager;
import sw.builder.gui.layout.LevelBuilderView;
/**
 * @author scyevchak
 */
/** Controller for the save button. */
public class SaveButtonController implements ActionListener {
	/** The view currently displayed. */
	BuilderLayoutManager blm;
	/** The fields to be saved. */
	LevelBuilderView lbv;
	/**
	 * Constructor for the save button controller.
	 * @param blm the current view.
	 * @param lbv the fields to save.
	 */
	public SaveButtonController(BuilderLayoutManager blm, LevelBuilderView lbv) {
		this.blm = blm;
		this.lbv = lbv;
	}
	/**
	 * Save the current data entered in the fields.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		int level = lbv.getLvlField();
		String mode = lbv.getModeList();
		int moves = lbv.getMoveField();
		int time = lbv.getTimeField();
		int swap = lbv.getSwapField();
		int shuffle = lbv.getShuffleField();
		int remove = lbv.getRemoveField();
		int onePer = lbv.getOnePercent();
		int twoPer = lbv.getTwoPercent();
		int threePer = lbv.getThreePercent();
		int fourPer = lbv.getFourPercent();
		int fivePer = lbv.getFivePercent();
		int sixPer = lbv.getSixPercent();
		int monePer = lbv.getOneMultPercent();
		int mtwoPer = lbv.getTwoMultPercent();
		int mthreePer = lbv.getThreeMultPercent();
		String[][] board = lbv.getBoard();
		int oneStar = lbv.getOneStar();
		int twoStar = lbv.getTwoStar();
		int threeStar = lbv.getThreeStar();

		if (level == -1 || moves == -1 || time == -1 || swap == -1
				|| shuffle == -1 || remove == -1 || onePer == -1
				|| twoPer == -1 || threePer == -1 || fourPer == -1
				|| fivePer == -1 || sixPer == -1 || monePer == -1
				|| mtwoPer == -1 || mthreePer == -1 || oneStar == -1
				|| twoStar == -1 || threeStar == -1) {
			return;
		}
		try {

			PrintWriter save = new PrintWriter(
					"./src/sw/resource/levelData/level" + level + ".txt");
			save.println(level);
			save.println(mode);
			save.println(moves);
			save.println(time);
			save.println(swap);
			save.println(shuffle);
			save.println(remove);
			save.println(onePer);
			save.println(twoPer);
			save.println(threePer);
			save.println(fourPer);
			save.println(fivePer);
			save.println(sixPer);
			save.println(monePer);
			save.println(mtwoPer);
			save.println(mthreePer);
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					save.print(board[j][i]);
				}
				save.println("");
			}
			save.println(oneStar);
			save.println(twoStar);
			save.println(threeStar);
			save.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
