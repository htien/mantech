/* === Load required Google Closure Library === */

//goog.require('goog.editor.Field');
//goog.require('goog.ui.editor.DefaultToolbar');
//goog.require('goog.ui.editor.ToolbarController');
//goog.require('goog.ui.Dialog');


/* === Initialize global variables === */

var $dialogOpts = {
		title: 'Mantech Helpdesk',
		autoOpen: false,
		draggable: true,
		modal: true,
		resizable: false,
		position: 'center',
		minWidth: 390,
		minHeight: 190,
		width: 'auto',
		height: 'auto',
		closeOnEscape: false,
		open: function(evt, ui) {
			$('.ui-dialog-titlebar-close').remove();
		},
		buttons: {
			'Close': function() {
				$(this).dialog('destroy');
			}
		}
},
$validateOpts = {
		debug: $debug,
		errorClass: 'error', validClass: 'valid',
		onkeyup: false, onfocusout: false,
		highlight : function(el, errorClass, validClass) {
			$(el).addClass(errorClass).removeClass(validClass);
			$(el).next('span[class~=' + el.id + ']').addClass(errorClass);
		},
		unhighlight: function(el, errorClass, validClass) {
			$(el).addClass(validClass).removeClass(errorClass);
			$(el.form).find('span[class~=' + el.id + ']').removeClass(errorClass);
		}
};

/* === Initialize setup default === */

$.ajaxSetup({
	scriptCharset: 'UTF-8',
	statusCode: {
		400: function() {
			jTien.callJqDialog('ajax-response', 'The request cannot be fulfilled due to bad syntax.', {title: 'HTTP Response 400'}).dialog('open');
		},
		404: function() {
			jTien.callJqDialog('ajax-response', 'The requested resource could not be found but may be available again in the future.', {title: 'HTTP Response 404'}).dialog('open');
		},
		500: function() {
			jTien.callJqDialog('ajax-response', 'Internal Server Error. Please try again later.', {title: 'HTTP Response 500'}).dialog('open');
		}
	}
});

$.validator.setDefaults($validateOpts);
$.validator.addMethod('vietnameseDate', function(value, element) {
	return value.match(/^\d\d\d\d\/\d\d?\/\d\d?$/);
}, 'Invalidate date format yyyy/MM/dd');

/* === Global functions === */

pageload = function() {
	$.history.init(applyAjax_pageload);
},

applyAjax_pageload = function(hash) {
	if (hash) jTien.ajaxFromLink(undefined, jTien.url('/load'), '#ggbody-content');
},

applyAjax_adminmenu = function() {
	$('#adminmenu a').each(function(idx, el) {
		$(el).click(function(evt) {
			jTien.ajaxFromLink(this, jTien.url('/load'), '#ggbody-content');
			evt.preventDefault();
			return false;
		});
	});
},

shakeContainer = function(container) {
	jTien.toJqId(container).stop(true, true).effect('shake', { times:2, distance:5 }, 50);
};

/* === Execute default methods === */

$(function() {
	jTien.f.autocompleteOff();
	jTien.f.completeFormAction();
	jTien.f.disableDrag('{"tags":["a", "img"], "classes":["g-b"]}');
});



/* ========== SPRINGNET JAVASCRIPT LIBRARY === */

/**
 * endsWith method for javascript String object, same as Java.
 * 
 * @param suffix
 * @returns {Boolean}
 */
String.prototype.endsWith = function(suffix) {
    return this.indexOf(suffix, this.length - suffix.length) !== -1;
};

/**
 * Initilization jTien library.
 */
