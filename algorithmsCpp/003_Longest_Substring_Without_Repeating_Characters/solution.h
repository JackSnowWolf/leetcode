//
// Created by huchong on 19-8-13.
//

#ifndef LEETCODE_SOLUTION_H
#define LEETCODE_SOLUTION_H
#include <unordered_map>
#include <unordered_map>
#include <vector>
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int max = 0;
        int min = s.length();
        unordered_map<char, int> prev_first;
        unordered_map<char, int> prev_second;
        
        for(int i = 0; i < s.length(); ++i)
        {
            if(prev_first.find(s[i]) == prev_first.end())
            {
                prev_first[s[i]] = i;
                
            }
            else
            {
                prev_second[s[i]] = prev_first[s[i]];
                prev_first[s[i]] = i;
            }
            if(!prev_second.empty())
            {
                min = s.length();
                for(auto it : prev_second)
                {
                    int sub = i - it.second;
                    min = min < sub ? min : sub;
                }
                max = max > min ? max : min;                
            }
            else
            {
                max = i + 1;
            }
        }
        return max;
    }
};
#endif //LEETCODE_SOLUTION_H
