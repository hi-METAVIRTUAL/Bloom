
const questionDiv = $('<div>');
questionDiv.append($('<h2>').addClass('whiteText').text(testQ.te));

for (let i = 1; i <= 5; i++) {
    const radioInput = $('<input>').attr({
        type: 'radio',
        name: `${question.testCategory}${question.testCode}`,
        class: "answerOption" + i ,
        value: i
    });
    const testQDiv = $('<div>').addClass('testQ');
    testQDiv.append('<div>전혀그렇지않다</div>');
    testQDiv.append('<div>매우그렇다</div>');

    questionDiv.append(radioInput);
    questionDiv.append(testQDiv);

    /*questionDiv.append($('<div>').append(answerDiv1).append(answerDiv2).addClass('testQ'));
    questionContainer.append(questionDiv);*/
    $('#test11').html(questionDiv);
}




const questions = [

]
let currentQuestionIndex = 0;


function nextButtonClick(moonjae_no, answer_val) {
    // 현재 질문에 대한 답변을 answers 배열에 저장
    answers[moonjae_no] = answer_val;

    // 마지막 질문일 경우 결과 페이지로 이동
    if (answers === questions.length) {
        calculateResult();
        return;
    }
    const nextQuestion = questions[currentQuestionIndex];
    const questionElement = document.getElementById('question');
    const questionNumberElement = document.getElementById('question-number');

    questionElement.textContent = nextQuestion.text;
    questionNumberElement.textContent = `질문 ${currentQuestionIndex + 1}`;
}

$("#topp").click(function() {
    countAndScroll();
    function countAndScroll() {
        // 결과를 표시할 element
        const resultElement = document.getElementById('result');
        // 현재 화면에 표시된 값
        let number = parseInt(resultElement.innerText);
        number += 1;
        if (number > 4) {
            window.location.href = '/psychological/psychometry/last';
            return; // 리디렉션 후 함수 종료
        }
        resultElement.innerText = number + " / 4";
        // 화면을 최상단으로 스크롤
        window.scrollTo(0, 0);
    }
});

