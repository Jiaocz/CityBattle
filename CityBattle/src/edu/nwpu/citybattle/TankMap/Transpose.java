package edu.nwpu.citybattle.TankMap;

public class Transpose {
	//test
//	public static void main(String args[]) {
//		int test[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }};
//		
//		System.out.println("ת��֮ǰ�ľ���ֵ�ǣ�");
//		print1(test);
// 
//		System.out.println("\nת��֮��ľ���ֵ�ǣ�");
//		int xx[][]=tfunction(test);
//		print1(xx);
//		
//	}
	
	//���������ת��
	public static int[][] tfunction(int[][] test){
		int m=test.length;
		int n=test[0].length;
		int t[][]=new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				t[i][j]=test[j][i];
			}
		}
		return  t;
	}
	
	//��ӡ
	/*public static void print1(int temp[][]) {
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				System.out.print(temp[i][j] + "\t");
			}
			System.out.println();
		}
	}*/


}
