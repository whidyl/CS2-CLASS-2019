import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class MyLinkedList<E> implements MyList<E> {
    
/**
 * Structure used to form the list.
 * @author bobgils
 * @param <E> - type of data element stored in node.
 */
class Node<E> {
    E element;
    Node<E> next;

    /**
     * @param element
     */
    public Node(E element) {
      this.element = element;
    }
}

  private Node<E> head, tail;
  private int size = 0; // Number of elements in the list
  
  /** Create an empty list */
  public MyLinkedList() {
  }

  /** Create a list from an array of objects */
  public MyLinkedList(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      add(objects[i]); 
  }

  /** Return the head element in the list */
  public E getFirst() {
    if (size == 0) {
      return null;
    }
    else {
      return head.element;
    }
  }

  /** Return the last element in the list */
  public E getLast() {
    if (size == 0) {
      return null;
    }
    else {
      return tail.element;
    }
  }

  /** Add an element to the beginning of the list */
  public void addFirst(E e) {
    Node<E> newNode = new Node<>(e); // Create a new node
    newNode.next = head; // link the new node with the head
    head = newNode; // head points to the new node
    size++; // Increase list size

    if (tail == null) // the new node is the only node in list
      tail = head;
  }

  /** Add an element to the end of the list */
  public void addLast(E e) {
    Node<E> newNode = new Node<>(e); // Create a new for element e

    if (tail == null) {
      head = tail = newNode; // The new node is the only node in list
    }
    else {
      tail.next = newNode; // Link the new with the last node
      tail = newNode; // tail now points to the last node
    }

    size++; // Increase size
  }

  /** Add a new element at the specified index 
   * in this list. The index of the head element is 0 */
  @Override 
  public void add(int index, E e) {
    if (index == 0) {
      addFirst(e);
    }
    else if (index >= size) {
      addLast(e);
    }
    else {
      Node<E> current = head;
      for (int i = 1; i < index; i++) {
        current = current.next;
      }
      Node<E> temp = current.next;
      current.next = new Node<>(e);
      (current.next).next = temp;
      size++;
    }
  }

  /** Remove the head node and
   *  return the object that is contained in the removed node. */
  public E removeFirst() {
    if (size == 0) {
      return null;
    }
    else {
      E temp = head.element;
      head = head.next;
      size--;
      if (head == null) {
        tail = null;
      }
      return temp;
    }
  }

  /** Remove the last node and
   * return the object that is contained in the removed node. */
  public E removeLast() {
    if (size == 0) {
      return null;
    }
    else if (size == 1) {
      E temp = head.element;
      head = tail = null;
      size = 0;
      return temp;
    }
    else {
      Node<E> current = head;

      for (int i = 0; i < size - 2; i++) {
        current = current.next;
      }

      E temp = tail.element;
      tail = current;
      tail.next = null;
      size--;
      return temp;
    }
  }

  /** Remove the element at the specified position in this 
   *  list. Return the element that was removed from the list. */
  @Override 
  public E remove(int index) {   
    if (index < 0 || index >= size) {
      return null;
    }
    else if (index == 0) {
      return removeFirst();
    }
    else if (index == size - 1) {
      return removeLast();
    }
    else {
      Node<E> previous = head;

      for (int i = 1; i < index; i++) {
        previous = previous.next;
      }

      Node<E> current = previous.next;
      previous.next = current.next;
      size--;
      return current.element;
    }
  }

  /** Override toString() to return elements in the list */
  @Override 
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      result.append(current.element);
      current = current.next;
      if (current != null) {
        result.append(", "); // Separate two elements with a comma
      }
      else {
        result.append("]"); // Insert the closing ] in the string
      }
    }

    return result.toString();
  }

  /** Clear the list */
  @Override 
  public void clear() {
    size = 0;
    head = tail = null;
  }

  /** Return true if this list contains the element e */
  // EXERCISE
  @Override 
  public boolean contains(Object e) {
    for (Object element : this) if (element.equals(e)) return true;
    return false;
  }

  /** Return the element at the specified index */
  // EXERCISE
  @Override 
  public E get(int index) {
    if (index > size || index < 0) throw new IndexOutOfBoundsException();

    Node<E> current = head;
    for (int i = 0; i < index; i++){
      current = current.next;
    }
    return current.element;
  }

  /** Return the index of the head matching element in 
   *  this list. Return -1 if no match. */
  @Override
  // EXERCISE
  public int indexOf(Object targetElement) {
    int index = 0;
    for (E element : this) {
      if (element.equals(targetElement)) return index;
      index++;
    }
    return -1;
  }

  /** Return the index of the last matching element in 
   *  this list. Return -1 if no match. */
  @Override
  // EXERCISE
  public int lastIndexOf(E targetElement) {
    int index = 0;
    int foundAt = -1;
    for (E element : this) {
      if (element.equals(targetElement)) foundAt = index;
      index++;
    }
    return foundAt;
  }

  /** Replace the element at the specified position 
   *  in this list with the specified element. */
  @Override
  // EXERCISE
  public E set(int index, E setElement) {
    if (index > size || index < 0) throw new IndexOutOfBoundsException();

    Node<E> current = head;
    for (int i = 0; i < index; i++){
      current = current.next;
    }
    current.element = setElement;
    return current.element;
  }

  /** Override iterator() defined in Iterable */
  @Override 
  public java.util.Iterator<E> iterator() {
    return new LinkedListIterator();
  }

  @NotNull
  @Override
  // EXERCISE
  public Object[] toArray() {
    Object[] converted = (E[]) new Object[size];
    System.arraycopy(this, 0, converted, 0, size);
    return converted;
  }

  @NotNull
  @Override
  // EXERCISE
  public <T> T[] toArray(@NotNull T[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (T) this.get(i);
    }
    return arr;
  }

  @Override
  // EXERCISE
  public boolean containsAll(@NotNull Collection<?> col) {
    for (Object element : col) if (!this.contains(element)) return false;
    return true;
  }

  @Override
  // EXERCISE
  public boolean addAll(@NotNull Collection<? extends E> col) {
    for (E element : col) this.addLast(element);
    return !col.isEmpty();
  }

  @Override
  // EXERCISE
  public boolean removeAll(@NotNull Collection<?> col) {
    boolean listWasChanged = false;
    for (Object element : col) if (this.remove(element)) listWasChanged = true;
    return listWasChanged;
  }

  @Override
  // EXERCISE
  public boolean retainAll(@NotNull Collection<?> col) {
    boolean listWasChanged = false;
    for (E element : this) listWasChanged |= this.remove(element);
    return listWasChanged;
  }

  private class LinkedListIterator 
      implements java.util.Iterator<E> {
    private Node<E> current = head; // Current index 
    
    @Override
    public boolean hasNext() {
      return (current != null);
    }

    @Override
    public E next() {
      E e = current.element;
      current = current.next;
      return e;
    }

    @Override
    public void remove() {
      // Left as an exercise
    }
  }
 
  /** Return the number of elements in this list */
  @Override 
  public int size() {
    return size;
  }
}

