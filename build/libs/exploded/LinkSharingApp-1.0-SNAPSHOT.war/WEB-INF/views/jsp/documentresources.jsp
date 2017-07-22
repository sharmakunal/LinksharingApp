<i class="fa fa-File fa-lg " data-toggle="modal" id="documentResources" data-target="#documentResourcesModel"></i>

<!-- Modal -->
<div class="modal fade" id="documentResourcesModel" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Share Document</h4>
            </div>
            <form class="form-horizontal" method="post" enctype="multipart/form-data" name="documentResource"
                  action="addDocumentResource">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="file">Document*</label>
                        <div class="col-sm-8 pull-right">
                            <input type="file" id="file" name="file">
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-sm-2" for="Description">Description*</label>
                        <div class="col-sm-8 pull-right">
                            <textarea class="form-control" rows="5" id="description" name="description"></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="documentTopicAdd">Topic*</label>
                        <div class="col-sm-8 pull-right">
                            <select id="documentTopicAdd" name="documentTopicAdd">
                            </select>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-default" id="addDocumentResources">Share</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </form>
        </div>

    </div>
</div>
