# 🏫 DLSU-D Campus Kiosk 📟

> A smart kiosk interface for DLSU-D designed to provide accessible campus services using Java Swing.

---

## 📌 WHAT is Campus Kiosk?

**Campus Kiosk** is a Java desktop application built with `JOptionPane` and `JFrame` to simulate a self-service kiosk station located at DLSU-D's Gate 1 Rotunda. It provides students and staff access to:

- 📞 **General Services**: Simulated phone connections to various departments
- 🗺️ **Interactive School Map**: Navigate key locations and buildings inside campus
- 🚐 **Ikot La Salle Jeepney System**: Reserve or manage trips for the campus shuttle service

## 🛠️ HOW It Works

### 📂 Technologies Used
- 💻 Java (JDK 17+)
- 🖼️ Java Swing: `JOptionPane`, `JFrame`, `JButton`, `JComboBox`, `JLabel`
- 🗺️ Image handling via `ImageIcon`
- 🧠 Singleton Pattern for Ikot La Salle instance

### 🧩 Features Breakdown

#### 📞 General Services
> Simulates a direct connection to departments like Ayuntamiento, ICTC, Aklatang Emilio Aguinaldo, and SWAFO.

```java
String[] departments = { "1 - Ayuntamiento", "2 - ICTC", "3 - Aklatang Emilio Aguinaldo", "4 - SWAFO" };

## 🤔 WHY We Built It

With DLSU-D's growing student population, we envisioned a digital kiosk that simplifies:

- Connecting with departments  
- Navigating the campus for first-timers or visitors  
- Accessing eco-friendly transport like the Ikot La Salle Jeep  

It’s a **mockup for a real-world solution** that enhances campus service access — convenient, fast, and intuitive.
