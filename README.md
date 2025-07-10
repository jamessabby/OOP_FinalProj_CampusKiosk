## What is Campus Kiosk?

**Campus Kiosk** is a Java desktop application built with `JOptionPane` and `JFrame` to simulate a self-service kiosk station located at DLSU-D's Gate 1 Rotunda. It provides students and staff access to:

- **General Services** — Simulated phone connections to various departments  
- **Interactive School Map** — Navigate key locations and buildings inside campus  
- **Ikot La Salle Jeepney System** — Reserve or manage trips for the campus shuttle service  

---

## Why We Built It

As the student population of DLSU-D continues to grow, there's a need for faster, smarter, and more accessible campus services. Our goal was to create a digital kiosk experience that improves how students:

- Connect with key departments  
- Find their way around campus (especially for first-timers and visitors)  
- Access eco-friendly transportation like the Ikot La Salle jeep system  

This project is a **mockup for a real-world solution** — one that promotes convenience, responsiveness, and user-friendliness at the heart of campus operations.

---

## How It Works

### Technologies Used

- **Java** (JDK 17+)
- **Java Swing**: `JOptionPane`, `JFrame`, `JButton`, `JComboBox`, `JLabel`
- **Image Handling**: `ImageIcon` for loading campus maps and UI assets
- **Design Pattern**: Singleton for the `IkotLaSalle` instance to manage shared ride state
