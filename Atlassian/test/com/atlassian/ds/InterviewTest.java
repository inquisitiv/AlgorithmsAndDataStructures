package com.atlassian.ds;

import java.util.ArrayList;

import org.junit.Test;
/*
 * The total size of all files stored; and
The top N collections (by file size) where N can be a user-defined value
[
{file: "file1.txt", size: 100},
{file: "file2.txt", size: 200, collectionId: "collection1"},
{file: "file3.txt", size: 200, collectionId: "collection1"},
{file: "file4.txt", size: 300, collectionId: "collection2"},
{file: "file5.txt", size: 10}

{{"collectionId", "filename", "100"},{{}}

ArrayList<ArrayList<String>> entry = 

entry(String collectuionId, filename, int size)


]  
 */

public class InterviewTest {

	
	
	@Test
	public void testTopNCollection() {
		
		Interview it = new Interview();
		ArrayList<Input> inputlist = new ArrayList<Input>();
		Input i1 = new Input();
		i1.collectionId = "others";
		i1.fileName = "file1";
		i1.fileSize = 100;
		inputlist.add(i1);
		i1 = new Input();
		i1.collectionId = "collection1";
		i1.fileName = "file2";
		i1.fileSize = 200;
		inputlist.add(i1);
		i1 = new Input();
		i1.collectionId = "collection1";
		i1.fileName = "file3";
		i1.fileSize = 200;
		inputlist.add(i1);
		i1 = new Input();
		i1.collectionId = "collection2";
		i1.fileName = "file4";
		i1.fileSize = 300;
		inputlist.add(i1);
		i1 = new Input();
		i1.collectionId = "others";
		i1.fileName = "file1";
		i1.fileSize = 10;
		inputlist.add(i1);
		
		System.out.println(it.topNCollections(inputlist, 1).toString());
		
		
		
	}
	
}
