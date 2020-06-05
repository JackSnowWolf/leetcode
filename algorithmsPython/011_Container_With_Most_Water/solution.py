class Solution:
    def maxArea(self, height: list) -> int:

        start = 0
        end = len(height) - 1
        h_left = height[start]
        h_right = height[end]
        max_area = (end - start) * min(h_left, h_right)
        while start < end:
            h_left = height[start]
            h_right = height[end]
            if h_left > h_right:
                while height[end] <= h_right:
                    end -= 1
                    if end >= start:
                        break
                max_area = max(max_area,
                               (end - start) * min(height[start], height[end]))
            else:
                while height[start] <= h_left:
                    start += 1
                    if start >= end:
                        break
                max_area = max(max_area,
                               (end - start) * min(height[start], height[end]))

        return max_area


if __name__ == '__main__':
    solution = Solution()
    solution.maxArea([2, 1])
