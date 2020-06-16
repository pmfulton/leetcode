/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.


*/

class Solution {
    public Node connect(Node root) {
        
        
        
        Queue<Node> q = new LinkedList();
        if (root != null && root.left != null) q.add(root.left);
        if (root != null && root.right != null) q.add(root.right);
        
        
        
        while (!q.isEmpty()) {
            Queue<Node> newq = new LinkedList();
            while (!q.isEmpty()) {
                Node currNode = q.poll();
                traverse(currNode, q, newq); 
            }
            
            q.addAll(newq);
            newq.clear();
           
        }
        
        return root;
    }
    
    public void traverse(Node node, Queue<Node> q, Queue<Node> newq) {  
        if (!q.isEmpty()) node.next = q.peek();
        
        if (node.left != null) newq.add(node.left);
        if (node.right != null) newq.add(node.right);
        
    }
}