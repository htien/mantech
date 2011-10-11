<%@ include file="layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">
<%@ include file="layout/header.inc" %>
<%@ include file="layout/gg_globalcontainer_top.inc"%>

	<div id="ggcontent">
		<div id="gghead">
			<h2 class="site-heading"><jtien:settings key="author"/></h2>
		</div>
		<div id="ggbody">
			<div id="ggbody-content">
				<%@ include file="includes/springnet_info.inc"%>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>

<%@ include file="layout/gg_globalcontainer_bottom.inc"%>
<%@ include file="layout/footer.inc" %>
</compress:html>