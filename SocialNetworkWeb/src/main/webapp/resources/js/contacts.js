


function dateFormatter(value, row) {
    var date = new Date(value);
    return  ('0' + date.getDay()).slice(-2) + "-" +  (date.getMonth() + 1) + "-" + date.getUTCFullYear();
}



function removeContacats() {
    var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
        return row.id;
    });


    var contactIds = {'name':'contactIds', 'value': ids.toString()};

    $.ajax({
        url: '/delete-contact',
        type: 'post',
        data: [contactIds],
        success: function (responce) {
            $table.bootstrapTable('remove', {
                field: 'id',
                values: ids
            });
        },
        error: function (e) {
            console.error('Cannot delete contact', e);
        }
    });
}

