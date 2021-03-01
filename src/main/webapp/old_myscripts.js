// GET
fetch('http://localhost:8080/hello-world')
    .then(response => {
        console.log("2222")
        async function f1() {
            var x = await response.text();
            console.log("Response = " + x); // 10
        }

        f1();
    })
console.log("11111")
//POST
var xhr = new XMLHttpRequest();

var body = 'name=' + encodeURIComponent("Oleksii2") +
    '&surname=' + encodeURIComponent("Aleshchenko2");

xhr.open("POST", 'http://localhost:8080/hello-world', true);
// xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

/*xhr.onreadystatechange =
...
;*/

xhr.send(body);

/*console.log("in JavaScript");

alert("AAAAAAAAAAAAAA!!!!!");

let age = prompt('Сколько тебе лет?', 100);

alert(`Тебе ${age} лет!`); // Тебе 100 лет!*/

/*fetch('http://localhost:8080/hello-world')
    .then(response => {
        // console.log(response/!*.json()*!/)

        async function f1() {
            var x = await response.text();
            console.log("Response = " + x); // 10
        }

        f1();

        // console.log(await response.text()/!*.json()*!/)
        // console.log(response.json())
    })*/
// .then(commits => alert(commits[0].author.login));

/*
let response = await fetch("http://localhost:8080/hello-world");

if (response.ok) { // если HTTP-статус в диапазоне 200-299
                   // получаем тело ответа (см. про этот метод ниже)

    let json = await response.json();
    console.log(json);
    alert(json);
} else {
    alert("Ошибка HTTP: " + response.status);
}*/


