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
        const urlString = window.location.href
        const url = new URL(urlString);
        const userName = url.searchParams.get("user");
        document.getElementById('user-name').textContent = "Name: " + userName;
        //todo unhardcode to roles
        if (userName === "user") {
            //todo think about getting by id
            document.getElementsByClassName('add-library-button')[0].hidden = true;
            document.getElementsByClassName('get-from-library-button')[0].hidden = false;
        }
    }

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
    };
    xhr.send(body);
}

function onGetFromLibraryButtonClick() {
    alert("do me");
    /*const title = document.getElementById('title').value;
    const author = document.getElementById('author').value;
    const quantity = document.getElementById('quantity').value;
    console.log(title);
    console.log(author);
    console.log(quantity);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('error', handleLibraryPostEvent);
    const body = title + "\n" + author + "\n" + quantity;
    xhr.open("POST", 'http://localhost:8080/library'/!*, true*!/);
    xhr.onload = function () {
        if (xhr.status === 403) {
            alert("Error. Please logout and login.");
        }
    };
    xhr.send(body);*/
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

