package algorithms.lru;

public class LRUNode {
	
	private int pageNumber;
	private String pageDetails;
	
	public LRUNode(int pageNumber, String pageDetails) {
		this.pageNumber = pageNumber;
		this.pageDetails = pageDetails;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getPageDetails() {
		return pageDetails;
	}
	public void setPageDetails(String pageDetails) {
		this.pageDetails = pageDetails;
	}
	
}
