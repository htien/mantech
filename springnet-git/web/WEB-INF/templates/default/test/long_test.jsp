<%@ include file="../layout/top.inc"%><%@ include file="../layout/header.inc"%><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<script>
$(function() {
	$('#btn').click(function() {
		$.ajax({
			type: 'get',
			url: $ctx + '/long.php',
			dataType: 'json',
			success: function(json) {
				$('#username').html(json.username);
			}
		});
	});
});
</script>

<input type="button" id="btn" value="Get User" />

<jtien:i18n key="LongTest.username" /><span id="username"></span><br />
<jtien:url address="/long"/><br />
<jtien:settings key="author"/><br />
<jtien:templateResource item="/default/common.js"/>

</compress:html>
<%@ include file="../layout/footer.inc"%>