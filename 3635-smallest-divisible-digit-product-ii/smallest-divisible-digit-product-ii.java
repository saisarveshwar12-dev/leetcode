class Solution {
    // Digit prime factor contributions for digits 0 to 9: {count_2, count_3, count_5, count_7}
    private static final int[][] FACTORS = {
        {0, 0, 0, 0}, // 0 (unused)
        {0, 0, 0, 0}, // 1
        {1, 0, 0, 0}, // 2
        {0, 1, 0, 0}, // 3
        {2, 0, 0, 0}, // 4
        {0, 0, 1, 0}, // 5
        {1, 1, 0, 0}, // 6
        {0, 0, 0, 1}, // 7
        {3, 0, 0, 0}, // 8
        {0, 2, 0, 0}  // 9
    };

    public String smallestNumber(String num, long t) {
          long temp = t;
        int a = 0, b = 0, c = 0, d = 0;
        
        while (temp % 2 == 0) { a++; temp /= 2; }
        while (temp % 3 == 0) { b++; temp /= 3; }
        while (temp % 5 == 0) { c++; temp /= 5; }
        while (temp % 7 == 0) { d++; temp /= 7; }

        if (temp > 1) {
            return "-1";
        }

        int n = num.length();

        int validPrefixLen = n;
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '0') {
                validPrefixLen = i;
                break;
            }
        }

        int[][] req = new int[n + 1][4];
        req[0] = new int[]{a, b, c, d};
        
        int curA = a, curB = b, curC = c, curD = d;
        for (int i = 0; i < validPrefixLen; i++) {
            int digit = num.charAt(i) - '0';
            curA -= FACTORS[digit][0];
            curB -= FACTORS[digit][1];
            curC -= FACTORS[digit][2];
            curD -= FACTORS[digit][3];
            req[i + 1] = new int[]{curA, curB, curC, curD};
        }

        for (int i = Math.min(n, validPrefixLen); i >= 0; i--) {
            if (i == n) {
                if (req[n][0] <= 0 && req[n][1] <= 0 && req[n][2] <= 0 && req[n][3] <= 0) {
                    return num;
                }
            } else {
                int startDigit = (num.charAt(i) - '0') + 1;
                for (int digit = startDigit; digit <= 9; digit++) {
                    int na = req[i][0] - FACTORS[digit][0];
                    int nb = req[i][1] - FACTORS[digit][1];
                    int nc = req[i][2] - FACTORS[digit][2];
                    int nd = req[i][3] - FACTORS[digit][3];
                    
                    int remPositions = n - 1 - i;
                    if (remPositions >= getMinLen(na, nb, nc, nd)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(num, 0, i);
                        sb.append(digit);
                        sb.append(fillSuffix(remPositions, na, nb, nc, nd));
                        return sb.toString();
                    }
                }
            }
        }

       int targetLen = Math.max(n + 1, getMinLen(a, b, c, d));
        return fillSuffix(targetLen, a, b, c, d);
    }

   private int getMinLen(int remA, int remB, int remC, int remD) {
        remA = Math.max(0, remA);
        remB = Math.max(0, remB);
        remC = Math.max(0, remC);
        remD = Math.max(0, remD);

        int resCD = remC + remD;
        int min23 = Integer.MAX_VALUE;

        int maxSixes = Math.min(remA, remB);
        for (int k = 0; k <= maxSixes; k++) {
            int ra = Math.max(0, remA - k);
            int rb = Math.max(0, remB - k);
            int digits2 = (ra + 2) / 3; // Using 8s (2^3)
            int digits3 = (rb + 1) / 2; // Using 9s (3^2)
            min23 = Math.min(min23, k + digits2 + digits3);
        }
        return resCD + min23;
    }
    private String fillSuffix(int targetLen, int remA, int remB, int remC, int remD) {
        StringBuilder sb = new StringBuilder();
        for (int pos = 0; pos < targetLen; pos++) {
            int positionsLeft = targetLen - 1 - pos;
            for (int digit = 1; digit <= 9; digit++) {
                int na = remA - FACTORS[digit][0];
                int nb = remB - FACTORS[digit][1];
                int nc = remC - FACTORS[digit][2];
                int nd = remD - FACTORS[digit][3];

                if (positionsLeft >= getMinLen(na, nb, nc, nd)) {
                    sb.append(digit);
                    remA = na;
                    remB = nb;
                    remC = nc;
                    remD = nd;
                    break;
                }
            }
        }
        return sb.toString();
    }
}