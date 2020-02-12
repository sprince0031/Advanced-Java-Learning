let favFlag = false;
let jokeJson = JSON.stringify("");
async function getRandJoke() {
    var requestOptions = {
        method: 'GET',
        redirect: 'follow',
        mode: 'cors'
    };

    const response = await fetch('https://official-joke-api.appspot.com/random_joke', requestOptions);
    return await response.json();
}

function sleep (time) {
    return new Promise((resolve) => setTimeout(resolve, time));
  }

function jokeGen() {
    favFlag = false;
    favButtonToggle();
    document.getElementById("setup").innerHTML = "";
    document.getElementById("punchline").innerHTML = "";
    getRandJoke().then((jsonData) => {
        // console.log(jsonData);
        $.ajax({
            type: "GET",
            url: "joke",
            data: "id="+jsonData.id,
            success: function(data) {
                if (data === "true") {
                    console.log("Already cracked this joke.. :P")
                    jokeGen();
                } else {
                    document.getElementById("setup").innerHTML = jsonData.setup;
                    document.getElementById("punchline").innerHTML = "";
                    sleep(2000).then(() => {
                        document.getElementById("punchline").innerHTML = jsonData.punchline;
                    })
                }
            }
        });
        jokeJson = jsonData;
        console.log("JokeId: " + jokeJson.id);
    });
    
    
    // });
}

function favButtonToggle() {
    if (favFlag) {
        favFlag = false;
        document.getElementById("fav-btn").innerHTML = "<i class=\"fas fa-heart\"></i>";
    } else {
        favFlag = true;
        document.getElementById("fav-btn").innerHTML = "<i class=\"far fa-heart\"></i>";
    }
    return favFlag;
}

function favouriteAction() {
    $.post("favtoggle",
    {
        joke: JSON.stringify(jokeJson),
        favFlag: favFlag
    }, 
    function (data, status) {
        console.log("Favourite toggled!\nData: " + data + "\nStatus: " + status);
    });
    favButtonToggle();
}

function listFavs() {
    console.log("function invoked..");
    $.get("listfavs", function(data, status) {
        console.log(data);
        parsedJson.forEach(element => {
            console.log(element);
        });
        console.log("List operation done!\n" + "Status: " + status);
    });
}