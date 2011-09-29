<%@ include file="../layout/header.inc"%>
<compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<style type="text/css">

#main { border:1px solid #000; }
#add-form { margin:20px 20px; }
#title { font-weight:bold; font-size:20px; text-align:center; margin-top:10px; }
.row { margin-bottom:12px; }
.row strong { display:inline-block; vertical-lign:top; margin-top:4px; width:90px; font-weight:bold; }
/* .row input[type=text] { margin-right:10px; } */

</style>

<script type="text/javascript">
var frm;

var dialogOpts = {
	title: "Create User Confirm",
	modal: true,
	resizable: false,
	width: 350,
	height: 'auto',
	buttons: {
		'Create': function() {
			if (frm.valid()) {
				submit(this, frm);
			}
		},
		'Cancel': function() {
			$(this).dialog("destroy");
		}
	}
};

var validOpts = {
	rules: {
		username: { required:true, minlength:3, maxlength:16 },
		passwd: { required:true, minlength:6 },
		email: { required:true, email:true },
		firstName: { required:true, minlength:3, maxlength:30 },
		lastName: { required:true, minlength:3, maxlength:30 },
		address: { required:true, minlength:3, maxlength:200 }
	},
	messages: {
		username: {
			required: 'Required field',
			minlength: 'Required 3 to 16 character',
			maxlength: 'Required 3 to 16 character'
		},
		passwd: {
			required: 'Required field.',
			minlength: 'Require at least 6 characters'
		},
		email: {
			required:'Required field',
			email:'eg, abc@cba.com'
		},
		firstName: {
			required:'Required field.',
			minlength:'Require 3 to 30 characters',
			maxlength:'Require 3 to 30 characters'
		},
		lastName: {
			required:'Required field.',
			minlength:'Require 3 to 30 characters',
			maxlength:'Require 3 to 30 characters'
		},
		address: {
			required:'Required field.',
			minlength:'Require 3 to 200 characters',
			maxlength:'Require 3 to 200 characters'
		}
	},
	highlight: function(el, errorClass, validClass) {
		$(el).addClass(errorClass).removeClass(validClass);
	},
	unhighlight: function(el, errorClass, validClass) {
		$(el).addClass(validClass).removeClass(errorClass);
	},
	submitHandler: function() {}
};

function submit(dialog, form) {
	$.ajax({
		async: false,
		type: form.attr('method'),
		url: form.attr('action'),
		data: form.serialize(),
		success: function(data, textCode, xhr) {
			$('#msg').html(xhr.responseText);
			$("form :input[type=text]").val(""); 
			$(dialog).dialog("destroy");
		},
		error: function(data) {
			$(dialog).dialog('close');
		}
	});
}

$(function() {
	$('#btnAdd').live('click', function() {
		frm = $("#add-form");
		frm.validate(validOpts);
		if (frm.valid()) {
			$('#dialog-confirm').dialog(dialogOpts);
			$('#dialog-confirm').dialog("open");
		}
	});
	
	$('#btnReset').live('click', function() {
		frm = $("#addform");
		$("form :input[type=text]").val("");
	});

});
</script>

<div id="main">
	<h2 id="title">Add New User</h2>
	<form id="add-form" method="post" action="/user/addSave">
		<p id="msg"></p>				
		<div>
			<div class="row">
				<label>
					<strong>User Name: </strong>
					<input type="text" name="username" class="ui-widget-content"/>
				</label>
			</div>
			<div class="row">
				<label>
					<strong>Password: </strong>
					<input type="text" name="passwd" class="ui-widget-content"/>
				</label>
			</div>
			<div class="row">
				<label>
					<strong>Email: </strong>
					<input type="text" name="email" class="ui-widget-content"/>
				</label>
			</div>
			<div class="row">
				<label>
					<strong>Department: </strong>
					<select name="department">
						<c:forEach items="${departList}" var="depart">
							<option value="${depart.id}">${depart.name}</option>
						</c:forEach>
					</select>
				</label>
			</div>
			<div class="row">
				<label>
					<strong>Role: </strong>
					<select name="role">
						<c:forEach items="${roleList}" var="role">
							<option value="${role.id}">${role.name}</option>
						</c:forEach>
					</select>
				</label>
			</div>
			<div class="row">
				<label>
					<strong>First Name: </strong>
					<input type="text" name="firstName" class="ui-widget-content"/>
				</label>
			</div>
			<div class="row">
				<label>
					<strong>Last Name: </strong>
					<input type="text" name="lastName" class="ui-widget-content"/>
				</label>
			</div>
			<div class="row">
				<label>
					<strong>Gender: </strong>
					<select name="gender">
						<option value="M">Male</option>
						<option value="F">Female</option>
					</select>
				</label>						
			</div>
			<div class="row">
				<label>
					<strong>Address: </strong>
					<input type="text" name="address" class="ui-widget-content"/>
				</label>
			</div>
		</div>
		<div id="btnAdd" class="g-b g-b-b">Add new user</div>
		<div id="btnReset" class="g-b g-b-r">Reset</div>
	</form>
</div>
<div id="dialog-confirm" style="display: none;">Are you sure ?</div>

</compress:html>
<%@ include file="../layout/footer.inc"%>