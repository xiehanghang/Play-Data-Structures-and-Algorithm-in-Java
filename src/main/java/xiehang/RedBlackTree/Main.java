package xiehang.RedBlackTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    @Test
    public void testABLTree() {
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

            for (String word : words) {
                map.remove(word);
                if (!map.isBalance() || !map.isBST())
                    throw new RuntimeException("Errors");
            }
        }
        System.out.println();
    }

    @Test
    public void testTime() {
        ArrayList<String> word1 = new ArrayList<>();
        if (FileOperation.readFile("src/main/resources/pride-and-prejudice.txt", word1)) {
//            Collections.sort(word1);
            long starTime = System.nanoTime();
            BST<String, Integer> bst = new BST<>();
            for (String word : word1) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }
            for (String word : word1)
                bst.contains(word);
            long endTime = System.nanoTime();
            System.out.println("BSTree Time: " + (endTime - starTime) / 1000000000.0);
        }

        ArrayList<String> word2 = new ArrayList<>();
        if (FileOperation.readFile("src/main/resources/pride-and-prejudice.txt", word2)) {
//            Collections.sort(word2);
            long starTime = System.nanoTime();
            AVLTree<String, Integer> bst = new AVLTree<>();
            for (String word : word2) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }
            for (String word : word2)
                bst.contains(word);
            long endTime = System.nanoTime();
            System.out.println("AVLTree Time: " + (endTime - starTime) / 1000000000.0);
        }

        ArrayList<String> word3 = new ArrayList<>();
        if (FileOperation.readFile("src/main/resources/pride-and-prejudice.txt", word3)) {
//            Collections.sort(word3);
            long starTime = System.nanoTime();
            RBTree<String, Integer> bst = new RBTree<>();
            for (String word : word3) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }
            for (String word : word3)
                bst.contains(word);
            long endTime = System.nanoTime();
            System.out.println("RBTree Time: " + (endTime - starTime) / 1000000000.0);
        }
    }

}


