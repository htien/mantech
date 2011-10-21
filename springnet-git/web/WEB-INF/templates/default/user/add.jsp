<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="pagelet_adduser" class="g-pl">
	<div id="adduser-box" class="wrap">
		<h2>Create a Mantech account</h2>
		<form id="adduser-form" class="g-f" method="post" action="/user/addSave">
			<div id="user-new" class="box">
				<p>Create a new user account. All information is required.</p>
				<table class="grid">
					<tbody>
						<tr>
							<td class="label">Username:</td>
							<td><input type="text" name="username" /></td>
						</tr>
						<tr>
							<td class="label">Create a password:</td>
							<td><input type="password" id="password" name="passwd" /></td>
						</tr>
						<tr>
							<td class="label">Retype password:</td>
							<td><input type="password" name="confirm_passwd" /></td>
						</tr>
						<tr>
							<td class="label">Email address:</td>
							<td><input type="text" name="email" /></td>
						</tr>
						<tr>
							<td class="label">Department:</td>
							<td>
								<select name="department">
									<c:forEach items="${departList}" var="depart">
										<option value="${depart.id}">${depart.name}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class="label">Role:</td>
							<td>
								<select name="role">
									<c:forEach items="${roleList}" var="role">
										<option value="${role.id}">${role.name}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class="label">First name:</td>
							<td><input type="text" name="firstName" /></td>
						</tr>
						<tr>
							<td class="label">Last name:</td>
							<td><input type="text" name="lastName" /></td>
						</tr>
						<tr class="gender">
							<td class="label">Gender:</td>
							<td>
								<label><input type="radio" name="gender" value="M" />Male</label>
								<label><input type="radio" name="gender" value="F" />Female</label>
							</td>
						</tr>
						<tr>
							<td class="label">Address:</td>
							<td><input type="text" name="address" /></td>
						</tr>
					</tbody>
				</table>
				<div class="buttons">
					<div id="btnAdd" class="g-b g-b-r">Add new user</div>
					<div id="btnReset" class="g-b g-b-b">Reset</div>
				</div>
			</div>
		</form>
	</div>
</div>

</compress:html>