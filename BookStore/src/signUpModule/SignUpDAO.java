package signUpModule;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SignUpDAO {

	Configuration con = null;
	SessionFactory sf = null;

	void setData(String phone_Number, String password, String email_address, String addressLine1, String addressLine2,
			String city, String pinCode) {

		SignUpPOJO u = new SignUpPOJO(phone_Number, password, email_address, addressLine1, addressLine2, city, pinCode);

		System.out.println(u.toString());
		con = new Configuration();
		con.configure("hib.cfg.xml");
		sf = con.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		System.out.println("done1");
		s.save(u);
		t.commit();
		s.close();
		System.out.println("done2");

	}
}
