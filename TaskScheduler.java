/*
TC: O(N) : N - length of tasks array
SC: O(1) HashMap can have at max 26

1. We follow greedy approach i.e., find the maxfreq of characters to determine least units of time.
2. The number of partitions is determined by maxFreq character.
3. The empty slots can be filled by either remaining characters or idle.
4. To reduce time, empty slots are first filled by other pending characters. 
5. Idle slots is obtained by empty - pending.
6. Total length would be idle + current length of array.



*/
import java.util.*;
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n){
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        int maxFreqCount = 0;

        for(char ch : tasks){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));
        }

        for(int num : map.values()){
            if(num == maxFreq)
                maxFreqCount++;
        }

        int partitions = maxFreq - 1;
        int empty = (n - maxFreqCount + 1) * partitions;
        int pending = tasks.length - (maxFreq * maxFreqCount);
        int idle = Math.max(0, empty - pending);

        return tasks.length + idle;
    }

    public static void main(String[] args){
        char[] tasks = new char[]{'A','A','A','B','B','C'};
        TaskScheduler ts = new TaskScheduler();
        System.out.println(ts.leastInterval(tasks, 2));

    }
}
