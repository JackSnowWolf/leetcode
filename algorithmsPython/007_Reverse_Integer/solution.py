class Solution:
    def reverse(self, x: int) -> int:
        res = 0
        tag = True if x < 0 else False
        x = abs(x)
        while x != 0:
            res *= 10
            res += (x % 10)
            x = x // 10
        if tag:
            res = -res
        return res


if __name__ == '__main__':
    solution = Solution()
    res = solution.reverse(123)
    print(res)
