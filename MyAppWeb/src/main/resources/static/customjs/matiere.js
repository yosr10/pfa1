 /********************* Edit matiere********************************/
   function loadMatiere(field){ //open modal
   		var data = field.closest("td").id;
   		$('#idEdit').val(data);
    	$('#nomEdit').val($('#nom' + data).text());
    	$('#descriptionEdit').val($('#description' + data).text());
    	$('#typeEdit').val($('#type' + data).text());
    	$('#nombreHeureEdit').val($('#nombreHeure' + data).text());
    	$('#volumeCEdit').val($('#volumeC' + data).text());
    	$('#volumeTpEdit').val($('#volumeTp' + data).text());
    	$('#volumeTdEdit').val($('#volumeTd' + data).text());
    	$('#creditEdit').val($('#credit' + data).text());
    	$('#coefficicentEdit').val($('#coefficicent' + data).text());
    	$('#edit-matiere-modal').modal('show');
    }
    $( "#matiere-edit-form" ).submit(function(event ) { //edit action
    	event.preventDefault();
    	var data = $('#idEdit').val();
    	$.ajax({
			url : '/admin/Matieres/update',
			type : 'POST',
			data :  $("#matiere-edit-form").serialize(),
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(response) {	
				$('#nom' + data).text($('#nomEdit').val());
				$('#description' + data).text($('#descriptionEdit').val());
				$('#type' + data).text($('#typeEdit').val());
				$('#nombreHeureEdit' + data).text($('#nombreHeure').val());
				$('#volumeC' + data).text($('#volumeCEdit').val());
				$('#volumeTp' + data).text($('#volumeTpEdit').val());
				$('#volumeTd' + data).text($('#volumeTdEdit').val());
				$('#credit' + data).text($('#credittypeEdit').val());
				$('#coefficient' + data).text($('#coefficientEdit').val());

				
				
				$('#edit-matiere-modal').modal('hide');
		    	swal("Updated!", "The matiere has been updated.", "success");
			}
		});
    });
    /*********************New Matiere********************************/
    function newMatiere(){ //open modal
    	$('#idEdit').val('');
    	$('#nomEdit').val('');
    	$('#descriptionEdit').val('');
    	$('#typeEdit').val('');
    	$('#nombreHeureEdit').val('');
    	$('#volumeCEdit').val('');
    	$('#volumeTpEdit').val('');
    	$('#volumeTdEdit').val('');
    	$('#creditEdit').val('');
    	$('#coefficicentEdit').val('');
    	
    	$('#new-matiere-modal').modal('show');
    }
    /*$( "#matiere-new-form" ).submit(function(event ) { //add action
    	event.preventDefault();
    	$.ajax({
			url : '/admin/new_matiere',
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
    /********************* Delete Matiere********************************/ 
   function deleteMatiere(field){
   var data = field.closest("td").id;
        swal({   
            title: "Are you sure?",   
            text: "You will not be able to recover this matiere!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Yes, delete it!",   
            closeOnConfirm: false 
        }, function(){ 
    		$.ajax({
    			url : '/admin/Matieres/delete',
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
    				swal("Deleted!", "The matiere has been deleted.", "success"); 
    				
    			}
    		})
           
        });
   }
 