package Array.binarySearch;

public class isPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) return true;
        long left = 0;
        long right = num;
        while (left <= right){
            long mid = left + ((right - left) / 2);
            long sqrt = mid * mid;
            if (sqrt == num) return true;
            if (sqrt > num){
                right = mid - 1;
            }
            if (sqrt < num){
                left = mid + 1;
            }
        }
        return false;
    }
}
