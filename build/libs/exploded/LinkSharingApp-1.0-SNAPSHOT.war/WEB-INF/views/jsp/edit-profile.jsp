<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<div class="container">
    <%@include file="DashboardHeader.jsp"%>

  <div class="col-md-6 " style="margin-top:30px;">


    <form class="form-horizontal" action="profile_update_Byuser" method="post" enctype="multipart/form-data"
          name="updateProfile">

        <div class="form-group">
            <label class="control-label col-sm-2" for="firstName">First-Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="firstName"  name="firstName">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="lastName">Last Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="lastName"  name="lastName">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="username">Username:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="username"  name="username">
            </div>
            <span id="usernameMessage"></span>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="file">Photo Upload:</label>
            <div class="col-sm-10">
                <input type="file" id="file" name="file">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" id="updateSubmit" class="btn btn-default">Update</button>
            </div>
        </div>
    </form>

 <br/>

 <br/>

<br/>

      ${SucccessMessage}
      ${msg}
<br/>
      <br/>
      <form class="form-horizontal" action="password_update_Byuser" method="post" name="updatePassword">

          <div class="form-group">
              <label class="control-label col-sm-2" for="confirmPassword">Password:</label>
              <div class="col-sm-10">
                  <input type="password" class="form-control" id="confirmPassword"  name="confirmPassword">
              </div>
          </div>

          <div class="form-group">
              <label class="control-label col-sm-2" for="password">Confirm-Password:</label>
              <div class="col-sm-10">
                  <input type="password" class="form-control" id="password"  name="password">
              </div>
          </div>

          <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default">Update</button>
              </div>
          </div>
      </form>

  </div>
</div>

<script type="text/javascript" src="/resources/assets/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js">0</script>
<script type="text/javascript" src="/resources/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/assets/js/form-validation.js"></script>


<script type="text/javascript">

    $(function() {
        $("form[name='updateProfile']").validate({
            rules: {
                firstName: "required",
                lastName: "required",
                username:"required",
            },
            messages: {
                firstName: "Please enter your FirstName",
                lastName: "Please enter your LastName",
                username:"Please provide a username"
            },
            submitHandler: function(form) {
                form.submit();
            }
        });
    });


    $(function() {
        $("form[name='updatePassword']").validate({
            rules: {
                password: {
                    required: true,
                    minlength: 5
                },
                confirmPassword: {
                    "required" : true
                },
            },
            messages: {
                password: {
                    required: "Please provide a Password",
                    minlength: "Your Password must be at least 5 characters long"
                },
                confirmPassword:"The confirm password is Required."
            },
            submitHandler: function(form) {
                form.submit();
            }
        });
    });


    $("#username").focusout(function () {
        ajaxCall($("#username").val(),this,1);
    });


    function ajaxCall(credential, tag,index){
        $.ajax({
            url:"validateUsername",
            data:{credential:credential},
            type:"post",
            success:function(r)
            {
                if(r==="true")
                {
                    if(index == 1) {
                        $('#usernameMessage').html('<i style="color:red"> Already Exsits</i>');
                        $('#updateSubmit').attr('disabled', true);
                    }
                    console.log(tag);
                }
                else
                {
                    if(index == 1) {
                        $('#usernameMessage').html('<i style="color:green"> Available</i>');
                        $('#updateSubmit').attr('disabled',false);
                    }
                }
            },
            error:function(e)
            {
                console.log(e);
            }
        });
    }
</script>
</body>
</html>
