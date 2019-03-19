package datastructures.Map;

import org.junit.Test;
import datastructures.AVLTree.FileOperation;

import java.util.ArrayList;

public class Main {
    @Test
    public void testBSTMap() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("src/main/resources/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words1) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("src/main/resources/pride-and-prejudice.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            AVLMap<String, Integer> map = new AVLMap<>();
            for (String word : words2) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

    }
}
