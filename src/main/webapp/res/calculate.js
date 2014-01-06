function calculate() {

    var value1 = document.getElementById('op1').value;
    var value2 = document.getElementById('op2').value;
    var operation = document.getElementById('op').value;

    var url = '/calculate';

    var requestBody = {
        operand1 : value1,
        operand2 : value2,
        operation: operation
    };

    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, true);
    xhr.onreadystatechange = function(){
        var resp = xhr.responseText;
        showResult(JSON.parse(resp));
    };
    xhr.send(JSON.stringify(requestBody));

}

function showResult(resp){
    var resultContainer = document.getElementById("result");
    var messageContainer = document.getElementById("message");

    resultContainer.innerHTML = resp["result"];
    messageContainer.innerHTML = resp["message"];
}