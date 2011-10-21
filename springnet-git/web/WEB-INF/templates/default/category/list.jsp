<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="pagelet_category_list" class="g-pl wrap">
	<h2>Categories
		<c:if test="${isAdmin}"><a class="add-new-h2" href="<jtien:url address="/index"/>#addcategory">Add New</a></c:if>
	</h2>
	
	<form id="category-filter-form" method="post" action="/category/search">
		<div id="category-viewmanager">
			<div class="gg-listview">
				<div class="gg-listview-inner">
					<div class="gg-listview-headers-container">
						<table class="gg-list-table gg-list-header-table widefat fixed category">
							<colgroup>
								<col class="list-col-categoryid" width="50" />
								<col class="list-col-categoryname" />
							</colgroup>
							<thead class="gg-list-thead">
								<tr class="gg-list-header">
									<td><span class="gg-inner-block">ID</span></td>
									<td><span class="gg-inner-block">Category</span></td>
								</tr>
							</thead>
							<tbody><tr><td colspan="2"></td></tr></tbody>
						</table>
					</div>
					<div class="gg-listview-list">
						<div class="gg-list-container">
							<table class="gg-list-table widefat fixed category">
								<colgroup>
									<col class="list-col-categoryid" width="50" />
									<col class="list-col-categoryname" />
								</colgroup>
								<thead class="gg-list-thead">
									<tr class="height:0"></tr>
								</thead>
								<tbody id="the-list" class="gg-list-tbody">
									<%@ include file="category_list_result.jsp" %>
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