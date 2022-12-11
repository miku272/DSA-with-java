public class FunWithArrays {
    public static void swap(int[] numbers, int indexA, int indexB) {
        int temp = numbers[indexA];

        numbers[indexA] = numbers[indexB];
        numbers[indexB] = temp;
    }

    public static int binarySearch(int[] numbers, int elementToSearch) {
        int start = 0, end = numbers.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (numbers[mid] == elementToSearch) {
                return mid;
            }

            if (numbers[mid] > elementToSearch) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void reverseArray(int[] numbers) {
        int first = 0, last = numbers.length - 1;

        while (first < last) {
            swap(numbers, first, last);

            first++;
            last--;
        }
    }

    public static void arrayPair(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int current = numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                System.out.print("(" + current + "," + numbers[j] + ") ");
            }

            System.out.print("\n");
        }
    }

    public static void printSubarray(int[] numbers) {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(numbers[k] + " ");

                    sum += numbers[k];
                }
                System.out.print(" Sum = " + sum);
                sum = 0;
                System.out.print("\n");
            }

            System.out.print("\n");
        }
    }

    public static void maxSubarraySum(int[] numbers) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                currSum = 0;

                for (int k = i; k <= j; k++) {
                    currSum += numbers[k];
                }

                System.out.println(currSum);

                if (maxSum < currSum)
                    maxSum = currSum;
            }
        }

        System.out.println("\nMax sum: " + maxSum);
    }

    public static void prefixSum(int[] numbers) {
        int[] prefix = new int[numbers.length];
        int currSum = 0, maxSum = Integer.MIN_VALUE;

        prefix[0] = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];

                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }

        System.out.println("Max sum: " + maxSum);
    }

    public static void kadanesMaxSubarraySum(int[] numbers) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            currSum = currSum + numbers[i];

            if (currSum < 0) {
                currSum = 0;
            }

            maxSum = Math.max(currSum, maxSum);
        }

        System.out.println("Max sum: " + maxSum);
    }

    public static void main(String[] args) {
        int[] numbers = { 2, 4, 6, 8, 10 };
        // int key = 10, result = -1;

        // result = binarySearch(numbers, key);

        // if (result == -1) {
        // System.out.println("The given element was not found in the array");
        // } else {
        // System.out.println("The given element was found at " + (result + 1) + "th
        // position in the array");
        // }

        // reverseArray(numbers);

        // for(int i = 0; i < numbers.length; i++) {
        // System.out.print(numbers[i] + " ");
        // }

        // arrayPair(numbers);

        // printSubarray(numbers);
        // maxSubarraySum(numbers);
        // prefixSum(numbers);
        kadanesMaxSubarraySum(numbers);
    }
}