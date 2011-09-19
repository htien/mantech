var $false = function() { return false; };
var $ctx = '${contextPath}', $ext = '${ext}', $webpage = '${webpage}';
var $json = __loadResource($ctx + '/_/resources.json');
__loadScripts();

/**
 * This function includes all necessary css files for the application
 */
function importCss(url) {
	var link = document.createElement('link');
	link.type = 'text/css';
	link.href = url;
	link.rel = 'stylesheet';

	document.getElementsByTagName('head').item(0).appendChild(link);
}

/**
 * This function includes all necessary js files for the application
 */
function include(url, callback) { // use jQuery.getScript(url, [callback]) insteads
	var script = document.createElement('script');
	script.type = 'text/javascript';
	script.src = url;
	script.defer = 'defer';

	var ua = navigator.userAgent;

	if (ua.indexOf('MSIE') > -1) {
		script.onreadystatechange = callback;
	} else {
		script.onload = callback;
	}

	document.getElementsByTagName('head').item(0).appendChild(script);
}

/**
 *  Load jQuery plugins
 */
function __loadScripts() {
	$.ajaxSetup({ async : false, cache : true });
	$.each($json.path.scripts, function(idx, el) {
		var _path = $ctx + el;
		console.log('Loading javascript from resource [' + _path + ']');
		$.getScript(_path);
	});
	$.each($json.path.css, function(idx, el) {
		var _path = $ctx + el;
		console.log('Loading stylesheet from resource [' + _path + ']');
		importCss(_path);
	});
	$.ajaxSetup({ async : true });
}

/**
 * Load json resource
 */
function __loadResource(url) {
	console.log("Loading resource from [" + url + "]");
	var _json = null;
	$.ajax({
		url: url,
		async: false,
		dataType: 'json',
		success: function(json) {
			_json = json;
		}
	});
	return _json;
}