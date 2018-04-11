package sortalgorithms;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class List {

    Node head = null;
    int size;

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;

        try {
            bw.write("Secuencias: \n\n");
            while (temp != null) {
                bw.write(temp.toString() + "\n");
                temp = temp.next;
            }
            bw.flush();
        } catch (IOException e) {}
    }

    public void insertAtBegin(Node newNode) {
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAtPosition(Node newNode, int position) {
        Node prev = head;
        for (int i = 0; i < position - 1; i++)
            prev = prev.next;
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }
    
    public void insertAtEnd(Node newNode) {
        if (isEmpty())
            head = newNode;
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    public void deleteAtBegin() {
        Node temp = head;
        head = head.next;
        temp = null;
        System.gc();
        size--;
    }
    
    public void deleteAtPosition(int position) {
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        Node temp2 = temp.next;
        temp.next = temp.next.next;
        temp2 = null;
        System.gc();
        size--;
    }

    public void deleteAtEnd() {
        Node temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        temp.next = null;
        System.gc();
        size--;
    }
    
    public Node get(int position) {
        if (position < size) {
            Node temp = head;
            for (int i = 0; i < position; i++) {
                temp = temp.next;
            }
            return temp;
        }
        return null;
    }
    
    public Node binarySearch(int id) {
        int lowerBound = 0, upperBound = size - 1, index = -1, middlePoint;
        
        while (lowerBound < upperBound) {
            middlePoint = (upperBound + lowerBound) / 2;
            if (id == get(middlePoint).id) {
                index = middlePoint;
                break;
            } else if (id < get(middlePoint).id)
                upperBound = middlePoint - 1;
            else
                lowerBound = middlePoint + 1;
        }
        
        if (lowerBound == upperBound && get(lowerBound).id == id)
            index = lowerBound;
        
        return get(index);
    }
    
    public Node binarySearchRecursive(int id, int lB, int uB) {
        int middlePoint = (lB + uB) / 2;
        int tempId = get(middlePoint).id;
        if (lB == uB)
            if (id == tempId)
                return get(middlePoint);
            else
                return null;
        else
            if (id == tempId)
                return get(middlePoint);
            else
                if (id < tempId)
                    return binarySearchRecursive(id, lB, middlePoint - 1);
                else
                    return binarySearchRecursive(id, middlePoint + 1, uB);
    }

}
