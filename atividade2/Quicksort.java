import java.util.Random;
import java.util.Scanner;

public class Quicksort {

    //This class should not be instantiated.
    private Quicksort(){}
    private static Random gerador;

    /*rearranges the array in ascending order, using the natural order.
    @param a the array to be sorted. */

    public static void sort (Comparable [] a) {
        gerador = new Random();
        sort(a, 0, a.length -1);
        assert isSorted(a);

    }
      //Quicksort the subarray from a [lo] to a[hi]
     private static void sort (Comparable[] a, int lo, int hi){
        if( hi <= lo) return;
        int j = rand_partition (a, lo, hi);
        sort(a, lo, hi);
        assert isSorted(a, lo, hi);
    }
    //partition the subarray a [lo..hi] so that a [lo..j-1] <= a[j] <= a[j+1..hi]
    //and return the index j.
    private staticint rand_partition(Comparable[] a, int lo, int hi){
        int n= hi-lo;
        int i = gerador.nextInt(n) + lo;

        exch(a,i,hi);
        return partition(a,lo,hi);
    }
    /* for( ; ; )
       for( ; j > 0 ; )
       for( ; ; ++j)
       for( j = 1; ; j+=3)
    */
    //for(int i/ i< n; i++) a[i] = i;
    private static int partition(Comparable [] a, int lo, int hi){
        int i = lo-1;
        int j = lo;
        Comparable v = a[hi];
        for( ; j < hi; j++){
            if(less(a[j], v)){
                i++;
                exch(a, i, j);
            }
        }
        exch(a, hi, i+1);
        //now, a[lo..j-1] <= a[j] <= a[j+1..hi]
        return i+1;
    }
    public static Comparable select(Comparable[] a, int k){
        if(k < 0 || k >= a.length){
            throe new IllegalArgumentException("index is not between 0 and " + a.length + ": " +k);
        }
        int lo = 0, hi = a.length - 1;
        while(hi > lo){
        int i = rand_partition(a, lo, hi);
        if(i > k){
            hi = i-1;
        }else if(i < k){
            lo = i + 1;
        }else{
            return a[i];
        }
    }
    //helper sorting functions
    //is v < w ?
    private static boolean less(Comparable v, Comparable w){
        if(v == w){
            return false; //optimization when reference equals
        }return v.compareTo(w) < 0;
    }
    //exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    //chech if array is sorted - useful for debugging.
    private static boolean isSorted(Comparable [] a){
        return isSorted(a, 0, a.length -1);
    }
    private static void show(Comparable [] a){
        for(int i = 0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
    public static void main (String []args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String [] a = new String[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextLine();
        }
        QuickSort.sort(a);
        show(a);
        assert isSorted(a);
    }
}
    
