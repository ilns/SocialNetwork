
var pageContent;
$(document).ready(function(){

    pageContent = $('#page-content-wrapper');

});


function showMessagesPage() {
    $.get('/html/messages', function (data) {
        pageContent.html(data);
    });
}

function showContactsPage() {
    $.get('/html/contacts', function (data) {
        pageContent.html(data);
    });

}
function showAddContactsPage() {
    $.get('/html/add-contact', function (data) {
        pageContent.html(data);
    });
}

function submitContact(){
    console.log('form submited');
        $.ajax({
            url: '/add-contact',
            type: 'post',
            data: $("#addNewContact").serializeArray(),
            success: function () {
                showContactsPage();
            },
            error: function (e) {
                console.error('Whoa, error', e);
            }
        });
}