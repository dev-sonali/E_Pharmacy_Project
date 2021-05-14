package pojoClass;

public class DrugClass 
{
	private String DrugName;
	private int Barcode;
	private String CostPrice;
	private String CompanyName;
	private int Quantity;
	private PurchaseClass purchase_obj;
	
	public PurchaseClass getPurchase_obj() {
		return purchase_obj;
	}
	public void setPurchase_obj(PurchaseClass purchase_obj) {
		this.purchase_obj = purchase_obj;
	}
	public String getDrugName() {
		return DrugName;
	}
	public void setDrugName(String drugName) {
		DrugName = drugName;
	}
	public int getBarcode() {
		return Barcode;
	}
	public void setBarcode(int barcode) {
		Barcode = barcode;
	}
	public String getCostPrice() {
		return CostPrice;
	}
	public void setCostPrice(String costPrice) {
		CostPrice = costPrice;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
}
