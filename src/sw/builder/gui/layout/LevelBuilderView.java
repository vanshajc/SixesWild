package sw.builder.gui.layout;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sw.app.gui.view.board.BoardPanel;
import sw.builder.gui.controller.CreateButtonController;
import sw.builder.gui.controller.DisplayBoardController;
import sw.builder.gui.controller.LoadButtonController;
import sw.builder.gui.controller.RandomizeButtonController;
import sw.builder.gui.controller.SaveButtonController;
import sw.common.model.entity.Board;

public class LevelBuilderView extends JPanel {

	BuilderLayoutManager blm;
	public static Board board;
	public static String[][] boardStr = new String[9][9];

	public static BoardPanel boardPanel;

	public LevelBuilderView(BuilderLayoutManager blm) {
		this.blm = blm;
		setLayout(null);

		board = new Board();
		boardPanel = new BoardPanel(board);

		initialize();
	}

	JTextField lvlField;
	JLabel lvl;
	JComboBox<String> modeList;
	JLabel move;
	JTextField moveField;
	JLabel time;
	JTextField timeField;
	JLabel swap;
	JTextField swapField;
	JLabel shuffle;
	JTextField shuffleField;
	JLabel remove;
	JTextField removeField;
	JLabel one;
	JTextField onePercent;
	JLabel two;
	JTextField twoPercent;
	JLabel three;
	JTextField threePercent;
	JLabel four;
	JTextField fourPercent;
	JLabel five;
	JTextField fivePercent;
	JLabel six;
	JTextField sixPercent;
	JLabel oneMult;
	JTextField oneMultPercent;
	JLabel twoMult;
	JTextField twoMultPercent;
	JLabel threeMult;
	JTextField threeMultPercent;
	static JTextField textFields[][];

	public void initialize() {

		lvl = new JLabel();
		lvl.setBorder(null);
		lvl.setBounds(20, 20, 35, 20);
		lvl.setText("Level:");
		add(lvl);

		lvlField = new JTextField();
		lvlField.setBounds(60, 20, 35, 20);
		lvlField.setBorder(null);
		add(lvlField);

		modeList = new JComboBox<>();
		modeList.setBounds(105, 20, 100, 20);
		modeList.setBorder(null);
		modeList.addItem("Puzzle");
		modeList.addItem("Lightning");
		modeList.addItem("Release");
		modeList.addItem("Elimination");
		add(modeList);

		move = new JLabel();
		move.setBorder(null);
		move.setBounds(215, 20, 40, 20);
		move.setText("Moves:");
		add(move);

		moveField = new JTextField();
		moveField.setBounds(260, 20, 35, 20);
		moveField.setBorder(null);
		add(moveField);

		time = new JLabel();
		time.setBorder(null);
		time.setBounds(310, 20, 35, 20);
		time.setText("Time:");
		add(time);
		timeField = new JTextField();
		timeField.setBounds(345, 20, 35, 20);
		timeField.setBorder(null);
		add(timeField);

		swap = new JLabel();
		swap.setBorder(null);
		swap.setBounds(20, 60, 50, 20);
		swap.setText("Swaps:");
		add(swap);
		swapField = new JTextField();
		swapField.setBounds(70, 60, 35, 20);
		swapField.setBorder(null);
		add(swapField);

		shuffle = new JLabel();
		shuffle.setBorder(null);
		shuffle.setBounds(115, 60, 50, 20);
		shuffle.setText("Shuffles:");
		add(shuffle);
		shuffleField = new JTextField();
		shuffleField.setBounds(170, 60, 35, 20);
		shuffleField.setBorder(null);
		add(shuffleField);

		remove = new JLabel();
		remove.setBorder(null);
		remove.setBounds(215, 60, 60, 20);
		remove.setText("Removes:");
		add(remove);
		removeField = new JTextField();
		removeField.setBounds(275, 60, 35, 20);
		removeField.setBorder(null);
		add(removeField);

		one = new JLabel();
		one.setBorder(null);
		one.setBounds(20, 100, 60, 20);
		one.setText("onePer:");
		add(one);
		onePercent = new JTextField();
		onePercent.setBounds(70, 100, 35, 20);
		onePercent.setBorder(null);
		add(onePercent);

		two = new JLabel();
		two.setBorder(null);
		two.setBounds(115, 100, 60, 20);
		two.setText("twoPer:");
		add(two);
		twoPercent = new JTextField();
		twoPercent.setBounds(165, 100, 35, 20);
		twoPercent.setBorder(null);
		add(twoPercent);

		three = new JLabel();
		three.setBorder(null);
		three.setBounds(210, 100, 60, 20);
		three.setText("threePer:");
		add(three);
		threePercent = new JTextField();
		threePercent.setBounds(265, 100, 35, 20);
		threePercent.setBorder(null);
		add(threePercent);

		four = new JLabel();
		four.setBorder(null);
		four.setBounds(310, 100, 60, 20);
		four.setText("fourPer:");
		add(four);
		fourPercent = new JTextField();
		fourPercent.setBounds(360, 100, 35, 20);
		fourPercent.setBorder(null);
		add(fourPercent);

		five = new JLabel();
		five.setBorder(null);
		five.setBounds(405, 100, 60, 20);
		five.setText("fivePer:");
		add(five);
		fivePercent = new JTextField();
		fivePercent.setBounds(450, 100, 35, 20);
		fivePercent.setBorder(null);
		add(fivePercent);

		six = new JLabel();
		six.setBorder(null);
		six.setBounds(495, 100, 60, 20);
		six.setText("sixPer:");
		add(six);
		sixPercent = new JTextField();
		sixPercent.setBounds(540, 100, 35, 20);
		sixPercent.setBorder(null);
		add(sixPercent);

		oneMult = new JLabel();
		oneMult.setBorder(null);
		oneMult.setBounds(20, 140, 80, 20);
		oneMult.setText("oneMultPer:");
		add(oneMult);
		oneMultPercent = new JTextField();
		oneMultPercent.setBounds(95, 140, 35, 20);
		oneMultPercent.setBorder(null);
		add(oneMultPercent);

		twoMult = new JLabel();
		twoMult.setBorder(null);
		twoMult.setBounds(140, 140, 80, 20);
		twoMult.setText("twoMultPer:");
		add(twoMult);
		twoMultPercent = new JTextField();
		twoMultPercent.setBounds(215, 140, 35, 20);
		twoMultPercent.setBorder(null);
		add(twoMultPercent);

		threeMult = new JLabel();
		threeMult.setBorder(null);
		threeMult.setBounds(260, 140, 80, 20);
		threeMult.setText("threeMultPer:");
		add(threeMult);
		threeMultPercent = new JTextField();
		threeMultPercent.setBounds(340, 140, 35, 20);
		threeMultPercent.setBorder(null);
		add(threeMultPercent);

		textFields = new JTextField[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				textFields[i][j] = new JTextField();
				textFields[i][j].setBounds(50 + 45 * j, 200 + i * 35, 30, 20);
				textFields[i][j].setBorder(null);
				add(textFields[i][j]);
			}
		}
		/*
		 * JLabel lblStartingBoarduse = new JLabel(
		 * "Starting Board: use a / to break up squares, return at the end of a row, use a"
		 * );
		 * 
		 * JLabel lblAndUseA = new JLabel(
		 * "comma between the value and the multiplier of the square,");
		 * 
		 * JLabel lblAndInput = new JLabel("and input 0,0 for a blank square");
		 */

