package sw.builder.gui.layout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;



public class LevelBuilderView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3838710634376227000L;
	BuilderLayoutManager blm;
	public LevelBuilderView(BuilderLayoutManager blm) {
		this.blm = blm;
		initialize();
	}
	
	private JTextField LvlField;
	private JComboBox<String> modeList;
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
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_50;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField textField_56;
	private JTextField textField_57;
	private JTextField textField_58;
	private JTextField textField_59;
	private JTextField textField_60;
	private JTextField textField_61;
	private JTextField textField_62;
	private JTextField textField_63;
	private JTextField textField_64;
	private JTextField textField_65;
	private JTextField textField_66;
	private JTextField textField_67;
	private JTextField textField_68;
	private JTextField textField_69;
	private JTextField textField_70;
	private JTextField textField_71;
	private JTextField textField_72;
	private JTextField textField_73;
	private JTextField textField_74;
	private JTextField textField_75;
	private JTextField textField_76;
	private JTextField textField_77;
	private JTextField textField_78;
	private JTextField textField_79;
	private JTextField textField_80;
	
	public void initialize() {
		
		JLabel lblLevel = new JLabel("Level");
		
		JLabel lblMode = new JLabel("Mode");
		
		
		modeList = new JComboBox<String>();
		modeList.setBackground(Color.WHITE);
		modeList.addItem("Puzzle");
		modeList.addItem("Lightening");
		modeList.addItem("Release");
		modeList.addItem("Elimination");
		
		
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
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		
		textField_33 = new JTextField();
		textField_33.setColumns(10);
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		
		textField_35 = new JTextField();
		textField_35.setColumns(10);
		
		textField_36 = new JTextField();
		textField_36.setColumns(10);
		
		textField_37 = new JTextField();
		textField_37.setColumns(10);
		
		textField_38 = new JTextField();
		textField_38.setColumns(10);
		
		textField_39 = new JTextField();
		textField_39.setColumns(10);
		
		textField_40 = new JTextField();
		textField_40.setColumns(10);
		
		textField_41 = new JTextField();
		textField_41.setColumns(10);
		
		textField_42 = new JTextField();
		textField_42.setColumns(10);
		
		textField_43 = new JTextField();
		textField_43.setColumns(10);
		
		textField_44 = new JTextField();
		textField_44.setColumns(10);
		
		textField_45 = new JTextField();
		textField_45.setColumns(10);
		
		textField_46 = new JTextField();
		textField_46.setColumns(10);
		
		textField_47 = new JTextField();
		textField_47.setColumns(10);
		
		textField_48 = new JTextField();
		textField_48.setColumns(10);
		
		textField_49 = new JTextField();
		textField_49.setColumns(10);
		
		textField_50 = new JTextField();
		textField_50.setColumns(10);
		
		textField_51 = new JTextField();
		textField_51.setColumns(10);
		
		textField_52 = new JTextField();
		textField_52.setColumns(10);
		
		textField_53 = new JTextField();
		textField_53.setColumns(10);
		
		textField_54 = new JTextField();
		textField_54.setColumns(10);
		
		textField_55 = new JTextField();
		textField_55.setColumns(10);
		
		textField_56 = new JTextField();
		textField_56.setColumns(10);
		
		textField_57 = new JTextField();
		textField_57.setColumns(10);
		
		textField_58 = new JTextField();
		textField_58.setColumns(10);
		
		textField_59 = new JTextField();
		textField_59.setColumns(10);
		
		textField_60 = new JTextField();
		textField_60.setColumns(10);
		
		textField_61 = new JTextField();
		textField_61.setColumns(10);
		
		textField_62 = new JTextField();
		textField_62.setColumns(10);
		
		textField_63 = new JTextField();
		textField_63.setColumns(10);
		
		textField_64 = new JTextField();
		textField_64.setColumns(10);
		
		textField_65 = new JTextField();
		textField_65.setColumns(10);
		
		textField_66 = new JTextField();
		textField_66.setColumns(10);
		
		textField_67 = new JTextField();
		textField_67.setColumns(10);
		
		textField_68 = new JTextField();
		textField_68.setColumns(10);
		
		textField_69 = new JTextField();
		textField_69.setColumns(10);
		
		textField_70 = new JTextField();
		textField_70.setColumns(10);
		
		textField_71 = new JTextField();
		textField_71.setColumns(10);
		
		textField_72 = new JTextField();
		textField_72.setColumns(10);
		
		textField_73 = new JTextField();
		textField_73.setColumns(10);
		
		textField_74 = new JTextField();
		textField_74.setColumns(10);
		
		textField_75 = new JTextField();
		textField_75.setColumns(10);
		
		textField_76 = new JTextField();
		textField_76.setColumns(10);
		
		textField_77 = new JTextField();
		textField_77.setColumns(10);
		
		textField_78 = new JTextField();
		textField_78.setColumns(10);
		
		textField_79 = new JTextField();
		textField_79.setColumns(10);
		
		textField_80 = new JTextField();
		textField_80.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(LvlField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lblMode)
							.addGap(12)
							.addComponent(modeList, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblMoves)
							.addGap(12)
							.addComponent(MoveField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lblTime)
							.addGap(12)
							.addComponent(TimeField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblPowerUps))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblSwap)
							.addGap(12)
							.addComponent(SwapField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lblShuffle)
							.addGap(12)
							.addComponent(Shufflefield, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lblRemove)
							.addGap(12)
							.addComponent(RemoveField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblPercentages))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lbls)
							.addGap(12)
							.addComponent(onePercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lbls_1)
							.addGap(12)
							.addComponent(twoPercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lbls_2)
							.addGap(12)
							.addComponent(threePercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lbls_3)
							.addGap(12)
							.addComponent(fourPercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lbls_4)
							.addGap(12)
							.addComponent(fivePercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lbls_5)
							.addGap(12)
							.addComponent(sixPercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblx)
							.addGap(12)
							.addComponent(oneMultPercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lblx_1)
							.addGap(12)
							.addComponent(twoMultPercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lblx_2)
							.addGap(12)
							.addComponent(threeMultPercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblStartingBoarduse))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(123)
							.addComponent(lblAndUseA))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(123)
							.addComponent(lblAndInput))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
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
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(btnLoad)))
					.addGap(111))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_35, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_66, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_68, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_70, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_72, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_74, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_76, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_78, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_80, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_33, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_56, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_58, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_59, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_60, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_61, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_62, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_63, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_64, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_34, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_65, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_67, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_69, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_71, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_73, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_75, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_77, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_79, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_32, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_49, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_50, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_51, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_52, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_53, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_54, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_55, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_57, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
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
							.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_21, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_22, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_23, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_27, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_28, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_29, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_30, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_36, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_37, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_24, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_25, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_26, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_38, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_39, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_40, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_31, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_41, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_42, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_43, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_44, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_45, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnRandomizeBoard))
							.addGap(18)
							.addComponent(textField_46, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_47, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_48, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnSave))))
					.addContainerGap(399, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(LvlField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblMode))
						.addComponent(modeList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblMoves))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(MoveField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblTime))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(TimeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addComponent(lblPowerUps)
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSwap)
						.addComponent(SwapField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblShuffle))
						.addComponent(Shufflefield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblRemove))
						.addComponent(RemoveField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addComponent(lblPercentages)
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lbls))
						.addComponent(onePercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lbls_1))
						.addComponent(twoPercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lbls_2))
						.addComponent(threePercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lbls_3))
						.addComponent(fourPercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lbls_4))
						.addComponent(fivePercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lbls_5))
						.addComponent(sixPercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblx))
						.addComponent(oneMultPercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblx_1))
						.addComponent(twoMultPercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblx_2))
						.addComponent(threeMultPercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addComponent(lblStartingBoarduse)
					.addGap(6)
					.addComponent(lblAndUseA)
					.addGap(6)
					.addComponent(lblAndInput)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_28, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_30, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_36, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_37, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_38, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_39, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_40, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_31, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_41, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_42, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_43, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_44, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_45, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_46, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_47, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_48, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_32, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_49, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_50, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_51, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_52, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_53, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_54, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_55, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_57, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_33, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_56, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_58, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_59, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_60, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_61, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_62, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_63, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_64, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_34, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_65, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_67, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_69, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_71, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_73, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_75, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_77, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_79, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_35, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_66, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_68, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_70, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_72, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_74, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_76, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_78, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_80, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLoad)
						.addComponent(btnSave)
						.addComponent(btnRandomizeBoard)))
		);
		setLayout(groupLayout);
		btnSave.addActionListener(new SaveButtonController(blm, this));
		
		btnLoad.addActionListener(new LoadButtonController(blm));
		
		btnRandomizeBoard.addActionListener(new RandomizeButtonController(blm));
	}
	
	public int getLvlField(){
		int level;
		try{
		level = Integer.parseInt(this.LvlField.getText());
		} catch (NumberFormatException e) {
			this.LvlField.setText("");
			return -1;
		}
		return level;
	}
	public void setLvlField(Integer s){
		this.LvlField.setText(s.toString());
	}
	
	public String getModeList(){
		return (String) this.modeList.getSelectedItem();
	}
	
	public int getMoveField(){
		int moves;
		try{
		moves = Integer.parseInt(this.MoveField.getText());
		} catch (NumberFormatException e) {
			this.MoveField.setText("");
			return -1;
		}
		return moves;
	}
	
	public int getTimeField(){
		int time;
		try{
		time = Integer.parseInt(this.TimeField.getText());
		} catch (NumberFormatException e) {
			this.TimeField.setText("");
			return -1;
		}
		return time;
	}
	
	public int getSwapField(){
		int swaps;
		try{
		swaps = Integer.parseInt(this.SwapField.getText());
		} catch (NumberFormatException e) {
			this.SwapField.setText("");
			return -1;
		}
		return swaps;
	}
	
	public int getShuffleField(){
		int shuffle;
		try{
		shuffle = Integer.parseInt(this.Shufflefield.getText());
		} catch (NumberFormatException e) {
			this.Shufflefield.setText("");
			return -1;
		}
		return shuffle;
	}
	
	public int getRemoveField(){
		int remove;
		try{
		remove = Integer.parseInt(this.RemoveField.getText());
		} catch (NumberFormatException e) {
			this.RemoveField.setText("");
			return -1;
		}
		return remove;
	}
	
	public int getOnePercent(){
		int one;
		try{
		one = Integer.parseInt(this.onePercent.getText());
		} catch (NumberFormatException e) {
			this.onePercent.setText("");
			return -1;
		}
		return one;
	}
	
	public int getTwoPercent(){
		int one;
		try{
		one = Integer.parseInt(this.twoPercent.getText());
		} catch (NumberFormatException e) {
			this.twoPercent.setText("");
			return -1;
		}
		return one;
	}
	
	public int getThreePercent(){
		int one;
		try{
		one = Integer.parseInt(this.threePercent.getText());
		} catch (NumberFormatException e) {
			this.threePercent.setText("");
			return -1;
		}
		return one;
	}
	
	public int getFourPercent(){
		int one;
		try{
		one = Integer.parseInt(this.fourPercent.getText());
		} catch (NumberFormatException e) {
			this.fourPercent.setText("");
			return -1;
		}
		return one;
	}
	
	public int getFivePercent(){
		int one;
		try{
		one = Integer.parseInt(this.fivePercent.getText());
		} catch (NumberFormatException e) {
			this.fivePercent.setText("");
			return -1;
		}
		return one;
	}
	
	public int getSixPercent(){
		int one;
		try{
		one = Integer.parseInt(this.sixPercent.getText());
		} catch (NumberFormatException e) {
			this.sixPercent.setText("");
			return -1;
		}
		return one;
	}
	
	public int getOneMultPercent(){
		int one;
		try{
		one = Integer.parseInt(this.oneMultPercent.getText());
		} catch (NumberFormatException e) {
			this.oneMultPercent.setText("");
			return -1;
		}
		return one;
	}
	
	public int getTwoMultPercent(){
		int one;
		try{
		one = Integer.parseInt(this.twoMultPercent.getText());
		} catch (NumberFormatException e) {
			this.twoMultPercent.setText("");
			return -1;
		}
		return one;
	}
	
	public int getThreeMultPercent(){
		int one;
		try{
		one = Integer.parseInt(this.threeMultPercent.getText());
		} catch (NumberFormatException e) {
			this.threeMultPercent.setText("");
			return -1;
		}
		return one;
	}
	
	public String[][] getBoard(){
		ArrayList<String> source = this.getBoardList();
		int iterator = 0;
		String[][] board = new String[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = source.get(iterator);
				if(iterator < 79)
					iterator++;
			}
		}
		return board;
	}
	
	public ArrayList<String> getBoardList(){
		ArrayList<String> squares = new ArrayList<String>();
		squares.add(textField_1.getText());
		squares.add(textField_2.getText());
		squares.add(textField_3.getText());
		squares.add(textField_4.getText());
		squares.add(textField_5.getText());
		squares.add(textField_6.getText());
		squares.add(textField_7.getText());
		squares.add(textField_8.getText());
		squares.add(textField_9.getText());
		squares.add(textField_10.getText());
		squares.add(textField_11.getText());
		squares.add(textField_12.getText());
		squares.add(textField_13.getText());
		squares.add(textField_14.getText());
		squares.add(textField_15.getText());
		squares.add(textField_16.getText());
		squares.add(textField_17.getText());
		squares.add(textField_18.getText());
		squares.add(textField_19.getText());
		squares.add(textField_20.getText());
		squares.add(textField_21.getText());
		squares.add(textField_22.getText());
		squares.add(textField_23.getText());
		squares.add(textField_24.getText());
		squares.add(textField_25.getText());
		squares.add(textField_26.getText());
		squares.add(textField_27.getText());
		squares.add(textField_28.getText());
		squares.add(textField_29.getText());
		squares.add(textField_30.getText());
		squares.add(textField_31.getText());
		squares.add(textField_32.getText());
		squares.add(textField_33.getText());
		squares.add(textField_34.getText());
		squares.add(textField_35.getText());
		squares.add(textField_36.getText());
		squares.add(textField_37.getText());
		squares.add( textField_38.getText());
		squares.add( textField_39.getText());
		squares.add( textField_40.getText());
		squares.add(textField_41.getText());
		squares.add(textField_42.getText());
		squares.add(textField_43.getText());
		squares.add(textField_44.getText());
		squares.add(textField_45.getText());
		squares.add(textField_46.getText());
		squares.add( textField_47.getText());
		squares.add(textField_48.getText());
		squares.add(textField_49.getText());
		squares.add(textField_50.getText());
		squares.add(textField_51.getText());
		squares.add(textField_52.getText());
		squares.add(textField_53.getText());
		squares.add(textField_54.getText());
		squares.add(textField_55.getText());
		squares.add(textField_56.getText());
		squares.add(textField_57.getText());
		squares.add(textField_58.getText());
		squares.add(textField_59.getText());
		squares.add(textField_60.getText());
		squares.add(textField_61.getText());
		squares.add(textField_62.getText());
		squares.add(textField_63.getText());
		squares.add(textField_64.getText());
		squares.add(textField_65.getText());
		squares.add(textField_66.getText());
		squares.add(textField_67.getText());
		squares.add(textField_68.getText());
		squares.add(textField_69.getText());
		squares.add(textField_70.getText());
		squares.add(textField_71.getText());
		squares.add(textField_72.getText());
		squares.add(textField_73.getText());
		squares.add(textField_74.getText());
		squares.add(textField_75.getText());
		squares.add(textField_76.getText());
		squares.add(textField_77.getText());
		squares.add(textField_78.getText());
		squares.add(textField_79.getText());
		squares.add(textField_80.getText());
		return squares;
	}
}
