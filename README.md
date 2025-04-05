SmartTransitPlanner is a multi-modal route planning system that evaluates bus, tram, and taxi options based on user location, preferences, and fare conditions. The system aims to provide optimal travel routes by considering time, cost, and passenger type (e.g., student, elderly). 

Unfortunately we did not create a GUI, it runs on console for now.

## 🔧 Features

- 🚍 Bus and 🚋 Tram route calculations
- 🚕 Taxi support with base fare and per-km pricing
- 🛑 Transfers between modes (e.g., tram to bus)
- 🕐 Fastest route / 💸 Cheapest route options
- 👥 Passenger type discounts (Student, Elderly, etc.)
- 📍 Calculates walking distance to nearest stop (Also tells you if you should walk or take a taxi etc.)
- 📈 Alternative route suggestions

## 📌 Input Parameters

- Start location (latitude, longitude)
- Destination (stop name or coordinates)
- Passenger type (General, Student, Elderly, etc.)
- Wallet info: Cash, Credit Card limit, KentKart(a payment system) balance

## 🗺️ Route Types

1. **Bus Only**
2. **Tram Only**
3. **Bus + Tram Combination**
4. **Taxi + Public Transport Hybrid**

