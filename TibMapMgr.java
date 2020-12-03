package tib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import member.MemberBean;

//db������ �ʿ��� ��� ����� ��üȭ ��Ų��
public class TibMapMgr {

	private DBConnectionMgr pool;

	public TibMapMgr() {
		pool = DBConnectionMgr.getInstance();// ��ü����
	}

	// ����Ʈ
	// ���׸�: Vector�� ����Ǵ� Ÿ���� MemberBean ����(�ɼ�)
	public Vector<TravelBean> getListTravel() {

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
			sql = "select MAIN_TITLE, gridx, gridy from travel where uc_seq = ?";
			// DB�� �����ϱ� ���� pstmt �� ����
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// DB ���� �� ����� ����(DB���� �ڹٷ� ������)
			while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
				TravelBean bean = new TravelBean();
				bean.setGRIDX(rs.getInt("gridX"));
				bean.setGRIDY(rs.getInt("gridY"));
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
	public TravelBean getTravel(int UC_SEQ) {

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
			pstmt.setInt(1, UC_SEQ); // Ŀ���� �ϼ�
			rs = pstmt.executeQuery(); // ����� ���� ����,
			if (rs.next()) {
				bean.setUC_SEQ(rs.getInt("UC_SEQ"));
				bean.setLAT(rs.getDouble("LAT"));
				bean.setLNG(rs.getDouble("LNG"));
				bean.setMAIN_IMG_THUMB(rs.getString("MAIN_IMG_THUMB"));
				bean.setMAIN_TITLE(rs.getString("MAIN_TITLE"));
				bean.setADDR1(rs.getString("ADDR1"));
				bean.setHOMEPAGE_URL(rs.getString("HOMEPAGE_URL"));
				bean.setCNTCT_TEL(rs.getString("CNTCT_TEL"));
				bean.setITEMCNTNTS(rs.getString("ITEMCNTNTS"));
				bean.setUSAGE_DAY_WEEK_AND_TIME(rs.getString("USAGE_DAY_WEEK_AND_TIME"));
				
				bean.setGRIDX(rs.getInt("GRIDX"));
				bean.setGRIDY(rs.getInt("GRIDY"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	public Vector<TravelBean> getListTravel(int position) {
		Connection con = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<TravelBean> vlist = new Vector<TravelBean>();
		try {
			con = pool.getConnection();
			sql = "SELECT UC_SEQ, MAIN_IMG_THUMB,MAIN_TITLE,ADDR1,USAGE_DAY_WEEK_AND_TIME,ITEMCNTNTS,HLDY_INFO "
					+ "FROM(SELECT ROWNUM AS RNUM, t1.* FROM travel t1) "
					+ "WHERE RNUM BETWEEN ? AND ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, position);
			pstmt.setInt(2, position+2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TravelBean bean = new TravelBean();
				bean.setUC_SEQ(rs.getInt("UC_SEQ"));
				bean.setMAIN_IMG_THUMB(rs.getString("MAIN_IMG_THUMB"));
				bean.setMAIN_TITLE(rs.getString("MAIN_TITLE"));
				bean.setADDR1(rs.getString("ADDR1"));
				bean.setUSAGE_DAY_WEEK_AND_TIME(rs.getString("USAGE_DAY_WEEK_AND_TIME"));
				bean.setITEMCNTNTS(rs.getString("ITEMCNTNTS"));
				bean.setHLDY_INFO(rs.getString("HLDY_INFO"));
				
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
}













