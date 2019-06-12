package coreLogical;


public class GameOfLife {
	public static void main(String[] args) throws InterruptedException {
		//外部输入
		int n,m;
		n=9;
		m=9;
		int[][] arr = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j] = 0;
			}
		}
		arr[0][0]=1;
		arr[2][0]=1;
		arr[1][1]=1;
		arr[2][1]=1;
		arr[1][2]=1;
		//运行程序
		show(arr);
		go(arr);
		//输出结果
		
	}
	
	public static void go(int[][] arr) throws InterruptedException {
		int[][] neighbour = new int[arr.length][arr[0].length];
		while(true) {
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[i].length;j++) {
					neighbour[i][j] = getNeighbour(arr,i,j);
				}
			}
			change(arr,neighbour);
			show(arr);
			Thread.sleep(1000);
		}
	}
	
	public static int getNeighbour(int[][] arr,int i,int j) {
		int count = 0;
		for(int ii=i-1;ii<=i+1;ii++) {
			if(ii<0||ii>=arr.length) {
				continue;
			}
			for(int jj=j-1;jj<=j+1;jj++) {
				if(jj<0||jj>=arr[i].length) {
					continue;
				}
				if(ii==i&&jj==j) {
					continue;
				}
				if(arr[ii][jj]==1) {
					count++;
				}
			}
		}
		return count;	
	}
	
	public static void change(int[][] arr,int[][] neighbour) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]==0) {
					if(neighbour[i][j]==3) {
						arr[i][j]=1;
					}
				}else {
					if(neighbour[i][j]>3||neighbour[i][j]<2) {
						arr[i][j] = 0;
					}
				}
			}
		}
		
	}
	
	public static void show(int[][] arr) {
		System.out.println("#####");
		for(int i =0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println("#####");
	}
}

