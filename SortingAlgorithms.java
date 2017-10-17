public class SortingAlgorithms
{
    public static void swap(int a, int b, int[] array){
        int temp = array[b];
        array[b]=array[a];
        array[a]=temp;
    }
    public static void bubbleSort(int[] nums)
    {
        int currentInd = 0;
        int nextInd = 1;
        int moves = 0;
        do
        {
            if(nextInd == nums.length)
            {
                currentInd = 0;
                nextInd = 1;
                moves = 0;
            }
            if(nums[nextInd] < nums[currentInd])
            {
                int temp = nums[nextInd];
                nums[nextInd] = nums[currentInd];
                nums[currentInd] = temp;
                moves++;
            }
            currentInd++;
            nextInd++;


        }
        while(moves != 0);

        System.out.println("done with bubble");


    }
    public static void selectionSort(int[] nums)
    {
        for(int i = 0;i<nums.length-1;i++){
            int min = i;

            for(int x = i+1; x<nums.length; x++){
                if(nums[x]<nums[min]){
                    min = nums[i];
                }
            }
            if(min != i){
                swap(min, i, nums);
            }
        }
    }



    public static void insertionSort(int[] nums)
    {
        for(int p=0;p<nums.length;p++){
            for(int x = 0;x<=p;x++){
                if(nums[p]<nums[x]){
                    swap(p,x,nums);
                }
            }
        }
    }

    // A helper method for you to check if your sorts work
    private static boolean isSorted(int[] nums){
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] > nums[i+1])
                return false;
        return true;
    }

    // Generate an array of size N with random integers in the range [0, N]
    private static int[] generateRandomArray(int N){
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = (int) (Math.random()*N);
        return nums;
    }

    // Generate a sorted array of size N whose contents are in the range [0, N]
    private static int[] generateSortedArray(int N){
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = i;
        return nums;
    }

    // Generate a reversed array of size N whose contents are in the range [0, N]
    private static int[] generateReversedArray(int N){
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = (N - 1 ) - i;
        return nums;
    }

    // Assumes that nums is not empty
    private static void printArray(int[] nums)
    {
        System.out.print("[" + nums[0]);
        for (int i = 1; i < nums.length; i++)
            System.out.print(", " + nums[i]);
        System.out.println("]");
    }

    // Use main for testing and timing your sorts
    public static void main(String[] args)
    {
        int[] testArray = generateReversedArray(10);

        printArray(testArray);



        /*long start = System.currentTimeMillis();
        selectionSort(testArray);
        long end = System.currentTimeMillis();
        double sortTime = (end - start) / 1000.0;*/

       insertionSort(testArray);

        printArray(testArray);
        System.out.println(isSorted(testArray));

        //System.out.format("Time to complete took %.4f seconds.%n", sortTime);



    }
}
