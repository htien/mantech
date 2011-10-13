<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure"
	compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="adduser_pagelet" class="g-pl">
	<div id="adduser-box" class="box wrap">
		<h2>Add New User</h2>
		<form id="adduser-form" class="g-f" method="post" action="/user/addSave">
			<div>
				<div class="row">
					<label>
						<strong>User Name: </strong>
						<input type="text" name="username" />
					</label>
				</div>
				<div class="row">
					<label>
						<strong>Password: </strong>
						<input type="password" name="passwd" />
					</label>
				</div>
				<div class="row">
					<label>
						<strong>Email: </strong>
						<input type="text" name="email" />
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
						<input type="text" name="firstName" />
					</label>
				</div>
				<div class="row">
					<label>
						<strong>Last Name: </strong>
						<input type="text" name="lastName" />
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
						<input type="text" name="address" />
					</label>
				</div>
			</div>
			<div>
				<div id="btnAdd" class="g-b g-b-r">Add new user</div>
				<div id="btnReset" class="g-b g-b-b">Reset</div>
			</div>
		</form>
	</div>
</div>

</compress:html>