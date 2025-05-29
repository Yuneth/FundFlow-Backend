# 🚀 FundFlow-Backend

**FundFlow – Microfinance Credit Scoring & Lending Portal**

---

## 🌟 Core Features

### 🔐 User Authentication
- Register and login functionality
- JWT-based authentication
- Two user roles: `customer` and `admin`
- Access control: only authenticated users can use the system

### 👤 Customer Management (Admin Only)
- Create new customers
- View all customers
- Edit or delete existing customers

### 💳 Loan Application API (Customer Side)
- Customers can submit multiple loan requests
- View all loan applications submitted by the logged-in user

### 📊 Credit Scoring Logic
- Score calculated out of 100
- Rules:
  - EMI must not exceed 40% of monthly income
  - Maximum of **2 active loans**
  - Lower loan amounts score better
  - Higher credit scores improve final score
- **Decision:**
  - Score ≥ 70 → ✅ **Approved**
  - Score < 70 → ❌ **Rejected**

### 🛠️ Admin Dashboard
- View all customers with filter options (Name, NIC, Email)
- View all loan applications with filters (Status, Score)
- Approve/Reject applications
- Export customer data to **Excel** or **PDF**
- Logout option

### 🧾 Customer Dashboard
- View personal loan applications with status
- Submit new loan applications
- Logout option

---

## ⚙️ Setup Instructions

### 🖥️ Backend
- Framework: **Spring Boot**
- Language: **Java 17**
- Database: **MySQL** (Database name: `fund_flow`)
- Authentication: **JWT**

### 💻 Frontend
- Library: **React.js**
- UI Framework: **Material UI**
- API Client: **Axios**

### 🧪 How to Run
1. Clone the repository and open it in **VS Code**
2. Open a terminal window
3. Install dependencies: npm install
4. Start the app: npm start
