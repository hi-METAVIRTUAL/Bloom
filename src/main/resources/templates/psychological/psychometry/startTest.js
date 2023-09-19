
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
