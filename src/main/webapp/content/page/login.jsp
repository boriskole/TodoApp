<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<t:template>

    <jsp:attribute name="title">
        Login - TodoApp
    </jsp:attribute>

    <jsp:attribute name="content">

        <div class="container p-3 text-center position-absolute top-50 start-50 translate-middle">
            <div class="row justify-content-center">

                <div class="col-lg-5 col-sm-12 col-md-7">

                    <form method="post" action="doLogin">

                        <h2 class="mb-5">Login</h2>

                        <div class="form-floating mt-3">
                            <input type="email" name="email" id="email" placeholder="E-mail" class="form-control">
                            <label for="email" class="col-form-label form-label-group">E-Mail</label>
                        </div>

                        <div class="form-floating mt-3">
                            <input type="password" name="password" id="password" placeholder="Password" class="form-control">
                            <label for="password" class="col-form-label form-label-group">Password</label>
                        </div>

                        <input type="submit" value="Login" class="btn btn-primary form-control my-3 py-3">

                    </form>

                    <p>
                        Don't have an account?
                        <a class="ms-1" href="register">Sign up</a>
                    </p>

                </div>

            </div>
        </div>

    </jsp:attribute>

</t:template>