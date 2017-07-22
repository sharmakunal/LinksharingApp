<div class="row margin-top"><!--Register-->
    <div class="col-md-12">
        <div class="wrapBox">
            <div class="boxHeading">Register</div>
            <div class="boxBody">

                <form class="form-horizontal" name="registration" enctype="multipart/form-data" action="register" method="POST">

                   <div class="form-group changeFontSize">
                        <label class="control-label col-sm-5 changeFontSizes" for="firstName">First name*</label>
                        <div class="col-sm-7">
                            <input type="textbox" class="" id="firstName" name="firstName">
                        </div>
                    </div>

                    <div class="form-group changeFontSize">
                        <label class="control-label col-sm-5 changeFontSizes" for="lastName">Last name*</label>
                        <div class="col-sm-7">
                            <input type="textbox" class="" id="lastName" name="lastName">
                        </div>
                    </div>
                    <div class="form-group changeFontSize">
                        <label class="control-label col-sm-5" for="email">Email*</label>
                        <div class="col-sm-7">
                            <input type="textbox" class="" id="email" name="email">
                        </div>
                        <span id="emailMessage"></span>
                    </div>
                    <div class="form-group changeFontSize">
                        <label class="control-label col-sm-5" for="regusername">Username*</label>
                        <div class="col-sm-7">
                            <input type="textbox" class="" id="regusername" name="username">
                        </div>
                    <span id="usernameMessage"></span>
                    </div>
                    <div class="form-group changeFontSize">
                        <label class="control-label col-sm-5" for="password">Password*</label>
                        <div class="col-sm-7">
                            <input type="password" class="" id="password" name="password">
                        </div>
                    </div>
                    <div class="form-group changeFontSize">
                        <label class="control-label col-sm-5" for="confirmPassword">Confirm Password*</label>
                        <div class="col-sm-7">
                            <input type="password" class="" id="confirmPassword" name="confirmPassword" >
                        </div>
                        <span id="cpsr"></span>
                    </div>
                    <div class="form-group changeFontSize">
                        <label class="control-label col-sm-5" for="file">Photo</label>
                        <div class="col-sm-4 padding-right0">
                            <input type="file" id="file" name="file">
                        </div>
                    </div>
                    <div class="form-group changeFontSize">
                        <div class="col-sm-12 padding-right">
                            <input class="pull-right btn btn-default" type="submit" id="regSubmit" value="Register" disabled>
                            <span STYLE="font-size: 15px;color:red">${registration}</span>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div><!-- Register -->
</div><!-- margin top col 4 -->
</div><!--master row end-->
</div>
