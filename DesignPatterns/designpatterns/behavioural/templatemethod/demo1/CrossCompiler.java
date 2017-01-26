package behavioural.templatemethod.demo1;

public abstract class CrossCompiler {
	public final void crossCompile() {
		collectSource();
		compileToTarget();
	}

	// Template methods
	protected abstract void collectSource();

	protected abstract void compileToTarget();
}