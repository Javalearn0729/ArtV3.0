package tw.group4._03_.cms.shopReservation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "CS_RESERVATION_TABLE")
@Component("shopReservationBean")
public class ShopReservationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "RESERVATIONNO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationNo;

	@Column(name = "MEMBERID")
	private String memberId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SHOPID")
	private int shopId;
	
	@Column(name = "SHOPNAME")
	private String shopName;

	// =====================

	@Column(name = "CUSTOMERNAME")
	private String customerName;

	@Column(name = "ADULTSNUM")
	private int adultsNum;

	@Column(name = "CHILDRENNUM")
	private int childrenNum;

	@Column(name = "AMOUNT")
	private int amount;

	@Column(name = "STARTTIME")
	private String startTime;

	// ==================

	@Column(name = "ENDTIME")
	private String endTime;

	// ==================
	
	public ShopReservationBean() {
	}

	// ==================

	public ShopReservationBean(int reservationNo, 
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

		this.reservationNo = reservationNo;
		this.memberId = memberId;
		this.name = name;
		this.shopId = shopId;
		this.shopName = shopName;
		
		this.customerName = customerName;
		this.adultsNum = adultsNum;
		this.childrenNum = childrenNum;
		this.amount = amount;
		this.startTime = startTime;
		
		this.endTime = endTime;
	}

	public int getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAdultsNum() {
		return adultsNum;
	}

	public void setAdultsNum(int adultsNum) {
		this.adultsNum = adultsNum;
	}

	public int getChildrenNum() {
		return childrenNum;
	}

	public void setChildrenNum(int childrenNum) {
		this.childrenNum = childrenNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	// ==================
}
