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
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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

	static final String levelFormat = "%d,%s,%d,%d,%s,%s";
	static final String levelRegex = "(\\d),(\\D+),(\\d+),(\\d+),(\\d{2}):(\\d{2}):(\\d{2}),(\\d+)";
	static final int levelFormatCount = 6;

	static String filePath = "src/sw/resource/levelData/";
	static String progressFile = "src/sw/resource/progress/Progress.txt";

	/**
	 * A cache of the player's progress, will be pushed out when the Level
	 * finish Need to override the Window's close method to push this out before
	 * exit application
	 */
	static ArrayList<String> progress = null;

	/** Load progress into cache */
	public static void initialize() {
		progress = readLines(progressFile);

		// Set default highest level to 1
		if (progress.isEmpty()) {
			progress.add("1");
		}
	}

	/** Save a level to player's progress */
	public static void saveLevel(Level level) {
		if (level != null) {
			String lvlStr = exportLevel(level);
			if (lvlStr != null) {
				// Search cache to see if level already exists
				for (int i = 1; i < progress.size(); i++) {
					Level l = importLevel(progress.get(i));

					// TODO make sure every level number is unique
					if (l.getLevelNum() == level.getLevelNum()) {
						Statistics s1 = l.getGame().getStats();
						Statistics s2 = level.getGame().getStats();

						// Found new high score
						if (s2.getScore() > s1.getScore()) {
							progress.set(i, lvlStr);
							return;
						}
					}
				}

				// If did not find the same level, just add it
				progress.add(lvlStr);
			}
		}
	}

	/**
	 * Save player's progress to a file
	 * 
	 * @throws IOException
	 */
	public static void saveProgress() throws IOException {
		try {
			PrintWriter out = new PrintWriter(progressFile);

			for (String s : progress) {
				out.println(s);
			}

			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			throw new IOException("Can't find progress file!");
		}
	}

	/**
	 * @return the highest level number unlocked from saved progress
	 */
	public static Integer getHighestLevel() {
		if (!progress.isEmpty()) {
			return Integer.valueOf(progress.get(0));
		}
		return 1; // Default highest level is 1
	}

	/**
	 * Set the highest level unlocked
	 * 
	 * @param highest
	 *            the level number to unlock
	 */
	public static void setHighestLevel(int highest) {
		if (highest > getHighestLevel()) {
			progress.set(0, String.valueOf(highest));
		}
	}

	/**
	 * @return a hashmap containing the high score for each Level
	 * @throws IOException
	 */
	public static HashMap<Integer, Level> loadProgress() {
		HashMap<Integer, Level> list = new HashMap<Integer, Level>();

		if (!progress.isEmpty() && progress.size() > 1) {
			for (int i = 1; i < progress.size(); i++) {
				Level l = importLevel(progress.get(i));
				if (l != null) {
					list.put(l.getLevelNum(), l);
				}
			}
		}

		return list;
	}

	/**
	 * Import a Level progress from exported string
	 * 
	 * @param str
	 *            the level export string
	 * @return the Level imported
	 */
	static Level importLevel(String str) {
		Level l = null;
		if (str.matches(levelRegex)) {
			String[] data = str.split(",");
			if (data.length == levelFormatCount) {
				int levelNum = Integer.valueOf(data[0]);
				String levelMode = data[1];

				int levelScore = Integer.valueOf(data[2]);
				int levelMove = Integer.valueOf(data[3]);
				Time levelTime = Time.valueOf(data[4]);
				int levelStars = Integer.valueOf(data[5]);

				switch (levelMode) {
				case "Puzzle":
					l = LevelFactory.getPuzzleLevel(levelNum, null, null, null);
					break;
				case "Release":
					l = LevelFactory
							.getReleaseLevel(levelNum, null, null, null);
					break;
				case "Lightning":
					l = LevelFactory.getLightningLevel(levelNum, null, null,
							null);
					break;
				case "Elimination":
					l = LevelFactory.getEliminationLevel(levelNum, null, null,
							null);
					break;
				}

				Statistics stats = l.getGame().getStats();
				stats.setScore(levelScore);
				stats.setNumMoves(levelMove);
				stats.setTime(levelTime);
				stats.setStars(levelStars);
			}
		}
		return l;
	}

	/**
	 * Export a Level statistics to a string
	 * 
	 * @param level
	 *            the Level to export
	 * @return the exported string
	 */
	static String exportLevel(Level level) {
		if (level != null) {
			Game g = level.getGame();
			if (g != null) {
				Statistics stats = g.getStats();
				if (stats != null) {
					return String.format(levelFormat, level.getLevelNum(),
							level.getMode().toString(), stats.getScore(),
							stats.getNumMoves(), stats.getTime(),
							level.getStars());
				}
			}
		}
		return null;
	}

	/**
	 * Load a playable level from saved text
	 * 
	 * @param name
	 *            the name of the level text
	 * @return the playable Level
	 * @throws IOException
	 */
	public static Level loadPlayableLevel(String name) throws IOException {
		Level lvl = null;
		ArrayList<String> lines = readLines(name);

		if (lines.size() == 28) {
			// Winning statistics
			String move = lines.get(2);
			String time = lines.get(3); // assume minutes here ???
			Statistics winStats = new Statistics();
			winStats.setNumMoves(Integer.parseInt(move));

			String time1 = String.format("%02d:%02d:%02d", 0, 0,
					Integer.parseInt(time));
			winStats.setTime(Time.valueOf(time1));

			String scoreOneStar = lines.get(25);
			String scoreTwoStar = lines.get(26);
			String scoreThreeStar = lines.get(27);
			winStats.setScoreOneStar(Integer.parseInt(scoreOneStar));
			winStats.setScoreTwoStar(Integer.parseInt(scoreTwoStar));
			winStats.setScoreThreeStar(Integer.parseInt(scoreThreeStar));

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
			String level = lines.get(0);
			String mode = lines.get(1);
			switch (mode) {
			case "Puzzle":
				lvl = LevelFactory.getPuzzleLevel(Integer.valueOf(level), b,
						winStats, freq);
				break;

			case "Lightning":
				lvl = LevelFactory.getLightningLevel(Integer.valueOf(level), b,
						winStats, freq);
				break;

			case "Elimination":
				lvl = LevelFactory.getEliminationLevel(Integer.valueOf(level),
						b, winStats, freq);
				break;

			case "Release":
				lvl = LevelFactory.getReleaseLevel(Integer.valueOf(level), b,
						winStats, freq);
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
				lvl.getGame().getPwrUps()[Game.PWRUP_SWAP] = Integer
						.valueOf(swaps);
				lvl.getGame().getPwrUps()[Game.PWRUP_SHUFFLE] = Integer
						.valueOf(shuffle);
				lvl.getGame().getPwrUps()[Game.PWRUP_REMOVE] = Integer
						.valueOf(remove);
			}
		}

		return lvl;
	}

	/**
	 * Load all playable levels
	 * 
	 * @return a list of all playable levels
	 */
	public static List<Level> loadPlayableLevel() {
		ArrayList<Level> levels = new ArrayList<Level>();

		try {
			File folder = new File(filePath);
			File[] files = folder.listFiles();

			if (files != null) {
				for (File file : files) {
					if (file.getName() != "Progress.txt") {
						levels.add(loadPlayableLevel(file.getAbsolutePath()));
					}
				}
			}
		} catch (Exception e) {
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

		File file = new File(name);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));

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
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return lines;
	}

	/**
	 * @param s
	 *            arraylist containing the value,multiplier for each tile
	 * @return the board created
	 */
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
						// "0,0" is blank, so it works out fine, null t is
						// expected
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
