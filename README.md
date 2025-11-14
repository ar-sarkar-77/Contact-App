# 📇 Contact App

A simple Android **Contact App** application built with **Kotlin** and **SQLite Database**.  
This app allows users to **add**, **view**, **edit**, **delete**, and **search contacts**, as well as make calls, send messages, or use WhatsApp directly from the app. Phone numbers starting with `0` are handled automatically.

---

## 🚀 Features

✅ **Add Contact** – Record contact with name and phone number  
✅ **View Contacts** – Display all saved contacts in a ListView  
✅ **Edit Contact** – Update name or phone number; removes leading zero automatically  
✅ **Delete Contact** – Remove contacts from the database  
✅ **Search Contacts** – Filter contacts by name in real-time  
✅ **Call & Message** – Directly call or SMS a contact  
✅ **WhatsApp Integration** – Open WhatsApp chat with saved contacts  
✅ **Email Option** – Compose email from the app  
✅ **SQLite Database** – Store all contacts locally with proper data types  

---

## 🧱 Tech Stack

| Component       | Technology Used                   |
|-----------------|----------------------------------|
| Language        | Kotlin                            |
| Database        | SQLite (Local Storage)            |
| UI              | LinearLayout, ListView, CardView  |
| Architecture    | Simple Activity-based             |
| Android Version | API 24+ (Android 7.0 and above)   |

---

## 📲 Screens Included

1. **MainActivity** – Home screen showing all contacts in a ListView with search functionality.  
2. **MainActivity2** – Add a new contact (name + phone number). Validates input to prevent empty fields or numbers starting with `0`.  
3. **MainActivity3** – View contact details, call, message, WhatsApp, email, edit, or delete a contact.  
4. **MainActivity4** – Edit existing contact with automatic removal of leading zero in phone numbers.  
5. **DataBaseOpenHelper** – SQLite helper for managing contacts: add, update, delete, search, and fetch all contacts.  

---

## 🗃️ Database Design

**Table:** `contact`

| Field   | Type   | Description                            |
|---------|--------|----------------------------------------|
| id      | Int    | Auto-increment primary key              |
| name    | Text   | Contact name                            |
| number  | Text   | Contact phone number (leading 0 handled automatically) |

---
| Home Screen | Add Contact | Contact Details |
|:--:|:--:|:--:|
|<img width="1344" height="2992" alt="Screenshot_20251114_202656" src="https://github.com/user-attachments/assets/e7313383-f6bf-4cd3-87b0-d2897fe349d3" />| <img width="1344" height="2992" alt="Screenshot_20251114_202718" src="https://github.com/user-attachments/assets/09a1e8a2-d00e-40e8-8477-3025a22c7f71" />| <img width="1344" height="2992" alt="Screenshot_20251114_203830" src="https://github.com/user-attachments/assets/fcb8762f-c233-4b3e-a5f7-deea2c0d0fe4" />|

---

## 🔧 How to Clone and Run

1. Open your terminal or command prompt. 
2. Clone this repository:
   ```bash
   git clone https://github.com/ar-sarkar-77/Contact-App.git  
---
## 👨‍💻 Author
---

## 👤 Mohammad Anondo Sarkar  
💼 Android App Developer | UI UX Designer | 💻 Computer Science Student  
📧 Email: anondosarkarar77@gmail.com  
🌍 From: Lalmonirhat, Bangladesh  
🌐 Website: https://arsarkar77.blogspot.com  
💬 Built with ❤️, powered by Kotlin, and fueled by late-night coding ☕💡  
