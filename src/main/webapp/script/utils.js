	
function createPage(pagingData, tdNum){
	if(pagingData.totalPage == 0) pagingData.totalPage = 1;
	if(pagingData.currentPage == 0) pagingData.currentPage = 1;
	$("#table").append("<tr>")
	for(var i = 0; i < tdNum - 2; i++){
		$("#table").append("<td></td>");
	}
	$("#table").append("<td>第" + pagingData.currentPage + "页，共" + pagingData.totalPage + "页，共" + pagingData.totalNum + "条记录</td><td id='paging'></td></tr>");
	$("#paging").append("<a href=javascript:void() onclick=jumpToPage(" + 1 + ")> 首页 </a>");
	if(pagingData.currentPage != 1){
		$("#paging").append("<a href=javascript:void() onclick=jumpToPage(" + (pagingData.currentPage - 1) + ")> 上一页 </a>");
	}
	if(pagingData.currentPage != pagingData.totalPage){
		$("#paging").append("<a href=javascript:void() onclick=jumpToPage(" + (pagingData.currentPage + 1) + ")> 下一页 </a>");
	}
	$("#paging").append("<a href=javascript:void() onclick=jumpToPage(" + (pagingData.totalPage) + ")> 末页 </a>");
}