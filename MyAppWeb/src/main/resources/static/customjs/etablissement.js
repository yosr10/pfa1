 /********************* Edit etablissement********************************/
   function loadEtablissement(field){ //open modal
   		var data = field.closest("td").id;
   		$('#idEdit').val(data);
    	$('#nomEdit').val($('#nom' + data).text());
    	$('#abbreviationEdit').val($('#abbreviation' + data).text());
    	$('#adresseEdit').val($('#adresse' + data).text());
    	$('#logoEdit').val($('#logo' + data).text());

    	$('#edit-etablissement-modal').modal('show');
    }
    $( "#etablissement-edit-form" ).submit(function(event ) { //edit action
    	event.preventDefault();
    	var data = $('#idEdit').val();
    	$.ajax({
			url : '/admin/Etablissements/update',
			type : 'POST',
			data :  $("#etablissement-edit-form").serialize(),
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(response) {	
				$('#nom' + data).text($('#nomEdit').val());
				$('#abbreviation' + data).text($('#abbreviationEdit').val());
				$('#adresse' + data).text($('#adresseEdit').val());
				$('#logo' + data).text($('#logoEdit').val());
		    	$('#edit-etablissement-modal').modal('hide');
		    	swal("Updated!", "The etablissement has been updated.", "success");
			}
		});
    });
    /*********************New etablissement********************************/
    function newEtablissement(){ //open modal
    	$('#nomNew').val('');
    	$('#abbreviationNew').val('');
    	$('#adresseNew').val('');
    	$('#logoNew').val('');
    	$('#new-etablissement-modal').modal('show');
    }
  /*  $( "#etablissement-new-form" ).submit(function(event ) { //add action
    	event.preventDefault();
    	$.ajax({
			url : '/admin/Etablissements/save',
			type : 'POST',
			data :  $("#etablissement-new-form").serialize(),
			dataType: "text",
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(idNewetablissement) {	
				var firstName = $('#firstNameNew').val();
				var lastName = $('#lastNameNew').val();
				var email = $('#emailNew').val();
				var nextRow = $('#dt_tableTools').DataTable().column( 0 ).data().length + 1;
		    	$('#new-etablissement-modal').modal('hide');
		    	var td1 ='<td><span>'+nextRow+'</span></td>' ;
		    	var td2 ='<td id="firstName'+idNewetablissement+'">'+firstName+'</td>' ; 
		    	var td3 ='<td id="lastName'+idNewetablissement+'">'+lastName+'</td>' ; 
		    	var td4 ='<td id="email'+idNewetablissement+'">'+email+'</td>' ; 
		    	var td5 ='<td id="'+idNewetablissement+'">' +
							'<a href="#" onclick="loadetablissement(this)" data-toggle="tooltip" data-original-title="Edit">' +
								'<i class="md-icon material-icons" data-toggle="modal" data-target="#edit-etablissement-modal">&#xE150;</i>' +
							'</a> &nbsp;' +
							'<a href="#" onclick="deleteetablissement(this)" data-toggle="tooltip" data-original-title="Delete">' +
								'<i class="material-icons">&#xE5CD;</i>' +
							'</a>' +
						'</td>' ;
		    	
		    	$('#dt_tableTools').DataTable().row.add($('<tr>'+td1+td2+td3+td4+td5+'</tr>')).draw();
		    	swal("Créer!", "L'utilisateur a été créé.", "success");
			}
		});
    });*/
    
    /********************* Delete etablissement********************************/ 
   function deleteEtablissement(field){
   var data = field.closest("td").id;
        swal({   
            title: "Are you sure?",   
            text: "You will not be able to recover this etablissement!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Yes, delete it!",   
            closeOnConfirm: false 
        }, function(){ 
    		$.ajax({
    			url : '/admin/Etablissements/delete',
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
    				swal("Deleted!", "The etablissement has been deleted.", "success"); 
    				
    			}
    		})
           
        });
   }
