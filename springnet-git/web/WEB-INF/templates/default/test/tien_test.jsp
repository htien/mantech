<%@ include file="../layout/header.inc"%><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">
<a class="ajax" href="http://localhost:8080/springnet/_/css/reset.css">Open Dialog</a>
<a class="ajax" href="http://kernel.org/">Open Dialog 2</a>
<div id="dialog" style="width:600px; height:500px">Abc</div>

<script>

$('a.ajax').each(function(idx, el) {
	$(el).click(function() {
		var url = this.href;
		$.get(url, {type:'html'}, function(data) {
			$('#dialog').html(data);
		});
		$('#dialog').dialog({ modal:true });
		return false;
	});
});

</script>

</compress:html>
<%@ include file="../layout/footer.inc"%>