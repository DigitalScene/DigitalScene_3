<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<style>
    .project{text-align: center;}
</style>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/admin/photoMade/toCheckList" method="post">
        <input type="hidden" name="pageSize" value="${checkList.size}">
        <input type="hidden" name="pageNumbers" value="<fmt:formatNumber value='${checkList.totalElements/checkList.size+((checkList.totalElements/checkList.size)%1==0?0:0.5)}' type="number" pattern='#,###,###,###'/>">
        <input type="hidden" name="pageCurrent" value="${checkList.number+1}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>项目名称：</label><input type="text" name="projectName" value="${projectName}" class="form-control" size="10" />
            <label>创建时间：</label><input type="text" name="createTime" data-toggle="datepicker" value="${createTime}" class="form-control" size="10" />
            <button type="submit" class="btn-default" data-icon="search">查询</button>
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        </div>
    </form>
</div>

<div class="bjui-pageContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th class="project">序号</th>
            <th data-order-field="projectName" class="project" style="width: 100px;">项目名称</th>
            <th data-order-field="createTime" class="project" style="width: 90px;">创建时间</th>
            <th data-order-field="creator" class="project">创建者</th>
            <th data-order-field="creator" class="project">指派者</th>
            <th data-order-field="creator" class="project" style="width: 90px;">指派时间</th>
            <th class="project">球形图制作者</th>
            <th class="project" style="width: 90px;">制作完成时间</th>
            <th class="project">球形图制作模块状态</th>
            <th data-order-field="status" class="project">项目状态</th>
            <th class="project" style="width: 164px;">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${checkList.content}" varStatus="i">
            <tr >
                <td class="project">${i.index+1}</td>
                <td class="project">${list.projectName}</td>
                <td class="project">${list.getCreateTimeString()}</td>
                <td class="project">${list.creator}</td>
                <td class="project">${list.photoMade.photoMadeToAppointPeople}</td>
                <td class="project">${list.photoMade.getPhotoMadeToAppointDateStr()}</td>
                <td class="project">${list.photoMade.photoMadePeople}</td>
                <td class="project">${list.photoMade.getPhotoMadeFinishDateStr()}</td>
                <td class="project">${list.getPhotoMadeStatus()}</td>
                <td class="project">${list.getProjectStatus()}</td>
                <td class="project">
                    <a href="${pageContext.request.contextPath}/admin/photoMade/toCheck?photoMadeId=${list.photoMade.id}" class="btn btn-info" data-toggle="dialog" data-width="500" data-height="300" data-id="dialog-mask" data-mask="true"  >审核</a>
                    <a href="${pageContext.request.contextPath}/admin/photoMade/toCheckFinish?id=${list.id}" class="btn btn-default" data-toggle="doajax" data-confirm-msg="确定要审核完成吗？" >审核完成</a>
                </td>
            </tr>
        </c:forEach>

        <%--列表为空时--%>
        <c:if test="${checkList==null}">
            <tr><td colspan="15" style="text-align: center;color: red;font-size: 14px">没有要显示的数据</td></tr>
        </c:if>
        </tbody>
    </table>
</div>

<div class="bjui-pageFooter">
    <div class="pages">
        <span>每页&nbsp;</span>
        <div class="selectPagesize">
            <select data-toggle="selectpicker" data-toggle-change="changepagesize">
                <option value="5" <c:if test="${checkList.size==5}">selected</c:if>>5</option>
                <option value="10" <c:if test="${checkList.size==10}">selected</c:if>>10</option>
                <option value="20" <c:if test="${checkList.size==20}">selected</c:if>>20</option>
                <option value="50" <c:if test="${checkList.size==50}">selected</c:if>>50</option>

            </select>
        </div>
        <span>&nbsp;条，共 ${checkList.totalElements} 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${checkList.totalElements}" data-page-size="${checkList.size}" data-page-current="${checkList.number+1}">
    </div>

</div>
