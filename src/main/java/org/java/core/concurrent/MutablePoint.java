package org.java.core.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class MutablePoint {
	public int x,y;

	public MutablePoint() {
		x=0;y=0;
	}
	public MutablePoint(MutablePoint p) {
		x=p.x;
		y=p.y;
	}
	
	@Override
	public String toString() {
		return "MutablePoint [x=" + x + ", y=" + y + "]";
	}
	public static void main(String[] args) {
		Map<String,MutablePoint> map=new HashMap<>();
		map.put("car", new MutablePoint());
		Map<String, MutablePoint> cc=Collections.unmodifiableMap(map);
		map.put("red", new MutablePoint());
		System.out.println(cc);
		/*MonitorVehicleTracker m=new MonitorVehicleTracker(map);
		ExecutorService exec=Executors.newCachedThreadPool();
		exec.execute(new Runnable() {
			@Override
			public void run() {
				m.setLocation("car", 5, 6);
			}
		});
		while(true){
			exec.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(m.getLocations());
				}
			});
		}*/
	}
}
