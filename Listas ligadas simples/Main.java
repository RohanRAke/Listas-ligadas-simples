import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Declaring Class Objects
        ListaSimple lista = new ListaSimple();
        Scanner scanner = new Scanner(System.in);

        lista.insertaPrimerNodo("H");
        lista.insertaAntesPrimerNodo("O");
        lista.insertaAlFinal("A"); //I Had to add a node A
        lista.insertaAlFinal("Y");
        lista.insertaEntreNodos("R", "A");//So this method can be used by finding the A and 
                                            //inserting the R right after

        // Print the list using both imprimir() and toString()
        System.out.println("List after insertion:");
        lista.imprimir();

        int choice;
        //Menu loop for user interface
        do {
            System.out.println("\n*********Menu:*********");
            System.out.println("1. Search for a node by its key value and return a reference");
            System.out.println("2. Search for a node by its key value and insert a new node after it");
            System.out.println("3. Swap one node with another searched node");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the value of the node to search: ");
                    String keyToSearch = scanner.nextLine();
                    Node foundNode = lista.searchByKey(keyToSearch);
                    if (foundNode != null) {
                        int position = lista.getPositionOfNode(lista.top, keyToSearch);
                        System.out.println("    **Node found at position " + position + ": [ " + foundNode.name + " ]");
                    } else {
                        System.out.println(" Error:Node not found.");
                    }
                    break;

                case 2:
                    System.out.print(" Enter the value of the new node: ");
                    String newValue = scanner.nextLine();
                    System.out.print("Enter the value of the node after which to insert: ");
                    String keyToInsertAfter = scanner.nextLine();
                    if (lista.insertAfterKey(keyToInsertAfter, newValue)) {
                        System.out.println("    **New node inserted after the node with key " + keyToInsertAfter);
                    } else {
                        System.out.println("    Error: Could not insert the new node. Node with key " + keyToInsertAfter + " not found.");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter the value of the first node to swap: ");
                    String key1 = scanner.nextLine();
                    System.out.print("Enter the value of the second node to swap: ");
                    String key2 = scanner.nextLine();
                    if (lista.swapNodes(key1, key2)) {
                        System.out.println("    **Nodes swapped successfully!");
                    } else {
                        System.out.println("    Error:Could not swap nodes. One or both nodes not found.");
                    }
                    break;
                    
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            // Print the list using both imprimir() and toString() after each loop
            System.out.println("\n---------List after operation:----------");
            lista.imprimir();
            System.out.println("----------------------------------------");

        } while (choice != 4);

        scanner.close();
    }
}
