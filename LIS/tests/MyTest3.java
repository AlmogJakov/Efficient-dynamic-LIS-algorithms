package LIS.tests;

import org.junit.jupiter.api.Test;

import LIS.src.LIS;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

class MyTest3 {

    private static Random _rnd = null;

    static public int[] arr_creator(int n, int seed) {
        int[] arr = new int[n];
        _rnd = new Random(seed);
        HashSet<Integer> vis = new HashSet<>();
        int n1 = n;
        while (0 < n) {
            int a = nextRnd(0, n1 * 2);
            int t = nextRnd(0, 2);
            if (t == 0)
                a = a * (-1);
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
    void lis_6() {
        int[] a;
        int n = 30;
        a = arr_creator(n, 3);
        LIS test = new LIS(a, 4);
        int[] b = test.allLIS()[0];
        assertEquals(test.allLIS().length, 4);
        assertEquals(test.numOfLIS(), 4);
        assertEquals(b.length, test.lengthLIS());
        assertEquals(8, test.lengthLIS());
        for (int j = 0, j2 = 0; j < b.length; j++, j2++) {
            while (b[j] != a[j2])
                j2++;
        }

        n = 40;
        a = arr_creator(n, 3);
        int t = 22;
        test = new LIS(a, t);
        b = test.allLIS()[0];
        assertEquals(test.allLIS().length, t);
        assertEquals(test.numOfLIS(), t);
        int[][] arr = test.allLIS();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        // printMat(test.allLIS());
        assertEquals(b.length, test.lengthLIS());
        assertEquals(9, test.lengthLIS());
        for (int j = 0, j2 = 0; j < b.length; j++, j2++) {
            while (b[j] != a[j2])
                j2++;
        }
    }
    /*
     * for n = 30:
     * test.allLIS =
     * [-50, -35, -13, 3, 16, 41, 53, 59]
     * [-50, -35, -30, -25, -20, -17, 9, 48]
     * [-50, -35, -30, -25, -20, -17, 9, 13]
     * [-50, -35, -30, -25, -20, 41, 53, 59]
     * 
     * for n = 40:
     * test.allLIS =
     * [-71, -48, 0, 51, 56, 58, 67, 71, 79]
     * [-71, -48, -46, -40, -33, -26, -22, 12, 64]
     * [-71, -48, -46, -40, -33, -26, -22, 12, 18]
     * [-71, -48, -46, -17, 4, 22, 55, 71, 79]
     * [-71, -48, -46, -40, -33, -26, 55, 71, 79]
     * [-71, -48, 0, 11, 56, 58, 67, 71, 79]
     * [-71, -60, -46, -40, -33, -26, 55, 71, 79]
     * [-71, -67, -46, -40, -33, -26, 55, 71, 79]
     * [-71, -60, -46, -40, -33, -26, -22, 12, 64]
     * [-71, -67, -46, -40, -33, -26, -22, 12, 64]
     * [-71, -60, -46, -40, -33, -26, -22, 12, 18]
     * [-71, -67, -46, -40, -33, -26, -22, 12, 18]
     * [-71, -60, -46, -17, 4, 22, 55, 71, 79]
     * [-71, -67, -46, -17, 4, 22, 55, 71, 79]
     * [-76, -60, -46, -40, -33, -26, 55, 71, 79]
     * [-76, -67, -46, -40, -33, -26, 55, 71, 79]
     * [-76, -60, -46, -40, -33, -26, -22, 12, 64]
     * [-76, -67, -46, -40, -33, -26, -22, 12, 64]
     * [-76, -60, -46, -40, -33, -26, -22, 12, 18]
     * [-76, -67, -46, -40, -33, -26, -22, 12, 18]
     * [-76, -60, -46, -17, 4, 22, 55, 71, 79]
     * [-76, -67, -46, -17, 4, 22, 55, 71, 79]
     */

    // @Test
    // void lis_4() {
    // int[] a;
    // int n = 800;
    // for (int i = 400; i < n; i++) {
    // a = arr_creator(n,3);
    // LIS test = new LIS(a, 1);
    // int[] b = test.allLIS()[0];
    // for (int j = 0, j2 = 0; j < b.length; j++, j2++) {
    // while (b[j] != a[j2])j2++;
    // }
    // }
    // }
}