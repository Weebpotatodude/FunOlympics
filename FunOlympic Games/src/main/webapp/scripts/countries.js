var countries = Object.values(countries);
var select = document.getElementById('country');

for (var i = 0; i < countries.length; i++) {
    var option = document.createElement('option');
    option.value = countries[i].name;
    option.text = countries[i].name;
    select.appendChild(option);
}