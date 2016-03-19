onload = function () {
    console.log('IN HERE DUDES');
    init();
};

function init() {
    var btn1 = document.getElementById('btn1');
    document.getElementById('btn2').addEventListener('click', ping);
    btn1.addEventListener('click', getFood);
};

var getFood = function (event) {
    event.preventDefault();
    console.log("button clicked ok guys");
    xhrMethod('GET', displayResponse, 'http://api.nal.usda.gov/ndb/reports/?ndbno=19095&type=b&format=JSON&api_key=', 'luHpcYzCW0AElRtcgcBmVrWyfRqYQQobhJuycS70');
};

var xhrMethod = function (method, callback, url, apiKey, obj) {
    var xhr = new XMLHttpRequest();
    if (apiKey) {
        xhr.open(method, url + apiKey);
    } else if (!apiKey && obj) {
        console.log("in the else ifXX");
        console.log(method);
        xhr.open(method, url);
        xhr.setRequestHeader('Content-Type', 'application/json');
    } else {
        xhr.open(method, url);
    }
    xhr.onreadystatechange = function () {
        console.log('state changing like a transformer');

        if (xhr.readyState === 4 && xhr.status < 400) {
            console.log('we have a response');
            if (apiKey) {
                var foodObj = JSON.parse(xhr.responseText);
                callback(foodObj);
            } else if (obj) {
                var responseString = xhr.responseText;
                callback(responseString);
            }else {
                var responseString = xhr.responseText;
                callback(responseString);
            }
        } else {
            console.log(xhr.status);
        }
    }
    if(obj) {
        xhr.send(JSON.stringify(obj));
    } else{
    xhr.send();        
    }
}

var displayResponse = function (foodObj) {
    console.log(foodObj);
    console.log(foodObj.report.food.nutrients.length);
    var nutrients = [];
    for (var i = 0; i < foodObj.report.food.nutrients.length; i++) {
        var measureArr = [];
        for (var j = 0; j < foodObj.report.food.nutrients[i].measures.length; j++) {
            var meas = new measure(foodObj.report.food.nutrients[i].measures[j].eqv, foodObj.report.food.nutrients[i].measures[j].label, foodObj.report.food.nutrients[i].measures[j].qty, foodObj.report.food.nutrients[i].measures[j].value, foodObj.report.food.nutrients[i].nutrient_id, foodObj.report.food.ndbno);
            measureArr.push(meas);
        }
        var nut = new nutrient(foodObj.report.food.nutrients[i].group, foodObj.report.food.nutrients[i].name, foodObj.report.food.nutrients[i].nutrient_id, foodObj.report.food.nutrients[i].unit, foodObj.report.food.nutrients[i].value, measureArr, foodObj.report.food.ndbno);
        nutrients.push(nut);
    }
    var newFood = new food(foodObj.report.food.name, foodObj.report.food.ndbno, nutrients);
    console.log(newFood);
    xhrMethod('POST', displayPing, 'http://localhost:8080/NutriTrac/rest/foodObj', false, newFood);
};

function food(name, ndbno, nutrients) {
    this.name = name;
    this.ndbno = ndbno;
    this.nutrients = nutrients;
}

function nutrient(group, name, nutrient_id, unit, value, measures, food) {
    this.group = group;
    this.name = name;
    this.nutrientId = nutrient_id;
    this.unit = unit;
    this.value = value;
    this.measures = measures;
    this.food = food;
    
}

function measure(eqv, label, qty, value, nutrient, food) {
    this.eqv = eqv;
    this.label = label;
    this.qty = qty;
    this.value = value;
    // this.nutrient = nutrient;
    this.food = food;
}

var ping = function (event) {
    event.preventDefault();
//    xhrMethod('GET', displayPing, 'http://52.89.185.185:8080/NutriTrac/rest/ping');
    xhrMethod('GET', displayPing, 'http://localhost:8080/NutriTrac/rest/ping');

}

var displayPing = function (response) {
    var div1 = document.getElementById('displayJson');
    var head = document.createElement('h1');
    div1.appendChild(head);
    head.innerHTML = response;
}