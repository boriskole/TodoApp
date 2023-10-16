<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<t:template>

    <jsp:attribute name="title">
        Todos - TodoApp
    </jsp:attribute>

    <jsp:attribute name="content">

        <div class="container-fluid p-3 position-absolute top-50 start-50 translate-middle">

            <div class="row">

                <div class="col-lg"></div>

                <div class="col-lg text-center">

                    <h1>Welcome back, <s:property value="account.firstName"/>!</h1>
                    <h3><s:property value="status"/></h3>

                </div>

                <div class="col-lg text-center">
                    <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addTodo">
                        <i class="bi bi-plus-square-fill"></i>
                    </button>
                    <a class="btn btn-primary text-end ms-1" href="logout">
                        <i class="bi bi-box-arrow-right"></i>
                    </a>
                </div>

            </div>

            <div class="row mt-4">

                <div class="col-2"></div>

                <div class="col-8 text-center">

                    <table class="table">

                        <tbody>
                        <s:iterator value="todos">
                                <tr>
                                    <td><s:property value="description"/></td>
                                    <td>
                                        <form action="completeTodo" method="post">
                                            <input type="hidden" name="id" value="<s:property value="id"/>"/>
                                            <button type="submit" class="btn btn-success">
                                                <i class="bi bi-check-square-fill"></i>
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>

                    </table>

                </div>

                <div class="col-2"></div>

            </div>

        </div>

        <div class="modal fade" id="addTodo" tabindex="-1" aria-hidden="true">

            <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header">
                        <h1 class="modal-title fs-5">Add a todo</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>

                    <div class="modal-body">

                        <form action="addTodo" method="post">

                            <div class="form-floating mt-2">
                                <input type="text" name="description" id="description" placeholder="Description" class="form-control">
                                <label for="description" class="col-form-label form-label-group">Description</label>
                            </div>

                            <input type="submit" value="Submit" class="btn btn-primary form-control mt-3">

                        </form>

                    </div>

                </div>
            </div>

        </div>

    </jsp:attribute>

</t:template>