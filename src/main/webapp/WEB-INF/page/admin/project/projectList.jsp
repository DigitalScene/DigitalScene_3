<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<style>
    .project{text-align: center;}
</style>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/admin/project/projectList" method="post">
        <input type="hidden" name="pageSize" value="${projectsList.size}">
        <input type="hidden" name="pageNumbers" value="<fmt:formatNumber value='${projectsList.totalElements/projectsList.size+((projectsList.totalElements/projectsList.size)%1==0?0:0.5)}' type="number" pattern='#,###,###,###'/>">
        <input type="hidden" name="pageCurrent" value="${projectsList.number+1}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>项目名称：</label><input type="text" name="projectName" value="${projectName}" class="form-control" size="10" />
            <label>创建时间：</label><input type="text" name="createTime" data-toggle="datepicker" value="${createTime}" class="form-control" size="10" />
            <label>状态：</label>
            <select name='status' class="selectpicker" data-toggle='selectpicker' data-width="100">
                <option value="" <c:if test="${status==null}">selected</c:if> >--请选择--</option>
                <option value="0" <c:if test="${status==0}">selected</c:if> >未开始</option>
                <option value="1" <c:if test="${status==1}">selected</c:if> >进行中</option>
                <option value="2" <c:if test="${status==2}">selected</c:if> >已完成</option>
            </select>
            <button type="submit" class="btn-default" data-icon="search">查询</button>
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div class="pull-right">
                <div class="btn-group">
                     <button type="button" class="btn-default" ><a href="${pageContext.request.contextPath}/admin/project/add" data-toggle="dialog" data-width="900" data-height="360" data-id="dialog-mask" data-mask="true" style="text-decoration: none;"><i class="fa fa-plus"></i> 添加新项目</a></button>
                </div>
            </div>
        </div>
    </form>
</div>

<div class="bjui-pageContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th colspan="4" class="project">基本信息</th>
            <th colspan="5" class="project">必须模块（状态）</th>
            <th colspan="4" class="project">非必须模块（状态）</th>
            <th colspan="3" class="project">其他</th>
        </tr>
        <tr>
            <th class="project">序号</th>
            <th data-order-field="projectName" class="project" style="width: 100px;">项目名称</th>
            <th data-order-field="createTime" class="project" style="width: 90px;">创建时间</th>
            <th data-order-field="creator" class="project">创建者</th>
            <th class="project">1.数据上传</th>
            <th class="project">2.原始图编辑</th>
            <th class="project">3.球形图制作</th>
            <th class="project">4.场景构建</th>
            <th class="project">5.数据整合</th>
            <th class="project">音频编辑</th>
            <th class="project">视频编辑</th>
            <th class="project">3D模型制作</th>
            <th class="project">字幕编辑</th>
            <th data-order-field="status" class="project">状态</th>
            <th class="project">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${projectsList.content}" varStatus="i">
            <tr >
                <td class="project">${i.index+1}</td>
                <td class="project">${list.projectName}</td>
                <td class="project">${list.getCreateTimeString()}</td>
                <td class="project">${list.creator}</td>
                <td class="project">${list.getDataUploadStatus()}</td>
                <td class="project">${list.getPhotoEditStatus()}</td>
                <td class="project">${list.getPhotoMadeStatus()}</td>
                <td class="project">${list.getSceneMadeStatus()}</td>
                <td class="project">${list.getDataIntegrationStatus()}</td>
                <td class="project">${list.getMp3EditStatus()}</td>
                <td class="project">${list.getVideoEditStatus()}</td>
                <td class="project">${list.getThrDModelMadeStatus()}</td>
                <td class="project">${list.getSubtitleEditStatus()}</td>
                <td class="project">${list.getProjectStatus()}</td>
                <td class="project">
                    <a href="${pageContext.request.contextPath}/admin/project/startup?id=${list.id}" class="btn btn-info" data-toggle="doajax" data-confirm-msg="确定要启动项目么？" <c:if test="${list.status!=0}">disabled="disabled"</c:if> >启动项目</a>
                    <a href="${pageContext.request.contextPath}/admin/project/add?id=${list.id}" class="btn btn-default" data-toggle="dialog" data-width="900" data-height="360" data-id="dialog-mask" data-mask="true">编辑</a>
                    <a href="${pageContext.request.contextPath}/admin/project/delete?id=${list.id}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
                </td>
            </tr>
        </c:forEach>

        <%--列表为空时--%>
        <c:if test="${projectsList==null}">
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
                <option value="5" <c:if test="${projectsList.size==5}">selected</c:if>>5</option>
                <option value="10" <c:if test="${projectsList.size==10}">selected</c:if>>10</option>
                <option value="20" <c:if test="${projectsList.size==20}">selected</c:if>>20</option>
                <option value="50" <c:if test="${projectsList.size==50}">selected</c:if>>50</option>

            </select>
        </div>
        <span>&nbsp;条，共 ${projectsList.totalElements} 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${projectsList.totalElements}" data-page-size="${projectsList.size}" data-page-current="${projectsList.number+1}">
    </div>
</div>