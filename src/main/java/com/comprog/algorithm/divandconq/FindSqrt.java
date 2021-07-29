package com.comprog.algorithm.divandconq;

public class FindSqrt {

    public int mySqrt(int x) {

        //Case when x is 0
        if(x == 0 || x == 1) {
            return x;
        }

        int low = 0, high = x;
        int mid, midSq;

        while( low < high) {
            mid = low + (high-low)/2;
            //midSq = mid*mid;

            if(mid == x/mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }
            else if( mid > x/mid ) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

}
