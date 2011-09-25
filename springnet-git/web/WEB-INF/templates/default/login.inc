<div id="signin_pagelet">
	<div id="signin-box">
		<h2>Administration</h2>
		<form id="signin-form" class="off" action="/" method="post">
			<div>
				<label title="Account ID (Username OR Email)">
					<strong class="id-label">ID</strong>
					<input type="text" id="id" class="g-t" name="id" value="" />
				</label>
				<label title="Your password for signing in">
					<strong class="passwd-label">Password</strong>
					<input type="password" id="passwd" class="g-t" name="passwd" value="" />
				</label>
			</div>
			<div id="signin" class="g-b g-b-b sm">Sign in</div>
			<span id="loginMsg">${loginMsg}</span>
		</form>
	</div>
</div>