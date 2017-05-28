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

$(document).ready(function(e){
/*	
	$("#player-form").submit(function(e){
		var selectedData = document.querySelector('#videolink').value;
	    e.preventDefault();
	    alert(selectedData);
	    var data = {}
	    var Form = this;
	    
	    //Gathering the Data
	    //and removing undefined keys(buttons)
	    $.each(this.elements, function(i, v){
	            var input = $(v);
	        data[input.attr("name")] = input.val();
	        delete data["undefined"];
	    });
		
	    //Save Form Data........
	    $.ajax({
	        cache: false,
	        url : "/player/link?videolink="+selectedData,
	        type: "POST",
	        dataType : "json",
	        data : JSON.stringify(data),
	        context : Form,
	        success : function(callback){
	            //Where $(this) => context == FORM
	            console.log(JSON.parse(callback));
	            $(this).html("Success!");
	        },
	        error : function(){
	            $(this).html("Error!");
	        }
	    });
	});*/
	
	var form = $('#player-form');
  
    form.submit(function (e) {

        e.preventDefault();
    	selectedData = document.querySelector('#videolink').value;
    	var player = document.querySelector('#audioplayer');
    	alert(selectedData);
    	
        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: form.serialize(),
            dataType : 'json',
    		timeout : 100000,
    		success : function(data) {
    			console.log("SUCCESS: ", data.link);
    			$(".audioSource").attr('src',data.link);
    			player.play()
    			//plyr.setup();
    			plyr.setup(player);
//    			player.destroy();
    		},
    		error : function(e) {
    			console.log("ERROR: ", e);
    		},
    		done : function(e) {
    			console.log("DONE");
    		}
        });
    });
       
	/*
	$(".fetch-video-link").on('click', function(event){
		event.preventDefault();
		
		var link = $("#video-link").val();
		$(".audioDiv audio source").attr('src',link);
		$(".audioDiv audio")[0].load();
	
	
		var post_url = $(this).attr('action');
		var post_method = $(this).attr('method');
		var form_data = $(this).serialize();
	
		alert(post_url+" "+post_method+" "+form_data);
		
		
		$.ajax({
			url: post_url,
			type: post_method,
			data: form_data,
			success: function(data){
				console.log("Form submit success");
				$(".success-div").html(data);
			}
		});
	});
	*/
});





