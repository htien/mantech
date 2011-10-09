<style type="text/css">
	.grid {margin-top: 15px; border: 1px solid #000; border-collapse: collapse;}
	.grid th, .grid td {border: 1px solid #000; border-collapse: collapse}
</style>

<div id="assignment_list_pagelet" class="g-pl">
	<form id="assignment-filter-form">
		<table class="gg-list-table users grid">
			<thead><tr><th>Complaint Id</th><th>Begin Date</th><th>Duration</th><th>Create Date</th><th>isDeleted</th><th>Details</th></tr></thead>
			<tfoot><tr><th>Complaint Id</th><th>Begin Date</th><th>Duration</th><th>Create Date</th><th>isDeleted</th><th>Details</th></tr></tfoot>
			<tbody id="the-list">
				<%@include file="assignment_list_result.jsp" %>
			</tbody>
		</table>
	</form>
</div>