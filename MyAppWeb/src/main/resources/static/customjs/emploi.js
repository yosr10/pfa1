 /********************* Edit emploi********************************/
   function loadEmploi(field){ //open modal
   		var data = field.closest("td").id;
   		$('#idEdit').val(data);
    	$('#versionEdit').val($('#version' + data).text());
    	$('#dateDebutEdit').val($('#dateDebut' + data).text());
    	$('#dateFinEdit').val($('#dateFin' + data).text());
    	$('#anneeEdit').val($('#annee' + data).text());
    	$('#semestreEdit').val($('#semestre' + data).text());
    	$('#groupeEdit').val($('#groupe' + data).text());
    	$('#edit-emploi-modal').modal('show');
    }
    $( "#emploi-edit-form" ).submit(function(event ) { //edit action
    	event.preventDefault();
    	var data = $('#idEdit').val();
    	$.ajax({
			url : '/admin/Emplois/update',
			type : 'POST',
			data :  $("#emploi-edit-form").serialize(),
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(response) {	
				$('#version' + data).text($('#versionEdit').val());
				$('#dateDebut' + data).text($('#dateDebutEdit').val());
				$('#dateFin' + data).text($('#dateFinEdit').val());
				$('#annee' + data).text($('#anneeEdit').val());
				$('#semestre' + data).text($('#semestreEdit').val());
				$('#groupe' + data).text($('#groupeEdit').val());
		    	$('#edit-emploi-modal').modal('hide');
		    	swal("Updated!", "The Emploi has been updated.", "success");
			}
		});
    });
    /*********************New emploi********************************/
    function newEmploi(){ //open modal
    	$('#versionNew').val('');
    	$('#dateDebutNew').val('');
    	$('#dateFinNew').val('');
    	$('#anneeNew').val('');
    	$('#semestreNew').val('');
    	$('#groupeNew').val('');

    	$('#new-emploi-modal').modal('show');
    }
  /*  $( "#emploi-new-form" ).submit(function(event ) { //add action
    	event.preventDefault();
    	$.ajax({
			url : '/admin/Annee-Academiques/save',
			type : 'POST',
			data :  $("#emploi-new-form").serialize(),
			dataType: "text",
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(idNewemploi) {	
				var firstName = $('#firstNameNew').val();
				var lastName = $('#lastNameNew').val();
				var email = $('#emailNew').val();
				var nextRow = $('#dt_tableTools').DataTable().column( 0 ).data().length + 1;
		    	$('#new-emploi-modal').modal('hide');
		    	var td1 ='<td><span>'+nextRow+'</span></td>' ;
		    	var td2 ='<td id="firstName'+idNewemploi+'">'+firstName+'</td>' ; 
		    	var td3 ='<td id="lastName'+idNewemploi+'">'+lastName+'</td>' ; 
		    	var td4 ='<td id="email'+idNewemploi+'">'+email+'</td>' ; 
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
    
    /********************* Delete emploi********************************/ 
   function deleteEmploi(field){
   var data = field.closest("td").id;
        swal({   
            title: "Are you sure?",   
            text: "You will not be able to recover this emploi!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Yes, delete it!",   
            closeOnConfirm: false 
        }, function(){ 
    		$.ajax({
    			url : '/admin/Emplois/delete',
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
    				swal("Deleted!", "The Emploi has been deleted.", "success"); 
    				
    			}
    		})
           
        });
   }
