package com.example.bit;


public class BaseConversion {
    private Base base;

    public BaseConversion(Base base) {
        this.base = base;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    //Get 10th Base Number from NBase Number
    public long decoode(String x) {
        char[] alphabets = base.getAlphabet().toCharArray();
        long val = 0;

        for (char ch : x.toCharArray()) {
            val *= base.getRadix();
            if ('0' <= ch && ch <= '9') {
                val += ch - '0';
            } else if ('A' <= ch && ch <= 'Z') {
                val += ch - 'A' + 10;
            } else if ('a' <= ch && ch <= 'z') {
                val += ch - 'a' + 36;
            }
        }
        return val;
    }

    public String encode(long num) {
        StringBuilder encode = new StringBuilder();
        char[] alphabet = base.getAlphabet().toCharArray();
        while (num > 0) {
            encode.append(alphabet[(int)(num % base.getRadix())]);
            num /= base.getRadix();
        }
        return encode.reverse().toString();
    }


    public static void main(String[] args) {
        BaseConversion conversion = new BaseConversion(Base._16);
        System.out.println(conversion.encode(35));
        System.out.println(conversion.decoode(conversion.encode(35)));

        conversion.setBase(Base._2);
        System.out.println(conversion.encode(35));
        System.out.println(conversion.decoode(conversion.encode(35)));

        conversion.setBase(Base._62);
        System.out.println(conversion.encode(6129129314232213232L));
        System.out.println(conversion.decoode(conversion.encode(6129129314232213232L)));

    }
}
