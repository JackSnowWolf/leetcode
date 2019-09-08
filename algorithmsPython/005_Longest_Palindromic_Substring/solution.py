class Solution:
    def longestPalindrome(self, s: str) -> str:
        size = len(s)
        if size == 0:
            return 0
        max_len = 1
        max_str = ""
        for curr in range(1, size):
            i = 1
            while curr - i >= 0 and curr + i < size - 1 and s[curr - i] == s[curr + i]:
                if 2 * i + 1 > max_len:
                    max_str = s[curr - i:curr + i + 1]
                i += 1
            i = 1
            while curr - i >= 0 and curr + i < size - 1 and s[curr - i] == s[curr + i - 1]:
                if 2 * i > max_len:
                    max_str = s[curr - i:curr + i - 1]
                i += 1
        return max_str


if __name__ == '__main__':
    solution = Solution()
    res = solution.longestPalindrome("abad")
    print(res)
