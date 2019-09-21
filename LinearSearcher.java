public class LinearSearcher {
    public static void main(String[] args) {
        Integer[] integerArray = {1, 2, 3, 4, 5};
        System.out.println(linearSearch(integerArray, 3));
        System.out.println(linearSearch(integerArray, 7));

        System.out.println();

        String[] stringArray = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        System.out.println(linearSearch(stringArray, "dog"));
        System.out.println(linearSearch(stringArray, "jumps"));
        System.out.println(linearSearch(stringArray, "Jumps"));
    }

    public static <E extends Comparable<E>> int linearSearch(E[] list, E key){
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(key)) {
                return i;
            }
        }
        System.out.println("Element " + key + " is not present in the array.");
        return -1;
    }
}
