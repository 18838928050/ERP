<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	</head>

	<body oncontextmenu="return false" onload="doInit();" class="sheet" scroll="no">
		<div class="sheet-main">
			<div class="sheet-top">
				<div class="content">
					<h2>选择材料</h2>
				</div>
			</div>
			<div class="blank24"></div>
			<div class="sheet-list" id="mainTd" style="height:348px;">
				<div class="nav" id="navDiv" style="float:left;height:100%;border:1px solid #CCCCCC;">
					<iframe width="100%" height="100%" frameborder="0" id="leftFrame" scrolling="no" src="InBillNew_toDepartmentListForStafferSelect"></iframe>
				</div>
				<div id="mainDiv" class="main search-business" style="float: right; height: 100%; width: 648px;border:1px solid #CCCCCC;">
					<iframe width="100%" height="100%" frameborder="0" id="mainFrame" scrolling="no" src=""></iframe>
				</div>
			</div>
			<div class="sheet-list" id="selectedTr" style="width: 860px;height:100px;display:none;overflow: auto;padding: 0;margin: 0 auto;">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list">
									<tbody>
										<tr>
											<th width="20%">编码</th>
											<th width="50%">品名规格</th>
											<th width="20%">单位</th>
											<th width="10%">操作</th>
										</tr>
									</tbody>
									<tbody id="selectedTbl">

									</tbody>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div id="buttonDiv" style="display:none">
				<!--<input type="button" class="buttom search-select" value=" 选 择" onclick="doOk();">-->
			</div>
		</div>

		<span id="dialogCase"><div id="dialogBoxBG" style="position: absolute; top: 0px; left: 0px; width: 100%; height: 500px; z-index: 10001; opacity: 0.4; display: none; background-color: rgb(0, 0, 0);"></div><div id="dialogBox" style="border: 1px solid rgb(230, 239, 248); z-index: 10003; position: absolute; width: 900px; left: 195.5px; top: 87px; display: none;"><table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"><tbody><tr height="24" id="dialogBoxTitleTr" bgcolor="#E6EFF8"><td><table style="-moz-user-select:none;height:24px;" width="100%" border="0" cellpadding="0" cellspacing="0"><tbody><tr><td width="6" height="24"></td><td id="dialogBoxTitle" style="color: rgb(0, 0, 0); font-size: 14px; font-weight: bold; text-align: left; cursor: move;">材料&nbsp;</td><td id="dialogClose" width="20" align="right" valign="middle"><img id="dialogBoxClose" src="./dialogclose.gif" border="0" align="absmiddle" style="cursor:pointer;" title="关闭"></td><td width="6"></td></tr></tbody></table></td></tr><tr id="dialogTr" style="height:420px" valign="top"><td id="dialogBody" style="position:relative;"></td></tr></tbody></table></div><div id="dialogBoxShadow" style="z-index: 10001; position: absolute; opacity: 0.2; top: 91px; left: 200px; width: 902px; height: 446px; display: none; background: rgb(0, 0, 0);"></div></span>
		<script src="layui/layui.all.js"></script>
		<script src="js/popup.js"></script>
		<script>
			var selectedArr = new Array();
			Array.prototype.del = function(n) {　 //n表示第几项，从0开始算起。
				//prototype为对象原型，注意这里为对象增加自定义方法的方法。
				　
				if(n < 0)　 //如果n<0，则不进行任何操作。
					　　 return this;　
				else　　 return this.slice(0, n).concat(this.slice(n + 1, this.length));　　
				/*
					　　　concat方法：返回一个新数组，这个新数组是由两个或更多数组组合而成的。
					　　　　　　　　　这里就是返回this.slice(0,n)/this.slice(n+1,this.length)
					　　 　　　　　　组成的新数组，这中间，刚好少了第n项。
					　　　slice方法： 返回一个数组的一段，两个参数，分别指定开始和结束的位置。
					　　*/
			}

			function showSelected(arr, isChecked) {
				var tmpArr;
				var found = false;
				var index = 0;
				var i;
				for(i = 0; i < selectedArr.length; i++) {
					tmpArr = selectedArr[i];
					if(tmpArr[0] == arr[0]) {
						found = true;
						index = i;
						break;
					}
				}
				if(isChecked) { //add
					if(!found) {
						selectedArr[selectedArr.length] = arr;

						var tbl = document.getElementById("selectedTbl");
						var tr = document.createElement("tr");
						tr.setAttribute("id", "itemTr" + arr[0]);

						var td = document.createElement("td");
						td.appendChild(document.createTextNode(arr[1]));
						tr.appendChild(td);

						td = document.createElement("td");
						td.appendChild(document.createTextNode(arr[2]));
						tr.appendChild(td);

						td = document.createElement("td");
						td.appendChild(document.createTextNode(arr[3]));
						tr.appendChild(td);

						td = document.createElement("td");
						var delLink = document.createElement("a");
						delLink.setAttribute("href", "javascript:doItemDelete(" + arr[0] + ");");
						delLink.appendChild(document.createTextNode("删除"));
						td.appendChild(delLink);
						tr.appendChild(td);

						tbl.appendChild(tr);
					}
				} else { //删除
					if(found) {
						selectedArr = selectedArr.del(index);
						var tbl = document.getElementById("selectedTbl");
						var tr = document.getElementById("itemTr" + arr[0]);
						tbl.removeChild(tr);
					}
				}
				showOrHidDiv();
			}

			function showOrHidDiv() {
				if(selectedArr.length == 0) {
					document.getElementById("mainTd").style.height = "348px";
					document.getElementById("selectedTr").style.display = "none";
					document.getElementById("buttonDiv").style.display = "none";
					document.getElementById("leftFrame").contentWindow.fixDivHeight("NORMAL");
					document.getElementById("mainFrame").contentWindow.fixDivHeight("NORMAL");
				} else if(document.getElementById("selectedTr").style.display == "none") {
					document.getElementById("mainTd").style.height = "248px";
					document.getElementById("selectedTr").style.display = "";
					document.getElementById("buttonDiv").style.display = "";
					document.getElementById("leftFrame").contentWindow.fixDivHeight("UNNORMAL");
					document.getElementById("mainFrame").contentWindow.fixDivHeight("UNNORMAL");
				}
			}

			function doItemDelete(id) {
				var tmpArr;
				var found = false;
				var index = 0;
				var i;
				for(i = 0; i < selectedArr.length; i++) {
					tmpArr = selectedArr[i];
					if(tmpArr[0] == id) {
						found = true;
						index = i;
						break;
					}
				}
				if(found) {
					selectedArr = selectedArr.del(index);
					var tbl = document.getElementById("selectedTbl");
					var tr = document.getElementById("itemTr" + id);
					tbl.removeChild(tr);
				}
				showOrHidDiv();
			}

			function doOk() {
				if(selectedArr.length > 0) {
					alert(selectedArr);
					parent.popRetVal = selectedArr;
					parent.layer.closeAll();
				} else {
					ShowAlert('请选择材料！', {title:'提示框'});
				}
			}

			function doInit() {
//				document.getElementById("mainDiv").style.width = (document.getElementById("mainTd").clientWidth - document.getElementById("navDiv").offsetWidth) + "px";
				document.getElementById("mainFrame").src = "base/ProductListForSelect.html?type=&stock=&sto_id=&stoc_type=UPPER_ZERO";
			}
			//子窗口调用
			function doProNewCallBack() {
				alert(popRetVal);
				if(popRetVal != null) {
					document.getElementById("mainFrame").contentWindow.doNewCallBack(popRetVal);
				}
			}
		</script>
	</body>

</html>