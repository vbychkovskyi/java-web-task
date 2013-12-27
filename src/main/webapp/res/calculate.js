function calculate() {

    var value1 = document.getElementById('op1').value;
    var value2 = document.getElementById('op2').value;
    var operation = document.getElementById('op').value;

    var params = '?operand1=' + value1 + '&operand2=' + value2 + '&operation=' + operation;
    var url = '/calculate' + params;

    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.onreadystatechange = function(){
        var resp = xhr.responseText;
        showResult(resp);
    };
    xhr.send();

}

function showResult(resp){
    resp = JSON.parse(resp);
    var resultContainer = document.getElementById("result");
    var messageContainer = document.getElementById("message");

    resultContainer.innerHTML = resp["result"];
    messageContainer.innerHTML = resp["message"];
}