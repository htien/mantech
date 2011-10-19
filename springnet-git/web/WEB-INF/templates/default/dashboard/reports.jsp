<%@page import="java.util.List"%>
<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="statchart-complaints">
	<div id="statchart-complaints-box" class="gg-postbox">
		<h3>At A Glance</h3>
		<div id="chartswitch">
			<ul>
				<li><a id="stat-1" href="#statdays">Days</a></li>
				<li><a id="stat-7" href="#statweeks">Weeks</a></li>
				<li><a id="stat-31" href="#statmonths">Months</a></li>
				<li><a id="stat-365" href="#statyears">Years</a></li>
			</ul>
			<div id="statdays" class="gg-stat-container">
				<div id="statdays-chart" class="chart"></div>
			</div>
			<div id="statweeks" class="gg-stat-container">
				<div id="statweeks-chart" class="chart"></div>
			</div>
			<div id="statmonths" class="gg-stat-container">
				<div id="statmonths-chart" class="chart"></div>
			</div>
			<div id="statyears" class="gg-stat-container">
				<div id="statyears-chart" class="chart"></div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$('#chartswitch', '#statchart-complaints').tabs();
</script>
<script type="text/javascript">
	var chart,
		xDays = [
	        <%
	        	List<String> xDays = (List<String>)request.getAttribute("listDate");
	        	for (int i = 0; i < xDays.size(); i++) {
	        	  out.print("'" + xDays.get(i) + "'");
	        	  if (i != xDays.size()) {
	        	    out.print(",");
	        	  }
	        	}
	        %>
        ].reverse(),
		yDays = [
       	<%
       		List<Integer> yDays = (List<Integer>)request.getAttribute("list");
       		for (int i : yDays) {
       		  out.print(i);
       		  if (i != yDays.size()) {
       		    out.print(",");
       		  }
       		}
       	%>
        ].reverse();
		
	var colors = Highcharts.getOptions().colors,
		categories = xDays,
		name = "Days",
		totalColumns = '<%=yDays.size()%>',
		data = [];
	for (var i = 0; i < totalColumns; i++) {
		data.push({ y: yDays[i], color: colors[0] });
	}
	function setChart(name, categories, data, color) {
		chart.xAxis[0].setCategories(categories);
		chart.series[0].remove();
		chart.addSeries({
			name: name,
			data: data,
			color: color || 'white'
		});
	}
	
	chart = new Highcharts.Chart({
		chart: {
			renderTo: 'statdays-chart', 
			type: 'column'
		},
		title: {
			text: null
		},
		xAxis: {
			categories: categories
		},
		yAxis: {
			title: {
				text: 'Total complaints'
			}
		},
		plotOptions: {
			column: {
				cursor: 'pointer',					
			}
		},
		tooltip: {
			formatter: function() {
				return this.x + '<br/><strong>Complaints: ' + this.y + '</strong>';
			}
		},
		series: [{
			name: name,
			data: data,
			color: 'white'
		}],
		exporting: {
			enabled: false
		}
	});		
</script>
<!-- <script type="text/javascript"> -->
<!-- 	var chart, -->
<!-- 		cate = [ -->
<%-- 	        <% --%>
<!-- 	        	List<String> sMonth = (List<String>)request.getAttribute("listMonth"); -->
<!-- 	        	for (int i = 0; i < sMonth.size(); i++) { -->
<!-- 	        	  out.print("'" + sMonth.get(i) + "'"); -->
<!-- 	        	  if (i != sMonth.size()) { -->
<!-- 	        	    out.print(","); -->
<!-- 	        	  } -->
<!-- 	        	} -->
<!-- 	        %> -->
<!--         ].reverse(), -->
<!-- 		list = [ -->
<%--        	<% --%>
<!--        		List<Integer> numbers = (List<Integer>)request.getAttribute("list"); -->
<!--        		for (int i : numbers) { -->
<!--        		  out.print(i); -->
<!--        		  if (i != numbers.size()) { -->
<!--        		    out.print(","); -->
<!--        		  } -->
<!--        		} -->
<!--        	%> -->
<!--         ].reverse(); -->
		
<!-- 	var colors = Highcharts.getOptions().colors, -->
<!-- 		categories = cate, -->
<!-- 		name = "Days", -->
<%-- 		totalColumns = '<%=numbers.size()%>', --%>
<!-- 		data = []; -->
<!-- 	for (var i = 0; i < totalColumns; i++) { -->
<!-- 		data.push({ y: list[i], color: colors[0] }); -->
<!-- 	} -->
<!-- 	function setChart(name, categories, data, color) { -->
<!-- 		chart.xAxis[0].setCategories(categories); -->
<!-- 		chart.series[0].remove(); -->
<!-- 		chart.addSeries({ -->
<!-- 			name: name, -->
<!-- 			data: data, -->
<!-- 			color: color || 'white' -->
<!-- 		}); -->
<!-- 	} -->
	
<!-- 	chart = new Highcharts.Chart({ -->
<!-- 		chart: { -->
<!-- 			renderTo: 'statmonths-chart',  -->
<!-- 			type: 'column' -->
<!-- 		}, -->
<!-- 		title: { -->
<!-- 			text: null -->
<!-- 		}, -->
<!-- 		xAxis: { -->
<!-- 			categories: categories -->
<!-- 		}, -->
<!-- 		yAxis: { -->
<!-- 			title: { -->
<!-- 				text: 'Total complaints' -->
<!-- 			} -->
<!-- 		}, -->
<!-- 		plotOptions: { -->
<!-- 			column: { -->
<!-- 				cursor: 'pointer',					 -->
<!-- 			} -->
<!-- 		}, -->
<!-- 		tooltip: { -->
<!-- 			formatter: function() { -->
<!-- 				return this.x + '<br/><strong>Complaints: ' + this.y + '</strong>'; -->
<!-- 			} -->
<!-- 		}, -->
<!-- 		series: [{ -->
<!-- 			name: name, -->
<!-- 			data: data, -->
<!-- 			color: 'white' -->
<!-- 		}], -->
<!-- 		exporting: { -->
<!-- 			enabled: false -->
<!-- 		} -->
<!-- 	}); -->
		
<!-- </script> -->
</compress:html>