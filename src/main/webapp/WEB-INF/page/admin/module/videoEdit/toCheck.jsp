<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .upload-photo{
        padding: 10px;
        border: 1px solid #ccc;
        width: 80%;
    }

</style>
<div class="bjui-pageContent">
        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">
                <tbody>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">视频编辑模块</label>　　
                        <div style="display: inline-block;padding: 6px;line-height: 10px;margin: 2px 0;border: 2px dashed #1F73B6">
                            温馨提示：可供下载，离线审核或查看
                        </div>
                    </td>
                </tr>

                <tr>
                    <td>
                        <label class="control-label ">审核文件列表</label>
                           <span id="doc_show_pic" style="margin-top: 10px;">
                               <c:forEach items="${uploadFileList}" var="list" varStatus="x">
                                   <div class="uploadFileList${x.index} upload-photo">
                                        <a href="${pageContext.request.contextPath}/admin/common/file/download?fileName=${list.fileName}&url=${list.url}"  class="btn btn-blue">下载</a>　
                                        <span class="fa fa-folder-open"></span>&nbsp;<span>${list.fileName}</span>
                                   </div>
                               </c:forEach>
                           </span>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>
