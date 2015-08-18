var myGeoObject;
var curentcoordinate;

function addPlaces() {
    var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
        return row.id;
    });


    var data = [{'name':'contactIds', 'value': ids.toString()},
        {'name':'title', 'value' : $('#title').val()},
        {'name':'description', 'value' : $('#description').val()},
        {'name':'longitude', 'value' : curentcoordinate[0]},
        {'name':'latitude', 'value' :  curentcoordinate[1]}];

    $.ajax({
        url: '/add-place',
        type: 'post',
        data: data,
        success: function (responce) {
            showAddPlacesPage();
        },
        error: function (e) {
            console.error('Cannot delete contact', e);
        }
    });
}

function faindCoordinations(e) {

    if (!map.balloon.isOpen()) {
        var coords = e.get('coords');
        createMark(coords);
        curentcoordinate = coords;
    }
    else {
        map.balloon.close();
    }
}

function createMark(coordinates) {
    if (myGeoObject) {
        map.geoObjects.remove(myGeoObject);
    }
    myGeoObject = new ymaps.GeoObject({
        // Описание геометрии.
        geometry: {
            type: "Point",
            coordinates: coordinates
        }
    }, {
        // Опции.
        // Иконка метки будет растягиваться под размер ее содержимого.
        preset: 'islands#blackStretchyIcon',
        // Метку можно перемещать.
        draggable: false
    });

    map.geoObjects.add(myGeoObject)
}