import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class FileTest {
	@Test
	public void openFileInMemory() {
	    String expectedData = "Hello World from fileTest.txt!!!";
	    String data = null;
	    
	    Path path;
		try {
		  path = Paths.get(getClass().getClassLoader().getResource("fileTest.txt").toURI());
		  System.out.println(path);
		  Stream<String> lines = Files.lines(path);
		  data = lines.collect(Collectors.joining("\n"));
		  ines.close();
		  assertEquals(data.trim(), expectedData);
		} catch (URISyntaxException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		} catch (IOException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		}
	}
	
	@Test
	public void streamFromBigFile(String path) {
		Scanner sc = null;
		try(FileInputStream is = new FileInputStream(path)) {
			sc = new Scanner(is, "UTF-8");
			while (sc.hasNextLine()) {
			  String line = sc.nextLine();
			  // System.out.println(line);
			}
			// Scanner suppresses exceptions
			if (sc.ioException() != null) {
		        throw sc.ioException();
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		    if (sc != null) {
		        sc.close();
		    }
		}
	}
	
	@Test
	public void openFileFromJAR() {
    	  String expectedData = "BSD License";
	  Class clazz = Matchers.class;
	  InputStream inputStream = clazz.getResourceAsStream("/LICENSE.txt");
	  String data = readFromInputStream(inputStream);
    	  Assert.assertThat(data, containsString(expectedData));
	}
}
