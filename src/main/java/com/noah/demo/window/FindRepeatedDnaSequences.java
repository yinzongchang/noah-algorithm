package com.noah.demo.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: FindRepeatedDnaSequences.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/28
 */
public class FindRepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {

        List<String> ans = new ArrayList<>();

        Map<String, Integer> cntMap = new HashMap<>();

        for (int i = 0; i <= s.length() - 10; i++) {

            String sub = s.substring(i, i + 10);
            cntMap.put(sub, cntMap.getOrDefault(sub, 0) + 1);
            if (cntMap.get(sub) == 2) {
                ans.add(sub);
            }
        }

        return ans;
    }

}
