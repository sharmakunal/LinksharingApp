<i class="fa fa-comment fa-lg" data-toggle="modal" data-target="#createTopic"></i>
<!-- Modal -->
<div class="modal fade" id="createTopic" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Create Topic</h4>
            </div>

            <form class="form-horizontal" action="#" method="post" name="creatTopicsForm">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="name">Name*</label>
                        <div class="col-sm-8 pull-right">
                            <input type="text" class="form-control" id="name" name="name">
                        </div>
                        <span id="topic_status"></span>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="Visibility">Visibility*</label>
                        <div class="col-sm-8 pull-right">
                                <select name="visibility" id="visibility">
                                <option value="Public" selected="selected">Public</option>
                                <option value="Private">Private</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" id="addTopic" disabled>Save</button>
                    <button type="button" class="btn btn-default" id="close" data-dismiss="modal" >Close</button>
                </div>

            </form>

        </div>

    </div>
</div>
