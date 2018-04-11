package sortalgorithms;

public class Node {
    
    int id;
    String text;
    Node next = null;
    
    public Node() {};
    
    public Node(int id, String text) {
        this.id = id;
        this.text = text;
    }    

    @Override
    public String toString() {
        return "Node " + id + ": " + text;
    }
    
    @Override
    public Node clone() {
        return new Node(id, text);
    }
    
}
