var checkboxes = document.querySelectorAll('.check_input');

checkboxes.forEach(function (check_input) {
    check_input.addEventListener('change', createOrderJson);
});

var ratColorSelect = document.querySelector('select[name="rat_color"]');
ratColorSelect.addEventListener('change', createOrderJson);


function createOrderJson() {

    var checkboxValues = [];
    var orderButton = document.getElementById('orderButton');
    var city = document.getElementById("city").value;
    var address = document.getElementById("address").value;
    var dateOfDelivery = document.getElementById("delivery_date").value;
    var timeOfDelivery = document.getElementById("delivery_time").value;
    var ratClassSelect = document.querySelector('select[name="rat_class"]');
    var selectedRatClass = ratClassSelect.value;
    var ratColorSelect = document.querySelector('select[name="rat_color"]');
    var selectedRatColor = ratColorSelect.value;

    var checkboxes = document.querySelectorAll('.check_input');
    checkboxes.forEach(function (check_input) {
        if (check_input.checked) {
            checkboxValues.push(check_input.value);
        }
    });

    if (city && address && dateOfDelivery && timeOfDelivery && selectedRatClass && selectedRatColor && checkboxValues.length > 0) {
        orderButton.disabled = false;
    } else {
        orderButton.disabled = true;
    }

    var orderData = {
        city: city,
        address: address,
        dateOfDelivery: dateOfDelivery,
        timeOfDelivery: timeOfDelivery,
        ratClass: selectedRatClass,
        ratColor: selectedRatColor,
        skills: checkboxValues,
        statusOrder: "Не оплачен",
        userId: 0
    };

    console.log(orderData);
    localStorage.setItem('orderData', JSON.stringify(orderData));
    // Сделать обработчик цены на крысу
}