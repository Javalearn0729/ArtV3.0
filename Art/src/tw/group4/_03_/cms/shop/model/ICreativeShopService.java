package tw.group4._03_.cms.shop.model;

import java.util.List;

public interface ICreativeShopService {
	public boolean checkShopId(int shopId);

	public CreativeShopBean insert(CreativeShopBean bean);

	public CreativeShopBean select(int shopId);

	public List<CreativeShopBean> selectById(int shopId);

	public List<CreativeShopBean> selectByName(String name);

	public List<CreativeShopBean> selectAll();

	public CreativeShopBean update(int shopId, String name, String representImage, String intro, String cityName,
			String address, Double longitude, Double latitude, String openTime, String phone, String fax, String email,
			String facebook, String website, int clicks);

	public boolean delete(int shopId);

}
