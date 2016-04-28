package topic2.Blog;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import topic2.Bootcampjava.Blogcase.*;
import org.junit.Before;
import org.junit.Test;

public class BlogTesting {

	Entry e;
	Blog b;
	
	@Before
	public void setUpBlog() throws Exception{
		b= new Blog();
		Entry entry1=new Entry("Othelo","Shakespeare","this is Othelo","2016-04-28");
		b.newPost(entry1);
		Entry entry2=new Entry("My First Notice","Clark Kente","Notice body","2016-04-28");
		b.newPost(entry2);
		Entry entry3=new Entry("The killing Joke","Alan Moore","batamn vs the joker","1988-03-27");
		b.newPost(entry3);
	}
	
	@Test
	public void newEntryTest (){
		Entry e=new Entry ("new entry test","tester","this is a test","2016-04-28");
		b.newPost(e);
		assertTrue(b.newPost(e));
	}
	
	@Test
	public void deleteEntryTest (){
		Entry e=new Entry("delete entry test","tester","this is a test","2016-04-28");
		b.deletePost(e.getEntryId());
		assertTrue(b.deletePost(e.getEntryId()));
		
	}
	
	@Test
	public void RecentEntriesAre10Test (){
		List<Entry> recentList;
		
		recentList=b.recentEntries();
		
		assertEquals(10,recentList.size());
	}
}
