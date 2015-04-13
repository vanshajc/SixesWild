package sw.builder.gui.layout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LevelBuilderView extends JPanel{
	public LevelBuilderView() {
		initialize();
	}
	
	private JTextField LvlField;
	private JTextField MoveField;
	private JTextField TimeField;
	private JTextField SwapField;
	private JTextField Shufflefield;
	private JTextField RemoveField;
	private JTextField onePercent;
	private JTextField twoPercent;
	private JTextField threePercent;
	private JTextField fourPercent;
	private JTextField fivePercent;
	private JTextField sixPercent;
	private JTextField oneMultPercent;
	private JTextField twoMultPercent;
	private JTextField threeMultPercent;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	public void initialize() {
		
		JLabel lblLevel = new JLabel("Level");
		
		JLabel lblMode = new JLabel("Mode");
		
		JComboBox ModeField = new JComboBox();
		
		LvlField = new JTextField();
		LvlField.setColumns(10);
		
		JLabel lblMoves = new JLabel("Moves");
		
		MoveField = new JTextField();
		MoveField.setColumns(10);
		
		JLabel lblTime = new JLabel("Time");
		
		TimeField = new JTextField();
		TimeField.setColumns(10);
		
		JLabel lblPowerUps = new JLabel("Power Ups:");
		
		JLabel lblSwap = new JLabel("Swap");
		
		SwapField = new JTextField();
		SwapField.setColumns(10);
		
		JLabel lblShuffle = new JLabel("Shuffle");
		
		Shufflefield = new JTextField();
		Shufflefield.setColumns(10);
		
		JLabel lblRemove = new JLabel("Remove");
		
		RemoveField = new JTextField();
		RemoveField.setColumns(10);
		
		JLabel lblPercentages = new JLabel("Percentages:");
		
		JLabel lbls = new JLabel("1's");
		
		onePercent = new JTextField();
		onePercent.setColumns(10);
		
		JLabel lbls_1 = new JLabel("2's");
		
		twoPercent = new JTextField();
		twoPercent.setColumns(10);
		
		JLabel lbls_2 = new JLabel("3's");
		
		threePercent = new JTextField();
		threePercent.setColumns(10);
		
		JLabel lbls_3 = new JLabel("4's");
		
		fourPercent = new JTextField();
		fourPercent.setColumns(10);
		
		JLabel lbls_4 = new JLabel("5's");
		
		fivePercent = new JTextField();
		fivePercent.setColumns(10);
		
		JLabel lbls_5 = new JLabel("6's");
		
		sixPercent = new JTextField();
		sixPercent.setColumns(10);
		
		JLabel lblx = new JLabel("1x");
		
		oneMultPercent = new JTextField();
		oneMultPercent.setColumns(10);
		
		JLabel lblx_1 = new JLabel("2x");
		
		twoMultPercent = new JTextField();
		twoMultPercent.setColumns(10);
		
		JLabel lblx_2 = new JLabel("3x");
		
		threeMultPercent = new JTextField();
		threeMultPercent.setColumns(10);
		
		JLabel lblStartingBoarduse = new JLabel("Starting Board: use a / to break up squares, return at the end of a row, use a");
		
		JLabel lblAndUseA = new JLabel("comma between the value and the multiplier of the square,");
		
		JLabel lblAndInput = new JLabel("and input 0,0 for a blank square");
		
		JButton btnSave = new JButton("Save");
		
		JButton btnLoad = new JButton("Load");
		
		JButton btnRandomizeBoard = new JButton("Randomize Board");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPowerUps)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(LvlField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblMode)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(ModeField, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblSwap)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(SwapField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblShuffle)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(Shufflefield, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblRemove)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblMoves)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(MoveField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblTime)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(TimeField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
										.addComponent(RemoveField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblPercentages)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblx)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(oneMultPercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblx_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(twoMultPercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblx_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(threeMultPercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lbls)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(onePercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbls_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(twoPercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbls_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(threePercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbls_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(fourPercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbls_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(fivePercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbls_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(sixPercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblStartingBoarduse)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(123)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAndInput)
								.addComponent(lblAndUseA)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnLoad)
							.addGap(137)
							.addComponent(btnRandomizeBoard)
							.addPreferredGap(ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
							.addComponent(btnSave))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(LvlField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMode)
						.addComponent(ModeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMoves)
						.addComponent(MoveField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTime)
						.addComponent(TimeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPowerUps)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSwap)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(SwapField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblShuffle)
							.addComponent(Shufflefield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblRemove)
							.addComponent(RemoveField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPercentages)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbls)
						.addComponent(onePercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbls_1)
						.addComponent(twoPercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbls_2)
						.addComponent(threePercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbls_3)
						.addComponent(fourPercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbls_4)
						.addComponent(fivePercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbls_5)
						.addComponent(sixPercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblx)
						.addComponent(oneMultPercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblx_1)
						.addComponent(twoMultPercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblx_2)
						.addComponent(threeMultPercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblStartingBoarduse)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAndUseA)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAndInput)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnLoad)
						.addComponent(btnRandomizeBoard))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
}
