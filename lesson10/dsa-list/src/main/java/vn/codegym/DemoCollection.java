package vn.codegym;

import java.util.*;

public class DemoCollection {
    public static void main(String[] args) {
        Collection<String> collection = new HashSet<>(); //Cho phep chen phan tu trung lap, duy tri thu tu them vao
        //them 5 phan tu
        collection.add("Long");//HashSet ko cho trung lap
        collection.add("Hai");
        collection.add("Trung");
        collection.add("Hung");
        collection.add("Long");

        System.out.println("Danh sach sinh vien tu ArrayList");
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        LinkedList<String> linkedList = new LinkedList<>();//Cho phep phan tu trung lap, duy tri thu tu them vao
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Pineapple");
        linkedList.add("Apple");
        linkedList.addFirst("Kiwi");
        linkedList.addLast("Tao meo");

        System.out.println("Danh sach sinh vien tu LinkedList");
        Iterator<String> iteratorLinkedList = linkedList.iterator();
        while (iteratorLinkedList.hasNext()) {
            System.out.println(iteratorLinkedList.next());
        }
    }
}
