<%@ include file="layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">
<%@ include file="layout/header.inc" %>

<%@ include file="includes/bluebar.inc"%>
<div id="pagelet_signin">
	<div id="signin-box">
		<h2><jtien:i18n key="Login.admin" /></h2>
		<form id="signin-form" class="off" action="/ssoAuthenticate" method="post">
			<div>
				<label title="<jtien:i18n key='Login.id.tip' />">
					<strong class="id-label"><jtien:i18n key="Login.id" /></strong>
					<input type="text" id="id" class="g-t" name="id" value="${id}" />
				</label>
				<label title="<jtien:i18n key='Login.passwd.tip' />">
					<strong class="passwd-label"><jtien:i18n key="Login.passwd" /></strong>
					<input type="password" id="passwd" class="g-t" name="passwd" />
				</label>
			</div>
			<div>
				<div id="signin" class="g-b g-b-r"><jtien:i18n key="Login.btnSignin" /></div>
				<a id="info" class="g-b g-b-b" href="<jtien:settings key="context.path"/>/?p=info">?</a>
			</div>
			<p></p>
			<%--<div id="testZone">
				<div>
					<div id="test1" class="g-b g-b-r">Closure Dialog</div>
					<div id="test2" class="g-b g-b-r" style="margin-right:0">JQuery Dialog</div>
				</div>
				<div>
					<div id="reset" class="g-b g-b-r">Reset Form</div>
				</div>
			</div>--%>
		</form>
	</div>
</div>

<%@ include file="layout/footer.inc" %>
</compress:html>