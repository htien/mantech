/* === Load required Google Closure Library === */

goog.require('goog.editor.Field');
goog.require('goog.ui.editor.DefaultToolbar');
goog.require('goog.ui.editor.ToolbarController');
goog.require('goog.ui.Dialog');


/* === Initialize global variables === */

var $dialogOpts = {
		title: 'Mantech Help Desk',
		autoOpen: false,
		draggable: true,
		modal: true,
		resizable: false,
		position: 'center',
		minWidth: 460,
		minHeight: 160,
		width: 'auto',
		height: 'auto'
};
var $validateOpts = {
		debug: $debug,
		errorClass: 'error', validClass: 'valid',
		onkeyup: false, onfocusout: false,
		highlight : function(el, errorClass, validClass) {
			$(el).addClass(errorClass).removeClass(validClass);
			$(el.form).find('span[class~=' + el.id + ']').addClass(errorClass);
		},
		unhighlight: function(el, errorClass, validClass) {
			$(el).addClass(validClass).removeClass(errorClass);
			$(el.form).find('span[class~=' + el.id + ']').removeClass(errorClass);
		}
};

/* === Initialize setup default === */

$.ajaxSetup({
	statusCode: {
		404: function() {
			alert('Page not found.');
		},
		500: function() {
			alert('Server is busy.');
		}
	}
});
$.validator.setDefaults($validateOpts);
$.validator.addMethod('vietnameseDate', function(value, element) {
	return value.match('/^\d\d\d\d\/\d\d?\d\d?$/');
}, '');

/* === Execute default methods === */

$(function() {
	jTien.f.autocompleteOff();
	jTien.f.completeFormAction();
	jTien.f.disableDrag('{"tags":["a", "img"], "classes":["g-b"]}');
});



/*
	=== SPRINGNET JAVASCRIPT LIBRARY ===
*/

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

jTien.resetForm = jTien.prototype = function(form) {
	var _form = typeof form === 'string'
			? /^#/.test(form) ? $(form) : $('#' + form)
			: form;
	_form[0].reset();
	_form.find(':input:visible:enabled:first').focus();
	return _form;
};

jTien.ajaxSubmit = jTien.prototype = function(form) {
	var jqXhr = jTien.f.ajaxSubmit(form);
	return jqXhr;
};

jTien.callJqDialog = jTien.prototype = function(id, url, settings, dlgOpts) {
	var isUrl = /^(\/|http:\/\/|https:\/\/|ftp:\/\/)/.test(url);
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
		var settings = {
			async: false,
			type: form.attr('method'),
			url: form.attr('action'),
			data: form.serialize()
		};
		return $.ajax(settings);
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
	}
};

window.jTien = jTien;

})(window);