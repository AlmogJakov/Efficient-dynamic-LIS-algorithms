package LIS.tests;

import org.junit.jupiter.api.Test;

import LIS.src.LIS;

import java.util.HashSet;
import java.util.Random;

class MyTest {

    private static Random _rnd = null;

    static public int[] arr_creator(int n, int seed) {
        int[] arr = new int[n];
        _rnd = new Random(seed);
        HashSet<Integer> vis = new HashSet<>();
        int n1 = n;
        while (0 < n) {
            int a = nextRnd(0, n1 * 2);
            while (vis.contains(a)) {
                a = nextRnd(0, n1 * 2);
            }
            vis.add(a);
            arr[n - 1] = a;
            n--;
        }
        return arr;
    }

    private static int nextRnd(int min, int max) {
        double v = nextRnd(0.0 + min, (double) max);
        int ans = (int) v;
        return ans;
    }

    private static double nextRnd(double min, double max) {
        double d = _rnd.nextDouble();
        double dx = max - min;
        return d * dx + min;
    }

    @Test
    void lis_4() {
        int[] a;
        int n = 800;
        for (int i = 400; i < n; i++) {
            a = arr_creator(n, 3);
            LIS test = new LIS(a, 1);
            int[] b = test.allLIS()[0];
            for (int j = 0, j2 = 0; j < b.length; j++, j2++) {
                while (b[j] != a[j2]) {
                    j2++;
                }
            }
        }
    }

    // @Test
    // void lis_4() {
    // int[] a;
    // int n = 800;
    // for (int i = 400; i < n; i++) {
    // a = arr_creator(n, 3);
    // LIS test = new LIS(a, 1);
    // System.out.println(test.numOfLIS());
    // System.out.println(test.lengthLIS());
    // int[] b = test.allLIS()[0];
    // System.out.println(Arrays.toString(b));
    // for (int j = 0, j2 = 0; j < b.length; j++, j2++) {
    // while (b[j] != a[j2])j2++;
    // }
    // }
    // }

}