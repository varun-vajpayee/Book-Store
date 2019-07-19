package loginModule1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import signUpModule.SignUpPOJO;

public class LoginDAO {

	// CHECK CREDENTIALS METHOD
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static boolean checkCredentials(String phone_Number, String password) {
		boolean isLogin = false;

		Configuration con = new Configuration();
		con.configure("hib.cfg.xml");

		SessionFactory sf = con.buildSessionFactory();
		Session s = sf.openSession();
		Criteria q = s.createCriteria(SignUpPOJO.class);

		q.add(Restrictions.eq("phone_Number", phone_Number));
		q.add(Restrictions.eq("password", password));

		List l = q.list();
		assert l.size() == 0 : "Incorrect UserName";

		if (l.size() == 1) {
			isLogin = true;

		}
		s.close();
		return isLogin;

	}
}
