window.onload = function() {

    function handleInputValidation(inputElement, errorElement, pattern, inputBox, message) {
        inputElement.addEventListener("input", function () {
            if ((inputElement.validity.valid && pattern.test(inputElement.value)) || inputElement.value === "") {
                errorElement.textContent = "";
                if (inputBox) {
                    inputBox.style.borderColor="green"
                }
            } else {
                errorElement.textContent = message;
                if (inputBox) {
                    inputBox.style.borderColor="red"
                }
            }
            setTimeout(function () {
                errorElement.textContent = "";
            }, 3000);
        });
        inputElement.addEventListener("change", function () {
            if (inputElement.value === "") {
                if (inputBox) {
                    inputBox.style.borderColor = "#C09A81";
                }
            }
        });
    }

// Call the function for password input
    const passwordInput = document.getElementById("password");
    const passwordError = document.getElementById("password-error");
    const passwordInputBox = document.getElementById("password");
    const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/;
    const passwordErrorMessage = "비밀번호는 8~20 자, 영문 대문자/소문자, 숫자, 특수기호(!@$%&*)가 필수이며 공백과 한글은 허용되지 않습니다.";
    handleInputValidation(passwordInput, passwordError, passwordPattern, passwordInputBox, passwordErrorMessage);

// Call the function for name input
    const nameInput = document.getElementById("name");
    const nameError = document.getElementById("name-error");
    const nameInputBox = document.getElementById("name");
    const namePattern = /^[a-zA-Z가-힣]{1,10}$/;
    const nameErrorMessage = "이름은 최대 10자, 영문 또는 한글 필수이며 공백과 특수기호는 허용되지 않습니다.";
    handleInputValidation(nameInput, nameError, namePattern, nameInputBox, nameErrorMessage);

// Call the function for id(username) input
    const idInput = document.getElementById("username");
    const idError = document.getElementById("id-error");
    const idInputBox = document.getElementById("username");
    const idPattern = /^[a-zA-Z0-9]{1,20}$/;
    const idErrorMessage = "아이디는 최대 20자, 영문은 필수이며 (공백, 한글, 특수기호는 불가)";
    handleInputValidation(idInput, idError, idPattern, idInputBox, idErrorMessage);

// Call the function for phone input
    const phoneInput = document.getElementById("phone");
    const phoneError = document.getElementById("phone-error");
    const phoneInputBox = document.getElementById("phone");
    const phonePattern = /^010-[0-9]{4}-[0-9]{4}$/; // Define the phone pattern here
    const phoneErrorMessage = "전회번호는 010-0000-0000 형식으로 입력해주세요";
    handleInputValidation(phoneInput, phoneError, phonePattern, phoneInputBox, phoneErrorMessage);

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

    document.getElementById("myForm").addEventListener("submit", function(event) {
        const professionCheckboxes = document.querySelectorAll('.profession');
        const sessionMethodCheckboxes = document.querySelectorAll('.sessionMethod');
        let professionChecked = false;
        let sessionMethodChecked = false;

        professionCheckboxes.forEach(function(checkbox) {
            if (checkbox.checked) {
                professionChecked = true;
            }
        });

        sessionMethodCheckboxes.forEach(function(checkbox) {
            if (checkbox.checked) {
                sessionMethodChecked = true;
            }
        });

        if (!professionChecked || !sessionMethodChecked) {
            alert("전문 분야와 상담 방법 각각 항목에 체크박스 최소 하나는 선택 해주셔야합니다");
            event.preventDefault(); // Prevent form submission if checkboxes are not selected
        } else {
            document.getElementById("submitButton").disabled = false;
        }
    });

    document.getElementById("submitButton").addEventListener("click", function(event) {
        alert("회원가입 양식을 모두 작성 해주세요!");
    });
}
