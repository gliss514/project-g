var load;
var doSubmit;
(function($) {
	var $workspace = $("#workspace");

	(function() {
		var currentPath = window.location.href;

		load = function load(url) {
			$.ajax(url, {
				"headers" : {
					"requester" : currentPath
				},
				"success" : function(data) {
					$workspace.html(data);
					doAfterLoad($workspace);
				}
			});
			currentPath = url;
		};

		doSubmit = function doSubmit(action, formName) {
			var form = document.forms[formName];
			form.action = action;
			$(form).submit();
		};

		function doAfterLoad($container) {
			var forms = $container.find("form");
			forms.ajaxForm({
				"beforeSend" : doBeforeSend,
				"success" : doFormSubmitSuccess
			});

//			forms.find('.datepicker').datepicker({
//				format : 'dd/mm/yyyy',
//				autoclose : true
//			});
//			forms.find('.duallist').bootstrapDualListbox();
//			forms.find('.fileinput').bootstrapFileInput();
//			var $slider = forms.find('.slider').slider();
//			$slider.on('slide', function(ev) {
//				$('#sliderVal').val(ev.value);
//			});

			function doFormSubmitSuccess(response) {
				doAfterLoad(($container.html(response)));
			}

			function doBeforeSend(jqXHR) {
				jqXHR.setRequestHeader("requester", currentPath);
			}
		}
	}());
})(jQuery);