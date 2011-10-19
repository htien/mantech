<%@ include file="../layout/top.inc"%><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">


<div class="wrap">
	<h2>Credits</h2>
	<p>Hi, please donate $:)</p>
</div>

<!-- ********************************* -->

<div id="report">
	<div>
		<label>Total complaints of this year: </label> <strong>${currentYear}</strong>
		<table>
			<tr>
				<th><strong>Education System</strong></th>
				<th><strong>Management System</strong></th>
				<th><strong>Learning System</strong></th>
				<th><strong>Internal System</strong></th>
				<th><strong>Human System</strong></th>
			</tr>
			<tr>
				<td>${currentYearByEducation}</td>
				<td>${currentYearByManagement}</td>
				<td>${currentYearByLearning}</td>
				<td>${currentYearByInternal}</td>
				<td>${currentYearByHuman}</td>
			</tr>
		</table>
	</div>
	<div>
		<label>Total complaints of this month: </label> <strong>${currentMonth}</strong>
		<table>
			<tr>
				<th><strong>Education System</strong></th>
				<th><strong>Management System</strong></th>
				<th><strong>Learning System</strong></th>
				<th><strong>Internal System</strong></th>
				<th><strong>Human System</strong></th>
			</tr>
			<tr>
				<td>${currentMonthByEducation}</td>
				<td>${currentMonthByManagement}</td>
				<td>${currentMonthByLearning}</td>
				<td>${currentMonthByInternal}</td>
				<td>${currentMonthByHuman}</td>
			</tr>
		</table>
	</div>
	<div>
		<div>
			<h2>All complaint in current year by department:</h2>
		</div>
		<div>
			<table>
				<tr>
					<th colspan="7"><strong>Education</strong></th>
				</tr>
				<tr>
					<th><strong>ID</strong></th>
					<th><strong>Title</strong></th>
					<th><strong>Employee</strong></th>
					<th><strong>Equipment</strong></th>
					<th><strong>Priority</strong></th>
					<th><strong>End Date</strong></th>
					<th><strong>Status</strong></th>
				</tr>
				<c:forEach items="${listCurrentYearByEducation}" var="edu">
					<tr>
						<td>${edu.id}</td>
						<td><strong>${edu.title}</strong></td>
						<td>${edu.user.username}</td>
						<td>${edu.equipment.name}</td>
						<td>${edu.priority.name}</td>
						<td><fmt:formatDate value="${edu.endDate}"
								pattern="${dateFormat}" />
						</td>
						<td><fmt:formatDate value="${edu.createDate}"
								pattern="${dateFormat}" /><br />
						<strong style="color: red">${edu.status.name}</strong>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>

<hr>
<div>
	<c:forEach items="${list}" var="l">${l}, </c:forEach><br/>
</div>

<!-- ***************** -->

<style>
	#container: {width: 800px; height: 500px; margin: 0 auto;}
</style>

<script type="text/javascript">
	var chart;
	$(function() {
		chart = new Highcharts.Chart({
			chart: {
				renderTo: 'container',
				type: 'column'
			},
			title: {
				text: 'Fruit Consumption'
			},
			xAxis: {
				categories: ['Apples', 'Bananas', 'Oranges']
			},
			yAxis: {
				title: {
					text: 'Fruit eaten'
				}
			},
			series: [{
				name: 'Jane',
				data: [1, 0, 4]
			},{
				name: 'Jone',
				data: [5, 7, 3]
			}]
		});
	});
</script>

<div id="container"></div>

</compress:html>