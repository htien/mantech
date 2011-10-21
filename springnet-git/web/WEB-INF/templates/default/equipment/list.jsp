<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="pagelet_listequipment" class="g-pl wrap">
	<h2>Equipments
		<c:if test="${isAdmin}"><a class="add-new-h2" href="<jtien:url address="/index"/>#addequipment">Add New</a></c:if>
	</h2>

	<form id="equipment-filter-form" method="post" action="/equipment/search">
		<c:if test="false">
			<div class="search-box">
				<input type="text" name="q" />
				<select name="f">
					<option value="1">Equipment</option>
					<option value="2">Category</option>
				</select>
				<div id="filter-query-submit" class="g-b g-b-r">Filter</div>
				<div id="lnkShowAll" class="g-b g-b-b">Show All</div>
			</div>
		</c:if>

		<div class="tablenav">
		</div>
		<div id="equipment-viewmanager">
			<div class="gg-listview">
				<div class="gg-listview-inner">
					<div class="gg-listview-headers-container">
						<table class="gg-list-table gg-list-header-table widefat fixed equipment">
							<colgroup>
								<col class="list-col-equipmentid" width="40" />
								<col class="list-col-equipmentname" width="200" />
								<col class="list-col-category" />
							</colgroup>
							<thead class="gg-list-thead">
								<tr class="gg-list-header">
									<td><span class="gg-inner-block">ID</span></td>
									<td><span class="gg-inner-block">Name</span></td>
									<td><span class="gg-inner-block">Category</span></td>
								</tr>
							</thead>
							<tbody><tr><td colspan="3"></td></tr></tbody>
						</table>
					</div>
					<div class="gg-listview-list">
						<div class="gg-list-container">
							<table class="gg-list-table widefat fixed equipment">
								<colgroup>
									<col class="list-col-equipmentid" width="40" />
									<col class="list-col-equipmentname" width="200" />
									<col class="list-col-category" />
								</colgroup>
								<thead class="gg-list-thead">
									<tr class="height:0"></tr>
								</thead>
								<tbody id="the-list" class="gg-list-tbody">
									<%@ include file="equipment_list_result.jsp" %>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>

</compress:html>