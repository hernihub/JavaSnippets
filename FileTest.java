public class FileTest {

	@Test
	public void givenFilePath_whenUsingFilesLines_thenFileData() {
	    String expectedData = "Hello World from fileTest.txt!!!";
	    String data = null;
	    
	    Path path;
		try {
			path = Paths.get(getClass().getClassLoader().getResource("fileTest.txt").toURI());
			System.out.println(path);
			Stream<String> lines = Files.lines(path);
			data = lines.collect(Collectors.joining("\n"));
		    lines.close();
		    
		    assertEquals(data.trim(), expectedData);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	          
	}

}
