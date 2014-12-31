$(document).ready(function()
		 {
		     // MAKE SURE YOUR SELECTOR MATCHES SOMETHING IN YOUR HTML!!!
		     $('a').each(function() {
		         $(this).qtip({
		            content: {
		                 text: $(this).next('.tooltiptext')
		            },
		            hide: {
		            	when: 'mouseout',
		            	 fixed: true,
		            	 delay: 1000
		            }
		         });
		     });
		 });
