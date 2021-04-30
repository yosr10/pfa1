 /********************* Edit Creneau********************************/
   function loadCreneau(field){ //open modal
   		var data = field.closest("td").id;
   		$('#idEdit').val(data);
    	$('#ordreEdit').val($('#ordre' + data).text());
    	$('#libelleEdit').val($('#libelle' + data).text());
    	
    	$('#edit-creneau-modal').modal('show');
    }
    $( "#creneau-edit-form" ).submit(function(event ) { //edit action
    	event.preventDefault();
    	var data = $('#idEdit').val();
    	$.ajax({
			url : '/admin/Creneaux/update',
			type : 'POST',
			data :  $("#creneau-edit-form").serialize(),
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(response) {	
				$('#ordre' + data).text($('#ordreEdit').val());
				$('#libelle' + data).text($('#libelleEdit').val());
				
		    	$('#edit-creneau-modal').modal('hide');
		    	swal("Updated!", "The creneau has been updated.", "success");
			}
		});
    });
    /*********************New Creneau********************************/
    function newCreneau(){ //open modal
    	$('#ordreNew').val('');
    	$('#libelleNew').val('');
    	$('#new-creneau-modal').modal('show');
    }
  /*  $( "#creneau-new-form" ).submit(function(event ) { //add action
    	event.preventDefault();
    	$.ajax({
			url : '/admin/new_user',
			type : 'POST',
			data :  $("#user-new-form").serialize(),
			dataType: "text",
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(idNewUser) {	
				var firstName = $('#firstNameNew').val();
				var lastName = $('#lastNameNew').val();
				var email = $('#emailNew').val();
				var nextRow = $('#dt_tableTools').DataTable().column( 0 ).data().length + 1;
		    	$('#new-user-modal').modal('hide');
		    	var td1 ='<td><span>'+nextRow+'</span></td>' ;
		    	var td2 ='<td id="firstName'+idNewUser+'">'+firstName+'</td>' ; 
		    	var td3 ='<td id="lastName'+idNewUser+'">'+lastName+'</td>' ; 
		    	var td4 ='<td id="email'+idNewUser+'">'+email+'</td>' ; 
		    	var td5 ='<td id="'+idNewUser+'">' +
							'<a href="#" onclick="loadUser(this)" data-toggle="tooltip" data-original-title="Edit">' +
								'<i class="md-icon material-icons" data-toggle="modal" data-target="#edit-user-modal">&#xE150;</i>' +
							'</a> &nbsp;' +
							'<a href="#" onclick="deleteUser(this)" data-toggle="tooltip" data-original-title="Delete">' +
								'<i class="material-icons">&#xE5CD;</i>' +
							'</a>' +
						'</td>' ;
		    	
		    	$('#dt_tableTools').DataTable().row.add($('<tr>'+td1+td2+td3+td4+td5+'</tr>')).draw();
		    	swal("Créer!", "L'utilisateur a été créé.", "success");
			}
		});
    });
    
    */
    /********************* Delete Creneau********************************/ 
   function deleteCreneau(field){
   var data = field.closest("td").id;
        swal({   
            title: "Are you sure?",   
            text: "You will not be able to recover this creneau!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Yes, delete it!",   
            closeOnConfirm: false 
        }, function(){ 
    		$.ajax({
    			url : '/admin/Creneaux/delete',
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
    				swal("Deleted!", "The creneau has been deleted.", "success"); 
    				
    			}
    		})
           
        });
   }
l