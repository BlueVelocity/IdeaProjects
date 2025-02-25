/**
 *  COMP-10205 - Starting code for Assignment # 2
 *
 * // statement of authorship goes here ...
 *
 *
 * // Answers for Part 3 goes here...
 *
 */

import java.util.Random;

interface Callback {
    IndividualRunData execute(int[] array);
}

class IndividualRunData {
    private double execTimeMs = 0.0;
    private long compares = 0;
    private long startTime;

    public void startClock() {
        startTime = System.currentTimeMillis();
    }

    public void stopClock() {
        execTimeMs = System.currentTimeMillis() - this.startTime;
    }

    public void incCompares() {
        this.compares++;
    }

    public double getExecTimeMs() {
        return this.execTimeMs;
    }

    public long getCompares() {
        return this.compares;
    }
}

class TestRunner {
    String sortName;
    private int[] array;
    private double totalExecTimeMs;
    private long totalCompares;
    private int[] arraySizes = {20, 400, 8_000};
    private Callback callback;

    public TestRunner(String sortname, Callback callback) {
        this.sortName = sortname;
        this.callback = callback;

    }

    public void runTests() {
        if (this.callback != null) {
            for (int arrLength: this.arraySizes) {

            }

            for (int i = 0; i < this.totalRuns; i++) {
                IndividualRunData runData = this.callback.execute(this.array);
                this.totalExecTimeMs += runData.getExecTimeMs();
                this.totalCompares += runData.getCompares();
            }
        } else {
            throw new Error("Error: Missing callback");
        }
    }

    private int[] generateArray(int length) {
        // Generates random array
        long myStudentID = 000376506; // replace with your student id
        Random rand = new Random(myStudentID);
        this.array = new int[length];
        for(int i =0; i < this.array.length; i++) {
            this.array[i] = rand.nextInt(1,length);
        }
        return array;
    }

    double getAvgExecTimeMs() {
        return this.totalExecTimeMs / this.totalRuns;
    }

    long getAvgCompares() {
       return this.totalCompares / this.totalRuns;
    }

    double getMsPerCompare() {
        return this.getAvgExecTimeMs() / this.getAvgCompares();
    }

    void printData() {
        System.out.printf("%-10s", this.sortName);
        System.out.printf("%,10.7f ms", this.totalExecTimeMs);
        System.out.printf("%,14d ops", this.totalCompares);
        System.out.printf("%,14.7f ms / op", this.getMsPerCompare());
//        System.out.printf("%,12d \n", checksum);
    }

    /**
     * Validate that an array is sorted,
     *
     * @param array array that might or might not be sorted
     * @return a 6 digit checksum if sorted, -1 if not sorted.
     */
    int ckSumSorted(int array[]) {
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return -1;
            }
            sum += array[i] * i;
        }
        return Math.abs(sum % 1_000_000);
    }


    /**
     * Randomly re-arrange any array, if sorted will unsort the array, or shuffle it
     *
     * @param array array that might or might not be sorted
     */
    void shuffle(int[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int j = rand.nextInt(array.length);
            Assignment2_Start_W25.swap(array, i, j);
        }
    }

}

/**
 * All methods are static to the class - functional style
 *
 * @author mark.yendt
 */
public class Assignment2_Start_W25 {

