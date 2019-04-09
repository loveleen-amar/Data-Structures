import java.util.*;
class InsertHeap{
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
	void upheapify(int arr[], int i){
		int child = i;
		int parent = (i-1)/2;
		// System.out.println(arr[child]+" "+arr[parent]);
		if(arr[child]>arr[parent]){
			int swap = arr[child];
			arr[child] = arr[parent];
			arr[parent] = swap;
			upheapify(arr,parent);
		}
	}
	static void printArray(int ar[],int n){
		for(int i=0;i<n;i++){
			System.out.print(ar[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		InsertHeap ob = new InsertHeap();
		System.out.print("Enter number of elements: ");
		int n = scanner.nextInt();
		int ar[] = new int[n+1];
		System.out.println("Enter the elements: ");
		for(int i=0;i<n;i++){
			ar[i] = scanner.nextInt();
		}
		for(int i=n/2-1; i>=0;i--)
			ob.heapify(ar,n,i);
		printArray(ar,n);
		System.out.print("Insert new element: ");
		ar[n] = scanner.nextInt();
		ob.upheapify(ar,n);
		printArray(ar,n+1);

	}

}