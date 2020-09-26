package algorithmsJava.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  class Node {
    private int key;
    private int value;
    private Node prev;
    private Node next;

    Node() {
      this.key = 0;
      this.value = 0;
      this.prev = null;
      this.next = null;
    }

    Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.prev = null;
      this.next = null;
    }

  }

  private Node head, tail;
  private int capacity, size;
  private Map<Integer, Node> nodeMap;

  private void add(Node node) {
    tail.prev.next = node;
    node.prev = tail.prev;
    node.next = tail;
    tail.prev = node;
  }

  private void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
    node.prev = null;
    node.next = null;
  }

  private void pop() {
    if (size == 0) return;
    Node removedNode = head.next;
    remove(head.next);
    nodeMap.remove(removedNode.key);
  }

  private void moveToTail(Node node) {
    remove(node);
    add(node);
  }

  public LRUCache(int capacity) {
    this.capacity = capacity;
    size = 0;
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.prev = head;
    nodeMap = new HashMap<>();
  }

  int get(int key) {
    if (nodeMap.containsKey(key)) {
      Node node = nodeMap.get(key);
      moveToTail(node);
      return node.value;
    }
    return -1;
  }

  void put(int key, int value) {
    if (nodeMap.containsKey(key)) {
      Node node = nodeMap.get(key);
      node.value = value;
      moveToTail(node);
    } else {
      Node newNode = new Node(key, value);
      nodeMap.put(key, newNode);
      add(newNode);
      ++size;
      if (size > capacity) {
        pop();
        --size;
      }
    }
  }

  public String print() {
    if (size == 0) return "";
    StringBuilder stringBuilder = new StringBuilder();
    Node currentNode = head;
    while (currentNode.next != tail) {
      stringBuilder.append(String.format("(%d,%d) ", currentNode.next.key, currentNode.next.value));
      currentNode = currentNode.next;
    }

    return stringBuilder.toString();
  }
}
