 /********************* Edit salle********************************/
   function loadSalle(field){ //open modal
   		var data = field.closest("td").id;
   		$('#idEdit').val(data);
    	$('#numeroEdit').val($('#numero' + data).text());
    	$('#capaciteEdit').val($('#capacite' + data).text());
    	$('#disponibleEdit').val($('#disponible' + data).text());
    	$('#typeSalleEdit').val($('#typeSalle' + data).text());

    	$('#edit-salle-modal').modal('show');
    }
    $( "#salle-edit-form" ).submit(function(event ) { //edit action
    	event.preventDefault();
    	var data = $('#idEdit').val();
    	$.ajax({
			url : '/admin/Salles/update',
			type : 'POST',
			data :  $("#salle-edit-form").serialize(),
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(response) {	
				$('#numero' + data).text($('#numeroEdit').val());
				$('#capacite' + data).text($('#capaciteEdit').val());
				$('#disponible' + data).text($('#disponibleEdit').val());
				$('#typeSalle' + data).text($('#typeSalleEdit').val());
		    	$('#edit-salle-modal').modal('hide');
		    	swal("Updated!", "The salle has been updated.", "success");
			}
		});
    });
    /*********************New salle********************************/
    function newSalle(){ //open modal
    	$('#numeroNew').val('');
    	$('#capaciteNew').val('');
    	$('#disponibleNew').val('');
    	$('#typeSalleNew').val('');
    	$('#new-salle-modal').modal('show');
    }
  /*  $( "#salle-new-form" ).submit(function(event ) { //add action
    	event.preventDefault();
    	$.ajax({
			url : '/admin/Salles/save',
			type : 'POST',
			data :  $("#salle-new-form").serialize(),
			dataType: "text",
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(idNewsalle) {	
				var firstName = $('#firstNameNew').val();
				var lastName = $('#lastNameNew').val();
				var email = $('#emailNew').val();
				var nextRow = $('#dt_tableTools').DataTable().column( 0 ).data().length + 1;
		    	$('#new-salle-modal').modal('hide');
		    	var td1 ='<td><span>'+nextRow+'</span></td>' ;
		    	var td2 ='<td id="firstName'+idNewsalle+'">'+firstName+'</td>' ; 
		    	var td3 ='<td id="lastName'+idNewsalle+'">'+lastName+'</td>' ; 
		    	var td4 ='<td id="email'+idNewsalle+'">'+email+'</td>' ; 
		    	var td5 ='<td id="'+idNewsalle+'">' +
							'<a href="#" onclick="loadsalle(this)" data-toggle="tooltip" data-original-title="Edit">' +
								'<i class="md-icon material-icons" data-toggle="modal" data-target="#edit-salle-modal">&#xE150;</i>' +
							'</a> &nbsp;' +
							'<a href="#" onclick="deletesalle(this)" data-toggle="tooltip" data-original-title="Delete">' +
								'<i class="material-icons">&#xE5CD;</i>' +
							'</a>' +
						'</td>' ;
		    	
		    	$('#dt_tableTools').DataTable().row.add($('<tr>'+td1+td2+td3+td4+td5+'</tr>')).draw();
		    	swal("Créer!", "L'utilisateur a été créé.", "success");
			}
		});
    });*/
    
    /********************* Delete salle********************************/ 
   function deleteSalle(field){
   var data = field.closest("td").id;
        swal({   
            title: "Are you sure?",   
            text: "You will not be able to recover this salle!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Yes, delete it!",   
            closeOnConfirm: false 
        }, function(){ 
    		$.ajax({
    			url : '/admin/Salles/delete',
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
    				swal("Deleted!", "The salle has been deleted.", "success"); 
    				
    			}
    		})
           
        });
   }
