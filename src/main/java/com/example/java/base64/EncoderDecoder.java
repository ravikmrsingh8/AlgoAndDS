package com.example.java.base64;

import java.util.Base64;

public class EncoderDecoder {
    public static void main(String[] args) {
        String data = "Top secret data";
        byte[] encodedBytes = Base64.getEncoder().encode(data.getBytes());
        StringBuilder eBytes = new StringBuilder();
        for(byte b : encodedBytes){
            eBytes.append((b & 0xff) + " ");
        }
        System.out.println(eBytes);

        byte[] decBytes = Base64.getDecoder().decode(encodedBytes);
        String decString =new String(decBytes);
        System.out.println(decString);
    }
}
