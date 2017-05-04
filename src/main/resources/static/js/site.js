/**
 * Custom JavaScript for the application
 */

/* data tables */
$().ready(function(){
    $('.table').DataTable();
});

$().ready(function(){
    $('.delete-confirm').on('click',function(){
    	swal({
    		  title: "Are you sure you want to delete?",
    		  text: "You will not be able to recover this process!",
    		  type: "warning",
    		  showCancelButton: true,
    		  confirmButtonColor: "#DD6B55",
    		  confirmButtonText: "Yes, delete it!",
    		  cancelButtonText: "No, I want to cancel!",
    		  closeOnConfirm: false,
    		  closeOnCancel: false
    		},
    		function(isConfirm){
    			if (isConfirm) {
    				$("#delete-form").submit();
    				swal("Deleted!", "Record has been deleted.", "success");
    			} else {
    			    swal("Cancelled", "Record not deleted", "error");
    			}
    		});
    });
});