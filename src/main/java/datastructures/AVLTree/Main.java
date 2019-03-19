package datastructures.AVLTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    @Test
    public void testABLTree(){
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/main/resources/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
            System.out.println("isBST: " + map.isBST());
            System.out.println("isBalance: " + map.isBalance());

            for (String word : words){
                map.remove(word);
                if (!map.isBalance() || !map.isBST())
                    throw new RuntimeException("Errors");
            }
        }
        System.out.println();
    }

    @Test
    public void testTime(){
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/main/resources/pride-and-prejudice.txt", words)) {
            Collections.sort(words);
            long starTime = System.nanoTime();
            BST<String, Integer> bst = new BST<>();
            for (String word : words){
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }
            for (String word : words)
                bst.contains(word);
            long endTime = System.nanoTime();
            System.out.println("BST Time: " + (endTime - starTime) / 1000000000.0);
        }
    }

    @Test
    public void testTime2(){
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/main/resources/pride-and-prejudice.txt", words)) {
            Collections.sort(words);
            long starTime = System.nanoTime();
            AVLTree<String, Integer> avlTree = new AVLTree<>();
            for (String word : words){
                if (avlTree.contains(word))
                    avlTree.set(word, avlTree.get(word) + 1);
                else
                    avlTree.add(word, 1);
            }
            for (String word : words)
                avlTree.contains(word);
            long endTime = System.nanoTime();
            System.out.println("avlTree Time: " + (endTime - starTime) / 1000000000.0);
        }
    }

}
