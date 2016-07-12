(function($) {
    var oldHTML = $.fn.html;
    $.fn.formhtml = function(fieldTargetNameParam) {
		

        var fieldTargetName = fieldTargetNameParam;
        
        $("input,button", this).each(function() {
        	
        	if(fieldTargetName){
        		this.setAttribute('name', fieldTargetName+'.' + this.getAttribute('name'));
        	}
        	
            this.setAttribute('value',this.value);
        });
        
        $("textarea", this).each(function() {
            if(fieldTargetName){
        		this.setAttribute('name', fieldTargetName+'.' + this.getAttribute('name'));
        	}
            $(this).html(this.value);
        });
        
        
        $(":radio,:checkbox", this).each(function() {
            if(fieldTargetName){
        		this.setAttribute('name', fieldTargetName+'.' + this.getAttribute('name'));
        	}
        
            if (this.checked) this.setAttribute('checked', 'checked');
            else this.removeAttribute('checked');
        });
        
         $("select", this).each(function() {
            if(fieldTargetName){
        		this.setAttribute('name', fieldTargetName+'.' + this.getAttribute('name'));
        	}
        
         });
        
        $("option", this).each(function() {

        
            if (this.selected) this.setAttribute('selected', 'selected');
            else this.removeAttribute('selected');
        });
        return oldHTML.apply(this);
    };
})(jQuery);