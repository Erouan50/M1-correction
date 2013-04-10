package com.supinfo.rmt.dao.jpa;

import com.supinfo.rmt.dao.WorkTimeDao;
import com.supinfo.rmt.entity.WorkTime;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@Stateless
public class WorkTimeJpaDao implements WorkTimeDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addWorkTime(WorkTime workTime) {
        em.persist(workTime);
    }
}
