<%@ include file="top.inc"%>

<div id="adminmenuback"></div>
<div id="adminmenuwrap">
	<div id="adminmenushadow"></div>
	<ul id="adminmenu">
		<li id="menu-dashboard" class="gg-first-item gg-menu-top gg-has-submenu menu-icon-dashboard">
			<div class="gg-menu-arrow"><div></div></div>
			<div class="gg-menu-toggle"><br /></div>
			<a href="<jtien:url address="/index"/>#dashoverview" class="gg-menu-top gg-menu-image">Dashboard</a>
			<div class="gg-submenu">
				<div class="gg-submenu-wrap">
					<div class="gg-submenu-head">Dashboard</div>
					<ul>
						<li class="gg-first-item current"><a href="<jtien:url address="/index"/>#dashoverview">Home</a></li>
						<li><a href="<jtien:url address="/index"/>#viewreport">Report</a></li>
						<li><a href="<jtien:url address="/index"/>#viewstats">Stats</a></li>
						<li><a href="<jtien:url address="/index"/>#faqs">FAQs</a></li>
					</ul>
				</div>
			</div>
		</li>
		<li id="menu-complaints" class="gg-menu-top gg-has-submenu menu-icon-complaint">
			<div class="gg-menu-arrow"><div></div></div>
			<div class="gg-menu-toggle"><br /></div>
			<a href="<jtien:url address="/index"/>#listcomplaint" class="gg-menu-top gg-menu-image">Complaints</a>
			<div class="gg-submenu">
				<div class="gg-submenu-wrap">
					<div class="gg-submenu-head">Complaints</div>
					<ul>
						<li class="gg-first-item"><a href="#listcomplaint">All Complaints</a></li>
						<li><a href="<jtien:url address="/index"/>#addcomplaint">Add New</a></li>
					</ul>
				</div>
			</div>
		</li>
		<li id="menu-assignments" class="gg-menu-top menu-icon-assignment">
			<div class="gg-menu-arrow"><div></div></div>
			<div class="gg-menu-toggle"><br /></div>
			<a href="<jtien:url address="/index"/>#listassignment" class="gg-menu-top gg-menu-image">Assignments</a>
		</li>
		<li id="menu-equipments" class="gg-menu-top gg-has-submenu menu-icon-equipment">
			<div class="gg-menu-arrow"><div></div></div>
			<div class="gg-menu-toggle"><br /></div>
			<a href="<jtien:url address="/index"/>#listequipment" class="gg-menu-top gg-menu-image">Equipments</a>
			<div class="gg-submenu">
				<div class="gg-submenu-wrap">
					<div class="gg-submenu-head">Equipments</div>
					<ul>
						<li class="gg-first-item"><a href="<jtien:url address="/index"/>#listequipment">All Equipments</a></li>
						<li><a href="<jtien:url address="/index"/>#addequipment">Add New</a></li>
						<li><a href="<jtien:url address="/index"/>#listcategory">Categories</a></li>
					</ul>
				</div>
			</div>
		</li>
		<li id="menu-users" class="gg-menu-top gg-has-submenu menu-icon-user">
			<div class="gg-menu-arrow"><div></div></div>
			<div class="gg-menu-toggle"><br /></div>
			<a href="<jtien:url address="/index"/>#listuser" class="gg-menu-top gg-menu-image">Users</a>
			<div class="gg-submenu">
				<div class="gg-submenu-wrap">
					<div class="gg-submenu-head">Users</div>
					<ul>
						<li class="gg-first-item"><a href="<jtien:url address="/index"/>#listuser">All Users</a></li>
						<li><a href="<jtien:url address="/index"/>#adduser">Add New</a></li>
					</ul>
				</div>
			</div>
		</li>
		<li id="menu-credits" class="gg-menu-top menu-icon-credit">
			<div class="gg-menu-arrow"><div></div></div>
			<div class="gg-menu-toggle"><br /></div>
			<a href="<jtien:url address="/index"/>#viewcredits" class="gg-menu-top gg-menu-image">Credits</a>
		</li>
	</ul>
</div>
