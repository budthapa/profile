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
    		  timer: 3000,
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
    				//swal("Deleted!", "Record has been deleted.", "success");
    			} else {
    			    swal("Cancelled", "Record not deleted", "error");
    			}
    		});
    });
});

$(document).ready(function(){

	
	$(".save-confirm").click(function(){
		 var form = $(this).parents('form');
		swal({
			  title: 'Are you sure?',
			  text: "You won't be able to revert this!",
			  type: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Yes, I\'ll save it!',
			  cancelButtonText: 'No, cancel! I\'ll add more.',
			  confirmButtonClass: 'btn btn-success',
			  cancelButtonClass: 'btn btn-danger',
			  buttonsStyling: false
			}).then(function () {
				form.submit();
			  
			}, function (dismiss) {
			  // dismiss can be 'cancel', 'overlay',
			  // 'close', and 'timer'
			  if (dismiss === 'cancel') {
			    swal(
			      'Cancelled',
			      'Your document is not saved :)',
			      'error'
			    )
			  }
			});
		
			e.preventDefault();
	});
	
   
});


$(document).ready(function() {
    // show the alert
    setTimeout(function() {
        $(".alert").alert('close');
    }, 4000);
});

$(document).ready(function(){
	$(".access-denied").effect("shake");
});