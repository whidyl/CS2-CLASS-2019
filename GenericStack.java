import java.util.Arrays;

public class GenericStack<E> {
  //private java.util.ArrayList<E> list = new java.util.ArrayList<>();
  private E[] list = (E[]) new Object[10];
  private int topIndex = -1;

  public int getSize() {
    return topIndex + 1;
  }

  public E peek() {
    if (topIndex < 0) {
      System.out.println("No value to peek in empty stack, returned null.");
      return null;
    }
    return list[topIndex];
  }

  public void push(E o) {
    if (list.length - 1 == topIndex) {
      list = Arrays.copyOf(list, list.length*2);
    }
    topIndex += 1;
    list[topIndex] = o;
  }

  public E pop() {
    E popped = list[topIndex];
    list[topIndex] = null;
    topIndex -= 1;
    return popped;
  }

  public boolean isEmpty() {
    return (topIndex == -1);
  }
  
  @Override
  public String toString() {
	return "stack: " + Arrays.toString(list);
  }
}
