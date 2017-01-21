package org.java.core.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MonitorVehicleTracker {
  
	private final Map<String,MutablePoint> localtions;
	
	public MonitorVehicleTracker(Map<String, MutablePoint> localtions) {
		this.localtions = localtions;
	}
	
	public synchronized Map<String,MutablePoint> getLocations(){
		return deepcopy(localtions);
	}
	public synchronized void setLocation(String id,int x,int y){
		MutablePoint m=localtions.get(id);
		if(m==null){
			throw new RuntimeException();
		}
		m.x=x;
		m.y=y;
	}
    private static Map<String,MutablePoint> deepcopy( Map<String,MutablePoint> m){
    	 Map<String,MutablePoint> result=new HashMap<>();
    	 for(String id:m.keySet()){
    		 result.put(id, new MutablePoint(m.get(id)));
    	 }
    	 return Collections.unmodifiableMap(result);
    }
}
