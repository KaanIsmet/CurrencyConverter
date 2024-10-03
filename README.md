# Currency Converter

## Overview
The Currency Converter is a Spring Boot application with a web-based interface that allows users to convert currency values from one currency to another. This application uses Thymeleaf for rendering dynamic HTML views and provides real-time conversion capabilities.The application also uses an api from https://app.exchangerate-api.com/

## Abstract
As currencies vary across countries, this application helps users convert amounts from one currency to another using up-to-date exchange rates. Built with Spring Boot and Thymeleaf, the application offers a user-friendly web interface that simplifies currency conversion tasks. Users can input the amount and select the currencies for conversion to get the converted value instantly.

## Features
- **Real-time Currency Conversion**: Convert any amount from one currency to another.
- **Dynamic Web Interface**: Utilizes Thymeleaf for a responsive and interactive user experience.
- **Live Exchange Rates**: Displays up-to-date exchange rates.
- **User-Friendly Interface**: Simple and intuitive design that resembles a calculator for ease of use.

## Technologies Used
- **Spring Boot**: Framework for building the application and managing dependencies.
- **Thymeleaf**: Java templating engine used to render dynamic HTML pages.
- **Java**: Programming language used for application development.
- **Maven**: Build automation tool used for managing project dependencies and building the application.

## Getting Started

### Prerequisites
- Java 11 or higher
- Apache Maven
- Apache Tomcat (optional, if deploying outside of embedded Tomcat)

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/KaanIsmet/CurrencyConverter.git
   cd CurrencyConverter
### Configurations

1. configure your api url and key either by a .gitignore or environmental variables (do not include the currency with the URL)
   ```bash
   api.url=<API_URL>
   api.key=<YOUR_API_KEY>
   ```

   


### Running

1. **Run the application**
* To run via Maven:
    ```bash
      mvn clean install
      mvn spring-boot:run
    ```
* To run the Jar file:
  ```bash
     java -jar target/CurrencyConverter-0.0.1-SNAPSHOT.jar
   ```
2. Access the Application
   ```bash
      https://localhost:8080
  
    
      
