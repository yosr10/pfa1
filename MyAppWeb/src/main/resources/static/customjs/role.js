 /********************* Edit role********************************/
   function loadRole(field){ //open modal
   		var data = field.closest("td").id;
   		$('#idEdit').val(data);
    	$('#roleEdit').val($('#role' + data).text());
    	
    	$('#edit-role-modal').modal('show');
    }
    $( "#role-edit-form" ).submit(function(event ) { //edit action
    	event.preventDefault();
    	var data = $('#idEdit').val();
    	$.ajax({
			url : '/admin/Roles/update',
			type : 'POST',
			data :  $("#role-edit-form").serialize(),
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(response) {	
				$('#role' + data).text($('#roleEdit').val());
			
				$('#edit-role-modal').modal('hide');
		    	swal("Updated!", "The role has been updated.", "success");
			}
		});
    });
    /*********************New role********************************/
    function newRole(){ //open modal
    	$('#roleNew').val('');

    	$('#new-role-modal').modal('show');
    }
  /*  $( "#anneeAcademique-new-form" ).submit(function(event ) { //add action
    	event.preventDefault();
    	$.ajax({
			url : '/admin/Annee-Academiques/save',
			type : 'POST',
			data :  $("#anneeAcademique-new-form").serialize(),
			dataType: "text",
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(idNewanneeAcademique) {	
				var firstName = $('#firstNameNew').val();
				var lastName = $('#lastNameNew').val();
				var email = $('#emailNew').val();
				var nextRow = $('#dt_tableTools').DataTable().column( 0 ).data().length + 1;
		    	$('#new-anneeAcademique-modal').modal('hide');
		    	var td1 ='<td><span>'+nextRow+'</span></td>' ;
		    	var td2 ='<td id="firstName'+idNewanneeAcademique+'">'+firstName+'</td>' ; 
		    	var td3 ='<td id="lastName'+idNewanneeAcademique+'">'+lastName+'</td>' ; 
		    	var td4 ='<td id="email'+idNewanneeAcademique+'">'+email+'</td>' ; 
		    	var td5 ='<td id="'+idNewanneeAcademique+'">' +
							'<a href="#" onclick="loadanneeAcademique(this)" data-toggle="tooltip" data-original-title="Edit">' +
								'<i class="md-icon material-icons" data-toggle="modal" data-target="#edit-anneeAcademique-modal">&#xE150;</i>' +
							'</a> &nbsp;' +
							'<a href="#" onclick="deleteanneeAcademique(this)" data-toggle="tooltip" data-original-title="Delete">' +
								'<i class="material-icons">&#xE5CD;</i>' +
							'</a>' +
						'</td>' ;
		    	
		    	$('#dt_tableTools').DataTable().row.add($('<tr>'+td1+td2+td3+td4+td5+'</tr>')).draw();
		    	swal("Créer!", "L'utilisateur a été créé.", "success");
			}
		});
    });*/
    
    /********************* Delete role********************************/ 
   function deleteRole(field){
   var data = field.closest("td").id;
        swal({   
            title: "Are you sure?",   
            text: "You will not be able to recover this role!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Yes, delete it!",   
            closeOnConfirm: false 
        }, function(){ 
    		$.ajax({
    			url : '/admin/Roles/delete',
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
    				swal("Deleted!", "The role has been deleted.", "success"); 
    				
    			}
    		})
           
        });
   }
