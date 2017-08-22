package org.advanced.validators;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UniqueKeyValidator implements ConstraintValidator<UniqueKey, Object> {

	private static final Logger logger = LogManager.getLogger();

	@PersistenceContext
	private EntityManager manager;
	
	private String columnNames;
	private Class<?> entityClass;
	
	public Session getSession(){
		Session session = null;
		try{
			session = manager.unwrap(Session.class);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return session;
	}
	@Override
	public void initialize(UniqueKey constraintAnnotation) {
		this.columnNames = constraintAnnotation.columnName();
		this.entityClass = constraintAnnotation.className();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Class<?> entityClass = this.entityClass;
		System.out.println("Class: "+entityClass.toString());
		
		@SuppressWarnings("deprecation")
		Criteria criteria = getSession().createCriteria(entityClass);
		try{
			criteria.add(Restrictions.eq(this.columnNames, value));
		}catch(Exception e){
			e.printStackTrace();
		}
		return criteria.list().size()==0;
	}
}