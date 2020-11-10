<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<br>
	<div class=title>
		<h3 align="center" style="margin-top: 20px;">新增藝文商店</h3>
	</div>
	<div class="back" align="right">
		<form action="<c:url value='/03/cms/shop/Index'/> " method="get">
			<div class="submitButton">
				<input type="submit" class="" name="submit" value="返回 藝文商店管理">
			</div>
		</form>
	</div>
	<br>
	<div class=content>
		<form method="post"
			action="<c:url value = "/03/cms/shop/CreateCreativeShop.ctrl"/>">
			<table id="03"
				class="display table table-bordered table-hover table-blue">
				<thead></thead>
				<tbody>
					<tr>
						<td>商店名稱*</td>
						<td><input type="text" placeholder="請輸入商店名稱 " name="name"
							required="required"></td>
						<td></td>
					</tr>
					<tr>
						<td>圖像連結網址</td>
						<td><input type="text" placeholder="請輸入圖片網址"
							name="representImage"></td>
						<td></td>
					</tr>
					<tr>
						<td>簡介*</td>
						<td><textarea placeholder="請輸入簡介內容" name="intro"
								style="width: 450px; height: 70px;" required="required"></textarea></td>
						<td style="width: 200px;"></td>
					</tr>
					<tr>
						<td>行政區</td>
						<td><input type="text" placeholder="請輸入行政區" name="cityName"></td>
						<td></td>
					</tr>

					<!-- ====================================================== -->

					<tr>
						<td>地址*</td>
						<td><input type="text" placeholder="請輸入地址" name="address"
							required="required"></td>
						<td></td>
					</tr>
					<tr>
						<td>經度</td>
						<td><input type="text" placeholder="請輸入經度" name="longitude"></td>
						<td></td>
					</tr>
					<tr>
						<td>緯度</td>
						<td><input type="text" placeholder="請輸入緯度" name="latitude"></td>
						<td></td>
					</tr>
					<tr>
						<td>營業時間*</td>
						<td><input type="text" placeholder="請輸入營業時間" name="openTime"
							required="required"></td>
						<td>*無格式要求</td>
					</tr>
					<tr>
						<td>連絡電話*</td>
						<td><input type="text" placeholder="請輸入連絡電話" name="phone"
							required="required"></td>
						<td>*無格式要求</td>
					</tr>

					<!-- ====================================================== -->

					<tr>
						<td>傳真號碼</td>
						<td><input type="text" placeholder="請輸入傳真號碼" name="fax"></td>
						<td></td>
					</tr>
					<tr>
						<td>電子郵件*</td>
						<td><input type="text" placeholder="請輸入電子郵件" name="email"
							required="required"></td>
						<td></td>
					</tr>
					<tr>
						<td>Facebook連結網址*</td>
						<td><input type="text" placeholder="請輸入facebook 網址"
							name="facebook" required="required"></td>
						<td></td>
					</tr>
					<tr>
						<td>商店網站連結網址</td>
						<td><input type="text" placeholder="請輸入網址" name="website"></td>
						<td></td>
					</tr>
					<tr>
						<td>點擊次數</td>
						<td><input type="text" placeholder="請輸入點擊次數" name="clicks"></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<br>
			<div class="submitButton" align="center" style="font-size:larger">
				<input type="submit" name="submit" value="資料送出">
			</div>
			<br>
		</form>
	</div>
</div>
	<!-- ====================================================== -->
<script>
	$(document).ready(function() {
		$('#03').DataTable({});
	});
</script>