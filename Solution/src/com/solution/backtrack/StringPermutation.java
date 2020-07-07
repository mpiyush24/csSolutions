package com.solution.backtrack;

import com.solution.main.*;

import java.util.*;

public class StringPermutation {

    public void run() {
        Scanner sc = ReadInput.getScanner("permute");
        String str = sc.next();
        doPermute(str, 0, str.length() - 1);

    }

    private void doPermute(String str, int l, int r) {

        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                doPermute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    private String swap(String str, int i, int j) {
        char[] chr = str.toCharArray();
        char c = chr[i];
        chr[i] = chr[j];
        chr[j] = c;
        //System.out.println("Original String: "+str+" Replaced String: "+result);
        return new String(chr);

    }


}
