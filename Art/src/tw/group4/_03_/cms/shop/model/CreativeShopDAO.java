package tw.group4._03_.cms.shop.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("creativeShopDAO")
public class CreativeShopDAO {

	// @Autowired @Qualifier("sessionFactory")
	private SessionFactory sessionFacory;

	@Autowired
	public CreativeShopDAO(@Qualifier("sessionFactory") SessionFactory sessionFacory) {
		this.sessionFacory = sessionFacory;
	}

	public boolean checkShopId(int shopId) {
		Session session = sessionFacory.getCurrentSession();
		CreativeShopBean result = session.get(CreativeShopBean.class, shopId);

		if (result != null) {
			return true;
		}
		return false;
	}

	public CreativeShopBean insert(CreativeShopBean bean) {
		Session session = sessionFacory.getCurrentSession();
		session.save(bean);
		return bean;
	}

	public CreativeShopBean select(int shopId) {
		Session session = sessionFacory.getCurrentSession();
		return session.get(CreativeShopBean.class, shopId);

	}

	public List<CreativeShopBean> selectById(int shopId) {
		Session session = sessionFacory.getCurrentSession();
		Query<CreativeShopBean> query = session.createQuery("From CreativeShopBean where shopId = " + shopId + " ",
				CreativeShopBean.class);
		List<CreativeShopBean> list = query.list();
		return list;
	}

	public List<CreativeShopBean> selectByName(String name) {
		Session session = sessionFacory.getCurrentSession();
		Query<CreativeShopBean> query = session.createQuery("From CreativeShopBean where name like '%" + name + "%' ",
				CreativeShopBean.class);
		List<CreativeShopBean> list = query.list();
		return list;
	}

	public List<CreativeShopBean> selectAll() {
		Session session = sessionFacory.getCurrentSession();
		Query<CreativeShopBean> query = session.createQuery("From CreativeShopBean", CreativeShopBean.class);
		List<CreativeShopBean> list = query.list();
		return list;
	}

	public CreativeShopBean update(int shopId, String name, String representImage, String intro, String cityName,
			String address, Double longitude, Double latitude, String openTime, String phone, String fax, String email,
			String facebook, String website, int clicks) {

		Session session = sessionFacory.getCurrentSession();
		CreativeShopBean result = session.get(CreativeShopBean.class, shopId);
		if (result != null) {
			result.setName(name);
			result.setRepresentImage(representImage);
			result.setIntro(intro);
			result.setCityName(cityName);

			result.setAddress(address);
			result.setLongitude(longitude);
			result.setLatitude(latitude);
			result.setOpenTime(openTime);
			result.setPhone(phone);

			result.setFax(fax);
			result.setEmail(email);
			result.setFacebook(facebook);
			result.setWebsite(website);
			result.setClicks(clicks);
		}
		return result;
	}

	public boolean delete(int shopId) {
		Session session = sessionFacory.getCurrentSession();
		CreativeShopBean result = session.get(CreativeShopBean.class, shopId);

		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}

}
