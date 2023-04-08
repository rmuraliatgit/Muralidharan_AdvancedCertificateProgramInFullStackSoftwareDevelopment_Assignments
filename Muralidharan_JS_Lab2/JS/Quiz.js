const quizContainer = document.getElementById('quiz');
const questionElement = document.getElementById('question');
const choiceButtons = Array.from(document.querySelectorAll('.buttons button span'));
const progressText = document.getElementById('progress');
let currentQuestionIndex = 0;
let score = 0;

const questions = [
  {
    question: 'What does HTML stand for?',
    choices: ['Hyper Text Markup Language', 'Home Tool Markup Language', 'Hyperlinks and Text Markup Language', 'Hyperlink Transfer Markup Language'],
    correctAnswer: 0
  },
  {
    question: 'What does CSS stand for?',
    choices: ['Creative Style Sheets', 'Colorful Style Sheets', 'Cascading Style Sheets', 'Computer Style Sheets'],
    correctAnswer: 2
  },
  {
    question: 'Where is the correct place to insert a JavaScript?',
    choices: ['The <head> section', 'The <body> section', 'Both the <head> section and the <body> section', 'None of the above'],
    correctAnswer: 2
  }
];

function startQuiz() {
  showQuestion();
}

function showQuestion() {
  if (currentQuestionIndex === questions.length) {
    showResults();
    return;
  }

  const currentQuestion = questions[currentQuestionIndex];
  questionElement.textContent = currentQuestion.question;
  choiceButtons.forEach((choiceButton, index) => {
    choiceButton.textContent = currentQuestion.choices[index];
    choiceButton.parentElement.onclick = () => selectAnswer(index);
  });

  progressText.textContent = `Question ${currentQuestionIndex + 1} of ${questions.length}`;
}

function selectAnswer(answerIndex) {
  if (answerIndex === questions[currentQuestionIndex].correctAnswer) {
    score++;
  }
  currentQuestionIndex++;
  showQuestion();
}

function showResults() {
  quizContainer.innerHTML = `
    <h1>Quiz Results</h1>
    <hr style="margin-bottom: 20px">
    <p>Your score: ${score} out of ${questions.length} questions</p>
    <p>Your percentage: ${(score / questions.length * 100).toFixed(2)}%</p>
  `;
}

startQuiz();
