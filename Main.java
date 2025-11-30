public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println(map.get("two"));

        map.remove("two");
        System.out.println(map.get("two"));
    }
}
