#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int> &nums, int target) {
        unordered_map<int, int> nums_pairs;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums_pairs.find(target - nums[i]) != nums_pairs.end()) {
                return {nums_pairs[target - nums[i]], i};
            }
            nums_pairs[nums[i]] = i;
        }
        return {-1, -1};
    }
};