		JButton btnSave = new JButton("Save");
		btnSave.setBorder(null);
		btnSave.setBounds(20, 510, 150, 40);
		add(btnSave);
		btnSave.addActionListener(new SaveButtonController(blm, this));

		JButton btnLoad = new JButton("Load");
		btnLoad.setBorder(null);
		btnLoad.setBounds(180, 510, 150, 40);
		add(btnLoad);
		btnLoad.addActionListener(new LoadButtonController(this));

		JButton btnRandomizeBoard = new JButton("Randomize Board");
		btnRandomizeBoard.setBorder(null);
		btnRandomizeBoard.setBounds(340, 510, 150, 40);
		add(btnRandomizeBoard);
		btnRandomizeBoard.addActionListener(new RandomizeButtonController(blm,
				this));

		JButton btnDisplay = new JButton("Display Board");
		btnDisplay.setBorder(null);
		btnDisplay.setBounds(500, 510, 150, 40);
		add(btnDisplay);
		btnDisplay.addActionListener(new DisplayBoardController(blm, this));

		JLabel background = new JLabel();
		add(background);
		background.setBounds(0, 0, 800, 600);
		background.setIcon(new ImageIcon(
				"src/sw/resource/image/levelbuilderbackground.png"));

	}

	public int getLvlField() {
		int level;
		try {
			level = Integer.parseInt(this.lvlField.getText());
		} catch (NumberFormatException e) {
			this.lvlField.setText("");
			return -1;
		}
		return level;
	}

	public void setLvlField(String s) {
		this.lvlField.setText(s);
	}

	public String getModeList() {
		return (String) this.modeList.getSelectedItem();
	}

	public void setModeList(String s) {
		int input = -1;
		if (s.equals("Puzzle"))
			input = 0;
		else if (s.equals("Lightning"))
			input = 1;
		else if (s.equals("Release"))
			input = 2;
		else if (s.equals("Elimination"))
			input = 3;
		this.modeList.setSelectedIndex(input);
	}

	public int getMoveField() {
		int moves;
		try {
			moves = Integer.parseInt(this.moveField.getText());
		} catch (NumberFormatException e) {
			this.moveField.setText("");
			return -1;
		}
		return moves;
	}

	public void setMoveField(String s) {
		this.moveField.setText(s);
	}

	public int getTimeField() {
		int time;
		try {
			time = Integer.parseInt(this.timeField.getText());
		} catch (NumberFormatException e) {
			this.timeField.setText("");
			return -1;
		}
		return time;
	}

	public void setTimeField(String s) {
		this.timeField.setText(s);
	}

	public int getSwapField() {
		int swaps;
		try {
			swaps = Integer.parseInt(this.swapField.getText());
		} catch (NumberFormatException e) {
			this.swapField.setText("");
			return -1;
		}
		return swaps;
	}

	public void setSwapsField(String s) {
		this.swapField.setText(s);
	}

	public int getShuffleField() {
		int shuffle;
		try {
			shuffle = Integer.parseInt(this.shuffleField.getText());
		} catch (NumberFormatException e) {
			this.shuffleField.setText("");
			return -1;
		}
		return shuffle;
	}

	public void setShuffleField(String s) {
		this.shuffleField.setText(s);
	}

	public int getRemoveField() {
		int remove;
		try {
			remove = Integer.parseInt(this.removeField.getText());
		} catch (NumberFormatException e) {
			this.removeField.setText("");
			return -1;
		}
		return remove;
	}

	public void setRemoveField(String s) {
		this.removeField.setText(s);
	}

	public int getOnePercent() {
		int one;
		try {
			one = Integer.parseInt(this.onePercent.getText());
		} catch (NumberFormatException e) {
			this.onePercent.setText("");
			return -1;
		}
		return one;
	}

	public void setOnePercent(String s) {
		this.onePercent.setText(s);
	}

	public int getTwoPercent() {
		int one;
		try {
			one = Integer.parseInt(this.twoPercent.getText());
		} catch (NumberFormatException e) {
			this.twoPercent.setText("");
			return -1;
		}
		return one;
	}

	public void setTwoPercent(String s) {
		this.twoPercent.setText(s);
	}

	public int getThreePercent() {
		int one;
		try {
			one = Integer.parseInt(this.threePercent.getText());
		} catch (NumberFormatException e) {
			this.threePercent.setText("");
			return -1;
		}
		return one;
	}

	public void setThreePercent(String s) {
		this.threePercent.setText(s);
	}

	public int getFourPercent() {
		int one;
		try {
			one = Integer.parseInt(this.fourPercent.getText());
		} catch (NumberFormatException e) {
			this.fourPercent.setText("");
			return -1;
		}
		return one;
	}

	public void setFourPercent(String s) {
		this.fourPercent.setText(s);
	}

	public int getFivePercent() {
		int one;
		try {
			one = Integer.parseInt(this.fivePercent.getText());
		} catch (NumberFormatException e) {
			this.fivePercent.setText("");
			return -1;
		}
		return one;
	}

	public void setFivePercent(String s) {
		this.fivePercent.setText(s);
	}

	public int getSixPercent() {
		int one;
		try {
			one = Integer.parseInt(this.sixPercent.getText());
		} catch (NumberFormatException e) {
			this.sixPercent.setText("");
			return -1;
		}
		return one;
	}

	public void setSixPercent(String s) {
		this.sixPercent.setText(s);
	}

	public int getOneMultPercent() {
		int one;
		try {
			one = Integer.parseInt(this.oneMultPercent.getText());
		} catch (NumberFormatException e) {
			this.oneMultPercent.setText("");
			return -1;
		}
		return one;
	}

	public void setmOnePercent(String s) {
		this.oneMultPercent.setText(s);
	}

	public int getTwoMultPercent() {
		int one;
		try {
			one = Integer.parseInt(this.twoMultPercent.getText());
		} catch (NumberFormatException e) {
			this.twoMultPercent.setText("");
			return -1;
		}
		return one;
	}

	public void setmTwoPercent(String s) {
		this.twoMultPercent.setText(s);
	}

	public int getThreeMultPercent() {
		int one;
		try {
			one = Integer.parseInt(this.threeMultPercent.getText());
		} catch (NumberFormatException e) {
			this.threeMultPercent.setText("");
			return -1;
		}
		return one;
	}

	public void setmThreePercent(String s) {
		this.threeMultPercent.setText(s);
	}

	public static String[][] getBoard() {
		String[][] board1 = new String[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				String input = textFields[i][j].getText();
				if (isValid(input))
					board1[j][i] = input;
				else {
					textFields[i][j].setText("");
				}
			}
		}
		LevelBuilderView.boardStr = board1;
		return board1;
	}

	public void setBoard(ArrayList<String> s) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
					textFields[i][j].setText(s.get(i).substring(j * 3,
							j * 3 + 3));
			}
		}
	}
	
	public void setBoardRandom(ArrayList<String> s) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (textFields[i][j].getText().contains("0,0")
						|| textFields[i][j].getText().contains("*,*")) {

				} else {
					textFields[i][j].setText(s.get(i).substring(j * 3,
							j * 3 + 3));
				}
			}
		}
	}

	public static boolean isValid(String s) {
		if (s.length() == 3) {

			if (s.charAt(0) == '0' || s.charAt(0) == '1' || s.charAt(0) == '2'
					|| s.charAt(0) == '3' || s.charAt(0) == '4'
					|| s.charAt(0) == '5' || s.charAt(0) == '6'
					|| s.charAt(0) == '*') {
				if (s.charAt(1) == ',') {
					if (s.charAt(2) == '0' || s.charAt(2) == '1'
							|| s.charAt(2) == '2' || s.charAt(2) == '3'
							|| s.charAt(2) == '*') {
						return true;
					}
				}
			}
		}
		return false;
	}

}
