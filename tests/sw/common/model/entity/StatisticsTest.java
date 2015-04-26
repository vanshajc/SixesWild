/**
 * @file StatisticsTest.java
 * @author Vanshaj Chowdhary
 */
package sw.common.model.entity;

import java.sql.Time;

import junit.framework.TestCase;

public class StatisticsTest extends TestCase{
	
	public void test(){
		Statistics stats = new Statistics();
		
		assertEquals(0, stats.getNumMoves());
		assertEquals(0, stats.score);
		assertEquals(0, stats.stars);
		
		stats.setNumMoves(1);
		assertEquals(1, stats.getNumMoves());
		
		stats.setScore(100);
		assertEquals(100, stats.getScore());
		
		stats.setStars(1);
		assertEquals(1, stats.getStars());
		
		stats.setTime(Time.valueOf("00:00:40"));
		stats.getTime();
	}
	
}
