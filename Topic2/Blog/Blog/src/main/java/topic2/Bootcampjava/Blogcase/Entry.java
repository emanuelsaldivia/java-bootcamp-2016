package topic2.Bootcampjava.Blogcase;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Entry {

	private int entryID;
	private String title;
	private String author;
	private String body;
	private String postDate;
	private static int IDGenerator=0;
	
	public Entry (String title,String author,String body,String postDate){
		this.entryID=IDGenerator++;
		this.title=title;
		this.author=author;
		this.body=body;
		this.postDate=postDate;
	}
	
	public void setID (int entryID){
		this.entryID=entryID;
	}
	
	public void setTitle (String title){
		this.title=title;
	}
	
	public void setAuthor (String author){
		this.author=author;
	}
	
	public void setBody (String body){
		this.body=body;
	}
	
	//setting current date
	public void setPostDate (){
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Date date = new Date();
		 this.postDate=dateFormat.format(date);
	}
	
	
	public int getEntryId(){
		return this.entryID;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getAuthor(){
		return this.author;
	}
	
	public String getBody(){
		return this.body;
	}
	
	public String getDate(){
		return this.postDate;
	}
	
}
