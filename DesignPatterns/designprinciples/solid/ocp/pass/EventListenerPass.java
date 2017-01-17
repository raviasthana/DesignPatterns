package solid.ocp.pass;

import java.util.HashMap;
import java.util.Map;

import solid.ocp.fail.UnhandledEventException;

/*
 * This class is closed for modification in terms of processing of 'Events'
 * As new events and event services can be added and processed without
 * modifying the code.
 * - So this implementation is OPEN for extension in terms of addition of
 *   more functionality
 * - and this implementation is CLOSED for modification in terms of
 *   processing of events
 *   
 * Event after addition of new functionality, this class can be used by 
 * existing classes that make use of event processing code
 * 
 */
public class EventListenerPass {
	
	//This can be populated via api method or spring configuration
	private final Map<Class<Event>,EventService<Event>> eventServiceMap;
	
	public EventListenerPass() {
		eventServiceMap = new HashMap<Class<Event>, EventService<Event>>();
	}
	
	public void addEventServiceMapping(Class<Event> clazz, EventService<Event> service){
		eventServiceMap.put(clazz, service);
	}
	
	public void receive(Event event) throws Exception{
		if(eventServiceMap.containsKey(event)){
			eventServiceMap.get(event.getClass()).process(event);
		}else{
			throw new UnhandledEventException();
		}
	}
}
