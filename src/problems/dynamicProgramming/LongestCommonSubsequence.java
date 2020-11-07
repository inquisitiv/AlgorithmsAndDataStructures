package problems.dynamicProgramming;


//Dynamic Programming
public class LongestCommonSubsequence {

	public static void main(String[] args) {

		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		int max = 0;
		int max_i = 0;
		int max_j = 0;

		int[][] matrix = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {

				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				} else {
					matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
				}
				if(max<matrix[i][j]) {
					max = matrix[i][j];
					max_i = i;
				    max_j = j;
				}

			}
		}
		
		int x = max_i;
		int y = max_j;
		String answer = "";
		while(matrix[x][y]!=0){
	
			if(Math.max(matrix[x-1][y],matrix[y-1][x])== matrix[x][y]) {
				if(matrix[x-1][y]>matrix[y-1][x]) {
					x=x-1;
				} else {
					y=y-1;
				}
			} else {
				answer = str1.charAt(x-1)+answer;
				x=x-1;
				y=y-1;
			}
		}
		
		System.out.println("String is : " + answer);

	}

}
