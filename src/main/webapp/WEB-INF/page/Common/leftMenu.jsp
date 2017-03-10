<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="bjui-leftside">
    <div id="bjui-sidebar-s">
        <div class="collapse"></div>
    </div>
    <div id="bjui-sidebar">
        <div class="toggleCollapse"><h2><i class="fa fa-bars"></i> 导航栏 <i class="fa fa-bars"></i></h2><a href="javascript:;" class="lock"><i class="fa fa-lock"></i></a></div>
        <div class="panel-group panel-main" data-toggle="accordion" id="bjui-accordionmenu" data-heightbox="#bjui-sidebar" data-offsety="26">

                  <%--必须模块列表 start--%>
              <div class="panel panel-default">
                  <div class="panel-heading panelContent">
                      <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse1" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;必须模块</a></h4>
                  </div>
                  <div id="bjui-collapse1" class="panel-collapse panelContent collapse in">
                      <div class="panel-body" >
                          <ul id="bjui-tree1" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                              <li data-id="shop" data-pid="1">用户数据上传模块</li>
                              <li data-id="shop_0" data-pid="shop" data-url="<%=request.getContextPath()%>/admin/shop/list" data-tabid="shop_0" data-fresh="true" data-reloadWarn="true">场景数据上传管理</li>
                              <%--<li data-id="shop_1" data-pid="shop" data-url="<%=request.getContextPath()%>/admin/shunShop/list" data-tabid="shop_1" data-fresh="true" data-reloadWarn="true">瞬时秒杀</li>--%>
                              <li data-id="advert" data-pid="2">原始图片编辑模块</li>
                              <li data-id="advert_0" data-pid="advert" data-url="<%=request.getContextPath()%>/admin/advert/list" data-tabid="advert_0" data-fresh="true" data-reloadWarn="true">广告操作</li>
                              <li data-id="firstPhoto" data-pid="3">球形图制作模块</li>
                              <li data-id="firstPhoto_0" data-pid="firstPhoto" data-url="<%=request.getContextPath()%>/admin/firstPhoto/list" data-tabid="firstPhoto_0" data-fresh="true" data-reloadWarn="true">首页图片操作</li>
                              <li data-id="adminOrder" data-pid="4">场景构建模块</li>
                              <li data-id="adminOrder_0" data-pid="adminOrder" data-url="<%=request.getContextPath()%>/admin/orders/list" data-tabid="adminOrder_0" data-fresh="true" data-reloadWarn="true">订单列表</li>
                              <li data-id="adminProfit" data-pid="5">数据整合模块</li>
                              <li data-id="adminProfit_0" data-pid="adminProfit" data-url="<%=request.getContextPath()%>/admin/profit/list" data-tabid="adminProfit_0" data-fresh="true" data-reloadWarn="true">统计收益</li>
                              <li data-id="adminProfit_1" data-pid="adminProfit" data-url="<%=request.getContextPath()%>/admin/profit/tiXian" data-tabid="adminProfit_1" data-fresh="true" data-reloadWarn="true">查看店主提现</li>
                          </ul>
                      </div>
                  </div>
                  <div class="panelFooter"><div class="panelFooterContent"></div></div>
              </div>

                      <%--非必须模块列表 start--%>
                      <div class="panel panel-default">
                          <div class="panel-heading panelContent">
                              <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse2" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;非必须模块</a></h4>
                          </div>
                          <div id="bjui-collapse2" class="panel-collapse panelContent collapse">
                              <div class="panel-body" >
                                  <ul id="bjui-tree2" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                                      <li data-id="adminProfit1" data-pid="1">音频文件编辑模块</li>
                                      <li data-id="adminProfit1_0" data-pid="adminProfit1" data-url="<%=request.getContextPath()%>/admin/profit/list" data-tabid="adminProfit1_0" data-fresh="true" data-reloadWarn="true">统计收益</li>
                                      <li data-id="adminProfit1_1" data-pid="adminProfit1" data-url="<%=request.getContextPath()%>/admin/profit/tiXian" data-tabid="adminProfit1_1" data-fresh="true" data-reloadWarn="true">查看店主提现</li>
                                      <li data-id="adminProfit2" data-pid="2">视频文件编辑模块</li>
                                      <li data-id="adminProfit2_0" data-pid="adminProfit2" data-url="<%=request.getContextPath()%>/admin/profit/list" data-tabid="adminProfit2_0" data-fresh="true" data-reloadWarn="true">统计收益</li>
                                      <li data-id="adminProfit2_1" data-pid="adminProfit2" data-url="<%=request.getContextPath()%>/admin/profit/tiXian" data-tabid="adminProfit2_1" data-fresh="true" data-reloadWarn="true">查看店主提现</li>
                                      <li data-id="adminProfit3" data-pid="3">3D模型制作模块</li>
                                      <li data-id="adminProfit3_0" data-pid="adminProfit3" data-url="<%=request.getContextPath()%>/admin/profit/list" data-tabid="adminProfit3_0" data-fresh="true" data-reloadWarn="true">统计收益</li>
                                      <li data-id="adminProfit3_1" data-pid="adminProfit3" data-url="<%=request.getContextPath()%>/admin/profit/tiXian" data-tabid="adminProfit3_1" data-fresh="true" data-reloadWarn="true">查看店主提现</li>
                                      <li data-id="adminProfit4" data-pid="4">字幕文件编辑模块</li>
                                      <li data-id="adminProfit4_0" data-pid="adminProfit4" data-url="<%=request.getContextPath()%>/admin/profit/list" data-tabid="adminProfit4_0" data-fresh="true" data-reloadWarn="true">统计收益</li>
                                      <li data-id="adminProfit4_1" data-pid="adminProfit4" data-url="<%=request.getContextPath()%>/admin/profit/tiXian" data-tabid="adminProfit4_1" data-fresh="true" data-reloadWarn="true">查看店主提现</li>
                                  </ul>
                              </div>
                          </div>
                          <div class="panelFooter"><div class="panelFooterContent"></div>
                      </div>

                   <%--人员管理模块--%>
                  <div class="panel panel-default">
                        <div class="panel-heading panelContent">
                            <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse3" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;人员管理模块</a></h4>
                        </div>
                        <div id="bjui-collapse3" class="panel-collapse panelContent collapse">
                            <div class="panel-body" >
                                <ul id="bjui-tree3" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                                    <li data-id="admin" data-pid="1">人员管理</li>
                                    <li data-id="admin_0" data-pid="admin" data-url="<%=request.getContextPath()%>/user/userList" data-tabid="admin_0" data-fresh="true" data-reloadWarn="true">人员操作</li>
                                </ul>
                            </div>
                        </div>
                        <div class="panelFooter"><div class="panelFooterContent"></div></div>
                  </div>
                  <%--人员管理模块 end--%>

        </div>
    </div>
</div>