<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div class="wrap">
	<h2>Dashboard</h2>
	<div id="dashboard-widgets-wrap">
		<div id="dashboard-widgets" class="gg-metabox-holder">
			<div class="gg-postbox-container" style="width:49%">
				<div class="gg-metabox-sortables">
					<div id="dashboard_right_now" class="gg-postbox">
						<div class="gg-handlediv"></div>
						<h3 class="gg-title">Right Now</h3>
						<div class="gg-inside">
							This is right now.
						</div>
					</div>
					<div id="dashboard_specialthanks" class="gg-postbox">
						<div class="gg-handlediv"></div>
						<h3 class="gg-title">Special Thanks</h3>
						<div class="gg-inside">
							<p>Open Source.</p>
						</div>
					</div>
				</div>
			</div>
			<div class="gg-postbox-container" style="width:49%">
				<div class="gg-metabox-sortables">
					<div id="dashboard_stats" class="gg-postbox">
						<div class="gg-handlediv"></div>
						<h3 class="gg-title">Stats</h3>
						<div class="gg-inside">
							<div id="container"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</div>
<script>startChart();</script>

</compress:html>