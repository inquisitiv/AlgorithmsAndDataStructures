package com.atlassian.ds;

public class File {
	String fileName;
	int filesize;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public File(String filename, int filesize) {

		this.fileName = filename;
		this.filesize = filesize;

	}

}
