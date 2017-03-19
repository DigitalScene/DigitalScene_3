<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="bjui-leftside">
    <div id="bjui-sidebar-s">
        <div class="collapse"></div>
    </div>
    <div id="bjui-sidebar">
        <div class="toggleCollapse"><h2><i class="fa fa-bars"></i> 导航栏 <i class="fa fa-bars"></i></h2><a href="javascript:;" class="lock"><i class="fa fa-lock"></i></a></div>
        <div class="panel-group panel-main" data-toggle="accordion" id="bjui-accordionmenu" data-heightbox="#bjui-sidebar" data-offsety="26">

            <%--<%--%>
                <%--String roleTypeName=(String) request.getAttribute("roleType");--%>
                <%--if (roleTypeName.equals("admin")){--%>
            <%--%>--%>
            <%--项目模块列表 start--%>
            <div class="panel panel-default">
                <div class="panel-heading panelContent">
                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse1" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;项目管理模块</a></h4>
                </div>
                <div id="bjui-collapse1" class="panel-collapse panelContent collapse in">
                    <div class="panel-body" >
                        <ul id="bjui-tree1" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                            <li data-id="project" data-pid="1">项目信息</li>
                            <li data-id="project_0" data-pid="project" data-url="<%=request.getContextPath()%>/admin/project/projectList" data-tabid="project_0" data-fresh="true" data-reloadWarn="true">项目列表</li>
                            <%--<li data-id="project_1" data-pid="project" data-url="<%=request.getContextPath()%>/project/moduleToAppointList" data-tabid="project_1" data-fresh="true" data-reloadWarn="true">待指派</li>--%>
                            <%--<li data-id="project_1" data-pid="project" data-url="<%=request.getContextPath()%>/project/moduleToCheckList" data-tabid="project_1" data-fresh="true" data-reloadWarn="true">待审核</li>--%>
                            <li data-id="project_1" data-pid="project" data-url="<%=request.getContextPath()%>/admin/project/finishList" data-tabid="project_1" data-fresh="true" data-reloadWarn="true">已完成</li>
                        </ul>
                    </div>
                </div>
                <div class="panelFooter"><div class="panelFooterContent"></div></div>
            </div>
            <%--<%--%>
                <%--}--%>
            <%--%>--%>


                  <%--必须模块列表 start--%>
              <div class="panel panel-default">
                  <div class="panel-heading panelContent">
                      <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse2" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;必须模块</a></h4>
                  </div>
                  <div id="bjui-collapse2" class="panel-collapse panelContent collapse <%--<%if (!roleTypeName.equals("admin")) {%>in<%} %>--%>">
                      <div class="panel-body" >
                          <ul id="bjui-tree2" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                              <li data-id="dataUpload" data-pid="1">1.数据上传模块</li>
                              <%--<% if (!roleTypeName.equals("admin")) {%>--%>
                              <li data-id="dataUpload_1" data-pid="dataUpload" data-url="<%=request.getContextPath()%>/admin/dataUpload/toDealWithList" data-tabid="dataUpload_1" data-fresh="true" data-reloadWarn="true">待处理</li>
                              <%--<%}else {%>--%>
                              <li data-id="dataUpload_0" data-pid="dataUpload" data-url="<%=request.getContextPath()%>/admin/dataUpload/toAppointList" data-tabid="dataUpload_0" data-fresh="true" data-reloadWarn="true">待指派</li>
                              <li data-id="dataUpload_2" data-pid="dataUpload" data-url="<%=request.getContextPath()%>/admin/dataUpload/toCheckList" data-tabid="dataUpload_2" data-fresh="true" data-reloadWarn="true">待审核</li>
                              <%--<%}%>--%>
                              <li data-id="dataUpload_3" data-pid="dataUpload" data-url="<%=request.getContextPath()%>/admin/dataUpload/toFinishList" data-tabid="dataUpload_3" data-fresh="true" data-reloadWarn="true">已完成</li>
                              <li data-id="photoEdit" data-pid="2">2.原始图编辑模块</li>
                              <%--<% if (!roleTypeName.equals("admin")) {%>--%>
                              <li data-id="photoEdit_1" data-pid="photoEdit" data-url="<%=request.getContextPath()%>/admin/photoEdit/toDealWithList" data-tabid="photoEdit_1" data-fresh="true" data-reloadWarn="true">待处理</li>
                              <%--<%}else {%>--%>
                              <li data-id="photoEdit_0" data-pid="photoEdit" data-url="<%=request.getContextPath()%>/admin/photoEdit/toAppointList" data-tabid="photoEdit_0" data-fresh="true" data-reloadWarn="true">待指派</li>
                              <li data-id="photoEdit_2" data-pid="photoEdit" data-url="<%=request.getContextPath()%>/admin/photoEdit/toCheckList" data-tabid="photoEdit_2" data-fresh="true" data-reloadWarn="true">待审核</li>
                              <%--<%}%>--%>
                              <li data-id="photoEdit_3" data-pid="photoEdit" data-url="<%=request.getContextPath()%>/admin/photoEdit/toFinishList" data-tabid="photoEdit_3" data-fresh="true" data-reloadWarn="true">已完成</li>
                              <li data-id="photoMade" data-pid="3">3.球形图制作模块</li>
                              <%--<% if (!roleTypeName.equals("admin")) {%>--%>
                              <li data-id="photoMade_1" data-pid="photoMade" data-url="<%=request.getContextPath()%>/admin/photoMade/toDealWithList" data-tabid="photoMade_1" data-fresh="true" data-reloadWarn="true">待处理</li>
                              <%--<%}else {%>--%>
                              <li data-id="photoMade_0" data-pid="photoMade" data-url="<%=request.getContextPath()%>/admin/photoMade/toAppointList" data-tabid="photoMade_0" data-fresh="true" data-reloadWarn="true">待指派</li>
                              <li data-id="photoMade_2" data-pid="photoMade" data-url="<%=request.getContextPath()%>/admin/photoMade/toCheckList" data-tabid="photoMade_2" data-fresh="true" data-reloadWarn="true">待审核</li>
                              <%--<%}%>--%>
                              <li data-id="photoMade_3" data-pid="photoMade" data-url="<%=request.getContextPath()%>/admin/photoMade/toFinishList" data-tabid="photoMade_3" data-fresh="true" data-reloadWarn="true">已完成</li>
                              <li data-id="sceneMade" data-pid="4">4.场景构建模块</li>
                              <%--<% if (!roleTypeName.equals("admin")) {%>--%>
                              <li data-id="sceneMade_1" data-pid="sceneMade" data-url="<%=request.getContextPath()%>/admin/sceneMade/toDealWithList" data-tabid="sceneMade_1" data-fresh="true" data-reloadWarn="true">待处理</li>
                              <%--<%}else {%>--%>
                              <li data-id="sceneMade_0" data-pid="sceneMade" data-url="<%=request.getContextPath()%>/admin/sceneMade/toAppointList" data-tabid="sceneMade_0" data-fresh="true" data-reloadWarn="true">待指派</li>
                              <li data-id="sceneMade_2" data-pid="sceneMade" data-url="<%=request.getContextPath()%>/admin/sceneMade/toCheckList" data-tabid="sceneMade_2" data-fresh="true" data-reloadWarn="true">待审核</li>
                              <%--<%}%>--%>
                              <li data-id="sceneMade_3" data-pid="sceneMade" data-url="<%=request.getContextPath()%>/admin/sceneMade/toFinishList" data-tabid="sceneMade_3" data-fresh="true" data-reloadWarn="true">已完成</li>
                              <li data-id="dataIntegration" data-pid="5">5.数据整合模块</li>
                              <%--<% if (!roleTypeName.equals("admin")) {%>--%>
                              <li data-id="dataIntegration_1" data-pid="dataIntegration" data-url="<%=request.getContextPath()%>/admin/dataIntegration/toDealWithList" data-tabid="dataIntegration_1" data-fresh="true" data-reloadWarn="true">待处理</li>
                              <%--<%}else {%>--%>
                              <li data-id="dataIntegration_0" data-pid="dataIntegration" data-url="<%=request.getContextPath()%>/admin/dataIntegration/toAppointList" data-tabid="dataIntegration_0" data-fresh="true" data-reloadWarn="true">待指派</li>
                              <li data-id="dataIntegration_2" data-pid="dataIntegration" data-url="<%=request.getContextPath()%>/admin/dataIntegration/toCheckList" data-tabid="dataIntegration_2" data-fresh="true" data-reloadWarn="true">待审核</li>
                              <%--<%}%>--%>
                              <li data-id="dataIntegration_3" data-pid="dataIntegration" data-url="<%=request.getContextPath()%>/admin/dataIntegration/toFinishList" data-tabid="dataIntegration_3" data-fresh="true" data-reloadWarn="true">已完成</li>
                          </ul>
                      </div>
                  </div>
                  <div class="panelFooter"><div class="panelFooterContent"></div></div>
              </div>

                      <%--非必须模块列表 start--%>
                      <div class="panel panel-default">
                          <div class="panel-heading panelContent">
                              <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse3" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;非必须模块</a></h4>
                          </div>
                          <div id="bjui-collapse3" class="panel-collapse panelContent collapse">
                              <div class="panel-body" >
                                  <ul id="bjui-tree3" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                                      <li data-id="mp3Edit" data-pid="1">音频编辑模块</li>
                                      <%--<% if (!roleTypeName.equals("admin")) {%>--%>
                                      <li data-id="mp3Edit_1" data-pid="mp3Edit" data-url="<%=request.getContextPath()%>/admin/mp3Edit/toDealWithList" data-tabid="mp3Edit_1" data-fresh="true" data-reloadWarn="true">待处理</li>
                                      <%--<%}else {%>--%>
                                      <li data-id="mp3Edit_0" data-pid="mp3Edit" data-url="<%=request.getContextPath()%>/admin/mp3Edit/toAppointList" data-tabid="mp3Edit_0" data-fresh="true" data-reloadWarn="true">待指派</li>
                                      <li data-id="mp3Edit_2" data-pid="mp3Edit" data-url="<%=request.getContextPath()%>/admin/mp3Edit/toCheckList" data-tabid="mp3Edit_2" data-fresh="true" data-reloadWarn="true">待审核</li>
                                      <%--<%}%>--%>
                                      <li data-id="mp3Edit_3" data-pid="mp3Edit" data-url="<%=request.getContextPath()%>/admin/mp3Edit/toFinishList" data-tabid="mp3Edit_3" data-fresh="true" data-reloadWarn="true">已完成</li>
                                      <li data-id="videoEdit" data-pid="2">视频编辑模块</li>
                                      <%--<% if (!roleTypeName.equals("admin")) {%>--%>
                                      <li data-id="videoEdit_1" data-pid="videoEdit" data-url="<%=request.getContextPath()%>/admin/videoEdit/toDealWithList" data-tabid="videoEdit_1" data-fresh="true" data-reloadWarn="true">待处理</li>
                                      <%--<%}else {%>--%>
                                      <li data-id="videoEdit_0" data-pid="videoEdit" data-url="<%=request.getContextPath()%>/admin/videoEdit/toAppointList" data-tabid="videoEdit_0" data-fresh="true" data-reloadWarn="true">待指派</li>
                                      <li data-id="videoEdit_2" data-pid="videoEdit" data-url="<%=request.getContextPath()%>/admin/videoEdit/toCheckList" data-tabid="videoEdit_2" data-fresh="true" data-reloadWarn="true">待审核</li>
                                      <%--<%}%>--%>
                                      <li data-id="videoEdit_3" data-pid="videoEdit" data-url="<%=request.getContextPath()%>/admin/videoEdit/toFinishList" data-tabid="videoEdit_3" data-fresh="true" data-reloadWarn="true">已完成</li>
                                      <li data-id="thrDModelMade" data-pid="3">3D模型制作模块</li>
                                      <%--<% if (!roleTypeName.equals("admin")) {%>--%>
                                      <li data-id="thrDModelMade_1" data-pid="thrDModelMade" data-url="<%=request.getContextPath()%>/admin/thrDModelMade/toDealWithList" data-tabid="thrDModelMade_1" data-fresh="true" data-reloadWarn="true">待处理</li>
                                      <%--<%}else {%>--%>
                                      <li data-id="thrDModelMade_0" data-pid="thrDModelMade" data-url="<%=request.getContextPath()%>/admin/thrDModelMade/toAppointList" data-tabid="thrDModelMade_0" data-fresh="true" data-reloadWarn="true">待指派</li>
                                      <li data-id="thrDModelMade_2" data-pid="thrDModelMade" data-url="<%=request.getContextPath()%>/admin/thrDModelMade/toCheckList" data-tabid="thrDModelMade_2" data-fresh="true" data-reloadWarn="true">待审核</li>
                                      <%--<%}%>--%>
                                      <li data-id="thrDModelMade_3" data-pid="thrDModelMade" data-url="<%=request.getContextPath()%>/admin/thrDModelMade/toFinishList" data-tabid="thrDModelMade_3" data-fresh="true" data-reloadWarn="true">已完成</li>
                                      <li data-id="subtitileEdit" data-pid="4">字幕编辑模块</li>
