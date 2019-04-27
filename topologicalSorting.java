import java.util.*;
class TopologicalSorting{
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of nodes: ");
		int n = scanner.nextInt();
		int matrix[][] = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				matrix[i][j] = scanner.nextInt();

		int in[] = new int[n];
		int visit[] = new int[n];

		for(int i=0;i<n;i++){
			int sum = 0;
			for(int j=0;j<n;j++){
				sum += matrix[j][i];
			}
			in[i] = sum;
			visit[i] = 0;
		}
		int count = n;
		int start = -1;
		for(int i=0;i<n;i++){
			if(in[i]==0){
				start = i;
				break;
			}
		}
		System.out.print("Topological Sorting: ");
		while(count>0){
			System.out.print(start+" ");
			visit[start] = 1;
			count -= 1;
			for(int i=0;i<n;i++){
				if(matrix[start][i]==1){
					matrix[start][i] = 0;
					in[i] -=1;
				}
			}
			for(int i=0;i<n;i++){
				if(in[i]==0 && visit[i]==0){
					start = i;
					break;
				}
			}
			// System.out.println("Start: "+start);
			// for(int i=0;i<n;i++){
			// 	System.out.print(in[i]+" ");
			// }
			// System.out.println();
			// for(int i=0;i<n;i++){
			// 	System.out.print(visit[i]+" ");
			// }
		}
		System.out.println();
	}
}