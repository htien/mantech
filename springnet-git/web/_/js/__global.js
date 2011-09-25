$(function() {
	jTien.f.autocompleteOff();
	jTien.f.completeFormAction();
	jTien.f.disableDrag('{"tags":["a", "img"], "classes":["g-b"]}');
});

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
		
	}
};

window.jTien = jTien;

})(window);