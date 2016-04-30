package topic1.RecentFilesList;

import java.util.LinkedList;
import java.util.List;

public class FilesList {
	
	private int listLimit=15;
	private int firstElement=0;
	private List<File> list;
	
	public void newList(){
	list= new LinkedList<File>();
	}
	
	public void addFile(File file){
		if (file.isOpen()==true){
			if (list.contains(file)){
				list.remove(file);
			}
			if (list.size()==listLimit){ //the list is full with the maximum amount of files
				list.remove(firstElement); //removes the first introduced file into the list
			}
			list.add(file);
		}
	}
	
	public void clearList(){
		list.clear();
	}
}
