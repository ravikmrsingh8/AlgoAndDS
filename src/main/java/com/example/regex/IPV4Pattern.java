package com.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPV4Pattern {
    String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    Pattern p = Pattern.compile(regex);


    boolean match(String text){
        Matcher m = p.matcher(text);
        return m.matches();
    }

    public static void main(String[] args) {
        String ip = "190.255.26.100";
        IPV4Pattern pattern = new IPV4Pattern();
        System.out.println(pattern.match(ip));
    }
}
