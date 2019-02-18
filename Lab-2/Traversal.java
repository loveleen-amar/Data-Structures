import java.util.*;

class Node{
	int data;
	Node left, right;

	public Node(int item){
		data = item;
		left = right = null;
	}
}

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

	void printPostorder(){
		Node node = root;
		if (node == null) { 
			return; 
		} 
		Stack<Node> nodeStack = new Stack<Node>(); 
		nodeStack.push(root); 
		while (nodeStack.empty() == false) { 
			Node mynode = nodeStack.peek(); 
			nodeStack.pop(); 
			if (mynode.right != null) { 
				nodeStack.push(mynode.right); 
			} 
			if (mynode.left != null) { 
				nodeStack.push(mynode.left); 
			} 
			System.out.print(mynode.data + " "); 
		} 
		System.out.println();
	}

	void printInorder(){
		if (root == null) 
			return; 
		Stack<Node> s = new Stack<Node>(); 
		Node curr = root; 
		while (curr != null || s.size() > 0) { 
			while (curr !=  null) { 
				curr = curr.left; 
			} 
			curr = s.pop(); 
			System.out.print(curr.data + " "); 
			curr = curr.right; 
		} 
	}

	void printPreorder(){
		Node node = root;
		if (node == null) { 
			return; 
		} 

		Stack<Node> nodeStack = new Stack<Node>(); 
		nodeStack.push(root); 
		while (nodeStack.empty() == false) { 
			Node mynode = nodeStack.peek(); 
			System.out.print(mynode.data + " "); 
			nodeStack.pop(); 

			if (mynode.right != null) { 
				nodeStack.push(mynode.right); 
			} 
			if (mynode.left != null) { 
				nodeStack.push(mynode.left); 
			} 
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
		
		System.out.println("PostOrder: ");
		tree.printPostorder();
		System.out.println("InOrder: ");
		// tree.printInorder();
		System.out.println("PreOrder: ");
		// tree.printPreorder();
	}
}