window.onload = function() {

    $("#duplicationIdCheck").click(function () {
        let userId = $("#username").val().trim();
        $.ajax({
            type: 'POST',
            url: '/user/idDupCheck',
            data: userId,
            contentType: 'plain/text',
            success: function (response) {
                if (response.check === 0) {
                    alert("사용 가능한 아이디입니다.");
                } else {
                    alert("이미 사용중인 아이디입니다.");
                }
            },
            error: function (error) {
                console.error('AJAX error:', error);
                alert('An error occurred while processing your request. Please try again later.');
            }
        });

        $("#duplicationNicknameCheck").click(function () {
            let nickname = $("#nickname").val().trim();
            $.ajax({
                type: 'POST',
                url: '/user/nicknameDupCheck',
                data: nickname,
                contentType: 'plain/text',
                success: function (response) {
                    if (response.check === 0) {
                        alert("사용 가능한 닉네임 입니다.");
                    } else {
                        alert("이미 사용중인 닉네임입니다.");
                    }
                },
                error: function (error) {
                    console.error('AJAX error:', error);
                    alert('An error occurred while processing your request. Please try again later.');
                }
            });
        });
    })}
