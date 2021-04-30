 /********************* Edit groupe********************************/
   function loadGroupe(field){ //open modal
   		var data = field.closest("td").id;
   		$('#idEdit').val(data);
    	$('#nomEdit').val($('#nom' + data).text());
    	$('#abbreviationEdit').val($('#abbreviation' + data).text());
    	$('#niveauEdit').val($('#niveau' + data).text());
    	$('#edit-groupe-modal').modal('show');
    }
    $( "#groupe-edit-form" ).submit(function(event ) { //edit action
    	event.preventDefault();
    	var data = $('#idEdit').val();
    	$.ajax({
			url : '/admin/Groupes/update',
			type : 'POST',
			data :  $("#groupe-edit-form").serialize(),
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(response) {	
				$('#nom' + data).text($('#nomEdit').val());
				$('#abbreviation' + data).text($('#abbreviationEdit').val());
				$('#niveau' + data).text($('#niveauEdit').val());
		    	$('#edit-groupe-modal').modal('hide');
		    	swal("Updated!", "The groupe has been updated.", "success");
			}
		});
    });
    /*********************New groupe********************************/
    function newGroupe(){ //open modal
    	$('#nomNew').val('');
    	$('#abbreviationNew').val('');
    	$('#niveauNew').val('');
    	$('#new-groupe-modal').modal('show');
    }
  /*  $( "#groupe-new-form" ).submit(function(event ) { //add action
    	event.preventDefault();
    	$.ajax({
			url : '/admin/Groupes/save',
			type : 'POST',
			data :  $("#groupe-new-form").serialize(),
			dataType: "text",
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(idNewgroupe) {	
				var firstName = $('#firstNameNew').val();
				var lastName = $('#lastNameNew').val();
				var email = $('#emailNew').val();
				var nextRow = $('#dt_tableTools').DataTable().column( 0 ).data().length + 1;
		    	$('#new-groupe-modal').modal('hide');
		    	var td1 ='<td><span>'+nextRow+'</span></td>' ;
		    	var td2 ='<td id="firstName'+idNewgroupe+'">'+firstName+'</td>' ; 
		    	var td3 ='<td id="lastName'+idNewgroupe+'">'+lastName+'</td>' ; 
		    	var td4 ='<td id="email'+idNewgroupe+'">'+email+'</td>' ; 
		    	var td5 ='<td id="'+idNewgroupe+'">' +
							'<a href="#" onclick="loadgroupe(this)" data-toggle="tooltip" data-original-title="Edit">' +
								'<i class="md-icon material-icons" data-toggle="modal" data-target="#edit-groupe-modal">&#xE150;</i>' +
							'</a> &nbsp;' +
							'<a href="#" onclick="deletegroupe(this)" data-toggle="tooltip" data-original-title="Delete">' +
								'<i class="material-icons">&#xE5CD;</i>' +
							'</a>' +
						'</td>' ;
		    	
		    	$('#dt_tableTools').DataTable().row.add($('<tr>'+td1+td2+td3+td4+td5+'</tr>')).draw();
		    	swal("Créer!", "L'utilisateur a été créé.", "success");
			}
		});
    });*/
    
    /********************* Delete groupe********************************/ 
   function deleteGroupe(field){
   var data = field.closest("td").id;
        swal({   
            title: "Are you sure?",   
            text: "You will not be able to recover this groupe!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Yes, delete it!",   
            closeOnConfirm: false 
        }, function(){ 
    		$.ajax({
    			url : '/admin/Groupes/delete',
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
    				swal("Deleted!", "The groupe has been deleted.", "success"); 
    				
    			}
    		})
           
        });
   }
