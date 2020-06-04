class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        def compare(str1, str2) -> bool:
            if len(str1) == 0 and len(str2) == 0:
                return True
            elif len(str2) == 0:
                return False
            elif len(str1) == 1 and len(str2) == 1:
                if str1 == str2:
                    return True
                elif str1 == "." or str2 == ".":
                    return True
                else:
                    return False
            elif "*" in str2:
                str2_split = str2.split("*", 1)
                str2_fst = str2_split[0]
                str2_end = str2_split[1]
                for i in range(0, len(str1) - len(str2_fst) + 2):
                    str2_new = str2_fst[0:-1] + str2_fst[-1] * i
                    if compare(str1[0:len(str2_new)], str2_new):
                        if compare(str1[len(str2_new):], str2_end):
                            return True
                return False
            else:
                if len(str1) != len(str2):
                    return False
                return compare(str1[0], str2[0]) and compare(str1[1:], str2[1:])
        return compare(s, p)

if __name__ == '__main__':
    solution = Solution()
    res = solution.isMatch("aa", "a*")
    print(res)
