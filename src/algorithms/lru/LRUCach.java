package algorithms.lru;

import java.util.HashMap;

import entities.DoublyLinkedList;
import entities.GenericNode;

public class LRUCach {
	
	private HashMap<Integer,GenericNode<LRUNode>> easyAccess;
	private DoublyLinkedList<LRUNode> lruDB;
	
	public LRUCach() {
		easyAccess = new HashMap<>();
		lruDB = new DoublyLinkedList<LRUNode>();
	}
	
	
	public String getPageFromCache(int pageNumber) {
		
		GenericNode<LRUNode> value = easyAccess.get(pageNumber);
		if(value != null) {
			return value.getValue().getPageDetails();
		} else {
			return getAndSetInCache(pageNumber) + " --- Oops, Its a miss! Next time you will find it in cache";
		}
		
	
	}
	
    private String getAndSetInCache(int pageNumber) {
    	
    	String pageDetails = getDataFromMainMemory(pageNumber);
    	LRUNode newPageInCache = new LRUNode(pageNumber, pageDetails);
        if (easyAccess.size() == 5) {
        	GenericNode<LRUNode> removedNode = lruDB.removeFromTail();
        	if(removedNode!= null) {
            easyAccess.remove(removedNode.getValue().getPageNumber());
        	}
        }
        lruDB.insertAtHead(newPageInCache);
        easyAccess.put(pageNumber, lruDB.getHead());
        
        return pageDetails;
		
	}
    
    private String getDataFromMainMemory(int pageNumber) {
    	
    	return "Let's start reading Page number " + pageNumber;
    	
    }

}
