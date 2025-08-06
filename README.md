# 🎓 Quizzy Kids – Preschool Quiz App

**Quizzy Kids** is a fun and educational Android quiz app designed for preschoolers. It features engaging multiple-choice questions across four subjects — General Knowledge, Mathematics, Islamiyat, and English — to help young learners develop their basic skills in a playful way.

---

## ✨ Features

- 🧠 20 MCQs per quiz across:
  - General Knowledge
  - Mathematics
  - Islamiyat
  - English
- ⏱️ 15-minute countdown timer per quiz
- 📊 Real-time question tracking (e.g., Question 4/20)
-  Online Questions Source
- Quiz data stored and managed via Firebase Console
- ⚫ Clean UI with black option boxes and white text
- 🔁 Progress line under question numbers that fills as you go
- ✅ Grey highlight for selected options
- 🚫 Toast warning if you try to proceed without selecting an answer
- ⏳ Auto-submit with "Time's Up" toast if timer hits zero
- 🧾 End screen showing:
  - Score percentage
  - Pass/Fail result

---

## 🔗 Firebase Integration

This app uses **Firebase Console** to manage and fetch quiz data online. This allows for:

- Centralized updates to quiz questions without releasing a new app version
- Lightweight local app with real-time data retrieval
- Easy expansion to support user data and analytics in the future

---

## 📂 App Structure

com.example.Quizzy Kids/
├── adapters/
│ └── QuizAdapter.kt
├── models/
│ └── QuizModel.kt
├── ui/
│ ├── MainActivity2.kt
│ └── StartActivity.kt
├── utils/
│ └── ScoreDialog.kt
└── res/layout/
├── activity_main2.xml
├── activity_start.xml
└── quiz_item.xml


---

## 🛠️ Tech Stack

- **Kotlin**
- **Firebase Console** (for storing quiz questions online)
- **RecyclerView**
- **Adapters**
- **Custom Dialogs**
- **Material Design UI (XML)**


---

## 🚀 How to Use

1. Launch the app and select a subject.
2. The quiz starts with a 15-minute timer.
3. Select your answers and press **Next**.
   - ⚠️ You’ll be prompted if no option is selected.
4. After the final question or if the time ends:
   - See your **score percentage**
   - Know whether you **passed or failed**

---
🙋‍♂️ About Me
Hi! I'm Muqeet Ahmad, an aspiring Android developer building educational apps to help young learners.
Connect with me on LinkedIn(https://www.linkedin.com/in/muqeet-ahmad-4432aa352/)



