<%@ include file="top.inc"%>

<script type="text/javascript">$('body').addClass('gg-admin');</script>
<div id="globalTop" class="fixed_elem">
	<div id="ggadminbar">
		<div class="quicklinks">
			<div id="ggadminbar-left">
				<ul>
					<li id="gg-adminbar-role" class="gg-link-top">
						<a class="ggl sel">
							<span class="gglb"></span>
							<span class="ggls">${userSession.user.role.name}</span>
						</a>
					</li>
					<li id="gg-adminbar-about" class="gg-link-top">
						<a class="ggl" href="<jtien:url address="/"/>?p=info">
							<span class="gglb"></span>
							<span class="ggls">About</span>
						</a>
					</li>
				</ul>
			</div>
			<div id="ggadminbar-right">
				<ul>
					<li id="gg-adminbar-account" class="gg-link-top gg-menupop">
						<a id="lnkAccount" class="ggl" href="javascript:">
							<span class="gglb"></span>
							<span class="ggls">
								${userSession.user.firstName} ${userSession.user.lastName}
								<c:if test="${!isAdmin}">[${userSession.user.department.name}]</c:if>
								<c:if test="${isAdmin}">[ Admin ]</c:if>
							</span>
						</a>
						<div id="gg-personal-menu" class="gg-menupop">
							<div class="gg-menupop-inner">
								<div id="personal-0">
									<span id="default-avatar"></span>
									<%--<img id="avatar" src="" alt="Tien Nguyen" style="display:none" />--%>
									<div class="personal-info">
										<span class="gme">${userSession.user.firstName} ${userSession.user.lastName}</span>
										<span class="gmail">${userSession.user.email}</span>
										<span class="grole">${userSession.user.role.name}</span>
										<ul class="personal-links">
											<li><a id="profile" class="link">Profile</a></li>
											<li><a id="blog" class="link" href="<jtien:settings key="author.blog"/>">About Me</a></li>
										</ul>
									</div>
									<div class="clear"></div>
									<table id="another">
										<tbody>
											<tr>
												<td class="tdleft"><a id="signout" class="link" href="<jtien:url address="/ssoLogout"/>">Sign out</a></td>
												<td class="tdright"><a id="close-personal-menu" class="link">Close</a></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</li>
					<li class="gg-link-top">
						<span class="ggs"></span>
					</li>
					<li id="gg-adminbar-options" class="gg-link-top">
						<a id="lnkOptions" class="ggl" href="javascript:">
							<span class="gglb"></span>
							<span class="ggls"><span id="options"></span></span>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div id="ggaction">
		<%--<img src="<jtien:templateResource item="/${templateName}/css/images/mantech_logo.png"/>" alt="" style="display:inline-block;margin-top:-12px;vertical-align:middle" />--%>
		<span class="logo-text">Mantech Helpdesk</span> · <span class="path-1">Admin Control Panel</span>
	</div>
	<div id="ggshadow"><div></div></div>
</div>
<div id="globalContainer">
	<%@ include file="gg_adminmenu.inc"%>