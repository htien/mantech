/* === Load required Google Closure Library === */

goog.require('goog.ui.Dialog');


/* === Initialize global variables === */

var $dialog = $('<div></div>');
var $dialogOpts = {
		title: 'Mantech Help Desk',
		autoOpen: false,
		draggable: true,
		modal: true,
		resizable: false,
		position: 'center',
		//minWidth: 460,
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

/* === Initialize default === */

$.ajaxSetup({
	statusCode: {
		404: function() {
			alert('Page not found.');
		}
	}
});
$.validator.setDefaults($validateOpts);

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

jTien.ajaxConnect = jTien.prototype = function() {
	alert('a');
};

jTien.callJqDialog = jTien.prototype = function(url, settings, dlgOpts) {
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
	jTien.f.createJqDialog(responseText, dlgOpts).dialog('open');
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
	
	ajaxSubmit: function() {
		// TODO Create ajaxSubmit() method
	},
	
	createJqDialog: function(data, dlgOpts) {
		$dialog.html(data);
		$dialog.dialog($dialogOpts);
		if (typeof dlgOpts === 'object') {
			$dialog.dialog(dlgOpts);
		}
		return $dialog;
	}
};

window.jTien = jTien;

})(window);