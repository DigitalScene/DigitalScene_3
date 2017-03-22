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
    <form action="${pageContext.request.contextPath}/admin/common/file/save" data-toggle="validate" data-reload-navtab="true" method="post">
        <input type="hidden" name="moduleId" value="${moduleId}">
        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">
                <tbody>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">3D模型制作模块(可上传多个)</label>
                        <div style="display: inline-block;padding: 6px;line-height: 10px;margin: 2px 0;border: 2px dashed #1F73B6">
                            温馨提示：文件上传保存，点右下角的保存时才会生效。
                        </div>
                    </td>
                </tr>

                <tr>
                    <td>
                        <div  id="fileInput2"
                              data-toggle="upload"
                              data-uploader="${pageContext.request.contextPath}/admin/common/file/upload"
                              data-form-data={"moduleType":"thrDModelMade"}
                              data-button-text="选择上传3D模型制作压缩文件"
                              data-file-size-limit="1024000000"
                              data-file-type-exts="*.zip;*.rar"
                              data-multi="true"
                              data-on-upload-success="show_upload_success"
                              data-icon="cloud-upload">
                        </div>
                           <span id="doc_show_pic" style="margin-top: 10px;">
                               <c:forEach items="${uploadFileList}" var="list" varStatus="x">
                                   <div class="uploadFileList${x.index} upload-photo">
                                        <a href="${pageContext.request.contextPath}/admin/common/file/delete?id=${list.id}&index=${x.index}&url=${list.url}" data-callback="mycallback" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>　
                                        <span class="fa fa-folder-open"></span>&nbsp;<span>${list.fileName}</span>
                                        <input type="hidden" name="uploadFileList[${x.index}].fileName" value="${list.fileName}">
                                        <input type="hidden" name="uploadFileList[${x.index}].id" value="${list.id}">
                                        <input type="hidden" name="uploadFileList[${x.index}].url" value="${list.url}">
                                   </div>
                               </c:forEach>
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

<script type="text/javascript">

    if (${uploadFileList.size()==0||uploadFileList.size()==null}){
        x=0;
    }else {
        x="${uploadFileList.size()}";
    }

    //图集展示，多张
    function show_upload_success(file, data) {
        var json = $.parseJSON(data);
        $(this).bjuiajax('ajaxDone', json);
        if (json[BJUI.keys.statusCode] == BJUI.statusCode.ok) {
            $('#doc_show_pic').append(
                    '<div class="uploadFileList'+x+' upload-photo">'+
                    "<a href='${pageContext.request.contextPath}/admin/common/file/delete?index="+x+"&url="+json.filePath+"' class='btn btn-red' data-callback='mycallback' data-toggle='doajax' data-confirm-msg='确定要删除吗？'>删除</a>　"+
                    '<span class="fa fa-folder-open"></span>&nbsp;<span>'+json.fileName+'</span>' +
                    '<input type="hidden" name="uploadFileList['+x+'].fileName" value="'+json.fileName+'">'+
                    '<input type="hidden" name="uploadFileList['+x+'].url" value="'+json.filePath+'">'+
                    '</div>');
            x++;
        }
    }

    function mycallback(json) {
        $(this).bjuiajax('ajaxDone', json);       // 信息提示
        $('.uploadFileList'+json.index).remove();
//        console.log(json.type+json.index);
    }
</script>