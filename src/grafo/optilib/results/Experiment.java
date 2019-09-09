package grafo.optilib.results;

import grafo.optilib.metaheuristics.Algorithm;
import grafo.optilib.structure.Instance;
import grafo.optilib.structure.InstanceFactory;
import grafo.optilib.tools.RandomManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Experiment<I extends Instance, IF extends InstanceFactory<I>> {

	private final long SEED = 1234;
	
	private Algorithm<I> alg;
	private IF factory;
	
	public Experiment(Algorithm<I> alg, IF factory) {
		this.alg = alg;
		this.factory = factory;
	}
	
	private List<String> readFilesInFolder(String folder, String[] extensions) {
		List<String> files = null;
		try {
//		    files = new File(folder).list(((dir, name) -> {
//		        for (int i=0;i<extensions.length;i++) {
//		            String ext = extensions[i];
//                    if (name.startsWith(".")) {
//                        return false;
//                    }
//                    if ((areRegex == null || !areRegex[i]) && name.endsWith(ext)) {
//                        return true;
//                    } else if (areRegex != null && areRegex[i]) {
//                        Pattern pattern = Pattern.compile(ext);
//
//                    }
//                }
//            }));

			files = Files.list(Paths.get(folder))
					.map(String::valueOf)
					.filter(path -> {
						for (String ext : extensions) {
							if (path.substring(Math.max(path.lastIndexOf("/"), path.lastIndexOf("\\"))+1).startsWith(".")) {
								return false;
							}
							if (path.endsWith(ext) || path.matches(ext)) {
								return true;
							}
						}
						return false;
					})
					.sorted()
					.collect(Collectors.toList());
		} catch (IOException e) {
			//e.printStackTrace();
		}
		return files;
	}
	
	public void launch(String inputFolder, String outputFile, String[] extensions) {
		List<String> files = readFilesInFolder(inputFolder, extensions);
		if (files == null) {
			System.err.println("The folder "+inputFolder+" does not contain any file matching the given extensions");
			System.exit(-1);
		}
		List<Result> results = new ArrayList<>();
		List<String> fails = new ArrayList<>();
		System.out.println("ALGORITHM: "+alg.toString());
		for (String file : files) {
			RandomManager.setSeed(SEED);
			I instance = factory.readInstance(file);
            Result res = alg.execute(instance);
            results.add(res);
		}
		TableCreator.createTable(outputFile, results);
//		try {
//            PrintWriter pw = new PrintWriter(outputFile + "_fails.txt");
//            for (String f : fails) {
//                pw.println(f);
//            }
//            pw.close();
//        } catch (IOException e) {
//		    e.printStackTrace();
//        }
	}


	public static void main(String[] args) throws IOException {
		String[] extensions = new String[]{".doc",".pdf"};
		List<String> files = Files.list(Paths.get("/Users/jesussanchezoro/Dropbox/Universidad/Energy prediction/1st rev"))
				.map(String::valueOf)
				.filter(path -> {
					for (String ext : extensions) {
						if (path.endsWith(ext)) {
							return true;
						}
					}
					return false;
				})
				.sorted()
				.collect(Collectors.toList());
		System.out.println(files);
	}
}
