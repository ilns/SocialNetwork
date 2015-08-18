var pageContent;
$(document).ready(function(){

    pageContent = $('#page-content-wrapper');

});


function showMessagesPage() {
    $.get('/html/messages', function (data) {
        loadHTML(data);
    });
}

function showContactsPage() {
    $.get('/html/contacts', function (data) {
        loadHTML(data);
    });

}
function showAddContactsPage() {
    $.get('/html/add-contact', function (data) {
        loadHTML(data);
    });
}

function showAddPlacesPage() {
    $.get('/html/add-place', function (data) {
        loadHTML(data);
    });
}

function loadHTML(html) {
    pageContent.html(html);
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