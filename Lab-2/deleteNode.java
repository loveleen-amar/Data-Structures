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
	void delectNode(int data){
		root = deleteNodeRec(root,data);
		printPreorder(root);	
	}

	Node deleteNodeRec(Node root, int data){
		if(root == null){
			return root;
		}
		if(data<root.data){
			root.left = deleteNodeRec(root.left,data);
		}else if(data>root.data){
			root.right = deleteNodeRec(root.right,data);
		}else{
			if(root.left==null){
				return root.right;
			}else if(root.right==null){
				return root.left;
			}

			root.data = minValue(root.right);

			root.right = deleteNodeRec(root.right,root.data);
		}
		return root;
	}

	int minValue(Node root){
		int minv = root.data;
		while(root.left!=null){
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}

	void printPreorder(Node node){
		if(node==null)
			return;

		System.out.print(node.data + " ");
		printPreorder(node.left);
		printPreorder(node.right);
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
		System.out.println("Enter a node to delete: ");
		int value = s.nextInt();
		tree.delectNode(value);
	}
}