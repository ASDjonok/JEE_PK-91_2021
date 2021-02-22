/*console.log("in JavaScript");

alert("AAAAAAAAAAAAAA!!!!!");

let age = prompt('Сколько тебе лет?', 100);

alert(`Тебе ${age} лет!`); // Тебе 100 лет!*/

fetch('http://localhost:8080/hello-world')
    .then(response => {
        // console.log(response/*.json()*/)

        async function f1() {
            var x = await response.text();
            console.log(x); // 10
        }
        f1();

        // console.log(await response.text()/*.json()*/)
        // console.log(response.json())
    })
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
