<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure"
	compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="edituser_pagelet" class="g-pl">
	<div id="edituser-box" class="wrap">
		<h2>Edit Existing User</h2>
		<form id="edituser-form" class="g-f" method="post" action="/user/editSave">
			<input type="hidden" name="id" value="${user.id}" />
			<div id="user-edit" class="box">
				<p>Modify a Mantech user account. Fill full information.</p>
				<table class="grid">
					<tbody>
						<tr>
							<td class="label">User ID:</td>
							<td class="t"><span>${user.id}</span></td>
						</tr>
						<tr>
							<td class="label">Username:</td>
							<td class="t"><span>${user.username}</span></td>
						</tr>
						<tr>
							<td class="label">Email address:</td>
							<td><input type="text" name="email" value="${user.email}" /></td>
						</tr>
						<tr>
							<td class="label">Department:</td>
							<td>
								<select name="department">
									<c:forEach items="${departList}" var="depart">
										<c:set var="isSelected">
											<c:if test="${depart.id == user.department.id}">selected="selected"</c:if>
										</c:set>
										<option value="${depart.id}" ${isSelected}>${depart.name}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class="label">Role:</td>
							<td>
								<select name="role">
									<c:forEach items="${roleList}" var="role">
										<c:set var="isSelected">
											<c:if test="${role.id == user.role.id}">selected="selected"</c:if>
										</c:set>
										<option value="${role.id}" ${isSelected}>${role.name}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class="label">Real name:</td>
							<td class="t"><span>${user.firstName} ${user.lastName}</span></td>
						</tr>
						<tr>
							<td class="label">Gender:</td>
							<td class="t">
								<span>
									<c:if test="${user.gender.equals('M')}">Male</c:if>
									<c:if test="${user.gender.equals('F')}">Female</c:if>
								</span>
							</td>
						</tr>
						<tr>
							<td class="label">Home address:</td>
							<td><input type="text" name="address" value="${user.homeAddress}" /></td>
						</tr>
					</tbody>
				</table>
				<div class="buttons">
					<div id="btnEdit" class="g-b g-b-r">Save information</div>
				</div>
			</div>
		</form>
	</div>
</div>

</compress:html>