 /********************* Edit seance********************************/
   function loadSeance(field){ //open modal
   		var data = field.closest("td").id;
   		$('#idEdit').val(data);
    	$('#numeroEdit').val($('#numero' + data).text());
    	$('#jourEdit').val($('#jour' + data).text());
    	$('#emploiEdit').val($('#emploi' + data).text());
    	$('#creneauEdit').val($('#creneau' + data).text());
    	$('#matiereEdit').val($('#matiere' + data).text());
    	$('#salleEdit').val($('#salle' + data).text());


    	$('#edit-seance-modal').modal('show');
    }
    $( "#seance-edit-form" ).submit(function(event ) { //edit action
    	event.preventDefault();
    	var data = $('#idEdit').val();
    	$.ajax({
			url : '/admin/Seances/update',
			type : 'POST',
			data :  $("#seance-edit-form").serialize(),
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(response) {	
				$('#numero' + data).text($('#numeroEdit').val());
				$('#jour' + data).text($('#jourEdit').val());
				$('#emploi' + data).text($('#emploiEdit').val());
				$('#creneau' + data).text($('#creneauEdit').val());
				$('#matiere' + data).text($('#matiereEdit').val());
				$('#salle' + data).text($('#salleEdit').val());

		    	$('#edit-seance-modal').modal('hide');
		    	swal("Updated!", "The seance has been updated.", "success");
			}
		});
    });
    /*********************New seance********************************/
    function newSeance(){ //open modal
    	$('#numeroNew').val('');
    	$('#jourNew').val('');
    	$('#emploiNew').val('');
    	$('#creneauNew').val('');
    	$('matiereNew').val('');
    	$('#salleNew').val('');

    	$('#new-seance-modal').modal('show');
    }
  /*  $( "#seance-new-form" ).submit(function(event ) { //add action
    	event.preventDefault();
    	$.ajax({
			url : '/admin/Seances/save',
			type : 'POST',
			data :  $("#seance-new-form").serialize(),
			dataType: "text",
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(idNewseance) {	
				var firstName = $('#firstNameNew').val();
				var lastName = $('#lastNameNew').val();
				var email = $('#emailNew').val();
				var nextRow = $('#dt_tableTools').DataTable().column( 0 ).data().length + 1;
		    	$('#new-seance-modal').modal('hide');
		    	var td1 ='<td><span>'+nextRow+'</span></td>' ;
		    	var td2 ='<td id="firstName'+idNewseance+'">'+firstName+'</td>' ; 
		    	var td3 ='<td id="lastName'+idNewseance+'">'+lastName+'</td>' ; 
		    	var td4 ='<td id="email'+idNewseance+'">'+email+'</td>' ; 
		    	var td5 ='<td id="'+idNewseance+'">' +
							'<a href="#" onclick="loadseance(this)" data-toggle="tooltip" data-original-title="Edit">' +
								'<i class="md-icon material-icons" data-toggle="modal" data-target="#edit-seance-modal">&#xE150;</i>' +
							'</a> &nbsp;' +
							'<a href="#" onclick="deleteseance(this)" data-toggle="tooltip" data-original-title="Delete">' +
								'<i class="material-icons">&#xE5CD;</i>' +
							'</a>' +
						'</td>' ;
		    	
		    	$('#dt_tableTools').DataTable().row.add($('<tr>'+td1+td2+td3+td4+td5+'</tr>')).draw();
		    	swal("Créer!", "L'utilisateur a été créé.", "success");
			}
		});
    });*/
    
    /********************* Delete seance********************************/ 
   function deleteSeance(field){
   var data = field.closest("td").id;
        swal({   
            title: "Are you sure?",   
            text: "You will not be able to recover this seance!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Yes, delete it!",   
            closeOnConfirm: false 
        }, function(){ 
    		$.ajax({
    			url : '/admin/Seances/delete',
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
    				swal("Deleted!", "The seance has been deleted.", "success"); 
    				
    			}
    		})
           
        });
   }
