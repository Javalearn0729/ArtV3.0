package tw.group4._03_.cms.shopReservation.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("shopReservationDAO")
public class ShopReservationDAO {

	// @Autowired @Qualifier("sessionFactory")
	private SessionFactory sessionFacory;

	@Autowired
	public ShopReservationDAO(@Qualifier("sessionFactory") SessionFactory sessionFacory) {
		this.sessionFacory = sessionFacory;
	}

	public boolean checkReservationNo(int reservationNo) {
		Session session = sessionFacory.getCurrentSession();
		ShopReservationBean result = session.get(ShopReservationBean.class, reservationNo);

		if (result != null) {
			return true;
		}
		return false;
	}

	public ShopReservationBean insert(ShopReservationBean bean) {
		Session session = sessionFacory.getCurrentSession();
		session.save(bean);
		return bean;
	}

	public ShopReservationBean select(int reservationNo) {
		Session session = sessionFacory.getCurrentSession();
		return session.get(ShopReservationBean.class, reservationNo);

	}

	public List<ShopReservationBean> selectByNo(int reservationNo) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean where reservationNo = " + reservationNo + " ",
				ShopReservationBean.class);
		List<ShopReservationBean> list = query.list();
		return list;
	}

	public List<ShopReservationBean> selectByName(String name) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean where name like '%" + name + "%' ",
				ShopReservationBean.class);
		List<ShopReservationBean> list = query.list();
		return list;
	}

	public List<ShopReservationBean> selectByShopName(String shopName) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean where name like '%" + shopName + "%' ",
				ShopReservationBean.class);
		List<ShopReservationBean> list = query.list();
		return list;
	}

	public List<ShopReservationBean> selectAll() {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean", ShopReservationBean.class);
		List<ShopReservationBean> list = query.list();
		return list;
	}

	public ShopReservationBean update(int reservationNo, 
			String memberId, 
			String name, 
			int shopId, 
			String shopName, 
			String customerName,
			int adultsNum, 
			int childrenNum, 
			int amount, 
			String startTime, 
			String endTime) {

		Session session = sessionFacory.getCurrentSession();
		ShopReservationBean result = session.get(ShopReservationBean.class, shopId);
		if (result != null) {
			result.setMemberId(memberId);
			result.setName(name);
			result.setShopId(shopId);
			result.setShopName(shopName);

			result.setCustomerName(customerName);
			result.setAdultsNum(adultsNum);
			result.setChildrenNum(childrenNum);
			result.setAmount(amount);
			result.setStartTime(startTime);

			result.setEndTime(endTime);
		}
		return result;
	}

	public boolean delete(int reservationNo) {
		Session session = sessionFacory.getCurrentSession();
		ShopReservationBean result = session.get(ShopReservationBean.class, reservationNo);

		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}

}
