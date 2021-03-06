package tw.group4._03_.input;

import java.util.ArrayList;

import tw.group4._03_.input.CreativeShop.CreateShopsTable;
import tw.group4._03_.input.CreativeShop.ShopsTable;
import tw.group4._03_.input.ReservationPolicy.CreateReservationPolicyTable;
import tw.group4._03_.input.ShopReservation.CreateShopReservationTable;

public class CreateTable03 {

	public void executeCreateTable() {

		CreateShopsTable input = new CreateShopsTable();

		// 刪除舊的文創商店表格
		input.dropShopsTable();

		// 建立文創商店表格
		input.createShopsTableForDB();

		// 讀取Json轉換成list
		ArrayList<ShopsTable> list = input.readJsonToTable();

		// 將list讀進DB
		input.creatShopsInfoTable(list);

		// =============================

		CreateShopReservationTable input2 = new CreateShopReservationTable();

		// 刪除舊的商店預約表格
		input2.dropShopReservationTable();

		// 建立商店預約表格
		input2.createShopReservationTable();

		// =============================

		CreateReservationPolicyTable input3 = new CreateReservationPolicyTable();

		// 刪除舊的商店預約規則表格
		input3.dropReservationPolicyTable();
		
		// 建立商店預約規則表格
		input3.createReservationPolicyTable();

		// =============================

	}
}
