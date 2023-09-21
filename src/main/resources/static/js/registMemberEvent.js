window.onload = function() {

    function handleInputValidation(inputElement, errorElement, pattern, inputBox) {
        inputElement.addEventListener("input", function () {
            if (inputElement.validity.valid || inputElement.value === "") {
                errorElement.textContent = "";
                if (inputBox) {
                    inputBox.style.borderColor="green"
                }
            } else {
                errorElement.textContent = pattern;
                if (inputBox) {
                    inputBox.style.borderColor="red"
                }
            }
        });
        inputElement.addEventListener("change", function () {
            if (inputElement.value === "") {
                errorElement.textContent = "";
                if (inputBox) {
                    inputBox.style.borderColor = "#C09A81";
                }
            }
        });
    }

    function handlePhoneValidation(inputElement, errorElement, inputBox) {
        const errorMessage = "전회번호는 - 포함해서 최대 12자까지만 입력해주세요";
        const phonePattern = /^010-[0-9]{4}-[0-9]{4}$/; // Define the phone pattern here

        inputElement.addEventListener("input", function () {
            const inputValue = inputElement.value;

            if (phonePattern.test(inputValue) || inputValue === "") {
                errorElement.textContent = "";
                inputBox.style.borderColor = "green";
            } else {
                errorElement.textContent = errorMessage;
                inputBox.style.borderColor = "red";
            }
        });

        // Add another event listener to clear the error message when the input is focused
        inputElement.addEventListener("focus", function () {
            errorElement.textContent = "";
        });

        inputElement.addEventListener("change", function () {
            if (inputElement.value === "") {
                errorElement.textContent = "";
                inputBox.style.borderColor = "#C09A81";
            }
        });
    }


// Call the function for password input
    const passwordInput = document.getElementById("password");
    const passwordError = document.getElementById("password-error");
    const passwordInputBox = document.getElementById("password");
    const passwordPattern = "비밀번호는 8~20 자, 영문 대문자/소문자, 숫자, 특수기호(!@$%&*)가 필수이며 공백과 한글은 허용되지 않습니다.";
    handleInputValidation(passwordInput, passwordError, passwordPattern, passwordInputBox);

// Call the function for name input
    const nameInput = document.getElementById("name");
    const nameError = document.getElementById("name-error");
    const nameInputBox = document.getElementById("name");
    const namePattern = "이름은 최대 10자, 영문 또는 한글 필수이며 공백과 특수기호는 허용되지 않습니다.";
    handleInputValidation(nameInput, nameError, namePattern, nameInputBox);

// Call the function for id(username) input
    const idInput = document.getElementById("username");
    const idError = document.getElementById("id-error");
    const idPattern = "아이디는 최대 20자, 영문, 특수기호(!@$%&*)는 필수이며 공백과 한글은 허용되지 않습니다.";
    handleInputValidation(idInput, idError, idPattern);

// Call the function for nickname input
    const nicknameInput = document.getElementById("nickname");
    const nicknameError = document.getElementById("nickname-error");
    const nicknamePattern = "닉네임은 최대 10자, 영문 또는 한글 가능하며 공백과 특수기호는 허용되지 않습니다.";
    handleInputValidation(nicknameInput, nicknameError, nicknamePattern);

// Call the function for phone input
    const phoneInput = document.getElementById("phone");
    const phoneError = document.getElementById("phone-error");
    const phoneInputBox = document.getElementById("phone");
    handlePhoneValidation(phoneInput, phoneError, phoneInputBox);

    function isInputValid(inputElement, pattern) {
        return inputElement.validity.valid || inputElement.value === "" || !pattern.test(inputElement.value);
    }


    $("#duplicationIdCheck").click(function idDupCheck() {
        let userId = $("#username").val().trim();
        const existing = document.getElementById("idDupCheck-error");
        const idInputBox = document.getElementById("username");

        idInput.addEventListener("input", function () {
            if (idInput.validity.valid) {
                idInputBox.style.borderColor = "#C09A81"; // Reset the border color
            }
        });

        if (!isInputValid(idInputBox, idPattern)) {
            // Display an error message or handle invalid input
            // For example, show a message to the user indicating the input is invalid
            existing.textContent = "Invalid input";
            existing.style.color = "red";
            idInputBox.style.borderColor = "red";
            return;
        }

        // If input is valid, proceed with AJAX request
        $.ajax({
            type: 'POST',
            url: '/user/idDupCheck',
            data: userId,
            contentType: 'plain/text',
            success: function (response) {
                if (response.check === 0) {
                    existing.textContent = "사용 가능한 아이디입니다.";
                    existing.style.color = "green";
                    idInputBox.style.borderColor = "green";
                } else {
                    existing.textContent = "이미 사용중인 아이디입니다.";
                    existing.style.color = "red";
                    idInputBox.style.borderColor = "red";
                }
                setTimeout(function () {
                    existing.textContent = "";
                }, 3000);
            },
            error: function (error) {
                console.error('AJAX error:', error);
            }
        });
    });

// Similarly, modify the nicknameDupCheck logic
    $("#duplicationNicknameCheck").click(function nicknameDupCheck() {
        let nickname = $("#nickname").val().trim();
        const existingNickname = document.getElementById("nicknameDupCheck-error");
        const nicknameInputBox = document.getElementById("nickname");

        nicknameInput.addEventListener("input", function () {
            if (nicknameInput.validity.valid) {
                nicknameInputBox.style.borderColor = "#C09A81"; // Reset the border color
            }
        });

        if (!isInputValid(nicknameInputBox, nicknamePattern)) {
            // Handle invalid input for nickname
            existingNickname.textContent = "Invalid input";
            existingNickname.style.color = "red";
            nicknameInputBox.style.borderColor = "red";
            return;
        }

        $.ajax({
            type: 'POST',
            url: '/user/nicknameDupCheck',
            data: nickname,
            contentType: 'plain/text',
            success: function (response) {
                if (response.check === 0) {
                    existingNickname.textContent = "사용 가능한 닉네임 입니다.";
                    existingNickname.style.color = "green";
                    nicknameInputBox.style.borderColor = "green";
                } else {
                    existingNickname.textContent = "이미 사용중인 닉네임입니다.";
                    existingNickname.style.color = "red";
                    nicknameInputBox.style.borderColor = "red";
                }

                setTimeout(function () {
                    existingNickname.textContent = "";
                }, 3000);
            },
            error: function (error) {
                existingNickname.textContent = "닉네임을 입력해주세요.";
                existingNickname.style.color = "red";
                nicknameInputBox.style.borderColor = "red";
                console.error('AJAX error:', error);
            }
        });
    });


   /* $("#submit").click(function isAllInputValid() {
        // Check if all input fields are valid (turned green)
        const inputFields = document.querySelectorAll(".input-field"); // Replace with your actual class name
        for (const inputField of inputFields) {
            if (inputField.style.borderColor !== "green") {
                return false; // At least one input field is not valid
            }
        }

        // Check if email verification is successful
        const emailVerificationStatus = document.getElementById("email-verification-status"); // Replace with the actual element ID
        if (emailVerificationStatus.textContent.trim() !== "Email Verified") {
            return false; // Email verification is not successful
        }

        return true; // All input fields are valid and email verification is successful


        if (isAllInputValid()) {
            alert("모두 성공!");
            // All input fields are valid and email verification is successful
            // Proceed with sending data to the database
        } else {
            // Handle the case where input validation or email verification failed
            alert("올바른 형식으로 다시 입력해주세요 또는 이메일 인증을 완료해주세요.");
        }
    })*/
}
