class CountingSort {
    void sort(int arr[]) {
        int n = arr.length;

        
        int output[] = new int[n];

        int max = arr[0];
        for (int i = 1; i < n; ++i) {
            if (arr[i] > max)
                max = arr[i];
        }

        int count[] = new int[max + 1];
        for (int i = 0; i <= max; ++i)
            count[i] = 0;

        for (int i = 0; i < n; ++i)
            ++count[arr[i]];

        for (int i = 1; i <= max; ++i)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
    }

    // Driver method
    public static void main(String args[]) {
        CountingSort ob = new CountingSort();
        int arr[] = {2,1,4,3,2};

        ob.sort(arr);

        System.out.print("Sorted integer array is ");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }
}