<%@ include file="../../layout/top.inc"%>

<div id="edituser_pagelet" class="g-pl">
	<div id="edituser-box" class="box">
		<h2 class="title">Edit User</h2>
		<form id="edituser-form" class="g-f" method="post" action="/user/editSave">
			<div>
				<div class="row">
					<label>
						<strong>User Id: </strong>
						<span>${user.id}</span>
						<input type="hidden" name="id" value="${user.id}"/>
					</label>
				</div>
				<div class="row">
					<label>
						<strong>User Name: </strong>
						<span>${user.username}</span>
					</label>
				</div>
				<div class="row">
					<label>
						<strong>Email: </strong>
						<input type="text" name="email" value="${user.email}" />
					</label>
				</div>
				<div class="row">
					<label>
						<strong>Department: </strong>
						<select name="department">
							<c:forEach items="${departList}" var="depart">
								<c:set var="isSelected">
									<c:if test="${depart.id == user.department.id}">selected="selected"</c:if>
								</c:set>
								<option value="${depart.id}" ${isSelected}>${depart.name}</option>
							</c:forEach>
						</select>
					</label>
				</div>
				<div class="row">
					<label>
						<strong>Role: </strong>
						<select name="role">
							<c:forEach items="${roleList}" var="role">
								<c:set var="isSelected">
									<c:if test="${role.id == user.role.id}">selected="selected"</c:if>
								</c:set>
								<option value="${role.id}" ${isSelected}>${role.name}</option>
							</c:forEach>
						</select>
					</label>
				</div>
				<div class="row">
					<label>
						<strong>First Name: </strong>
						<span>${user.firstName}</span>
					</label>
				</div>
				<div class="row">
					<label>
						<strong>Last Name: </strong>
						<span>${user.lastName}</span>
					</label>
				</div>
				<div class="row">
					<label>
						<strong>Gender: </strong>
						<span><c:if test="${user.gender.equals('M')}">Male</c:if><c:if test="${user.gender.equals('F')}">Female</c:if></span>
					</label>						
				</div>
				<div class="row">
					<label>
						<strong>Address: </strong>
						<input type="text" name="address" value="${user.homeAddress}"/>
					</label>
				</div>
			</div>
			<div>
				<div id="btnEdit" class="g-b g-b-r">Save</div>
			</div>
		</form>
	</div>
</div>