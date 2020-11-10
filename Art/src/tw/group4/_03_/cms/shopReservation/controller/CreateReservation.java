package tw.group4._03_.cms.shopReservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._03_.cms.shopReservation.model.ShopReservationBean;
import tw.group4._03_.cms.shopReservation.model.ShopReservationService;

@Controller
public class CreateReservation {

	@Autowired
	private ShopReservationService srs;

	@RequestMapping(path = "/03/cms/reservation/CreateReservation.ctrl", method = RequestMethod.POST)
	public String createReservation(
			@RequestParam(name="memberId") String memberId,
			@RequestParam(name="name") String name,
			@RequestParam(name="shopId") int shopId,
			@RequestParam(name="shopName") String shopName,
			
			@RequestParam(name="customerName") String customerName,
			@RequestParam(name="adultsNum") int adultsNum,
			@RequestParam(name="childrenNum") int childrenNum,
			@RequestParam(name="amount") int amount,
			@RequestParam(name="startTime") String startTime,
		
			@RequestParam(name="endTime") String endTime,
			Model m) {
		try {
			
			ShopReservationBean reservation = new ShopReservationBean();
			
//			測試
//			System.out.println("reservationNo = " + reservation.getReservationNo());
			
			reservation.setMemberId(memberId);
			reservation.setName(name);
			reservation.setShopId(shopId);
			reservation.setShopName(shopName);

			reservation.setCustomerName(customerName);
			reservation.setAdultsNum(adultsNum);
			reservation.setChildrenNum(childrenNum);
			reservation.setAmount(amount);
			reservation.setStartTime(startTime);

			reservation.setEndTime(endTime);
			srs.insert(reservation);
			
			String reservationCreateMsg = "商店預約新增成功";
			m.addAttribute("reservationCreateMsg", reservationCreateMsg);

		} catch (Exception e) {
			e.printStackTrace();

			String reservationCreateMsg = "商店預約新增失敗";
			m.addAttribute("reservationCreateMsg", reservationCreateMsg); // 回傳錯誤訊息
		}

		return "03/cms/reservation/create_return";

	}

}
