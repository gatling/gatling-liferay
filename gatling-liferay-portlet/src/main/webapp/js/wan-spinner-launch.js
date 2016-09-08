

$(document).ready(function() {
	var options = {
		maxValue : 99,
		minValue : 0,
		step : 1,
		start : 2,
		plusClick : function(val) {
			console.log(val);
		},
		minusClick : function(val) {
			console.log(val);
		},
		exceptionFun : function(val) {
			console.log("excep: " + val);
		},
		valueChanged : function(val) {
			console.log('change: ' + val);
		}
	}
	$(".time").WanSpinner(options);
});
