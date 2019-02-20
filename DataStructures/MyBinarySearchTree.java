package mybinarysearchtree;

public class MyBinarySearchTree {
	Node root;
	
    public void addNode(int key, String value)
    {
    	Node newnode = new Node(key, value);
    	if(root == null)
    	{
    		root = newnode;
    	}
    	else
    	{
    		Node focusnode = root; // have parent and focusnode
    		Node parent;
    		while(true)
    		{
    			parent = focusnode;
    			if(key < focusnode.key)  // if key < parent(root) key, move to left
    			{
    				focusnode = focusnode.left;
    				if(focusnode == null)  // if node is null replace at left
    				{
    					parent.left = newnode;
    					return;
    				}
    			}
    			else  // else move to right
    			{
    				focusnode = focusnode.right; // if node is null replace at right
    				if(focusnode == null) 
    				{
    					parent.right = newnode;
    					return;
    				}
    			}
    		}
    	}
    }
    
    public Node findNode(int key)
    {
    	// Start at the top of the tree
    	Node focusnode = root;
        // While we haven't found the Node keep looking
    	while(key != focusnode.key) {
    		// If we should search to the left
    		if(key < focusnode.key)
    		{
    			// Shift the focus Node to the left child
    			focusnode = focusnode.left;
    		}
    		else
    		{
    			// Shift the focus Node to the right child
    			focusnode = focusnode.right;
    		}
    		// The node wasn't found
    		if(focusnode == null) return null;
    	}
    return focusnode;
    }
    
    public boolean removeNode(int key)
    {
    	// Start at the top of the tree
    	Node focusnode = root;
    	Node parent = root;
    	// When searching for a Node this will tell us whether to search to right or left
    	boolean isatleft = true;
    	while(focusnode.key != key)
    	{
    		parent = focusnode;
    		// If we should search to the left
    		if(key < focusnode.key)
    		{
    			// Shift the focus Node to the left child
    			isatleft = true;
    			focusnode = focusnode.left;
    		}
    		else
    		{
    			// Shift the focus Node to the right child
    			isatleft = false;
    			focusnode = focusnode.right;
    		}
    		 // The node wasn't found
    		if(focusnode == null) return false;
    	}
    	
    	// If Node doesn't have children delete it
    	if(focusnode.left == null && focusnode.right == null)
    	{
    		// If root delete it
    		if(focusnode == root){
    			root = null;
    		}
    		// If it was marked as a left child of the parent delete it in its parent
    		else if(isatleft)
    		{
    			parent.left = null;
    		}
    		// Vice versa for the right child
    		else
    		{
    			parent.right = null;
    		}
    	}
    	// If no left child
    	else if(focusnode.left == null)
    	{
    		if(focusnode == root){
    			root = focusnode.right;
    		}
    		 // If focus Node was on the left of parent move the focus Nodes right child up to parent node
    		else if(isatleft)
    		{
    			parent.left = focusnode.right;
    		}
    		// Vice versa for the left child
    		else
    		{
    			parent.right = focusnode.left;
    		}
    	}
    	// If no right child
    	else if(focusnode.right == null)
    	{
    		if(focusnode == root){
    			root = focusnode.left;
    		}
   		 // If focus Node was on the left of parent move the focus Nodes left child up to parent node
    		else if(isatleft)
    		{
    			parent.left = focusnode.left;
    		}
    		// Vice versa for the right child
    		else
    		{
    			parent.right = focusnode.left;
    		}
    	}
    	// Two children so I need to find the deleted nodes replacement
    	else
    	{
    		Node replacement = getreplacement(focusnode);
    		// If the focusNode is root replace root with replacement
    		if(focusnode == root){
    			root = replacement;
    		}
    		// If the deleted node was a left child, make the replacement the left child
    		else if(isatleft)
    		{
    			parent.left = replacement;
    		}
    		// Vice versa if it was a right child
    		else
    		{
    			parent.right = replacement;
    		}
    		replacement.left = focusnode.left;
    	}

    	return true;
    }
    
    public Node getreplacement(Node replacenode)
    {
    	Node replaceparent = replacenode;
    	Node replacement = replacenode;
    	Node focusnode = replacenode.right;
    	// While there are no more left children
    	while(focusnode != null)
    	{
    		replaceparent = replacement;
    		replacement = focusnode;
    		focusnode = focusnode.left;
    	}

        // If the replacement isn't the right child
        // move the replacement into the parents
        // leftChild slot and move the replaced nodes
        // right child into the replacements rightChild

    	if(replacement != replacenode.right)
    	{
    		replaceparent.left = replacement.right;
    		replacement.right = replacenode.right;
    	}
    	return replacement;
    }
    
    public void inOrderTraverse(Node focusnode)
    {
    	if (focusnode != null) {
    		inOrderTraverse(focusnode.left);
    		System.out.println(focusnode.value);
    		inOrderTraverse(focusnode.right);
    }
    }
    public void preOrderTraverse(Node focusnode)
    {
    	if (focusnode != null) {
    		System.out.println(focusnode.value);
    		preOrderTraverse(focusnode.left);
    		preOrderTraverse(focusnode.right);
    	}
    }
    public void postOrderTraverse(Node focusnode)
    {
    	if (focusnode != null) {
    		postOrderTraverse(focusnode.left);
    		postOrderTraverse(focusnode.right);
    		System.out.println(focusnode.value);
    }
    }
    public class Node
    {
    	int key;
    	String value;
    	Node left;
    	Node right;
    	
    	Node(int key, String value)
    	{
    		this.key = key;
    		this.value = value;
    	}
    }
	public static void main(String[] args) {
		MyBinarySearchTree theTree = new MyBinarySearchTree();
		theTree.addNode(50, "Boss");
		theTree.addNode(25, "Vice President");
		theTree.addNode(15, "Office Manager");
		theTree.addNode(30, "Secretary");
		theTree.addNode(75, "Sales Manager");
		theTree.addNode(85, "Salesman 1");
		System.out.println(theTree.findNode(75).value);
		System.out.println(theTree.findNode(15).value);
		theTree.removeNode(25);
		System.out.println(theTree.findNode(25));
		theTree.removeNode(50);
		System.out.println(theTree.findNode(50));
		theTree.postOrderTraverse(theTree.root);
		theTree.preOrderTraverse(theTree.root);
		theTree.inOrderTraverse(theTree.root);

	}

}
