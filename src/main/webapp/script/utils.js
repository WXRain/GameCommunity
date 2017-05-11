
function createPage(pagingData, tdNum){
	if(pagingData.totalPage == 0) pagingData.totalPage = 1;
	if(pagingData.totalNum == 0){
		$("#table").append("<tr><td colspan=" + tdNum + "><hr/></td></tr>");
	}
	$("#table").append("<tr>");
	for(var i = 0; i < tdNum - 2; i++){
		$("#table").append("<td></td>");
	}
	$("#table").append("<td class='text-label'>第" + pagingData.currentPage + "页，共" + pagingData.totalPage + "页，共" + pagingData.totalNum + "条记录</td><td id='paging'></td></tr>");
	$("#paging").append("<a class='a-label' href=javascript:void() onclick=jumpToPage(" + 1 + ")> 首页 </a>");
	if(pagingData.currentPage != 1){
		$("#paging").append("<a class='a-label' href=javascript:void() onclick=jumpToPage(" + (pagingData.currentPage - 1) + ")> 上一页 </a>");
	}
	if(pagingData.currentPage != pagingData.totalPage){
		$("#paging").append("<a class='a-label' href=javascript:void() onclick=jumpToPage(" + (pagingData.currentPage + 1) + ")> 下一页 </a>");
	}
	$("#paging").append("<a class='a-label' href=javascript:void() onclick=jumpToPage(" + (pagingData.totalPage) + ")> 末页 </a>");
}

function showUser(userId){
	window.location.href = "../user/showUser.html?userId=" + userId;
}