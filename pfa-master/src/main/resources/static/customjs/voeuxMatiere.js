 /********************* Edit voeuxMatiere********************************/
   function loadVoeuxMatiere(field){ //open modal
   		var data = field.closest("td").id;
   		$('#IdEdit').val(data);
    	$('#affecteEdit').val($('#affecte' + data).text());
    	$('#matiereIdEdit').val($('#matiereId' + data).text());
    	$('#edit-voeuxMatiere-modal').modal('show');
    }
    $( "#voeuxMatiere-edit-form" ).submit(function(event ) { //edit action
    	event.preventDefault();
    	var data = $('#idEdit').val();
    	$.ajax({
			url : '/admin/Voeux-Matieres/update',
			type : 'POST',
			data :  $("#voeuxMatiere-edit-form").serialize(),
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(response) {	
				$('#affecte' + data).text($('#affecteEdit').val());
				$('#matiereId' + data).text($('#matiereIdEdit').val());
				
		    	$('#edit-voeuxMatiere-modal').modal('hide');
		    	swal("Updated!", "The voeuxMatiere has been updated.", "success");
			}
		});
    });
    /*********************New voeuxMatiere********************************/
    function newVoeuxMatiere(){ //open modal
    	$('#affecteNew').val('');
    	$('#matiereNew').val('');
    	
    	$('#new-voeuxMatiere-modal').modal('show');
    }
  /*  $( "#voeuxMatiere-new-form" ).submit(function(event ) { //add action
    	event.preventDefault();
    	$.ajax({
			url : '/admin/Voeux-Matieres/save',
			type : 'POST',
			data :  $("#voeuxMatiere-new-form").serialize(),
			dataType: "text",
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(idNewvoeuxMatiere) {	
				var firstName = $('#firstNameNew').val();
				var lastName = $('#lastNameNew').val();
				var email = $('#emailNew').val();
				var nextRow = $('#dt_tableTools').DataTable().column( 0 ).data().length + 1;
		    	$('#new-voeuxMatiere-modal').modal('hide');
		    	var td1 ='<td><span>'+nextRow+'</span></td>' ;
		    	var td2 ='<td id="firstName'+idNewvoeuxMatiere+'">'+firstName+'</td>' ; 
		    	var td3 ='<td id="lastName'+idNewvoeuxMatiere+'">'+lastName+'</td>' ; 
		    	var td4 ='<td id="email'+idNewvoeuxMatiere+'">'+email+'</td>' ; 
		    	var td5 ='<td id="'+idNewvoeuxMatiere+'">' +
							'<a href="#" onclick="loadvoeuxMatiere(this)" data-toggle="tooltip" data-original-title="Edit">' +
								'<i class="md-icon material-icons" data-toggle="modal" data-target="#edit-voeuxMatiere-modal">&#xE150;</i>' +
							'</a> &nbsp;' +
							'<a href="#" onclick="deletevoeuxMatiere(this)" data-toggle="tooltip" data-original-title="Delete">' +
								'<i class="material-icons">&#xE5CD;</i>' +
							'</a>' +
						'</td>' ;
		    	
		    	$('#dt_tableTools').DataTable().row.add($('<tr>'+td1+td2+td3+td4+td5+'</tr>')).draw();
		    	swal("Créer!", "L'utilisateur a été créé.", "success");
			}
		});
    });*/
    
    /********************* Delete voeuxMatiere********************************/ 
   function deleteVoeuxMatiere(field){
   var data = field.closest("td").id;
        swal({   
            title: "Are you sure?",   
            text: "You will not be able to recover this voeuxMatiere!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Yes, delete it!",   
            closeOnConfirm: false 
        }, function(){ 
    		$.ajax({
    			url : '/admin/Voeux-Matieres/delete',
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
    				swal("Deleted!", "The voeuxMatiere has been deleted.", "success"); 
    				
    			}
    		})
           
        });
   }
