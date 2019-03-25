
public class Tester
{
    public static void main(String[] args)
    {
        //Test Part A
        Customer c1 = new Customer("Smith", 1001);
        Customer c2 = new Customer("Anderson", 1002);
        Customer c3 = new Customer("Smith", 1003);
        System.out.println("Part A");
        System.out.println(c1.compareCustomer(c1));
        System.out.println(c1.compareCustomer(c2));
        System.out.println(c1.compareCustomer(c3));
        System.out.println("\n");

        //Test Part B
        Customer[] list1 = {
            new Customer("Arthur", 4920),
            new Customer("Burton", 3911),
            new Customer("Burton", 4944),
            new Customer("Franz", 1692),
            new Customer("Horton", 9221),
            new Customer("Jones", 5554),
            new Customer("Miller", 9360),
            new Customer("Nguyen", 4339) };
        Customer[] list2 = {
            new Customer("Aaron", 1729),
            new Customer("Baker", 2921),
            new Customer("Burton", 3911),
            new Customer("Dillard", 6552),
            new Customer("Jones", 5554),
            new Customer("Miller", 9360),
            new Customer("Noble", 3335) };
        Customer[] result = new Customer[6];
        prefixMerge(list1, list2, result);
        System.out.println("Part B");
        for(Customer resCustomer : result) System.out.print(resCustomer + "; ");
        System.out.println("\n");

    }

    // fills result with customers merged from the
    // beginning of list1 and list2;
    // result contains no duplicates and is sorted in
    // ascending order by customer
    // precondition:  result.length > 0;
    //                list1.length >= result.length;
    //                list1 contains no duplicates;
    //                list2.length >= result.length;
    //                list2 contains no duplicates;
    //                list1 and list2 are sorted in
    //                ascending order by customer
    // postcondition: list1, list2 are not modified
    public static void prefixMerge(Customer[] list1,
                                   Customer[] list2,
                                   Customer[] result)
    {
        int currentResultIndex, currentTwoIndex;
        currentResultIndex = currentTwoIndex = 0;

        for(int i = 0; i < list1.length;) {
            if(currentResultIndex > result.length - 1) return;

            int comparison = list1[i].compareCustomer(list2[currentTwoIndex]);
            if (comparison > 0) {
                result[currentResultIndex] = list2[currentTwoIndex];
                currentTwoIndex++;
            } else if (comparison < 0) {
                result[currentResultIndex] = list1[i];
                i++;
            } else {
                result[currentResultIndex] = list1[i];
                currentTwoIndex++;
                i++;
            }
            currentResultIndex++;
        }
    }
}
