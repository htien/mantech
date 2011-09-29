<%@ include file="../layout/header.inc"%><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">
<a class="ajax" href="http://google.com.vn">Open Dialog</a>
<div id="dialog"></div>

<script>

$('a.ajax').click(function() {
	var url = this.href;
	$('#dialog').load(url, function(respText) {
		$(this).html(respText);
	});
	
	return false;
});

</script>

</compress:html>
<%@ include file="../layout/footer.inc"%>