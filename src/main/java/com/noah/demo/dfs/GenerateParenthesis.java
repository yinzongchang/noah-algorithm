package com.noah.demo.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: GenerateParenthesis.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/16
 */
public class GenerateParenthesis {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        ans.clear();

        dfs(n, 0, 0, "");

        return ans;
    }


    // 定义递归函数

    /**
     * n是括号对数，lc是左括号数量，rc是右括号数量，str是当前维护的合法括号序列。
     * <p>
     * 搜索过程如下：
     * <p>
     * 1、初始时定义序列的左括号数量lc 和右括号数量rc都为0。
     * 2、如果 lc < n，左括号的个数小于n，则在当前序列str后拼接左括号。
     * 3、如果 rc < n && lc > rc , 右括号的个数小于左括号的个数，则在当前序列str后拼接右括号。
     * 4、当lc == n && rc == n 时，将当前合法序列str加入答案数组res中。
     * <p>
     * 作者：lin-shen-shi-jian-lu-k
     * 链接：https://leetcode.cn/problems/generate-parentheses/solution/shen-du-you-xian-bian-li-zui-jian-jie-yi-ypti/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private void dfs(int n, int lc, int rc, String s) {

        if (lc == n && rc == n) {

            ans.add(s);
        } else {

            if (lc < n) {

                dfs(n, lc + 1, rc, s + "(");
            }

            if (rc < n && lc > rc) {
                dfs(n, lc, rc + 1, s + ")");
            }
        }
    }


}
