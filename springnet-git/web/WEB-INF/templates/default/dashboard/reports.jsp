<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="statchart-complaints">
	<div id="statchart-complaints-box" class="gg-postbox">
		<h3>At A Glance</h3>
		<div id="chartswitch">
			<ul>
				<li><a id="stat-1" href="#statdays">Days</a></li>
				<li><a id="stat-7" href="#statweeks">Weeks</a></li>
				<li><a id="stat-31" href="#statmonths">Months</a></li>
				<li><a href="#">Years</a></li>
			</ul>
			<div id="statdays" class="gg-stat-container">Chart 1
			</div>
			<div id="statweeks" class="gg-stat-container">Chart 2
			</div>
			<div id="statmonths" class="gg-stat-container">Chart 3
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$('#chartswitch', '#statchart-complaints').tabs();
</script>

</compress:html>