/*
const main = document.querySelector('#main');
const qna = document.querySelector('#qna');
let result = document.querySelector('#result');
const endPoint = 12;
const select = [0,0,0,0,0,0,0,0,0,0,0,0];
function begin(){
    main.style.WebkitAnimation = "fadeOut 1s";
    main.style.animation = "fadeOut 1s";
    setTimeout(()=>{
        qna.style.WebkitAnimation = "fadeIn 1s";
        qna.style.animation = "fadeIn 1s";
        setTimeout(()=>{
            main.style.display = 'none';
            qna.style.display = 'block';
        },400)
        let qIdx = 0;
        goNext(qIdx);
    },400);
}

function goNext(qIdx){
    var q = document.querySelector('.qBox');

    if (qIdx == endPoint){
        goResult();
        return;
    }
    q.innerHTML = qnaList[qIdx].q;
    for (let i in qnaList[qIdx].a){ //질문당 답변은 여러개니까 for문으로
        addAnswer(qnaList[qIdx].a[i].answer, qIdx, i);
    }
    var status = document.querySelector('.statusBar');
    status.style.width = (100/endPoint) * (qIdx+1) + '%';
    //statusBar의 넓이를 진행상황에 따라 넓게 하기 위해서
}

function addAnswer(answerText,qIdx,idx){
    var a = document.querySelector('.answerBox');
    var answer = document.createElement('button');
    //이벤트리스너를 위해 모든 answer를 담기위해 클래스를 만들어준다
    answer.classList.add('answerList');
    answer.classList.add('my-3');
    answer.classList.add('py-3');
    answer.classList.add('mx-auto');
    answer.classList.add('fadeIn');
    a.appendChild(answer); //answer와 a 의 관계를 만들어준다
    answer.innerHTML = answerText;
    //answer버튼이 클릭되면 지금거 사라지고 다음게 나타나야한다
    answer.addEventListener('click',function(){
        var children = document.querySelectorAll('.answerList');
        for(let i=0; i< children.length; i++){
            children[i].disabled = true;
            children[i].style.WebkitAnimation = "fadeOut 0.5s";
            children[i].style.animation = "fadeOut 0.5s";
        }
        setTimeout(()=>{
            var target = qnaList[qIdx].a[idx].type;
            for(let j=0; j<target.length; j++){
                select[target[j]] += 1;
            }
            for(let i =0; i<children.length; i++){
                children[i].style.display = 'none';
            }
            goNext(++qIdx);
        },450);
    }, false);
}*/
//--------------------------------------------------------
/*
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
    <head>
    <meta>
    <title>start</title>
<link rel="stylesheet" type="text/css" href="/css/psychological/startTest.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
          rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    </head>
    <body>
    <header class="header" th:include="components/Header.html" th:with="textColor='#FEEFCC'"></header>
    <main>
        <button id="countBoutton" class="countbutton"><h2 id='result' style="display: flex; justify-content: center;"> 1 /
            4</h2></button>
    </main>
    <article>
        <form class="theme-checker">
            <div id="test11">
                <div th:each="test, testIndex : ${testQ}">
                    <h2 class="whiteText" th:text="${test.testContent}"></h2>
                    <input type="radio" th:name="${test.testCategory+test.testCode}" class="one" value="1"/>
                    <input type="radio" th:name="${test.testCategory+test.testCode}" class="two" value="2"/>
                    <input type="radio" th:name="${test.testCategory+test.testCode}" class="three" value="3"/>
                    <input type="radio" th:name="${test.testCategory+test.testCode}" class="four" value="4"/>
                    <input type="radio" th:name="${test.testCategory+test.testCode}" class="five" value="5"/>
                    <div class="testQ">
                        <div>전혀그렇지않다</div>
                        <div>매우그렇다</div>
                    </div>
                </th:block>
            </div>
        </div>
        <div>
            <input id="next2" class="roundbutton" type="button" value="다음1">
                <input id="first" type="hidden" name="category" value="A">
                    <input id="next3" class="roundbutton" type="button" value="다음2">
                        <input id="second" type="hidden" name="category" value="B">
                            <input id="next4" class="roundbutton" type="button" value="다음3">
                                <input id="third" type="hidden" name="category" value="O">
                                    <input id="next5" class="roundbutton" type="button" value="제출하기">
        </div>
    </form>
    </article>
    <br><br><br><br><br><br><br><br><br><br><br><br>
        <footer style=" position: fixed;bottom: 0; margin: 0 auto; left: 0; right: 0;">
            <img class="grass" src="/images/common/beigeGrass.png" alt="grass">
                <th:block th:include="components/Footer.html" th:with="textColor='#C09A81'"></th:block>
        </footer>
        <script>
            $("#next3").hide();
            $("#next4").hide();
            $("#next5").hide();
            // JavaScript를 사용하여 질문 데이터를 관리하고 페이지를 동적으로 로드합니다.
            const answers = {}; // 답변을 저장할 빈 객체 생성
            const categoryIndex = ["D", "A", "B", "O"]
            let index = 0;
            $("#next2").click(function () {
            const testQuestions = $("input[type='radio']:checked"); // 체크된 라디오 버튼 가져오기
            const category = document.getElementById('first').value;
            $.ajax({
            url: "startAjax",
            data: {category: category},
            dataType: "json",
            contentType: "application/json",
            success: function (data, status, xhr) {

            const testQ = JSON.parse(data.testQ);
            const questionContainer = $("#test11");
            questionContainer.html("");
            testQ.forEach(function (testQ, i) {
            const questionDiv = $('<div>');
            const answerDiv1 = $('<div>').append('전혀그렇지않다');
            const answerDiv2 = $('<div>').append('매우그렇다');

            /!* 질문 *!/
            questionDiv.append($('<h2>').addClass('whiteText').text(testQ.testContent));
            /!* 버튼 *!/
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
            questionContainer.append(questionDiv);
            console.log(testQuestions.length);

        });

            // 질문 번호 표시를 업데이트합니다. 나중에 변경
            $('#result').text((index + 1) + ' / ' + 4);
            /!* Top 으로 *!/
            window.scrollTo(0, 0);
            /!* 버튼 숨기기 and 보이기 *!/
            $("#next2").hide();
            $("#next3").show();

            testQuestions.each(function () {

            let name = $(this).attr("name");
            let value = $(this).val();
            answers[name] = value; // 객체에 답변 추가
        });
        },
            error: function (xhr, status, error) {
        }
        });
        });
            $("#next3").click(function () {
            const testQuestions = $("input[type='radio']:checked"); // 체크된 라디오 버튼 가져오기
            const category = document.getElementById('second').value;
            $.ajax({
            url: "startAjax",
            data: {category: category},
            dataType: "json",
            contentType: "application/json",
            success: function (data, status, xhr) {

            const testQ = JSON.parse(data.testQ);
            const questionContainer = $("#test11");
            questionContainer.html("");
            testQ.forEach(function (testQ, i) {
            const questionDiv = $('<div>');
            const answerDiv1 = $('<div>').append('전혀그렇지않다');
            const answerDiv2 = $('<div>').append('매우그렇다');

            /!* 질문 *!/
            questionDiv.append($('<h2>').addClass('whiteText').text(testQ.testContent));
            /!* 버튼 *!/
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
            questionContainer.append(questionDiv);
        });

            // 질문 번호 표시를 업데이트합니다. 나중에 변경
            $('#result').text((index + 2) + ' / ' + 4);
            window.scrollTo(0, 0);
            $("#next3").hide();
            $("#next4").show();

            testQuestions.each(function () {

            let name = $(this).attr("name");
            let value = $(this).val();
            answers[name] = value; // 객체에 답변 추가
        });
        },
            error: function (xhr, status, error) {
        }
        });
        });
            $("#next4").click(function () {
            const testQuestions = $("input[type='radio']:checked"); // 체크된 라디오 버튼 가져오기
            /!*const category = categoryIndex[3];*!/
            const category = document.getElementById('third').value;
            $.ajax({
            url: "startAjax",
            data: {category: category},
            dataType: "json",
            contentType: "application/json",
            success: function (data, status, xhr) {

            const testQ = JSON.parse(data.testQ);
            const questionContainer = $("#test11");
            questionContainer.html("");
            testQ.forEach(function (testQ, i) {
            const questionDiv = $('<div>');
            const answerDiv1 = $('<div>').append('전혀그렇지않다');
            const answerDiv2 = $('<div>').append('매우그렇다');

            /!* 질문 *!/
            questionDiv.append($('<h2>').addClass('whiteText').text(testQ.testContent));
            /!* 버튼 *!/
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
            questionContainer.append(questionDiv);
        });

            // 질문 번호 표시를 업데이트합니다. 나중에 변경
            $('#result').text((index + 3) + ' / ' + 4);
            window.scrollTo(0, 0);
            $("#next4").hide();
            $("#next5").show();
            testQuestions.each(function () {
            let name = $(this).attr("name");
            let value = $(this).val();
            answers[name] = value; // 객체에 답변 추가
        });
        },
            error: function (xhr, status, error) {
        },
        });
        });

            /!*$("#next5").click(function () {
            // 폼 제출 로직 추가
            console.log("시작");

            // 답변 데이터를 JSON 형식으로 만들기
            const answerData = [];

            $("input[type='radio']:checked").each(function () {
            const name = $(this).attr("name");
            const value = $(this).val();
            console.log(name)
            console.log(value)

            // TestResultDTO 형식으로 데이터 생성
            const testResultDTO = {
            name: name,
            value: value
        };

            answerData.push(testResultDTO);
        });


            // 서버에 JSON 데이터 전송
            $.ajax({
            url: "saveAnswers",
            type: "POST",
            data: JSON.stringify(answerData),
            contentType: "application/json",
            success: function (response) {
            console.log(response + " 성공");
        },
            error: function (xhr, status, error) {
            console.error("에러 발생:", error);
        }
        });
        });*!/
            $("#next5").click(function () {
            // 폼 제출 로직 추가
            console.log("시작")
            jQuery.ajaxSettings.traditional = true;
            $.ajax({
            url: "saveAnswers",
            type: "POST",
            data: JSON.stringify(answers),
            contentType: "application/json",
            success: function (data) {
            console.log(data + "성공");
            window.location.href = '/psychological/psychometry/last';
            return; // 리디렉션 후 함수 종료
        },
            error: function (xhr, status, error){

        }
        });
        });



        </script>
    </body>
    </html>*/