<%--//                                      <% if (!roleTypeName.equals("admin")) {%>--%>
                                      <li data-id="subtitileEdit_1" data-pid="subtitileEdit" data-url="<%=request.getContextPath()%>/admin/subtitleEdit/toDealWithList" data-tabid="subtitileEdit_1" data-fresh="true" data-reloadWarn="true">待处理</li>
                                      <%--<%}else {%>--%>
                                      <li data-id="subtitileEdit_0" data-pid="subtitileEdit" data-url="<%=request.getContextPath()%>/admin/subtitleEdit/toAppointList" data-tabid="subtitileEdit_0" data-fresh="true" data-reloadWarn="true">待指派</li>
                                      <li data-id="subtitileEdit_2" data-pid="subtitileEdit" data-url="<%=request.getContextPath()%>/admin/subtitleEdit/toCheckList" data-tabid="subtitileEdit_2" data-fresh="true" data-reloadWarn="true">待审核</li>
                                      <%--<%}%>--%>
                                      <li data-id="subtitileEdit_3" data-pid="subtitileEdit" data-url="<%=request.getContextPath()%>/admin/subtitleEdit/toFinishList" data-tabid="subtitileEdit_3" data-fresh="true" data-reloadWarn="true">已完成</li>
                                  </ul>
                              </div>
                          </div>
                          <div class="panelFooter"><div class="panelFooterContent"></div></div>
                      </div>

            <%
//                if (roleTypeName.equals("admin")){
            %>
            <%--人员管理模块--%>
            <div class="panel panel-default">
                <div class="panel-heading panelContent">
                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse4" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;人员管理模块</a></h4>
                </div>
                <div id="bjui-collapse4" class="panel-collapse panelContent collapse">
                    <div class="panel-body" >
                        <ul id="bjui-tree4" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                            <li data-id="admin" data-pid="1">人员管理</li>
                            <li data-id="admin_0" data-pid="admin" data-url="<%=request.getContextPath()%>/user/userList" data-tabid="admin_0" data-fresh="true" data-reloadWarn="true">人员操作</li>
                        </ul>
                    </div>
                </div>
                <div class="panelFooter"><div class="panelFooterContent"></div></div>
            </div>
            <%--人员管理模块 end--%>
            <%
//                }
            %>


        </div>
    </div>
</div>