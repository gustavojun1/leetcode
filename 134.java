class Solution {
    // if solvable
    //  returns -1
    // else
    //  returns the index of the position where it got stuck
    int solve(int start, int[] gas, int[] cost) {
        int tank = 0;
        int position = start;
        do {
            tank += gas[position]; // adding gas on the station
            tank -= cost[position]; // subbing gas cost to the next station
            if(tank < 0) {
                // negative return
                return position;
            }
            position = (position + 1) % cost.length; // modular division to maintain circularity on indexing
        } while(position != start);
        // positive return
        return -1;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {          
        for(int i = 0; i < gas.length; i++) {
            if(gas[i] >= cost[i]) {
                int k = solve(i, gas, cost); 
                if(k == -1) // if is solvable starting at i
                    return i;
                else if(k > i) { // if isn't solvable starting at i but may be with another start
                    i = k;
                }
                else // if isn't solvable starting at i and won't be at all
                    return -1;
            }
        }
        return -1;
    }
};
