package com.comprog.stringoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateBinaryPermFromPattern {

    public List<String> generate(final String str, String formed, int i) {
        if(formed.length() == str.length())
            return Arrays.asList(formed);

        List<String> res = new ArrayList<>();
        if(str.charAt(i) == '?') {
            res.addAll(generate(str, formed + '0', i+1));
            res.addAll(generate(str, formed + '1', i+1));
        } else {
            return generate(str, formed + str.charAt(i), i+1);
        }

        return res;
    }

    public List<String> binaryStrings(String str) {
        return generate(str, "", 0);
    }

}
