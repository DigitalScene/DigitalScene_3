<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<style>
    .project{text-align: center;}
</style>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/admin/subtitleEdit/toDealWithList" method="post">
        <input type="hidden" name="pageSize" value="${dealWithList.size}">
        <input type="hidden" name="pageNumbers" value="<fmt:formatNumber value='${dealWithList.totalElements/dealWithList.size+((dealWithList.totalElements/dealWithList.size)%1==0?0:0.5)}' type="number" pattern='#,###,###,###'/>">
        <input type="hidden" name="pageCurrent" value="${dealWithList.number+1}">
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
            <th class="project">指派的编辑者</th>
            <th class="project">字幕编辑模块状态</th>
            <th data-order-field="status" class="project">项目状态</th>
            <th data-order-field="status" class="project">接受或拒绝</th>
            <th class="project" style="width: 164px;">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${dealWithList.content}" varStatus="i">
            <tr >
                <td class="project">${i.index+1}</td>
                <td class="project">${list.projectName}</td>
                <td class="project">${list.getCreateTimeString()}</td>
                <td class="project">${list.creator}</td>
                <td class="project">${list.subtitleEdit.subtitleEditToAppointPeople}</td>
                <td class="project">${list.subtitleEdit.getSubtitleEditToAppointDateStr()}</td>
                <td class="project">${list.subtitleEdit.subtitleEditPeople}</td>
                <td class="project">${list.getSubtitleEditStatus()}</td>
                <td class="project">${list.getProjectStatus()}</td>
                <td class="project">
                    <c:if test="${list.subtitleEdit.is_subtitleEditPeople!=1}">
                        <a href="${pageContext.request.contextPath}/admin/subtitleEdit/toAccept?id=${list.id}" class="btn btn-default" data-toggle="doajax" data-confirm-msg="确定要接受处理吗？">接受</a>
                        <a href="${pageContext.request.contextPath}/admin/common/module/toReject?id=${list.id}&type=subtitleEdit" class="btn btn-red" data-toggle="dialog" data-width="680" data-height="240" data-id="dialog-mask" data-mask="true">拒绝</a>
                    </c:if>
                    <c:if test="${list.subtitleEdit.is_subtitleEditPeople==1}">
                        已接受
                    </c:if>
                </td>
                <td class="project">
                    <a href="${pageContext.request.contextPath}/admin/subtitleEdit/toDealWith?id=${list.id}" class="btn btn-info" data-toggle="dialog" data-width="500" data-height="300" data-id="dialog-mask" data-mask="true" <c:if test="${list.subtitleEdit.is_subtitleEditPeople!=1}">disabled="disabled" </c:if> >处理</a>
                    <a href="${pageContext.request.contextPath}/admin/subtitleEdit/toDealWithFinish?id=${list.id}" class="btn btn-default" data-toggle="doajax" data-confirm-msg="确定要处理完成吗？" <c:if test="${list.subtitleEdit.is_subtitleEditPeople!=1}">disabled="disabled" </c:if>>处理完成</a>
                </td>
            </tr>
        </c:forEach>

        <%--列表为空时--%>
        <c:if test="${dealWithList==null}">
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
                <option value="5" <c:if test="${dealWithList.size==5}">selected</c:if>>5</option>
                <option value="10" <c:if test="${dealWithList.size==10}">selected</c:if>>10</option>
                <option value="20" <c:if test="${dealWithList.size==20}">selected</c:if>>20</option>
                <option value="50" <c:if test="${dealWithList.size==50}">selected</c:if>>50</option>

            </select>
        </div>
        <span>&nbsp;条，共 ${dealWithList.totalElements} 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${dealWithList.totalElements}" data-page-size="${dealWithList.size}" data-page-current="${dealWithList.number+1}">
    </div>

</div>
