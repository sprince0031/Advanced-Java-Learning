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
    getRandJoke().then((jsondata) => {
        console.log(jsondata);
        $.ajax({
            type: "GET",
            url: "joke",
            data: "id="+jsondata.id,
            success: function(data) {
                if (data === "true") {
                    console.log("Already cracked this joke.. :P")
                    jokeGen();
                } else {
                    document.getElementById("setup").innerHTML = jsondata.setup;
                    document.getElementById("punchline").innerHTML = "";
                    sleep(4000).then(() => {
                        document.getElementById("punchline").innerHTML = jsondata.punchline;
                    })
                }
            }
        });
    });
}
