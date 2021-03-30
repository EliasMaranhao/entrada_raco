var idCheckBoxUF = '';
var checkBox ;
var ddds;

$(document).ready(function(){
	$('#customFile').on('change',function(event){
		var fileName = $(this).val();
		$(this).next('.custom-file-label').html(fileName);
	});

	$('#btnCarregarAudio').off('click').on('click',function(event){
		var fd = new FormData();
		var files = $('#customFile')[0].files[0];
		fd.append('file', files);
		
        $.ajax({
            url: '/sgm/evento/tracks', 
            type: 'post', 
            data: fd, 
            contentType: false, 
            processData: false, 
            success: function(response){ 
                if(response != 0){ 
                   
                } 
                else{ 
                    
                } 
            }, 
        });
	});
	
	$('.jqCheckBoxCl').off('click').on('click', function(event){
		checkBox = $(event.target);
		
		ddds = checkBox.data('ddds');
		idCheckBoxUF = checkBox.attr('id');
		
		mostrarCheckBoxDDD();
	});
});

function habilitaCheckBox(){
	for(var i=0; i<ddds.length; i++){
		$('#'+ddds[i]).prop('disabled', false);
	}
}

function desabilitaCheckBox(){
	for(var i=0; i<ddds.length; i++){
		if($('#'+ddds[i]).is(':checked')){
			$('#'+ddds[i]).prop('checked', false);
		}
		$('#'+ddds[i]).prop('disabled', true);
	}
}

//function addCheckBoxDDD(ddds) {
//	for(var i=0; i<ddds.length; i++){
//		var containerDdd = $('<div />', {class: 'custom-control custom-checkbox custom-control-inline col-sm-1', id:idCheckBoxUF+ddds[i]});
//		$('<input />', { type: 'checkbox', id: 'ddd' + ddds[i], value: ddds[i], class: 'custom-control-input' }).appendTo(containerDdd);
//		$('<label />', { for: 'ddd' + ddds[i], text: ddds[i], class: 'custom-control-label' }).appendTo(containerDdd);
//		containerDdd.appendTo($('#ddds'));
//	}
//}
//
//function removeCheckBoxDDD(ddds) {
//	for(var i=0; i<ddds.length; i++){
//		$('#'+idCheckBoxUF+ddds[i]).remove();
//	}
//}

function mostrarCheckBoxDDD(){
	if(checkBox.is(':checked')){
		habilitaCheckBox();
	}else if(!checkBox.is(":checked")){
		desabilitaCheckBox()
	}
}