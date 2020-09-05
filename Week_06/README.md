## 学习笔记

#### 动态规划

有点难，刚开始做dp的题，一点思路都没有，感觉得找感觉，得大量的做dp的题目才可以，听老师的，多做多练，刷题法刷起来。

动态规划的本质其实还是递归，等于分治 + 最优子结构。和分治的相同点在于找到重复子问题；差异就在于有无最优子结构，并且
动态规划在计算的过程总还可以淘汰次优解。

说实话，回到原点，算法无非就是 if-else，for-loop，递归，只要找到规律，多练，看到题之后想到要用哪种去解决，这就是
关键点所在，需要多练。

#### dp解题流程

1. 重复性问题（分治） ： problem（i, j） = subProblem(i, j)
2. 定义状态数组 ： f[i][j]
3. dp方程: 关键一步

这个过程中有个初始化的问题，也就是dp的边界，这个也是很重要的，否则dp是没有任何意义的。

这个动态规划要继续刷题去，五遍刷题法不够用了，那就六七八一直往上刷，总会熟练，拿到题就有思路的感觉真的很让人着迷。

#### 链接

homework：https://github.com/WangZhiLove/algorithm013/blob/master/Week_06/toSumUp.md
每日一题：https://github.com/WangZhiLove/algorithm013/tree/master/OneQuestionPerDay/src/com/wz/september

