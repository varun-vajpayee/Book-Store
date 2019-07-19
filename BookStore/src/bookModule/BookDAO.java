package bookModule;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookDAO {

	Configuration con = null;
	SessionFactory sf = null;

	//Connection with database for adding the books.
	public void setBooks(int bookId, String bookName, String bookAuthor, int bookPrice) {
		BookPOJO u = new BookPOJO(bookId, bookName, bookAuthor, bookPrice);
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
	//Connection with database for getting the books details.

	@SuppressWarnings("deprecation")
	public List<BookPOJO> getBooks() {
		con = new Configuration();
		con.configure("hib.cfg.xml");
		sf = con.buildSessionFactory();
		Session s = sf.openSession();
		/*
		 * String hql = "from User"; Query q = s.createQuery(hql);
		 */
		Criteria q = s.createCriteria(BookPOJO.class);
		@SuppressWarnings("unchecked")
		List<BookPOJO> list1 = q.list();
		s.close();
		return list1;
	}
}
