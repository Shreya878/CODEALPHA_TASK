let flashcards = [
  { question: "What is the capital of France?", answer: "Paris" },
  { question: "What is 2 + 2?", answer: "4" }
];

let currentIndex = 0;
let showingAnswer = false;
let editingIndex = null;

const cardText = document.getElementById("card-text");
const showAnswerBtn = document.getElementById("show-answer-btn");
const prevBtn = document.getElementById("prev-btn");
const nextBtn = document.getElementById("next-btn");

const addBtn = document.getElementById("add-btn");
const editBtn = document.getElementById("edit-btn");
const deleteBtn = document.getElementById("delete-btn");

const modal = document.getElementById("modal");
const modalTitle = document.getElementById("modal-title");
const questionInput = document.getElementById("question");
const answerInput = document.getElementById("answer");
const saveBtn = document.getElementById("save-btn");
const cancelBtn = document.getElementById("cancel-btn");

function renderCard() {
  const card = flashcards[currentIndex];
  cardText.textContent = showingAnswer ? card.answer : card.question;
  showAnswerBtn.textContent = showingAnswer ? "Show Question" : "Show Answer";
}

showAnswerBtn.onclick = () => {
  showingAnswer = !showingAnswer;
  renderCard();
};

prevBtn.onclick = () => {
  if (currentIndex > 0) {
    currentIndex--;
    showingAnswer = false;
    renderCard();
  }
};

nextBtn.onclick = () => {
  if (currentIndex < flashcards.length - 1) {
    currentIndex++;
    showingAnswer = false;
    renderCard();
  }
};

addBtn.onclick = () => {
  modal.classList.remove("hidden");
  modalTitle.textContent = "Add Flashcard";
  questionInput.value = "";
  answerInput.value = "";
  editingIndex = null;
};

editBtn.onclick = () => {
  const card = flashcards[currentIndex];
  modal.classList.remove("hidden");
  modalTitle.textContent = "Edit Flashcard";
  questionInput.value = card.question;
  answerInput.value = card.answer;
  editingIndex = currentIndex;
};

deleteBtn.onclick = () => {
  flashcards.splice(currentIndex, 1);
  if (currentIndex >= flashcards.length) currentIndex = flashcards.length - 1;
  showingAnswer = false;
  if (flashcards.length > 0) {
    renderCard();
  } else {
    cardText.textContent = "No cards available.";
    showAnswerBtn.style.display = "none";
  }
};

saveBtn.onclick = () => {
  const q = questionInput.value.trim();
  const a = answerInput.value.trim();
  if (q && a) {
    if (editingIndex !== null) {
      flashcards[editingIndex] = { question: q, answer: a };
    } else {
      flashcards.push({ question: q, answer: a });
      currentIndex = flashcards.length - 1;
    }
    modal.classList.add("hidden");
    showingAnswer = false;
    renderCard();
  }
};

cancelBtn.onclick = () => {
  modal.classList.add("hidden");
};

renderCard();
