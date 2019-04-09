import java.util.*;

class Sequential{
	void delete(int ar[],int item){
		deleteItem(ar,item,0);
	}
	int deleteItem(int ar[], int item, int i){
		if(ar[0]==-1){
			return -1
		}
		if(item<ar[i]){
			ar[2*i+1] = deleteItem(ar,item,2*i+1);
		}else if(item>ar[i]){
			ar[2*i+2] = deleteItem(ar,item,2*i+2);
		}else{
			if(ar[i]==-1){
				return ar[2*i+1];
			}else if(ar[2*i+2]==-1){
				return ar[2*i+2];
			}


			root[2*i+2] = deleteItem()
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int n = s.nextInt();
		System.out.println("Enter number of nodes: ");
		int m = s.nextInt();
		int ar[] = new int[n];
		for(int i =0;i<n;i++){
			ar[i] = -1;
		}
		for(int i=0;i<m;i++){
			if(i==0){
				ar[0] = s.nextInt();
			}else{
				int temp = s.nextInt();
				cur = 0;
				while(ar[i]!=-1 && cur<n){
					if(ar[cur]>temp){
						cur = 2*cur+1;
					}else{
						cur = 2*cur+2;
					}
				}
				if(cur<n){
					ar[i] = temp;
				}
			}
		}
		for(int i=0;i<n;i++){
			System.out.println(ar[i]+" ");
		}
	}
}