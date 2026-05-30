# 💱 Currency Converter

A console-based Java currency converter using BigDecimal for precise financial calculations, supporting 10 major currencies with robust input validation and a menu-driven interface.

---

## 📸 Sample Output
<img width="540" height="953" alt="carbon (6)" src="https://github.com/user-attachments/assets/00ac7c9a-ed2c-4650-a8ed-e5c7a4e64961" />
---

## ✨ Features

- 💰 **10 major currencies** — USD, EUR, GBP, INR, AED, PKR, JPY, AUD, CAD, KWD
- 🔢 **BigDecimal precision** — accurate financial calculations
- 🔄 **Continuous conversion** — convert multiple times without restarting
- ✅ **Input validation** — handles invalid numbers, negative amounts, unknown currencies
- 🚫 **Same currency check** — prevents converting to the same currency
- 🧩 **Modular design** — clean separation of methods

---

## 💱 Supported Currencies

| Code | Currency |
|------|----------|
| USD | US Dollar |
| EUR | Euro |
| GBP | British Pound |
| INR | Indian Rupee |
| AED | UAE Dirham |
| PKR | Pakistani Rupee |
| JPY | Japanese Yen |
| AUD | Australian Dollar |
| CAD | Canadian Dollar |
| KWD | Kuwaiti Dinar |

---

## 🛠️ Tech & Concepts Used

| Concept | Applied |
|--------|---------|
| Java Fundamentals | Variables, loops, conditionals |
| BigDecimal | High precision financial math |
| MathContext | DECIMAL128 precision standard |
| Switch Statement | Currency code to rate mapping |
| Exception Handling | Try-catch for invalid inputs |
| Input Validation | Negative, unknown, same currency checks |
| Modular Methods | showMenu, showResult, convert, getRate |

---

## 🚀 How to Run

### ✅ Step 1 — Install Java (One Time Only)
1. Go to 👉 https://www.java.com/en/download/
2. Click **Download Java**
3. Install it like any normal program (Next → Next → Finish)
4. **Restart your computer** after installing

---

### ✅ Step 2 — Download the Project
Open **Command Prompt** (search CMD in Windows search bar) and paste this:
```bash
git clone https://github.com/mahnoor-shahbaz-se/currency-converter-java.git
```

---

### ✅ Step 3 — Go Into the Project Folder
```bash
cd currency-converter-java
```

---

### ✅ Step 4 — Compile the Program
```bash
javac CurrencyConverter.java
```
> You'll see no output if it works — that's normal! ✅

---

### ✅ Step 5 — Run the Program
```bash
java CurrencyConverter
```
> Enter amount, source currency and target currency when prompted!

---

## 🔮 Future Improvements

- [ ] Live exchange rate API integration
- [ ] GUI version using Java Swing or JavaFX
- [ ] Support for more currencies
- [ ] Conversion history tracking
- [ ] Web version of the application

---

## 👩‍💻 Author

**Mahnoor Shahbaz**
🔗 [LinkedIn](https://www.linkedin.com/in/mahnoor-shahbaz-se/) &nbsp;|&nbsp; 📧 [mahnoorshahbaz86@gmail.com](mailto:mahnoorshahbaz86@gmail.com)
