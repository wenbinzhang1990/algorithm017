package com.geek.week1;

public class DesignCircularDeque {

  int size;
  int[] array;
  int front;
  int end;
  int capacity;

  /**
   * Initialize your data structure here. Set the size of the deque to be k.
   */
  public DesignCircularDeque(int k) {
    size = 0;
    front = 0;
    end = 1;
    array = new int[k];
    capacity = k;
  }

  /**
   * Adds an item at the front of Deque. Return true if the operation is successful.
   */
  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }

    size++;
    array[front] = value;
    front = (front - 1 + capacity) % capacity;
    return true;
  }

  /**
   * Adds an item at the rear of Deque. Return true if the operation is successful.
   */
  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }

    size++;
    array[end] = value;
    end = (end + 1 + capacity) % capacity;
    return true;
  }

  /**
   * Deletes an item from the front of Deque. Return true if the operation is successful.
   */
  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    }

    size--;
    front = (front + 1 + capacity) % capacity;
    return true;
  }

  /**
   * Deletes an item from the rear of Deque. Return true if the operation is successful.
   */
  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }

    size--;
    end = (end - 1 + capacity) % capacity;
    return true;
  }

  /**
   * Get the front item from the deque.
   */
  public int getFront() {
    if (isEmpty()) {
      return -1;
    }
    return array[(front + 1 + capacity) % capacity];
  }

  /**
   * Get the last item from the deque.
   */
  public int getRear() {
    if (isEmpty()) {
      return -1;
    }
    return array[(end - 1 + capacity) % capacity];
  }

  /**
   * Checks whether the circular deque is empty or not.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Checks whether the circular deque is full or not.
   */
  public boolean isFull() {
    return size == capacity;
  }
}
