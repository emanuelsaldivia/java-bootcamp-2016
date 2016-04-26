package topic1.RecentFilesList;

import java.util.LinkedList;
import java.util.List;

public class FilesList {
	
	private List<File> list;
	
	public void newList(){
	list= new LinkedList<File>();
	}
	
	public void addFile(File file){
		if (file.isOpen()==true){
			if (list.contains(file)){
				list.remove(file);
			}
			if (list.size()==15){ //the list is full with the maximum amount of files
				list.remove(0); //removes the first introduced file into the list
			}
			list.add(file);
		}
	}
	
	public void clearList(){
		list.clear();
	}
}
