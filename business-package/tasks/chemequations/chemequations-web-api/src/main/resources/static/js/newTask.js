// $(document).ready(function(){
//      alert('herota2');
// })

// Add user
$(document).on("click", "#btnNewTask", function () {
    let taskDto = $("#formAddNewTask").serializeArray();
    $('#taskId').val('0');
    $('#chapterId').val('');
    $('#referenceId').val('');
    $('#description').val('');
    $('#rightAnswer').val('');

    $.ajax({
        type: 'POST',
        url: '/tasks-chemequations-application/equations/v.1.0',
        data: taskDto,
        timeout: 3000,
        success: function (){
            alert('Задача добавлена.')
        }
    });
});