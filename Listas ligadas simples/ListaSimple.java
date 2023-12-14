// Class representing a simple linked list
public class ListaSimple {

    // Top pointer for the start of the list
    Node top;

    // Method to insert the first node in the list
    public boolean insertaPrimerNodo(String dato) {
        // Check if the list is empty
        if (top == null) {
            // Create a new node and make it the top
            top = new Node();
            top.name = dato;
            top.next = null;
            return true;
        } else {
            // List is not empty, insertion failed
            return false;
        }
    }

    // Method to insert a node before the first node
    public void insertaAntesPrimerNodo(String nombre) {
        // Create a new node
        Node temp = new Node();
        temp.name = nombre;
        // Insert the new node at the beginning
        temp.next = this.top;
        this.top = temp;
        temp = null;
    }

    // Method to insert a node at the end of the list
    public void insertaAlFinal(String nombre) {
        // Create a new node
        Node temp = new Node();
        temp.name = nombre;
        temp.next = null;

        Node temp2 = this.top;
        // Traverse to the end of the list
        while (temp2.next != null)
            temp2 = temp2.next;

        // Insert the new node at the end
        temp2.next = temp;
        temp = null;
        temp2 = null;
    }

    // Method to calculate the position of a node in the list
    public int getPositionOfNode(Node startNode, String key) {
        int position = 1;
        Node temp = startNode;
        // Traverse the list until the key is found
        while (temp != null && !temp.name.equals(key)) {
            temp = temp.next;
            position++;
        }
        // Return the position or -1 if the node is not found
        return temp != null ? position : -1;
    }

    // Method to insert a node between nodes with specified names
    public boolean insertaEntreNodos(String nombre, String buscado) {
        // Create a new node
        Node temp = new Node();
        temp.name = nombre;

        // Handle the case when the list is empty
        if (this.top == null) {
            this.top = temp;
            temp.next = null;
            return true;
        }

        Node temp2 = this.top;

        // Handle the case when the first node matches the search key
        if (temp2.name.equals(buscado)) {
            temp.next = temp2.next;
            temp2.next = temp;
            return true;
        }

        // Traverse the list to find the node with the specified name
        while (temp2 != null && !temp2.name.equals(buscado)) {
            temp2 = temp2.next;
        }

        // If the node is found, insert the new node between nodes
        if (temp2 != null) {
            temp.next = temp2.next;
            temp2.next = temp;
            return true;
        } else {
            // Node not found, insertion failed
            return false;
        }
    }

    // Method to print the elements of the linked list
    public void imprimir() {
        // Traverse the list and print each node's name
        for (Node temp = this.top; temp != null; temp = temp.next) {
            System.out.print("[ " + temp.name + " ] -> ");
        }

        // Print the end marker
        System.out.print("[X]\n");
    }

    // Method to delete the first node in the list
    public void borrarPrimerNodo() {
        // Move the top pointer to the next node, effectively deleting the first node
        this.top = this.top.next;
    }

    // Method to delete any node other than the first
    public boolean borrarCualquierNodo(String buscado) {
        // Start from the top
        Node temp = this.top;

        // Traverse the list to find the node with the specified name
        while (temp != null && !temp.name.equals(buscado)) {
            temp = temp.next;
        }

        // If the node is found, delete it
        if (temp != null) {
            temp.next = temp.next.next;
            temp = null;
            return true;
        } else {
            // Node not found, deletion failed
            return false;
        }
    }

    // Method to search for a node by the value of its key field and return a reference
    public Node searchByKey(String key) {
        Node temp = this.top;
        // Traverse the list to find the node with the specified key
        while (temp != null && !temp.name.equals(key)) {
            temp = temp.next;
        }
        return temp;
    }

    // Method to search for a node by its key field and insert a new node after it
    public boolean insertAfterKey(String key, String newName) {
        // Search for the node with the specified key
        Node temp = searchByKey(key);
        // If the node is found, insert a new node after it
        if (temp != null) {
            Node newNode = new Node();
            newNode.name = newName;
            newNode.next = temp.next;
            temp.next = newNode;
            return true;
        }
        return false;
    }

    // Method to swap one node with another searched node
    public boolean swapNodes(String key1, String key2) {
        // Initialize variables for the nodes to be swapped and their predecessors
        Node node1Previous = null, node1 = this.top;
        Node node2Previous = null, node2 = this.top;

        // Traverse the list to find the first node
        while (node1 != null && !node1.name.equals(key1)) {
            node1Previous = node1;
            node1 = node1.next;
        }

        // Traverse the list to find the second node
        while (node2 != null && !node2.name.equals(key2)) {
            node2Previous = node2;
            node2 = node2.next;
        }

        // If both nodes are found, perform the swap
        if (node1 != null && node2 != null) {
            // Adjust the pointers to swap the nodes
            if (node1Previous != null) {
                node1Previous.next = node2;
            } else {
                this.top = node2;
            }

            if (node2Previous != null) {
                node2Previous.next = node1;
            } else {
                this.top = node1;
            }

            // Perform the swap
            Node temp = node1.next;
            node1.next = node2.next;
            node2.next = temp;

            return true;
        }
        // Nodes not found, swap failed
        return false;
    }
}
