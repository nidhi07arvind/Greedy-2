import java.util.*;

/*
TC: O(N) Two pass solution
SC: O(N) array of size N

1. Every child gets 1 candy atleast. Fill result array with 1.
2. One pass - Left Right: Check if ratings of child to the left is less than cur child. Update cur value with left value + 1.
3. Two pass - Right  to Left. Check if ratings of child to the right is less than cur. Update cur value with right value + 1. 
4. Update cur value with max value. 
5. Find sum. 
*/

public class Candy {
    public int candy(int[] ratings){

        if(ratings == null || ratings.length == 0) return 0;

        int[] res = new int[ratings.length];

        //initialize
        Arrays.fill(res,1);

        int sum = 0;

        //Left-Right
        for(int i = 1; i < res.length; i++){
            if(ratings[i] > ratings[i-1]){
                res[i] = Math.max(res[i-1] + 1, res[i]);
            }
        }

        //Right-Left
        for(int i = res.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                res[i] = Math.max(res[i+1] + 1, res[i]);
            }
        }

        for(int num : res){
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args){
        int[] ratings = new int[]{5,4,3,2,1};
        Candy c = new Candy();

        System.out.println(c.candy(ratings));
    }
}
