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
        <div class="col-1">
        </div>
        <div class="col-8">
            <div class="row justify-content-center mb-5">
                <img class="col-2"
                     src="https://png.pngtree.com/png-clipart/20191121/original/pngtree-vector-calculator-icon-in-creative-design-with-elements-for-mobi-png-image_5145411.jpg"
                     alt="">
            </div>
            <div class="row justify-content-center">
                <form class="col-6 align-self-center" action="/calc" method="post">
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
                    <button type="submit" class="btn btn-success w-100 mb-2 mt-3">Calculate</button>
                    <!-- Button trigger modal -->
                    <button style="text-align: center" type="button" class="btn btn-outline-success btn-sm w-100"
                            data-bs-toggle="modal" data-bs-target="#historyModal">
                        History
                    </button>
                    <!-- Button trigger modal -->
                </form>
            </div>
            <div style="text-align: center">
                <label for="exampleInputPassword1" class="form-label"><h1><b>${result}</b></h1></label>
            </div>
        </div>
        <div class="col-3"></div>

    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="historyModal" tabindex="-1" aria-labelledby=modalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="modalLabel">History of computing</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <core:forEach var="operation" items="${operationsHistory}">
                    <h5>Type: ${operation.type} | num1: ${operation.num1} | num2: ${operation.num2} |
                        Result: ${operation.result}</h5>
                    <p>---------------------------------------------------------------------</p>
                </core:forEach>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-success" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
</body>
</html>