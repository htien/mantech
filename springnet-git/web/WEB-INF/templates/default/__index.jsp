<%@ include file="layout/top.inc" %><%@ include file="layout/header.inc" %><compress:html
	jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="globalTop" class="fixed_elem">
	<div id="ggadminbar">
		<ul>
			<li class="selected"><span>Administrator</span></li>
		</ul>
	</div>
	<div id="ggaction"><span class="one">Mantech Helpdesk</span></div>
	<div id="ggshadow"><div></div></div>
</div>
<div id="globalContainer">
	<div id="adminmenuback"></div>
	<div id="adminmenuwrap">
		<div id="adminmenushadow"></div>
		<ul id="adminmenu">
			<li id="menu-dashboard" class="gg-first-item gg-menu-top gg-has-submenu menu-icon-dashboard gg-menu-open current">
				<div class="gg-menu-arrow"></div>
				<div class="gg-menu-toggle"></div>
				<a href="#dashoverview" rel="ax" class="gg-menu-top gg-menu-image current">Dashboard</a>
				<div class="gg-submenu">
					<div class="gg-submenu-wrap">
						<div class="gg-submenu-head">Dashboard</div>
						<ul>
							<li class="gg-first-item current"><a href="#">Home</a></li>
							<li><a href="#viewreport">Report</a></li>
							<li><a href="#viewstats">Stats</a></li>
						</ul>
					</div>
				</div>
			</li>
			<li id="menu-complaints" class="gg-menu-top gg-has-submenu menu-icon-complaint gg-menu-open">
				<div class="gg-menu-arrow"></div>
				<div class="gg-menu-toggle"></div>
				<a href="#listcomplaint" rel="ax" class="gg-menu-top gg-menu-image">Complaints</a>
				<div class="gg-submenu">
					<div class="gg-submenu-wrap">
						<div class="gg-submenu-head">Complaints</div>
						<ul>
							<li class="gg-first-item"><a href="#listcomplaint">All Complaints</a></li>
							<li><a href="#addcomplaint">Add New</a></li>
						</ul>
					</div>
				</div>
			</li>
			<li id="menu-assignments" class="gg-menu-top gg-has-submenu menu-icon-assignment gg-menu-open">
				<div class="gg-menu-arrow"></div>
				<div class="gg-menu-toggle"></div>
				<a href="#listassignment" class="gg-menu-top gg-menu-image">Assignments</a>
				<div class="gg-submenu">
					<div class="gg-submenu-wrap">
						<div class="gg-submenu-head">Assignments</div>
						<ul>
							<li class="gg-first-item"><a href="#listassignment">All Assignments</a></li>
							<li><a href="#addassignment">Add New</a></li>
						</ul>
					</div>
				</div>
			</li>
			<li id="menu-equipments" class="gg-menu-top gg-has-submenu menu-icon-equipment">
				<div class="gg-menu-arrow"></div>
				<div class="gg-menu-toggle"></div>
				<a href="#listequipment" class="gg-menu-top gg-menu-image">Equipments</a>
				<div class="gg-submenu">
					<div class="gg-submenu-wrap">
						<div class="gg-submenu-head">Equipments</div>
						<ul>
							<li class="gg-first-item"><a href="#listequipment">All Equipments</a></li>
							<li><a href="#addequipment">Add New</a></li>
						</ul>
					</div>
				</div>
			</li>
			<li id="menu-users" class="gg-menu-top gg-has-submenu menu-icon-user gg-menu-open">
				<div class="gg-menu-arrow"></div>
				<div class="gg-menu-toggle"></div>
				<a href="#listuser" class="gg-menu-top gg-menu-image">Users</a>
				<div class="gg-submenu">
					<div class="gg-submenu-wrap">
						<div class="gg-submenu-head">Users</div>
						<ul>
							<li class="gg-first-item"><a href="#listuser">All Users</a></li>
							<li><a href="#adduser">Add New</a></li>
						</ul>
					</div>
				</div>
			</li>
			<li id="menu-credits" class="gg-menu-top menu-icon-credit">
				<div class="gg-menu-arrow"></div>
				<div class="gg-menu-toggle"></div>
				<a href="#viewcredits" class="gg-menu-top gg-menu-image">Credits</a>
			</li>
		</ul>
	</div>
	<div id="ggcontent">
		<div id="gghead"></div>
		<div id="ggbody">
			<div id="ggbody-content">
			</div>
		</div><%--ggbody--%>
	</div><%--ggcontent--%>
</div><%--globalContainer--%>
</compress:html><%@ include file="layout/footer.inc" %>