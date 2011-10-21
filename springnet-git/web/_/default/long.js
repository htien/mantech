$('#pagelet_addcomplaint').ready(function() {
	var frm = null,
		dialogOpts = {
			title: 'Add Complaint Confirmation',
			buttons: {
				'Create': function() {
					if (!frm.valid()) { return; }
					jTien.ajaxSubmit(frm)
						.success(function(data, textCode, xhr) {
							if (data.status == 1) {
								jTien.callJqDialog('ajax-response', data.message, {
									buttons: {
										'Close': function() {
											$(this).dialog('destroy');
										}
									}
								});
								jTien.resetForm(frm);
							}
						})
						.error(function(data) {
							$(dialog).dialog('close');
						});
				},
				'Cancel': function() {
					$(this).dialog('destroy');
				}
			}
		},
		validOpts = {
			rules: {
				complaint_title: { required: true },
				complaint_content: { required: true }
			},
			submitHandler: function(form) {
				jTien.callJqDialog('ajax-response', 'Are you sure you want to add new complaint?', 
						dialogOpts).dialog('open');
			}
		};
	
	$('#addcomplaint-box').delegate('#btnAdd', 'click', function(evt) {
		frm = $(this).parents('form');
		frm.validate(validOpts);
		frm.submit();
	});
	$('#addcomplaint-box').delegate('#btnReset', 'click', function(evt) {
		jTien.resetForm($(this).parents('form'));
	});
});

$('#pagelet_addassignment').ready(function() {
	var frm = null,	
		dialogOpts = {
			title: 'Add Assignment Confirmation',
			buttons: {
				'Create': function() {
					if (!frm.valid()) { return; }
					jTien.ajaxSubmit(frm)
						.success(function(data, textCode, xhr) {
							jTien.callJqDialog('ajax-response', 'Added assignment successfully!', {
								buttons: {
									'Close': function() {
										$(this).dialog('destroy');
									}
								}
							});
							$('#msg').html(xhr.responseText);
							jTien.resetForm(frm);
						})
						.error(function(data) {
							$(dialog).dialog('close');
						});
				},
				'Cancel': function() {
					$(this).dialog('destroy');
				}
			}
		},
		validOpts = {
				rules: {
					beginDate: {
						required: true,
						vietnameseDate: true
					},
					duration: {
						required: true,
						digits: true
					},
					userId: {
						required: true
					}
				},
				submitHandler: function(form) {
					var dlg = jTien.callJqDialog('ajax-response', 'Are you sure you want to add new assignment?', 
							dialogOpts);
					dlg.dialog('open');
				}
		};
	
	$('#addassignment-box').delegate('#btnAdd', 'click', function(evt) {
		frm = $(this).parents('form');
		frm.validate(validOpts);
		frm.submit();
	});
	$('#addassignment-box').delegate('#btnReset', 'click', function(evt) {
		jTien.resetForm($(this).parents('form'));
	});
});

$('#pagelet_editcomplaint').ready(function() {
	var frm = null,
	
	dialogOpts = {
		title: 'Edit Complaint Confirmation',
		buttons: {
			'Update': function() {
				if (!frm.valid()) {return;}
				jTien.ajaxSubmit(frm)
					.success (function(json, textCode, xhr) {
						jTien.callJqDialog('ajax-response', json.message, {
							buttons: {
								'Close Message': function() {
									$(this).dialog('destroy');
								}
							}
						});
					});
			},
			'Cancel': function() {
				$(this).dialog('destroy');
			}
		}
	},
	
	validOpts = {
		submitHandler: function(form) {
			jTien.callJqDialog('ajax-response', 'Are you sure want to edit this complaint?', dialogOpts).dialog('open');
		}	
	};
	
	$('#editcomplaint-box').delegate('#btnEdit', 'click', function(evt) {
		frm = $(this).parents('form');
		frm.validate(validOpts);
		frm.submit();
	});
});

startChart = function() {
	var a = [560, 2000, 700, 4000],
		b = [100,200,30,130,60,30,10,100,600,200,100,50,150,800,200,100,30,70,80,20,200,200,1200,400,200,100,300,1600];
	
	var first = b.slice(0,7);
	var second = b.slice(7,14);
	var third = b.slice(14,21);
	var fourth = b.slice(21,28);
	
	var chart=0;
	
	var colors = Highcharts.getOptions().colors,
	categories = ['First Week', 'Second Week', 'Third Week', 'Fourth Week'],
	name = 'Monthly Report',
	data = [{
			y: a[0],
			color: colors[0],
			drilldown: {
				name: 'First Week',
				categories: ['Monday', 'Tuesday', 'Wednesday', 'Thurday', 'Friday', 'Saturday', 'Sunday'],
				data: first,
				color: colors[0]
			}
		}, {
			y: a[1],
			color: colors[1],
			drilldown: {
				name: 'Second Week',
				categories: ['Monday', 'Tuesday', 'Wednesday', 'Thurday', 'Friday', 'Saturday', 'Sunday'],
				data: second,
				color: colors[1]
			}
		},{
			y: a[2],
			color: colors[2],
			drilldown: {
				name: 'Third Week',
				categories: ['Monday', 'Tuesday', 'Wednesday', 'Thurday', 'Friday', 'Saturday', 'Sunday'],
				data: third,
				color: colors[2]
			}
		}, {
			y: a[3],
			color: colors[3],
			drilldown: {
				name: 'Fourth Week',
				categories: ['Monday', 'Tuesday', 'Wednesday', 'Thurday', 'Friday', 'Saturday', 'Sunday'],
				data: fourth,
				color: colors[3]
			}
		}];
	
	function setChart(name, categories, data, color) {
		chart.xAxis[0].setCategories(categories);
		chart.series[0].remove();
		chart.addSeries({
			name: name,
			data: data,
			color: color || 'white'
		});
	}
	
	chart = new Highcharts.Chart({
		credits: {
			enabled: false,
		},
		chart: {
			renderTo: 'container',
			type: 'column'
		},
		title: {
			text: 'Daily, Weekly, Monthly Complaint Report'
		},
		subtitle: {
			text: 'Click to the column to view details'
		},
		xAxis: {
			categories: categories
		},
		yAxis: {
			title: {
				text: 'Total Complaints'
			}
		},
		plotOptions: {
			column: {
				cursor: 'pointer',
				point: {
					events: {
						click: function() {
							var drilldown = this.drilldown;
							if (drilldown) {
								setChart(drilldown.name, drilldown.categories, drilldown.data, drilldown.color);
							}else {
								setChart(name, categories, data);
							}
						}
					}
				},
				dataLabels: {
					enabled: true,
					color: colors[5],
					style: {
						fontweight: 'bold'
					},
					formatter: function() {
						return this.y + ' complaints';
					}
				}
			}
		},
		tooltip: {
			formatter: function() {
				var point = this.point,
				s = this.x +':<b>'+ this.y +' complaints</b><br/>';
				if (point.drilldown) {
					s += 'Click to view '+ point.category;
				} else {
					s += 'Click to return to browser brands';
				}
				return s;
				}
		},
		series: [{
			name: name,
			data: data,
			color: 'white'
			}],
		exporting: {
			enabled: true
		}
	});
};
