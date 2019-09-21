/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bobgils
 */
public class GenericStackDemo {
    
    public static void main(String[] args){
        GenericStack<Integer> myStack = new GenericStack<>();
        System.out.println("myStack initial: " + myStack);
        System.out.println("myStack.isEmpty(): " + myStack.isEmpty());
        System.out.println("myStack.peak(): " + myStack.peek());
        myStack.push(3);
        myStack.push(5);
        System.out.println("myStack after popping a 3 and 5: " + myStack);
        System.out.println("myStack.getSize(): " + myStack.getSize());
        myStack.push(8);
        myStack.push(3);
        myStack.push(7);
        myStack.push(9);
        myStack.push(8);
        myStack.push(1);
        myStack.push(4);
        myStack.push(2);
        myStack.push(12);
        System.out.println("myStack after pushing 8, 3, 7, 9, 8, 1, 4, 2, 12: " + myStack);
        myStack.pop();
        int lastValuePopped = myStack.pop();
        System.out.println("myStack after popping twice: " + myStack);
        System.out.println("value of last pop: " + lastValuePopped);
        System.out.println("myStack.peek(): " + myStack.peek());
        System.out.println("myStack.getSize(): " + myStack.getSize());
        System.out.println("myStack.isEmpty(): " + myStack.isEmpty());


//        myStack.push('w');
    }

}
