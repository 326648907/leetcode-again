package Array.binarySearch;

public class re_mySqrt {
    public int re_mySqrt(int x) {
        if(x == 0) return 0;
        long left = 1;
        long right = x;
        while (left <= right){
            long mid = left + (right - left)/2;
            long r = mid * mid;
            if (r == x) return (int) mid;
            if (r > x){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return (int) right;
    }
}
