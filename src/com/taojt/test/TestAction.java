package com.taojt.test;

import com.taojt.action.GoddnessAction;
import com.taojt.model.Goddness;

import java.util.*;

/**
 * Created by taojt on 2016/6/3.
 */
public class TestAction {
    public static void main(String[] args) throws Exception {
        GoddnessAction goddnessAction = new GoddnessAction();

//        // 查询
//        List<Goddness> result = goddnessAction.query();
//
//        for(int i = 0; i< result.size();i++){
//            System.out.println(result.get(i).toString());
//        }

       /* // 添加
        Goddness g = new Goddness();
        g.setUsername("江涛");
        g.setSex(0);
        g.setAge(23);
        g.setBirthday(new Date());
        g.setEmail("taojt08@163.com");
        g.setMobile("18681352015");
        goddnessAction.add(g);*/

        /*// 更新
        Goddness g = new Goddness();
        g.setUsername("JINGTAO");
        g.setSex(0);
        g.setAge(23);
        g.setBirthday(new Date());
        g.setId(7);
        g.setEmail("taojt08@163.com");
        g.setMobile("18681352015");
        goddnessAction.edit(g);*/

        // 查询
        List<Map<String,Object>> params = new ArrayList<Map<String, Object>>();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name", "mobile");
        map.put("real", "=");
        map.put("value", "18681352015");

        params.add(map);
        List<Goddness> results = goddnessAction.query(params);
        for(int i =0;i< results.size();i++){
            System.out.println(results.get(i).toString());

        }

    }
}
