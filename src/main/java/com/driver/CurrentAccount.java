package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);

        this.tradeLicenseId = tradeLicenseId.toUpperCase();

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw " Exception
        for(int i = 0; i < tradeLicenseId.length() - 1; i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1)) {
                String res = rearrangeString(tradeLicenseId);
                if (res == "") {
                    throw new Exception("Valid License can not be generated");
                } else {
                    tradeLicenseId = res;
                }
            }
        }
//        System.out.println("tradeLicenseId-->" + tradeLicenseId);
    }
    public char getMaxCountChar(int[] count)
    {
        int max = 0;
        char ch = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                ch = (char)((int)'A' + i);
            }
        }
        return ch;
    }

    public String rearrangeString(String S)
    {

        int N = S.length();
        if (N == 0)
            return "";

        int[] count = new int[26];
        for (int i = 0; i < 26; i++) {
            count[i] = 0;
        }
        for (char ch : S.toCharArray()) {
            count[(int)ch - (int)'A']++;
        }

        char ch_max = getMaxCountChar(count);
        int maxCount = count[(int)ch_max - (int)'A'];

        // check if the result is possible or not
        if (maxCount > (N + 1) / 2)
            return "";

        String res = "";
        for (int i = 0; i < N; i++) {
            res += ' ';
        }

        int ind = 0;
        // filling the most frequently occurring char in the
        // even indices
        while (maxCount > 0) {
            res = res.substring(0, ind) + ch_max
                    + res.substring(ind + 1);
            ind = ind + 2;
            maxCount--;
        }
        count[(int)ch_max - (int)'A'] = 0;

        // now filling the other Chars, first filling the
        // even positions and then the odd positions
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                ind = (ind >= N) ? 1 : ind;
                res = res.substring(0, ind)
                        + (char)((int)'A' + i)
                        + res.substring(ind + 1);
                ind += 2;
                count[i]--;
            }
        }
        return res;
    }

}
