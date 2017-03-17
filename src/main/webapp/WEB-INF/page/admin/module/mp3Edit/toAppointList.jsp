<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<style>
    .project{text-align: center;}
</style>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/mp3Edit/toAppointList" method="post">
        <input type="hidden" name="pageSize" value="${appointList.size}">
        <input type="hidden" name="pageNumbers" value="<fmt:formatNumber value='${appointList.totalElements/appointList.size+((appointList.totalElements/appointList.size)%1==0?0:0.5)}' type="number" pattern='#,###,###,###'/>">
        <input type="hidden" name="pageCurrent" value="${appointList.number+1}">
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
            <th data-order-field="projectName" class="project" >项目名称</th>
            <th data-order-field="createTime" class="project" >创建时间</th>
            <th data-order-field="creator" class="project">创建者</th>
            <th class="project">音频编辑模块状态</th>
            <th class="project">上次指派被拒绝的原因</th>
            <th data-order-field="status" class="project">项目状态</th>
            <th class="project" style="width: 140px;">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${appointList.content}" varStatus="i">
            <tr >
                <td class="project">${i.index+1}</td>
                <td class="project">${list.projectName}</td>
                <td class="project">${list.getCreateTimeString()}</td>
                <td class="project">${list.creator}</td>
                <td class="project">${list.getMp3EditStatus()}</td>
                <td class="project">${list.mp3Edit.mp3EditPeople_reason}</td>
                <td class="project">${list.getProjectStatus()}</td>
                <td class="project">
                    <a href="${pageContext.request.contextPath}/common/module/toAppoint?id=${list.id}&type=mp3Edit" class="btn btn-info" data-toggle="dialog" data-width="500" data-height="160" data-id="dialog-mask" data-mask="true">指派</a>
                </td>
            </tr>
        </c:forEach>

        <%--列表为空时--%>
        <c:if test="${appointList==null}">
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
                <option value="5" <c:if test="${appointList.size==5}">selected</c:if>>5</option>
                <option value="10" <c:if test="${appointList.size==10}">selected</c:if>>10</option>
                <option value="20" <c:if test="${appointList.size==20}">selected</c:if>>20</option>
                <option value="50" <c:if test="${appointList.size==50}">selected</c:if>>50</option>

            </select>
        </div>
        <span>&nbsp;条，共 ${appointList.totalElements} 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${appointList.totalElements}" data-page-size="${appointList.size}" data-page-current="${appointList.number+1}">
    </div>
</div>