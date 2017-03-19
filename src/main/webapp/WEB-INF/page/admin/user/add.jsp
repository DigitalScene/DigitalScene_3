<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bjui-pageContent">
     <form action="${pageContext.request.contextPath}/user/add" data-toggle="validate" data-reload-navtab="true" method="post">
         <input type="hidden" name="id" value="${user.id}">
         <c:if test="${user!=null}">
             <input type="hidden" name="password" value="${user.password}">
         </c:if>
         <div class="pageFormContent" data-layout-h="0">
             <table class="table table-condensed table-hover" width="100%">
                 <tbody>
                       <tr>
                           <td colspan="2">
                               <label class="control-label x100">用户名：</label>
                               <input type="text" data-rule="required" id="username" name="username" value="${user.username}" size="40">
                               <a href="#" id="checkUsername" ><input type="button" value="检测用户名是否已存在"></a>
                           </td>
                       </tr>
                       <tr>
                           <td colspan="2">
                               <label class="control-label x100">昵称：</label>
                               <input type="text" data-rule="required" name="nickname" value="${user.nickname}" size="40">
                           </td>
                       </tr>
                       <c:if test="${user==null}">
                           <tr>
                               <td colspan="2">
                                   <label class="control-label x100">密码：</label>
                                   <input type="password" data-rule="密码:required" name="password" value="${user.password}" size="40">
                               </td>
                           </tr>
                           <tr>
                               <td colspan="2">
                                   <label class="control-label x100">确认密码：</label>
                                   <input type="password" data-rule="确认密码:required;match(password)" value="${user.password}" size="40">
                               </td>
                           </tr>
                       </c:if>

                       <tr>
                           <td colspan="2">
                               <label class="control-label x100">角色：</label>
                               <input type="checkbox" name="roles" data-toggle="icheck" data-label="管理员" value="admin" <c:if test="${roles.contains('admin')}">checked</c:if>/>
                               <input type="checkbox" name="roles" data-toggle="icheck" data-label="普通用户" value="user" <c:if test="${roles.contains('user')}">checked</c:if>/>
                           </td>
                       </tr>
                       <tr>
                           <td colspan="2">
                               <label class="control-label x100">状态：</label>
                               <input type="radio" name="status" data-toggle="icheck" data-label="正常" value="0" <c:if test="${user.status==0}">checked</c:if><c:if test="${user.status==null}">checked</c:if>/>
                               <input type="radio" name="status" data-toggle="icheck" data-label="锁定" value="1" <c:if test="${user.status==1}">checked</c:if>/>
                           </td>
                       </tr>
                       <tr>
                           <td colspan="2">
                               <label class="control-label x120"></label>
                               <div style="display: inline-block;padding: 10px;line-height: 24px;margin: 10px 0;border: 2px dashed #1F73B6">
                                   温馨提示：角色更改在该用户下次登录时才会生效
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
    $("#checkUsername").on("click",function () {
//        alert("hello");
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}"+"/user/checkUsername",
            dataType:"json",
            data:{
                username:$("#username").val()
            },

            success:function (data) {
//                alert(data.message);
                $(this).bjuiajax('ajaxDone',data);
            }

        })
    });

</script>

