<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<html>
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width" initial-scale="1.0"/>
  <title>Home</title>
  <link rel="stylesheet" type="text/css" href="/resources/assets/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>
<div class="container">

 <%@ include file="homeheader.jsp"%>
 <%@ include file="homepost.jsp"%>
 <%@ include file="login.jsp"%>
 <%@ include file="registration.jsp"%>

  <script type="text/javascript" src="/resources/assets/js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js">0</script>
  <script type="text/javascript" src="/resources/assets/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="/resources/assets/js/form-validation.js"></script>

  <script type="text/javascript">
      $(function() {
          $("form[name='registration']").validate({
              rules: {
                  firstName: "required",
                  lastName: "required",
                  email: {
                      required: true,
                      email: true,
                      emailUnique: true
                  },
                  password: {
                      required: true,
                      minlength: 5
                  },
                  confirmPassword: {
                      "required" : true
                  },
                  username:"required"
              },
              messages: {
                  firstName: "Please enter your FirstName",
                  lastName: "Please enter your LastName",
                  password: {
                      required: "Please provide a Password",
                      minlength: "Your Password must be at least 5 characters long"
                  },
                  email: "Please enter a valid email address",
                  confirmPassword:"The confirm password is Required.",
                  username:"Please provide a username"
              },
              submitHandler: function(form) {
                  form.submit();
              }
          });
      });


      $("#regusername").focusout(function () {
          ajaxCall($("#regusername").val(),this,1);
      });
      $("#email").focusout(function () {
          ajaxCall($("#email").val(),this,2);
      });

      function ajaxCall(credential, tag,index) {
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
                          $('#regSubmit').attr('disabled',true);
                      }else {
                          $('#emailMessage').html('<i style="color:red"> Already Exsits</i>');
                          $('#regSubmit').attr('disabled',true);
                      }
                      console.log(tag);
                  }
                  else
                  {
                      if(index == 1) {
                          $('#usernameMessage').html('<i style="color:green"> Available</i>');
                          $('#regSubmit').attr('disabled',false);
                     }else{
                          $('#emailMessage').html('<i style="color:green"> Available</i>');
                          $('#regSubmit').attr('disabled',false);

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
</div>
</body>
</html>
