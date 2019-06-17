package jeet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BTest2 {

    String[] words;
    String[] inputs;

    public BTest2(String[] words, String inputs[]) {
        this.words = words;
        this.inputs = inputs;
    }

    //s=airplane
    //start=airplane
    private String sperate(String s, String start) {
        int index = s.indexOf(start);
        if(index == -1) {
            return null;
        }
        return s.substring(index + start.length(), s.length());
    }

    public List<String> searchCompound() {
        List<String> result = new ArrayList<>();

        if(words == null || words.length == 0 || inputs == null && inputs.length == 0) {
            return null;
        }

        // words=[air,plane,airplan]
        // input = [airplane]
        // result = [airplane,airplane]

        for(String word: words) {
            for(String input: inputs) {
                if(result.contains(input)) {
                    result.add(input);
                    break;
                }
                if(input.startsWith(word)) {
                    String theOther = sperate(input, word);
                    if(theOther == null) {
                        break;
                    }
                    for(String word2: words) {
                        if(theOther.equals(word2)) {
                            result.add(input);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        List<String> s = new ArrayList<>();

        String input = "hellohelloworld";
        int index = input.lastIndexOf("hello");
        System.out.println(input.substring(index+"hello".length(), input.length()));

    }
}
