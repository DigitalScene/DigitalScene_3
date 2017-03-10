<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bjui-pageContent">
     <form action="${pageContext.request.contextPath}/user/updatePassword" data-toggle="validate" data-reload-navtab="true" method="post">
         <input type="hidden" name="id" value="${id}">
         <div class="pageFormContent" data-layout-h="0">
             <table class="table table-condensed table-hover" width="100%">
                 <tbody>
                           <tr>
                               <td colspan="2">
                                   <label class="control-label x100">原密码：</label>
                                   <input type="password" data-rule="密码:required" name="oldPassword" value="" size="40">
                               </td>
                           </tr>
                           <tr>
                               <td colspan="2">
                                   <label class="control-label x100">新密码：</label>
                                   <input type="password" data-rule="密码:required" name="password" value="" size="40">
                               </td>
                           </tr>
                           <tr>
                               <td colspan="2">
                                   <label class="control-label x100">新密码确认：</label>
                                   <input type="password" data-rule="确认密码:required;match(password)" value="" size="40">
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


