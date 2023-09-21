$("#startTest").click(function () {

    const mainTop = $("#mainTop");
    mainTop.html("");
    const resultNum = mainTop.append($('<button>').attr({
        id: 'countBoutton',
        class: 'countbutton',
    }).text((currentPage) + " / 4"));
    resultNum.append($('<h2>').attr({id: 'result'}));
    mainTop.append(resultNum)
    currentPage++


    const testCategory = selectCategory[currentPage]; // 다음 카테고리 가져오기
    $.ajax({
        url: "startAjax",
        data: {testCategory: testCategory},
        dataType: "json",
        contentType: "application/json",
        success: function (data, status, xhr) {
            //answerScore.push(answer);

            const testQ = JSON.parse(data.testQ);
            const beforeTest = $("#beforeTest");
            const questionBox = $("#testBox");

            beforeTest.html("");
            questionBox.html("");

            /* 질문 반복 */
            testQ.forEach(function (testQ) {
                const questionDiv = $('<div>');
                const answerDiv1 = $('<div>').append('전혀그렇지않다');
                const answerDiv2 = $('<div>').append('매우그렇다');

                /* 질문 */
                questionDiv.append($('<h2>').addClass('whiteText').text(testQ.testContent));
                /* 버튼 */
                questionDiv.append($('<input>').attr({
                    type: 'radio',
                    name: testQ.testCategory + testQ.testCode,
                    class: 'one',
                    value: '1'
                }));
                questionDiv.append($('<input>').attr({
                    type: 'radio',
                    name: testQ.testCategory + testQ.testCode,
                    class: 'two',
                    value: '2'
                }));
                questionDiv.append($('<input>').attr({
                    type: 'radio',
                    name: testQ.testCategory + testQ.testCode,
                    class: 'three',
                    value: '3'
                }));
                questionDiv.append($('<input>').attr({
                    type: 'radio',
                    name: testQ.testCategory + testQ.testCode,
                    class: 'four',
                    value: '4'
                }));
                questionDiv.append($('<input>').attr({
                    type: 'radio',
                    name: testQ.testCategory + testQ.testCode,
                    class: 'five',
                    value: '5'
                }));
                questionDiv.append($('<div>').append(answerDiv1).append(answerDiv2).addClass('testQ'));
                questionBox.append(questionDiv);
            });
            // 현재 질문을 페이지에 추가
            if (currentPage == 4) {
                const buttonChange = $("#buttonChange");
                buttonChange.html("");
                buttonChange.append($('<input>').attr({
                    id: 'submit',
                    type: 'button',
                    class: 'roundbutton',
                    value: '제출하기',
                    disabled: false
                }));
            } else {
                const buttonChange = $("#buttonChange");
                buttonChange.html("");
                buttonChange.append($('<input>').attr({
                    id: 'startTest',
                    type: 'button',
                    class: 'roundbutton',
                    value: '다음',
                    disabled: false
                }));
            }

            $("#submit").click(function () {

                console.log(categorys + "마지막")
                console.log(answers + "마지막")


                // answers 객체를 서버로 전송
                $.ajax({
                    url: "saveAnswers",
                    method: "POST",
                    data: JSON.stringify(categorys, answers),
                    success: function (data) {


                        // 제출이 성공했을 때의 처리
                    },
                    error: function (xhr, status, error) {
                        console.error(error + " 에러가 났따...");
                    }
                });
            })
        },
        error: function (xhr, status, error) {
        }
    });

});
