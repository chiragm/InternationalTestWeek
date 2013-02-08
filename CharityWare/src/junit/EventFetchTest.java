package junit;

import hibernateEntities.Event;
import hibernateEntities.User;
import hibernateManagers.UserManager;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import RESTClient.EventClient;
import RESTservices.EventService;

public class EventFetchTest {

	
	List<Event> events;
	
	
	@Before
	public void init() {
		events = new LinkedList<Event>();
		Event event2 = new Event();
		event2.setEvent_location("London");
		event2.setEvent_description("");
		Event event3 = new Event();
		event3.setEvent_location("London");
		event3.setEvent_description("");
		events.add(event2);
		events.add(event3);
	}
	
	
	@Test
	public void test() {
		Map<Integer,List<String>> testEvents = EventClient.getEvents();
		Set<Entry<Integer,List<String>>> tev = testEvents.entrySet();
		Iterator<Entry<Integer,List<String>>> it = tev.iterator();
		assertEquals("Wrong number of retrieved events", 2, tev.size());
		int index =0;
		while (it.hasNext()) {
			index++;
			List<String> values = it.next().getValue();
			Integer id = it.next().getKey().intValue();
			assertNotNull("Event "+index+ " with "+id+" has no name",values.get(0));
			assertNotNull("Event "+index+" with "+id+" has no time associated with it",values.get(1));
		}
	}
	
	
	@After
	public void close() {
		
	}
}
