/**
 * @file TimerTaskManager.java
 * @author Tony Vu
 */
package sw.common.system.manager;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskManager {
	
	static HashMap<String, Timer> schedule = new HashMap<String, Timer>();
	
	public static void scheduleTask(String name, TimerTask task, long period) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, period);
		
		schedule.put(name, timer);
	}
	
	public static void cancelAll() {
		for (Timer t : schedule.values()) {
			t.cancel();			
		}
		schedule.clear();
	}
	
	public static void cancelTask(String name) {
		if (schedule.containsKey(name)) {
			schedule.get(name).cancel();
			schedule.remove(name);
		}
	}

}
