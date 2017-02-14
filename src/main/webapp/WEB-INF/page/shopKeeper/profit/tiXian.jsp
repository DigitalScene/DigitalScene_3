<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bjui-pageContent">
     <form action="${pageContext.request.contextPath}/admin/shopKeeper/profit/tiXian" data-toggle="validate" data-reload-navtab="true" method="post">
         <div class="pageFormContent" data-layout-h="0">
             <div style="padding: 5px;"></div>
             <table class="table table-condensed table-hover" width="100%" >
                 <thead>
                 <label>提现</label>
                 </thead>
                 <tbody>
                       <tr >
                           <td colspan="2" style="width: 50%;">
                               <label class="control-label x70">金额：</label>
                               <input type="text" data-rule="required" name="money" value="" size="20">元
                               <input type="hidden" name="shopKeeper" value="${shopKeeper}">
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

