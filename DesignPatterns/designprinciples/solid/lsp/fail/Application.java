package solid.lsp.fail;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String args[]){
		//load and save
		saveAll(loadAll());
		System.out.println("Finished");
	}
	
	private static Iterable<IPersistedResource> loadAll(){
		List<IPersistedResource> allResources = new ArrayList<IPersistedResource>();
		
		allResources.add(new UserSettings());
		allResources.add(new ApplicationSettings());
		
		allResources.forEach(r -> r.load());
		
		return allResources;
	}
	
	private static void saveAll(Iterable<IPersistedResource> resources){
		resources.forEach(r -> r.persist());
	}
	
}
