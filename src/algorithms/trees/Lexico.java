package algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import entities.Node;

class Lexico {
	
	int count  = 0; 
	public String smallestFromLeaf(Node root) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		result = leafPaths(root, new ArrayList<Integer>(), result);
		StringBuilder str = new StringBuilder();
		for (int i = result.size() - 1; i >= 0; i--) {
			str.append((char) (result.get(i) + 97));
		}
		return str.toString();

	}

	public ArrayList<Integer> leafPaths(Node root, ArrayList<Integer> path, ArrayList<Integer> result) {

		if (root == null) {
			return result;
		}
		path.add(root.data);
		if (root.left == null && root.right == null) {
			result = getMin(result, path);
			return result;
		}
		result = leafPaths(root.left, new ArrayList<Integer>(path), result);
		result = leafPaths(root.right, new ArrayList<Integer>(path), result);
		return result;

	}

	public ArrayList<Integer> getMin(ArrayList<Integer> currMin, ArrayList<Integer> str) {

		if (currMin.size() == 0) {
			return str;
		}
		int len = Math.min(currMin.size(), str.size());
		int i = currMin.size() - 1;
		int j = str.size() - 1;
		for (int k = len - 1; k >= 0; k--) {
			if (currMin.get(i) < str.get(j)) {
				return currMin;
			}
			if (currMin.get(i) > str.get(j)) {
				return str;
			}
			i--;
			j--;
		}
		if (currMin.size() > str.size()) {
			return str;
		}
		if (currMin.size() < str.size()) {
			return currMin;
		}
		return currMin;
	}
    public int minCameraCover(Node root) {
        
        cameraNodeCount(root, null);
        return count;
        
    }
    
    public boolean cameraNodeCount(Node root, Node parent) {
        
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null && parent!=null) {
            return false;
        }
        if(root.left == null && root.right == null && parent==null) {
            count++;
            return true;
        }
        
        boolean isLeftChildCamera = cameraNodeCount(root.left, root);
        boolean isRightChildCamera = cameraNodeCount(root.right, root);
        boolean curr = !(isLeftChildCamera || isRightChildCamera);
        if(curr == true){
            count++;
        }
        
        return curr;
        
    }

}
