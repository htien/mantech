$(function() {
	jTien.f.autocompleteOff();
	jTien.f.completeFormAction();
	jTien.f.disableDrag('{"tags":["a", "img"]}');
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
		$('input[type=text].off').attr('autocomplete', 'off');
	},
	
	completeFormAction: function() {
		$('form').attr('action', function() {
			var action = $(this).attr('action');
			return !action.endsWith($ext) ? action + $ext : action; 
		});
	},
	
	/** Prevent from dragging <link> and <image> */
	disableDrag: function(elements) {
		var tags = $.parseJSON(elements).tags;
		$.each(tags, function(idx, el) {
			$(el).live('mousedown', $false);
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