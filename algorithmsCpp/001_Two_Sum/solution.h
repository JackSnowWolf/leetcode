#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int> &nums, int target) {
        unordered_map<int, int> curr;
        for (int i = 0; i < nums.size(); i++) {
            if (curr.find(target - nums[i]) != curr.end()) {
                return {curr[target - nums[i]], i};
            }
            curr[nums[i]] = i;
        }
        return {-1, -1};
    }
};