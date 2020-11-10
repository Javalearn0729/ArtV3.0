package tw.group4._03_.cms.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._03_.cms.shop.model.CreativeShopBean;
import tw.group4._03_.cms.shop.model.CreativeShopService;
import tw.group4._03_.cms.util.CustomizedTypeConversion;

@Controller
public class UpdateShop {

	@Autowired
	private CreativeShopService css;

	@RequestMapping(path = "/03/cms/shop/UpdateCreativeShop.ctrl", method = RequestMethod.POST)
	private String updateCreativeShop(@RequestParam(name = "shopId") String shopId,
			@RequestParam(name = "name") String name, @RequestParam(name = "representImage") String representImage,
			@RequestParam(name = "intro") String intro, @RequestParam(name = "cityName") String cityName,

			@RequestParam(name = "address") String address, @RequestParam(name = "longitude") String longitude,
			@RequestParam(name = "latitude") String latitude, @RequestParam(name = "openTime") String openTime,
			@RequestParam(name = "phone") String phone,

			@RequestParam(name = "fax") String fax, @RequestParam(name = "email") String email,
			@RequestParam(name = "facebook") String facebook, @RequestParam(name = "website") String website,
			@RequestParam(name = "clicks") String clicks, Model m) {
		try {

			int intShopId = Integer.parseInt(shopId);
			Double doubleLongitude = CustomizedTypeConversion.customizedParseDouble(longitude);
			Double doubleLatitude = CustomizedTypeConversion.customizedParseDouble(latitude);
			int intClicks = CustomizedTypeConversion.customizedParseInt(clicks);

			// 執行更新
			css.update(intShopId, name, representImage, intro, cityName, address, doubleLongitude, doubleLatitude,
					openTime, phone, fax, email, facebook, website, intClicks);

			String acShopsUpdateMsg = "商店資料更新成功";
			m.addAttribute("acShopsUpdateMsg", acShopsUpdateMsg);

		} catch (Exception e) {
			e.printStackTrace();
			String acShopsUpdateMsg = "商店資料更新失敗";
			m.addAttribute("acShopsUpdateMsg", acShopsUpdateMsg); // 回傳錯誤訊息
		}
		return "03/cms/shop/update_return";
	}

	@RequestMapping(path = "/03/cms/shop/UpdateCreativeShopById.ctrl", method = RequestMethod.POST)
	private String updateCreativeShopById(@RequestParam(name = "shopId") String shopId, Model m) {

		try {
			int id = Integer.parseInt(shopId);
			List<CreativeShopBean> shopsList = css.selectById(id);

//			CreativeShopBean a = shopsList.get(0);
//			System.out.println(a);
			
			if (shopsList.size() != 0) {
				m.addAttribute("acShopsList", shopsList);
			} else {
				String acShopsSerachMsg = "查無此商店資料，請重新查詢";
				m.addAttribute("acShopsSerachMsg", acShopsSerachMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();

			String acShopsSerachMsg = "查無此商店編號";
			m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
		}
		return "03/cms/shop/update_confirm";

	}

	@RequestMapping(path = "/03/cms/shop/UpdateCreativeShopByName.ctrl", method = RequestMethod.POST)
	private String updateCreativeShopByName(@RequestParam(name = "name") String name, Model m) {

		try {
			List<CreativeShopBean> shopsList = css.selectByName(name);

			if (shopsList.size() != 0) {
				m.addAttribute("acShopsList", shopsList);
			} else {
				String acShopsSerachMsg = "查無此商店資料，請重新查詢";
				m.addAttribute("acShopsSerachMsg", acShopsSerachMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();

			String acShopsSerachMsg = "查無此商店名稱";
			m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
		}
		return "03/cms/shop/update_by_name";

	}

}
