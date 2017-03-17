<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Calendar calendar=Calendar.getInstance();
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String nowDate=format.format(calendar.getTime());
%>
<div class="bjui-pageContent">
     <form action="${pageContext.request.contextPath}/project/add" data-toggle="validate" data-reload-navtab="true" method="post">
         <input type="hidden" name="id" value="${project.id}">
         <div class="pageFormContent" data-layout-h="0">
             <table class="table table-condensed table-hover" width="100%">
                 <tbody>
                       <tr>
                           <td colspan="2">
                               <label class="control-label x100">项目名称：</label>
                               <input type="text" data-rule="required" id="projectName" name="projectName" value="${project.projectName}" size="60" <c:if test="${project.status!=0&&project.status!=null}">readonly</c:if> >
                           </td>
                       </tr>
                       <tr>
                           <td colspan="2">
                               <label class="control-label x100">创建者：</label>
                               <input type="text" data-rule="required"  name="creator" value="${project.creator}" size="60" <c:if test="${project.status!=0&&project.status!=null}">readonly</c:if>>
                           </td>
                       </tr>
                       <tr>
                           <td colspan="2">
                               <label class="control-label x100">创建时间：</label>
                               <c:if test="${project.createTime==null||project.createTime.equals('')}">
                                   <input type="text" name="frontCreateTime" value="<%=nowDate%>" size="60">
                               </c:if>
                               <c:if test="${project.createTime!=null&&!project.createTime.equals('')}">
                                   <input type="text" name="frontCreateTime" value="${project.createTimeString}" size="60" <c:if test="${project.status!=0&&project.status!=null}">readonly</c:if>>
                               </c:if>
                           </td>
                       </tr>
                       <tr>
                           <td colspan="2">
                               <label class="control-label x100">项目描述：<br></label>
                               <div style="display: inline-block;vertical-align: middle;">
                                   <textarea name="description" style="width:600px;height:50px" <c:if test="${project.status!=0&&project.status!=null}">readonly</c:if> >${project.description}</textarea>
                               </div>
                           </td>
                       </tr>
                       <tr>
                           <td colspan="2">
                               <label class="control-label x100">必须模块：</label>
                               <input type="checkbox" data-toggle="icheck" data-label="数据上传模块" value="0" checked disabled/>
                               <input type="checkbox" data-toggle="icheck" data-label="原始图编辑模块" value="1" checked disabled/>
                               <input type="checkbox" data-toggle="icheck" data-label="球形图制作模块" value="2" checked disabled/>
                               <input type="checkbox" data-toggle="icheck" data-label="场景构建模块" value="3" checked disabled/>
                               <input type="checkbox" data-toggle="icheck" data-label="数据整合模块" value="4" checked disabled/>
                           </td>
                       </tr>
                       <tr>
                           <td colspan="2">
                               <label class="control-label x100">非必须模块：</label>
                               <input type="checkbox" name="nonessentialModels" data-toggle="icheck" data-label="音频编辑模块" value="mp3Edit" <c:if test="${project.is_mp3EditStatus!=6&&project.is_mp3EditStatus!=null}">checked</c:if> <c:if test="${project.status!=0&&project.status!=null}">disabled</c:if>/>
                               <input type="checkbox" name="nonessentialModels" data-toggle="icheck" data-label="视频编辑模块" value="videoEdit" <c:if test="${project.is_videoEditStatus!=6&&project.is_videoEditStatus!=null}">checked</c:if> <c:if test="${project.status!=0&&project.status!=null}">disabled</c:if>/>
                               <input type="checkbox" name="nonessentialModels" data-toggle="icheck" data-label="3D模型制作模块" value="thrDModelMade" <c:if test="${project.is_thrDModelMadeStatus!=6&&project.is_thrDModelMadeStatus!=null}">checked</c:if> <c:if test="${project.status!=0&&project.status!=null}">disabled</c:if>/>
                               <input type="checkbox" name="nonessentialModels" data-toggle="icheck" data-label="字幕编辑模块" value="subtitleEdit" <c:if test="${project.is_subtitleEditStatus!=6&&project.is_subtitleEditStatus!=null}">checked</c:if> <c:if test="${project.status!=0&&project.status!=null}">disabled</c:if>/>
                               <span class="alert-info">（注：可选可不选）</span>
                           </td>
                       </tr>
                       <c:if test="${project.status!=0&&project.status!=null}">
                           <tr>
                               <td colspan="2">
                                   <label class="control-label x120"></label>
                                   <div style="display: inline-block;padding: 10px;line-height: 24px;margin: 10px 0;border: 2px dashed #1F73B6">
                                       说明：项目进行中，不允许编辑
                                   </div>
                               </td>
                           </tr>
                       </c:if>

                 </tbody>
             </table>
         </div>
     </form>
</div>
<div class="bjui-pageFooter">
       <ul>
           <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
           <c:if test="${project.status==null||project.status==0}">
               <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
           </c:if>
       </ul>
</div>
<script>

</script>

