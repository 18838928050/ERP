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
		moveOut: false,
		//下面 3 行实现点击当前行置顶
//		zIndex: layer.zIndex,
//		success: function(layero){
//		  layer.setTop(layero);
//		}
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
			moveOut: false,
			//下面 3 行实现点击当前行置顶
//		zIndex: layer.zIndex,
//	    success: function(layero){
//	      layer.setTop(layero);
//	    }
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







