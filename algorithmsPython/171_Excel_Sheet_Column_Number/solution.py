class Solution:
    def titleToNumber(self, s: str) -> int:
        """
        AB = 26**1*1(A) + 26**0*2(B)
        ZY = 26**1*26(Z) + 26**0*25(Z)
        """
        res = 0
        for i, c in enumerate(s[::-1]):
            res += (ord(c) - ord('A') + 1) * (26 ** i)
        return res
