<div class="col-md-4 margin-top">
    <div class="row"><!--Login-->
        <div class="col-md-12">
            <div class="wrapBox">
                <div class="boxHeading">Login</div>
                <div class="boxBody">
                    <form class="form-horizontal" action="loginUser" method="Post">

                        <div class="form-group changeFontSize">
                            <label class="control-label col-sm-5" for="username">Username/Email*</label>
                            <div class="col-sm-7">
                                <input type="textbox" id="username" name="username">
                            </div>
                        </div>
                        <div class="form-group changeFontSize">
                            <label class="control-label col-sm-5" for="password">Password*</label>
                            <div class="col-sm-7">
                                <input type="password" id="password" name="password">
                            </div>
                        </div>
                        <div class="form-group changeFontSize ">
                            <div class="col-sm-9">
                                <div style="text-decoration:underline"><a href="/reset">Forgot password</a></div>
                            </div>
                            <div class="col-sm-3 right">
                                <button>Login</button>
                            </div>
                        </div>
                        <span STYLE="font-size: 15px;color:red"> ${LoginMessage}</span>
                    </form>
                </div>
            </div>
        </div>
    </div>
