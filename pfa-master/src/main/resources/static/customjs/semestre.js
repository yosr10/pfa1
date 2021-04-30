 /********************* Edit semestre********************************/
   function loadSemestre(field){ //open modal
   		var data = field.closest("td").id;
   		$('#idEdit').val(data);
    	
    	$('#numeroEdit').val($('#numero' + data).text());
    	$('#edit-semestre-modal').modal('show');
    }
    $( "#semestre-edit-form" ).submit(function(event ) { //edit action
    	event.preventDefault();
    	var data = $('#idEdit').val();
    	$.ajax({
			url : '/admin/Semestres/update',
			type : 'POST',
			data :  $("#semestre-edit-form").serialize(),
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(response) {	
				
				$('numero' + data).text($('#numeroEdit').val());
		    	$('#edit-semestre-modal').modal('hide');
		    	swal("Updated!", "The semestre has been updated.", "success");
			}
		});
    });
    /*********************New semestre********************************/
    function newSemestre(){ //open modal
    	$('#debutAnneeNew').val('');
    	$('#finAnneeNew').val('');
    	$('#etatNew').val('');
    	$('#new-semestre-modal').modal('show');
    }
  /*  $( "#semestre-new-form" ).submit(function(event ) { //add action
    	event.preventDefault();
    	$.ajax({
			url : '/admin/Semestres/save',
			type : 'POST',
			data :  $("#semestre-new-form").serialize(),
			dataType: "text",
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(idNewsemestre) {	
				var firstName = $('#firstNameNew').val();
				var lastName = $('#lastNameNew').val();
				var email = $('#emailNew').val();
				var nextRow = $('#dt_tableTools').DataTable().column( 0 ).data().length + 1;
		    	$('#new-semestre-modal').modal('hide');
		    	var td1 ='<td><span>'+nextRow+'</span></td>' ;
		    	var td2 ='<td id="firstName'+idNewsemestre+'">'+firstName+'</td>' ; 
		    	var td3 ='<td id="lastName'+idNewsemestre+'">'+lastName+'</td>' ; 
		    	var td4 ='<td id="email'+idNewsemestre+'">'+email+'</td>' ; 
		    	var td5 ='<td id="'+idNewsemestre+'">' +
							'<a href="#" onclick="loadsemestre(this)" data-toggle="tooltip" data-original-title="Edit">' +
								'<i class="md-icon material-icons" data-toggle="modal" data-target="#edit-semestre-modal">&#xE150;</i>' +
							'</a> &nbsp;' +
							'<a href="#" onclick="deletesemestre(this)" data-toggle="tooltip" data-original-title="Delete">' +
								'<i class="material-icons">&#xE5CD;</i>' +
							'</a>' +
						'</td>' ;
		    	
		    	$('#dt_tableTools').DataTable().row.add($('<tr>'+td1+td2+td3+td4+td5+'</tr>')).draw();
		    	swal("Créer!", "L'utilisateur a été créé.", "success");
			}
		});
    });*/
    
    /********************* Delete semestre********************************/ 
   function deleteSemestre(field){
   var data = field.closest("td").id;
        swal({   
            title: "Are you sure?",   
            text: "You will not be able to recover this semestre!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Yes, delete it!",   
            closeOnConfirm: false 
        }, function(){ 
    		$.ajax({
    			url : '/admin/Semestres/delete',
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
    				swal("Deleted!", "The semestre has been deleted.", "success"); 
    				
    			}
    		})
           
        });
   }
