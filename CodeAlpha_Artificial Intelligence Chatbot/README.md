🤖 Artificial Intelligence Chatbot – Java-Based Interactive Assistant
📌 Project Overview

The AI Chatbot is a Java-based desktop application designed for interactive communication using rule-based Natural Language Processing (NLP) techniques.
The system simulates conversational intelligence by processing user input, detecting intent through pattern matching, handling frequently asked questions (FAQs), maintaining contextual memory, and providing real-time responses through a graphical user interface.
This project demonstrates core concepts of NLP, OOP, file handling, and GUI development using Java Swing.

🎯 Features
    Rule-based NLP engine (pattern + keyword detection)
    FAQ training from external file (faq.txt)
    Dynamic response loading
   Context memory (remembers user name)
   Real-time chat GUI using Java Swing
   Enter key + Send button support
   Confidence scoring for responses
   Input normalization (lowercase, trimming, cleaning)
   Exception handling for stable execution

🏗 Project Structure
AI_Chatbot
├── ChatBotEngine.java     → Core NLP & logic engine
├── FAQLoader.java         → Loads FAQ data from file
├── ChatBotGUI.java        → Swing-based user interface
├── faq.txt                → Training data file
└── README.md              → Project documentation

🧠 NLP Techniques Implemented
The chatbot uses lightweight NLP techniques suitable for internship-level implementation:

Text normalization (lowercasing and trimming)
      Tokenization (splitting sentences into words)
           Pattern matching using regular expressions
                Keyword-based intent detection
                     Context tracking (user name memory)
                            Approximate string similarity (typo tolerance)

📂 FAQ Training Mechanism

The chatbot reads training data from:
faq.txt
Format: question=answer
Example:
what is java=Java is a high-level programming language.
what is ai=AI stands for Artificial Intelligence.
This allows dynamic expansion without modifying source code.

🖥 GUI Interface
The application uses Java Swing to provide: Chat display area,Scrollable conversation window,Input field,Send button,Real-time interaction.The interface is event-driven using ActionListeners.

How to Run
Compile all files:javac *.java
Run the chatbot:java ChatBotGUI

📊 Example Interaction
You: hello
Bot: Hello! How can I assist you today?

You: my name is Shilan
Bot: Nice to meet you, Shilan!

You: what is ai
Bot: AI stands for Artificial Intelligence. (Confidence: 100%)

🧩 Technologies Used
Java (Core Java),Object-Oriented Programming,Java Swing (GUI),File Handling (BufferedReader),HashMap (Data storage),Regular Expressions (Pattern matching)

👨‍💻 Author
Developed as part of internship-level academic project to demonstrate applied NLP and Java development skills.
