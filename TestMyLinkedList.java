import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class TestMyLinkedList {
  /** Main method */
  public static void main(String[] args) {
    // Create a list for strings
    MyLinkedList<String> list = new MyLinkedList<String>();
    MyLinkedList<String> list2 = new MyLinkedList<String>();
    MyLinkedList<String> myGreetingsList;
    String[] greetings = {"hello", "ciao", "ola", "bonjour"};

    //create list using constructor
    myGreetingsList = new MyLinkedList<String>(greetings);
    
    System.out.println(myGreetingsList);
    
    // Add elements to the list
    list.add("America"); // Add it to the list
    System.out.println("(1) " + list);

    list.add(0, "Canada"); // Add it to the beginning of the list
    System.out.println("(2) " + list);

    list.add("Russia"); // Add it to the end of the list
    System.out.println("(3) " + list);

    list2.addAll(list);
    System.out.println("list2 after list2.addAll(list): " + list2);
    
    list.addLast("France"); // Add it to the end of the list
    System.out.println("(4) " + list);

    list.add(2, "Germany"); // Add it to the list at index 2
    System.out.println("(5) " + list);

    list.add(5, "Norway"); // Add it to the list at index 5
    System.out.println("(6) " + list);

    list.add(0, "Poland"); // Same as list.addFirst("Poland")
    System.out.println("(7) " + list);

    System.out.println("list.get(5): "  + list.get(5));
    list.set(3, "France");
    System.out.println("list after list.set(3, \"France\"): " + list);
    System.out.println("list.indexOf(\"France\"): " + list.indexOf("France"));
    System.out.println("list.lastIndexOf(\"France\"): " + list.lastIndexOf("France"));

    // Remove elements from the list
    list.remove(0); // Same as list.remove("Australia") in this case
    System.out.println("(8) " + list);

    list.remove(2); // Remove the element at index 2
    System.out.println("(9) " + list);

    System.out.println("list.containsAll(list2): " + list.containsAll(list2));
    System.out.println("list2.containsAll(list): " + list2.containsAll(list));

    list.remove(list.size() - 1); // Remove the last element
    System.out.print("(10) " + list + "\n(11) ");
    
    for (String s: list)
      System.out.print(s.toUpperCase() + " ");
    
    list.clear();
    System.out.println("\nAfter clearing the list, the list size is " 
      + list.size());
  }
}