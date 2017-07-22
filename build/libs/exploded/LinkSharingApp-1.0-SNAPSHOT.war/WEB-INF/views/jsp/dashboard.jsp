<%@include file="DashboardHeader.jsp"%>
    ${fileNotUpload}
    <%@include file="Posts.jsp"%>
</div>
<script type="text/javascript" src="/resources/assets/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js">0</script>
<script type="text/javascript" src="/resources/assets/js/bootstrap.min.js"></script>
<script type="text/javascript">

    $(document).ready(function(){
        $("#close").click(function(){
            $("#name").val(" ");
            $('#topic_status').html('<i style="color:white">  </i>');
        });
    });

    $('#addTopic').on('click', function(){
        $.ajax({
            url:"addTopicbyUser",
            data:{
                name:$('#name').val(),
                visibility:$('#visibility').val(),
            },
            type:"post",
            success: function(response)
            {
                $('#name').val(' ');
                $('#createTopic').modal('hide');
                console.log(response);
            },
            error:function(e)
            {
                $('#name').val(' ');
                $('#createTopic').modal('hide');
                console.log(e);
            }
        });
    });



    $("#name").focusout(function () {
        ajaxCall($("#name").val(),this,1);
    });

    function ajaxCall(credential, tag,index) {
        $.ajax({
            url:"validateTopicName",
            data:{credential:credential},
            type:"post",
            success:function(r)
            {
                if(r==="true")
                {
                        $('#topic_status').html('<i style="color:red"> Already Exsits</i>');
                        $('#addTopic').attr("disabled", true);
                         console.log(tag);
                }
                else  if(r==="false" &&  $("#name").val()!=" ")
                {
                        $('#topic_status').html('<i style="color:green"> Available</i>');
                        $('#addTopic').attr("disabled", false);

                }
            },
            error:function(e)
            {
                console.log(e);
            }
        });
    }
    $(document).ready(function(){
        $("#closeAddLink").click(function(){
            $('#url').val(" ");
            $('#description').val(" ");

        });
    });

    $('#addshareLinkResources').on('click', function(){
        $.ajax({
            url:"addLinkResource",
            type:"post",
            data:{
                url:$('#url').val(),
                description:$('#description').val(),
                topicsAdd:$('#topicsAdd').val(),
            },
            success: function(response)
            {
                $('#url').val(' ');
                $('#description').val(' ');
                $('#shareLinkModel').modal('hide');
                console.log(response);
            },
            error:function(e)
            {
                $('#url').val(' ');
                $('#description').val(' ');
                $('#shareLinkModel').modal('hide');
                console.log(e);
            }
        });
    });

    $('#shareLink').on('click',getTopics('#topicsAdd'));
    $('#documentResources').on('click',getTopics('#documentTopicAdd'));
    function getTopics(idName) {

        var subs=new Object();
        $.ajax({
            url: "listcheck",
            type: 'GET',
            success: function (List) {
                console.log(List);
                $(idName).empty();
                for (i = 0; i < List.length; i++) {
                    var subs = List[i];
                    var row = $('<option value=' + subs.topicId + '>' + subs.name + '</option>');
                    $(idName).append(row);
                }
            },

            error: function () {
                console.log("no values")
            }
        });

    }

    $(function() {
        $("form[name='documentResource']").validate({
            rules: {
                description: "required",
                file: "required",
            },
            messages: {
                description: "Please enter your description",
                file: "please Choose File"
            },
            submitHandler: function(form) {
                form.submit();
            }
        });
    });

      $(function() {
        $("form[name='creatTopicsForm']").validate({
            rules: {
                name: "required",
            },
            messages: {
                name: "Please enter the Topic",
            },
            submitHandler: function(form) {
                form.submit();
            }
        });
    });

</script>
</body>
</html>
