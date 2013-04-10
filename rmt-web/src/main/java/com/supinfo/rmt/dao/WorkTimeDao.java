package com.supinfo.rmt.dao;

import com.supinfo.rmt.entity.WorkTime;

import javax.ejb.Local;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Local
public interface WorkTimeDao {

    void addWorkTime(WorkTime workTime);
}
