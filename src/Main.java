public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Hello");
        list.add("World");
        list.add("GoIT courses");

        System.out.println("List size: " + list.size());

        System.out.println("First element: " + list.get(0));
        System.out.println("Second element: " + list.get(1));
        System.out.println("Third element: " + list.get(2));

        list.remove(1);
        System.out.println("Second element: " + list.get(1));

        list.clear();

        System.out.println("List size: " + list.size());

    }
}