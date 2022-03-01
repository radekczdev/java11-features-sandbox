package com.example.multithreading;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentCollections {

  public static void main(String[] args) {
    Queue<String> queue = new ConcurrentLinkedQueue<>();
    queue.offer("firstElement");
    queue.offer("secondElement");
    System.out.println(queue.peek());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
  }

}
