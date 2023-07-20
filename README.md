# Cryptanalyst

# Module 1 Final Project Task JavaRush University

**Module 1. Java Syntax**  
**Level 28, Lecture 1**

## Cryptology, Cryptography, and Cryptoanalysis

Let's move on to the theory analysis needed during your final project. Let's learn more about cryptology and its components. At the same time, let's learn more about the cipher that you will use while writing the final practical project.

### 1. Cryptology and Its Components

Cryptology is a field of knowledge that includes:

- **Cryptography (the science of ciphers)**: The subject of study of cryptography is the encryption of information to protect it from unauthorized access.
- **Cryptoanalysis (methods of disclosing these ciphers)**: Cryptoanalysis studies the methods of cipher disclosure and ways of their application.

### 2. Cryptographic Key

A key is a set of data with which encryption and decryption of information are performed.

Types of cryptographic keys:
- **Symmetric (secret)**.
- **Asymmetric**.

### 3. Alphabet in Cryptography

The alphabet is a finite set of symbols used to encode information symbols.

### 4. Approaches to Cryptoanalysis

Let's describe the simplest approaches to cryptoanalysis:

- **Brute force**: A brute-force search of keys, which is performed until a suitable one is found.
- **Cryptoanalysis based on statistical data**.

### 5. Caesar Cipher
This is one of the simplest and most well-known encryption methods. It was named, of course, after Emperor Gaius Julius Caesar, who used it for secret correspondence with his generals.

Caesar's cipher is a substitution cipher: in it, each character in the plaintext is replaced with a character that is a certain constant number of positions to the left or right of it in the alphabet.

For example, if we set the offset to 3, then A will be replaced by D, B will become E, and so on.

This is the minimum amount of theoretical data you will need to complete the final project. Let's move on to describing the task!

You can read the [CS50 lecture](https://javarush.com/quests/lectures/questharvardcs50.level02.lecture07).

## Final Project for the Java Syntax Module: Writing a Cryptoanalyzer
Task: Write a program that works with Caesar's cipher.

Take all the letters of the Ukrainian or English alphabet and punctuation marks (. , ”” : - ! ? SPACE) as the basis for the cryptographic alphabet. If there are characters that are not included in our cryptographic alphabet, just skip them.

### Mandatory Requirements
The program should have 2 modes:

**Encryption / decryption**: The program should encrypt and decrypt text using a given cryptographic key.

The program should receive a path to a text file with the source text and based on it, create a file with encrypted text.

**Brute force cryptoanalysis**

The program should break the encrypted text, passed in the form of a text file.

If the user chooses brute force, the program should independently, by brute force, select the key and decrypt the text.

Think about what criterion the program should take as a signal for successful key selection. Perhaps you should pay attention to the gaps between words or the correct use of punctuation marks.

### Optional Requirements
1. **Cryptoanalysis by statistical analysis**

The user of the program should be able to choose one of two methods of cryptoanalysis. If the user chooses the method of statistical analysis, they need to be offered to upload another additional file with text, preferably from the same author and the same stylistics. Based on the uploaded file, the program should compile statistics of character occurrence and after that try to use the statistics to cryptoanalyze the encrypted text.

2. **User Interface**

Design all dialog boxes with the user at your discretion. If desired, you can use graphic frameworks like Swing, JavaFX.

Upload the completed solution to a public Git repository.

The project is checked during its passage by a group.

---
### 🇺🇦 Ukrainian version:
---

# Завдання на підсумковий проєкт модуля 1 JavaRush University

**Модуль 1. Java Syntax**  
**Рівень 28, Лекція 1**

## Криптологія, криптографія та криптоаналіз

Перейдемо до аналізу теорії, яка знадобиться тобі під час написання підсумкового проєкту. Давай дізнаємося більше про криптологію та її складові. А заразом — більше про шифр, який ти будеш використовувати під час написання підсумкового практичного проєкту.

### 1. Криптологія та її складові

Криптологія — це область знань, до якої входить:

- **Криптографія (наука про шифри)**: Предмет вивчення криптографії — шифрування інформації для її захисту від несанкціонованого доступу. 
- **Криптоаналіз (методи розкриття цих шифрів)**: Криптоаналіз вивчає методи розкриття шифрів та способи їх застосування.

### 2. Криптографічний ключ

Ключ — це набір даних, за допомогою якого виконується шифрування та розшифрування інформації.

Різновиди криптографічних ключів:
- **Симетричні (секретні)**.
- **Асиметричні**.

### 3. Алфавіт у криптографії

Алфавіт — це скінченна множина символів, які використовують для кодування інформації символів.

### 4. Підходи до криптоаналізу

Опишемо найпростіші підходи до криптоаналізу:

- **Brute force (брутфорс, пошук грубою силою)**.
- **Криптоаналіз на основі статистичних даних**.

### 5. Шифр Цезаря
Це один з найпростіших і найвідоміших методів шифрування. Його назвали, звісно, на честь імператора Гая Юлія Цезаря, який використовував його для таємного листування зі своїми генералами.

Шифр Цезаря є шифром заміни: в ньому кожен символ відкритого тексту замінюється символом, що знаходиться на певному постійному числі позицій ліворуч або праворуч від нього в алфавіті.

Наприклад, якщо ми встановимо зсув у 3, то А буде замінено на Г, Б стане Д, і так далі.

Це мінімум теоретичних відомостей, які вам знадобляться для виконання підсумкового проєкту. Переходимо до опису завдання!

Ви можете прочитати [лекцію CS50](https://javarush.com/quests/lectures/questharvardcs50.level02.lecture07).

## Підсумковий проєкт до модуля Java Syntax: Пишемо криптоаналізатор
Завдання: написати програму, що працює з шифром Цезаря.

Як основу криптографічного алфавіту використовуйте всі літери українського або англійського алфавіту та знаки пунктуації (. , ”” : - ! ? ПРОБІЛ). Якщо зустрічаються символи, які не входять до нашого криптографічного алфавіту, просто пропустіть їх.

### Обов'язкові вимоги
Програма має мати 2 режими:

**Шифрування / розшифрування**: програма повинна шифрувати і розшифровувати текст, використовуючи заданий криптографічний ключ.

Програма повинна отримувати шлях до текстового файлу з вихідним текстом та на його основі створювати файл із зашифрованим текстом.

**Криптоаналіз методом brute force**

Програма повинна зламати зашифрований текст, переданий у вигляді текстового файлу.

Якщо користувач обирає brute force (брутфорс, пошук грубою силою), програма повинна самостійно, шляхом перебору, підібрати ключ і розшифрувати текст.

Замисліться над тим, який критерій програма повинна вважати сигналом успішного підбору ключа. Можливо, варто звернути увагу на прогалини між словами або коректність використання знаків пунктуації.

### Додаткові вимоги (опціонально)
1. **Криптоаналіз методом статистичного аналізу**

Користувач програми повинен мати можливість обрати один із двох методів криптоаналізу. Якщо користувач обирає метод статистичного аналізу, йому потрібно запропонувати завантажити ще один додатковий файл із текстом, бажано — того самого автора і тієї самої стилістики. На основі завантаженого файлу програма повинна скласти статистику входження символів і після цього спробувати використати статистику для криптоаналізу зашифрованого тексту.

2. **User Interface**

Всі діалогові вікна з користувачем робіть на власний розсуд. За бажанням можна використовувати графічні фреймворки Swing, JavaFX.

Готове рішення завантажуйте у публічний Git-репозиторій.

Проєкт перевіряється під час його проходження групою.