    /**
     * The swap method swaps the contents of two elements in an int array.
     *
     * @param array where elements are to be swapped.
     * @param a The subscript of the first element.
     * @param b The subscript of the second element.
     */
    public static void swap(int[] array, int a, int b) {
        int temp;
        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * ---------------------------- a Sort ---------------------------------------
     */

    public static void aSort(int[] array) {
        int startScan;   // Starting position of the scan
        int index;       // To hold a subscript value
        int minIndex;    // Element with smallest value in the scan
        int minValue;    // The smallest value found in the scan

        // The outer loop iterates once for each element in the
        // array. The startScan variable marks the position where
        // the scan should begin.
        for (startScan = 0; startScan < (array.length - 1); startScan++) {
            // Assume the first element in the scannable area
            // is the smallest value.
            minIndex = startScan;
            minValue = array[startScan];

            // Scan the array, starting at the 2nd element in
            // the scannable area. We are looking for the smallest
            // value in the scannable area.
            for (index = startScan + 1; index < array.length; index++) {
                if (array[index] < minValue) {
                    minValue = array[index];
                    minIndex = index;
                }
            }

            // Swap the element with the smallest value
            // with the first element in the scannable area.
            array[minIndex] = array[startScan];
            array[startScan] = minValue;
        }

    }


    /**
     * ---------------------------- b Sort ---------------------------------------
     */

    public static void bSort(int array[]) {
        int count = 0;

        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
            else if (array[i] > max)
                max = array[i];
        }
        int b[] = new int[max - min + 1];
        for (int i = 0; i < array.length; i++)
            b[array[i] - min]++;

        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[i]; j++) {
                array[count++] = i + min;
            }

    }
    /**
     * ---------------------------- c Sort ---------------------------------------
     */

    public static void cSort(int inputArray[]) {
        int length = inputArray.length;
        // Create temporary array only once
        int[] workingArray = new int[inputArray.length];

        doCSort(inputArray, workingArray, 0, length - 1);
        return;
    }

    private static void doCSort(int[] inputArray, int[] workingArray, int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doCSort(inputArray, workingArray, lowerIndex, middle);
            // Below step sorts the right side of the array
            doCSort(inputArray, workingArray, middle + 1, higherIndex);
            // Now process both sides
            part2(inputArray, workingArray, lowerIndex, middle, higherIndex);
        }
        return;
    }

    private static void part2(int[] inputArray, int[] workingArray, int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            workingArray[i] = inputArray[i];
        }
        int i1 = lowerIndex;
        int i2 = middle + 1;
        int newIndex = lowerIndex;
        while (i1 <= middle && i2 <= higherIndex) {
            if (workingArray[i1] <= workingArray[i2]) {
                inputArray[newIndex] = workingArray[i1];
                i1++;
            } else {
                inputArray[newIndex] = workingArray[i2];
                i2++;
            }
            newIndex++;
        }
        while (i1 <= middle) {
            inputArray[newIndex] = workingArray[i1];
            newIndex++;
            i1++;
        }
        return;
    }

    /**
     * ---------------------------- d Sort (Insertion Sort) ---------------------------------------
     */

    public static void dSort(int[] array) {

        int unsortedValue;  // The first unsorted value
        int scan;           // Used to scan the array

        // The outer loop steps the index variable through
        // each subscript in the array, starting at 1. The portion of
        // the array containing element 0  by itself is already sorted.
        for (int index = 1; index < array.length; index++) {
            // The first element outside the sorted portion is
            // array[index]. Store the value of this element
            // in unsortedValue.
            unsortedValue = array[index];

            // Start scan at the subscript of the first element
            // outside the sorted part.
            scan = index;

            // Move the first element in the still unsorted part
            // into its proper position within the sorted part.
            while (scan > 0 && array[scan - 1] > unsortedValue) {
                array[scan] = array[scan - 1];
                scan--;
            }

            // Insert the unsorted value in its proper position
            // within the sorted subset.
            array[scan] = unsortedValue;
        }
        return;
    }

    /**
     * ---------------------------- e Sort (Quick Sort) ---------------------------------------
     */

    public static void eSort(int array[]) {

        doESort(array, 0, array.length - 1);
        return;
    }

    /**
     * The doESort method uses the Quick Sort algorithm to sort an int array.
     *
     * @param array The array to sort.
     * @param start The starting subscript of the list to sort
     * @param end The ending subscript of the list to sort
     */
    private static void doESort(int array[], int start, int end) {
        int pivotPoint;

        if (start < end) {
            // Get the pivot point.
            pivotPoint = part1(array, start, end);
            // Sort the first sub list
            doESort(array, start, pivotPoint - 1);
            // Sort the second sub list.
            doESort(array, pivotPoint + 1, end);
        }
        return;
    }

    /**
     * The part1 method selects a pivot value in an array and arranges the
     * array into two sub lists. All the values less than the pivot will be
     * stored in the left sub list and all the values greater than or equal to
     * the pivot will be stored in the right sub list.
     *
     * @param array The array to partition.
     * @param start The starting subscript of the area to partition.
     * @param end The ending subscript of the area to partition.
     * @return The subscript of the pivot value.
     */
    private static int part1(int array[], int start, int end) {
        int pivotValue;    // To hold the pivot value
        int endOfLeftList; // Last element in the left sub list.
        int mid;           // To hold the mid-point subscript

        // Find the subscript of the middle element.
        // This will be our pivot value.
        mid = (start + end) / 2;

        // Swap the middle element with the first element.
        // This moves the pivot value to the start of
        // the list.
        swap(array, start, mid);

        // Save the pivot value for comparisons.
        pivotValue = array[start];

        // For now, the end of the left sub list is
        // the first element.
        endOfLeftList = start;

        // Scan the entire list and move any values that
        // are less than the pivot value to the left
        // sub list.
        for (int scan = start + 1; scan <= end; scan++) {
            if (array[scan] < pivotValue) {
                endOfLeftList++;
                swap(array, endOfLeftList, scan);
            }
        }

        // Move the pivot value to end of the
        // left sub list.
        swap(array, start, endOfLeftList);

        // Return the subscript of the pivot value.
        return endOfLeftList;
    }

    /**
     * ---------------------------- f Sort (Bubble Sort) ---------------------------------------
     */

    public static IndividualRunData fSort(int[] array) {
        IndividualRunData runData = new IndividualRunData();

        runData.startClock();

        int lastPos;     // Position of last element to compare
        int index;       // Index of an element to compare

        // The outer loop positions lastPos at the last element
        // to compare during each pass through the array. Initially
        // lastPos is the index of the last element in the array.
        // During each iteration, it is decreased by one.
        for (lastPos = array.length - 1; lastPos >= 0; lastPos--) {
            // The inner loop steps through the array, comparing
            // each element with its neighbor. All of the elements
            // from index 0 thrugh lastPos are involved in the
            // comparison. If two elements are out of order, they
            // are swapped.
            for (index = 0; index <= lastPos - 1; index++) {
                runData.incCompares();
                // Compare an element with its neighbor.
                if (array[index] > array[index + 1]) {
                    // Swap the two elements.

                    swap(array, index, index + 1);
                }
            }
        }

        runData.stopClock();

        return runData;
    }

    /**
     * A demonstration of recursive counting in a Binary Search
     * @param array - array to search
     * @param low - the low index - set to 0 to search whiole array
     * @param high - set to length of array to search whole array
     * @param value - item to search for
     * @param count - Used in recursion to accumulate the number of comparisons made (set to 0 on initial call)
     *
     * @return a pair - indicating the index of the match, and the # of steps to find it.
     */
    private static int[] binarySearchR(int[] array, int low, int high, int value, int count)
    {
        int middle;     // Mid point of search

        // Test for the base case where the value is not found.
        if (low > high)
            return new int[] {-1,count};

        // Calculate the middle position.
        middle = (low + high) / 2;

        // Search for the value.
        if (array[middle] == value)
            // Found match return the index
            return new int[] {middle, count};

        else if (value > array[middle])
            // Recursive method call here (Upper half of remaining data)
            return binarySearchR(array, middle + 1, high, value, count+1);
        else
            // Recursive method call here (Lower half of remaining data)
            return binarySearchR(array, low, middle - 1, value, count+1);
    }

    static void performAnalysis() {

    }

    /**
     * The main method will run through all of the Sorts for the prescribed sizes and produce output for parts A and B
     *
     * Part C should be answered at the VERY TOP of the code in a comment
     *
     */
    public static void main(String[] args) {
        TestRunner sortFData = new TestRunner("fSort", Assignment2_Start_W25::fSort);
        sortFData.runTests();

        System.out.printf("\nComparison of sorts, Array size = %,d  total runs = %,d\n");
        System.out.println("==============================================================");
        System.out.println(
                "Algorithm      Run time     # of compares         ms / compares    checksum");

        sortFData.printData();
    }

}
