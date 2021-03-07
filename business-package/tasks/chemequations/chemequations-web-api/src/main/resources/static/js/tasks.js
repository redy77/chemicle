//start
$(document).ready(function () {
    getAllTasks()
})

//getResponses
function getAllTasks() {
    $.ajax({
        type: 'get',
        url: '/tasks-chemequations-application/equations/v.1.0/',
        response: 'json',
        success: function (data) {
            setTasksTable(data)
        }
    })
}

function setTasksTable(result) {
    $('#taskTable').empty()
    $.each(result, function (i, task) {
        $('<tr>').append(
            $('<td>').append($('<a>').text(task.taskId).attr({
                "id": "linkId",
                "class": "btn btn-link text-secondaryt",
                "href": "#taskCard"
            }).data("task", task)),
            $('<td>').text(task.chapterId),
            $('<td>').text(task.referenceId),
        ).appendTo('#taskTable')
    })
}

$(document).on('click', '#linkId', function () {
    $('#answerForm').empty();
    let task = $(this).data('task');
    $('<div>').append(
        $('<input>').val(task.taskId).attr({"id": "taskId", "type": "hidden"}),
        $('<p>').text(task.description).attr({"id": "description"}),
        $('<textarea>').attr({
            "id": "userAnswer",
            "rows": "5",
            "class": "form-control"
        }),
        $('<a>').text('Answer').attr({
            "id": "btnTaskAnswer",
            "class":"btn btn-outline-success"
        })
    ).appendTo('#answerForm')
})

$(document).on('click', '#btnTaskAnswer', function () {
    let taskId = $('#taskId').val();
    let userAnswer = $('#userAnswer').val();
    // alert(taskId + userAnswer)

    $.ajax({
        type: 'POST',
        url: '/tasks-chemequations-application/equations/v.1.0/checkAnswer',
        data: {
            "taskId" : taskId,
            "userAnswer": userAnswer
        },
        timeout: 3000,
        success: function (date) {
            getResultAnswer(date)
        }
    });
})

function getResultAnswer(result) {
    $('#resultCard').empty();
    $.each(result.testResult, function (i, res) {
        $('<div>').append(
            $('<p>').text(res)
        ).appendTo('#resultCard');
    })
    $('<div>').append(
        $('<h4>').text(result.score + ' баллов!')
    ).appendTo('#resultCard');
}
