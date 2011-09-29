<%@ include file="../layout/header.inc"%>
<%@ include file="../layout/top.inc"%>
<compress:html jsCompressor="closure" compressJavaScript="true"
	compressCss="true" removeIntertagSpaces="true">

<!-- 	<style> -->
<!-- 		.grid {border: 1px solid #000; border-collapse: collapse;} -->
<!-- 		.grid th, .grid td {border: 1px solid #000; border-collapse: collapse; padding: 1px 2px;} -->
<!-- 		.grid .row:hover {background-color: #eee; cursor: pointer;} -->
<!-- 	</style> -->

	<style type = "text/css">
		#main {border: 1px solid #000; height: 300px}
		#add-form { margin:20px 20px; }
		#title { font-weight:bold; font-size:20px; text-align:center; margin-top:10px; }
		#form { float: left; margin-top: 20px}
		#details { margin: 20px 450px; }
		#details h2 {text-align: center; font-style: italic;}
		#details .row strong {margin-top: 0; }
		.row { margin-bottom:12px; }
		.row strong { display:inline-block; margin-top:4px; width:90px; vertical-align:top; font-weight:bold; }
	</style>
	
	<script type="text/javascript">
		var frm;
		var dialogOpts = {
			modal: true,
			resizable: false,
			title: "New Assignment",
			width: 350,
			buttons: {
				'Create': function() {
					Submit(this, frm);
					$(this).dialog("destroy");
				},
				'Cancel': function() {
					$(this).dialog("destroy");
				}
			}
		};
		var validOpts = {
			rules: {
				beginDate: "required",
				duration: {
					required: true
				},
				userId: "required"
			},
			messages: {
				beginDate: "Please enter the begin Date!",
				duration: "Please enter the duration!",
				userId: "Please choose the technician to assign!"
			}
		};
		
		function Submit(dialog, form) {
			$.ajax( {
				async: false,
				type: form.attr("method"),
				url: form.attr("action"),
				data: form.serialize(),
				success: function(data, textCode, xhr) {
					Reset();
					$(dialog).dialog("destroy");
					
				},
				error: function(data) {
					$(dialog).dialog("destroy");
				}
			});
		};
		
		function Reset() {
			$("#form :input[type=text]").val("");
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
				Reset();
			});
		});
	</script>
	
	<div id="main">
		<h1 id="title">Insert new assignment</h1>
		<div id="form">
			<form method="post" action="/assignment/addSave" id="add-form">
				<div class="row">
					<label>
						<strong>Begin Date: </strong>
						<input type="text" name="beginDate"/>
					</label>
				</div>
				<div class="row">
					<label>
						<strong>Duration: </strong>
						<input type="text" name="duration"/>
					</label>
				</div>
				<div class="row">
					<label>
						<strong></strong>
					</label>
				</div>
				<div class="row">
					<label>
						<strong>User Name</strong>
						<select name="userId" multiple="multiple">
							<option value="3">A</option>
							<option value="5">B</option>
						</select>		
					</label>
				</div>
				<input type="hidden" name="compId" value="${compId}" />
				
				<div id="btnAdd" class="g-b g-b-b">Add new assignment</div>
				<div id="btnReset" class="g-b g-b-r">Reset</div>
			</form>
		</div>
		
		<div id="details">
			<h2>Complaint Details:</h2>
			<div class="row">
				<label>
					<strong>Id: </strong>
					${complaint.id}
				</label>
			</div>
			<div class="row">
				<label>
					<strong>Employee Name: </strong>
					${complaint.user.firstName}
				</label>
			</div>
			<div class="row">
				<label>
					<strong>Status: </strong>
					${complaint.status.name}
				</label>
			</div>
			<div class="row">
				<label>
					<strong>Title: </strong>
					${complaint.title}
				</label>
			</div>
			<div class="row">
				<label>
					<strong>Content: </strong>
					${complaint.content}
				</label>
			</div>
			<div class="row">
				<label>
					<strong>Prority: </strong>
					${complaint.priority.name}
				</label>
			</div>
			<div class="row">
				<label>
					<strong>CreateDate: </strong>
					${complaint.createDate}
				</label>
			</div>
		</div>
		<div id="dialog-confirm" style="display:none;">Are You Sure!</div>
	</div>
	
<!-- 		<table class="grid"> -->
<!-- 			<tr> -->
<!-- 				<th colspan="8">List of complaint</th> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<th>Id</th> -->
<!-- 				<th>Employee Id</th> -->
<!-- 				<th>Employee Name</th> -->
<!-- 				<th>Status</th> -->
<!-- 				<th>Title</th> -->
<!-- 				<th>Content</th> -->
<!-- 				<th>Priority</th> -->
<!-- 				<th>Create Date</th> -->
<!-- 			</tr> -->
<%-- 			<c:forEach items="${listComplaint}" var="l"> --%>
<!-- 				<tr class="row"> -->
<%-- 					<td>${l.id}</td> --%>
<%-- 					<td>${l.user.id}</td> --%>
<%-- 					<td>${l.user.firstName}</td> --%>
<%-- 					<td>${l.status.name}</td> --%>
<%-- 					<td>${l.title}</td> --%>
<%-- 					<td>${l.content}</td> --%>
<%-- 					<td>${l.priority.name}</td> --%>
<%-- 					<td>${l.createDate}</td> --%>
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
<!-- 		</table> -->
	
</compress:html>
<%@ include file="../layout/footer.inc"%>