public class ListaSimple {
    Node top;

    // Método para insertar el primer nodo en la lista.
    public boolean insertaPrimerNodo(String dato) {
        if (top == null) {
            top = new Node();
            top.name = dato;
            top.next = null;
            return true;
        } else {
            return false;
        }
    }

    // Método para insertar un nodo antes del primer nodo.
    public void insertaAntesPrimerNodo(String nombre) {
        Node temp = new Node();
        temp.name = nombre;
        temp.next = this.top;
        this.top = temp;
        temp = null;
    }

    // Método para insertar un nodo al final de la lista.
    public void insertaAlFinal(String nombre) {
        Node temp = new Node();
        temp.name = nombre;
        temp.next = null;

        Node temp2 = this.top;
        while (temp2.next != null)
            temp2 = temp2.next;

        temp2.next = temp;
        temp = null;
        temp2 = null;
    }
// Método para calcular la posición de un nodo en la lista.
public int getPositionOfNode(Node startNode, String key) {
    int position = 1;
    Node temp = startNode;
    while (temp != null && !temp.name.equals(key)) {
        temp = temp.next;
        position++;
    }
    return temp != null ? position : -1; // Return -1 if the node is not found
}
   // Método para insertar un nodo entre nodos con nombres especificados.
public boolean insertaEntreNodos(String nombre, String buscado) {
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

    while (temp2 != null && !temp2.name.equals(buscado)) {
        temp2 = temp2.next;
    }

    if (temp2 != null) {
        temp.next = temp2.next;
        temp2.next = temp;
        return true;
    } else {
        return false;
    }
}





    // Método para imprimir los elementos de la lista enlazada.
    public void imprimir() {
        for (Node temp = this.top; temp != null; temp = temp.next) {
            System.out.print("[ " + temp.name + " ] -> ");
        }

        System.out.print("[X]\n");
    }

    // Método para eliminar el primer nodo en la lista.
    public void borrarPrimerNodo() {
        this.top = this.top.next;
    }

    // Método para eliminar cualquier nodo que no sea el primero.
    public boolean borrarCualquierNodo(String buscado) {
        Node temp = this.top;

        while (temp != null && !temp.name.equals(buscado)) {
            temp = temp.next;
        }

        if (temp != null) {
            temp.next = temp.next.next;
            temp = null;
            return true;
        } else {
            return false;
        }
    }

    // Método para buscar un nodo por el valor de su campo clave y devolver una referencia.
    public Node searchByKey(String key) {
        Node temp = this.top;
        while (temp != null && !temp.name.equals(key)) {
            temp = temp.next;
        }
        return temp;
    }

    // Método para buscar un nodo por su campo clave e insertar un nuevo nodo después de él.
    public boolean insertAfterKey(String key, String newName) {
        Node temp = searchByKey(key);
        if (temp != null) {
            Node newNode = new Node();
            newNode.name = newName;
            newNode.next = temp.next;
            temp.next = newNode;
            return true;
        }
        return false;
    }

    // Método para intercambiar un nodo por otro buscado.
    public boolean swapNodes(String key1, String key2) {
        Node node1Previous = null, node1 = this.top;
        while (node1 != null && !node1.name.equals(key1)) {
            node1Previous = node1;
            node1 = node1.next;
        }

        Node node2Previous = null, node2 = this.top;
        while (node2 != null && !node2.name.equals(key2)) {
            node2Previous = node2;
            node2 = node2.next;
        }

        if (node1 != null && node2 != null) {
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

            Node temp = node1.next;
            node1.next = node2.next;
            node2.next = temp;

            return true;
        }
        return false;
    }
}
