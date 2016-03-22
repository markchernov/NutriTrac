var XMLHttpRequest = require('xmlhttprequest').XMLHttpRequest;

// FOR IN BROWSER
// onload = function () {
//     console.log('IN HERE DUDES');
//     init();
// };

var scrapeTimer = {
    start: function () {
        this.interval = setInterval(getUSDA, 500);
    },
    clear: function () {
        clearInterval(this.interval);
        console.log("XXXXclear interval called and stuffXXXX");
    }
};

//var ndbno = 1115;
var ndbno = 1001;
//var ndbno = 36633;

var place = 0;

var apiKeys = [apkey1, apkey2, apkey3, apkey4, apkey5, apkey6, apkey7, apkey8];


function init() {
  // setTimer();
    var btn1 = document.getElementById('btn1');
    document.getElementById('btn2').addEventListener('click', ping);
    btn1.addEventListener('click', getFood);
    document.getElementById('btn3').addEventListener('click', setTimer);
}

var setTimer = function (event) {
    //FOR In-Browser Version
    //event.preventDefault();
    scrapeTimer.start();
};

var getUSDA = function() {
    
    if(place === 7) {
        place = 0;
    } else {
        place += 1;
    }
    apiKey = apiKeys[place];
    
    if(ndbno < 10000) {
        var url1 = 'http://api.nal.usda.gov/ndb/reports/?ndbno=0';
    } else {
        var url1 = 'http://api.nal.usda.gov/ndb/reports/?ndbno=';
    }
    var url2 = '&type=b&format=JSON&api_key=';
    
    xhrMethod('GET', displayResponse, url1 + ndbno + url2, apiKey );
    ndbno ++;
    if(ndbno > 44260) {
        scrapeTimer.clear();
    }
};

//FOR In-Browser Version
var getFood = function (event) {
    event.preventDefault();
    console.log("button clicked ok guys");
    xhrMethod('GET', displayResponse, 'http://api.nal.usda.gov/ndb/reports/?ndbno=19098&type=b&format=JSON&api_key=', **APIKEY**);
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
        if (xhr.readyState === 4) {
            if(xhr.status < 400) {
                console.log('we have a response');
                if (apiKey) {
                    var foodObj = JSON.parse(xhr.responseText);
                    callback(foodObj);
                } else if (obj) {
                    var responseString = xhr.responseText;
                    callback(responseString);
                } else {
                    var responseString = xhr.responseText;
                    callback(responseString);
                }
            } else {
                console.log(xhr.status);
            }
        }    
    };
    if (obj) {
        xhr.send(JSON.stringify(obj));
    } else {
        xhr.send();
    }
};

var displayResponse = function (foodObj) {
    console.log(foodObj);
    console.log(foodObj.report.food.nutrients.length);
    var nutrients = [];
    for (var i = 0; i < foodObj.report.food.nutrients.length; i++) {
        var measureArr = [];
        for (var j = 0; j < foodObj.report.food.nutrients[i].measures.length; j++) {
            if(foodObj.report.food.nutrients[i].measures[j]){    
                var meas = new measure(foodObj.report.food.nutrients[i].measures[j].eqv, foodObj.report.food.nutrients[i].measures[j].label, foodObj.report.food.nutrients[i].measures[j].qty, foodObj.report.food.nutrients[i].measures[j].value, foodObj.report.food.nutrients[i].nutrient_id, foodObj.report.food.ndbno);
                measureArr.push(meas);
            }
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

};

var displayPing = function (response) {
    //FOR In-Browser Version
    // var div1 = document.getElementById('displayJson');
    // var head = document.createElement('h1');
    // div1.appendChild(head);
    // head.innerHTML = response;
};

console.log('JS LOADED - Init Next');
init();