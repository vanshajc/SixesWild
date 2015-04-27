package sw.builder.gui.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import sw.app.gui.view.IView;
import sw.builder.gui.layout.LevelBuilderView;

public class LoadButtonController extends JPanel implements ActionListener,IView {

	LevelBuilderView lbv;
	JTextArea log;
	JFileChooser fc;
	
	public LoadButtonController(LevelBuilderView lbv) {
		this.lbv = lbv;
		setLayout(null);
		initialize();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		File file;
		int returnVal = fc.showOpenDialog(LoadButtonController.this);
        file = fc.getSelectedFile();
        		
        ArrayList<String> input  = new ArrayList<String>();
		
		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;
		    while ((text = reader.readLine()) != null) {
		        input.add(text);
		    }
		} catch (FileNotFoundException e1) {
		    e1.printStackTrace();
		} catch (IOException e1) {
		    e1.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e1) {
		    }
		}
		setFields(input);
	}


	@Override
	public void initialize() {
		File file = new File("./src/sw/resource/levelData/");
		File file1 = new File("level1.txt");
		setPreferredSize(new Dimension(800, 600));
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setBounds(0, 0, 800, 550);
		fc.setCurrentDirectory(file);
		fc.setSelectedFile(file1);	
		
	}

	private void setFields(ArrayList<String> input) {
		String level = input.get(0);
		String mode = input.get(1);
		String move = input.get(2);
		String time = input.get(3);
		String swaps = input.get(4);
		String shuffle = input.get(5);
		String remove = input.get(6);
		String one = input.get(7);
		String two = input.get(8);
		String three = input.get(9);
		String four = input.get(10);
		String five = input.get(11);
		String six = input.get(12);
		String oneM = input.get(13);
		String twoM = input.get(14);
		String threeM = input.get(15);
		ArrayList<String> board = new ArrayList<String>();
		board.add(input.get(16));
		board.add(input.get(17));
		board.add(input.get(18));
		board.add(input.get(19));
		board.add(input.get(20));
		board.add(input.get(21));
		board.add(input.get(22));
		board.add(input.get(23));
		board.add(input.get(24));
		
		lbv.setLvlField(level);	
		lbv.setModeList(mode);
		lbv.setMoveField(move);
		lbv.setTimeField(time);
		lbv.setSwapsField(swaps);
		lbv.setShuffleField(shuffle);
		lbv.setRemoveField(remove);
		lbv.setOnePercent(one);
		lbv.setTwoPercent(two);
		lbv.setThreePercent(three);
		lbv.setFourPercent(four);
		lbv.setFivePercent(five);
		lbv.setSixPercent(six);
		lbv.setmOnePercent(oneM);
		lbv.setmTwoPercent(twoM);
		lbv.setmThreePercent(threeM);
		lbv.setBoard(board);
		
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}

}
