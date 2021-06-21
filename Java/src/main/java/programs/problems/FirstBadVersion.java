package programs.problems;

public class FirstBadVersion {

    static int[] versionsArray = {1};
    public static void main(String[] args) {
        System.out.println(firstBadVersion(1));
    }
    public static int firstBadVersion(int n) {
        if(n==1) return 0;
        int mid = n/2, start = 0, end = mid;
        while (true){
            if(isBadVersion(mid) ) { // left
                if(!isBadVersion(mid-1)) return mid;
                mid=(end-start)/2;
                n = end = mid;
                if(mid==0) break;
            }
            else {   // right
                if(isBadVersion(mid+1)) return mid+1;
                mid = (n+mid)/2;
            }
        }
        return mid;
    }

    static boolean isBadVersion(int version){
        return versionsArray[version] != 0;
    }

}
