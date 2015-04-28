/**
 * @file MementoManager.java
 * @date Apr 26, 2015 3:27:12 PM
 * @author Tony Vu (quangvu@wpi.edu), Vanshaj Chowdhary
 */
package sw.common.system.manager;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sw.common.model.entity.Board;
import sw.common.model.entity.Game;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.model.entity.Tile;
import sw.common.system.factory.LevelFactory;
import sw.common.system.factory.TileFactory;
import sw.common.system.factory.TileFrequency;

/** Responsible for loading existing levels into the LevelManager */
public class MementoManager {

	static String filePath = "/sw/resource/levelData/";

	public static Level loadMemento(String name) throws IOException {		

		ArrayList<String> lines = readLines(name);

		// Winning statistics
		String move = lines.get(2);
		String time = lines.get(3); // assume minutes here ???
		Statistics winStats = new Statistics();
		winStats.setNumMoves(Integer.parseInt(move));
		
		String time1 = String.format("%02d:%02d:%02d", 0, 0, Integer.parseInt(time));
		winStats.setTime(Time.valueOf(time1));
		
		// Tile value and multiplier percentage
		String one = lines.get(7);
		String two = lines.get(8);
		String three = lines.get(9);
		String four = lines.get(10);
		String five = lines.get(11);
		String six = lines.get(12);
		HashMap<Integer, Double> valFreq = new HashMap<Integer, Double>();
		valFreq.put(1, Double.valueOf(one));
		valFreq.put(2, Double.valueOf(two));
		valFreq.put(3, Double.valueOf(three));
		valFreq.put(4, Double.valueOf(four));
		valFreq.put(5, Double.valueOf(five));
		valFreq.put(6, Double.valueOf(six));
		
		String oneM = lines.get(13);
		String twoM = lines.get(14);
		String threeM = lines.get(15);
		HashMap<Integer, Double> mulFreq = new HashMap<Integer, Double>();
		mulFreq.put(1, Double.valueOf(oneM));
		mulFreq.put(2, Double.valueOf(twoM));
		mulFreq.put(3, Double.valueOf(threeM));
		
		TileFrequency freq = new TileFrequency(valFreq, mulFreq);
		
		// Initial board layout
		ArrayList<String> board = new ArrayList<String>();
		board.add(lines.get(16));
		board.add(lines.get(17));
		board.add(lines.get(18));
		board.add(lines.get(19));
		board.add(lines.get(20));
		board.add(lines.get(21));
		board.add(lines.get(22));
		board.add(lines.get(23));
		board.add(lines.get(24));
		Board b = setBoard(board);
		
		// get level
		Level lvl;
		String level = lines.get(0);
		String mode = lines.get(1);
		switch (mode) {
		case "Puzzle":
			lvl = LevelFactory.getPuzzleLevel(Integer.valueOf(level), b, winStats, freq);
			break;

		case "Lightning":
			lvl = LevelFactory.getLightningLevel(Integer.valueOf(level), b, winStats, freq);
			break;

		case "Elimination":
			lvl = LevelFactory.getEliminationLevel(Integer.valueOf(level), b, winStats, freq);
			break;

		case "Release":
			lvl = LevelFactory.getReleaseLevel(Integer.valueOf(level), b, winStats, freq);
			break;

		default:
			lvl = null;
			break;
		}
		
		if (lvl != null) {
			// Number of power up allowed
			String swaps = lines.get(4);		
			String shuffle = lines.get(5);
			String remove = lines.get(6);
			lvl.getGame().getPwrUps()[Game.PWRUP_SWAP]    = Integer.valueOf(swaps);
			lvl.getGame().getPwrUps()[Game.PWRUP_SHUFFLE] = Integer.valueOf(shuffle);
			lvl.getGame().getPwrUps()[Game.PWRUP_REMOVE]  = Integer.valueOf(remove);
		}
		
		return lvl;
	}

	public static List<Level> loadMemento() throws IOException {
		ArrayList<Level> levels = new ArrayList<Level>();
		
		try {
			URI uri = MementoManager.class.getResource(filePath).toURI();
			
			File folder = new File(uri);
			File[] files = folder.listFiles();
			
			if (files != null) {
				for (File file : files) {
					levels.add(loadMemento(file.getName()));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return levels;
	}

	/**
	 * @param file
	 *            to read
	 * @return an array of lines in the file
	 */
	static ArrayList<String> readLines(String name) {
		ArrayList<String> lines = new ArrayList<String>();
		
		InputStream is = null;
		BufferedReader reader = null;
		try {
			is = MementoManager.class.getResourceAsStream(filePath.concat(name));			

			reader = new BufferedReader(new InputStreamReader(is));
			
			// Read all the lines in the file
			String line = reader.readLine();
			do {
				if (line != null) {
					lines.add(line);
				}
				line = reader.readLine();
			} while (line != null);		
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return lines;
	}

	static Board setBoard(ArrayList<String> s) {
		Board b = new Board(false);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Point p = new Point(j, i);
				String str = s.get(i).substring(j * 3, j * 3 + 3);
				String[] strArray = str.split(",");
				if (strArray.length == 2) {
					if (strArray[0].equals("*") && strArray[1].equals("*")) {
						// Release square
						b.getSquare(p).setSelectable(false);
						b.getSquare(p).setOnlySix(true);
					} else {
						int val = Integer.valueOf(str.split(",")[0]);
						int mul = Integer.valueOf(str.split(",")[1]);
						// "0,0" is blank, so it works out fine, null t is expected
						if (val == 0 && mul == 0)
							b.getSquare(p).setSelectable(false);
						
						Tile t = TileFactory.getTile(val, mul);
						b.replace(p, t);
					}
				}
			}
		}
		
		// Any error will simply result in a blank square
		return b;
	}
}