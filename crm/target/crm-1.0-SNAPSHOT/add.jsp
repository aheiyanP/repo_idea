<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加员工</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <%--查询部门信息--%>
    <script>
        $(function (){
            console.log("function方法执行了")

            let url = '${pageContext.request.contextPath}/dept/ajaxRequest';
            $.ajax({
                type: 'POST',
                url: url,
                success: function (resp) {

                    //alert(JSON.stringify(resp));
                    console.log("ajax执行了"+resp)
                    var $select = $("#dept_id");
                    $select.append("<option value=" + null + ">--请选择部门--</option>");
                    for (var i = 0; i < resp.length; i++) {
                        $select.append("<option value=" + resp[i].dept_id + ">" + resp[i].dept_name + "</option>");
                    }
                },
            })
        })
    </script>
</head>
<body>
<div class="container">
    <center><h3>添加员工</h3></center>
    <div class="row">
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
            <form action="${pageContext.request.contextPath}/employee/save" method="post">
                <div class="form-group">
                    <label for="emp_name">姓名：</label>
                    <input type="text" class="form-control" id="emp_name" name="emp_name" placeholder="请输入姓名">
                </div>
                      <div class="form-group">
                    <label for="dept_id">部门：</label>

                          <select id="dept_id" name="dept_id" class="form-control" required>
<%--                              <c:forEach items="${depts}" var="dept">
                                  <option value="${dept.dept_id}">${dept.dept_name}</option>
                              </c:forEach>--%>
                          </select>
                </div>
                <div class="form-group">
                    <label for="job_name">职位：</label>
                    <input type="text" class="form-control" id="job_name" name="job_name" placeholder="请输入职位">
                </div>
                <div class="form-group">
                    <label for="join_date">入职时间：</label>
                    <input type="text" class="form-control" id="join_date" name="join_date" placeholder="请输入职时间，例如 2020-02-02">
                </div>
                <div class="form-group">
                    <label for="telephone">联系方式：</label>
                    <input type="text" class="form-control" id="telephone" name="telephone" placeholder="请输入联系方式">
                </div>


                <div class="form-group" style="text-align: center">
                    <input class="btn btn-primary" type="submit" value="提交" />
                    <input class="btn btn-default" type="reset" value="重置" />
                    <input class="btn btn-default" type="button" onclick="history.go(-1)" value="返回" />
                </div>
            </form>
        </div>
        <div class="col-lg-3"></div>
    </div>
</div>
</body>
</html>