package com.erp.model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;

/**
 * 所有的 DAO的父类 
 * 继承时需要填写泛型
 * 例如 ：  public class UserDao extend BaseDAO<User>{}
 * @author JiaQi
 *
 * @param <T>
 */
public abstract class BaseDAOw <T> {
	private Class<T> clazz;
	
	
	/**
	 * 构造方法  通过泛型去得到真实实体类映射
	 */
	@SuppressWarnings("unchecked")
	public BaseDAOw() {
		// 使用反射得到T的真实类
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); // 获取当前new的对象的 泛型的父类型
		this.clazz = (Class<T>)pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
	}

	/**
	 * 保存实体类方法
	 * 直接传参数  参数为实体类  
	 * 数据库设置为自增长 Id
	 * 需要处理异常
	 * @param entity
	 */
	public  void save(T entity) throws Exception{
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		
	}
	
	/**
	 * 保存或修改
	 * 如果没有就保存，有就进行修改 
	 *  
	 * @param entity
	 */
	public void saveOrUpdate(T entity) throws Exception{
		
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
	}
	
	/**
	 * 修改  方法
	 * @param entity
	 */
	public void update(T entity) throws Exception{
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
	}
	
	/**
	 * 删除  通过id进行删除
	 * @param id
	 */
	public void delete(Long id) throws Exception{
		Object obj = getById(id);
		if (obj != null) {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			session.delete(obj);
			session.getTransaction().commit();
		}
	}

	/**
	 * 通过id获得  对应的实体类
	 * 如果未查询到  返回 null
	 * @param id
	 * @return
	 */
	public  T getById(Long id) throws Exception{
		if (id == null) {
			return null;
		} else {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			T t =  (T) session.get(clazz, id);
			session.close();
			return t;
			
		}
	}

	/**
	 * 查询所有   返回的是一个list集合
	 * 如果表中没有数据  返回 null
	 * @return
	 */
	public List<T> findAll() throws Exception{
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<T> list= session.createQuery(
				"FROM " + clazz.getSimpleName())
				.list();
		session.close();
		return list;
	}
	
	/**
	 * 
	 */
	
}