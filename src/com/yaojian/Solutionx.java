package com.yaojian;

import java.util.Scanner;

public class Solutionx implements Solution {
    @Override
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(f(x, y));
        }
    }

    private int f(int x, int y) {
        if (x == 0 && y == 0) {
            return 1;
        }
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        int maxP = Math.max(absX, absY);
        int xx = 1;
        for (int i = 1; i <= maxP; i++) {
            xx = xx + 4 * (2 * i - 1) + 4;
        }
        int offset = 0;
        if (x >= 0 && y <= 0) {
            if (absX < absY) {
                offset = maxP - absX;
            } else if (absX == absY){
                offset = 0;
            } else {
                offset = 7 * maxP + absY;
            }
        }else if (x <= 0 && y <= 0) {
            if (absX <= absY) {
                offset = maxP + absX;
            } else {
                offset = 2 * maxP + (maxP - absY);
            }
        } else if (x <= 0 && y >= 0) {
            if (absX <= absY) {
                offset = 4 * maxP + (maxP - absX);
            } else {
                offset = 3 * maxP + absY;
            }
        } else {
            if (absX <= absY) {
                offset = 5 * maxP + absX;
            } else {
                offset = 6 * maxP + (maxP - absY);
            }
        }
        return xx - offset;
    }
}
