var storedData = localStorage.getItem('orderData');
if (storedData) {
    var orderData = JSON.parse(storedData);

    var orderNumberElement = document.getElementById('orderNumber');
    var orderCompositionElement = document.getElementById('orderComposition');
    var orderSkillsElement = document.getElementById('orderSkills');
    var deliveryAddressElement = document.getElementById('deliveryAddress');
    var deliveryDateTimeElement = document.getElementById('deliveryDateTime');
    var clientPreferencesElement = document.getElementById('clientPreferences');
    var orderCostElement = document.getElementById('orderCost');


    var dateStr = orderData.dateOfDelivery;
    var date = new Date(dateStr);
    var options = { day: 'numeric', month: 'long', year: 'numeric' };
    var formattedDate = date.toLocaleDateString('ru-RU', options);

    orderNumberElement.textContent = "1";
    orderCompositionElement.textContent = orderData.ratClass + ", " + orderData.ratColor + "крыса, 1 шт.";
    orderSkillsElement.textContent = "Кухня: " + orderData.skills.join(", ");
    deliveryAddressElement.textContent = orderData.city + " " + orderData.address;
    deliveryDateTimeElement.textContent = formattedDate + " " + orderData.timeOfDelivery;
    clientPreferencesElement.textContent = "Нет";
    orderCostElement.textContent = "1000";
}



var token = ""
var storedToken = localStorage.getItem('jwtToken');
if (storedToken) {
    token = storedToken;
}

// Обработка события
var paymentButton = document.querySelector('.btn_next');
paymentButton.addEventListener('click', function() {
    fetch('http://127.0.0.1:8080/order', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': token
        },
        body: JSON.stringify(orderData)
    })
        .then(response => response.text())
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
});