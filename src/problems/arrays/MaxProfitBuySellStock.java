package problems.arrays;

public class MaxProfitBuySellStock {

	public static void main(String[] args) {

		int[] stocks = { 2, 30, 15, 10, 8, 25, 80 };
		int size = (stocks.length / 2) + 1;

		int[][] localMaxMin = new int[size][2];
		boolean localMinFound = false;
		boolean localMaxFound = false;
		int profit = 0;
		int k = 0;
		for (int i = 0; i < stocks.length-1; i++) {

			if ((stocks[i] < stocks[i+1]) && !localMinFound) { 
				localMaxMin[k][0] = stocks[i];
				localMinFound = true;
				localMaxFound = false;
			} else if (stocks[i] > stocks[i+1] && localMinFound) {
				localMaxMin[k][1] = stocks[i];
				localMaxFound = true;
				if(localMinFound) {
					System.out.println("LocalMin : " + localMaxMin[k][0] + " Local Max : " +  localMaxMin[k][1]);
					profit = profit + localMaxMin[k][1] - localMaxMin[k][0];
					k++;
				    localMinFound = false;				    
				}
				
			}
		}
		if(!localMaxFound) {
		localMaxMin[k][1] = stocks[stocks.length-1];
		System.out.println("LocalMin : " + localMaxMin[k][0] + " Local Max : " +  localMaxMin[k][1]);
		profit = profit + localMaxMin[k][1] - localMaxMin[k][0];
		}
		System.out.println("Max Profit : " + profit);

	}

}
