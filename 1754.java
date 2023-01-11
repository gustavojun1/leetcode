class Solution {
    public String largestMerge(String word1, String word2) {
        String merge = new String();
        int counter1 = 0, counter2 = 0;
        while(counter1 < word1.length() || counter2 < word2.length()) {
            if(counter2 == word2.length() || word1.charAt(counter1) > word2.charAt(counter2)) {
                merge = merge + word1.charAt(counter1);
                counter1++;
            }
            else if(counter1 == word1.length() || word2.charAt(counter2) > word1.charAt(counter1)) {
                merge = merge + word2.charAt(counter2);
                counter2++;
            }   
            else if(word1.charAt(counter1) == word2.charAt(counter2)) {
                for(int i = counter1 + 1, j = counter2 + 1; i <= word1.length() - counter1 && j <= word2.length() - counter2; i++, j++) {
                    if(word1.charAt(i) > word2.charAt(j)) {
                        merge = merge + word1.charAt(counter1);
                        counter1++;
                    }
                    else if(word1.charAt(i) > word2.charAt(j)) {
                        merge = merge + word2.charAt(counter2);
                        counter2++;
                    }
                }

            }
        }
        return merge;
    }
}
