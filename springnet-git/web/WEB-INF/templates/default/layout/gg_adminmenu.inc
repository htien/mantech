<%@ include file="top.inc"%>

<div id="adminmenuback"></div>
<div id="adminmenuwrap">
	<div id="adminmenushadow"></div>
	<ul id="adminmenu">
		<li class="quickbuttons">
			<c:if test="${isEmployee}">
				<div id="new-complaint" class="g-b g-b-r"><jtien:i18n key="AdminMenu.buttons.newComplaint"/></div>
			</c:if>
		</li>
		<li id="menu-dashboard" class="gg-first-item gg-menu-top gg-has-submenu menu-icon-dashboard">
			<div class="gg-menu-arrow"><div></div></div>
			<div class="gg-menu-toggle"><br /></div>
			<div class="gg-menu-top"><a href="<jtien:url address="/index"/>#dashoverview" class="gg-menu-top gg-menu-image"><jtien:i18n key="AdminMenu.dashboard"/></a></div>
			<div class="gg-submenu">
				<div class="gg-submenu-wrap">
					<div class="gg-submenu-head"><jtien:i18n key="AdminMenu.dashboard"/></div>
					<ul>
						<li class="gg-first-item current"><a href="<jtien:url address="/index"/>#dashoverview"><jtien:i18n key="AdminMenu.dashboard.home"/></a></li>
						<c:if test="${isAdmin}"><li><a href="<jtien:url address="/index"/>#viewreports"><jtien:i18n key="AdminMenu.dashboard.reports"/></a></li></c:if>
						<li><a href="<jtien:url address="/index"/>#viewstats"><jtien:i18n key="AdminMenu.dashboard.stats"/></a></li>
						<li><a href="<jtien:url address="/index"/>#faqs"><jtien:i18n key="AdminMenu.dashboard.faqs"/></a></li>
					</ul>
				</div>
			</div>
		</li>
		<c:if test="${!isTechnician}">
			<li id="menu-complaints" class="gg-menu-top gg-has-submenu menu-icon-complaint">
				<div class="gg-menu-arrow"><div></div></div>
				<div class="gg-menu-toggle"><br /></div>
				<div class="gg-menu-top"><a href="<jtien:url address="/index"/>#listcomplaint" class="gg-menu-top gg-menu-image"><jtien:i18n key="AdminMenu.complaints"/></a></div>
				<div class="gg-submenu">
					<div class="gg-submenu-wrap">
						<div class="gg-submenu-head"><jtien:i18n key="AdminMenu.complaints"/></div>
						<ul>
							<li class="gg-first-item"><a href="<jtien:url address="/index"/>#listcomplaint"><jtien:i18n key="AdminMenu.complaints.all"/></a></li>
							<c:if test="${isEmployee}"><li><a id="addcomplaint" href="<jtien:url address="/index"/>#addcomplaint"><jtien:i18n key="AdminMenu.complaints.new"/></a></li></c:if>
						</ul>
					</div>
				</div>
			</li>
		</c:if>
		<c:if test="${isTechnician}">
			<li id="menu-assignments" class="gg-menu-top menu-icon-assignment">
				<div class="gg-menu-arrow"><div></div></div>
				<div class="gg-menu-toggle"><br /></div>
				<div class="gg-menu-top"><a href="<jtien:url address="/index"/>#listassignment" class="gg-menu-top gg-menu-image"><jtien:i18n key="AdminMenu.assignments"/></a></div>
			</li>
		</c:if>
		<li id="menu-equipments" class="gg-menu-top gg-has-submenu menu-icon-equipment">
			<div class="gg-menu-arrow"><div></div></div>
			<div class="gg-menu-toggle"><br /></div>
			<div class="gg-menu-top"><a href="<jtien:url address="/index"/>#listequipment" class="gg-menu-top gg-menu-image"><jtien:i18n key="AdminMenu.equipments"/></a></div>
			<div class="gg-submenu">
				<div class="gg-submenu-wrap">
					<div class="gg-submenu-head"><jtien:i18n key="AdminMenu.equipments"/></div>
					<ul>
						<li class="gg-first-item"><a href="<jtien:url address="/index"/>#listequipment"><jtien:i18n key="AdminMenu.equipments.all"/></a></li>
						<c:if test="${isAdmin}"><li><a href="<jtien:url address="/index"/>#addequipment"><jtien:i18n key="AdminMenu.equipments.new"/></a></li></c:if>
						<li><a href="<jtien:url address="/index"/>#listcategory"><jtien:i18n key="AdminMenu.equipments.categories"/></a></li>
					</ul>
				</div>
			</div>
		</li>
		<c:if test="${isAdmin}">
			<li id="menu-users" class="gg-menu-top gg-has-submenu menu-icon-user">
				<div class="gg-menu-arrow"><div></div></div>
				<div class="gg-menu-toggle"><br /></div>
				<div class="gg-menu-top"><a href="<jtien:url address="/index"/>#listuser/page=1" class="gg-menu-top gg-menu-image"><jtien:i18n key="AdminMenu.users"/></a></div>
				<div class="gg-submenu">
					<div class="gg-submenu-wrap">
						<div class="gg-submenu-head"><jtien:i18n key="AdminMenu.users"/></div>
						<ul>
							<li class="gg-first-item"><a href="<jtien:url address="/index"/>#listuser/page=1"><jtien:i18n key="AdminMenu.users.all"/></a></li>
							<li><a href="<jtien:url address="/index"/>#adduser"><jtien:i18n key="AdminMenu.users.new"/></a></li>
						</ul>
					</div>
				</div>
			</li>
		</c:if>
		<li id="menu-credits" class="gg-menu-top menu-icon-credit">
			<div class="gg-menu-arrow"><div></div></div>
			<div class="gg-menu-toggle"><br /></div>
			<div class="gg-menu-top"><a href="<jtien:url address="/index"/>#viewcredits" class="gg-menu-top gg-menu-image"><jtien:i18n key="AdminMenu.credits"/></a></div>
		</li>
	</ul>
</div>
