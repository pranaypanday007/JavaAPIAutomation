# Java API Automation Framework

A robust and scalable Java-based automation framework designed for comprehensive RESTful API testing. This project leverages RestAssured and TestNG to facilitate efficient API validations, ensuring reliability and maintainability in automated testing processes.

## 🚀 Features

- **Comprehensive HTTP Method Support**: Automate RESTful API calls including GET, POST, PUT, DELETE.
- **Data-Driven Testing**: Parameterize test cases with diverse payloads for extensive coverage.
- **Schema Validation**: Validate JSON/XML responses against predefined schemas.
- **Custom Assertions**: Implement flexible assertions using JSONPath for precise validations.
- **Reporting**: Generate detailed API test reports to monitor test execution and outcomes.

## 🛠️ Technologies Used

- **Java**: Core programming language for the framework.
- **RestAssured**: Simplifies the testing of REST services in Java.
- **TestNG**: Testing framework for executing test cases and generating reports.
- **JSONPath**: Facilitates querying and asserting JSON responses.
- **Maven**: Manages project dependencies and build lifecycle.

## 📁 Project Structure

JavaAPIAutomation/
├── src/
│ ├── main/
│ │ └── java/
│ │ └── [package_name]/ # Core framework classes
│ └── test/
│ └── java/
│ └── [package_name]/ # Test cases
├── testng.xml # TestNG suite configuration
├── pom.xml # Maven project file
└── README.md # Project documentation

bash

## 🔧 Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/pranaypanday007/JavaAPIAutomation.git
   cd JavaAPIAutomation
Import Project:
Open your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
Import the project as a Maven project.
Install Dependencies:
Maven will automatically resolve and download necessary dependencies specified in pom.xml.
Configure TestNG:
Review and modify testng.xml to specify test suites and parameters as needed.
Run Tests:
Execute tests via your IDE or using Maven:
bash mvn test

📊 Reporting
TestNG generates default HTML reports located in the test-output directory after test execution.

For enhanced reporting, integrate ExtentReports or Allure as needed.

🤝 Contributing
Contributions are welcome! To contribute:

Fork the repository.
Create a new branch:
bash: git checkout -b feature/YourFeature

Commit your changes:
bash: git commit -m "Add YourFeature"

Push to the branch:
bash: git push origin feature/YourFeature
Open a pull request detailing your changes.

📄 License
This project is licensed under the MIT License.

Developed and maintained by Pranay Panday.
---
