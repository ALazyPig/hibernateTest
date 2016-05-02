package com.hibernate.zhaojun.model;

import java.io.File;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.hibernate.zhaojun.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
	  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	  session.beginTransaction();
//	  new Test().updateInstruction(session);
	  Student student = new Student();
      student.setAge(18);
      student.setName("xiaoming");
      session.save(student);
      session.getTransaction().commit();
      HibernateUtil.getSessionFactory().close();
	}
	public void updateInstruction(Session session){
		String s;
		String sql="update t_sqzg_cfys_ypsmsxx set smsbz='1' where yybm=?";
		File folder = new File("C:\\Users\\军\\Desktop\\市统一272个品种说明书");//C:\Users\军\Desktop\市统一272个品种说明书
		File[] files = folder.listFiles();
		for(File f : files){
			System.out.println(f.getName());
			s = f.getName().substring(0, 15);
			SQLQuery query=session.createSQLQuery(sql);
			query.setParameter(0, s).executeUpdate();
			System.out.println(s);
		}
	}
}
