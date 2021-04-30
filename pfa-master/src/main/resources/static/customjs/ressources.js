 /********************* Edit ressource********************************/
   function loadRessource(field){ //open modal
   		var data = field.closest("td").id;
   		$('#idEdit').val(data);
    	$('#nomEdit').val($('#nom' + data).text());
    	$('#salleEdit').val($('#salle' + data).text());
    	
    	$('#edit-ressource-modal').modal('show');
    }
    $( "#ressource-edit-form" ).submit(function(event ) { //edit action
    	event.preventDefault();
    	var data = $('#idEdit').val();
    	$.ajax({
			url : '/admin/Ressources/update',
			type : 'POST',
			data :  $("#ressource-edit-form").serialize(),
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(response) {	
				$('#nom' + data).text($('#nomEdit').val());
				$('#salle' + data).text($('#salleEdit').val());
				$('#edit-ressource-modal').modal('hide');
		    	swal("Updated!", "The ressource has been updated.", "success");
			}
		});
    });
    /*********************New ressource********************************/
    function newRessource(){ //open modal
    	$('#nomNew').val('');
    	$('#salleNew').val('');
    	$('#new-ressource-modal').modal('show');
    }
  /*  $( "#ressource-new-form" ).submit(function(event ) { //add action
    	event.preventDefault();
    	$.ajax({
			url : '/admin/Ressources/save',
			type : 'POST',
			data :  $("#ressource-new-form").serialize(),
			dataType: "text",
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(idNewressource) {	
				var firstName = $('#firstNameNew').val();
				var lastName = $('#lastNameNew').val();
				var email = $('#emailNew').val();
				var nextRow = $('#dt_tableTools').DataTable().column( 0 ).data().length + 1;
		    	$('#new-ressource-modal').modal('hide');
		    	var td1 ='<td><span>'+nextRow+'</span></td>' ;
		    	var td2 ='<td id="firstName'+idNewressource+'">'+firstName+'</td>' ; 
		    	var td3 ='<td id="lastName'+idNewressource+'">'+lastName+'</td>' ; 
		    	var td4 ='<td id="email'+idNewressource+'">'+email+'</td>' ; 
		    	var td5 ='<td id="'+idNewressource+'">' +
							'<a href="#" onclick="loadressource(this)" data-toggle="tooltip" data-original-title="Edit">' +
								'<i class="md-icon material-icons" data-toggle="modal" data-target="#edit-ressource-modal">&#xE150;</i>' +
							'</a> &nbsp;' +
							'<a href="#" onclick="deleteressource(this)" data-toggle="tooltip" data-original-title="Delete">' +
								'<i class="material-icons">&#xE5CD;</i>' +
							'</a>' +
						'</td>' ;
		    	
		    	$('#dt_tableTools').DataTable().row.add($('<tr>'+td1+td2+td3+td4+td5+'</tr>')).draw();
		    	swal("Créer!", "L'utilisateur a été créé.", "success");
			}
		});
    });*/
    
    /********************* Delete ressource********************************/ 
   function deleteRessource(field){
   var data = field.closest("td").id;
        swal({   
            title: "Are you sure?",   
            text: "You will not be able to recover this ressource!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Yes, delete it!",   
            closeOnConfirm: false 
        }, function(){ 
    		$.ajax({
    			url : '/admin/Ressources/delete',
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
    				swal("Deleted!", "The ressource has been deleted.", "success"); 
    				
    			}
    		})
           
        });
   }
