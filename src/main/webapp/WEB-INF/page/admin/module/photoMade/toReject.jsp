<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bjui-pageContent">
     <form action="${pageContext.request.contextPath}/admin/photoMade/toReject" data-toggle="validate" data-reload-navtab="true" method="post">
         <input type="hidden" name="id" value="${id}">
         <div class="pageFormContent" data-layout-h="0">
             <table class="table table-condensed table-hover" width="100%">
                 <tbody>
                       <tr>
                           <td colspan="2">
                               <label class="control-label x100">项目名称：</label>
                               <input type="text" data-rule="required"   value="${projectName}" size="20" readonly>
                           </td>
                       </tr>
                       <tr>
                           <td colspan="2">
                               <label class="control-label x100">拒绝原因：</label>
                               <div style="display: inline-block;vertical-align: middle;">
                                   <textarea name="photoMadePeopleReason" data-rule="required" data-rule-*="[^[\u4e00-\u9fa5]{1,50}$,'请低于50字']"  style="width:440px;height:50px"></textarea>
                               </div>
                           </td>
                       </tr>
                       <tr>
                           <td colspan="2">
                               <label class="control-label x120"></label>
                               <div style="display: inline-block;padding: 10px;line-height: 24px;margin: 10px 0;border: 2px dashed #1F73B6">
                                   说明：拒绝原因限50字
                               </div>
                           </td>
                       </tr>
                 </tbody>
             </table>
         </div>
     </form>
</div>
<div class="bjui-pageFooter">
       <ul>
           <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
           <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
       </ul>
</div>
<script>

</script>

