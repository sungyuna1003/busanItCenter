<%@page import="tib.TravelBean"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html; charset=utf-8"%>
<jsp:useBean id="mgr" class="tib.TravelMgr"/>
<%
		Vector<TravelBean> vlist = mgr.getTravelList();
%>
<!DOCTYPE HTML>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>Map List</title>
</head>
<body>
<div id="map" style="width:100%;height:350px;">
<h2>부산 관광 명소</h2>
<table border="1">
	<tr>
		<th>컨텐츠ID</th>
		<th>TITLE</th>
		<th>지도보기</th>
	</tr>
	<%
			for(int i=0;i<vlist.size();i++){
				TravelBean bean = vlist.get(i);
				int uc_seq = bean.getUc_seq();
				String main_title = bean.getMain_title();
				double lat =  bean.getLat();
				double lng =  bean.getLng();
				String main_img_thumb  = bean.getMain_img_thumb();
				String addr1 = bean.getAddr1();
				String homepage_url = bean.getHomepage_url();
				String cntct_tel = bean.getCntct_tel();
				String url = "http://jspstudy.co.kr/tib/map.jsp?uc_seq="+uc_seq;
				url+="&uc_seq="+uc_seq;
				url+="&main_title="+main_title;
				url+="&lat="+lat;
				url+="&lng="+lng;
				url+="&main_img_thumb="+main_img_thumb;
				url+="&addr1="+addr1;
				url+="&homepage_url="+homepage_url;
				url+="&cntct_tel="+cntct_tel;
	%>
			<tr align="center">
				<td><%=uc_seq%></td>
				<td><%=main_title%></td>
				<td><a href="<%=url%>">지도보기</a></td>
			</tr>
	<%}%>
</table>
</div>
</body>
</html>









