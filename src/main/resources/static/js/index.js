/**
 * 
 */
$(document).ready(function initial() {
			checkToday();
});


function getDiv(data) {
	return '<div class="list-item" id=div-' + data.id  + '>' +
					'<p class="todo-text">' + data.task +  '</p>' +
					'<form class="btn-form" id=form-' + data.id  + ' method="POST">' +
						'<input type="hidden" style="display: none;" name="id" value=' + data.id + ' }></input>' +
						'<button class="remove-icon" type="submit" onclick="removeTask(' + data.id + ')"><i class="fa fa-trash" style="color: white; font-size: 1.5em;"></i></button>' +
					'</form>' +
				'</div>'
}

function checkPending() {
	$.ajax({
		url: '/todo/pendingTasks',
		type: 'get',
		success: function(data) {
			console.log(data);
			$('#pendingTasks').empty();
			for (let i = 0; i < data.length; i++) {
				var initial = getDiv(data[i]);

				$('#pendingTasks').append(initial);
			}
		}
	})
}

function checkToday() {
	$.ajax({
		url: '/todo/todayTasks',
		type: 'get',
		success: function(data) {
			console.log(data);
			$('#todayTasks').empty();
			for (let i = 0; i < data.length; i++) {
				var initial = getDiv(data[i]);
				$('#todayTasks').append(initial);
			}
		}
	})
}

function addTask() {
	$('#addForm').one('submit', function(event) {
		event.preventDefault();
		var form = $(this);
		
		$.ajax({
			url: "/todo/add",
			type: 'post',
			data: form.serialize(),
			success: function() {
				checkToday();
				$("#add").val('');
			}
		})
		
		event.stopImmediatePropagation();
    	return false;
	})
}

let removeTask = (id) => {
	
	$("#form-"+id).on('submit', function(event) {
		event.preventDefault();
		var form = $(this);
	
		$.ajax({
			url: "/todo/remove",
			type: "post",
			data: form.serialize(),
			success: function () {
				$("#div-"+id).remove();
			}
		})
	
	})
}