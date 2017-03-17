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
     <form action="${pageContext.request.contextPath}/sceneMade/toAppoint" data-toggle="validate" data-reload-navtab="true" method="post">
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
                               <label class="control-label x100">数据上传者：</label>
                               <select name='username' class="selectpicker" data-toggle='selectpicker' data-width="200">
                                   <option value=""  >--请选择--</option>
                                   <c:forEach items="${userLists}" var="list">
                                       <option value="${list.username}(${list.nickname})">${list.username}(${list.nickname})</option>
                                   </c:forEach>
                               </select>
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

