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
		Node temp = root;
		Stack<Node> stack = new Stack<>(); 
        while(true) { 
            while(temp != null) { 
                stack.push(temp); 
                stack.push(temp); 
                temp = temp.left; 
            } 
              
            // Check for empty stack 
            if(stack.empty()) return; 
            temp = stack.pop(); 
              
            if(!stack.empty() && stack.peek() == temp) temp = temp.right; 
              
            else { 
                  
                System.out.print(temp.data + " "); temp = null; 
            } 
        } 
	}

	void printInorder(){
		Node temp = root;
		if (temp == null) 
            return; 
        Stack<Node> s = new Stack<Node>(); 
        Node curr = temp; 
        while (curr != null || s.size() > 0) { 
            while (curr !=  null){ 
                s.push(curr); 
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
		nodeStack.push(node); 
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
		System.out.println("\nInOrder: ");
		tree.printInorder();
		System.out.println("\nPreOrder: ");
		tree.printPreorder();
	}
}