<%@ include file="../layout/top.inc"%><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div class="wrap">
	<h2>Dashboard</h2>
	<div id="dashboard-widgets-wrap">
		<div id="dashboard-widgets" class="gg-metabox-holder">
			<div class="gg-postbox-container" style="width: 49%">
				<div class="gg-metabox-sortables">
					<div id="dashboard_right_now" class="gg-postbox">
						<div class="gg-handlediv"></div>
						<h3 class="gg-title">Right Now</h3>
						<div class="gg-inside">
							<div class="table table_summary">
								<p class="sub">Summary</p>
								<table>
									<tbody>
										<tr class="first">
											<td class="first b"><a href="javascript:">0</a>
											</td>
											<td class="t">Users</td>
										</tr>
										<tr>
											<td class="first b"><a href="javascript:">0</a>
											</td>
											<td class="t">Categories</td>
										</tr>
										<tr>
											<td class="first b"><a href="javascript:">0</a>
											</td>
											<td class="t">Equipments</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="table table_complaints">
								<p class="sub">Complaint Summary</p>
								<table>
									<tbody>
										<tr class="first">
											<td class="first b"><a href="javascript:">0</a>
											</td>
											<td class="t">Complaints</td>
										</tr>
										<tr class="first">
											<td class="first b"><a href="javascript:">0</a>
											</td>
											<td class="t">Assignments</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="version">
								<p>
									Theme <a><strong>SpringNet</strong>
									</a> is combine Google+ and Wordpress skin.<br /> Designed by T.
								</p>
							</div>
						</div>
					</div>
					<div id="dashboard_complaint_stats" class="gg-postbox">
						<div class="gg-handlediv"></div>
						<h3 class="gg-title">Complaint Summary</h3>
						<div class="gg-inside box">
							<table class="grid">
								<tbody>
									<tr>
										<td class="label">Complaints today</td>
										<td class="n">0</td>
									</tr>
									<tr>
										<td class="label">Complaints yesterday</td>
										<td class="n">0</td>
									</tr>
									<tr>
										<td class="label">Complaints last month</td>
										<td class="n">0</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div id="dashboard_specialthanks" class="gg-postbox">
						<div class="gg-handlediv"></div>
						<h3 class="gg-title">Special Thanks</h3>
						<div class="gg-inside">
							<ol>
								<li>Google</li>
								<li>Github</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
			<div class="gg-postbox-container" style="width: 49%">
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