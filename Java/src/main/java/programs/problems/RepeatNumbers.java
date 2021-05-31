package programs.problems;

/**
 * Created by Dean.Jain @sjain106.
 * Date: 2/9/19
 */
public class RepeatNumbers {

    static void printRepeating(int arr[], int size) {
        int count[] = new int[size];
        int i;

        System.out.println("Repeated elements are : ");
        for (i = 0; i < size; i++) {
            if (count[arr[i]] == 1)
                System.out.print(arr[i] + " ");
            else {
                count[arr[i]]++;
                System.out.println(count[arr[i]]++);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 4, 5, 2, 3, 1, 2, 2};
        int arr_size = arr.length;
        RepeatNumbers.printRepeating(arr, arr_size);
    }

}
