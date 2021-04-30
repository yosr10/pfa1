 /********************* Edit departement********************************/
   function loadDepartement(field){ //open modal
   		var data = field.closest("td").id;
   		$('#idEdit').val(data);
    	$('#nomEdit').val($('#nom' + data).text());
    	$('#etablissementEdit').val($('#etablissement' + data).text());
    
    	$('#edit-departement-modal').modal('show');
    }
    $( "#departement-edit-form" ).submit(function(event ) { //edit action
    	event.preventDefault();
    	var data = $('#idEdit').val();
    	$.ajax({
			url : '/admin/Departements/update',
			type : 'POST',
			data :  $("#departement-edit-form").serialize(),
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(response) {	
				$('#nom' + data).text($('#nomEdit').val());
				$('#etablissement' + data).text($('#etablissementEdit').val());
				
		    	$('#edit-departement-modal').modal('hide');
		    	swal("Updated!", "The departement has been updated.", "success");
			}
		});
    });
    /*********************New departement********************************/
    function newDepartement(){ //open modal
    	$('#nomNew').val('');
    	$('#etablissementNew').val('');
    	
    	$('#new-departement-modal').modal('show');
    }
  /*  $( "#departement-new-form" ).submit(function(event ) { //add action
    	event.preventDefault();
    	$.ajax({
			url : '/admin/Annee-Academiques/save',
			type : 'POST',
			data :  $("#departement-new-form").serialize(),
			dataType: "text",
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(idNewdepartement) {	
				var firstName = $('#firstNameNew').val();
				var lastName = $('#lastNameNew').val();
				var email = $('#emailNew').val();
				var nextRow = $('#dt_tableTools').DataTable().column( 0 ).data().length + 1;
		    	$('#new-departement-modal').modal('hide');
		    	var td1 ='<td><span>'+nextRow+'</span></td>' ;
		    	var td2 ='<td id="firstName'+idNewdepartement+'">'+firstName+'</td>' ; 
		    	var td3 ='<td id="lastName'+idNewdepartement+'">'+lastName+'</td>' ; 
		    	var td4 ='<td id="email'+idNewdepartement+'">'+email+'</td>' ; 
		    	var td5 ='<td id="'+idNewdepartement+'">' +
							'<a href="#" onclick="loaddepartement(this)" data-toggle="tooltip" data-original-title="Edit">' +
								'<i class="md-icon material-icons" data-toggle="modal" data-target="#edit-departement-modal">&#xE150;</i>' +
							'</a> &nbsp;' +
							'<a href="#" onclick="deletedepartement(this)" data-toggle="tooltip" data-original-title="Delete">' +
								'<i class="material-icons">&#xE5CD;</i>' +
							'</a>' +
						'</td>' ;
		    	
		    	$('#dt_tableTools').DataTable().row.add($('<tr>'+td1+td2+td3+td4+td5+'</tr>')).draw();
		    	swal("Créer!", "L'utilisateur a été créé.", "success");
			}
		});
    });*/
    
    /********************* Delete departement********************************/ 
   function deleteDepartement(field){
   var data = field.closest("td").id;
        swal({   
            title: "Are you sure?",   
            text: "You will not be able to recover this departement!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Yes, delete it!",   
            closeOnConfirm: false 
        }, function(){ 
    		$.ajax({
    			url : '/admin/Departements/delete',
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
    				swal("Deleted!", "The departement has been deleted.", "success"); 
    				
    			}
    		})
           
        });
   }
