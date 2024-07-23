<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/">Home</a>
                </li>
                <core:if test="${sessionScope.user == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="/reg">Registration</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                </core:if>
                <core:if test="${sessionScope.user != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="/calc">Calculator</a>
                    </li>
                </core:if>
                <core:if test="${sessionScope.user != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Out</a>
                    </li>
                </core:if>
                <li class="nav-item">
                    <core:if test="${sessionScope.user == null}">
                        <a class="nav-link disabled" aria-disabled="true">Hello, Guest</a>
                    </core:if>
                    <core:if test="${sessionScope.user != null}">
                        <a class="nav-link disabled" aria-disabled="true">Hello, ${sessionScope.user.userName}</a>
                    </core:if>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>