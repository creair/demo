;(function($){
	$.fn.automiddle = function(){
	
		return this.each(function(){
			$(this).css({
	              "left": ($(window).width() - $(this).outerWidth())/2,
	              "top": ($(window).height() + $("#main_header").outerHeight() - $(this).outerHeight())/2
	     	});
		});
	}
	
	$.fn.center = function(){
		return this.each(function(){
			$(this).css({
	              "left": ($(window).width() - $(this).outerWidth())/2
	     	});
		});
	}
		
})(jQuery);