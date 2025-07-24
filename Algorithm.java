import java.util.Scanner;

public class Algorithm {

    Algorithm() {}

    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int[] arr, int target) {
        if (!isSorted(arr)) {
            System.out.println("Array is not sorted. Sorting now...");
            bubbleSort(arr);
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; ++i) {
            int minIdx = i;
            for (int j = i + 1; j < n; ++j) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                --j;
            }

            arr[j + 1] = key;
        }
    }

    public boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Algorithm algo = new Algorithm();

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nChoose an operation:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.println("3. Bubble Sort");
        System.out.println("4. Selection Sort");
        System.out.println("5. Insertion Sort");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter element to search (Linear): ");
                int linTarget = sc.nextInt();
                int linIndex = algo.linearSearch(arr, linTarget);
                System.out.println(linIndex != -1 ? "Found at index: " + linIndex : "Element not found.");
                break;

            case 2:
                System.out.print("Enter element to search (Binary): ");
                int binTarget = sc.nextInt();
                int binIndex = algo.binarySearch(arr, binTarget);
                System.out.println(binIndex != -1 ? "Found at index: " + binIndex : "Element not found.");
                break;

            case 3:
                algo.bubbleSort(arr);
                System.out.println("Array after Bubble Sort:");
                printArray(arr);
                break;

            case 4:
                algo.selectionSort(arr);
                System.out.println("Array after Selection Sort:");
                printArray(arr);
                break;

            case 5:
                algo.insertionSort(arr);
                System.out.println("Array after Insertion Sort:");
                printArray(arr);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
