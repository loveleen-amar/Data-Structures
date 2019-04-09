import java.util.*;
class HeapSort{
	void sort(int arr[]) {
		int n  = arr.length;
		
		for(int i=n/2-1; i>=0;i--)
			heapify(arr,n,i);

		for(int i=n-1;i>=0;i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr,i,0);
		}
	}
	void heapify(int arr[], int n, int i){
		int largest = i;
		int l = 2*i+1;
		int r = 2*i+2;

		if(l<n && arr[l]>arr[largest])
			largest = l;
		if(r<n && arr[r]>arr[largest])
			largest = r;

		if(largest!=i){
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			heapify(arr,n,largest);
		}
	}
	static void printArray(int arr[]){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the length of array: ");
		int n = scanner.nextInt();
		int ar[] = new int[n];
		System.out.println("Enter the array: ");
		for(int i=0;i<n;i++){
			ar[i] = scanner.nextInt();
		}
		HeapSort obj = new HeapSort();
		obj.sort(ar);
		System.out.println("Sorted array is: ");
		printArray(ar);
	}
}