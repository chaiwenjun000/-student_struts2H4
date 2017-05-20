package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.HibernateSessionFactory;
import entity.Students;
import entity.Users;
import service.UserDao;

public class UsersDaoImpl implements UserDao {

	public boolean usersLogin(Users u) {
		//创建事物对象
		Transaction tx=null;
		String hql="";
		try {
			Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Users where username=? and password = ?";
			//System.out.println(u.getPassword() +  " lllllllll");
			
			Query query=session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			
			List list=query.list();
			tx.commit();
			
			//System.out.println(list.size() + " bug");
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if(tx!=null){
				tx=null;
			}
		}
	}
	
	public List<Users> queryAllUsers() {
		Session session=null;
		String hql="";
		Transaction tx=null;
		List<Users> list=null;
		try {
			session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Users";
			Query query=session.createQuery(hql);
			list=query.list();
			tx.commit();
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return list;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

}
