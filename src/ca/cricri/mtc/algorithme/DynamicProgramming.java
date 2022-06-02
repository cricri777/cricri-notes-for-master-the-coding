package ca.cricri.mtc.algorithme;

import java.util.HashMap;
import java.util.Map;

/**
 * Dynamics Programming is just an optimization technique :
 *  - Do you have something you can cache
 * Memoization ~~~~ Caching
 */
public class DynamicProgramming {
    private static Map<Integer, Integer> cache = new HashMap<>();

    private static int longCalcul(int n) {
        System.out.println("tres long calcul pour [" + n + "]");
        return n * n;
    }

    public static int memoizedLongCalcul(int n) {
        if(cache.containsKey(n)){
            return cache.get(n);
        } else {
            System.out.println("[" + n + "] not found in cache, compute");
            int result = longCalcul(n);
            cache.put(n, result);
            return result;
        }
    }

    private static final Map<Long, Long> fibonacciMemoize = new HashMap<>();
    private static int counter = 0;

    public static long fibonacciMemoized(long n) {
        counter++;
        if(fibonacciMemoize.containsKey(n)) {
            return fibonacciMemoize.get(n);
        } else {
            if(n < 2) {
                return n;
            } else {
                fibonacciMemoize.put(n, fibonacciMemoized(n-1) + fibonacciMemoized(n-2));
                return fibonacciMemoize.get(n);
            }
        }
    }


    /**
     * House Robber
     * <a href="https://leetcode.com/problems/house-robber/">link</a>
     * TODO
     */
    public int rob(int[] nums) {
        return 0;
    }

    /**
     * bes time to bur and sell stock
     * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">link</a>
     * TODO
     */
    public int maxProfit(int[] prices) {
        return 0;
    }

    /**
     * climbing stair
     * <a href="https://leetcode.com/problems/climbing-stairs/">link</a>
     * TODO
     */
    public static int climbStairsBottomUp(int n) {
        int one = 0;
        int two = 1;

       for(int i=0; i<n-1; i++){
           int tmp = two;
           two = one + two;
           one = two;
       }
        return two;
    }
    public static int climbStairsMemoized(int n) {
        return climbStairsHelper(n, 0);
    }

    private static final Map<Integer, Integer> memoizeClimbStairs = new HashMap<>();

    private static int climbStairsHelper(int n, int current) {
        if (current == n) {
            return 1;
        } else if (current > n) {
            return 0;
        } else {
            if (memoizeClimbStairs.containsKey(current)) {
                return memoizeClimbStairs.get(current);
            } else {
                int blub = climbStairsHelper(n, current + 1) + climbStairsHelper(n, current + 2);
                memoizeClimbStairs.put(current, blub);
                return blub;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(climbStairsBottomUp(3));
    }
}
