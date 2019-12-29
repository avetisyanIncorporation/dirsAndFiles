"use strict";

$(function() {
    $('#addToList').click(function() {
        $.ajax({
            type : 'GET',
            url : '/add-directory',
            data : { path : $('#newDirectoryPath').val() },
            success : function(directoryDTO) {
                $('#directoriesTable').append(createAndGetTableTr(directoryDTO));
                $('#newDirectoryPath').val('');
            },
            error : function() {
                alert('error');
            }
        });
    });

    function createAndGetTableTr(directoryDTO) {
        var tr = document.createElement('tr');
        for (var key in directoryDTO) {
            if (key !== 'id' && key !== 'filesSizeCount') {
                var td = document.createElement('td');
                td.innerText = directoryDTO[key];
                $(td).appendTo(tr);
            }
        }
        var td = document.createElement('td');
        var button = document.createElement('button');
        button.className = 'show-files';
        button.type = 'button';
        button.setAttribute('path', 'directory/' + directoryDTO.id);
        button.innerText = 'Файлы';

        $(button).appendTo(td);
        $(td).appendTo(tr);
        return tr;
    }

    $('body').on('click', '.show-files', function() {
        $.ajax({
            type : 'GET',
            url : $(this).attr('path'),
            success : function(data) {
                $('#tableFragmentWrapper').html(data);
                $('.files-fragment').show();
            },
            error : function() {
                alert('error');
            }
        });
    });

    $('body').on('click', '.close-popup', function() {
        $('.files-fragment').hide();
    });
});