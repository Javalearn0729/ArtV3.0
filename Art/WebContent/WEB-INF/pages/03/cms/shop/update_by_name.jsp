<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<br>
	<div class=title>
		<h3 align="center" style="margin-top: 20px;">更新藝文商店</h3>
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
		<table id="03"
			class="display table table-bordered table-hover table-blue">
			<thead></thead>
			<tbody>
				<tr class="head">
					<th scope="col">商店代號</th>
					<th scope="col">商店名稱</th>
					<th scope="col">地址</th>
					<th scope="col">連絡電話</th>
					<th scope="col">電子郵件</th>
					<!-- ===================== -->
					<th scope="col">更新</th>
				</tr>
				<c:if test="${acShopsList != null}">
					<form method="post"
						action="<c:url value="/03/cms/shop/UpdateCreativeShopById.ctrl"/>">
						<c:forEach items="${acShopsList}" var="acShopsList" varStatus="vs">
							<tr>
								<td>${acShopsList.shopId}</td>
								<td>${acShopsList.name}</td>
								<td>${acShopsList.address}</td>
								<td>${acShopsList.phone}</td>

								<td>${acShopsList.email}</td>
								<td><button name="shopId" type="submit"
										value="${acShopsList.shopId}">更新</button></td>
							</tr>
						</c:forEach>
					</form>
				</c:if>
			</tbody>
		</table>
		<br>
		<c:if test="${acShopsSerachMsg != null}">
			<div align="center" style="font-size: larger">${acShopsSerachMsg}</div>
		</c:if>
	</div>
</div>
<!-- ====================================================== -->
<script>
	$(document).ready(function() {
		$('#03').DataTable({});
	});
</script>