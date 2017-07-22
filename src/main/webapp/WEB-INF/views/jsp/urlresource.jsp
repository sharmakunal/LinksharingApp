<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<i class="fa fa-link fa-lg" data-toggle="modal" id="shareLink" data-target="#shareLinkModel"></i>

<!-- Modal -->
<div class="modal fade" id="shareLinkModel" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Share Link</h4>
            </div>

            <form class="form-horizontal" action="" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="url">Link*</label>
                        <div class="col-sm-8 pull-right">
                            <input type="text" class="form-control" id="url" name="url">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="Description">Description*</label>
                        <div class="col-sm-8 pull-right">
                            <textarea class="form-control" rows="5" id="description" name="description"></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="topicsAdd">Topic*</label>
                        <div class="col-sm-8 pull-right ">
                                <select id="topicsAdd" name="topicsAdd">
                                </select>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" id="addshareLinkResources">Share</button>
                    <button type="button" class="btn btn-default" id="closeAddLink"data-dismiss="modal">Close</button>
                </div>
            </form>
        </div>

    </div>
</div>
