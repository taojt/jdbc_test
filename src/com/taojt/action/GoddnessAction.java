package com.taojt.action;

import com.taojt.dao.GoddnessDao;
import com.taojt.model.Goddness;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by taojt on 2016/6/3.
 */
public class GoddnessAction {

    public void add(Goddness goddness) throws Exception {
        GoddnessDao goddnessDao = new GoddnessDao();
        goddnessDao.addGoddness(goddness);

    }

    public void edit(Goddness goddness) throws Exception {
        GoddnessDao goddnessDao = new GoddnessDao();
        goddnessDao.updateGoddness(goddness);

    }

    public void del(Integer id) throws Exception {
        GoddnessDao goddnessDao = new GoddnessDao();
        goddnessDao.delGoddness(id);

    }

    public List<Goddness> query() throws Exception {
        GoddnessDao goddnessDao = new GoddnessDao();
        return goddnessDao.query();
    }

    public List<Goddness> query(List<Map<String, Object>> params) throws Exception {
        GoddnessDao goddnessDao = new GoddnessDao();
        return goddnessDao.query(params);
    }

    public Goddness get(Integer id) throws SQLException {
        GoddnessDao goddnessDao = new GoddnessDao();
        return goddnessDao.get(id);
    }

}
