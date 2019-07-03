package mybook.Util;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateUtil {
 
	private static SessionFactory sessionFactory;
	private static Configuration configuration;
	//�����ֲ߳̾�����threadLocal����������Hibernate��Session
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	
	//ʹ�þ�̬������ʼ��Hibernate
	static{
		try{
			//�����ָ��hibernate�������ļ�λ�ã���ô����Ĭ�ϵ�classpath·���²�����Ϊhibernate.cfg.xml���ļ�
			Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
			//����SessionFactory
			sessionFactory = cfg.buildSessionFactory();
		}catch(Throwable ex){
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	//���SessionFactory
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	
	//���ThreadLocal��������Sessionʵ��
	public static Session getSession() throws HibernateException {
		Session session = (Session)threadLocal.get();
		if(session == null || session.isOpen()){
			if(sessionFactory == null){
				rebuildSessionFactory();
			}
			//ͨ��SessionFactory���󴴽�Session����
			session = (sessionFactory != null)?sessionFactory.openSession():null;
			//���´򿪵�Sessionʵ�����浽�ֲ߳̾�����threadLocal��
			threadLocal.set(session);
		}
		
		return session;
	}
	
	//�ر�Sessionʵ��
	public static void closeSession() throws HibernateException {
		//���ֲ߳̾�����threadLocal�л�ȡ֮ǰ�����Sessionʵ��
		Session session = (Session)threadLocal.get();
		threadLocal.set(null);
		if(session != null){
			session.close();
		}
	}
	
	
	//�ؽ�SessionFactory
	public static void rebuildSessionFactory() {
		try{
			configuration.configure("/hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
		}catch(Exception e){
			System.out.println("Error Creating SessionFactory ");
			e.printStackTrace();
		}
	}
	
	
	//�رջ�������ӳ�
	public static void shutdown(){
		getSessionFactory().close();
	}
}