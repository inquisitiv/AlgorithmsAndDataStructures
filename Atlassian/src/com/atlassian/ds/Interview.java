package com.atlassian.ds;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

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
public class Interview {
	
	
	
	private HashMap<String, Collection> insertCollectionList(ArrayList<Input> inputlist) {
		
		
		HashMap<String, Collection> list = new HashMap<>();
		for(Input in : inputlist) {
			File file = new File(in.fileName, in.fileSize);
			String collectionId = in.collectionId;
			if(list.containsKey(collectionId)){
				list.get(collectionId).addFile(file);
			} else {
				Collection newCol = new Collection(collectionId);
				newCol.addFile(file);
				list.put(collectionId, newCol);
			}
 			
		}
		return list;
		
	}
	
	public int totalSizeOfAllFiles(ArrayList<Input> inputlist) {
		
		// n
		HashMap<String, Collection> list = insertCollectionList(inputlist);
		int tSize = 0;
		// k
		for(Entry<String, Collection> cEntry : list.entrySet()) {
			tSize = tSize + cEntry.getValue().totalsize;
		}
		return tSize;
		
	}
	
   public ArrayList<String> topNCollections(ArrayList<Input> inputlist, int n) {
	   // s:k
	   ArrayList<String> result = new ArrayList<String>();
	    //n // n
		HashMap<String, Collection> list = insertCollectionList(inputlist);
		//1 //s:k
		PriorityQueue<Collection> minHeap = new PriorityQueue<Collection>(new Comparator<Collection>() {

			@Override
			public int compare(Collection o1, Collection o2) {
				// TODO Auto-generated method stub
				if(o1.totalsize > o2.totalsize) {
					return 1;
				} else if (o1.totalsize < o2.totalsize) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		
	    // nLog k
		for(Entry<String, Collection> cEntry : list.entrySet()) {
			minHeap.add(cEntry.getValue());
			if(minHeap.size()>n) {
				minHeap.remove();
			}
		}
		
		//k
		while(!minHeap.isEmpty()) {
			result.add(minHeap.remove().id);
		}
		
		return result;
		
	}
	
	
	
	

	
	
}
