 /********************* Edit grade********************************/
   function loadGrade(field){ //open modal
   		var data = field.closest("td").id;
   		$('#idEdit').val(data);
    	$('#nomEdit').val($('#nom' + data).text());
    	
    	$('#edit-grade-modal').modal('show');
    }
    $( "#grade-edit-form" ).submit(function(event ) { //edit action
    	event.preventDefault();
    	var data = $('#idEdit').val();
    	$.ajax({
			url : '/admin/Grades/update',
			type : 'POST',
			data :  $("#grade-edit-form").serialize(),
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(response) {	
				$('#nom' + data).text($('#nomEdit').val());
				
		    	$('#edit-grade-modal').modal('hide');
		    	swal("Updated!", "The grade has been updated.", "success");
			}
		});
    });
    /*********************New grade********************************/
    function newGrade(){ //open modal
    	$('#nomNew').val('');
    	
    	$('#new-grade-modal').modal('show');
    }
  /*  $( "#grade-new-form" ).submit(function(event ) { //add action
    	event.preventDefault();
    	$.ajax({
			url : '/admin/Grades/save',
			type : 'POST',
			data :  $("#grade-new-form").serialize(),
			dataType: "text",
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(idNewgrade) {	
				var firstName = $('#firstNameNew').val();
				var lastName = $('#lastNameNew').val();
				var email = $('#emailNew').val();
				var nextRow = $('#dt_tableTools').DataTable().column( 0 ).data().length + 1;
		    	$('#new-grade-modal').modal('hide');
		    	var td1 ='<td><span>'+nextRow+'</span></td>' ;
		    	var td2 ='<td id="firstName'+idNewgrade+'">'+firstName+'</td>' ; 
		    	var td3 ='<td id="lastName'+idNewgrade+'">'+lastName+'</td>' ; 
		    	var td4 ='<td id="email'+idNewgrade+'">'+email+'</td>' ; 
		    	var td5 ='<td id="'+idNewgrade+'">' +
							'<a href="#" onclick="loadgrade(this)" data-toggle="tooltip" data-original-title="Edit">' +
								'<i class="md-icon material-icons" data-toggle="modal" data-target="#edit-grade-modal">&#xE150;</i>' +
							'</a> &nbsp;' +
							'<a href="#" onclick="deletegrade(this)" data-toggle="tooltip" data-original-title="Delete">' +
								'<i class="material-icons">&#xE5CD;</i>' +
							'</a>' +
						'</td>' ;
		    	
		    	$('#dt_tableTools').DataTable().row.add($('<tr>'+td1+td2+td3+td4+td5+'</tr>')).draw();
		    	swal("Créer!", "L'utilisateur a été créé.", "success");
			}
		});
    });*/
    
    /********************* Delete grade********************************/ 
   function deleteGrade(field){
   var data = field.closest("td").id;
        swal({   
            title: "Are you sure?",   
            text: "You will not be able to recover this grade!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Yes, delete it!",   
            closeOnConfirm: false 
        }, function(){ 
    		$.ajax({
    			url : '/admin/Grades/delete',
    			type : 'POST',
    			data : {
    				id : data
    			},
    			error: function (request, error) {
    				 swal("ERROR!", " Can't do because: " + error, "error");
    		    },
    			success : function(response) {	
    				$('#dt_tableTools').DataTable().row( $(field).closest('tr') ).remove().draw();
    				//field.closest('tr').remove(); 
    				//$('#myTable').dataTable();
    				swal("Deleted!", "The grade has been deleted.", "success"); 
    				
    			}
    		})
           
        });
   }
