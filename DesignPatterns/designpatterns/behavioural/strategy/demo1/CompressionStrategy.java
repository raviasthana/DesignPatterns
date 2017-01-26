package behavioural.strategy.demo1;

import java.io.File;
import java.util.List;

//Strategy Interface
public interface CompressionStrategy {
	public void compressFiles(List<File> files);
}