class Solution:
    def __init__(self):
        self.dp = {}

    def isMatch(self, s: str, p: str) -> bool:
        if (s, p) in self.dp:
            return self.dp[s, p]

        if s == p:
            self.dp[s, p] = True
        elif len(s) > 0 and len(p) == 0:
            self.dp[s, p] = False
        elif len(s) == 0 and len(p) > 0:
            if len(p) < 2:
                self.dp[s, p] = False
            else:
                if p[1] == '*':
                    self.dp[s, p] = self.isMatch(s, p[2:])
                else:
                    self.dp[s, p] = False
        else:
            if s[0] == p[0] or p[0] == '.':
                if len(p) == 1:
                    self.dp[s, p] = self.isMatch(s[1:], p[1:])
                else:  # len(p) > 1
                    if p[1] == '*':
                        self.dp[s, p] = self.isMatch(s[1:], p) or self.isMatch(
                            s, p[2:])
                    else:
                        self.dp[s, p] = self.isMatch(s[1:], p[1:])
            else:
                if len(p) == 1:
                    self.dp[s, p] = False
                else:
                    if p[1] == '*':
                        self.dp[s, p] = self.isMatch(s, p[2:])
                    else:
                        self.dp[s, p] = False

        return self.dp[s, p]

if __name__ == '__main__':
    solution = Solution()
    res = solution.isMatch("aa", "a*")
    print(res)
