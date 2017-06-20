$(function(){
	var $agreement = $("#agreement");

	$agreement.data("value", false);

	$agreement.click(function() {
		var $this = $(this);
		
		var baseUrl =root+"/pictures/reg-login/";
		var value = $this.data("value");		

		value = !value;
		
		var src =
			baseUrl + (value?
				"checkbox-selected.png":
				"checkbox-unselected.png");

		$this.attr("src", src);
		$this.data("value", value);
	});
});
