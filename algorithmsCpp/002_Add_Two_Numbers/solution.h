//
// Created by huchong on 19-4-24.
//

#ifndef LEETCODE_SOLUTION_H
#define LEETCODE_SOLUTION_H
#include <stdio.h>

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        int sum;
        int exceed = 0;
        ListNode* res = l1;
        ListNode* prev = l1;
        if(!l1 && !l2)
        {
            return new ListNode(0);
        }
        while (l1 || l2 || exceed) {
            sum = exceed;
            if (l1)sum += l1->val;
            if (l2)sum += l2->val;
            exceed = sum / 10;
            int val =  sum % 10;
            if (!l1 && l2)
            {
                ListNode* temp = l2;
                prev->next = l2;
                l2 = l1;
                l1 = temp;
                l1->val = val;
            }
            else if(!l1 && !l2)
            {
                ListNode* node_t = new ListNode(val);
                prev->next = node_t;
            }
            else
            {
                l1->val = val;
            }
            prev = l1;
            if (l1)l1 = l1->next;
            if (l2)l2 = l2->next;
        }
        return res;
    }
};

#endif //LEETCODE_SOLUTION_H
