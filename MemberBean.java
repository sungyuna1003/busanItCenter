
package tib;

//������̹� : ���̺��+Bean ->����
//���� : ���ڵ�(����) ������ ������ ���
public class MemberBean {

	private int idx;
	private String id;
	private String name;
	private String email;
	private String birth;
	private String password;
	private String gender;
	private String phone;
	private String img;
	
	//�����ʸ��콺 Ŭ�� -> source->geter and seter->select all->generateŬ��
	 //getXxx ���� ��������
	public int getIdx() {
		return idx;
	}
	 //setXxx(Ÿ�� �÷���) ���� �ְ�
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

}
