<i class="fa fa-envelope fa-lg" data-toggle="modal" data-target="#invitation"></i>

<!-- Modal -->
<div class="modal fade" id="invitation" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Send Invitation</h4>
            </div>
            <form class="form-horizontal">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="email">Email*</label>
                        <div class="col-sm-8 pull-right">
                            <input type="text" class="form-control" id="email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="Topic">Topic*</label>
                        <div class="col-sm-8 pull-right">
                            <select>
                                <option value="1" selected="selected">Public</option>
                                <option value="2">Private</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-default">Invite</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </form>
        </div>

    </div>
</div>
