<%--
  Created by IntelliJ IDEA.
  User: Жека
  Date: 23.07.2024
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<jsp:include page="_bootstrap.jsp"/>
<jsp:include page="_header.jsp"/>

<div class="container">
    <div class="row min-vh-100 align-items-center">
        <div>
            <div class="row justify-content-center mb-5">
                <img class="col-2"
                     src="https://png.pngtree.com/png-clipart/20191121/original/pngtree-vector-calculator-icon-in-creative-design-with-elements-for-mobi-png-image_5145411.jpg"
                     alt="">
            </div>
            <div class="row justify-content-center">
                <form class="col-4 align-self-center" action="/calc" method="post">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label"><b>First number -></b></label>
                        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                               placeholder="enter a number here" name="num1">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label"><b>Second number -></b></label>
                        <input type="text" class="form-control" id="exampleInputPassword1"
                               placeholder="enter a number here" name="num2">
                    </div>
                    <label for="exampleInputPassword1" class="form-label"><b>Select the type of operation -></b></label>
                    <select class="form-select form-select-sm" aria-label="Small select example" name="type">
                        <option selected>Select the type</option>
                        <option value="sum">+ (plus)</option>
                        <option value="sub">- (subtract)</option>
                        <option value="mul">* (multiply)</option>
                        <option value="div">/ (divide)</option>
                    </select>
                    <button type="submit" class="btn btn-primary w-100 mb-2 mt-3">Submit</button>
                </form>
            </div>
            <div style="text-align: center">
                <label for="exampleInputPassword1" class="form-label"><h1>${result}</h1></label>
            </div>
        </div>
    </div>
</div>
</body>
</html>
