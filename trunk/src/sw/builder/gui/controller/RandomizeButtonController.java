package sw.builder.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import sw.builder.gui.layout.BuilderLayoutManager;
import sw.builder.gui.layout.LevelBuilderView;

public class RandomizeButtonController implements ActionListener {

	BuilderLayoutManager blm;
	LevelBuilderView lbv;

	public RandomizeButtonController(BuilderLayoutManager blm,
			LevelBuilderView lbv) {
		this.blm = blm;
		this.lbv = lbv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int one = lbv.getOnePercent();
		int two = lbv.getTwoPercent();
		int three = lbv.getThreePercent();
		int four = lbv.getFourPercent();
		int five = lbv.getFivePercent();
		int six = lbv.getSixPercent();

		int oneM = lbv.getOneMultPercent();
		int twoM = lbv.getTwoMultPercent();
		int threeM = lbv.getThreeMultPercent();
		if (one == -1 || two == -1 || three == -1 || four == -1 || five == -1
				|| six == -1 || oneM == -1 || twoM == -1 || threeM == -1) {
			return;
		} else if (one + two + three + four + five + six != 100) {
			return;
		} else if (oneM + twoM + threeM != 100) {
			return;
		}
		ArrayList<String> board = new ArrayList<String>();
		two = one + two;
		three = two + three;
		four = three + four;
		five = four + five;
		six = five + six;
		
		twoM = oneM + twoM;
		threeM = twoM + threeM;

		for (int i = 0; i < 9; i++) {
			String line = "";
			for (int j = 0; j < 9; j++) {
				String square = "";
				Random rv = new Random();
				int value = rv.nextInt(100);

				Random rm = new Random();
				int mult = rm.nextInt(100);
				int val;
				int mu;
				

				if (value < one) {
					val = 1;
				} else if (value >= one && value < two) {
					val = 2;
				} else if (value >= two && value < three) {
					val = 3;
				} else if (value >= three && value < four) {
					val = 4;
				} else if (value >= four && value < five) {
					val = 5;
				} else {
					val = 6;
				}

				if (mult < oneM) {
					mu = 1;
				} else if (mult >= oneM && mult < twoM) {
					mu = 2;
				} else {
					mu = 3;
				}
				square = val + "," + mu;
				line = line.concat(square);
			}
			board.add(line);
		}
		lbv.setBoardRandom(board);

	}

}
