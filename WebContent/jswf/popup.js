var popRetVal = null;

//父页面关闭弹出层
function ClosePop() {
	var layer_index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(layer_index);
}

function ShowIframe(size, url, mark, Callback, title)//模态
{
	popRetVal=null;
	var json = {
		type: 2,
		title: false,
		content: '',
		area: ['1200px', '700px'],
		shadeClose: false,
		closeBtn: 1, //关闭按钮
		resize: false, //是否允许拉伸
		scrollbar: true, //是否允许浏览器出现滚动条
		moveOut: true,
	};
	json['area'] = size;
	json['content'] = url;
	json['end'] = Callback;
	json['title'] = title;
	layui.use('layer', function() {
		var layer = layui.layer;
		var index = layer.open(json);
		//				  layer.open(json);
	});
}

//显示确认对话框
function ShowConfirm(content, options, yes) 
{
	layer.confirm(content, options, yes);
}

//显示普通信息框
function ShowAlert(content, options, yes) {
	layer.alert(content, options, yes);
}

function ShowIframeNoScroll(size, url, mark, Callback ,title) //显示没有滚动条的iframe
{
    popRetVal=null;//在子页面中使用parent.popRetVal赋值
//  enlargeMyself(1280,600,curWinW,curWinH);//不管子窗口多大都放大父窗口,因为有可能第三个更大
    
    	popRetVal=null;
		var json = {
			type: 2,
			title: false,
			content: '',
			area: ['1200px', '700px'],
			shadeClose: false,
			closeBtn: 1, //关闭按钮
			resize: false, //是否允许拉伸
			scrollbar: true, //是否允许浏览器出现滚动条
			moveOut: true,
		};
		json['area'] = size;
		json['content'] = url;
		json['end'] = Callback;
		json['title'] = title;
		layui.use('layer', function() {
			var layer = layui.layer;
			var index = layer.open(json);
			//				  layer.open(json);
		});
}



//参数示例
$('#test').on('click', function() {
	layer.open({
		type: 2, //0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
		title: ' ', //String/Array/Boolean
		content: 'EstablishmentNew.html',
		area: ['1500px', '900px'],
		offset: 't', //坐标
		//		shade: false, //遮罩
		shadeClose: true, //是否点击遮罩关闭
		//		time: 5000,//自动关闭所需毫秒
		//		id: 'id', //用于控制弹层唯一标识,设置该值后，不管是什么类型的层，都只允许同时弹出一个
		//		isOutAnim: false,//关闭动画
		//		maxmin: true,//最大最小化
		fixed: false, //层是否固定在可视区域
		resize: false, //是否允许拉伸
		//		scrollbar: false,//是否允许浏览器出现滚动条
		move: false, //触发拖动的元素
		cancel: function(index, layero) {
			if(confirm('确定要关闭么')) { //只有当点击confirm框的确定时，该层才会关闭
				layer.close(index)
			}
			return false;
		} //右上角关闭按钮触发的回调
	});
});

function showClientDialog() {
	layer.open({
		type: 2,
		title: false,
		content: 'base/EstablishmentNew.html',
		area: ['1180px', '700px'],
		shadeClose: true,
		closeBtn: 0, //关闭按钮
		resize: false, //是否允许拉伸
		scrollbar: false, //是否允许浏览器出现滚动条
		moveOut: true
	});
}

function showWin(size, url) {
	var json = {
		type: 2,
		title: false,
		content: '',
		area: ['1200px', '700px'],
		shadeClose: true,
		closeBtn: 0, //关闭按钮
		resize: false, //是否允许拉伸
		scrollbar: false, //是否允许浏览器出现滚动条
		moveOut: true
	};
	json['area'] = size;
	json['content'] = url;
	layer.open(json);
}

function showEstMoveDialog(type) {
	var json = {
		type: 2,
		title: false,
		content: '',
		area: ['550px', '330px'],
		shadeClose: true,
		//		fixed: false, //层是否固定在可视区域
		closeBtn: 0, //关闭按钮
		resize: false, //是否允许拉伸
		//		scrollbar: false,//是否允许浏览器出现滚动条
		//		move: false, //触发拖动的元素
		moveOut: true
	};
	if(type == "CLIENT") {
		json['content'] = 'base/EstablishmentMoveForm.html'; //客户
		layer.open(json);
	} else if(type == "COOPERATOR") {
		json['content'] = url; //外协商
		layer.open(json);
	} else if(type == "PROVIDER") {
		json['content'] = url; //供应商
		layer.open(json);
	}
}

function showBusinessBillDialog() {
	layer.open({
		type: 2,
		'title': false,
		content: 'base/EstablishmentListForSelect.html',
		area: ['1200px', '700px'],
		shadeClose: true,
		closeBtn: 0,
		resize: false,
		//		scrollbar: false,//是否允许浏览器出现滚动条
		//		move: false, //触发拖动的元素
		moveOut: true
	});
}

function showBusAccountDialog() {
	layer.open({
		type: 2,
		'title': false,
		content: 'base/EstablishmentListForSelect.html',
		area: ['1200px', '596px'],
		shadeClose: true,
		closeBtn: 0,
		resize: false,
		moveOut: true
	});
}

function showDelAccountDialog() {

}

function showPayBillDialog() {
	layer.open({
		type: 2,
		'title': false,
		content: 'finance/PayTypeSelect.html',
		area: ['300px', '173px'],
		shadeClose: true,
		closeBtn: 0,
		resize: false,
		moveOut: true
	});
}

