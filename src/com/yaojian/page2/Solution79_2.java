package com.yaojian.page2;

import com.yaojian.Solution;

import java.util.HashSet;
import java.util.Stack;

public class Solution79_2 implements Solution {
    @Override
    public void solution() {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        String word = "ABCESEEEF";
        System.out.println(exist(board, word));
    }

    class Node {
        int idx;
        int x;
        int y;
        HashSet<String> visited = new HashSet<>();
        public Node(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            visited.add(x + ":" + y);
        }
    }

    public boolean exist(char[][] board, String word) {
        Stack<Node> stack = new Stack<>();
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == words[0]) {
                    stack.push(new Node(0, i, j));
                }
            }
        }
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            int x = node.x;
            int y = node.y;
            int idx = node.idx;
            HashSet<String> visited = node.visited;
            if (idx >= words.length - 1) {
                return true;
            }
            if (x + 1 < board.length && board[x + 1][y] == words[idx + 1] && !visited.contains((x + 1) + ":" + y)) {
                Node newNode = new Node(idx + 1, x + 1, y);
                newNode.visited.addAll(visited);
                newNode.visited.add((x + 1) + ":" + y);
                stack.push(newNode);
            }

            if (x - 1 >= 0 && board[x - 1][y] == words[idx + 1] && !visited.contains((x - 1) + ":" + y)) {
                Node newNode = new Node(idx + 1, x - 1, y);
                newNode.visited.addAll(visited);
                newNode.visited.add((x - 1) + ":" + y);
                stack.push(newNode);
            }

            if (y - 1 >= 0 && board[x][y - 1] == words[idx + 1] && !visited.contains(x + ":" + (y - 1))) {
                Node newNode = new Node(idx + 1, x, y - 1);
                newNode.visited.addAll(visited);
                newNode.visited.add(x + ":" + (y - 1));
                stack.push(newNode);
            }

            if (y + 1 < board[0].length && board[x][y + 1] == words[idx + 1] && !visited.contains(x + ":" + (y + 1))) {
                Node newNode = new Node(idx + 1, x, y + 1);
                newNode.visited.addAll(visited);
                newNode.visited.add(x + ":" + (y + 1));
                stack.push(newNode);
            }
        }
        return false;
    }
}
