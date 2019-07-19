package orderModule;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OrderDAO {

	public void addOrderDetails(String orderID, String customerName, String vTempCustomer_Phone,
			String vTempCustomer_Address, int vTempBook_Quantity, String addressLine1, String orderDate) {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hib.cfg.xml");

			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			OrderPOJO u = new OrderPOJO(orderID, customerName, vTempCustomer_Phone, vTempBook_Quantity,
					vTempCustomer_Address, addressLine1, orderDate);
			session.save(u);
			transaction.commit();
			session.close();
			sessionFactory.close();
			System.out.println("\n\n Order submitted \n");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
	}
}