function showPayBillDialogCallBack() {
	if(popRetVal != null) {
		var url = "../finance/PayBillNew.html?alert_type=SHOW&pay_type=" + popRetVal;
		showWin(1024, 600, url);
	}
	setIframeDisplay("");
}

function showAdjustBillDialog() {
	layer.open({
		type: 2,
		'title': false,
		content: 'finance/AdjustTypeSelect.html',
		area: ['300px', '317px'],
		shadeClose: true,
		closeBtn: 0,
		resize: false,
		moveOut: true
	});
//	setIframeDisplay("none");
//	var url = "../finance/AdjustTypeSelect.html";
//	ShowIframeNoScroll("选择调帐类型", url, 240, 380, "showAdjustBillDialogCallBack()");
}

function showAdjustBillDialogCallBack() {
	if(popRetVal != null) {
		var url = "../finance/AdjustBillNew.html?adjust_type=" + popRetVal + "&alert_type=SHOW";
		showWin(1024, 600, url);
	}
	setIframeDisplay("");
}
//参数示例
$('#test').on('click', function() {
	layer.open({
		type: 2, //0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
		title: ' ', //String/Array/Boolean
		content: 'EstablishmentNew.html',
		area: ['1500px', '900px'],
		offset: 't', //坐标
		//		shade: false, //遮罩
		shadeClose: true, //是否点击遮罩关闭
		//		time: 5000,//自动关闭所需毫秒
		//		id: 'id', //用于控制弹层唯一标识,设置该值后，不管是什么类型的层，都只允许同时弹出一个
		//		isOutAnim: false,//关闭动画
		//		maxmin: true,//最大最小化
		fixed: false, //层是否固定在可视区域
		resize: false, //是否允许拉伸
		//		scrollbar: false,//是否允许浏览器出现滚动条
		move: false, //触发拖动的元素
		cancel: function(index, layero) {
			if(confirm('确定要关闭么')) { //只有当点击confirm框的确定时，该层才会关闭
				layer.close(index)
			}
			return false;
		} //右上角关闭按钮触发的回调
	});
});

function showClientDialog() {
	layer.open({
		type: 2,
		title: false,
		content: 'base/EstablishmentNew.html',
		area: ['1180px', '700px'],
		shadeClose: true,
		closeBtn: 0, //关闭按钮
		resize: false, //是否允许拉伸
		scrollbar: false, //是否允许浏览器出现滚动条
		moveOut: true
	});
}

function showWin(size, url) {
	var json = {
		type: 2,
		title: false,
		content: '',
		area: ['1200px', '700px'],
		shadeClose: true,
		closeBtn: 0, //关闭按钮
		resize: false, //是否允许拉伸
		scrollbar: false, //是否允许浏览器出现滚动条
		moveOut: true
	};
	json['area'] = size;
	json['content'] = url;
	layer.open(json);
}

function showEstMoveDialog(type) {
	var json = {
		type: 2,
		title: false,
		content: '',
		area: ['550px', '330px'],
		shadeClose: true,
		//		fixed: false, //层是否固定在可视区域
		closeBtn: 0, //关闭按钮
		resize: false, //是否允许拉伸
		//		scrollbar: false,//是否允许浏览器出现滚动条
		//		move: false, //触发拖动的元素
		moveOut: true
	};
	if(type == "CLIENT") {
		json['content'] = 'base/EstablishmentMoveForm.html'; //客户
		layer.open(json);
	} else if(type == "COOPERATOR") {
		json['content'] = url; //外协商
		layer.open(json);
	} else if(type == "PROVIDER") {
		json['content'] = url; //供应商
		layer.open(json);
	}
}

function showBusinessBillDialog() {
	layer.open({
		type: 2,
		'title': false,
		content: 'base/EstablishmentListForSelect.html',
		area: ['1200px', '700px'],
		shadeClose: true,
		closeBtn: 0,
		resize: false,
		//		scrollbar: false,//是否允许浏览器出现滚动条
		//		move: false, //触发拖动的元素
		moveOut: true
	});
}

function showBusAccountDialog() {
	layer.open({
		type: 2,
		'title': false,
		content: 'base/EstablishmentListForSelect.html',
		area: ['1200px', '596px'],
		shadeClose: true,
		closeBtn: 0,
		resize: false,
		moveOut: true
	});
}

function showDelAccountDialog() {

}

function showPayBillDialog() {
	layer.open({
		type: 2,
		'title': false,
		content: 'finance/PayTypeSelect.html',
		area: ['300px', '173px'],
		shadeClose: true,
		closeBtn: 0,
		resize: false,
		moveOut: true
	});
}

function showPayBillDialogCallBack() {
	if(popRetVal != null) {
		var url = "../finance/PayBillNew.html?alert_type=SHOW&pay_type=" + popRetVal;
		showWin(1024, 600, url);
	}
	setIframeDisplay("");
}

function showAdjustBillDialog() {
	layer.open({
		type: 2,
		'title': false,
		content: 'finance/AdjustTypeSelect.html',
		area: ['300px', '317px'],
		shadeClose: true,
		closeBtn: 0,
		resize: false,
		moveOut: true
	});
//	setIframeDisplay("none");
//	var url = "../finance/AdjustTypeSelect.html";
//	ShowIframeNoScroll("选择调帐类型", url, 240, 380, "showAdjustBillDialogCallBack()");
}

function showAdjustBillDialogCallBack() {
	if(popRetVal != null) {
		var url = "../finance/AdjustBillNew.html?adjust_type=" + popRetVal + "&alert_type=SHOW";
		showWin(1024, 600, url);
	}
	setIframeDisplay("");
}



