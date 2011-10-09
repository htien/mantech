<style type="text/css">
	.grid {margin-top: 15px; border: 1px solid #000; border-collapse: collapse;}
	.grid th, .grid td {border: 1px solid #000; border-collapse: collapse}
</style>
<h2>Details</h2>
<div>
	<form>
		<table class="gg-list-table users grid">
			<thead><tr><th>Assignment Detail Id</th><th>Complaint Id</th><th>Complete Date</th><th>Username</th></tr></thead>
			<tfoot><tr><th>Assignment Detail Id</th><th>Complaint Id</th><th>Complete Date</th><th>Username</th></tr></tfoot>
			<tbody>
				<c:forEach items="${details}" var="d">
					<tr>
						<td>${d.id}</td>
						<td>${d.assignment.complaintId}</td>
						<td>${d.completeDate}</td>
						<td>${d.user.username}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</div>