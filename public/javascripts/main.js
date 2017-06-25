var trent = trent || {};

trent.forms = (function (window, document, $) {

	'use strict';

	var formUtils = {
		el: {
			form : $("form"),
		},
		init : function() {
			formUtils.submit();
		},
		submit : function(){
			formUtils.el.form.on("submit", formUtils.handler);
		},
		handler: function(event) {
			event.preventDefault();
			$.post(formUtils.el.form.attr('action'), formUtils.data(), function( response, textStatus, jqXHR ){
				console.log(response);
				console.log(textStatus);
				console.log(jqXHR);
			}, 'json');
		},
		data : function(){
			var inputs = {};
			formUtils.el.form.serializeArray().map(function(item, index) {
				inputs[item.name] = item.value;
			});
			return inputs;
		}
	};
	return {
		init: formUtils.init,
	};
})(window, document, jQuery);


jQuery(document).ready(function($){
    trent.forms.init();
});