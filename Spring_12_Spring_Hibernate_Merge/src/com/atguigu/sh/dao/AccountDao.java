package com.atguigu.sh.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	// [3]根据用户名减少用户账户中的余额，减少的额度就是书的价格
	public void updateBalanceByUsername(String username, int price) {
		String hql = "update Account a set a.balance = a.balance - ? where a.username = ?";
		sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, price).setParameter(1, username)
				.executeUpdate();
	}
}
