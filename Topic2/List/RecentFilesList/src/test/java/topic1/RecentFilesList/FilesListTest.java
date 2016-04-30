package topic1.RecentFilesList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import topic1.RecentFilesList.*;

public class FilesListTest {

	File f;
	FilesList list;
	
	@Before
	public void setUpFile() throws Exception{
		f = new File();
		f.setFileName("file1");
		list = new FilesList();
		list.clearList();
	}
	
	@Test
	public void testFileName(){
		assertEquals("file1",f.getFileName());
	}
	
	@Test
	public void testWrongFileName(){
		assertEquals("file2",f.getFileName());
	}
	
	@Test
	public void testOpenFile(){
		f.openFile();
		assertTrue(f.openFile==true);
	}
	
	@Test
	public void testClosedFile(){
		assertTrue(f.openFile==false);
		f.closeFile();
		assertTrue(f.openFile==false);
	}
	@Test
	public void listIsEmpty(){
		assertNull(list);
	}
}
