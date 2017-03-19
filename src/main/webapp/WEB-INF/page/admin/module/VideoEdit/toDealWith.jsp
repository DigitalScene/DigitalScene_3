<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="bjui-pageContent">
     <form action="${pageContext.request.contextPath}/admin/videoEdit/toAppoint" data-toggle="validate" data-reload-navtab="true" method="post">
         <input type="hidden" name="id" value="${id}">
         <div class="pageFormContent" data-layout-h="0">
             <table class="table table-condensed table-hover" width="100%">
                 <tbody>
                       <tr>
                           <td colspan="2">
                               <label class="control-label x100">数据上传：</label>
                               <span style="text-align: center;"></span>
                           </td>
                       </tr>

                       <tr>
                           <td>
                               <div  id="fileInput2"
                                     data-toggle="upload"
                                     data-uploader="${pageContext.request.contextPath}/Atlas/photo/upload"
                                     data-button-text="选择上传图片压缩文件"
                                     data-file-size-limit="1024000000"
                                     data-file-type-exts="*.jpg;*.png;*.gif;*.mpg"
                                     data-multi="true"
                                     data-on-upload-success="show_upload_success"
                                     data-icon="cloud-upload">
                               </div>
                           <span id="doc_show_pic" style="margin-top: 10px;">
                           </span>
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

