import java.util.Objects;

public class MyHashMap<K, V> {

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V>[] table;
    private int capacity = 16;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = (Node<K, V>[]) new Node[capacity];
    }

    private int hash(K key) {
        return (key == null) ? 0 : (key.hashCode() & 0x7fffffff) % capacity;
    }


    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> head = table[index];

        for (Node<K, V> node = head; node != null; node = node.next) {
            if (Objects.equals(node.key, key)) {
                node.value = value;
                return;
            }
        }

        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        table[index] = newNode;
        size++;
    }


    public V get(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];

        while (node != null) {
            if (Objects.equals(node.key, key)) {
                return node.value;
            }
            node = node.next;
        }

        return null;
    }


    public V remove(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        Node<K, V> prev = null;

        while (node != null) {
            if (Objects.equals(node.key, key)) {
                if (prev == null) {
                    table[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }

            prev = node;
            node = node.next;
        }

        return null;
    }

    public int size() {
        return size;
    }
}