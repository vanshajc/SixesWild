package sw.builder.gui.layout;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sw.app.gui.controller.MainMenuController;
import sw.app.gui.view.MainMenuView;
import sw.app.gui.view.board.BoardPanel;
import sw.builder.gui.controller.CreateButtonController;
import sw.builder.gui.controller.DisplayBoardController;
import sw.builder.gui.controller.LoadButtonController;
import sw.builder.gui.controller.RandomizeButtonController;
import sw.builder.gui.controller.SaveButtonController;
import sw.common.model.entity.Board;
import sw.common.system.manager.TimerTaskManager;

/** GUI class for level builder view. */
public class LevelBuilderView extends JPanel {

	/** The object theat manages views. */
	BuilderLayoutManager blm;
	/** The board object that will be set. */
	public static Board board;
	/** Collection of Strings representing the board. */
	public static String[][] boardStr = new String[9][9];
	/** JPanel that holds a representation of the gui of the board. */
	public static LevelBuilderBoardPanel boardPanel;

	/**
	 * Initializes the level builder view and the board.
	 * 
	 * @param blm
	 *            controls which screens are switched to.
	 */
	public LevelBuilderView(BuilderLayoutManager blm) {
		this.blm = blm;
		setLayout(null);

		board = new Board();
		try {
			boardPanel = new LevelBuilderBoardPanel(board);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		initialize();
	}

	/**
	 * All textfields and labels on the level builder view.
	 */
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
	JLabel oneStar;
	JTextField oneStarScore;
	JLabel twoStar;
	JTextField twoStarScore;
	JLabel threeStar;
	JTextField threeStarScore;
	static JTextField textFields[][];

	/**
	 * Initializes all fields on the level builder view.
	 */
	public void initialize() {

		lvl = new JLabel();
		lvl.setBorder(null);
		lvl.setBounds(20, 20, 55, 20);
		lvl.setText("Level:");
		lvl.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lvl.setForeground(new Color(184, 134, 11));
		add(lvl);
		lvlField = new JTextField();
		lvlField.setBounds(75, 20, 35, 20);
		lvlField.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(lvlField);

		modeList = new JComboBox<>();
		modeList.setBounds(145, 20, 120, 20);
		modeList.setBorder(null);
		modeList.addItem("Puzzle");
		modeList.addItem("Lightning");
		modeList.addItem("Release");
		modeList.addItem("Elimination");
		modeList.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		modeList.setForeground(new Color(184, 134, 11));
		add(modeList);

		move = new JLabel();
		move.setBorder(null);
		move.setBounds(300, 20, 65, 20);
		move.setText("Moves:");
		move.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		move.setForeground(new Color(184, 134, 11));
		add(move);
		moveField = new JTextField();
		moveField.setBounds(365, 20, 35, 20);
		moveField.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(moveField);

		time = new JLabel();
		time.setBorder(null);
		time.setBounds(435, 20, 55, 20);
		time.setText("Time:");
		time.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		time.setForeground(new Color(184, 134, 11));
		add(time);
		timeField = new JTextField();
		timeField.setBounds(490, 20, 35, 20);
		timeField.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(timeField);

		swap = new JLabel();
		swap.setBorder(null);
		swap.setBounds(20, 60, 65, 20);
		swap.setText("Swaps:");
		swap.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		swap.setForeground(new Color(184, 134, 11));
		add(swap);
		swapField = new JTextField();
		swapField.setBounds(85, 60, 35, 20);
		swapField.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(swapField);

		shuffle = new JLabel();
		shuffle.setBorder(null);
		shuffle.setBounds(145, 60, 80, 20);
		shuffle.setText("Shuffles:");
		shuffle.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		shuffle.setForeground(new Color(184, 134, 11));
		add(shuffle);
		shuffleField = new JTextField();
		shuffleField.setBounds(225, 60, 35, 20);
		shuffleField.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(shuffleField);

		remove = new JLabel();
		remove.setBorder(null);
		remove.setBounds(300, 60, 90, 20);
		remove.setText("Removes:");
		remove.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		remove.setForeground(new Color(184, 134, 11));
		add(remove);
		removeField = new JTextField();
		removeField.setBounds(390, 60, 35, 20);
		removeField.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(removeField);

		one = new JLabel();
		one.setBorder(null);
		one.setBounds(20, 100, 60, 20);
		one.setText("onePer:");
		add(one);
		onePercent = new JTextField();
		onePercent.setBounds(70, 100, 35, 20);
		onePercent.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(onePercent);

		two = new JLabel();
		two.setBorder(null);
		two.setBounds(115, 100, 60, 20);
		two.setText("twoPer:");
		add(two);
		twoPercent = new JTextField();
		twoPercent.setBounds(165, 100, 35, 20);
		twoPercent.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(twoPercent);

		three = new JLabel();
		three.setBorder(null);
		three.setBounds(240, 100, 85, 20);
		three.setText("threePer:");
		three.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		three.setForeground(new Color(184, 134, 11));
		add(three);
		threePercent = new JTextField();
		threePercent.setBounds(325, 100, 35, 20);
		threePercent.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(threePercent);

		four = new JLabel();
		four.setBorder(null);
		four.setBounds(375, 100, 75, 20);
		four.setText("fourPer:");
		four.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		four.setForeground(new Color(184, 134, 11));
		add(four);
		fourPercent = new JTextField();
		fourPercent.setBounds(450, 100, 35, 20);
		fourPercent.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(fourPercent);

		five = new JLabel();
		five.setBorder(null);
		five.setBounds(500, 100, 70, 20);
		five.setText("fivePer:");
		five.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		five.setForeground(new Color(184, 134, 11));
		add(five);
		fivePercent = new JTextField();
		fivePercent.setBounds(570, 100, 35, 20);
		fivePercent.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(fivePercent);

		six = new JLabel();
		six.setBorder(null);
		six.setBounds(620, 100, 65, 20);
		six.setText("sixPer:");
		six.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		six.setForeground(new Color(184, 134, 11));
		add(six);
		sixPercent = new JTextField();
		sixPercent.setBounds(685, 100, 35, 20);
		sixPercent.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(sixPercent);

		oneMult = new JLabel();
		oneMult.setBorder(null);
		oneMult.setBounds(20, 140, 80, 20);
		oneMult.setText("oneMultPer:");
		add(oneMult);
		oneMultPercent = new JTextField();
		oneMultPercent.setBounds(95, 140, 35, 20);
		oneMultPercent.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(oneMultPercent);

		twoMult = new JLabel();
		twoMult.setBorder(null);
		twoMult.setBounds(140, 140, 80, 20);
		twoMult.setText("twoMultPer:");
		add(twoMult);
		twoMultPercent = new JTextField();
		twoMultPercent.setBounds(215, 140, 35, 20);
		twoMultPercent.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(twoMultPercent);

		threeMult = new JLabel();
		threeMult.setBorder(null);
		threeMult.setBounds(260, 140, 80, 20);
		threeMult.setText("threeMultPer:");
		add(threeMult);
		threeMultPercent = new JTextField();
		threeMultPercent.setBounds(340, 140, 35, 20);
		threeMultPercent.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(threeMultPercent);

		oneStar = new JLabel();
		oneStar.setBorder(null);
		oneStar.setBounds(620, 20, 100, 20);
		oneStar.setText("oneStarScore:");
		add(oneStar);
		oneStarScore = new JTextField();
		oneStarScore.setBounds(705, 20, 40, 20);
		oneStarScore.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(oneStarScore);

		twoStar = new JLabel();
		twoStar.setBorder(null);
		twoStar.setBounds(620, 50, 100, 20);
		twoStar.setText("twoStarScore:");
		add(twoStar);
		twoStarScore = new JTextField();
		twoStarScore.setBounds(710, 50, 40, 20);
		twoStarScore.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(twoStarScore);

		threeStar = new JLabel();
		threeStar.setBorder(null);
		threeStar.setBounds(620, 80, 100, 20);
		threeStar.setText("threeStarScore:");
		add(threeStar);
		threeStarScore = new JTextField();
		threeStarScore.setBounds(715, 80, 40, 20);
		threeStarScore.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		add(threeStarScore);

		textFields = new JTextField[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				textFields[i][j] = new JTextField();
				textFields[i][j].setBounds(50 + 45 * j, 200 + i * 35, 30, 20);
				textFields[i][j].setBorder(BorderFactory.createLineBorder(Color.BLUE));
				add(textFields[i][j]);
			}
		}

		ImageIcon buttonSave = new ImageIcon(LevelBuilderView.class.getResource("/sw/resource/image/button_save.png"));
		ImageIcon newBtnSave = new ImageIcon(buttonSave.getImage().getScaledInstance(114, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnSaveRollover = new ImageIcon(LevelBuilderView.class.getResource("/sw/resource/image/button_save_Rollover.png"));
		ImageIcon newBtnSaveRollover = new ImageIcon(btnSaveRollover.getImage().getScaledInstance(114, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnSavePressed = new ImageIcon(LevelBuilderView.class.getResource("/sw/resource/image/button_save_Pressed.png"));
		ImageIcon newBtnSavePressed = new ImageIcon(btnSavePressed.getImage().getScaledInstance(114, 69, java.awt.Image.SCALE_SMOOTH));
		JButton btnSave = new JButton(newBtnSave);
		btnSave.setBounds(20, 510, 114, 69);
		btnSave.setBorderPainted(false);
		btnSave.setBackground(Color.WHITE);
		btnSave.setBorder(null);
		btnSave.setContentAreaFilled(false);
		btnSave.addActionListener(new SaveButtonController(blm, this));
		btnSave.setRolloverEnabled(true);
		btnSave.setRolloverIcon(newBtnSaveRollover);
		btnSave.setPressedIcon(newBtnSavePressed);
		add(btnSave);

		ImageIcon buttonLoad = new ImageIcon(LevelBuilderView.class.getResource("/sw/resource/image/button_load.png"));
		ImageIcon newBtnLoad = new ImageIcon(buttonLoad.getImage().getScaledInstance(114, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnLoadRollover = new ImageIcon(LevelBuilderView.class.getResource("/sw/resource/image/button_load_Rollover.png"));
		ImageIcon newBtnLoadRollover = new ImageIcon(btnLoadRollover.getImage().getScaledInstance(114, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnLoadPressed = new ImageIcon(LevelBuilderView.class.getResource("/sw/resource/image/button_load_Pressed.png"));
		ImageIcon newBtnLoadPressed = new ImageIcon(btnLoadPressed.getImage().getScaledInstance(114, 69, java.awt.Image.SCALE_SMOOTH));
		JButton btnLoad = new JButton(newBtnLoad);
		btnLoad.setBounds(150, 510, 114, 69);
		btnLoad.setBorderPainted(false);
		btnLoad.setBackground(Color.WHITE);
		btnLoad.setBorder(null);
		btnLoad.setContentAreaFilled(false);
		btnLoad.addActionListener(new LoadButtonController(this));
		btnLoad.setRolloverEnabled(true);
		btnLoad.setRolloverIcon(newBtnLoadRollover);
		btnLoad.setPressedIcon(newBtnLoadPressed);
		add(btnLoad);

		ImageIcon buttonRandomize = new ImageIcon(LevelBuilderView.class.getResource("/sw/resource/image/button_randomize.png"));
		ImageIcon newBtnRandomize = new ImageIcon(buttonRandomize.getImage().getScaledInstance(322, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnRandomizeRollover = new ImageIcon(LevelBuilderView.class.getResource("/sw/resource/image/button_randomize_Rollover.png"));
		ImageIcon newBtnRandomizeRollover = new ImageIcon(btnRandomizeRollover.getImage().getScaledInstance(322, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnRandomizePressed = new ImageIcon(LevelBuilderView.class.getResource("/sw/resource/image/button_randomize_Pressed.png"));
		ImageIcon newBtnRandomizePressed = new ImageIcon(btnRandomizePressed.getImage().getScaledInstance(322, 69, java.awt.Image.SCALE_SMOOTH));
		JButton btnRandomizeBoard = new JButton(newBtnRandomize);
		btnRandomizeBoard.setBounds(270, 510, 322, 69);
		btnRandomizeBoard.setBorderPainted(false);
		btnRandomizeBoard.setBackground(Color.WHITE);
		btnRandomizeBoard.setBorder(null);
		btnRandomizeBoard.setContentAreaFilled(false);
		btnRandomizeBoard.addActionListener(new RandomizeButtonController(blm, this));
		btnRandomizeBoard.setRolloverEnabled(true);
		btnRandomizeBoard.setRolloverIcon(newBtnRandomizeRollover);
		btnRandomizeBoard.setPressedIcon(newBtnRandomizePressed);
		add(btnRandomizeBoard);

		ImageIcon buttonDisplay = new ImageIcon(LevelBuilderView.class.getResource("/sw/resource/image/button_display.png"));
		ImageIcon newBtnDisplay = new ImageIcon(buttonDisplay.getImage().getScaledInstance(155, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnDisplayRollover = new ImageIcon(LevelBuilderView.class.getResource("/sw/resource/image/button_display_Rollover.png"));
		ImageIcon newBtnDisplayRollover = new ImageIcon(btnDisplayRollover.getImage().getScaledInstance(155, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnDisplayPressed = new ImageIcon(LevelBuilderView.class.getResource("/sw/resource/image/button_display_Pressed.png"));
		ImageIcon newBtnDisplayPressed = new ImageIcon(btnDisplayPressed.getImage().getScaledInstance(155, 69, java.awt.Image.SCALE_SMOOTH));
		JButton btnDisplayBoard = new JButton(newBtnDisplay);
		btnDisplayBoard.setBounds(595, 510, 155, 69);
		btnDisplayBoard.setBorderPainted(false);
		btnDisplayBoard.setBackground(Color.WHITE);
		btnDisplayBoard.setBorder(null);
		btnDisplayBoard.setContentAreaFilled(false);
		btnDisplayBoard.addActionListener(new DisplayBoardController(blm, this));
		btnDisplayBoard.setRolloverEnabled(true);
		btnDisplayBoard.setRolloverIcon(newBtnDisplayRollover);
		btnDisplayBoard.setPressedIcon(newBtnDisplayPressed);
		add(btnDisplayBoard);

		ImageIcon builderBackground = new ImageIcon(LevelBuilderView.class.getResource("/sw/resource/image/builderBackground.png"));
		ImageIcon newbldBackground = new ImageIcon(builderBackground.getImage().getScaledInstance(800, 573, java.awt.Image.SCALE_SMOOTH));
		JLabel background = new JLabel(newbldBackground);
		background.setBounds(0, 0, 800, 600);
		//background.setIcon(new ImageIcon(
		//		"src/sw/resource/image/levelbuilderbackground.png"));
		add(background);

	}

	/**
	 * Getter for the Level field.
	 * 
	 * @return The level.
	 */
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

	/**
	 * Setter level Field.
	 * @param s the new value in the Level field.
	 */
	public void setLvlField(String s) {
		this.lvlField.setText(s);
	}

	/**
	 * Getter for mode.
	 * @return the mode selected.
	 */
	public String getModeList() {
		return (String) this.modeList.getSelectedItem();
	}
	
	/**
	 * Setter for the mode.
	 * @param s the new value of the mode.
	 */
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

	/**
	 * Getter for move.
	 * @return The move.
	 */
	public int getMoveField() {
		int moves;
		try {
			moves = Integer.parseInt(this.moveField.getText());
		} catch (NumberFormatException e) {
			this.moveField.setText("");
			return -1;
		}
		if (!this.getModeList().equals("Puzzle")) {
			moves = 0;
			setMoveField("");
		}
		return moves;
	}

	/**
	 * Setter move field.
	 * @param s The value move field will be set to.
	 */
	public void setMoveField(String s) {
		this.moveField.setText(s);
	}

	/**
	 * Getter time field.
	 * @return The time.
	 */
	public int getTimeField() {
		int time;
		try {
			time = Integer.parseInt(this.timeField.getText());
		} catch (NumberFormatException e) {
			this.timeField.setText("");
			return -1;
		}
		if (!this.getModeList().equals("Lightning")) {
			time = 0;
			setTimeField("");
		}
		return time;
	}

	/**
	 * Setter for time field.
	 * @param s value time field will be set to.
	 */
	public void setTimeField(String s) {
		this.timeField.setText(s);
	}

	/**
	 * Getter for the swap field.
	 * @return The number of swaps.
	 */
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

	/**
	 * Setter for swap field.
	 * @param s the new value of swap field.
	 */
	public void setSwapsField(String s) {
		this.swapField.setText(s);
	}

	/**
	 * Getter for the shuffle field.
	 * @return the value of shuffle field.
	 */
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

	/**
	 * Setter for the shuffle field
	 * @param s the new value of the shuffle field.
	 */
	public void setShuffleField(String s) {
		this.shuffleField.setText(s);
	}
	
	/**
	 * Getter for the remove field.
	 * @return the number of removes.
	 */
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

	/**
	 * Setter for the remove field.
	 * @param s the new value of the remove field.
	 */
	public void setRemoveField(String s) {
		this.removeField.setText(s);
	}
	/**
	 * Getter for the one percent field.
	 * @return the value in one percent field.
	 */
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

	/**
	 * Setter for one percent field.
	 * @param s new value of the one percent field.
	 */
	public void setOnePercent(String s) {
		this.onePercent.setText(s);
	}
	/**
	 * Getter for the one percent field.
	 * @return the value in one percent field.
	 */
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
	/**
	 * Setter for two percent field.
	 * @param s new value of the two percent field.
	 */
	public void setTwoPercent(String s) {
		this.twoPercent.setText(s);
	}
	/**
	 * Getter for the three percent field.
	 * @return the value in three percent field.
	 */
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
	/**
	 * Setter for three percent field.
	 * @param s new value of the three percent field.
	 */
	public void setThreePercent(String s) {
		this.threePercent.setText(s);
	}
	/**
	 * Getter for the four percent field.
	 * @return the value in four percent field.
	 */
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
	/**
	 * Setter for four percent field.
	 * @param s new value of the four percent field.
	 */
	public void setFourPercent(String s) {
		this.fourPercent.setText(s);
	}
	/**
	 * Getter for the five percent field.
	 * @return the value in five percent field.
	 */
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
	/**
	 * Setter for five percent field.
	 * @param s new value of the five percent field.
	 */
	public void setFivePercent(String s) {
		this.fivePercent.setText(s);
	}
	/**
	 * Getter for the six percent field.
	 * @return the value in five percent field.
	 */
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
	/**
	 * Setter for six percent field.
	 * @param s new value of the six percent field.
	 */
	public void setSixPercent(String s) {
		this.sixPercent.setText(s);
	}
	/**
	 * Getter for the one multiplier percent field.
	 * @return the value in one multiplier percent field.
	 */
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
	/**
	 * Setter for one multiplier percent field.
	 * @param s new value of the one multiplier percent field.
	 */
	public void setmOnePercent(String s) {
		this.oneMultPercent.setText(s);
	}
	/**
	 * Getter for the two multiplier percent field.
	 * @return the value in two multiplier percent field.
	 */
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
	/**
	 * Setter for two multiplier percent field.
	 * @param s new value of the two multiplier percent field.
	 */
	public void setmTwoPercent(String s) {
		this.twoMultPercent.setText(s);
	}
	/**
	 * Getter for the three multiplier percent field.
	 * @return the value in three multiplier percent field.
	 */
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
	/**
	 * Setter for three multiplier percent field.
	 * @param s new value of the three multiplier percent field.
	 */
	public void setmThreePercent(String s) {
		this.threeMultPercent.setText(s);
	}
	/** 
	 * Getter for one star field.
	 * @return one star field.
	 */
	public int getOneStar() {
		int score;
		try {
			score = Integer.parseInt(this.oneStarScore.getText());
		} catch (NumberFormatException e) {
			this.oneStarScore.setText("");
			return -1;
		}
		return score;
	}
	/**
	 * Setter one star field.
	 * @param s new value of one star field.
	 */
	public void setOneStar(String s) {
		this.oneStarScore.setText(s);
	}
	/** 
	 * Getter for two star field.
	 * @return two star field.
	 */
	public int getTwoStar() {
		int score;
		try {
			score = Integer.parseInt(this.twoStarScore.getText());
		} catch (NumberFormatException e) {
			this.twoStarScore.setText("");
			return -1;
		}
		return score;
	}
	/**
	 * Setter two star field.
	 * @param s new value of two star field.
	 */
	public void setTwoStar(String s) {
		this.twoStarScore.setText(s);
	}
	/** 
	 * Getter for three star field.
	 * @return three star field.
	 */
	public int getThreeStar() {
		int score;
		try {
			score = Integer.parseInt(this.threeStarScore.getText());
		} catch (NumberFormatException e) {
			this.threeStarScore.setText("");
			return -1;
		}
		return score;
	}
	/**
	 * Setter three star field.
	 * @param s new value of three star field.
	 */
	public void setThreeStar(String s) {
		this.threeStarScore.setText(s);
	}

	public String[][] getBoard() {
		String[][] board1 = new String[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				String input = textFields[i][j].getText();
				if (isValid(input)) {
					board1[j][i] = input;
				} else {
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
				textFields[i][j].setText(s.get(i).substring(j * 3, j * 3 + 3));
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

	public boolean isValid(String s) {
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

	public class LevelBuilderBoardPanel extends BoardPanel {

		public LevelBuilderBoardPanel(Board board) throws IOException {
			super(board);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see sw.app.gui.view.board.BoardPanel#cleanup()
		 */
		@Override
		public void cleanup() {

		}

	}

}
