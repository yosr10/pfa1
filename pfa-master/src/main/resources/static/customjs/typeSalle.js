 /********************* Edit typeSalle********************************/
   function loadTypeSalle(field){ //open modal
   		var data = field.closest("td").id;
   		$('#idEdit').val(data);
    	$('#nomEdit').val($('#nom' + data).text());
    	$('#edit-typeSalle-modal').modal('show');
    }
    $("#typeSalle-edit-form" ).submit(function(event ) { //edit action
    	event.preventDefault();
    	var data = $('#idEdit').val();
    	$.ajax({
			url : '/admin/Type-Salles/update',
			type : 'POST',
			data :  $("#typeSalle-edit-form").serialize(),
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(response) {	
				$('#nom' + data).text($('#nomEdit').val());
				
		    	$('#edit-typeSalle-modal').modal('hide');
		    	swal("Updated!", "The typeSalle has been updated.", "success");
			}
		});
    });
    /*********************New typeSalle********************************/
    function newTypeSalle(){ //open modal
    	$('#nomNew').val('');
    	
    	$('#new-typeSalle-modal').modal('show');
    }
  /*  $( "#typeSalle-new-form" ).submit(function(event ) { //add action
    	event.preventDefault();
    	$.ajax({
			url : '/admin/Type-Salles/save',
			type : 'POST',
			data :  $("#typeSalle-new-form").serialize(),
			dataType: "text",
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(idNewtypeSalle) {	
				var firstName = $('#firstNameNew').val();
				var lastName = $('#lastNameNew').val();
				var email = $('#emailNew').val();
				var nextRow = $('#dt_tableTools').DataTable().column( 0 ).data().length + 1;
		    	$('#new-typeSalle-modal').modal('hide');
		    	var td1 ='<td><span>'+nextRow+'</span></td>' ;
		    	var td2 ='<td id="firstName'+idNewtypeSalle+'">'+firstName+'</td>' ; 
		    	var td3 ='<td id="lastName'+idNewtypeSalle+'">'+lastName+'</td>' ; 
		    	var td4 ='<td id="email'+idNewtypeSalle+'">'+email+'</td>' ; 
		    	var td5 ='<td id="'+idNewtypeSalle+'">' +
							'<a href="#" onclick="loadtypeSalle(this)" data-toggle="tooltip" data-original-title="Edit">' +
								'<i class="md-icon material-icons" data-toggle="modal" data-target="#edit-typeSalle-modal">&#xE150;</i>' +
							'</a> &nbsp;' +
							'<a href="#" onclick="deletetypeSalle(this)" data-toggle="tooltip" data-original-title="Delete">' +
								'<i class="material-icons">&#xE5CD;</i>' +
							'</a>' +
						'</td>' ;
		    	
		    	$('#dt_tableTools').DataTable().row.add($('<tr>'+td1+td2+td3+td4+td5+'</tr>')).draw();
		    	swal("Créer!", "L'utilisateur a été créé.", "success");
			}
		});
    });*/
    
    /********************* Delete typeSalle********************************/ 
   function deleteTypeSalle(field){
   var data = field.closest("td").id;
        swal({   
            title: "Are you sure?",   
            text: "You will not be able to recover this typeSalle!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Yes, delete it!",   
            closeOnConfirm: false 
        }, function(){ 
    		$.ajax({
    			url : '/admin/Type-Salles/delete',
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
    				swal("Deleted!", "The typeSalle has been deleted.", "success"); 
    				
    			}
    		})
           
        });
   }
