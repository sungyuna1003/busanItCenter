package tib;

//������̹� : ���̺��+Bean
//���� : ���ڵ�(����) ������ ������ ���
public class TrvlBean {

	
	private int tidx;
	private String place;
	private String address;
	private String pnumber;
	
	
	                 //getXxx
	public int getTidx() {
		return tidx;
	}                 
	                   //setXxx(Ÿ�� �÷���)
	public void setTidx(int tidx) {
		this.tidx = tidx;
	}

////////////////////////////////////////////	
	public String getPlace() {
		return place;
	}
	public void setplace(String place) {
		this.place = place;
	}
	/////////////////////////
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    ////////////////////////////////
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	
}
