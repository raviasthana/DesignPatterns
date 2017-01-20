package solid.lsp.pass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

	public static void main(String args[]){
		//load and save
		saveAll(getPersistableResources(loadAll()));
		//saveAll(ofTypeWithStream(IPersistedResource.class,loadAll()));
		System.out.println("Finished");
	}
	
	private static List<ILoadResource> loadAll(){
		List<ILoadResource> allResources = new ArrayList<ILoadResource>();
		
		allResources.add(new UserSettings());
		allResources.add(new ApplicationSettings());
		allResources.add(new SpecialSettings()); //Now this should work
		
		allResources.forEach(r -> r.load());
		
		return allResources;
	}
	
	private static void saveAll(List<IPersistedResource> resources){
		resources.forEach(r -> r.persist());
	}
	
	//this is just for the demo sake, need to find the better way
	private static List<IPersistedResource> getPersistableResources(List<ILoadResource> resources){
		
		List<IPersistedResource> pResources = new ArrayList<IPersistedResource>();
		
		pResources = resources.stream()
				.filter(r -> r instanceof IPersistedResource)
				.map(p -> (IPersistedResource)p)
				.collect(Collectors.toList());
		
		return pResources;
	}
	
	@SuppressWarnings("unchecked")
	private static <T> List<T> ofTypeWithStream(Class<?> out, List<Object> list) {
	    return list.stream().filter(x -> out.isAssignableFrom(x.getClass()))
	               .map(x -> (T) x) // unchecked
	               .collect(Collectors.toList());
	}
	
	private static <T> List<T> ofType(Class<?> out, List<Object> list) {
	    List<T> outList = new ArrayList<T>(list.size());
	    for(Object o : list) {
	        if ( out.isAssignableFrom(o.getClass())) {
	            outList.add((T)o);
	        }
	    }
	    return outList;
	}
}
