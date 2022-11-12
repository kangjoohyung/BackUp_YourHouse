package mvc.dto.orders;

import java.util.ArrayList;
import java.util.List;

public class OrdersDTO {
	private int ordersCode;
	private int userCode;
	private int totalPrice;
	private String ordersAdress;
	private String status;
	private String ordersReg;
	
	private List<OrdersDetail> ordreDetailList = new ArrayList<OrdersDetail>();
	
	public OrdersDTO() {}

	public OrdersDTO(int ordersCode, int userCode, int totalPrice, String ordersAdress, String status,
			String ordersReg) {
		this.ordersCode = ordersCode;
		this.userCode = userCode;
		this.totalPrice = totalPrice;
		this.ordersAdress = ordersAdress;
		this.status = status;
		this.ordersReg = ordersReg;
	}

	public int getOrdersCode() {
		return ordersCode;
	}

	public void setOrdersCode(int ordersCode) {
		this.ordersCode = ordersCode;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrdersAdress() {
		return ordersAdress;
	}

	public void setOrdersAdress(String ordersAdress) {
		this.ordersAdress = ordersAdress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrdersReg() {
		return ordersReg;
	}

	public void setOrdersReg(String ordersReg) {
		this.ordersReg = ordersReg;
	}

	public List<OrdersDetail> getOrdreDetailList() {
		return ordreDetailList;
	}

	public void setOrdreDetailList(List<OrdersDetail> ordreDetailList) {
		this.ordreDetailList = ordreDetailList;
	}
}
