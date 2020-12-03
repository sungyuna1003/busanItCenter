package tib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//db������ �ʿ��� ��� ����� ��üȭ ��Ų��
public class TibImgMgr {

	private DBConnectionMgr pool;

	public TibImgMgr() {
		pool = DBConnectionMgr.getInstance();// ��ü����
	}

	// ����Ʈ
	// ���׸�: Vector�� ����Ǵ� Ÿ���� MemberBean ����(�ɼ�)
	public Vector<TravelBean> getListMember() {

		// DB���� ���� ����
		Connection con = null; // DB���� ��ü]
		PreparedStatement pstmt = null; // sql �� ����� ��ü
		ResultSet rs = null; // select�� ���� ����� ���� ��ü
		String sql = null;
		Vector<TravelBean> vlist = new Vector<TravelBean>();
		try {
			// pool ��ü���� ������
			con = pool.getConnection();
			// sql�� ����
			sql = "select MAIN_IMG_NORMAL from travel where uc_seq = ?";
			// DB�� �����ϱ� ���� pstmt �� ����
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// DB ���� �� ����� ����(DB���� �ڹٷ� ������)
			while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
				TravelBean bean = new TravelBean();
				bean.setMAIN_IMG_THUMB(rs.getString("MAIN_IMG_THUMB"));
		
				// ���ڵ带 �����Ų ��� Vector�� ����
				vlist.addElement(bean);

			} // --While
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// con�� �ݳ�, pstmt�̶� rs�� close �ؾ���.
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}

	// ���ڵ� �Ѱ� ��������
	public TravelBean getTravel(String MAIN_IMG_THUMB) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		TravelBean bean = new TravelBean();

		try {
			con = pool.getConnection();
			sql = "select * from travel where uc_seq = ?";
			// �Ű����� idx�� ù��° ����ǥ�� ����
			pstmt = con.prepareStatement(sql); // ����
			pstmt.setString(1, MAIN_IMG_THUMB); // Ŀ���� �ϼ�
			rs = pstmt.executeQuery(); // ����� ���� ����,
			if (rs.next()) {
				bean.setMAIN_IMG_THUMB(rs.getString("MAIN_IMG_THUMB"));
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
}
