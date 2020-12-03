package tib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//DB�� ������ �ʿ��� ��� ����� ��üȭ ��Ų Ŭ����
public class MemberMgr {

	// DB ���� ��ü 10�� ����� ����. pool��
	private DBConnectionMgr pool;

	public MemberMgr() {
		pool = DBConnectionMgr.getInstance();// �ν��Ͻ� ������� ��ü�� �����ؼ� ������
	}

	// <����Ʈ>
	// ����Ʈ :����Ʈ�� memberSwing���� �����ְ� �Է¹�ư�� ������ SigninŬ������ ȣ��
	// ���׸� : Vector�� ����Ǵ� Ÿ���� MemberBean ����(�ɼ�-�ص��ǰ� ���ص��ǰ�)
	public Vector<MemberBean> getListMember() {
		// DB���� ���� ����
		Connection con = null;// DB���� ��ü
		PreparedStatement pstmt = null;// sql�� ����� ��ü
		ResultSet rs = null;// select�� ���� ����� ���� ��ü
		String sql = null;// prepareStatement�������� sql�� �Ǿ� �ֱ� ������ sql�� �������� �ٸ� �̸����� �����ص� ��
		Vector<MemberBean> vlist = new Vector<MemberBean>();// ����� �޾ƿ��� ��Ÿ
		try {
			// pool ��ü���� ������
			con = pool.getConnection();
			// sql�� ����
			sql = "select * from member order by idx";// ��緹�ڵ带 ������������ ������
			// DB�� �����ϱ� ���� pstmt�� ����
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// DB ���� �� ����� ����,rs�� ����� sql���� ������� ����Ŵ
			while (rs.next()/* ���� cursor���� ���� cursor�� �̵�, ���̿� ���ڵ尡 ������ true */) {
				MemberBean bean = new MemberBean();
				bean.setIdx(rs.getInt("idx"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setBirth(rs.getString("birth"));
				bean.setPassword(rs.getString("password"));
				bean.setGender(rs.getString("gender"));
				bean.setPhone(rs.getString("phone"));
				bean.setImg(rs.getString("img"));
				// ���ڵ带 �����Ų ��� Vector�� ����
				vlist.addElement(bean);
			} // ---while
		} catch (Exception e) {
			e.printStackTrace();// ���� ������ �����ش�.
		} finally {
			// con�� �ݳ�, pstmt�̶� rs�� close �ؾ���.
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}

	// id�� ��й�ȣ �� ���� �� ��������
	public MemberBean getMember(String id, String ps) {// ��Ģ�� ���ݵǾ��ٴµ� �� ���� �Ǿ����� �𸣰���
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberBean bean = new MemberBean();
		try {
			con = pool.getConnection();// pool���� ��ü������
			// sql = "select * from member where id=? and password = ? ";//������ �̿ϼ�
			sql = "select * from member where  id=? and password= ? ";
			// �Ű����� id�� ù��° ?�� ����
			pstmt = con.prepareStatement(sql);// sql�� ����
			pstmt.setString(1, id);
			pstmt.setString(2, ps);
			rs = pstmt.executeQuery();// ������ ����� ����Ŵ
			// pstmt.setString(2, id);//ù���� ����ǥ�� id�� �ִ´�.������ �ϼ�

			if (rs.next()) {
				bean.setIdx(rs.getInt(1));// ���̺� ��Ű�� ���ؽ�(�÷� ���� ��ȣ 1���� ���),�÷��� �־ ��
				bean.setId(rs.getString(2));// 2=id
				bean.setName(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setBirth(rs.getString(5));
				bean.setPassword(rs.getString(6));
				bean.setGender(rs.getString(7));
				bean.setPhone(rs.getString(8));
				bean.setImg(rs.getString(9));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);// Ŀ�ؼ� �ݳ�
		}
		return bean;
	}

	public MemberBean getMember(String id) {// ��Ģ�� ���ݵǾ��ٴµ� �� ���� �Ǿ����� �𸣰���
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberBean bean = new MemberBean();
		try {
			con = pool.getConnection();// pool���� ��ü������
			// sql = "select * from member where id=? and password = ? ";//������ �̿ϼ�
			sql = "select * from member where  id=? ";
			// �Ű����� id�� ù��° ?�� ����
			pstmt = con.prepareStatement(sql);// sql�� ����
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();// ������ ����� ����Ŵ
			// pstmt.setString(2, id);//ù���� ����ǥ�� id�� �ִ´�.������ �ϼ�

			if (rs.next()) {
				bean.setIdx(rs.getInt(1));// ���̺� ��Ű�� ���ؽ�(�÷� ���� ��ȣ 1���� ���),�÷��� �־ ��
				bean.setId(rs.getString(2));// 2=id
				bean.setName(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setBirth(rs.getString(5));
				bean.setPassword(rs.getString(6));
				bean.setGender(rs.getString(7));
				bean.setPhone(rs.getString(8));
				bean.setImg(rs.getString(9));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);// Ŀ�ؼ� �ݳ�
		}
		return bean;
	}

	/*
	 * //< ���ڵ� �Ѱ� ��������-�����ϱ����� �����;������� > public MemberBean getMember(int idx) {
	 * 
	 * //�ڵ���������߰�:window-> preference - > java->editor->templates->new->name :
	 * �ڵ��ϴ��ܾ� //description:�����ϴ� �κ����� �߿����� ���� , pattern : �����ϴ� �ڵ� -> //appay and
	 * close��ư Ŭ�� Connection con = null; PreparedStatement pstmt = null; ResultSet
	 * rs = null; String sql = null; MemberBean bean = new MemberBean(); try { con =
	 * pool.getConnection();//pool���� ��ü������ sql =
	 * "select * from member where idx=?";//������ �̿ϼ� //�Ű����� idx�� ù��° ?�� ���� pstmt =
	 * con.prepareStatement(sql);//sql�� ���� pstmt.setInt(1, idx);//ù���� ����ǥ�� idx��
	 * �ִ´�.������ �ϼ� rs = pstmt.executeQuery();//������ ����� ����Ŵ if(rs.next()) {
	 * bean.setIdx(rs.getInt(1));//���̺� ��Ű�� ���ؽ�(�÷� ���� ��ȣ 1���� ���),�÷��� �־ ��
	 * bean.setId(rs.getString(2));//2=id bean.setName(rs.getString(3));
	 * bean.setEmail(rs.getString(4)); bean.setBirth(rs.getString(5));
	 * bean.setPassword(rs.getString(6)); bean.setGender(rs.getString(7));
	 * bean.setPhone(rs.getString(8)); bean.setImg(rs.getString(9)); } } catch
	 * (Exception e) { e.printStackTrace(); } finally { pool.freeConnection(con,
	 * pstmt, rs);//Ŀ�ؼ� �ݳ� } return bean; }
	 */

	// �Է�
	public boolean insertMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into member(idx,id,name,email,birth,password,gender,phone,img)"
					+ "values(seqmbr.nextval,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getEmail());
			pstmt.setString(4, bean.getBirth());
			pstmt.setString(5, bean.getPassword());
			pstmt.setString(6, bean.getGender());
			pstmt.setString(7, bean.getPhone());
			pstmt.setString(8, bean.getImg());
			int cnt = pstmt.executeUpdate();// insert,update,delete
			if (cnt == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	// ����

	public boolean updateMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "update member set id=?, name=?, email=?, birth=?, password=?, gender=?, phone=?, img=? "
					+ "where idx =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getEmail());
			pstmt.setString(4, bean.getBirth());
			pstmt.setString(5, bean.getPassword());
			pstmt.setString(6, bean.getGender());
			pstmt.setString(7, bean.getPhone());
			pstmt.setString(8, bean.getImg());
			pstmt.setInt(9, bean.getIdx());
			int cnt = pstmt.executeUpdate();// insert,update,delete
			if (cnt == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	// ����
	public boolean deleteMember(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "delete from tblMember where idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			int cnt = pstmt.executeUpdate();
			if (cnt == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
}
