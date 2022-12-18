package Day7;

import java.util.ArrayList;

public class Directory {
	
	private int size;
	private String name;
	private ArrayList<Directory> subDir = new ArrayList<Directory>();
	private ArrayList<File> files = new ArrayList<File>();
	private Directory parent = null;
	
	public Directory() {
		size = 0;
	}
	
	public Directory(String name, Directory parent) {
		size = 0;
		this.name = name;
		this.parent = parent;
	}
	
	public Directory(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSize() {
		return size;
	}
	
	public void add(Directory newDir) {
		subDir.add(newDir);
	}
	
	public ArrayList<Directory> get() {
		return subDir;
	}
	
	public Directory get(int index) {
		return subDir.get(index);
	}
	
	public Directory findName(String name) {
		Directory ret = new Directory();
		for(int i = 0; i < subDir.size(); i++) {
			if(subDir.get(i).getName().equals(name)) {
				ret = subDir.get(i);
			}
		}
		return ret;
	}
	
	public int determineSize() { // Nicht im Betrieb im Moment
		subDir.forEach(i -> size += i.determineSize());
		return size;
	}
	
	public void newFile(int size) {
		this.size += size;
//		if(size > Global.threshold && !Global.overLimit.contains(this)) Global.overLimit.add(this);
		if(parent != null) parent.newFile(size);
	}
	
	public void addFile(String name, int size) {
		files.add(new File(name, size));
		newFile(size);
	}
	
	public ArrayList<File> getFiles() {
		return files;
	}

	public Directory getParent() {
		return parent;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
	}
	
}
