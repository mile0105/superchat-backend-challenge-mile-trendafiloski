let sock = new SockJS("http://localhost:8080/superchat");

let client = Stomp.over(sock);

client.connect({}, frame => {
    const myId = 1; //this will be taken from the login in the future
    client.subscribe("/topic/messages/" + myId, payload => {

        let message_list = document.getElementById('message-list');
        let message = document.createElement('li');

        message.appendChild(document.createTextNode(JSON.parse(payload.body).content));
        message_list.appendChild(message);

    });

});

function sendMessage(){

    let input = document.getElementById("message-input");
    let message = input.value;

    //recipientId will be different in the future, based on the contact we want to send to
    client.send('/app/chat', {}, JSON.stringify({content: message, recipientId: 2}));

}