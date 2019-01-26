import java.util.ArrayList;

public class Kangaroo {
    public static void main(String[] args) {
        ArrayList<Integer> ebic = new ArrayList<Integer>(10);
        ebic.add(1);
        ebic.add(3);
        ebic.add(7);
        ebic.add(2);
        ebic.add(9);
        ebic.add(4);
        ebic.add(8);
        ebic.add(6);
        ebic.add(5);
        System.out.println(ebic);

        /* ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < ebic.size(); i++) 
            if (ebic.get(i) % 2 != 0) 
                nums.add(ebic.get(i));

        nums.forEach(a -> {
            ebic.remove(a);
        }); */

        /* for (int i = 0; i < ebic.size(); i++)
            if (ebic.get(i) % 2 != 0)
                ebic.set(i, null);
        
        while (ebic.contains(null)) ebic.remove(null); */

        ebic.removeIf(a -> a % 2 != 0);

        System.out.println(ebic);
    }
}