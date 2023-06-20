function toggleButton()
{
    var usermail = document.getElementById('user_email').value;
    var password = document.getElementById('user_password').value;

    if (usermail && password) {
        document.getElementById('login_button').disabled = false;
    } else {
        document.getElementById('login_button').disabled = true;
    }
    var userData = {
        mail: usermail,
        password: password,
    };

    fetch('http://127.0.0.1:8080/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    })
        .then(response => response.json())
        .then(data => {

            var token = data.token;

            localStorage.setItem('jwtToken', token);

            console.log('Token:', token);
        })
        .catch(error => {
            console.error('Error:', error);
        });
}


function toggleButton2()
{
    var personId = 0
    var username = document.getElementById('user_name_reg').value;
    var usersurname = document.getElementById('user_surname_reg').value;
    var usertel = document.getElementById('user_tel_reg').value;
    var usermail = document.getElementById('user_email_reg').value;
    var password1 = document.getElementById('user_pass_reg').value;
    var password2 = document.getElementById('user_pass2_reg').value;

    if (username && usersurname && usertel && usermail && password1 && password2) {
        document.getElementById('reg_button').disabled = false;

        var userData = {
            personId: personId,
            firstName: username,
            lastName: usersurname,
            phone: usertel,
            email: usermail,
            password: password1
        };

        fetch('http://127.0.0.1:8080/registrationPerson', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        })
            .then(response => response.text())
            .then(data => {
                console.log(data);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    } else {
        document.getElementById('reg_button').disabled = true;
    }
}