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
				This feature will be released in version 2.0.<br />
				Comming soon...
				<div id="statyears-chart" class="chart"></div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	var colors = Highcharts.getOptions().colors,
		daysChart, monthsChart, weeksChart,
		daysStatName = "Days", monthsStatName = "Months", weeksStatName = "Weeks",
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
        ].reverse(),
		totalDays= '<%=yDays.size()%>',
		daysData = [];

	for (var i = 0; i < totalDays; i++) {
		daysData.push({ y: yDays[i], color: colors[0] });
	}

	daysChart = new Highcharts.Chart({
		chart: {
			renderTo: 'statdays-chart', 
			type: 'column'
		},
		title: {
			text: null
		},
		xAxis: {
			categories: xDays
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
			name: daysStatName,
			data: daysData,
			color: 'white'
		}],
		exporting: {
			enabled: false
		}
	});

	function setChart(name, categories, data, color) {
		chart.xAxis[0].setCategories(categories);
		chart.series[0].remove();
		chart.addSeries({
			name: name,
			data: data,
			color: color || 'white'
		});
	}
	
	var xMonths = [
        <%
        	String[] monthNames = {
				"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
			};
        	List<Integer> xMonths = (List<Integer>)request.getAttribute("listMonth");
        	for (int i = 0; i < xMonths.size(); i++) {
        	  out.print("'" + monthNames[i] + "'");
        	  if (i != xMonths.size()) {
        	    out.print(",");
        	  }
        	}
        %>
       ],
       yMonths = [
      	<%
     		List<Integer> yMonths = (List<Integer>)request.getAttribute("listInMonth");
       		for (int i : yMonths) {
       		  out.print(i);
       		  if (i != yMonths.size()) {
       		    out.print(",");
       		  }
       		}
      	%>
       ];
	totalMonths = '<%=yMonths.size()%>',
	monthsData = [];

for (var i = 0; i < totalMonths; i++) {
	monthsData.push({ y: yMonths[i], color: colors[0] });
}

monthsChart = new Highcharts.Chart({
	chart: {
		renderTo: 'statmonths-chart', 
		type: 'column'
	},
	title: {
		text: null
	},
	xAxis: {
		categories: xMonths
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
		name: monthsStatName,
		data: monthsData,
		color: 'white'
	}],
	exporting: {
		enabled: false
	}
});

var xWeeks = [
<%
   	List<Integer> xWeeks = (List<Integer>)request.getAttribute("listWeeks");
   	for (int i = 0; i < xWeeks.size(); i++) {
   	  out.print(xWeeks.get(i));
   	  if (i != xWeeks.size()) {
   	    out.print(",");
   	  }
   	}
%>
].reverse(),
yWeeks = [
<%
List<Integer> yWeeks = (List<Integer>)request.getAttribute("listComplaintsInWeek");
		for (int i : yWeeks) {
		  out.print(i);
		  if (i != yWeeks.size()) {
		    out.print(",");
		  }
		}
 %>
   ].reverse();
totalWeeks = '<%=yWeeks.size()%>',
	weeksData = [];

for (var i = 0; i < totalWeeks; i++) {
 weeksData.push({ y: yWeeks[i], color: colors[0] });
}

weeksChart = new Highcharts.Chart({
	chart: {
		renderTo: 'statweeks-chart', 
		type: 'column'
	},
	title: {
		text: null
	},
	xAxis: {
		categories: xWeeks
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
			return 'Week ' + this.x + '<br/><strong>Complaints: ' + this.y + '</strong>';
		}
	},
	series: [{
		name: weeksStatName,
		data: weeksData,
		color: 'white'
	}],
	exporting: {
		enabled: false
	}
});
          
</script>

<script type="text/javascript">
	$('#chartswitch', '#statchart-complaints').tabs();
</script>

</compress:html>