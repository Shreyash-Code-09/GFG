import java.util.*;

class Solution {
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }

        // If target not present → impossible
        if (!set.contains(targetWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(startWord);

        int steps = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String word = q.poll();

                if (word.equals(targetWord)) return steps;

                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[j] = ch;
                        String newWord = new String(arr);

                        if (set.contains(newWord)) {
                            q.add(newWord);
                            set.remove(newWord); // mark visited
                        }
                    }

                    arr[j] = original; // restore
                }
            }

            steps++;
        }

        return 0;
    }
}