public class ArrayLookup {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 4, 6, 7, 9, 13, 14, 17 };
        int[] arr2 = { 0, 3, 5, 8, 9, 11, 12, 14, 17, 18, 20 };

        //Method 1
        long startTime = System.nanoTime();
        Integer[] lowestCommon = lc1(arr1, arr2);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / (double)1000000;
        System.out.println("The lowest common factor using Method 1 is: " + lowestCommon[0] + ", done in " + duration + "ms with " + lowestCommon[1] + " comparisons");
    
        //Method 2
        long startTime2 = System.nanoTime();
        Integer[] lowestCommon2 = lc2(arr1, arr2);
        long endTime2 = System.nanoTime();
        double duration2 = (endTime2 - startTime2) / (double) 1000000;
        System.out.println("The lowest common factor using Method 2 is: " + lowestCommon2[0] + ", done in " + duration2 + "ms with " + lowestCommon2[1] + " comparisons");
    }

    public static Integer[] lc1(int[] nums1, int[] nums2) {
        Integer lcf = null, comparisons = 0;

        //Check each element of nums1 against each element of nums2
        lcLoop:
            for (int num : nums1) {
                for (int j = 0; j < nums2.length; j++) {
                    comparisons++;

                    if (num == nums2[j]) {
                        lcf = num;
                        break lcLoop;
                    }
                }
                
            }

        return new Integer[] {lcf, comparisons};
    }

    public static Integer[] lc2(int[] nums1, int[] nums2) {
        Integer lcf = null, comparisons = 0;
        
        int i = 0;
        lcloop:  
            for (int num : nums1) {
                if (num < nums2[i]) continue;
                while (num >= nums2[i]) {
                    comparisons++;
                    
                    if (num == nums2[i]) {
                        lcf = num;
                        break lcloop;
                    }

                    i++;
                }
            }

        return new Integer[] {lcf, comparisons};
    }
}

//21 October 2018 (21 10 2018) 01:52