package com.atlassian.ds;

import java.util.ArrayList;

public class Collection {

	String id;
	ArrayList<File> fileSet;
	int totalsize;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<File> getFileSet() {
		return fileSet;
	}

	public void setFileSet(ArrayList<File> fileSet) {
		this.fileSet = fileSet;
	}

	public int getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}

	

	public Collection(String id) {
		this.id = id;
		fileSet = new ArrayList<File>();
		totalsize = 0;
	}

	public Collection(String id, ArrayList<File> files) {
		this.id = id;
		fileSet = files;
		totalsize = 0;
		for (File file : files) {
			totalsize = totalsize + file.getFilesize();
		}
	}

	public void addFile(File file) {
		if (fileSet == null) {
			fileSet = new ArrayList<File>();
		}
		fileSet.add(file);
		totalsize = totalsize + file.getFilesize();
	}

}
