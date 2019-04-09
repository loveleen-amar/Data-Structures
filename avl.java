import java.util.*;
class Node{
	int info, height;
	Node left,right;

	Node(int d) {
		info = d;
		height = 1;
	}
}

class AVL{
	Node root;

	int height(Node N){
		if(N==null)
			return 0;
		return N.height;
	}

	int max(int a, int b){
		return (a>b)?a:b;
	}

	Node RR(Node y){
		Node x = y.left;
		Node T2 = x.right;

		x.right = y;
		y.left = T2;

		y.height = max(height(y.left),height(y.right)) + 1;
		x.height = max(height(x.left),height(x.right)) + 1;

		return y;
	}

	Node LR(Node x){
		Node y = x.right;
		Node T2 = y.left;

		y.left = x;
		x.right = T2;

		x.height = max(height(x.left),height(x.right)) + 1;
		y.height = max(height(y.left),height(y.right)) + 1;

		return y;
	}

	int getBlance(Node N){
		if(N==null)
			return 0;

		return height(N.left) - height(N.right);
	}

	Node insert(Node node, int key){
		if(node == null)
			return (new Node(key));

		if(key<node.info){
			// System.out.println("Left " + node.info);
			node.left = insert(node.left,key);
		}
		else if(key>node.info){
			// System.out.println("Right " + node.info);
			node.right = insert(node.right,key);
		}
		else
			return node;

		node.height = 1 + max(height(node.left),height(node.right));

		int blance = getBlance(node);

		if(blance>1 && key<node.left.info)
			return RR(node);

		if(blance<-1 && key>node.right.info)
			return LR(node);

		if(blance>1 && key>node.left.info){
			node.left = LR(node.left);
			return RR(node);
		}

		if(blance<-1 && key<node.right.info){
			node.right = RR(node.right);
			return LR(node);
		}

		return node;
	}

	void preOrder(Node n){
		if(n!=null){
			System.out.print(n.info + " ");
			preOrder(n.left);
			preOrder(n.right);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		AVL tree = new AVL();
		System.out.print("Number of nodes: ");	
		int n = s.nextInt();
		for(int i=0;i<n;i++){
			int temp = s.nextInt();
			tree.root = tree.insert(tree.root,temp);
			tree.preOrder(tree.root);
			System.out.println();
		}
	}
}