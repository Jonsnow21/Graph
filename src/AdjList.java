/**
 * Created by pavi on 16/2/17.
 */
public class AdjList {
    Node root;

    AdjList() {
        root = null;
    }

    public void addNode(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
        } else {
            Node temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
}
