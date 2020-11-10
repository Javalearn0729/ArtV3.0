package tw.group4._03_.cms.shopReservation.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("shopReservationService")
public class ShopReservationService implements IShopReservationBean {

	@Autowired
	private ShopReservationDAO shopReservationDAO;
	
	
	@Override
	public boolean checkReservationNo(int reservationNo) {
		return shopReservationDAO.checkReservationNo(reservationNo);
	}

	@Override
	public ShopReservationBean insert(ShopReservationBean bean) {
		return shopReservationDAO.insert(bean);
	}

	@Override
	public ShopReservationBean select(int reservationNo) {
		return shopReservationDAO.select(reservationNo);
	}

	@Override
	public List<ShopReservationBean> selectByNo(int reservationNo) {
		return shopReservationDAO.selectByNo(reservationNo);
	}

	@Override
	public List<ShopReservationBean> selectByName(String name) {
		return shopReservationDAO.selectByName(name);
	}

	@Override
	public List<ShopReservationBean> selectByShopName(String shopName) {
		return shopReservationDAO.selectByShopName(shopName);
	}

	@Override
	public List<ShopReservationBean> selectAll() {
		return shopReservationDAO.selectAll();
	}

	@Override
	public ShopReservationBean update(int reservationNo, String memberId, String name, int shopId, String shopName,
			String customerName, int adultsNum, int childrenNum, int amount, String startTime, String endTime) {
		return shopReservationDAO.update(reservationNo, memberId, name, shopId, shopName, 
				customerName, adultsNum, childrenNum, amount, startTime, endTime);
	}

	@Override
	public boolean delete(int reservationNo) {
		return shopReservationDAO.delete(reservationNo);
	}

}