;(function(window, undefined) {

var jTien = function() {
	return new jTien.fn.init();
};

jTien.fn = jTien.prototype = {
	init: function() {
		return new Object();
	}
};

// Give the init function the jTien prototype for later instantiation
jTien.fn.init.prototype = jTien.fn;

jTien.toJqId = function(id) {
	return (typeof id === 'string')
				? /^#/.test(id) ? $(id) : $('#' + id)
				: id;
};

jTien.url = function(path) {
	if (typeof path === 'string') {
		return $ctx.concat(path).concat($ext);
	}
	else {
		return $ctx;
	}
};

jTien.resetForm = function(form) {
	var _form = jTien.toJqId(form);
	_form[0].reset();
	_form.find(':input[class!=noreset]:visible:enabled:first').focus();
	return _form;
};

jTien.ajaxSubmit = function(form) {
	var jqXhr = jTien.f.ajaxSubmit(form);
	return jqXhr;
};

jTien.ajaxConnect = function(container, form, data) {
	var _form = form instanceof HTMLFormElement ? $(form) : jTien.toJqId(form);
	return jTien.f.ajaxConnect(container, {
			async: false,
			type: _form.attr('method'),
			url: _form.attr('action'),
			data: data == undefined ? _form.serialize() : data
	});
};

jTien.ajaxFromLink = function(link, target, container) {
	return jTien.f.ajaxFromLink(link, target).success(function(html) {
		jTien.toJqId(container).html(html);
		jTien.f.completeFormAction();
	});
};

jTien.callJqDialog = function(id, url, settings, dlgOpts) {
	var isUrl = jTien.f.isUrl(url);
	if (dlgOpts == undefined) {
		dlgOpts = settings;
		settings = isUrl ? {} : undefined;
	}
	if (typeof settings === 'object') {
		settings.async = false;
	}
	var responseText =  isUrl
			? $.ajax(url, settings).responseText
			: '<p class="gg-popup-msg">' + url + '</p>';
	var dlg = jTien.f.createJqDialog(id, responseText, dlgOpts); 
	return dlg;
};

jTien.f = jTien.prototype = {

	/** Turn off autocomplete for input text */
	autocompleteOff: function() {
		if ($debug && !isIEBrowser()) {
			console.log('Assigned autocomplete="off" on input[type=text].');
		}
		$('form.off').attr('autocomplete', 'off');
		$('input[type=text].off').attr('autocomplete', 'off');
	},
	
	completeFormAction: function() {
		if ($debug && !isIEBrowser()) {
			console.log('Auto assigning "' + $ext + '" for form[action].');
		}
		$('form').attr('action', function() {
			var action = $ctx + $(this).attr('action');
			return !action.endsWith("/") && !action.endsWith($ext) ? action + $ext : action;
		});
	},
	
	/** Prevent from dragging <link> and <image> */
	disableDrag: function(elements) {
		var json = $.parseJSON(elements); 
		$.each(json.tags, function(idx, el) {
			if ($debug && !isIEBrowser()) {
				console.log('Diabled dragging on tag: "' + el + '"');
			}
			$(el).live('mousedown', $false);
		});
		$.each(json.classes, function(idx, el) {
			if ($debug && !isIEBrowser()) {
				console.log('Diabled dragging on class: ".' + el + '"');
			}
			$('.' + el).live('mousedown', $false);
		});
	},
	
	getJSON: function(path) {
		var _json = null;
		$.ajax({
			url: $ctx + '/_/' + path,
			async: false,
			dataType: 'json',
			success: function(json) {
				_json = json;
			}
		});
		return _json;
	},
	
	ajaxSubmit: function(form) {
		var _form = form instanceof HTMLFormElement ? $(form) : form;
		var settings = {
			async: false,
			type: _form.attr('method'),
			url: _form.attr('action'),
			data: _form.serialize()
		};
		return $.ajax(settings);
	},
	
	ajaxConnect: function(container, url, data, type, settings) {
		if (jTien.f.isBlank(url)) {
			return null;
		}

		if (typeof url === 'object') {
			settings = settings || url;
			url = undefined;
			data = undefined;
			type = undefined;
		}
		else {		
			url = jTien.f.isUrl(url) ? url : undefined;
			data = !jTien.f.isBlank(data) ? data : undefined;
			type = !jTien.f.isBlank(type) ? type : 'GET';
		}

		settings = settings || {};
		settings.async = settings.async == undefined ? false : settings.async;
		settings.url = url != undefined ? url : settings.url;
		settings.data = data != undefined ? data: settings.data;
		settings.type = settings.type == undefined ? type : settings.type;

		var jqXHR = $.ajax(settings);
		
		jTien.toJqId(container).html(jqXHR.responseText);
		return jqXHR;
	},

	/**
	 * Ajax, get page from link.
	 * Syntax: ajaxFromLink(link[, type], target)
	 * @param link
	 */
	ajaxFromLink: function(link, type, target) {
		var hash = (link == undefined ? document.location.hash : $(link).attr('href')).replace(/^.*#/, ''),
			page = 'page='.concat(hash);
		if (target == undefined) {
			target = type;
			type = undefined;
		}
		var jqXHR = $.ajax({
			async: false,
			url: target,
			type: type || 'get',
			data: page,
			cache: false
		});
		$.history.load(hash);
		return jqXHR;
	},

	createJqDialog: function(id, data, dlgOpts) {
		var dlg = document.getElementById(id) == null
				? $('<div id="' + id + '"></div>')
				: $('#' + id);
		dlg.html(data);
		dlg.dialog($dialogOpts);
		if (typeof dlgOpts === 'object') {
			dlg.dialog(dlgOpts);
		}
		return dlg;
	},
	
	isBlank: function(text) {
		return text == null || (typeof text === 'string' && /^\s*$/.test(text));
	},
	
	isUrl: function(url) {
		return url != null &&
			(typeof url === 'string' && /^(\/|http:\/\/|https:\/\/|ftp:\/\/)/.test(url));
	}
};

window.jTien = jTien;

})(window);