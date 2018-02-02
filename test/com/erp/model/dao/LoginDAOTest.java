package com.erp.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.TestVO;

public class LoginDAOTest extends BaseDAO<TestVO> {

	@Test
	public void testSave() {
		
		try {
			save(new TestVO("zhangsan",22,87.5));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		//获取Session对象
//		Session session = HibernateUtils.getSession();
//		//2、开启事物
//		try {
//			session.beginTransaction();
//			//3、执行save操作
//			TestVO testVO =  new TestVO("zhangsan",22,87.5);
//			session.save(testVO);
//			//6、提交事物
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			//7、事物回滚
//			session.getTransaction().rollback();
//		}
	}

	public void testDel() {
		//获取Session对象
		Session session = HibernateUtils.getSession();
		//2、开启事物
		try {
			session.beginTransaction();
			//3、执行删除操作,删除的条件是对象要具有id,delete是根据id来删除的
			TestVO testVO =  new TestVO("zhangsan",22,87.5);
			testVO.setId(1);
			session.delete(testVO);
			//6、提交事物
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//7、事物回滚
			session.getTransaction().rollback();
		}
	}
	
	public void testUpdate() {
		//获取Session对象
		Session session = HibernateUtils.getSession();
		//2、开启事物
		try {
			session.beginTransaction();
			//3、执行Update操作,条件是对象要具有id且存在记录(id= set的id).
			TestVO testVO =  new TestVO("李四",22,87.5);
			testVO.setId(8);
			session.update(testVO);
			//6、提交事物
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//7、事物回滚
			session.getTransaction().rollback();
		}
	}

	//Persist()方法可以实现insert,由于它是jpa的实现，并不是hibernate实现，
	//因此我们使用save()方法，而尽量不要用persist()方法.
	public void testPersist() {
		//获取Session对象
		Session session = HibernateUtils.getSession();
		//2、开启事物
		try {
			session.beginTransaction();
			//3、执行insert操作,条件是对象要具有id且存在记录(id= set的id).
			TestVO testVO =  new TestVO("王五",22,87.5);
			
			session.persist(testVO);;
			//6、提交事物
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//7、事物回滚
			session.getTransaction().rollback();
		}
	}
	
	public void testGet() {
		//获取Session对象
		Session session = HibernateUtils.getSession();
		//2、开启事物
		try {
			session.beginTransaction();
			//3、执行select操作,条件是对象要具有id且存在记录(id= set的id).
			TestVO testVO = session.get(TestVO.class,8);
			System.out.println(testVO);
			//6、提交事物
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//7、事物回滚
			session.getTransaction().rollback();
		}
	}

	//get()和load()的共同点:根据id查询对象	
	//get()和load()的区别:get()方法查询一个不存在的记录，会返回一个null对象
	//load()方法查询一个不存在的记录，会抛出空指针异常
	public void testLoad() {
		//获取Session对象
		Session session = HibernateUtils.getSession();
		//2、开启事物
		try {
			session.beginTransaction();
			//3、执行select操作,条件是对象要具有id且存在记录(id= set的id).
			TestVO testVO = session.load(TestVO.class,8);
			System.out.println(testVO);
			//6、提交事物
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//7、事物回滚
			session.getTransaction().rollback();
		}
	}

	public void testSaveOrUpdate() {
		//获取Session对象
		Session session = HibernateUtils.getSession();
		//2、开启事物
		try {
			session.beginTransaction();
			//3、执行Update操作,条件是对象要具有id且存在记录(id= set的id).
			TestVO testVO =  new TestVO("李四",22,87.5);
			testVO.setId(8);
			//被操作对象testVO,如果这里给了ID，则执行update,不考虑表中是否有这个id的记录
			//被操作对象testVO,如果没有id,则执行insert（insert在hibernate中等于save）.
			session.saveOrUpdate(testVO);
			//6、提交事物
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//7、事物回滚
			session.getTransaction().rollback();
		}
	}

	public void testGetLoad() {
		//获取Session对象
		Session session = HibernateUtils.getSession();
		//2、执行查询,此时会抛出异常，因为session是通过getCurrentSession()
		//方法获取的，如果是通过openSession()方法获取的，则不会抛出异常，
		//通过getCurrentSession()获取的session,其执行CURD必须在事物中进行
	
			session.beginTransaction();
	
			TestVO testVO = session.get(TestVO.class,8);
			System.out.println(testVO);
	
	}

	public void testGetLoad2() {
		//获取Session对象
		Session session = HibernateUtils.getSessionFactory().openSession();
		//2、执行查询,此时正常执行查询,不会抛出异常，
		//通过getCurrentSession()获取的session,其执行CURD必须在事物中进行
	
			session.beginTransaction();
	
			TestVO testVO = session.get(TestVO.class,8);
			System.out.println(testVO);
	
	}

	//测试事物执行顺序，testCURD()方法，会先执行查询，接着执行插入，
	//接着执行update,最后delete,其业务逻辑完全和我们要的不一致
	public void testCURD() {
		//获取Session对象
		Session session = HibernateUtils.getSession();
		//2、开启事物
		try {
			session.beginTransaction();
			//3、执行操作
			//增删改操作，如果放在同一个事物中，系统默认执行顺序为增改删
			//因此，一定要注意这个问题，否则数据一致性遭到破坏，可以在需要的地方
			//刷新Session缓存，则以刷新点为界限，分别执行增改删。这样能够避开这种
			//执行顺序造成的数据不一致，如4所示
			
			//删除.
			TestVO testVO =  session.get(TestVO.class, 8);
			session.delete(testVO);
			
			//刷新Session缓存,删除虽然最后做，但是因为在刷新点前，所以第一部分
			//执行增改删的结果是执行delete,第二部分执行增改删的结果是增改。
			
			session.flush();
			
			//插入
			TestVO testVO2 = new TestVO("正往",21,90.5);
			session.save(testVO2);
			
			//修改
			TestVO testVO3 =  session.get(TestVO.class, 8);
			testVO3.setName("赵六");
			session.update(testVO3);
				
			//6、提交事物
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//7、事物回滚
			session.getTransaction().rollback();
		}
	}

}
