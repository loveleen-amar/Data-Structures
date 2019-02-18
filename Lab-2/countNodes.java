import java.util.Scanner;
class BinaryTree{
	Node root;

	BinaryTree(){
		root = null;
	}

	void insertData(int data){
		Node prev = null;
		Node temp = root;
		Node newNode = new Node(data);
		if(root==null){
			root = newNode;
			return;
		}
		while(temp!=null){
			prev = temp;
			if(temp.data>data){
				temp = temp.left;
			}else{
				temp = temp.right;
			}
		}
		if(prev.data>data){
			prev.left = newNode;
		}else{
			prev.right = newNode;
		}
	}

	int getCount(){
		return getCount(root);
	}

	int getCount(Node node){
		if(node!=null){
			return getCount(node.right) + getCount(node.left) + 1;
		}else{
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinaryTree tree = new BinaryTree();
		System.out.println("Enter Data into Tree: ");
		System.out.println("Enter -1 to stop entring data");
		int data;
		data = s.nextInt();
		while(data!=-1){
			tree.insertData(data);
			data = s.nextInt();
		}
		int count = tree.getCount();
		System.out.println("Number of nodes: "+count);
	}
}