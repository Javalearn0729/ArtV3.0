package tw.group4._03_.cms.shop.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("creativeShopService")
public class CreativeShopService implements ICreativeShopService {

	@Autowired
	private CreativeShopDAO creativeShopDAO;

	@Override
	public boolean checkShopId(int shopId) {
		return creativeShopDAO.checkShopId(shopId);
	}
	
	@Override
	public CreativeShopBean insert(CreativeShopBean bean) {
		return creativeShopDAO.insert(bean);
	}

	@Override
	public CreativeShopBean select(int shopId) {
		return creativeShopDAO.select(shopId);
		
	}
	@Override
	public List<CreativeShopBean> selectById(int shopId) {
		return creativeShopDAO.selectById(shopId);
	}
	
	@Override
	public List<CreativeShopBean> selectByName(String name) {
		return creativeShopDAO.selectByName(name);
	}

	@Override
	public List<CreativeShopBean> selectAll() {
		return creativeShopDAO.selectAll();
	}

	@Override
	public CreativeShopBean update(int shopId, String name, String representImage, String intro, String cityName,
			String address, Double longitude, Double latitude, String openTime, String phone, String fax, String email,
			String facebook, String website, int clicks) {

		return creativeShopDAO.update(shopId, name, representImage, intro, cityName, address, longitude, latitude,
				openTime, phone, fax, email, facebook, website, clicks);
	}

	@Override
	public boolean delete(int shopId) {
		return creativeShopDAO.delete(shopId);
	}

}
