package Array;

import java.util.Stack;

public class IIQ1 {

//    public String useStackToDeDuplicate(String string) {//TODO remove Stack?
//
//        if (string == null || string.length() <= 1) {
//            return string;
//        }
//
//        Stack<Character> stack = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//
//        // char[] chars = string.toCharArray(); unnecessary
//
//        for (int i = 0 ; i < string.length() ; i++ ) {
//            if (stack.isEmpty() || string.charAt(i) != stack.peek()) { // need to check stack is Empty!!!!!
//                sb.append(string.charAt(i));
//            }
//        }
//
//        return sb.toString();
//    }

    public String useStackToDeDuplicate(String string) {

        if (string == null || string.length() <= 1) {
            return string;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < string.length() ; i++ ) {
            if (sb.length() != 0 || string.charAt(i) != sb.charAt(i)) { // need to check stack is Empty!!!!!
                sb.append(string.charAt(i));
            }
        }

        return sb.toString();
    }
}
