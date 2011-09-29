<%@ include file="../layout/header.inc"%>
<compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<style type = "text/css">
	#main {border: 1px solid #000; }
	#add-form { margin:20px 20px; }
	#title { font-weight:bold; font-size:20px; text-align:center; margin-top:10px; }
	.row { margin-bottom:12px; }
	.row strong { display:inline-block; margin-top:4px; width:90px; vertical-align:top; font-weight:bold; }
</style>

<script type = "text/javascript">
	var frm;
	
	var dialogOpts = {
		title: "New Complaint",
		modal: true,
		resizable: false,
		width: 350, // height: auto -> default
		buttons: {
			'Create': function() {
				submit(this, frm);
				$(this).dialog("destroy");
			},
			'Cancel': function() {
				$(this).dialog("destroy");
			}
		}
	};
	
	var validOpts = {
		rules: {
			title: {required: true},
			content: {required: true}
		},
		messages: {
			title: "required field",
			wysiwyg: "required field"
		},
		submitHandler: function() {}
	};
	
	function submit(dialog, form) {
		$.ajax( {
			async: false,
			type: form.attr('method'),
			url: form.attr('action'),
			data: form.serialize(),
			success: function(data, textCode, xhr) {
				reset();
				$(dialog).dialog("destroy");
			},
			error: function(data) {
				$(dialog).dialog("destroy");
			}
		});
	};
	
	function reset() {
		$("form :input[type=text]").val("");
	};
	
	$(function() {
		$("#btnAdd").live('click', function() {
			frm = $("#add-form");
			frm.validate(validOpts);
			if(frm.valid()) {
				$("#dialog-confirm").dialog(dialogOpts);
				$("#dialog-confirm").dialog("open");
			}
		});
		$("#btnReset").live('click', function() {
			frm = $("#add-form");
			reset();
		});
		
		//----------------------------Editor--------------------------
				
	});
	
	
	
	
</script>

<div id="main">
	<h1 id="title">Insert New Complaint</h1>
	<form id="add-form" method="post" action="/complaint/addSave">
		<div>
			<div class = "row">
				<label><strong>${user.firstName} ${user.lastName}</strong></label>
			</div>
			<div class="row">
				<label>
					<strong>Equipment: </strong>	
					<select name="equipId">
						<c:forEach items="${list}" var="equip">
							<option value="${equip.id}">${equip.name}</option>
						</c:forEach>
					</select>			
				</label>
			</div>
			<div class="row">
				<label>
					<strong>Title: </strong>
					<input type="text" name="title"/>
				</label>
			</div>
			<div class="row">
				<strong>Content: </strong>
				<textarea rows="5" cols="103" name="content" id="content"></textarea>
			</div>
		</div>
		<div id="btnAdd" class="g-b g-b-b">Add new complaint</div>
		<div id="btnReset" class="g-b g-b-r">Reset</div>
	</form>
	<div id="dialog-confirm" style="display:none;">Are You Sure!</div>
</div>
</compress:html>
<%@ include file="../layout/footer.inc"%>