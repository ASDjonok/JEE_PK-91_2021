/*let xhrButtonSuccess;
let xhrButtonError;
let xhrButtonAbort;
let log;

function addListeners(xhr) {
    xhr.addEventListener('error', handleLibraryPostEvent);
}

function runXHR(url) {
    log.textContent = '';

    const xhr = new XMLHttpRequest();
    addListeners(xhr);
    // xhr.open("GET", url);
    /!*xhr.open("POST", url);
    xhr.send();*!/
    const body = "1" + "\n" + "1" + "\n" + "1";
    xhr.open("POST", 'http://localhost:8080/library', true);
    xhr.send(body);
    return xhr;
}*/




function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}

window.onload = function() {
    console.log("!!!!!!! in window.onload");

    if (getCookie("token")) {
        document.getElementById('login-form').hidden = true;
        document.getElementById('library-view').hidden = false;
    }
    /*debugger;
    xhrButtonSuccess = document.querySelector('.xhr.success');
    xhrButtonError = document.querySelector('.xhr.error');
    xhrButtonAbort = document.querySelector('.xhr.abort');
    log = document.querySelector('.event-log');


    xhrButtonSuccess.addEventListener('click', () => {
        runXHR('https://mdn.mozillademos.org/files/16553/DgsZYJNXcAIPwzy.jpg');
    });

    xhrButtonError.addEventListener('click', () => {
        runXHR('http://somewhere.org/i-dont-exist');
    });

    xhrButtonAbort.addEventListener('click', () => {
        runXHR('https://mdn.mozillademos.org/files/16553/DgsZYJNXcAIPwzy.jpg').abort();
    });*/
};

function onAddToLibraryButtonClick() {
    const title = document.getElementById('title').value;
    const author = document.getElementById('author').value;
    const quantity = document.getElementById('quantity').value;
    console.log(title);
    console.log(author);
    console.log(quantity);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('error', handleLibraryPostEvent);
    const body = title + "\n" + author + "\n" + quantity;
    xhr.open("POST", 'http://localhost:8080/library'/*, true*/);
    xhr.onload = function () {
        if (xhr.status === 403) {
            alert("Error. Please logout and login.");
        }
        // console.log('DONE: ', xhr.status);
    };
    xhr.send(body);
    /*if (xhr.status === 403) {
        return alert("!!!!!!!!!!!!!!!");
    }*/
}

function handleLibraryPostEvent(e) {
    alert("Error. Please logout and login.");
}

function onLibraryButtonClick() {
// GET
    fetch('http://localhost:8080/library')
        .then(response => {
            // console.log("2222")
            async function f1() {
                const responseStatus = response.status;
                const responseText = await response.text();
                console.log("responseStatus = " + responseStatus);
                console.log("Response = " + responseText); // 10
                if (responseStatus === 200) {
                    document.getElementsByTagName("textarea")[0].value = responseText;
                } else {
                    document.getElementsByTagName("textarea")[0].value = "Error"
                    alert("Error. Please logout and login.");
                }
            }
            f1();
        });
}

function deleteCookie(name) {
    document.cookie = name +'=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

function onLogoutButtonClick() {
    deleteCookie("token");
    document.location.reload();
}




/*for (let i = 0; i < 10000; i++) {
    console.log("11111")
}*/
//POST
/*var xhr = new XMLHttpRequest();

var body = 'name=' + encodeURIComponent("Oleksii2") +
    '&surname=' + encodeURIComponent("Aleshchenko2");

xhr.open("POST", 'http://localhost:8080/hello-world', true);
// xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

/!*xhr.onreadystatechange =
...
;*!/

xhr.send(body);*/

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


