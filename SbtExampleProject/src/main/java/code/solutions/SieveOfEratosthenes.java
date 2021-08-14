package code.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 Given a number n, print all primes smaller than or equal to n. It is also given that n is a small number.
 */

public class SieveOfEratosthenes {

    public static void main(String args[]) {
        int n = 47;

        boolean[] prime = getListOfPrime(n);
        for(int i = 2; i <= n; i++) {
            if(!prime[i]) System.out.println(i);
        }
    }

    public static boolean[] getListOfPrime(int n) {
        boolean[] prime = new boolean[n + 1];

        for(int i = 2; i <= n; i++) {
            if(!prime[i]) {
                for(int j = i * i; j < n; j += i) {
                    prime[j] = true;
                }
            }
        }

        return prime;
    }
}
