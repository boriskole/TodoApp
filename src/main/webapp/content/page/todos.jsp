<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<t:template>

    <jsp:attribute name="title">
        Todos - TodoApp
    </jsp:attribute>

    <jsp:attribute name="content">

        <div class="container p-3 text-center position-absolute top-50 start-50 translate-middle">
            <div class="row justify-content-center">

                <div class="col-lg-5 col-sm-12 col-md-7">

                    <h1>Welcome back, <s:property value="account.firstName"/>!</h1>
                    <h3><s:property value="status"/></h3>

                    <a class="mt-5 btn btn-primary" href="logout">Logout</a>

                </div>

            </div>
        </div>

    </jsp:attribute>

</t:template>