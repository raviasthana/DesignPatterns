package solid.ocp.pass;

/*
 * interface to abstract event services
 */
public interface EventService<E extends Event> {
	void process(E Event);
}
