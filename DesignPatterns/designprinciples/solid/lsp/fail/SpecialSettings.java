package solid.lsp.fail;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SpecialSettings implements IPersistedResource {

	@Override
	public void load() {
		// TODO Auto-generated method stub
	}

	@Override
	public void persist() {
		throw new NotImplementedException();
	}

}
